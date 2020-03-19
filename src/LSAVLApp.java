public class LSAVLApp{
    public static void main(String[] args) {
        AVLTree myAVL = new AVLTree();
        if (args.length == 0){
            System.out.println("No of  operations for insert: " + myAVL.getCounterInsert());
            /** 
            System.out.println ("Height : " + myTree.getHeight ());
            System.out.println ("Size : " + myTree.getSize ());
            System.out.println ("Inorder : ");
            myTree.inOrder ();
            System.out.println ("Preorder : ");
            myTree.preOrder ();
            System.out.println ("Postorder : ");
            myTree.postOrder ();
            System.out.println ("Level order : ");
            myTree.levelOrder ();}*/

        }
        else{
        //check if correct format
        if (args.length == 3){
            try{
                int num1 = Integer.parseInt(args[0]);
                int num2 = Integer.parseInt(args[1]);
                int num3 = Integer.parseInt(args[2]);

                myAVL.PrintAreas(args[0], args[1], args[2]);
                System.out.println("No of operations: " + myAVL.getCounterFind());

            }catch (NumberFormatException ex) {
                System.out.println("Error: input must be integer numbers");
            }
        } 
        else{
            System.out.println("Error: incorrect format");}
    } 
        myAVL.PrintAreas("1", "23", "00");
        System.out.println(myAVL.getCounterInsert());
        System.out.println(myAVL.getCounterFind());
    }
}