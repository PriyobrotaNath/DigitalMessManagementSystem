import com.sun.jndi.cosnaming.IiopUrl;
import sun.awt.SunHints;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Registration extends JFrame {
    JLabel name, contact, address, password, re_password, duration,title;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton submit,back;

    public Registration() {
        JLabel label1 = new JLabel("Registration");
        name = new JLabel("        Name     :");
        contact = new JLabel("   Contact      : ");
        address= new JLabel("    Address     :  ");
        password = new JLabel("  Password     : ");
        re_password = new JLabel("Re-password  : ");
        duration= new JLabel("    Duration    : ");
        title = new JLabel("      Registration");


        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);

        submit = new JButton("Submit");
        back = new JButton("Back");


        setTitle("Registration");
        setBounds(380, 200, 700, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        label1.setBounds(200,30,600,60);
        label1.setFont(new Font("Calibri", Font.BOLD, 40));
        getContentPane().add(label1);

        name.setBounds(60, 100, 150, 25);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(name);

        t1.setBounds(190, 100, 150, 25);
        getContentPane().add(t1);

        contact.setBounds(60, 150, 150, 25);
        contact.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(contact);

        t2.setBounds(190, 150, 150, 25);
        getContentPane().add(t2);

        address.setBounds(60, 200, 150, 25);
        address.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(address);

        t3.setBounds(190, 200, 150, 25);
        getContentPane().add(t3);

        password.setBounds(60, 250, 150, 25);
        password.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(password);

        t4.setBounds(190, 250, 150, 25);
        getContentPane().add(t4);

        re_password.setBounds(60, 300, 150, 25);
        re_password.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(re_password);

        t5.setBounds(190, 300, 150, 25);
        getContentPane().add(t5);

        duration.setBounds(60, 350, 150, 25);
        duration.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(duration);

        t6.setBounds(190, 350, 150, 25);
        t6.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(t6);

       /* tittle.setBounds(150, 200, 220, 25);
        getContentPane().add(tittle);*/

        submit.setBounds(360, 450, 120, 30);
        submit.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(submit);

        back.setBounds(510, 450, 120, 30);
        back.setFont(new Font("Calibri", Font.BOLD, 20));
        getContentPane().add(back);

        setVisible(true);


        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = t1.getText();
                String contact = t2.getText();
                String address = t3.getText();
                String password = String.valueOf(t4.getText());
                String re_password = String.valueOf(t5.getText());
                String duration= t6.getText();

                if(name.length() == 0 || contact.length() == 0 || address.length() == 0 || password.length() == 0 || re_password.length() == 0 || duration.length() == 0) {
                    JOptionPane.showMessageDialog(null,"Invalid name or cantact or address or password or re_password or duration\nClick ok and try again","Error",JOptionPane.ERROR_MESSAGE);
                }
                /*else if(password.length()!=re_password.length()){
                    JOptionPane.showMessageDialog(,"Password do not match ");
                }*/
                /*else if(password.matches(password)!=re_password.matches(re_password)) {
                JOptionPane.
                }*/
                else {
                    File file = new File("C:\\Users\\ASUS\\Desktop\\Project\\registration.txt");
                    ArrayList<String> al = new ArrayList<>();
                    try{
                        FileInputStream fis = new FileInputStream(file);
                        InputStreamReader isr =  new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);


                        String info = br.readLine();
                        if(info == null){
                            al.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText()+" "+t5.getText()+" "+t6.getText());
                        }
                        else{
                            while(info != null){
                                al.add(info);
                                info = br.readLine();
                            }
                            al.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t5.getText()+" "+t6.getText());
                        }
                        fis.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        FileOutputStream fos =  new FileOutputStream(file);
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        BufferedWriter bw = new BufferedWriter(osw);

                        Iterator it = al.iterator();

                        while(it.hasNext()){
                            bw.write(String.valueOf(it.next()));
                            bw.newLine();
                            bw.flush();
                        }
                        fos.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    File f = new File("C:\\Users\\ASUS\\Desktop\\Project\\login.txt");
                    ArrayList<String> a = new ArrayList<>();
                    try{
                        FileInputStream fis = new FileInputStream(f);
                        InputStreamReader isr =  new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);


                        String in = br.readLine();
                        if(in == null){
                            a.add(t1.getText()+" "+t4.getText());
                        }
                        else{
                            while(in != null){
                                a.add(in);
                                in = br.readLine();
                            }
                            a.add(t1.getText()+" "+t4.getText());
                        }
                        fis.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        FileOutputStream fos =  new FileOutputStream(f);
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        BufferedWriter bw = new BufferedWriter(osw);

                        Iterator iterator = a.iterator();

                        while(iterator.hasNext()){
                            bw.write(String.valueOf(iterator.next()));
                            bw.newLine();
                            bw.flush();
                        }
                        fos.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    dispose();
                    LogIn obj = new LogIn();
                }
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                LogIn obj = new LogIn();
            }
        });

    }
}
