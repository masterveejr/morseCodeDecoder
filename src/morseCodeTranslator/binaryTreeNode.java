package morseCodeTranslator;

public class binaryTreeNode{
	protected Object info;
	protected binaryTreeNode parent;
	protected binaryTreeNode left;
	protected binaryTreeNode right;
	
	public binaryTreeNode getLeft() {//gets leftnode
		return left;
	}
	public void setLeft(binaryTreeNode left) {//sets the left node
		this.left = left;
	}
	public binaryTreeNode getRight() {//gets the right node
		return right;
	}
	public void setRight(binaryTreeNode right) {//sets the right node
		this.right = right;
	}
	public Object getInfo() {//gets the info of the node
		return info;
	}
	public binaryTreeNode (Object info){//constructor
		this.info = info;
		left = null;
		right = null;
	}
	public void setInfo(Object info){//sets info for the node
		this.info = info;
	}
	public boolean hasLeft(){//checks if theres a left node
		return (left != null);
	}
	public boolean hasRight(){//checks if theres a right node
		return (right != null);
	}
	public binaryTreeNode getParent() {//gets parent node
		return parent;
	}
	public void setParent(binaryTreeNode parent) {//sets parent node
		this.parent = parent;
	}
}
