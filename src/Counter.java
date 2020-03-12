class Counter{
    int ArrayFind;
    int ArrayInsert;
    int BSTFind;
    int BSTInsert;
    int iternum;


    
    /** 
     * initialises a counter object with the position (iteration number) of the data that is being searched
     */
    public Counter(int itnum){
        this.ArrayFind = 0;
        this.BSTFind = 0;
        this.iternum = itnum;
    }
    
    /** 
     * generic initialising object
     */
    public Counter(){
        BSTInsert =0;
        ArrayInsert=0;
    }
    
    /** 
     * sets ArrayFind
     */
    public void setArrayFind(int count){
        ArrayFind = count;
    }

    
    /** 
     * setsvBSTFind
     */
    public void setBSTFind(int count){
        BSTFind = count;
    }

    
    /** 
     * sets ArrayInsert 
     */
    public void setArrayInsert(int count){
        ArrayInsert = count;
    }

    
    /** 
     * sets BSTInsert 
     */
    public void setBSTInsert(int count){
        BSTInsert = count;
    }

    
    /** 
     * resets all variables =0
     */
    private void reset(){
        ArrayFind = 0;
        BSTFind = 0;
        iternum =0;
        ArrayInsert =0;
        BSTInsert = 0;

    }

    
    /** 
     * outputs the Find counters in string format
     */
    public String toStringFind(){
        String out = Integer.toString(iternum) + "," + Integer.toString(ArrayFind) + "," + Integer.toString(BSTFind) ;
        reset();
        return out;

    }

    
    /** 
     * outputs the insert counters in string format
     */
    public String toStringInsert(){
        
        String out ="Array insert counter: " + Integer.toString(ArrayInsert) + "BST Insert counter: " + Integer.toString(BSTInsert);
        reset();
        return out;
    }
}