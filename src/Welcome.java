import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame {
    JLabel label1 = new JLabel("Welcome");
    JButton button1 = new JButton("Rent & Service");
    JButton button2 = new JButton("Supplies");
    JButton button3 = new JButton("Deposit");
    JButton button4 = new JButton("Meal Estimate");
    JButton button5 = new JButton("Total Cost");
    JButton button6 = new JButton("Log Out");


    public Welcome() {
        setBounds(180,200,700,680);
        setTitle("Welcome to Features");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        label1.setBounds(260,30,600,60);
        label1.setFont(new Font("Calibri", Font.BOLD, 50));
        getContentPane().add(label1);

        button1.setBounds(290,120,140,50);
        button1.setFont(new Font("Calibri", Font.PLAIN, 18));
        getContentPane().add(button1);

        button2.setBounds(290,180,140,50);
        button2.setFont(new Font("Calibri", Font.PLAIN, 18));
        getContentPane().add(button2);

        button3.setBounds(290,240,140,50);
        button3.setFont(new Font("Calibri", Font.PLAIN, 18));
        getContentPane().add(button3);

        button4.setBounds(290,300,140,50);
        button4.setFont(new Font("Calibri", Font.PLAIN, 18));
        getContentPane().add(button4);

        button5.setBounds(290,360,140,50);
        button5.setFont(new Font("Calibri", Font.PLAIN, 18));
        getContentPane().add(button5);
        setVisible(true);

        button6.setBounds(290,420,140,50);
        button6.setFont(new Font("Calibri", Font.PLAIN, 18));
        getContentPane().add(button6);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                RentServiceEstimates obj = new RentServiceEstimates();
            }
        });


        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                SuppliesCost obj = new SuppliesCost();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                DepositEstimates obj=new DepositEstimates();
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MealEstimate obj = new MealEstimate();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TotalCost obj = new TotalCost();
            }
        });
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                LogIn obj = new LogIn();
            }
        });
    }
}
