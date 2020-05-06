/* Jason Moreau
 * CISC 3130 - EWQ6
 * Spring 2020
 *
 * Assignment #5 - More Trees (General Trees)
 * Family Tree
 *
 */

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
		tree1.uncles("Jake");
		System.out.print("\nOldest child of Jones: ");
		tree1.oldestSon("Jones");
		System.out.print("Youngest child of Jones: ");
		tree1.youngestSon("Jones");
		System.out.print("Children of Deville: ");
		tree1.children("Deville");
		
		// Tree 2
		System.out.println("\n*** TREE 2 *** ");
		System.out.print("Grandparent of Scott: ");
		tree2.grandparent("Scott");
		System.out.print("Siblings of Phillip: ");
		tree2.getSibling("Phillip");
		System.out.print("Children of Mabel: ");
		tree2.children("Mabel");
		System.out.print("\nChildren of Jane: ");
		tree2.children("Jane");
		System.out.print("\nParent of Jane: ");
		tree2.getParentName("Jane");
		
		// Tree 3
		System.out.println("\n*** TREE 3 *** ");
		System.out.print("Children of Kelly: ");
		tree3.children("Kelly");
		System.out.print("\nGrandparent of Kelly: ");
		tree3.grandparent("Kelly");
		System.out.print("Oldest sibling of Sidney: ");
		tree3.oldestSibling("Sidney");
		
		// Tree 4
		System.out.println("\n*** TREE 4 *** ");
		System.out.print("Uncles of Isabel: ");
		tree4.uncles("Isabel");
		System.out.print("\nGrandparent of Harper: ");
		tree4.grandparent("Harper"); 
		System.out.print("Sibling of Harper: ");
		tree4.getSibling("Harper");
		System.out.print("Oldest son of Noah: ");
		tree4.oldestSon("Noah");
		
		// Tree 5
		System.out.println("\n*** TREE 5 *** ");
		System.out.print("Youngest child of Matthew: ");
		tree5.youngestSon("Matthew");
		System.out.print("Oldest child of Sebastian: ");
		tree5.oldestSon("Matthew"); 
		System.out.print("Uncles of Dylan: ");
		tree5.uncles("Dylan");
		System.out.print("Uncles of Sebastian: ");
		tree5.uncles("Sebastian");
		System.out.print("\nGrandparent of Sebastian: ");
		tree5.grandparent("Sebastian"); 
		System.out.print("Uncles of Luke: ");
		tree5.uncles("Luke");
		
	}
	
	// data: Imports data into tree
	public static void data(Node tree) throws Exception {
		String filename = "Tree" + Integer.toString(num); 
		Scanner sc = new Scanner(new File(filename));
		StringBuilder title = new StringBuilder("   *** Data for " + filename + " ***");
		String child;
		String parent;
		System.out.println(title);
		while(sc.hasNext()) {
			child = sc.next();
			parent = sc.next();
			tree.insert(child, parent);
			System.out.println("Child: " + child + "\tParent: " + parent);
		}
		System.out.println();
		num++;
	}

}
