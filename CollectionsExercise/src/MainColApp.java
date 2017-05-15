import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MainColApp {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("John");
		set.add("Mike");
		set.add("John");
		set.add("Jane");
		
		for (String string : set) {
			System.out.println(string);
		}
		
		System.out.println("----------------------------");
		
		Map<String, Color> map = new HashMap<>();
		map.put("Green", new Color("Green"));
		map.put("Blue", new Color("Blue"));
		map.put("Red", new Color("Red"));
		map.put("Yellow", new Color("Yellow"));
		map.put("White", new Color("White"));
		map.put("Black", new Color("Black"));
		
		System.out.println(map.get("Yellow"));
		System.out.println(map.get("Blue"));
		
		System.out.println("----------------------------");

		System.out.println(countOccurences("HELLO THERE"));
		
		System.out.println("----------------------------");
		
		String sentence = "Solve the exercise. Make sure you use TDD for the coding exercise";
		System.out.println("Number of duplicates: "+numOfDuplicates(sentence));
		
		System.out.println("----------------------------");
		
		LinkedList<String> ll = new LinkedList<>();
		ll.add("1st");
		ll.add("2nd");
		ll.add("3rd");
		ll.add("4th");
		for (String string : reverseLinkedList(ll)) {
			System.out.println(string);
		}
		
		System.out.println("----------------------------");

		String sentence2 = "Solve the exercise. Make sure you use TDD for the coding exercise";
		for (String string : tokenize(sentence2)) {
			System.out.print(string+",");
		}
		
		System.out.println("----------------------------");

		for (double d : orderPriority(2.4, 45.7, 23.54, 1.0)) {
			System.out.print(d+",");
		}
	}
	
	public static String countOccurences(String str){
		char[] data = str.replace(" ", "").toCharArray();
		Arrays.sort(data);
		char start = data[0];
		int sum = 0;
		String result = "";
		for (int i = 0; i<data.length; i++) {
			if (data[i]!=start || i == data.length-1){ 
				result+=(start+":"+sum);
				start = data[i];
				sum = 1;
			}
			else 
				sum++;			
		}
		
		return result;
	}
	
	public static int numOfDuplicates(String str){
		str = str.replace(",", "").replace(".", "");
		String[] data = str.split(" ");
		Arrays.sort(data);
		String start = null;
		int sum = 0;
		for (int i = 0; i<data.length; i++) {
			if (data[i].equalsIgnoreCase(start)){ 		
				sum += 1;
				System.out.println(data[i]);
			}
			else{
				start = data[i];
			}
		}
		return sum;
	}
	
	public static LinkedList<String> reverseLinkedList(LinkedList ll){
		LinkedList<String> list = new LinkedList<>();
		while (! ll.isEmpty()) {
			list.add((String) ll.removeLast());
		}
		return list;
	}
	
	public static TreeSet<String> tokenize(String str){
		TreeSet<String> tree = new TreeSet<>();
		String[] data = str.split(" ");
		for (String string : data) {
			tree.add(string);
		}
		return tree;
	}
	
	public static PriorityQueue<Double> orderPriority(double... nums){
		PriorityQueue<Double> pq = new PriorityQueue<>();
		for (double d : nums) {
			pq.add(d);
		}
		return pq;
		
	}
}
