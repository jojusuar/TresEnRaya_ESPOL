/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author euclasio
 */
public class Tree<E>{
    private TreeNode<E> root;

    public Tree() {
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public boolean isLeaf(){
        return root.isEmpty();
    }
    
    private void setRootNode(TreeNode<E> treenode){
        root = treenode;
    }
    
    public void setRoot(E content){
        root.setContent(content);
    }
    
    private TreeNode<E> getRootNode(){
        return root;
    }
    
    private E getRoot(){
        return root.getContent();
    }
    
} 
