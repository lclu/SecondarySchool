package extra_assignment;

public class AVLNode {
	
	/** Attributes */
	private Object key;
	private Object value;
	private AVLNode parent;
	private AVLNode left;
	private AVLNode right;
	
	
	/** Constructor */
	public AVLNode (Object k, Object v, AVLNode lt, AVLNode rt) {
		key = k;
		value = v;
		//parent = pt;
		left = lt;
		right = rt;
	}
	
	
	/** Methods */
	public void setKey(Object k) { key = k; }
	
	public Object getKey() { return key; }
	
	public void setValue(Object v) { value = v; }
	
	public Object getValue() { return value; }
	
	public void setParent(AVLNode pt) { parent = pt; }
	
	public AVLNode getParent() { return parent; }
	
	public void setLeft(AVLNode lt) { left = lt; }
	
	public AVLNode getLeft() { return left; }
	
	public void setRight(AVLNode lt) { right = lt; }
	
	public AVLNode getRight() { return right; }
	
	public String toString() {
		return "<AVLNode(" + key + ")>";
	}
}
