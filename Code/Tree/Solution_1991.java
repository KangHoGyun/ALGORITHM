package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1991 {
	static int N;
	static class Node {
		Node left, right;
		char data;

		public Node(char data) {
			this.data = data;
		}
	}

	static class Tree {
		Node root;

		public void add(char left, char data, char right) {
			if (root == null) {
				if (data != '.')
					root = new Node(data);
				if (left != '.')
					root.left = new Node(left);
				if (right != '.')
					root.right = new Node(right);
			} else {
				search(root, left, data, right);
			}
		}

		public void search(Node root, char left, char data, char right) {
			if (root == null) {
				return;
			} else if (root.data == data) {
				if (left != '.')
					root.left = new Node(left);
				if (right != '.')
					root.right = new Node(right);
			} else {
				search(root.left, left, data, right);
				search(root.right, left, data, right);
			}
		}

		public void preorder(Node root) {
			System.out.print(root.data);
			if (root.left != null)
				preorder(root.left);
			if (root.right != null)
				preorder(root.right);
		}

		public void inorder(Node root) {
			if (root.left != null)
				inorder(root.left);
			System.out.print(root.data);
			if (root.right != null)
				inorder(root.right);
		}

		public void postorder(Node root) {
			if (root.left != null)
				postorder(root.left);
			if (root.right != null)
				postorder(root.right);
			System.out.print(root.data);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		Tree t = new Tree();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			t.add(left, data, right);
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		System.out.println();
	}
}
