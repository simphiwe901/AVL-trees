/** Hussein's AVL Tree
* 2 April 2017
* @author Hussein Suleman
* reference: kukuruku.co/post/avl-trees
*/


import java.io.*;
import java.util.*;

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }

   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }

   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }

   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }

   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( dataType k, dataType d )
   {
      root = insert (k, d, root);
   }
   public BinaryTreeNode<dataType> insert (dataType k, dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (k,d, null, null);
      if (k.compareTo (node.key) <= 0)
         node.left = insert (k,d, node.left);
      else
         node.right = insert (k,d, node.right);
      return balance (node);
   }



   public BinaryTreeNode<dataType> find ( dataType k )
   {
      if (root == null)
         return null;
      else
         return find (k, root);
   }
   public BinaryTreeNode<dataType> find ( dataType k, BinaryTreeNode<dataType> node )
   {
      if (k.compareTo (node.key) == 0)
         return node;
      else if (k.compareTo (node.key) < 0)
         return (node.left == null) ? null : find (k, node.left);
      else
         return (node.right == null) ? null : find (k, node.right);
   }

   public void treeOrder()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}
