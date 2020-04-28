//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

//import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;


public class GUI extends JPanel implements ActionListener {
    private JButton btnGo;
    private JComboBox compStage;
    private JComboBox compArea;
    private JTextArea todayText;
    private JTextArea tomText;
    private JLabel lblStage;
    private JLabel lblArea;
    private JLabel lblToday;
    private JLabel lblTom;
    private JButton btnClear;

    public GUI() {
        //construct preComponents
        String[] compStageItems = {"1", "2", "3", "4", "5", "6", "7", "8"};
        String[] compAreaItems = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

        //construct components
        btnGo = new JButton ("SEARCH");
        compStage = new JComboBox (compStageItems);
        compArea = new JComboBox (compAreaItems);
        todayText = new JTextArea (5, 5);
        tomText = new JTextArea (5, 5);
        lblStage = new JLabel ("STAGE:");
        lblArea = new JLabel ("AREA:");
        lblToday = new JLabel ("TODAY:");
        lblTom = new JLabel ("TOMORROW:");
        btnClear = new JButton ("CLEAR");

        //adjust size and set layout
        setPreferredSize (new Dimension (343, 471));
        setLayout (null);

        //add components
        add (btnGo);
        add (compStage);
        add (compArea);
        add (todayText);
        add (tomText);
        add (lblStage);
        add (lblArea);
        add (lblToday);
        add (lblTom);
        add (btnClear);

        //action listener
        btnGo.addActionListener(this); 
        btnClear.addActionListener(this);

        //set component bounds (only needed by Absolute Positioning)
        btnGo.setBounds (120, 125, 100, 30);
        compStage.setBounds (120, 45, 100, 25);
        compArea.setBounds (120, 90, 100, 25);
        todayText.setBounds (30, 260, 110, 185);
        tomText.setBounds (190, 260, 110, 185);
        lblStage.setBounds (20, 45, 100, 25);
        lblArea.setBounds (20, 90, 100, 25);
        lblToday.setBounds (55, 220, 100, 25);
        lblTom.setBounds (200, 220, 100, 25);
        btnClear.setBounds (120, 160, 100, 30);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("GUI");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GUI());
        frame.pack();
        frame.setVisible (true);
       
    }

    public void actionPerformed(ActionEvent e){  
        //todayText.setText("hi");  
        if (e.getSource() == btnClear){
            todayText.setText("");
            tomText.setText("");
        }
        else{
        String selectedStage = (String) compStage.getSelectedItem();
        String selectedArea = (String) compArea.getSelectedItem();

        AVLTree myData = new AVLTree();
        //Get current day
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd");
        LocalDateTime cur = LocalDateTime.now();
        String usrDay = dt.format(cur);
        cur = cur.plusDays(1);
        String usrTom =  dt.format(cur);
        
        //System.out.println(usrTom);
        String info;
        String infoTom;
        String[] timeArr = {"00","02","04","06","08","10","12","14","16","18","20","22"};
        for (String t : timeArr){
            //System.out.println(t);
            info = "";
            infoTom = "";
            infoTom = selectedStage + "_" + usrTom + "_" + t;
            info = selectedStage + "_" + usrDay + "_" + t;
            //System.out.println(info);

            LSInfoItem curItem = new LSInfoItem(info);
            LSInfoItem tomItem = new LSInfoItem(infoTom);

            BinaryTreeNode ans = myData.find(curItem);
            BinaryTreeNode ansTom = myData.find(tomItem);

            if (ans != null){
                String myAreas = ans.data.getLSAreas();
                //System.out.println(myAreas);
                String[] arrAreas = myAreas.split(",");

                List<String> areasList = Arrays.asList(arrAreas);
                if (areasList.contains(selectedArea)){
                    //System.out.println(t);
                    todayText.append(t + "h00 \n\r");
                }

            }

            if (ansTom != null){
                String myAreasTom = ansTom.data.getLSAreas();
                //System.out.println(myAreas);
                String[] arrAreasTom = myAreasTom.split(",");

                List<String> areasListTom = Arrays.asList(arrAreasTom);
                if (areasListTom.contains(selectedArea)){
                    //System.out.println(t);
                    tomText.append(t + "h00 \n\r");
                }

            }
            
        }
    }

}
}
