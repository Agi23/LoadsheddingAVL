class Counter{
    int ArrayFind;
    int ArrayInsert;
    int BSTFind;
    int BSTInsert;
    int iternum;
    int AVLInsert;
    int AVLFind;


    
    /** 
     * initialises a counter object with the position (iteration number) of the data that is being searched
     */
    public Counter(int itnum){
        this.ArrayFind = 0;
        this.BSTFind = 0;
        this.iternum = itnum;
        this.AVLFind =0;
    }
    
    /** 
     * generic initialising object
     */
    public Counter(){
        BSTInsert =0;
        ArrayInsert=0;
        AVLInsert =0;
    }
    
    /** 
     * sets ArrayFind
     */
    public void setArrayFind(int count){
        ArrayFind = count;
    }
    public void setAVLFind(int count){
        AVLFind = count;
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
    public void setAVLInsert(int count){
        AVLInsert = count;
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
    private void resetFind(){
        ArrayFind = 0;
        BSTFind = 0;
        AVLFind = 0;
        iternum =0;
        //ArrayInsert =0;
        //BSTInsert = 0;

    }
    private void resetInsert(){
        ArrayInsert =0;
        BSTInsert = 0;
        AVLInsert = 0;
    }
    
    /** 
     * outputs the Find counters in string format
     */
    public String toStringFind(){
        String out = Integer.toString(iternum) + "," + Integer.toString(ArrayFind) + "," + Integer.toString(BSTFind) + ',' +Integer.toString(AVLFind);
        resetFind();
        return out;

    }

    
    /** 
     * outputs the insert counters in string format
     */
    public String toStringInsert(){
        
        //String out ="Array insert counter: " + Integer.toString(ArrayInsert) + System.lineSeparator() + "BST Insert counter: " + Integer.toString(BSTInsert) + System.lineSeparator()+ "AVL Insert counter: " + Integer.toString(AVLInsert);
        String out ="," + Integer.toString(ArrayInsert) +  ", " + Integer.toString(BSTInsert) + "," + Integer.toString(AVLInsert);
        resetInsert();
        return out;
    }
}