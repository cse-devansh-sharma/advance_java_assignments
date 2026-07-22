package com.cap.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Practice {
	
	public static void add() {
		List<Integer> li=Arrays.asList(5,4,3,22,4,5,6,7);
		
		Integer ans=li.stream().mapToInt(Integer::intValue).sum();
		System.out.println(ans);
	}
	
	public static void even() {
		List<Integer> li=List.of(22,3,4,5,6,7,8,9,6,4,5,65,4,43,5,67,65);
		
		List<Integer> ans=li.stream().filter(a->a%2==0).toList();
		System.out.println(ans);
	}
	
	public static void upperCase() {
		List<String> names=List.of("devansh","tanu","manu","nikhil","dev","cat","dog");
		
		List<String> ans=names.stream().map(a->a.toUpperCase()).toList();
		System.out.println(ans);
	}
	
	public static void count() {
		List<String> names=List.of("devansh","tanu","manu","nikhil","dev","cat","dog");
		Long ans=names.stream().map(a->a.toUpperCase()).filter(a->a.length()>3).count();
		System.out.println(ans);
	}
	
	public static void match() {
		List<Integer> li=List.of(-4,5,-5,0,5,3,-6,-8,8);
		
		boolean one=li.stream().anyMatch(a->a>0);
		boolean all=li.stream().allMatch(a->a>0);
		
		System.out.println(one+" "+all);
	}
	
	public static void  secondLargest() {
		
		List<Integer> li=List.of(22,3,4,5,6,7,8,9,6,4,5,65,4,43,5,67,65);
		
		long ans=li.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
		
		System.out.println(ans);
	}
	
	public static void fibonacci() {
		
		Stream.iterate(new long[] {0,1}, f->new long[] {f[1],f[0]+f[1]}).limit(10).map(a->a[0]).forEach(System.out::println);
		
	}
	
	public static int  binarySearch(long arr[],int target) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==target) {
				return mid;
			}else if(arr[mid]>target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return -1;
	}
	
	
	
	
	
	
}
