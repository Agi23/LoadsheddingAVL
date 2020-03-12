public class LSAVLApp{
    public static void main(String[] args) {
        AVLTree myAVL = new AVLTree();
        myAVL.PrintAreas("1", "23", "00");
        System.out.println(myAVL.getCounterInsert());
        System.out.println(myAVL.getCounterFind());
    }
}