import java.util.LinkedList;
import java.util.Queue;

public class Question9 {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(8);
		binaryTree.insert(3);
		binaryTree.insert(1);
		binaryTree.insert(6);
		binaryTree.insert(4);
		binaryTree.insert(7);
		binaryTree.insert(10);
		binaryTree.insert(14);
		binaryTree.insert(13);		

		Node node = binaryTree.getNode(null, 10);
		
		binaryTree.printTree(0);
		System.out.println("Numero de Niveis:" + binaryTree.getNumLevels());
		
		System.out.println("A soma do NÓ " + node.getValue() + " e dos nós subsequentes:" + binaryTree.sum(node));
	}
}

class BinaryTree {
	private Node root;
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public int getNumLevels() {
		return getNumLevels(this.root);
	}
	
	private int getNumLevels(Node root) {
		if (root == null) {
			return 0;
		} else {
			int numLeftLevels = getNumLevels(root.getLeft());
			int numRightLevels = getNumLevels(root.getRight());
			if (numLeftLevels > numRightLevels) {
				return numLeftLevels + 1;
			} else {
				return numRightLevels + 1;
			}
		}
	}
	
	public int getNumNode() {
		return getNumNode(root);
	}
	
	private int getNumNode(Node root) {
		if (root == null) {
			return 0;
		}
		int numNodeLeft  = getNumNode(root.getLeft()); 
		int numNodeRight = getNumNode(root.getRight());
		return numNodeLeft + numNodeRight + 1;
	}
	
	public void printTree(int printLevel) {
		if (this.root == null) {
			System.out.println("Arvore vazia");
		} else {
			printTree(this.root, 0, printLevel);
		}
	}
	
	public void printTree(Node node, int level, int printLevel) {		
		if (node.getLeft() != null) {
			printTree(node.getLeft(), level+1, printLevel);
		}
		if (node.getRight() != null) {
			printTree(node.getRight(), level+1, printLevel);
		}
		if (level >= printLevel) {
			System.out.print(node.getValue() + " ");
		}
	}
	
	public int sum(Node root) {
		if (root == null) {
			System.out.println("Arvore vazia");
			return -1;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		int totalSum = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			totalSum += node.value;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return totalSum;
	}
	
	public void insert(int value) {
		insert(this.root, value);
	}
	
	public void insert(Node node, int value) {
		if (this.root == null) {
			this.root = new Node(value);
		} else {
			if (value < node.getValue()) {
				if (node.getLeft() != null) {
					insert(node.getLeft(), value);
				} else {
					node.setLeft(new Node(value));
				}
			} else if (value > node.getValue()) {
				if (node.getRight() != null) {
					insert(node.getRight(), value);
				} else {
					node.setRight(new Node(value));
				}
			}
		}
	}

	public Node getNode(Node node, int value) {
		Node nodeR = null;
		if (node == null) {
			node = this.root;
		}
		
		if (value < node.getValue()) {
			if (node.getLeft() != null) {
				nodeR = getNode(node.getLeft(), value);
			} else {
				nodeR = node;
			}
		} else if (value > node.getValue()) {
			if (node.getRight() != null) {
				nodeR = getNode(node.getRight(), value);
			} else {
				nodeR = node;
			}
		} else {
			nodeR = node;
		}
		return nodeR;
			
	}
	
}

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node() {}
	
	public Node(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}	

    @Override
    public String toString() {
        return "Node [valor=" + value + "]";

    }
}
