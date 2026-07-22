package com.cap.code;
import java.util.Comparator;
import java.util.List;

public class Test {
	    public static void main(String[] args) {
	        List<String> names=List.of("Devansh","Dev","Tanu","Sundaram","Khushi");


	        List<String> result=names.stream().filter(a->a.length()>3).sorted(Comparator.naturalOrder()).toList();
	        System.out.println(result);
	    }
	}
