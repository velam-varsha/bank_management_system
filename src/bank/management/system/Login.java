package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; //ResultSet

public class Login extends JFrame implements ActionListener{  //actionlistener is used to know the actions when clicked on buttons,  we import java.awt.event.*
    JButton login, clear, signup;   ///these buttons are defined globally, to access them outside login constructor or to use in other constructors also
    JTextField cardTextField; // to use them in other constructs so defined globally, JTextField is used so that we can enter text or number
    JPasswordField pinTextField; // JPassword is used so that if we type anything in that box, it will show dots like password for hiding





    Login(){   // Login here is a constructor in which we write our code // to create or build and code the frame

        setTitle("AUTOMATIC TELLER MACHINE");

        setLayout(null);  // to nullify the centre layout coz of which the image is placed in the centre of the frame...
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  //ImageIcon in beginning is a class; // i1 is the name or variable of the object that is object name
        // ClassLoader.getSystemResources is used to get the image from the system by mentioning the address of the image
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);    //Image is the class and 12 is th object name
        ImageIcon i3 = new ImageIcon(i2); //we cannot pass Image i2 in JFrame coz they are of different packages, so we create an object i3 in ImageIcon class and pass i2 into it
        JLabel label = new JLabel(i3);    //JLabel is used to place the image on the frame // label is variable
        label.setBounds(70,10,100,100);   //used to place the image on frame where we want
        add(label);    // we should use add function to place any component on the frame, inside add func pass the object, here the object is label


        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardNum  = new JLabel("Card No:");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNum.setBounds(120,150,150,40);
        add(cardNum);

        cardTextField = new JTextField();  // to get a box front of cardNum, JTextField is the class and cardTextField is the object
        cardTextField.setBounds(300,150,230,40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardTextField);


        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(120,220,150,40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220, 230,40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinTextField);

        // SIGN IN BUTTON
        login = new JButton("SIGN IN");  // to create buttons, login is the object name
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);   //informs when clicked on sign in button
        add(login);

        //CLEAR BUTTON
        clear = new JButton("CLEAR");  // to create buttons, login is the object name
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);   //informs when clicked on clear button
        add(clear);


        // SIGN UP BUTTON
        signup = new JButton("SIGN UP");  // to create buttons, login is the object name
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);   //informs when clicked on sign up button
        add(signup);

        //creation of the frame
        getContentPane().setBackground(Color.white); // getcontentpane will select the whole frame and can change the background

        setSize(800,480);   // to set the size of the frame // should add extends JFrame or else there will be an error
        setVisible(true);  // to make the frame visible
        setLocation(350,200);      //at wch place the frame will open




    }

    public void actionPerformed(ActionEvent ae) {   //used to override the error actionlistener, we list what should we do when a particular button is clicked
        //actionevent is a class , ae is the name of the object of the actionevent class
        if (ae.getSource() == clear) {
            cardTextField.setText(""); //setText is used to write in that box... if we leave blank, then if there was something written in card no. box it becomes empty
            pinTextField.setText("");


        } else if (ae.getSource() == login) {
            connection c = new connection();
            String cardNum = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from login where card_number = '"+cardNum+"' and pin = '"+pin+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);  //this operation gives a value so we will store it in result object
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }

            }catch (Exception e){
                System.out.println(e);
            }


        } else if (ae.getSource() == signup) {
            setVisible(false); // so on clicking signup the current frame will be closed
            new SignupOne().setVisible(true); // now SignupOne frame will be opened
        }

    }
        public static void main(String args[]){
        new Login();        //object of th class

    }

}

