package com.quxue.part01;

public class Test {

	
	private static class Node {
		int s[];
		int l;//长度
		int c;//幂次
	}
	
	public void cp(Node src, Node des, int st, int l) {
		int i, j;
		for (i = st, j = 0; i < st + l; i++, j++) {
			des.s[j] = src.s[i];
		}
		des.l = l;
		des.c = src.c;
	}
	
	public void add(Node pa, Node pb, Node ans) {
		int i, cc, k, alen, blen, len;
		int ta, tb;
		Node temp;
		if (pa.c < pb.c) {
			temp = pa;
			pa = pb;
			pb = temp;
		}
		ans.c = pb.c;
		cc = 0;
		k = pa.c - pb.c;
		alen = pa.l + pa.c;
		blen = pb.l + pb.c;
		if (alen > blen)
			len = alen;
		else
			len = blen;
		len = len - pb.c;
		for (i = 0; i < len; i++) {
			if (i < k)
				ta = 0;
			else
				ta = pa.s[i - k];
			if (i < pb.l)
				tb = pb.s[i];
			else
				tb = 0;
			if (i > pa.l + k) {
				ta = 0;
			}
			ans.s[i] = (ta + tb + cc) % 10;
			cc = (ta + tb + cc) / 10;
		}
		if (cc > 0) {
			ans.s[i++] = cc;
			ans.l = i;
		}
	}
}
