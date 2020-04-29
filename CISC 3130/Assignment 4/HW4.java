/* Jason Moreau
 * CISC 3130 - EWQ6
 * Spring 2020
 *
 * Assignment #4 - Trees
 *
 */


package assignment4;

import java.io.File;
import java.util.Scanner;

public class HW4 {
	static int num = 1;
	public static void main(String[] args) throws Exception {
		Node tree = new Node();
		/* Set1 */
		printSet();
		tree = readData();
		process(tree);
		tree.insert(21);
		tree.delete(1);
		tree.insert(0);
		tree.delete(10);
		tree.delete(11);
		tree.delete(5);
		tree.delete(2);
		tree.insert(10);
		newline();
		process(tree);
		newline();
		tree.freeTree();
		/* Set2 */
		printSet();
		tree = readData();
		process(tree);
		newline();
		tree.delete(3);
		tree.delete(1);
		process(tree);
		newline();
		tree.freeTree();
		/* Set3 */
		printSet();
		tree = readData();	
		process(tree);
		newline();
		tree.freeTree();
		tree.delete(15);
		tree.insert(30);
		tree.insert(5);
		tree.insert(10);
		tree.insert(20);
		tree.delete(20);
		tree.delete(10);
		tree.delete(5);
		tree.delete(15);
		tree.delete(30);
		process(tree);
		newline();
		tree.freeTree();
		/* Set4 */
		printSet();
		tree = readData();	
		process(tree);
		newline();
		tree.delete(2);
		process(tree);
		newline();
		tree.freeTree();
		/* Set5 */
		printSet();
		tree = readData();	
		process(tree);
		newline();
		tree.delete(37);
		tree.delete(15);
		tree.insert(40);
		tree.insert(99);
		process(tree);
		newline();
		tree.freeTree();
		/* Set6 */
		printSet();
		tree = readData();	
		process(tree);
		newline();
		newline();
		tree.freeTree();
		/* Set7 */
		printSet();
		tree = readData();	
		process(tree);
		newline();
		newline();
		tree.freeTree();
	}
	
	public static Node readData() throws Exception {
		Scanner sc = new Scanner(new File("Set" + Integer.toString(num)));	
		Node tree = null;
		while(sc.hasNextInt()) {
			if(tree == null) {
				 tree = new Node(sc.nextInt());
			} else {
				tree.insert(sc.nextInt());	
			}
		}
		
		if(tree == null) {
			tree = new Node();
		} 
			
		num++;
		sc.close(); 
		return tree;
	}
	
	public static void printSet() {
		System.out.println("*** Set " + num + " *** \n");
	}
	
	public static void process(Node tree) {
		if(tree.root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			System.out.println("Inorder Traversal");
			tree.inorder();
			newline();
			System.out.println("\nPreorder Traversal");
			tree.preorder();
			newline();
			System.out.println("\nPostorder Traversal");
			tree.postorder();
			newline();
			System.out.println("\nNumber of nodes: " + tree.count());
			newline();
			tree.children();
		}
		
	}
	
	public static void newline() {
		System.out.println();
	}

}
