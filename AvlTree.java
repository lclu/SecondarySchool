package extra_assignment;

public class AvlTree {

	/** Attributes */
	private AVLNode root;
	
	
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
	* Insert AVLNode into the tree
	* @param k the key of the node
	* @param v the value of the node
	*/
	public void insert(Object k, Object v) {
		AVLNode n = new AVLNode(k, v, null, null);
		
		if (v instanceof Student) {
			root = insertStudent(n, root);
		}

		if (v instanceof Course) {
			root = insertCourse(n, root);
		}
	}
	
	/**
	* Internal method to insert the node for Students recursively.
	* @param m the node to insert
	* @param n the node that roots the subtree
	* @return the inserted node
	*/
	private AVLNode insertStudent(AVLNode m, AVLNode n) {
		if (n == null) {
			n = m;
		}
		
		else if ((int)m.getKey() < (int)n.getKey()) {
			
			n.setLeft(insertStudent(m,n.getLeft()));
			m.setParent(n);
			if (height(n.getLeft()) - height(n.getRight()) == 2) {
				if ((int)m.getKey() < (int)n.getLeft().getKey()) {
					n = singleLeftChild(n);
				}
				else {
					n = doubleLeftChild(n);
				}
			}
		}
		
		else if ((int)m.getKey() > (int)n.getKey()) {
			
			n.setRight(insertStudent(m,n.getRight()));
			m.setParent(n);
			if (height(n.getRight()) - height(n.getLeft()) == 2) {
				if ((int)m.getKey() > (int)n.getRight().getKey()) {
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
	private AVLNode insertCourse(AVLNode m, AVLNode n) {
		if (n == null) {
			n = m;
		}
		
		String a = (String)m.getKey();
		String b = (String)n.getKey();
		int compare = a.compareTo(b);
		
		if (compare < 0) {
			
			n.setLeft(insertCourse(m,n.getLeft()));
			m.setParent(n);
			if (height(n.getLeft()) - height(n.getRight()) == 2) {
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
		
		else if (compare > 0) {
			
			n.setRight(insertCourse(m,n.getRight()));
			m.setParent(n);
			if (height(n.getRight()) - height(n.getLeft()) == 2) {
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
	public AVLNode remove(Object k) {
		
		if (k instanceof Integer) {
			AVLNode n = searchStudent((int)k, root);
			if (n != null) {
				root = removeStudent(n, root);
				return n;
			}
		}

		if (k instanceof String) {
			AVLNode n = searchCourse((String)k, root);
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
	private AVLNode removeStudent(AVLNode m, AVLNode n) {
		// search for the node
		if (n == null) {
			return null;
		}
		if ((int)m.getKey() < (int)n.getKey()) {
			removeStudent(n.getLeft(),m);
		}
		else if ((int)m.getKey() > (int)n.getKey()) {
			removeStudent(n.getRight(),m);
		}
		// found the node to remove
		else if ((int)m.getKey() == (int)n.getKey()) {
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
	private AVLNode removeCourse(AVLNode m, AVLNode n) {
		if (n == null) {
			return null;
		}

		String a = (String)m.getKey();
		String b = (String)n.getKey();
		int compare = a.compareTo(b);
		
		if (compare < 0) {
			removeCourse(n.getLeft(),m);
		}
		else if (compare > 0) {
			removeCourse(n.getRight(),m);
		}
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
	private AVLNode removeFound(AVLNode n) {
		// n has 0 children
		if (n.getLeft() == null && n.getRight() == null) {
			return null;
		}
		// n has 1 child
		else if (n.getLeft() == null) {
			return n.getRight();
		}
		else if (n.getRight() == null) {
			return n.getLeft();
		}
		// n has 2 children
		else {
			AVLNode temp = treeMinimum(n.getRight());
			n.setKey(temp.getKey());
			n.setValue(temp.getValue());
			n.setRight(removeStudent(n.getRight(), temp));
		}
	
		// check balance tree
		int difference = (height(root.getRight()) - height(root.getLeft()));
		
		if ((difference > 1) && (getBalance(root.getLeft()) >= 0)) {
			return singleRightChild(root);
		}
			
		if ((difference > 1) && (getBalance(root.getLeft()) < 0)) {
			return doubleRightChild(root);
		}
			
		if ((difference < -1) && (getBalance(root.getRight()) < 0)) {
			return singleLeftChild(root);
		}
				
		if ((difference < -1) && (getBalance(root.getRight()) < 0)) {
			return doubleLeftChild(root);
		}
		return null;
	}
		
	public AVLNode singleLeftChild(AVLNode n) {
		AVLNode left = n.getLeft();
		n.setLeft(left.getRight());
		left.setRight(n);
		return left;
	}
	
	public AVLNode singleRightChild(AVLNode n) {
		AVLNode right = n.getLeft();
		n.setRight(right.getLeft());
		right.setLeft(n);
		return right;
	}
	
	public AVLNode doubleLeftChild(AVLNode n) {
		n.setLeft(singleRightChild(n.getLeft()));
		return singleLeftChild(n);
	}
	
	public AVLNode doubleRightChild(AVLNode n) {
		n.setRight(singleLeftChild(n.getRight()));
		return singleRightChild(n);
	}
	
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
	
	// returns the height of the tree
	public int height() {
		return height(root);
	}
	
	// returns the height of the node
	public int height(AVLNode n) {
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
	
	
	// checks which one of the two inputs is the highest
	public int minimum(int a, int b) {
		if (a > b) {
			return b;
		}
		return a;
	}
	
	// checks which one of the two inputs is the highest
	public int maximum(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
	
	// returns the node with the minimum key of the subtree
	public AVLNode treeMinimum(AVLNode n) {
		while (n.getLeft() != null) {
			n = n.getLeft();
		}
		return n;
	}
	
	// returns the node with the maximum key of the subtree
	public AVLNode treeMaximum(AVLNode n) {
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n;
	}
	
	public int getBalance(AVLNode n) {
		if (n == null) {
			return 0;
		}
		return (height(n.getLeft()) - height(n.getRight()));
	}
	
	//counts the number of nodes in the tree
	public int countNodes()
	{
		return countNodes(root);
	}
	
	// help method to count the number of nodes with recursion
	private int countNodes(AVLNode n) {
		if (n == null) {
			return 0;
		}
		int temp = 1;
		temp += countNodes(n.getLeft());
		temp += countNodes(n.getRight());
		return temp;
	}
	
	// method to find an object in the tree
	public boolean search(Object k) {
		if (k instanceof Integer) {
			if (searchStudent((int)k, root) != null) {
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
	
	// help method to find a student in the tree with recursion
	private AVLNode searchStudent(int k, AVLNode n) {
		AVLNode found = null;
		while ((n != null)) {
			int key = (int)n.getKey();
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
	
	// help method to find a course in the tree with recursion
	private AVLNode searchCourse(String k, AVLNode n) {
		AVLNode found = null;
		
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
		
	// return String representation with keys and values of inorder traversal
	private void inorder() {
		inorder(root);
	}
	
	// help method for inorder traversal with recursion
	private void inorder(AVLNode n) {
		if (n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey() + " ");
			inorder(n.getRight());
		}
	}
	
	// return String representation with keys and values of preorder traversal
	private void preorder() {
		preorder(root);
	}
	
	// help method for preorder traversal with recursion
	private void preorder(AVLNode n) {
		if (n != null) {
			System.out.print(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	// return String representation with keys and values of postorder traversal
	private void postorder() {
		postorder(root);
	}
	
	// help method for postorder traversal recursion
	private void postorder(AVLNode n) {
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}
}
