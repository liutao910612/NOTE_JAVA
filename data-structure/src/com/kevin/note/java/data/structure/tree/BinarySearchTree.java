package com.kevin.note.java.data.structure.tree;

/**
 * 二叉查找树示例
 *
 * @Author:Kevin
 * @Date:Created in 11:12 2021/3/21
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;

        while (p != null) {
            if (p.data == data) {
                return p;
            }
            p = data < p.data ? p.left : p.right;
        }

        return null;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}


