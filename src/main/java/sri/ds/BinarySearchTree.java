package sri.ds;

public class BinarySearchTree {
	public class Node {
		Node left;
		Node right;
		private int val;
		
		public Node(int val) {
			left = right = null;
			this.val = val;
		}

		public int getVal() {
			return val;
		}

		
	}
	
	public Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node insert(int value){
		root = insertRec(root,value);
		return root;
	}

	private Node insertRec(Node root, int value) {
		if(null == root){
			root = new Node(value);
			return root;
		}
		else if(value < root.getVal()){
			root.left = insertRec(root.left, value);
		}
		else if(value > root.getVal()) {
			root.right = insertRec(root.right, value);
		}
		return root;
	}
	
	public void traverse(){
		System.out.println("Inorder:");
		inOrderRec(root);
		System.out.println("\nPreorder:");
		preOrderRec(root);
		System.out.println("\nPostorder:");
		postOrderRec(root);
	}
	
	private void inOrderRec(Node root){
		if(null != root){
			inOrderRec(root.left);
			System.out.println(root.getVal());
			inOrderRec(root.right);
		}
	}
	
	private void preOrderRec(Node root){
		if(null != root){
			System.out.println(root.getVal());
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	
	private void postOrderRec(Node root){
		if(null != root){
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.println(root.getVal());
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        tree.traverse();
	}

}
