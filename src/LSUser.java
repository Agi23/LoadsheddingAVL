import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LSUser {
    public static void main(String[] args) {
        AVLTree myData = new AVLTree();
        //Get current day
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd");
        LocalDateTime cur = LocalDateTime.now();
        String usrDay = dt.format(cur);
        //System.out.println(usrDay);

        //get user data
        int Stage = 4;
        int Area = 1;
        String info;
        //search
        String[] timeArr = {"00","02","04","06","08","10","12","14","16","18","20","22"};
        for (String t : timeArr){
            //System.out.println(t);
            info = "";
            info = Integer.toString(Stage) + "_" + usrDay + "_" + t;
            //System.out.println(info);

            LSInfoItem curItem = new LSInfoItem(info);
            BinaryTreeNode ans = myData.find(curItem);
            if (ans != null){
                String myAreas = ans.data.getLSAreas();
                //System.out.println(myAreas);
                String[] arrAreas = myAreas.split(",");
                List<String> areasList = Arrays.asList(arrAreas);
                if (areasList.contains("1")){
                    System.out.println(t);
                }

            }


            
        }

    }
}