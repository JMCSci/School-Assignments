package assignment5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Node {
	String name;
	Node root;
	Node parent;
	Node child; 
	Node sibling;
	int numberOfChildren;
	LinkedList <Node> children = new LinkedList<>();
	ArrayList <Node> parents = new ArrayList<>();
	LinkedList <Node> siblings = new LinkedList<>();
		
	Node(String name) {
		this.name = name;
		// if the root doesnt exist make it this node
		// set the parent to null since the root doesnt have parent
		if(root == null) {
			this.root = this;
			parent = null;	
		} 
		numberOfChildren = 0;
		// list of parent child nodes
		parents.add(this);
	}

	// insert: Inserts a new node into tree
	boolean insert(String child, String parentNode) {
		Iterator <Node> iterator = parents.listIterator();
		Iterator <Node> iteratorSib = siblings.listIterator();
		Node parentTemp = null;
		int index = 0;
		// search for parent node match 
		// get the index in list
		while(iterator.hasNext()) {
			if(iterator.next().name == parentNode) {
				break;
			}
			index++;
		}
		
		// searching tree index is greater than the size of parents array
		// means parent is not in tree
		if(index > parents.size() - 1) {
			System.out.println("Parent not in tree");
			return false;
		}
		
		Node node = new Node(child);			// new node for tree
		parentTemp = parents.get(index);		// temp is the parent node will be placed back into array
		parentTemp.children.addLast(node);
		node.parent = parentTemp;
		this.parents.add(node);					// add to parents list
		parentTemp.numberOfChildren++;
		
		// if children list size is greater than 1, there are siblings  -- add and update node's sibling list
		if(parentTemp.numberOfChildren > 1) {
			updateSiblings(parentTemp, node);
		}
		return true;
	}
	
	// updateSiblings: (WORKS) -- Updates all children siblings lists
	void updateSiblings(Node parentNode, Node newNode) { 
				int size = parentNode.children.size();
					Node parentChild = null;
					Node temp = null;
					for(int i = 0; i < size; i++) {
						// walks through list -- sets variable to children nodes
						parentChild = parentNode.children.get(i);
						// walks through entire list -- adds siblings that are not in list already 
						for(int j = 0; j < size; j++) { 
							temp = parentNode.children.get(j);
							// child name does not equal sibling name
							if(temp.name != parentChild.name) {
								// make sure name is not already on the list -- if not, add it
								if(!parentChild.siblings.contains(temp)) {
									parentChild.siblings.addLast(temp);
								}
							} 
						}
					}
					
				}
	
	
		// getSibling: (WORKS) -- Gets siblings of child
		void getSibling(String child) throws Exception {
			int index = 0;
			// get parent of child
			Node parentOfChild = getParent(child);
			
			// check if parentOfChild is null
			if(parentOfChild == null) {
				System.out.println("This is the root node.");
				return;
			}
			
			// iterate through parent's children lists to find child
			Iterator <Node> childIterator = parentOfChild.children.iterator();
			while(childIterator.hasNext()) {
				if(childIterator.next().name == child) {
					// get index of child name in list
					break;	
				}
				// increments index for use in children list
				index++;
			}
	
			// child location in array
			//parentOfChild.children.get(index);
			
			// if sibling list is empty 
			if(parentOfChild.children.get(index).siblings.isEmpty()) {
				System.out.println("No siblings");
			} else {
				System.out.println(parentOfChild.children.get(index).siblings);
			}
		}

	// getRoot: (WORKS) -- Prints root node of tree
	void getRoot() {
		System.out.println(root.name);
	}
	
	// getParent: (WORKS) -- Returns parent of child
	Node getParent(String child) {
		Iterator <Node> parent = parents.iterator();
		Node parentOfChild = null;
		Node node = null;
		Node childNode = null;
		int index = 0;
		
		Node temp = null;			// holds parent node
		// go through parents -- find parent
		for(int i = 0; i < parents.size(); i++) {
			temp = parents.get(i);
			index = i;
			for(int j = 0; j < temp.children.size(); j++) {
				// go through parents childrens list to find match of child name
				if(temp.children.get(j).name == child) {
					parentOfChild = temp;
					break;
				}
			}
		}
		System.out.println(parentOfChild.name);
		return parentOfChild;
	}
	
	// getTotalChildren: (WORKS)
	int getTotalChildren(String nodeName) throws Exception {
		// find parent
		Iterator <Node> parent = parents.iterator();
		Node node = null;
		int index = 0;
		// go through parents
		while(parent.hasNext()) {
			if(parent.next().name == nodeName) {
				break; 
			} 
			index++;			// find index in array
		}
			
		node = parents.get(index);
		System.out.println(node.numberOfChildren);
		return node.numberOfChildren;		
	}

	
	
	// getChildren: (WORKS) -- Gets children of parent node
	void getChildren(String nameNode) {
		// find parent
		Iterator <Node> parent = parents.iterator();
		Node node = null;
		int index = 0;
		// go through parents
		while(parent.hasNext()) {
			if(parent.next().name == nameNode) {
				break;
			} 
			index++;			// index in array
		}
		node = parents.get(index);
		Iterator <Node> nodeChild= node.children.iterator();

		if(nodeChild.hasNext() == false) {
			System.out.println("No children");
		} else {
			// print children
			while(nodeChild.hasNext()) {
				System.out.println(nodeChild.next());
			}
		}
	}
	
		
	public String toString() {
		return name;
	}
	
	

}
