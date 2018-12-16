package com.test.part02;

import java.util.Scanner;

public class Huffuman {

	private static Node[] node;
	private static Code[] code;
	private static final int MAX_VALUE = 10000;
	
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
		
		public Code(int[] b, int start) {
			this.bit = bit;
			this.start = start;
		}
	}
	
	private static void init(int n) {
		node = new Node[2 * n - 1];
		Node d = null;
		for (int i = 0; i < 2 * n - 1; i++) {
			d = new Node(0, -1, -1, -1);
			node[i] = d;
		}
		
		System.out.println("输入叶子值及权值");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			String[] args = sc.nextLine().split(",");
			node[i].weight = Integer.valueOf(args[1]);
			node[i].value = args[0].charAt(0);
		}
		
		int i, j, x1, x2;
		double m1, m2;
		for (i = 0; i < n - 1; i++) {
			m1 = m2 = MAX_VALUE;
			x1 = x2 = -1;
			for (j = 0; j < n + i; j++) {
				if (node[j].weight < m1 && node[j].parent == -1) {
					m2 = m1;
					x2 = x1;
					m1 = node[j].weight;
					x1 = j;
				} else if (node[j].weight < m2 && node[j].parent == -1) {
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
	
	public static void code(int n) {
		
		int[] b = new int[n];
		code = new Code[n];
		for (int m = 0; m < n; m++) {
			code[m] = new Code(b, n - 1);
		}
		Code cd = new Code(b, n - 1);
		int i, j, c, p;
		for (i = 0; i < n; i++) {
			
			cd.start = n - 1;
			c = i;
			p = node[c].parent;
			while (p != -1) {
				if (node[p].left == c)
					cd.bit[cd.start] = 0;
				else
					cd.bit[cd.start] = 1;
				cd.start--;
				c = p;
				p = node[p].parent;
			}
			for ( j = cd.start + 1; j < n; j++)
				code[i].bit[j] = cd.bit[j];
			code[i].start = cd.start;
		}
	}
	
	public static void main(String[] args) {
		int i, j, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("输入数量:");
		int t = sc.nextInt();
		init(t);
		code(t);
		for (i = 0; i < t; i++) {
			System.out.print("value:" + node[i].value + ";code is:");
			for (j = code[i].start + 1; j < t; j++)
				System.out.print(code[i].bit[j]);
			System.out.println();
		}
	}
}
