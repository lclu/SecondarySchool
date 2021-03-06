package extra_assignment;

public class AvlTree {

	/** Attributes */
	private AvlNode root;
	
	
	/** 
	 * Construct the tree
	 */
	public AvlTree () {
		root = null;
	}
	
	
	/** 
	 * Check whether the tree is empty 
	 */
	public boolean isEmpty() {
		return (root == null);
	}
	
	/** 
	 * Make the tree empty 
	 */
	public void makeEmpty() {
		root = null;
	}
	
	/** 
	 * Return root of the tree 
	 */
	public AvlNode getRoot() {
		return root;
	}
	
	/**
	* Insert AVLNode into the tree
	* @param k the key of the node
	* @param v the value of the node
	*/
	public boolean insert(Object k, Object v) {
		AvlNode n = new AvlNode(k, v, null, null, null);
		
		if (v instanceof Student) {
			root = insertStudent(n, root);
			return true;
		}

		if (v instanceof Course) {
			root = insertCourse(n, root);
			return true;
		}
		return false;
	}
	
	/**
	* Internal method to insert the node for Students recursively.
	* @param m the node to insert
	* @param n the node that roots the subtree
	* @return node n
	*/
	private AvlNode insertStudent(AvlNode m, AvlNode n) {
		if (n == null) { //tree is empty
			n = m;
		}
		
		if ((Integer)m.getKey() < (Integer)n.getKey()) {
			
			n.setLeft(insertStudent(m,n.getLeft())); //recursion
			//m.setParent(n);
			if (height(n.getLeft()) - height(n.getRight()) == 2) { //check if rebalance needed
				if ((Integer)m.getKey() < (Integer)n.getLeft().getKey()) {
					n = singleLeftChild(n);
				}
				else {
					n = doubleLeftChild(n);
				}
			}
		}
		
		else if ((Integer)m.getKey() > (Integer)n.getKey()) {
			
			n.setRight(insertStudent(m,n.getRight())); //recursion
			//m.setParent(n);
			if (height(n.getRight()) - height(n.getLeft()) == 2) { //check if rebalance needed
				if ((Integer)m.getKey() > (Integer)n.getRight().getKey()) {
					n = singleRightChild(n);
				}
				else {
					n = doubleRightChild(n);
				}
			}
		}
		return n;
	}
	
	/**
	* Internal method to insert the node for Courses recursively.
	* @param m the node to insert
	* @param n the node that roots the subtree
	* @return the inserted node
	*/
	private AvlNode insertCourse(AvlNode m, AvlNode n) {
		if (n == null) { //tree is empty
			n = m;
		}
		
		String a = (String)m.getKey();
		String b = (String)n.getKey();
		int compare = a.compareTo(b);
		
		if (compare < 0) { //a is smaller
			
			n.setLeft(insertCourse(m,n.getLeft())); //recursion
			//m.setParent(n);
			if (height(n.getLeft()) - height(n.getRight()) == 2) { //check if rebalance needed
				String c = (String)n.getLeft().getKey();
				int compare2 = a.compareTo(c);
				
				if (compare2 < 0) {
					n = singleLeftChild(n);
				}
				else {
					n = doubleLeftChild(n);
				}
			}
		}
		
		else if (compare > 0) { //a is bigger
			
			n.setRight(insertCourse(m,n.getRight())); //recursion
			//m.setParent(n);
			if (height(n.getRight()) - height(n.getLeft()) == 2) { //check if rebalance needed
				String c = (String)n.getRight().getKey();
				int compare3 = a.compareTo(c);
				
				if (compare3 > 0) {
					n = singleRightChild(n);
				}
				else {
					n = doubleRightChild(n);
				}
			}
		}
		return n;
	}
	
	/**
	* Remove AVLNode from the tree
	* @param k the key of the node
	* @return the deleted node
	*/
	public AvlNode remove(Object k) {

		if (k instanceof Integer) {
			AvlNode n = searchStudent((Integer)k, root);
			if (n != null) {
				root = removeStudent(n, root);
				return n;
			}
		}

		if (k instanceof String) {
			AvlNode n = searchCourse((String)k, root);
			if (n != null) {
				root = removeCourse(n, root);
				return n;
			}
		}
		return null;
	}

