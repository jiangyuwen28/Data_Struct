package com.njupt.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode root){
        if(root == null)    return;
        inOrder(root.getLeft());
        System.out.println(root.getData());
        inOrder(root.getRight());
    }

    public void lastOrder(TreeNode root){
        if(root == null)    return;
        lastOrder(root.getLeft());
        lastOrder(root.getRight());
        System.out.println(root.getData());
    }


    public List<Integer> levelOrder(TreeNode root){
        //Deque<TreeNode> stack = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            list.add((Integer) t.getData());
            if(t.getLeft() != null) queue.offer(t.getLeft());
            if(t.getRight() != null)    queue.offer(t.getRight());


        }
        return list;

    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(5);
        tree.getRoot().setLeft(new TreeNode<>(10));
        tree.getRoot().setRight(new TreeNode<>(15));
        tree.preOrder(tree.getRoot());
        List<Integer> ans = tree.levelOrder(tree.getRoot());
        for(Integer i : ans){
            System.out.println(i);
        }

    }

}
