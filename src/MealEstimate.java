import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MealEstimate extends JFrame {
    JTable tab;
    JScrollPane scroll;
    JLabel name,month,meal,tittle,mealPer;
    JTextField t1,t2,t3;
    JComboBox m;
    JButton back,submit;
    public MealEstimate(){
        String[] column = {"DATE", "LAUNCH","GUEST","DINNER","GUEST","TOTAL"};
        String[][] row = {
                {"","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
                {"","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
                {"","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
                {"","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","      ","     ","      ","     ","     ","     ","     ","     ","     "},
                {"      ","     ","     ","     ","     ","     ","     ","     ","     ","     ","     "},
        };

        tab= new JTable(row,column);

        name=new JLabel("      Name          :");
        month=new JLabel("MONTH");
        meal=new JLabel("       Meal           : ");
        mealPer=new JLabel("       MealPer     : ");
        tittle=new JLabel("MEAL CALCULATION");

        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);

        m=new JComboBox();
        submit=new JButton("Submit");
        back=new JButton("Back");
        scroll = new JScrollPane(tab);

        setTitle("MEAL ESTIMATES");
        setBounds(380, 120, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        name.setBounds(60, 80, 250, 25);
        getContentPane().add(name);

        t1.setBounds(160, 80, 250, 25);
        getContentPane().add(t1);

        meal.setBounds(60, 110, 150, 25);
        getContentPane().add(meal);

        t2.setBounds(160, 110, 100, 25);
        getContentPane().add(t2);

        mealPer.setBounds(60, 140, 150, 25);
        getContentPane().add(mealPer);

        t3.setBounds(160, 140, 100, 25);
        getContentPane().add(t3);

        month.setBounds(450, 10, 70, 25);
        getContentPane().add(month);

        m.setBounds(440, 30, 70, 25);
        getContentPane().add(m);

        tittle.setBounds(150, 200, 220, 25);
        getContentPane().add(tittle);

        scroll.setBounds(40,220,450,200);
        getContentPane().add(scroll);

        submit.setBounds(360, 450, 80, 30);
        getContentPane().add(submit);

        back.setBounds(460, 450, 80, 30);
        getContentPane().add(back);
        setVisible(true);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File file=new File("C:/Users/ASUS/Desktop/Project/Meal.txt");
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    FileWriter fw=new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    for(int i=0; i<tab.getRowCount();i++){
                        for(int j=0; j<tab.getColumnCount();j++){
                            bw.write(tab.getModel().getValueAt(i,j)+"");
                        }
                        bw.write("\n         \n");
                    }
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null,"Data Exported");
                }
                catch(Exception e1){
                    e1.printStackTrace();

                }
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Welcome obj = new Welcome();
            }
        });
    }


}