	/**
	* Internal method to search for the Student AVLNode and delete it
	* @param m the node to remove
	* @param n the node that roots the subtree
	* @return the root of the new tree
	*/
	private AvlNode removeStudent(AvlNode m, AvlNode n) {

		if (n == null) {
			return null;
		}
		// search for the node
		if ((Integer)m.getKey() < (Integer)n.getKey()) {
			removeStudent(m,n.getLeft());
		}
		else if ((Integer)m.getKey() > (Integer)n.getKey()) {
			removeStudent(m,n.getRight());
		}
		// found the node to remove
		else if ((Integer)m.getKey() == (Integer)n.getKey()) {
			return removeFound(n);
		}
		return null;
	}
	
	/**
	* Internal method to search for the Course AVLNode and delete it
	* @param m the node to remove
	* @param n the node that roots the subtree
	* @return the root of the new tree
	*/
	private AvlNode removeCourse(AvlNode m, AvlNode n) {
		if (n == null) {
			return null;
		}
		// search for the node
		String a = (String)m.getKey();
		String b = (String)n.getKey();
		int compare = a.compareTo(b);
		
		if (compare < 0) {
			removeCourse(n.getLeft(),m);
		}
		else if (compare > 0) {
			removeCourse(n.getRight(),m);
		}
		// found the node to remove
		else if (compare == 0) {
			return removeFound(n);
		}
		return null;
	}

	/**
	* Internal method to remove the found AVLNode from the tree.
	* @param n the node to remove
	* @return the root of the new tree
	*/
	private AvlNode removeFound(AvlNode n) {
		// n has 0 children
		if (n.getLeft() == null && n.getRight() == null) {
			n.setParent(null);
			return null;
		}
		// n has 1 child - will be balanced after removal
		else if (n.getLeft() == null) {
			n.getRight().setParent(n.getParent()); //remove n from tree
			n.setParent(null); //link n to nothing
			return n.getRight();
		}
		else if (n.getRight() == null) {
			n.getLeft().setParent(n.getParent()); //remove n from tree
			n.setParent(null); //link n to nothing
			return n.getLeft();
		}
		// n has 2 children
		else {
			AvlNode temp = treeMinimum(n.getRight());
			n.setKey(temp.getKey());
			n.setValue(temp.getValue());
			if (n.getKey() instanceof Integer) {
				n.setRight(removeStudent(n.getRight(), temp));
			}
			if (n.getKey() instanceof String) {
				n.setRight(removeCourse(n.getRight(), temp));
			}
		}
	
		// check balance tree
		int difference = (height(root.getRight()) - height(root.getLeft()));
		
		if ((difference > 1) && (getBalance(root.getLeft()) >= 0)) {
			return singleRightChild(root);
		}
			
		if ((difference > 1) && (getBalance(root.getLeft()) < 0)) {
			return doubleRightChild(root);
		}
			
		if ((difference < -1) && (getBalance(root.getRight()) >= 0)) {
			return singleLeftChild(root);
		}
				
		if ((difference < -1) && (getBalance(root.getRight()) < 0)) {
			return doubleLeftChild(root);
		}
		return null; 
	}
	
	/**
	 * Search for a course/student in the tree
*/
	public boolean search(Object k) {
	if (k instanceof Integer) {
		if (searchStudent((Integer)k, root) != null) {
			return true;
		}
	}

	if (k instanceof String) {
		if (searchCourse((String)k, root) != null) {
			return true;
		}
	}
	return false;
}

/**
 	* Internal method to find a student in the tree with recursion
* @param k the id of the student
* @param n the AVLNode to compare with
*/
	private AvlNode searchStudent(Integer k, AvlNode n) {
	AvlNode found = null;
	while ((n != null)) {
		Integer key = (Integer)n.getKey();
		if (k < key) {
			n = n.getLeft();
		}
		else if (k > key) {
			n = n.getRight();
		}
		else {
			found = n;
			break;
		}
		found = searchStudent(k, n);
	}
	return found;
}

/**
 	* Internal method to find a course in the tree with recursion
* @param k the id of the course
* @param n the AVLNode to compare with
*/
	private AvlNode searchCourse(String k, AvlNode n) {
	AvlNode found = null;
	
	while((n != null)) {
		String key = (String)n.getKey();
		int compare = k.compareTo(key);
		
		if (compare < 0) {
			n = n.getLeft();
		}
		else if (compare > 0) {
			n = n.getRight();
		}
		else {
			found = n;
			break;
		}
		found = searchCourse(k, n);
	}
	return found;
}
	
