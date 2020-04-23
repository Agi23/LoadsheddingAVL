import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;


class LSBSTApp{
    /**stores BinaryTree object of all the data */
    public static BinaryTree myTree;

    
    /** 
    *main method used to invoke a Binary Tree and facilitate outputting values and allowing a user to input a search
     */
    public static void main(String[] args) {
        myTree = new BinaryTree();
        if (args.length == 0){
            System.out.println("No of  operations for insert: " + myTree.getCounterInsert());
            
            System.out.println ("Height : " + myTree.getHeight ());
            System.out.println ("Size : " + myTree.getSize ());
            System.out.println ("Inorder : ");
            myTree.inOrder ();
            System.out.println ("Preorder : ");
            myTree.preOrder ();
            System.out.println ("Postorder : ");
            myTree.postOrder ();
            System.out.println ("Level order : ");
            myTree.levelOrder ();}

        
        else{
        //check if correct format
        if (args.length == 3){
            try{
                int num1 = Integer.parseInt(args[0]);
                int num2 = Integer.parseInt(args[1]);
                int num3 = Integer.parseInt(args[2]);

                myTree.PrintAreas(args[0], args[1], args[2]);
                System.out.println("No of operations: " + myTree.getCounterFind());

            }catch (NumberFormatException ex) {
                System.out.println("Error: input must be integer numbers");
            }
        } 
        else{
            System.out.println("Error: incorrect format");}
    } 
    
        }

    
}