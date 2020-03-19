import java.util.Collections;
import java.util.Random; 
import java.util.concurrent.ThreadLocalRandom;
 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class testGen{


    
    /** 
    * generates 10 textfiles of varying lengths from random items of LSData.txt
     */
    public static void main(String[] args) {
        //get entire array
        LSArray Data = new LSArray(true);
        LSInfoItem[] arrTotalItems = Data.getArray();
        int[] testValues = {297,594,891,1188,1485,1782,2079,2376,2673, 2976};

        for (int i: testValues) {
            shuffleArray(arrTotalItems);
            String fileName = "data" + Integer.toString(i) + ".txt";
            try {
                FileWriter writer = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for (int k = 0; k<i; k++){
                    bufferedWriter.write(arrTotalItems[k].getLSRawString());
                    bufferedWriter.newLine();
                }
     
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();}
            
          }
          
          

    }

    
    /** 
     * rearranges all the items in the array in a random order
     */
    static void shuffleArray(LSInfoItem[] ar)
    {
      Random rnd = ThreadLocalRandom.current();
      for (int i = ar.length - 1; i > 0; i--)
      {
        int index = rnd.nextInt(i + 1);
        // Simple swap
        LSInfoItem a = ar[index];
        ar[index] = ar[i];
        ar[i] = a;
      }
    }

  }

