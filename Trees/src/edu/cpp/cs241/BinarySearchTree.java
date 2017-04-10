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

	public TreeNode<Integer> findEntryNonRec(int dataToSearch) {
		return findEntryNonRec(root, dataToSearch);
	}

	// search an element using the non-recursive algorithm
	private TreeNode<Integer> findEntryNonRec(TreeNode<Integer> root, int dataToSearch) {
		TreeNode<Integer> cursor = root;
		while (cursor != null) {
			if (cursor.getData() == dataToSearch) {
				return cursor;
			}
			if (dataToSearch < cursor.getData()) {
				cursor = cursor.getLeftChild();
			} else {
				cursor = cursor.getRightChild();
			}
		}
		return null;
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

	public void removeEntry(int dataToRemove) {
		removeEntry(root, dataToRemove);
	}

	public void removeEntry(TreeNode<Integer> root, int dataToRemove) {
		TreeNode<Integer> cursor = root;
		TreeNode<Integer> parent = null;
		while(cursor != null && cursor.getData() != dataToRemove) {
			parent = cursor;
			if (dataToRemove < cursor.getData()) {
				cursor = cursor.getLeftChild();
			} else {
				cursor = cursor.getRightChild();
			}
		}

		if (cursor != null) {
			// is leaf
			if (cursor.isLeaf()) {
				if (parent.getLeftChild() == cursor) {
					parent.setLeftChild(null);
				} else {
					parent.setRightChild(null);
				}
			}
			// has only a left child
			else if (cursor.getLeftChild() != null && cursor.getRightChild() == null) {
				if (parent.getLeftChild() == cursor) {
					parent.setLeftChild(cursor.getLeftChild());
				} else {
					parent.setRightChild(cursor.getLeftChild());
				}
			}
			// has only a right child
			else if (cursor.getLeftChild() == null && cursor.getRightChild() != null) {
				if (parent.getLeftChild() == cursor) {
					parent.setLeftChild(cursor.getRightChild());
				} else {
					parent.setRightChild(cursor.getRightChild());
				}
			}
			// has both children
			else {
				TreeNode<Integer> node = cursor.getLeftChild().getRightMostNode();
				cursor.setData(node.getData());
				cursor.setLeftChild(cursor.getLeftChild().removeRightmost());
			}
		}
	}

}
