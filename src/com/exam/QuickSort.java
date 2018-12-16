package com.exam;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] a =  {8, 12, 32, 9, 53, 26, 11, -4, 93, 55, 63};
		QuickSort sort = new QuickSort();
		sort.sort2(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static int partition(int []array,int lo,int hi){
        //三数取中
        int mid=lo+(hi-lo)/2;
        if(array[mid]>array[hi]){
            swap(array[mid],array[hi]);
        }
        if(array[lo]>array[hi]){
            swap(array[lo],array[hi]);
        }
        if(array[mid]>array[lo]){
            swap(array[mid],array[lo]);
        }
        int key=array[lo];
        
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
    public static void sort2(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort2(array,lo,index-1);
        sort2(array,index+1,hi);
    }
	
	public void sort(int[] a, int low, int high) {
		if (low > high) return;
		int i = low;
		int j = high;
		int key = a[low];
		while (i < j) {
			while (i < j && a[j] > key)
				j--;
			while (i < j && a[i] <= key)
				i++;
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int p = a[i];
		a[i] = a[low];
		a[low] = p;
		sort(a, low, i - 1);
		sort(a, i + 1, high);
	}
}
