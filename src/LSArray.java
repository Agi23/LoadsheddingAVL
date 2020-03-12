

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;


public class LSArray {
    /**stores value array of object LSInfoItem */
    public LSInfoItem[] arrInfoItems; 

    /**stores a formatted LSTime for what the user entered */
    public String usrLSTime;

    /**stores number of operations when searching for a data item */
    public int opCounterFind;
    
    /**stores number of operations when inserting all the data items */
    public int opCounterInsert;
    int k;
    
    /** 
     * gets value of opCounterFind
     */
    public int getCounterFind (){
        return opCounterFind; 
    }
    
    /** 
     * gets value of opCounterInsert
     */
    public int getCounterInsert(){
        return opCounterInsert;
    }
    
    /** 
     * Loops through the entire array of items and prints their details 
     */
    public void PrintAllAreas(){
        //for loop and print out every item using toString
        for (LSInfoItem num: arrInfoItems){
            System.out.println(num.toString());
        }
        
    }

    
    /** 
     * Takes in a stage,day and start time from wht the user entered and searches for the corresponding area codes
     */
    public void PrintAreas(final String stage, final String day, final String startTime) {
        // change format
        usrLSTime = stage + '_' + day + "_"+ startTime;
        //boolean Found = false;
        opCounterFind = 0;

        // for loop through array + compareTo
        for (LSInfoItem b : arrInfoItems)
        {   opCounterFind++;
            if (b.getLSTime().compareTo(usrLSTime) == 0 ){
                System.out.println(b.toString());
                System.out.println("Data point has been found");
                //System.exit(0);
                return;  
            }
        }
        // if found: return areas
        // if not found: display error message
        System.out.println("No item found");
    }

    
    /** 
     * helper method to declare array of type InfoItem of size 2976 and sends command to read LSData.txt
     */
    private void initialise() {
        arrInfoItems = new LSInfoItem[2976];
        ReadFile("LSData.txt");
    }
    
    /** 
    * Takes in a textfile name as a parameter. Using the name of the textfile it creates an array of appripriate size and then sends a command to read the given textfile into the array
     */
    public LSArray(String txtfile){
        opCounterInsert=0;
        int pos = txtfile.lastIndexOf(".");
        int size = Integer.valueOf(txtfile.substring(4,pos));
        arrInfoItems = new LSInfoItem[size];
        ReadFile(txtfile);
    }
    
    /** 
     * General constructor used to enter all the data into an array and print out all the information
     */
    public LSArray() {
        opCounterInsert=0;
        initialise();
        PrintAllAreas();
    }
    
    /** 
    * This constructor is only used by testGen class which enables the array to only be initialised
     */
    public LSArray(boolean test){
        opCounterInsert=0;
        initialise();
    }
    
    /** 
    * Takes in a stage, day and start time and sends command to search for this item
     */
    public LSArray(final String stage, final String day, final String startTime) {
        opCounterInsert=0;
        initialise();
        PrintAreas(stage, day, startTime);
        
    }
    
    /** 
     * returns entire arrInfoItems which is used in the testGen class
     */
    public LSInfoItem[] getArray(){
        return arrInfoItems;
        
    }
    
    /** 
    * Takes a name of textfile as a string parameter and reads the data in that file and places it in an array (arrInfoItems) 
     */
    public void ReadFile(String txtfile) {
        String line;
        String pathToFile = txtfile;
        BufferedReader fin = null;
        
        k = 0;
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)));
            do {
                line = fin.readLine();
                //System.out.println(k);
                

                // System.out.println(line);
                if (line == null) // Checks if you reached end of file
                    break; // Exits the loop if end of file reached
                else{
                    opCounterInsert++;
                    arrInfoItems[k] = new LSInfoItem(line);
                    k=k+1;
                }
                   
                // TO DO CODE
            } while (line != null);
            fin.close(); // Close the stream
        } catch (final IOException e)
        {
        System.out.println(e.getMessage() +"\nProgram will be aborted");
        System.exit(0);
        }

      
        

    }


}