package com.suanfa.part07;

import java.util.Scanner;

public class GraphMatrix {

	static final int MaxNum = 5;
	char[] Vertex = new char[MaxNum];
	int GType;
	int VertexNum;
	int EdgeNum;
	int[][] EdgeWeight = new int[MaxNum][MaxNum];
	int[] isTrav = new int[MaxNum];
	static Scanner input = new Scanner(System.in);
	
	static void createGraph(GraphMatrix GM) {
		int i,j,k;
		int weight;
		char EstartV,EendV;
		
		for (i = 0; i < GM.VertexNum; i++) {
			System.out.println("第" + i + "个顶点信息:");
			GM.Vertex[i] = input.next().toCharArray()[0];
		}
		System.out.println("输入构成各边的顶点及权值:\n");
		for (k = 0; k < GM.EdgeNum; k++) {
			System.out.println("第" + (k + 1) + "条边");
			EstartV = input.next().charAt(0);
			EendV = input.next().charAt(0);
			weight = input.nextInt();
			for (i = 0; EstartV != GM.Vertex[i]; i++);
			for (j = 0; EendV != GM.Vertex[j]; j++);
			GM.EdgeWeight[i][j] = weight;
			if (GM.GType == 0) {
				GM.EdgeWeight[j][i] = weight;
			}
		}
	}
	
	static void clearGraph(GraphMatrix GM) {
		int i,j;
		for (i = 0; i < GM.VertexNum; i++) {
			for (j = 0; j < GM.VertexNum; j++) {
				GM.EdgeWeight[i][j] = P8.MaxValue;
			}
		}
	}
	
	static void outGraph(GraphMatrix GM) {
		int i,j;
		for (i = 0; i < GM.VertexNum; i++) {
			System.out.print("顶点:" + GM.Vertex[i]);
		}
		System.out.println();
		for (i = 0; i < GM.VertexNum; i++) {
			for (j = 0; j < GM.VertexNum; j++) {
				if (GM.EdgeWeight[i][j] == P8.MaxValue) {
					System.out.print("\tZ");
				} else {
					System.out.println("边的值:" + GM.EdgeWeight[i][j]);
				}
			}
		}
	}
	
	static void printGraph(GraphMatrix GM) {
		int i,j,k,min,sum;
		int[] weight = new int[GM.MaxNum];
		char[] vtempx = new char[GM.MaxNum];
		sum = 0;
		for (i = 1; i < GM.VertexNum; i++) {
			weight[i] = GM.EdgeWeight[0][i];
			if (weight[i] == GM.MaxNum) {
				vtempx[i] = (char)P8.NoL;
			} else {
				vtempx[i] = GM.Vertex[0];
			}
		}
		vtempx[0] = P8.USED;
		weight[0] = GM.MaxNum;
		for (i = 1; i < GM.VertexNum; i++) {
			min = weight[0];
			k = i;
			for (j = 1; j < GM.VertexNum; j++) {
				if (weight[j] < min && vtempx[j] > 0) {
					min = weight[j];
					k = j;
				}
			}
			sum += min;
			System.out.printf("(%c,%c),", vtempx[k], GM.Vertex[k]);
			vtempx[k] = P8.USED;
			weight[k] = GM.MaxNum;
			for (j = 0; j < GM.VertexNum; j++) {
				if (GM.EdgeWeight[k][j] < weight[j] && vtempx[j] != 0) {
					weight[j] = GM.EdgeWeight[k][j];
					vtempx[j] = GM.Vertex[k];
				}
			}
		}
		System.out.println("生成最小树的总权值：" + sum);
	}
	
	public static void main(String[] args) {
		GraphMatrix GM = new GraphMatrix();
		char again;
		String go;
		System.out.println("最小生成树");
		do {
			System.out.println("输入生成树的类型：");
			GM.GType = input.nextInt();
			System.out.println("输入图的顶点数量:");
			GM.VertexNum = input.nextInt();
			System.out.println("输入图的边数量");
			GM.EdgeNum = input.nextInt();
			clearGraph(GM);
			createGraph(GM);
			System.out.println("最小生成树的边");
			printGraph(GM);
			System.out.println("继续玩吗(y/n)");
			go = input.next();
		} while (go.equalsIgnoreCase("y"));
		System.out.println("游戏结束");
	}
}
