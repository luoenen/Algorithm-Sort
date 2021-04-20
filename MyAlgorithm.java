package edu.luoshenshen.javasort;

/*
 * Project: MyAlgorithm
 * Author : luoshenshen
 * Time   : 2021/01/26
 */
public class MyAlgorithm {

	/*
	 * 选择排序
	 */
	public void MySelectionSort(int array[]) {
		
		int min;
		
		for (int i = 0; i < array.length-1; i++) {
			
			min = i;
			
			for (int j = i+1; j < array.length; j++) {
				
				if (array[min]>array[j]) {
					min = j;
				}
			}
			if (min != i) {
				array[min] += array[i];
				array[i] = array[min] - array[i];
				array[min] = array[min] - array[i];
			}
		}
	}
	
	/*
	 * 冒泡排序
	 */
	public void MyBuddleSort(int array[]) {
		
		for (int i = 0; i < array.length-1; i++) {
			
			for (int j = i+1; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[j] += array[i];
					array[i] = array[j] - array[i];
					array[j] = array[j] - array[i];
				}
			}
		}
	}
	
	/*
	 * 插入排序
	 */
	public void MyInsertSort(int array[]) {
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = i; j > 0; j--) {
				if (array[j-1] > array[j]) {
					array[j] += array[j-1];
					array[j-1] = array[j] - array[j-1];
					array[j] = array[j] - array[j-1];
				}
			}
		}
	}
	
	/*
	 * 希尔排序
	 */
	public void MyShellSort(int array[]) {
		
		int cup = 1;
		
		while (cup<array.length/3) {
			
			cup = cup * 3 +1;
			
		}
		for (int gap = cup; gap > 0; gap=(gap-1)/3) {
			
			for (int i = gap; i < array.length; i++) {
				
				for (int j = i; j > gap-1; j-=gap) {
					
					if (array[j-gap] > array[j]) {
						array[j] += array[j-gap];
						array[j-gap] = array[j] - array[j-gap];
						array[j] = array[j] - array[j-gap];
					}
				}
			}
		}
	}
	
	/*
	 * 归并过程
	 */
	public void MyMerge(int array[],int left,int right,int RB) {
		
		int temp[]= new int[RB-left+1];
		int k = 0;
		int i = left;
		int j = right;
		int flag = right-1;
		
		while (i<=flag&&j<=RB) {
			
			temp[k++] = array[i] < array[j] ? array[i++] : array[j++];  
		}
		
		while (i<=flag) {
			
			temp[k++] = array[i++];
		}
		
		while (j<=RB) {
			
			temp[k++] = array[j++];
		}
		
		for (int l = 0; l < temp.length; l++) {
			
			array[left + l] = temp[l];
		}
		
	}
	
	/*
	 * 归并排序
	 */
	public void MyMergeSort(int array[],int left,int right) {
		
		if (left == right) {
			
			return;
		}
		int flag = left + (right - left)/2;
		
		MyMergeSort(array, left, flag);
		MyMergeSort(array, flag+1, right);
		MyMerge(array, left, flag+1, right);
	}
	
	/*
	 * 快速过程
	 */
	public int MyQuick(int array[],int left,int right) {
		
		int flag = array[right];
		int start = left;
		int end = right-1;
		
		while (start<=end) {
			
			while (start<=end && array[start] <= flag) {
				start++;
			}
			
			while (start<=end && array[end] > flag) {
				end--;
			}
			
			if (start < end) {
				array[end] += array[start];
				array[start] = array[end] - array[start];
				array[end] = array[end] - array[start];
			}
		}
		
		int temp = array[right];
		array[right] = array[start];
		array[start] = temp;
		return start;
		
	}
	
	/*
	 * 快速排序
	 */
	public void MyQuickSort(int array[],int left,int right) {
		
		if (left>=right) {
			return;
		}
		
		int flag = MyQuick(array, left, right);
		MyQuickSort(array, left, flag-1);
		MyQuickSort(array, left+1, right);
	}
	
	/*
	 * 计数排序
	 */
	public void MyCountSort(int array[]) {
	
		int temp[] = new int[array.length];
		int count[] = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		
		for (int i = 0,j = 0; i < array.length; i++) {
			
			while (count[i]-- > 0) {
				temp[j++] = i;
			}
		}
		for (int i = 0; i < temp.length; i++) {
			
			array[i] = temp[i]; 
		}
	}
}
