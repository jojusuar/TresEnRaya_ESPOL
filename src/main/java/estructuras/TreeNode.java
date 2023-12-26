/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author euclasio
 */
public class TreeNode<E> {

    private E content;
    private Tree<E>[] children;
    private int effectiveSize;
    private int capacity = 100;

    public TreeNode(E content) {
        this.content = content;
        children = (Tree<E>[]) new Object[capacity];
        effectiveSize = 0;
    }

    private void addCapacity() {
        capacity = capacity * 2;
        Tree<E>[] temp = (Tree<E>[]) new Object[capacity];
        System.arraycopy(children, 0, temp, 0, effectiveSize);
        children = temp;
    }
    
    public boolean isEmpty(){
        return childrenCount()==0;
    }
    
    public int childrenCount(){
        return effectiveSize;
    }
    
    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public Tree<E>[] getChildren() {
        return children;
    }

    public boolean addChildren(Tree<E> subtree) {
        if(subtree==null){
            return false;
        }
        if(this.effectiveSize>=capacity){
            addCapacity();
        }
        children[effectiveSize-1] = subtree;
        effectiveSize++;
        return true;
    }
    
    public void setChildren(Tree<E>[] children){
        this.children = children;
    }
}
