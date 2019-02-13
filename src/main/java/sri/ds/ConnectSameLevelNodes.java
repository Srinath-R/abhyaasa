package sri.ds;


public class ConnectSameLevelNodes {
	private class Node {
		int data;
		Node left,right;
		Node nextRight;
		Node(int item){
			data = item;
			left=null;
			right=null;
			nextRight=null;
		}
	}
	
	Node tree;
	
	private Node insertLeft(Node t,int item){
		if(null != t.left){
			t.left = insertLeft(t.left, item);
		}
		else {
			t.left = new Node(item);
		}
		return t;
	}
	
	private Node insertRight(Node t,int item){
		if(null != t.right){
			t.right = insertRight(t.right, item);
		}
		else {
			t.right = new Node(item);
		}
		return t;
	}

	public static void main(String[] args) {
		new ConnectSameLevelNodes().start();
	}

	private void start() {
		tree = new Node(10);
		tree.left = new Node(3);
		tree.right = new Node(5);
		tree.left.left = new Node(4);
		tree.left.right = new Node(1);
		tree.right.right = new Node(2);
		
		tree = connect(tree);
		System.out.println("Test");
	}

	private Node connect(Node t) {
		if(null != t && null!=t.left){
			t.left.nextRight = (null != t.right) ? t.right :
				connectRight(t.nextRight);
		}
		if(null != t && null!=t.right){
			t.right.nextRight = connectRight(t.nextRight);
		}
		if(null != t){
			t.left = connect(t.left);
			t.right = connect(t.right);
		}
		
		return t;
	}

	private Node connectRight(Node right) {
		if(null != right && null!=right.left)
			return right.left;
		else if(null != right && null!=right.right)
			return right.right;
		return null;
	}

}
