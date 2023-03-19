package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //ActionListener, ActionEvent
import java.util.*; //random

public class SignupThree extends JFrame implements ActionListener{  //extends JFrame coz we want to use JLabel

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;  // JCheckbox is a class used to create check boxes
    JButton submit , cancel;
    String formNo;

    SignupThree(String formNo){ //constructor
        this.formNo= formNo;

        setLayout(null);

        JLabel l1 = new JLabel(("Page 3: Account Details"));
        l1.setFont(new Font("Raleway", Font.BOLD,22) );
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel(("Account Type: "));
        type.setFont(new Font("Raleway", Font.BOLD,20) );
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 18));
        r1.setBounds(100,180,250,20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 18));
        r2.setBounds(350,180,250,20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 18));
        r3.setBounds(100,220,250,20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 18));
        r4.setBounds(350,220,300,20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel(("Card Number: "));
        card.setFont(new Font("Raleway", Font.BOLD,20) );
        card.setBounds(100,300,200,30);
        add(card);

        JLabel cnumber = new JLabel(("XXXX-XXXX-XXXX-4184 "));
        cnumber.setFont(new Font("Raleway", Font.BOLD,20) );
        cnumber.setBounds(330,300,300,30);
        add(cnumber);

        JLabel cardDetails = new JLabel(("This is your 16 digit card number"));
        cardDetails.setFont(new Font("Raleway", Font.BOLD,18) );
        cardDetails.setBounds(100,340,400,20);
        add(cardDetails);

        JLabel pin = new JLabel(("PIN: "));
        pin.setFont(new Font("Raleway", Font.BOLD,20) );
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinDetails = new JLabel(("This is your 4 digit pin number"));
        pinDetails.setFont(new Font("Raleway", Font.BOLD,18) );
        pinDetails.setBounds(100,410,400,20);
        add(pinDetails);

        JLabel pnumber = new JLabel(("XXXX"));
        pnumber.setFont(new Font("Raleway", Font.BOLD,20) );
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        JLabel services = new JLabel(("Services Required: "));
        services.setFont(new Font("Raleway", Font.BOLD,20) );
        services.setBounds(100,450,200,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 18));
        c1.setBounds(100,500,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 18));
        c2.setBounds(350,500,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 18));
        c3.setBounds(100,550,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 18));
        c4.setBounds(350,550,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 18));
        c5.setBounds(100,600,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 18));
        c6.setBounds(350,600,200,30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100,680,700,20);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 18));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);




        // creation of the frame
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);



    }


    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == submit){
            String Type = null;
            if(r1.isSelected()){
                Type = "Saving Account";
            } else if (r2.isSelected()) {
                Type = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                Type = "Current Account";
            } else if (r4.isSelected()) {
                Type = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs ((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs ((random.nextLong() % 9000L) + 1000L);
            String declare = "";
            if(c7.isSelected()){
                declare= "Declared";
            }

            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM card";
            } else if(c2.isSelected()){
                facility = facility + " Internet Banking" ;
            } else if(c3.isSelected()){
                facility = facility + " Mobile Banking" ;
            } else if(c4.isSelected()){
                facility = facility + " Email & SMS alerts" ;
            } else if(c5.isSelected()){
                facility = facility + " Cheque Book" ;
            } else if(c6.isSelected()){
                facility = facility + " E-Statment" ;
            }
            try{
                if( Type.equals("") || facility.equals("") || declare.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    connection c= new connection();
                    String query1 = "insert into signupthree values('"+formNo+"', '"+Type+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";

                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n PIN:" + pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }


            } catch (Exception e){
                System.out.println(e);
            }



        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }

    }
    public static void main(String args[]){

        new SignupThree("");   //SignupThree class
    }
}
