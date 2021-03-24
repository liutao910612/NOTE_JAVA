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

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        //Don't find
        if (p == null) {
            return;
        }

        //Node will be deleted have two nodes
        if (p.left != null && p.right != null) {
            Node minP = p.left;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        Node child = null;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
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


