package extra_assignment;

public class AvlNode {
	
	/** Attributes */
	private Object key;
	private Object value;
	private AvlNode parent;
	private AvlNode left;
	private AvlNode right;
	
	
	/** Constructor */
	public AvlNode (Object k, Object v, AvlNode pt, AvlNode lt, AvlNode rt) {
		key = k;
		value = v;
		parent = pt;
		left = lt;
		right = rt;
	}
	
	
	/** Methods */
	public void setKey(Object k) { key = k; }
	
	public Object getKey() { return key; }
	
	public void setValue(Object v) { value = v; }
	
	public Object getValue() { return value; }
	
	public void setParent(AvlNode pt) { parent = pt; }
	
	public AvlNode getParent() { return parent; }
	
	public void setLeft(AvlNode lt) { 
		left = lt;
		lt.setParent(this);
		}
	
	public AvlNode getLeft() { return left; }
	
	public void setRight(AvlNode rt) { 
		right = rt;
		rt.setParent(this);
		}
	
	public AvlNode getRight() { return right; }
	
	public String toString() {
		return "<AVLNode(" + key + ")>";
	}
}
