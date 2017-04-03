package edu.cpp.cs241;

public class TreeNodeTest {

	public static void main(String[] args) {
		// create TreeNode
		TreeNode<Integer> root = new TreeNode<Integer>();
		root.setData(50);

		TreeNode<Integer> left = new TreeNode<Integer>();
		left.setData(10);
		TreeNode<Integer> right = new TreeNode<Integer>();
		right.setData(30);

		root.setLeftChild(left);
		root.setRightChild(right);

		System.out.println(root.getData());
		System.out.println(root.getLeftChild().getData());
		System.out.println(root.getRightChild().getData());

		// create TreeNode using constructors
		TreeNode<Integer> tn2 = new TreeNode<Integer>(70);
		TreeNode<Integer> tn3 = new TreeNode<Integer>(80);
		TreeNode<Integer> tnRoot = new TreeNode<Integer>(60, tn2, tn3);
		System.out.println(tnRoot.getData());
		System.out.println(tnRoot.getLeftChild().getData());
		System.out.println(tnRoot.getRightChild().getData());

		tn2.setLeftChild(new TreeNode<Integer>(10));
		tn2.setRightChild(new TreeNode<Integer>(20));
		tn3.setLeftChild(new TreeNode<Integer>(100));
		tn3.setRightChild(new TreeNode<Integer>(200));

		System.out.println("Preorder Traversal");
		tnRoot.preOrderTraverse();

		TreeNode<Integer> newTree = tnRoot.copy();
		System.out.println("Inorder Traversal");
		newTree.inorderTraverse();

		System.out.println("Number of nodes: " + tnRoot.getNumberOfNodes());
		System.out.println("Height: " + tnRoot.getHeight());
		System.out.println("Leftmost data: " + tnRoot.getLeftMostData());
		System.out.println("Rightmost data: " + tnRoot.getRightMostData());

		tnRoot.removeLeftmost();
		tnRoot.removeRightmost();
		System.out.println("Preorder Traversal");
		tnRoot.preOrderTraverse();
	}

}
