package assignment5;

public class HW5 {
	public static void main(String[] args) throws Exception {
		Node tree = new Node("Jones");
		tree.insert("Bob", "Jones");
//		tree.getRoot();
//		tree.getParent("Bob");
//		System.out.println(tree.getTotalChildren("Jake"));
		
		
		tree.insert("Dan", "Jones");
		
//		tree.getTotalChildren("Jake");
		
		
		tree.insert("Brian", "Jones");
//		tree.getTotalChildren("Jake");
//		System.out.println(tree.getParent("Mildred"));
//		tree.preorder();
//		tree.getParent("Bob");
//		tree.getTotalChildren("Dan");
//		tree.getTotalChildren("Dan");
//		tree.insert("Lisa", "Jake");
//		tree.getSiblings("Lisa");
//		tree.insert("Tara", "Bob");
//		tree.preorder();
		
		
		tree.insert("Richard", "Bob");
		tree.insert("Jake", "Bob");
		tree.insert("Bill", "Jake");
		tree.insert("Michael", "Brian");
		tree.insert("Deville", "Michael");
	

		
//		tree.getChildren("Jake");
//		tree.getSibling("Bob");
//		tree.getTotalChildren("Michael");
//		tree.getRoot();
//		tree.getSibling("Brian");

//		tree.getTotalChildren("Bob");
//		tree.getSiblings("Bill");
		tree.getChildren("Bob");

		
		 
	}

}