	/**
	* Rotate node with left child.
	*/
	private AvlNode singleLeftChild(AvlNode n) {
		AvlNode left = n.getLeft();
		n.setLeft(left.getRight());
		left.setRight(n);
		return left;
	}
	
	/**
	* Rotate node with right child.
	*/
	private AvlNode singleRightChild(AvlNode n) {
		AvlNode right = n.getLeft();
		n.setRight(right.getLeft());
		right.setLeft(n);
		return right;
	}
	
	/**
	* Rotate left child with its right child
	* then rotate n with n's new left child
	*/
	private AvlNode doubleLeftChild(AvlNode n) {
		n.setLeft(singleRightChild(n.getLeft()));
		return singleLeftChild(n);
	}
	
	/**
	* Rotate right child with its left child
	* then rotate n with n's new right child
	*/
	private AvlNode doubleRightChild(AvlNode n) {
		n.setRight(singleLeftChild(n.getRight()));
		return singleRightChild(n);
	}
	
	/*
	/**
	* Search successor of node
	
	public AVLNode successor(AVLNode n) {
		AVLNode temp = n;
		AVLNode temp2 = n.getParent();
		
		if (n.getRight() != null) {
			return treeMinimum(n.getRight());
		}
			
		while (temp2 != null && temp == temp2.getRight()) {
			temp = temp2;
			temp2 = temp2.getParent();
		}
		return temp2;		
	}
	*/
	
	/**
	* Return height of the tree
	*/
	public int height() {
		return height(root);
	}
	
	/**
	* Return height of the node
	*/
	private int height(AvlNode n) {
		if (n == null) { 
			return -1;
		}
		if (n.getLeft() == null && n.getRight() == null) {
			return 0;
		}
		else if (n.getLeft() == null) {
			return (1 + height(n.getRight()));
		}
		else if (n.getRight() == null) {
			return (1 + height(n.getLeft()));
		}
		else {
			return (1 + maximum(height(n.getLeft()), height(n.getRight())));
		}
	}
	
	/**
	* Check balance of the tree
	* should be at most 1
	*/
	public int getBalance(AvlNode n) {
		if (n == null) {
			return 0;
		}
		return (height(n.getLeft()) - height(n.getRight()));
	}
		
	/**
	* Count the number of nodes
	*/
	public int countNodes()
	{
		return countNodes(root);
	}
	
	/**
	* Internal method to count the number of nodes with recursion
	*/
	private int countNodes(AvlNode n) {
		if (n == null) {
			return 0;
		}
		int temp = 1;
		temp += countNodes(n.getLeft());
		temp += countNodes(n.getRight());
		return temp;
	}
			
	/**
	* checks which one of the two inputs is the lowest
	*/
	public int minimum(int a, int b) {
		if (a > b) {
			return b;
		}
		return a;
	}
	
	/**
	* checks which one of the two inputs is the highest
	*/ 
	public int maximum(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
	
	/**
	* Return the node with the minimum key of the subtree
	*/ 
	public AvlNode treeMinimum(AvlNode n) {
		while (n.getLeft() != null) {
			n = n.getLeft();
		}
		return n;
	}
	
	/**
	* Return the node with the maximum key of the subtree
	*/
	public AvlNode treeMaximum(AvlNode n) {
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n;
	}
	
	/**
	* method for String representation with keys and values of inorder traversal
	*/	
	public void inorder() {
		inorder(root);
	}
	
	/**
	* Internal method for inorder traversal with recursion
	*/
	private void inorder(AvlNode n) {
		if (n != null) {
			inorder(n.getLeft());
			if (n.getKey() instanceof Integer) {
				System.out.print(n.getKey() + " " + ((Student)n.getValue()).getName() + "\n");
			}
			if (n.getKey() instanceof String) {
				System.out.print(n.getKey() + " " + ((Course)n.getValue()).getName() + "\n");
			}
			inorder(n.getRight());
		}
	}
		
	/**
	* method for String representation with keys and values of preorder traversal
	* ! does not return a list in ascending order
	*/
	public void preorder() {
		preorder(root);
	}
	
	/**
	* Internal method for preorder traversal with recursion
	*/
	private void preorder(AvlNode n) {
		if (n != null) {
			System.out.print(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
		
	/**
	* method for String representation with keys and values of postorder traversal
	* ! does not return a list in ascending order
	*/
	public void postorder() {
		postorder(root);
	}
	
	/**
	* Internal method for postorder traversal with recursion
	*/
	private void postorder(AvlNode n) {
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}
}
