
public class LSInfoItem implements Comparable<LSInfoItem>{
    String LSTime;
    String LSAreas;
    String LSRawString;

    
    /** 
     * Takes on String LSLine (from textfile) and formats it into a LSInfoItem object
     */
    public LSInfoItem(String LSLine){
        this.LSRawString = LSLine;
        //Find position of last _ value
        int pos = LSLine.lastIndexOf("_");

        //copy from _ value +2 and store in LSTime
        this.LSTime = LSLine.substring(0,pos +3);
        if (LSLine.length() > pos + 3){
        //Store remaining info of LSLine into LSAreasDraft
        String LSAreasDraft = LSLine.substring(pos + 3);

        //Remove spaces of the location and store in LSAreas
        this.LSAreas = LSAreasDraft.replace(" ", "");
        }
        else{
            this.LSAreas = null;
        }
    }

    
    /** 
     * gets value stored in LSTime
     */
    public String getLSTime(){
        return LSTime;
    }

    
    /** 
     * gets value stored in LSAreas 
     */
    public String getLSAreas(){
        return LSAreas;
    }

    
    /** 
     * returns the LSInfoItem data in raw string form stored in LSRawString
     */
    public String getLSRawString(){
        return LSRawString;
    }


    
    /** 
     * takes in LSInfoItem as a parameter and compares it with the current LSInfoItem
     */
    public int compareTo(LSInfoItem item){
        String itemTime = item.LSTime;
        return itemTime.compareTo(LSTime);
    }

    
    /** 
     * returns LSInfoItem LSTime and LSArea in a readable string format
     */
    public String toString(){
        return formatLSTime() + System.lineSeparator() + "Areas: " +LSAreas + System.lineSeparator();
    }
    
    
    /** 
     * helper method to format LSTime into readable data for the user
     */
    private String formatLSTime(){
        int pos = LSTime.lastIndexOf("_");
        return "Stage: " + LSTime.charAt(0) + System.lineSeparator() + "Day: " + LSTime.substring(2, pos) + System.lineSeparator() + "Starting time: " + LSTime.substring(pos +1, pos+3) + "h00";

    }
}