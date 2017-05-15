package com.fdmgroup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import com.fdmgroup.util.StopWatch;

public class CompareCollections {

	public static final int SAMPLE_SIZE = 500000;
	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		
		int[] samples = new int[SAMPLE_SIZE];
		Random random = new Random();
		
		for (int i=0; i<SAMPLE_SIZE; i++){
			samples[i] = random.nextInt(10000);
		}
		
		List<Integer> intList = new ArrayList<>();
		Queue<Integer> intQueue = new ArrayDeque<>();
		Set<Integer> intSet = new HashSet<>();

		System.out.println("Estimated time for adding "+ SAMPLE_SIZE + " for List");
		sw.start();
		for (int i : samples) {
			intList.add(i);
		}
		sw.stop();
		System.out.println(sw.getElapsedTime());
		System.out.println("--------------------------");
		
		System.out.println("Estimated time for adding "+ SAMPLE_SIZE + " for Queue");
		sw.start();
		for (int i : samples) {
			intQueue.add(i);
		}
		sw.stop();
		System.out.println(sw.getElapsedTime());
		System.out.println("--------------------------");
		
		System.out.println("Estimated time for adding "+ SAMPLE_SIZE + " for set");
		sw.start();
		for (int i : samples) {
			intSet.add(i);
		}
		sw.stop();
		System.out.println(sw.getElapsedTime());
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		
		
		
		System.out.println("Estimated time for finding "+ SAMPLE_SIZE + " for List");
		sw.start();
		for (int i : samples) {
			intList.contains(i);
		}
		sw.stop();
		System.out.println(sw.getElapsedTime());
		System.out.println("--------------------------");
		
		System.out.println("Estimated time for finding "+ SAMPLE_SIZE + " for Queue");
		sw.start();
		for (int i : samples) {
			intQueue.contains(i);
		}
		sw.stop();
		System.out.println(sw.getElapsedTime());
		System.out.println("--------------------------");
		
		System.out.println("Estimated time for finding "+ SAMPLE_SIZE + " for set");
		sw.start();
		for (int i : samples) {
			intSet.contains(i);
		}
		sw.stop();
		System.out.println(sw.getElapsedTime());
		System.out.println("--------------------------");
	}
}
