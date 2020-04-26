
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class BinaryTree
{  /**stores root of Binary Tree */
   BinaryTreeNode root;
   /**counts number of operations for searching */
   int opCounterFind;
   /**counts number of operations for inserting */
   int opCounterInsert;
   
   
   /** 
    * generates binary tree with all data items
    */
   public BinaryTree ()
   {
      root = null;
      opCounterFind =0;
      opCounterInsert =0;
      ReadFile("LSData.txt");
   }

   
   /** 
    * generates binary tree of data stored in a textfile. The textfile's name is passed as a paameter
    */
   public BinaryTree(String txtfile){
      opCounterInsert =0;
      root = null;
      ReadFile(txtfile);
   }

   
   /** 
    * reads in data stored in textfile and inserts it into the Binary Tree. Textfile's name is passed as a string. 
    */
   public void ReadFile(String txtfile){
      opCounterInsert =0;
      LSInfoItem curItem;
        //Read in file into binary tree
        String line;
        String pathToFile = txtfile;
        BufferedReader fin = null;
        
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)));
            do {
                line = fin.readLine();
                //System.out.println(k);
                    
    
                // System.out.println(line);
                if (line == null) // Checks if you reached end of file
                    break; // Exits the loop if end of file reached
                else{
                    curItem = new LSInfoItem(line);
                    insert(curItem);
                }
                   
            }
            while (line != null);
            fin.close(); // Close the stream
        }       
                
        catch (final IOException e){
            System.out.println(e.getMessage() +"\nProgram will be aborted");
            System.exit(0);
        }
}
   
   /** 
    * Initial search method used to search for a LSInfoItem in the tree
    */
   public BinaryTreeNode find ( LSInfoItem d )
   {  
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
   /** 
    * Secondary search method used recursively to find the LSInfoItem
    */
   public BinaryTreeNode find ( LSInfoItem d, BinaryTreeNode node )
   {  opCounterFind++;
      int cmp = d.compareTo (node.data);
      if (cmp == 0)
         return node;
      else if (cmp < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }

   
   /** 
    * returns opCounterFind and resets
    */
   public int getCounterFind(){
     int out = opCounterFind;
     opCounterFind = 0;
     return out;
   }
   
   /** 
    * returns opCounterInsert and resets
    */
   public int getCounterInsert(){
      int out = opCounterInsert;
      opCounterInsert =0;
      return out;
      }
   
   /** 
     * Takes in a stage,day and start time from wht the user entered and searches for the corresponding area codes in the tree
     */
   public void PrintAreas(final String stage, final String day, final String startTime){
      String usrLSTime = stage + '_' + day + "_"+ startTime;
      LSInfoItem finding = new LSInfoItem(usrLSTime);

      BinaryTreeNode found = find(finding);
      if (found == null)
         System.out.println("Item not found");
      else{
         System.out.println("Data item was found");
         visit(found);
      }


   }

   
   /** 
    * inserts LSInfoItem into the BST
    */
   public BinaryTreeNode insert(LSInfoItem d, BinaryTreeNode node){
      opCounterInsert++;
      if (d.compareTo(node.data)  <= 0){
         if (node.left == null)
            node.left = new BinaryTreeNode(d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode (d, null, null);
         else
            insert (d, node.right);
      }  
      return node;


   }
   
   /** 
    * Primary insertion function to facillitate BinaryTreeNode root for the next insert method
    */
   public void insert(LSInfoItem d){
         if (root == null)
            root = new BinaryTreeNode (d, null, null);
         else
            insert(d, root);
   }
 
   
   
   /** 
    * returns height of root
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   
   /** 
    * returns height of a particular BinaryTreeNode
    */
   public int getHeight ( BinaryTreeNode node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   
   /** 
    * returns size of BinaryTree
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   
   /** 
    * returns size of particular BinaryTreeNode 
    */
   public int getSize ( BinaryTreeNode node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   
   /** 
    * prints out data stored in particular BinaryTreeNode 
    */
   public void visit ( BinaryTreeNode node )
   {
      System.out.println (node.data);
   }
   
   
   /** 
    * preOrder traversal
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   
   /** 
    * preOrder traversal of particular BinaryTreeNode
    */
   public void preOrder ( BinaryTreeNode node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   
   /** 
    * postOrder traversal of BST
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   
   /** 
    * postOrder traversal of particular BinaryTreeNode
    */
   public void postOrder ( BinaryTreeNode node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   
   /** 
    * inOrder traversal of BST 
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   
   /** 
    * inOrder traversal of particular BinaryTreeNode
    */
   public void inOrder ( BinaryTreeNode node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   
   /** 
    * level order traversal of tree
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue q = new BTQueue ();
      q.enQueue (root);
      BinaryTreeNode node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }

   
   /** 
    * outputssss all traversals of the data stored in the tree
    */
   public void PrintAllAreas(){
      System.out.println ("Height : " + getHeight ());
      System.out.println ("Size : " + getSize ());
      System.out.println ("Inorder : ");
      inOrder ();
      System.out.println ("Preorder : ");
      preOrder ();
      System.out.println ("Postorder : ");
      postOrder ();
      System.out.println ("Level order : ");
      levelOrder ();}
   }

