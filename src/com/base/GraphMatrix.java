package com.base;

import java.util.Scanner;

public class GraphMatrix {

	public static final int MaxNum = 20;
	public static final int MaxValue = 65535;
	
	char[] vertex = new char[MaxNum];//保存顶点信息
	int GType;//0无向图1有向图
	int VertexNum;//顶点的数量
	int EdgeNum;//边的数量
	int[][] edgeWeight = new int[MaxNum][MaxNum];//边的权值
	int[] isTrav = new int[MaxNum];//遍历标志
	
	/**
	 * 初始化
	 */
	public void init() {
		int i,j;
		int weight;
		char start, end;
		VertexNum = 10;
		System.out.println("输入顶点数量:");
		Scanner sc = new Scanner(System.in);
		for (int l = 0; l < VertexNum; l++) {
			vertex[l] = sc.next().toCharArray()[0];
		}
		System.out.println("输入构成各边的顶点及权值:");
		EdgeNum = 18;
		for (int l = 0; l < EdgeNum; l++) {
			start = sc.next().charAt(0);
			end = sc.next().charAt(0);
			weight = sc.nextInt();
			for (i = 0; start != vertex[i]; i++) {
				for(j = 0; end != vertex[j]; j++) {
					edgeWeight[i][j] = weight;
					if (GType == 0) {
						edgeWeight[j][i] = weight;
					}
				}
					
			}
			
		}
	}

	/**
	 * 清空
	 */
	public void clear() {
		for (int i = 0; i < VertexNum; i++) {
			for (int j = 0; j < VertexNum; j++) {
				edgeWeight[i][j] = MaxValue;
			}
		}
	}
	
	/**
	 * 输出图
	 * 
	 */
	public void outGraph() {
		int i,j;
		for (i = 0 ; i < EdgeNum; i++) {
			System.out.print("\t" + vertex[i]);
		}
		System.out.println("\n");
		for (i = 0; i < EdgeNum; i++) {
			System.out.print(vertex[i]);
			for (j = 0; j < EdgeNum; j++) {
				if (edgeWeight[i][j] == MaxValue) {
					System.out.print("\tZ");
				} else {
					System.out.print("\t" + edgeWeight[i][j]);
				}
			}
		}
	}
	
	public char[] getVertex() {
		return vertex;
	}

	public void setVertex(char[] vertex) {
		this.vertex = vertex;
	}

	public int getGType() {
		return GType;
	}

	public void setGType(int gType) {
		GType = gType;
	}

	public int getVertexNum() {
		return VertexNum;
	}

	public void setVertexNum(int vertexNum) {
		VertexNum = vertexNum;
	}

	public int getEdgeNum() {
		return EdgeNum;
	}

	public void setEdgeNum(int edgeNum) {
		EdgeNum = edgeNum;
	}

	public int[][] getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(int[][] edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

	public int[] getIsTrav() {
		return isTrav;
	}

	public void setIsTrav(int[] isTrav) {
		this.isTrav = isTrav;
	}

	public static int getMaxnum() {
		return MaxNum;
	}

	public static int getMaxvalue() {
		return MaxValue;
	}
	
	
}