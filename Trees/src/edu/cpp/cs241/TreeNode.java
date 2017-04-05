package edu.cpp.cs241;

import java.util.Stack;

public class TreeNode<T> {

	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;

	TreeNode() {

	}

	TreeNode (T data) {
		this.data = data;
	}

	TreeNode (T data, TreeNode<T> leftChild, TreeNode<T> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public boolean isLeft() {
		return this.leftChild == null && this.rightChild == null;
	}

	public void preOrderTraverse() {
		preorderTraverse(this);
	}

	private void preorderTraverse(TreeNode<T> root) {
		if (root != null) {
			System.out.println(root.getData());
			preorderTraverse(root.getLeftChild());
			preorderTraverse(root.getRightChild());
		}
	}

	public void preOrderTraverseNonRec() {
		Stack<TreeNode<T>> stack = new Stack<>();
		stack.push(this);
		while(!stack.isEmpty()) {
			TreeNode<T> currentNode = stack.pop();
			System.out.println(currentNode.getData());
			if (currentNode.getRightChild() != null) {
				stack.push(currentNode.getRightChild());
			}
			if (currentNode.getLeftChild() != null) {
				stack.push(currentNode.getLeftChild());
			}
		}
	}

	public void inorderTraverse() {
		inorderTraverse(this);
	}

	private void inorderTraverse(TreeNode<T> root) {
		if (root != null) {
			preorderTraverse(root.getLeftChild());
			System.out.println(root.getData());
			preorderTraverse(root.getRightChild());
		}
	}

	public TreeNode<T> copy() {
		TreeNode<T> newNode = new TreeNode<T>(data);
		if (leftChild != null) {
			newNode.setLeftChild(leftChild.copy());
		}
		if (rightChild != null) {
			newNode.setRightChild(rightChild.copy());
		}
		return newNode;
	}

	public int getNumberOfNodes() {
		int numberOfLeftNodes = 0;
		int numberOfRightNodes = 0;
		if (leftChild != null) {
			numberOfLeftNodes = leftChild.getNumberOfNodes();
		}
		if (rightChild != null) {
			numberOfRightNodes = rightChild.getNumberOfNodes();
		}
		return numberOfLeftNodes + numberOfRightNodes + 1;
	}

	public int getHeight() {
		return getHeight(this);
	}

	private int getHeight(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(
				getHeight(root.getLeftChild()),
				getHeight(root.getRightChild()));
	}

	public T getLeftMostData() {
		if (leftChild != null) {
			return leftChild.getLeftMostData();
		} else {
			return data;
		}
	}

	public T getRightMostData() {
		if (rightChild != null) {
			return rightChild.getRightMostData();
		} else {
			return data;
		}
	}

	public TreeNode<T> removeLeftmost() {
		if (leftChild == null) {
			return rightChild;
		} else {
			leftChild = leftChild.removeLeftmost();
			return this;
		}
	}

	public TreeNode<T> removeRightmost() {
		if (rightChild == null) {
			return leftChild;
		} else {
			rightChild = rightChild.removeRightmost();
			return this;
		}
	}

}
