package com.njupt.tree;

public class Tree<T> {
    private TreeNode<T> root;

    Tree(){

    }

    Tree(T data){
        //单节点的树
        this.root = new TreeNode<>(data);
    }

    Tree(T data, TreeNode left, TreeNode right){
        this.root = new TreeNode<>(data, left, right);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public void preOrder(TreeNode root){
        if(root == null)    return;
        System.out.println(this.root.getData());
        preOrder(this.root.getLeft());
        preOrder(this.root.getRight());
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(5);
        tree.getRoot().setLeft(new TreeNode<>(10));
        tree.getRoot().setRight(new TreeNode<>(15));
//        tree.preOrder(tree.getRoot());
    }

}
