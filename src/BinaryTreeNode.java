

public class BinaryTreeNode
{
   LSInfoItem data;
   BinaryTreeNode left;
   BinaryTreeNode right;
   int height;
   /**sets node's data and what its left and right node are */
   public BinaryTreeNode ( LSInfoItem d, BinaryTreeNode l, BinaryTreeNode r )
   {
      data = d;
      left = l;
      right = r;
      height =0;
   }
   /**gets left node */
   BinaryTreeNode getLeft () { return left; }
   /**gets right node */
   BinaryTreeNode getRight () { return right; }

   
}
