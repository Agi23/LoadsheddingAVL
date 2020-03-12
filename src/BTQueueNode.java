

public class BTQueueNode
{
   BinaryTreeNode node;
   BTQueueNode next;
   
   
   /** 
    * sets value of current node and the next node 
    */
   public BTQueueNode ( BinaryTreeNode n, BTQueueNode nxt )
   {
      node = n;
      next = nxt;
   }
}
