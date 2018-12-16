package com.part02;

import java.util.Arrays;
import java.util.Scanner;

public class HuffmanTree {

	private static final int MAX_VALUE = 10000;
	private static final int MAX_LEAF = 10;
	private static int maxNode = MAX_LEAF * 2 - 1;
	private static Node[] node = new Node[maxNode];
	private static Code[] code = new Code[MAX_LEAF];
	
	private static class Node {
		double weight;
		int parent;
		int left;
		int right;
		char value;
		
		public Node(double weight, int parent, int left, int right) {
			this.weight = weight;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
	
	private static class Code {
		int[] bit;
		int start;
		
		public Code(int[] bit, int start) {
			this.bit = bit;
			this.start = start;
		}
	}
	
	public static void huffmanTree(int n) {
		int i, j, x1, x2;
		double m1, m2;
		Scanner sc = new Scanner(System.in);
		for (i = 0; i < 2 * n - 1; i++) {
			Node m = new Node(0, -1, -1, -1);
			node[i] = m;
		}
		for (i = 0; i < n; i++) {
			System.out.println("输入节点的值及权值：");
			String s = sc.nextLine();
			String[] args = s.split(",");
			node[i].value = args[0].charAt(0);
			node[i].weight = Integer.valueOf(args[1]);
		}
		for (i = 0; i < n - 1; i++) {
			m1 = m2 = MAX_VALUE;
			x1 = x2 = -1;
			for (j = 0; j < n + i; j++) {
				if (node[j].weight < m1 && node[j].parent == -1) {
					m2 = m1;
					x2 = x1;
					m1 = node[j].weight;
					x1 = j;
				} else if (node[j].weight < m2 && node[j].parent == -1){
					m2 = node[j].weight;
					x2 = j;
				}
			}
			node[x1].parent = n + i;
			node[x2].parent = n + i;
			node[n + i].weight = m1 + m2;
			node[n + i].left = x1;
			node[n + i].right = x2;
			
		}
	}
	
	public static void huffmanCode(int n) {
		Code cd = null;
		int i, j, c, p;
		
		for (i = 0; i < n; i++) {
			cd = new Code(new int[n], n - 1);
			cd.start = n - 1;
			c = i;
			p = node[c].parent;
			while (p != -1) {
				if (node[p].left == c) {
					cd.bit[cd.start] = 0;
				} else {
					cd.bit[cd.start] = 1;
				}
				cd.start--;
				c = p;
				p = node[c].parent;
			}
			for (j = cd.start + 1; j < n; j++) {
				code[i].bit[j] = cd.bit[j];
			}
			code[i].start = cd.start;
			System.out.println( i + ":" + Arrays.toString(code[i].bit));
		}
	}
	
	public static void main(String[] args) {
		
		int i, j, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		n = sc.nextInt();
		while (n < 6) {
			System.out.println("数字不能小于6");
			n = sc.nextInt();
		}
		huffmanTree(n);
		int[] byt = new int[n];
		for ( j = 0; j < n; j++) {
			Code m = new Code(byt, n - 1);
			code[j] = m;
		}
		huffmanCode(n);
		System.out.println("------------------");
		for (i = 0; i < n; i++) {
			System.out.println();
			System.out.print(node[i].value + ";code is :");
			for (j = code[i].start + 1; j < n; j++)
				System.out.print(code[i].bit[j]);
		}
	}
}
