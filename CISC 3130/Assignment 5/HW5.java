package assignment5;

import java.util.Scanner;
import java.io.File;

public class HW5 {
	static int num = 1;
	public static void main(String[] args) throws Exception {
		// Create family instances
		Node tree1 = new Node("Jones");
		Node tree2 = new Node("Thomas");
		Node tree3 = new Node("Lisa");
		Node tree4 = new Node("Emma");
		Node tree5 = new Node("Jackson");
		// Import data
		data(tree1);
		data(tree2);
		data(tree3);
		data(tree4);
		data(tree5);
		
		// Tree 1
		System.out.println("*** TREE 1 *** ");
		System.out.print("Parent of Dan: " + tree1.getParent("Dan") + "\n");
		System.out.print("Uncles of Jake: ");
		tree1.getUncles("Jake");
		System.out.print("Oldest child: ");
		tree1.oldestSon("Jones");
		System.out.print("Youngest child: ");
		tree1.youngestSon("Jones");
		
		// Tree 2
		System.out.println("\n*** TREE 2 *** ");
		System.out.print("Grandparent of Scott: ");
		tree2.getGrandparent("Scott");
		System.out.print("Siblings of Phillip: ");
		tree2.getSibling("Phillip");
		System.out.print("Children of Mabel: ");
		tree2.getChildren("Mabel");
		
		// Tree 3
		System.out.println("\n\n*** TREE 3 *** ");
		System.out.print("Children of Kelly: ");
		tree3.getChildren("Kelly");
		System.out.print("\nGrandparent of Kelly: ");
		tree3.getGrandparent("Kelly");
		System.out.print("\nOldest sibling of Sidney: ");
		tree3.oldestSibling("Sidney");
		
		// Tree 4
		System.out.println("\n*** TREE 4 *** ");
		System.out.print("Uncles of Isabel: ");
		tree4.getUncles("Isabel");
		System.out.print("Grandparent of Harper: ");
		tree4.getGrandparent("Harper"); 
		System.out.print("Sibling of Harper: ");
		tree4.getSibling("Harper");
		
		// Tree 5
		System.out.println("\n*** TREE 5 *** ");
		System.out.print("Youngest child of Matthew: ");
		tree5.youngestSon("Matthew");
		System.out.print("Oldest child of Sebastian: ");
		tree5.oldestSon("Matthew"); 
		System.out.print("Uncles of Dylan: ");
		tree5.getUncles("Dylan");
		System.out.print("Uncles of Sebastian: ");
		tree5.getUncles("Sebastian");
		System.out.print("Grandparent of Sebastian: ");
		tree5.getGrandparent("Sebastian"); 
		System.out.print("Uncles of Luke: ");
		tree5.getUncles("Luke");
		
	}
	
	// data: Imports data into tree
	public static void data(Node tree) throws Exception {
		String filename = "Tree" + Integer.toString(num); 
		Scanner sc = new Scanner(new File(filename));
		while(sc.hasNext()) {
			tree.insert(sc.next(), sc.next());
		}
		num++;
	}

}
