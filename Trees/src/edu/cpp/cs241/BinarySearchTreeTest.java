package edu.cpp.cs241;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		TreeNode<Integer> node1 = new TreeNode<Integer>();
		node1.setData(30);

		TreeNode<Integer> node3 = new TreeNode<>(15);
		TreeNode<Integer> node4 = new TreeNode<>(55, null, null);
		TreeNode<Integer> node5 = new TreeNode<>(105);

		TreeNode<Integer> node2 = new TreeNode<Integer>(60, node4, node5);

		TreeNode<Integer> root = new TreeNode<Integer>(50, node1, node2);
		node1.setLeftChild(node3);

		BinarySearchTree bst = new BinarySearchTree(root);
		System.out.println(bst.findEntry(35));
		System.out.println(bst.findEntry(105));

		System.out.println(bst.findEntryNonRec(35));
		System.out.println(bst.findEntry(105));
	}

}
