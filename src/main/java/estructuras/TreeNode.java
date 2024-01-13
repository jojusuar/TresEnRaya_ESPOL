/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author euclasio
 */
public class TreeNode<E> {

    private E content;
    private List<Tree<E>> children;

    public TreeNode(E content) {
        this.content = content;
        children = new LinkedList<>();
    }

    public boolean isEmpty() {
        return childrenCount() == 0;
    }

    public int childrenCount() {
        return children.size();
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public boolean addChildren(E content) {
        Tree<E> subtree = new Tree<>();
        subtree.setRoot(content);
        children.add(subtree);
        return true;
    }

    public void setChildren(List<Tree<E>> children) {
        this.children = children;
    }
    
    public String toString(){
        return content.toString();
    }
}
