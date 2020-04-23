// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree extends BinaryTree
{  

   public AVLTree(String txtfile){
      super(txtfile);
   }

   public AVLTree(){
      super();
   }

   
   /** Helper method for height
    * @param node
    * @return int
    */
   public int height (BinaryTreeNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   
   /** calculates difference in height of left tree and right tree and returns what is called a balance factor
    * @param node tree that needs to be balanced
    * @return int balance factor adjustment needed
    */
   public int balanceFactor ( BinaryTreeNode  node )
   {
      return height (node.right) - height (node.left);
   }
   
   
   /** Calculates the required height the tree needs to be once operations are complete by taking the max height of either the left or right treee
    * @param node tree that this function needs to be applied
    */
   public void fixHeight ( BinaryTreeNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   
   /** Performs a rotation to the right
    * @param p the tree that the rotation needs to be applied to
    * @return BinaryTreeNode the tree after rotation to the right has been completed
    */
   public BinaryTreeNode rotateRight ( BinaryTreeNode p )
   {
      BinaryTreeNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   
   /** Performs a rotation to the left
    * @param q the tree that the rotation needs to be applied to
    * @return BinaryTreeNode the tree after rotation to the left has been completed
    */
   public BinaryTreeNode rotateLeft ( BinaryTreeNode q )
   {
      BinaryTreeNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   
   /** Adjusts the placement of nodes in the Binary Tree so as to satisfy AVL balancing conditions
    * @param p the tree that the balancing needs to be applied
    * @return BinaryTreeNode the new tree after the balancing has occured
    */
   public BinaryTreeNode balance ( BinaryTreeNode p )
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

   
   /** Helper method for insetions
    * @param d the itme that needs to be inserted
    */
   public void insert ( LSInfoItem d )
   {
      root = insert (d, root);
   }
   
   /** Insertion function: adds data item to the treee
    * @param d the data item that needs to be inserted
    * @param node the root node used as reference
    * @return BinaryTreeNode the new tree after with the inserted item
    */
   public BinaryTreeNode insert (LSInfoItem d, BinaryTreeNode node )
   {
      opCounterInsert++;
      if (node == null)
         return new BinaryTreeNode (d, null, null);
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   
   
   /** Helper method for deletion
    * @param d item that needs to be deleted
    */
   public void delete ( LSInfoItem d )
   {
      root = delete (d, root);
   }   
   
   /** Deletion function: finds the node in the tree with the specific data item and deletes it from the tree
    * @param d the data item that needs to be deleted
    * @param node the root of the tree as reference
    * @return BinaryTreeNode the new tree after deletion has occured
    */
   public BinaryTreeNode delete ( LSInfoItem d, BinaryTreeNode node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode q = node.left;
         BinaryTreeNode r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   
   /** Finds the smallest data value (most left value) and returns the node
    * @param node the root of the tree needed to be searched
    * @return BinaryTreeNode the most left node (min)
    */
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   
   /** Removes left most node from tree
    * @param node the root of the tree that needs this function performed
    * @return BinaryTreeNode the new tree after the left most item has been removed
    */
   public BinaryTreeNode removeMin ( BinaryTreeNode node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   
   /** Helper method for function that searches for the node with a given info
    * @param d the LSInfoItem object that needs to be found
    * @return BinaryTreeNode the node that contains the specified LSInfoItem 
    */
   public BinaryTreeNode find ( LSInfoItem d )
   {  
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
   /** Searches for the item in the tree given by its root node
    * @param d the data item needed to be found
    * @param node the root of the tree that needs to be searched
    * @return BinaryTreeNode the node containing the data item specified
    */
   public BinaryTreeNode find ( LSInfoItem d, BinaryTreeNode node )
   {  opCounterFind++;
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   
   /** 
    * @param node
    * @param level
    */
   public void treeOrder ( BinaryTreeNode node, int level )
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

