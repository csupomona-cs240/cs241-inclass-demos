package edu.cpp.cs241;

public class BinarySearchTreeTest2 {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(null);
		bst.addEntry(14);
		bst.addEntry(7);
		bst.addEntry(25);
		bst.addEntry(6);
		bst.addEntry(12);
		bst.addEntry(19);
		bst.addEntry(29);

		bst.findEntry(14).preOrderTraverse();

		BinarySearchTree bst2 = new BinarySearchTree(null);
		bst2.addEntryRec(14);
		bst2.addEntryRec(7);
		bst2.addEntryRec(25);
		bst2.addEntryRec(6);
		bst2.addEntryRec(12);
		bst2.addEntryRec(19);
		bst2.addEntryRec(29);

		bst2.findEntry(14).preOrderTraverse();
	}

}
