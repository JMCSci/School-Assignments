/* Node class
 * Binary Tree 
 */

package assignment4;

public class Node {
	Stack <Node> stack = new Stack<>();
	int data;	
	int leaves;	
	int parentNodes;
	int numberOfChildren = 0;
	Node left;
	Node right;
	Node root;		// root value
	Node p;

	// No arg constructor
	Node() {
		
	}
	
	// Constructor will be the first node/root node
	Node(int data) {
		this.data = data;
		if(root == null) {
			this.root = this;
		}
		
	}
	
	// insert: Creates a new node
	boolean insert(int value) {
		Node node = new Node(value);
		if(root == null) {
			root = node;
		}
		if(value < data) {
			if(left == null) {
				left = node;
				return true;
			} else {
				return left.insert(value);
			}
		} else if(value > data) {
			if(right == null) {
				right = node;
				return true;
			} 
		}
		return right.insert(value);
		
	}

	void inorder() {
		// Left 
		if(left != null) {
			left.inorder();
		}
		// Root
		System.out.print(data + " ");
		// Right
		if(right != null) {
			right.inorder();
		} 
		
	}
	
	void postorder() {
		// Left
		if(left != null) {
			left.postorder();
		}
		// Right
		if(right != null) {
			right.postorder();
		}
		// Root
		System.out.print(data + " ");
	}
	
	void preorder() {
		// Root
		System.out.print(data + " ");
		// Left
		if(left != null) {
			left.preorder();
		}
		// Right
		if(right != null) {
			right.preorder();
		}
	}
	
	// delete: Deletes a node in the tree
	boolean delete(int value) {
		// Find node
		Node current = root;		 
		Node parent = null;						// keep track of node to be removed parent 
		while(current != null) {
			// Value is root
			if(value == current.data) {
				break;
			}
			if(value < current.data) {
				parent = current;
				current = current.left;
			} else if(value > current.data) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		}
		// Data is not in tree
		if(current == null) {
			return false;
		}
		
		Node newRoot = null;
		
		// its the root
		if(current == root) {
			if(current.right != null) {
				current = current.right;
				while(current != null) {
					if(current.left == null) {
						newRoot = current;
						root.data = current.data;
						root.right = current.right;
						break;
					}
					parent = current;
					current = current.left;
				
				}
			} else if(current.left != null) {
				current = current.left;
				while(current != null) {
					if(current.right == null) {
						newRoot = current;
						break;
					}
					parent = current;
					current = current.right;
				}
			}
			return true;
	
		}
		
		// Check if current's left is null
		// If it is...
		if(current.left == null) {
			// Check if parent node is null
			// Set root equal to current's right
			if(parent == null) {
				root = current.right;
			} else { 
				// If current is less than parent
				// Set parents's left equal to current's right
				// Or else, set parent's right equal to current's right
				if(value < parent.data) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		// If current's left is not null
		} else {
			Node rightMostParent = current;
			// Set rightMost to the current node's left
			Node rightMost = current.left;
			// If there is a right node, keep going right
			while(rightMost.right != null) {
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			// Change contents of current node with those of rightMost node
			current.data = rightMost.data;
			// Check if rightMost's parent is rightMost
			// If it is, set it to rightMost's left -- which should be null
			// Or else, set it rightMost's parent' left equal to rightMost's left  
			if(rightMostParent.right == rightMost) {
				rightMostParent.right = rightMost.left;
			} else {
				rightMostParent.left = rightMost.left;
			}
					
		}
		return true;
	}
	
	// count: Returns the number of nodes in the tree
	int count() {
		int nodes = 0;
		if(right != null) {
			 nodes += right.count();
		}
		if(left != null) {
			nodes += left.count() ;
		}
		
		if(root == null) {
			return -1;
		}
		return nodes + 1; // nodes + 1 (root)
	}
	
	// freeTree: Sets root node as a parameter to removeTree function
	void freeTree() {
		removeTree(root);
	}
	
	// removeTree: Removes root node via pointer
	void removeTree(Node p) {
		p = null;			// sets pointer to null -- GARBAGE COLLECTION
	}

}
