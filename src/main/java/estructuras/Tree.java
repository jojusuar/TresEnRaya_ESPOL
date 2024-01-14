/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author euclasio
 */
public class Tree<E> {

    private TreeNode<E> root;
    private Comparator<E> cmp;

    public Tree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return root.isEmpty();
    }

    public List<Tree<E>> getSubtrees() {
        return root.getChildren();
    }

    public boolean isLeaf(E content) {
        TreeNode<E> node = this.getNode(content);
        return node.isEmpty();
    }

    public Comparator<E> getCmp() {
        return cmp;
    }

    public void setCmp(Comparator<E> cmp) {
        this.cmp = cmp;
    }

    private void setRootNode(TreeNode<E> treenode) {
        root = treenode;
    }

    public boolean add(E target, E content) {
        TreeNode<E> targetNode = getNode(target);
        if (targetNode == null) {
            System.out.println("Target not in tree");
            return false;
        }
        targetNode.addChildren(content);
        return true;
    }

    public void setRoot(E content) {
        if (isEmpty()) {
            setRootNode(new TreeNode<>(content));
        } else {
            root.setContent(content);
        }
    }

    public TreeNode<E> getNode(E content) {
        if (cmp.compare(root.getContent(), content) == 0) {
            return root;
        }
        List<Tree<E>> children = root.getChildren();
        if (!isLeaf()) {
            for (Tree<E> child : children) {
                child.setCmp(cmp);
                TreeNode<E> result = child.getNode(content);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    private TreeNode<E> getRootNode() {
        return root;
    }

    public E getRoot() {
        return root.getContent();
    }

    public List<E> iterativePreorderTraversal() {
        List<E> nodes = new LinkedList<>();
        if (root == null) {
            return nodes;
        }
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            nodes.add(current.getContent()); // Add the content to the result list
            if (!current.isEmpty()) {
                for (Tree<E> child : current.getChildren()) {
                    stack.push(child.root);
                }
            }
        }
        return nodes;
    }

    public int nodeChildCount(E content) {
        TreeNode<E> node = getNode(content);
        return node.childrenCount();
    }

    public List<E> getFirstLevel() {
        if (isEmpty()) {
            return null;
        }
        return root.getChildrenContent();
    }

    public String toString() {
        List<E> all = this.iterativePreorderTraversal();
        String representation = "";
        for (E element : all) {
            representation += element + "****************************\n";
        }
        return representation;
    }

}
