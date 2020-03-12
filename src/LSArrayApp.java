

public class LSArrayApp {
    /**stores LSArray object of the data */
    public static LSArray ArrayData;

    
    /** 
    * main method used to invoke an LSArray and facilitate outputting values and allowing a user to input a search
     */
    public static void main(String[] args) {
        
        if (args.length == 0){
            ArrayData = new LSArray();
            System.out.println("No of operations: " + ArrayData.getCounterInsert());
    }
        else{
            //check if correct format
            if (args.length == 3){
                try{
                    int num1 = Integer.parseInt(args[0]);
                    int num2 = Integer.parseInt(args[1]);
                    int num3 = Integer.parseInt(args[2]);

                    ArrayData = new LSArray(args[0], args[1], args[2]);
                    System.out.println("No of operations: " + ArrayData.getCounterFind());

                }catch (NumberFormatException ex) {
                    System.out.println("Error: input must be integer numbers");
                }
                
            } 
            else{
                System.out.println("Error: incorrect format");}
                ArrayData = null;
        }
         
    } 
     

}