package edu.cpp.cs241;

public class BinarySearchTree {

	private TreeNode<Integer> root;

	public BinarySearchTree(TreeNode<Integer> root) {
		this.root = root;
	}

	public TreeNode<Integer> findEntry(int dataToSearch) {
		return findEntry(root, dataToSearch);
	}

	private TreeNode<Integer> findEntry(TreeNode<Integer> root, int dataToSearch) {
		if (root == null) {
			return null;
		}
		if (root.getData() == dataToSearch) {
			return root;
		} else if (dataToSearch < root.getData()) {
			return findEntry(root.getLeftChild(), dataToSearch);
		} else {
			return findEntry(root.getRightChild(), dataToSearch);
		}
	}

	public void addEntry(int dataToAdd) {
		TreeNode<Integer> newNode = new TreeNode<Integer>(dataToAdd);
		// find position to add
		TreeNode<Integer> cursorNode = root;
		TreeNode<Integer> prevNode = null;
		while(cursorNode != null) {
			prevNode = cursorNode;
			if (dataToAdd <= cursorNode.getData()) {
				cursorNode = cursorNode.getLeftChild();
			} else {
				cursorNode = cursorNode.getRightChild();
			}
		}
		// add
		if (prevNode == null) {
			root = newNode;
		} else {
			if (dataToAdd <= prevNode.getData()) {
				prevNode.setLeftChild(newNode);
			} else {
				prevNode.setRightChild(newNode);
			}
		}
	}

	public void addEntryRec(int dataToAdd) {
		if (root == null) {
			root = new TreeNode<Integer>(dataToAdd);
		} else {
			addEntryRec(root, dataToAdd);
		}
	}

	private void addEntryRec(TreeNode<Integer> root, int dataToAdd) {
		if (dataToAdd <= root.getData()) {
			if (root.getLeftChild() == null) {
				root.setLeftChild(new TreeNode<Integer>(dataToAdd));
			} else {
				addEntryRec(root.getLeftChild(), dataToAdd);
			}
		} else {
			if (root.getRightChild() == null) {
				root.setRightChild(new TreeNode<Integer>(dataToAdd));
			} else {
				addEntryRec(root.getRightChild(), dataToAdd);
			}
		}
	}
}
