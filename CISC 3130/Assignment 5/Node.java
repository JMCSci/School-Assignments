/* Node class */

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
	boolean insert(String child, String parentName) {
		Iterator <Node> iterator = parents.listIterator();
		Node parentTemp = null;
		int index = 0;
		// search for parent node match 
		// get the index in list
		while(iterator.hasNext()) {
			if(iterator.next().name.matches(parentName)) {
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
	
	// updateSiblings: Updates all children siblings lists after node creation
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
	
	
		// siblings: Prints siblings of child node
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
				if(childIterator.next().name.matches(child)) {
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
				System.out.println("* No siblings * ");
			} else {
				Iterator <Node> nodeSiblings = parentOfChild.children.get(index).siblings.listIterator();
				while(nodeSiblings.hasNext()) {
					System.out.print(nodeSiblings.next());
					if(nodeSiblings.hasNext()) {
						System.out.print(", ");
					}
				}
				System.out.println("\n");
			}
		}

	// getRoot: Prints root node of tree
	Node getRoot() {
		return root;
	}
	
	// getParent: Returns parent of child
	Node getParent(String child) {
		Iterator <Node> parent = parents.iterator();
		Node parentOfChild = null;
		int index = 0;
		
		Node temp = null;			// holds parent node
		// go through parents -- find parent
		for(int i = 0; i < parents.size(); i++) {
			temp = parents.get(i);
			index = i;
			for(int j = 0; j < temp.children.size(); j++) {
				// go through parents childrens list to find match of child name
				if(temp.children.get(j).name.matches(child)) {
					parentOfChild = temp;
					break;
				}
			}
		}
		
		// root doesnt have a parent
		if(parentOfChild == null) {
			System.out.println("Node does not have a parent.");
			return null;
		}
		return parentOfChild;
	}
	
	// parentName: Prints name of parent node
	void getParentName(String child) {
		Iterator <Node> parent = parents.iterator();
		Node parentOfChild = null;
		int index = 0;
		// holds parent node
		Node temp = null; 	
		// go through parents -- find parent
		for(int i = 0; i < parents.size(); i++) {
			temp = parents.get(i);
			index = i;
			for(int j = 0; j < temp.children.size(); j++) {
				// go through parents childrens list to find match of child name
				if(temp.children.get(j).name.matches(child)) {
					parentOfChild = temp;
					break;
				}
			}
		}
		
		// root doesnt have a parent
		if(parentOfChild == null) {
			System.out.println("Node does not have a parent.");
			return;
		}
		System.out.println(parentOfChild.name);
	}
	
	// getTotalChildren: Returns the number of children of the parent node
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
			// find index in array
			index++;			
		}
			
		node = parents.get(index);
		System.out.println(node.numberOfChildren);
		return node.numberOfChildren;		
	}


	// getChildren: Returns children of parent node
	LinkedList <Node> getChildrenList(String nameNode) {
		// find parent
		Iterator <Node> parent = parents.iterator();
		Node node = null;
		int index = 0;
		// go through parents
		while(parent.hasNext()) {
			if(parent.next().name.matches(nameNode)) {
				break;
			} 
			// index in array
			index++;			
		}
		node = parents.get(index);
		Iterator <Node> nodeChild= node.children.iterator();

		
		// Print children
		if(nodeChild.hasNext() == false) {
			System.out.println("No children");
		}
	
		return node.children;
	}
	
	// children: Prints the children of the parent node
	void children(String nameNode) {
		// find parent
		Iterator <Node> parent = parents.iterator();
		Node node = null;
		int index = 0;
		// go through parents
		while(parent.hasNext()) {
			if(parent.next().name.matches(nameNode)) {
				break;
			} 
			// index in array
			index++;			
		}
		node = parents.get(index);
		Iterator <Node> nodeChild= node.children.iterator();

				
		// Print children
		// No children in list
		if(nodeChild.hasNext() == false) {
				System.out.println("No children");
		}
		// Children in list
		Iterator <Node> nodeChildren = node.children.listIterator();
		while(nodeChildren.hasNext()) {
			System.out.print(nodeChildren.next());
			if(nodeChildren.hasNext()) {
				System.out.print(", ");
			}
		}
	}
	
	// uncles: Prints uncles of child node
	void uncles(String nameNode) {
		Node parentOfChild = null;
		LinkedList <Node> uncles = new LinkedList<>();
		parentOfChild = getParent(nameNode);
		
		// this is the root node -- no parents
		if(parentOfChild == null) {
			System.out.println("This is the root node.");
			return; 
		}
		
		// walk through siblings of parent list
		Iterator <Node> iterator = parentOfChild.siblings.listIterator();
		// add them to uncles list
		while(iterator.hasNext()) {
			uncles.addLast(iterator.next());
		}
		
		// uncles will be sibling of parent
		if(uncles.isEmpty()) {
			System.out.println("* No uncles * ");
			return;
		}
		
		// Print all uncles
		Iterator <Node> allUncles = uncles.listIterator();
		while(allUncles.hasNext()) {
			System.out.print(allUncles.next());
			if(allUncles.hasNext()) {
				System.out.print(", ");
			}
		}
	}
	
	// grandparent: Prints the name of the grandparent
	void grandparent(String nameNode) {
		// get parent node
		// get parents parent node
		Node parentOfChild = getParent(nameNode);
		Node parentOfParent = getParent(parentOfChild.name);
		
		// this is the root node -- no parents
		if(parentOfChild == null || parentOfParent == null) {
			System.out.println("This is the root node.");
			System.out.println("Child does not have grandparent.");
			return;
		}
		System.out.println(parentOfParent.name);
	}
	
	// youngestSon: Prints the name of the youngest son
	void youngestSon(String nameNode) {
		LinkedList<Node> childList = getChildrenList(nameNode);
		if(childList.isEmpty()) {
			System.out.println("* No sons * ");
			return;
		}
		System.out.println(childList.getLast());
	}
	
	// oldestSon: Prints the name of the oldest son
	void oldestSon(String nameNode) {
		LinkedList<Node> childList = getChildrenList(nameNode);
		if(childList.isEmpty()) {
			System.out.println("* No sons *");
			return;
		}
		System.out.println(childList.getFirst());
	}
	
	// oldestSibling: Prints the name of the oldest sibling
	void oldestSibling(String nameNode) {
		Node parentOfChild = getParent(nameNode);
		Node oldestChild; 
		oldestChild = parentOfChild.children.getFirst();
		
		if(parentOfChild.children.size() == 1) {
			System.out.println("* Only child * ");
			return;
		}
		
		if(nameNode.matches(oldestChild.name)) {
			System.out.println("This member is the oldest sibling.");
			return;
		}
		
		System.out.println(oldestChild.name);
	}
	
	// youngestSibling: Prints the name of the youngest sibling
	void youngestSibling(String nameNode) {
		// root node
		if(getParent(nameNode) == null) {
			System.out.println("This is the root node.");
			return;
		}
		
		Node parentOfChild = getParent(nameNode);
		Node oldestChild; 
		oldestChild = parentOfChild.children.getLast();

		if(parentOfChild.children.size() == 1) {
			System.out.println("Node is an only child.");
			return;
		}
		
		
		if(nameNode.matches(oldestChild.name)) {
			System.out.println("This member is the youngest sibling.");
			return;
		}
		
		System.out.println(oldestChild.name);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}
