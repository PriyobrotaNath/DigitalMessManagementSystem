import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class LogIn extends JFrame {
   // JLabel a = new JLabel("Log In");
    JPanel panel = new JPanel(new GridBagLayout());
    JLabel label0 = new JLabel("Registration");
    JLabel label1 = new JLabel("Name       :");
    JLabel label2 = new JLabel("Password :");
    JTextField tf = new JTextField(15);
    JPasswordField pf = new JPasswordField(15);
    JButton button = new JButton("Log In");
    JButton SignUp = new JButton("Sign UP");

    GridBagConstraints c = new GridBagConstraints();


    public LogIn(){
       // JLabel label1 = new JLabel("Registration");
        JFrame f;
        setSize(700,680);
        setTitle("Log In to Digital Mess");
      //  JPanel p = new JPanel();
     //   getContentPane().setBackground(Color.PINK);
        //setBackground(Color.cyan);
       // setForeground(Color.black);
        setTitle("Log In");
        setBounds(380, 200, 700, 680);
        setLocation(430,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // getContentPane().setLayout(null);
        //getContentPane().setLayout(null);

         c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 1;
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(label1, c);

        c.gridx = 2;
        c.gridy = 1;
        panel.add(tf, c);

        c.gridx = 0;
        c.gridy = 5;
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(label2, c);

        c.gridx = 2;
        c.gridy = 5;
        panel.add(pf, c);

        c.gridx = 3;
        c.gridy = 7;
        button.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(button, c);

        c.gridx = 0;
        c.gridy = 7;
        SignUp.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(SignUp, c);
        add(panel);


        setVisible(true);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int check = 0;
                String Name = tf.getText();
                String password = String.valueOf(pf.getPassword());

                File f = new File("C:/Users/ASUS/Desktop/Project/login.txt");
                ArrayList<String> a = new ArrayList<>();
                try{
                    FileInputStream fis = new FileInputStream(f);
                    InputStreamReader isr =  new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);


                    String in = br.readLine();
                    while(in != null)
                    {
                            a.add(in);
                            in = br.readLine();
                    }

                    for(int i = 0; i<a.size(); i++){
                        String info[] = a.get(i).split(" ");
                        if(String.valueOf(tf.getText()).equals(info[0]) && String.valueOf(pf.getPassword()).equals(info[1])){
                            check = 1;
                            break;
                        }
                    }
                    if(check == 0){
                        JOptionPane.showMessageDialog(null,"Invalid username or password\nClick ok and try again","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    fis.close();
                    dispose();
                    Welcome obj = new Welcome();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        SignUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                    dispose();
                    Registration obj = new Registration();

            }
        });
    }

    public static void main(String[] args)
    {

        LogIn obj = new LogIn();


    }
}
