package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pin;

    BalanceEnquiry(String pin){
        this.pin= pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(370,520,120,25);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);

        JButton lack = new JButton("Back");

        connection c = new connection();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {   //rs.next() is used to check each and every row  in the pin column in mysql
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));  // here "amount" is used to select amount row in mysql // here amount is a string whereas balance is integer, so we use Integer.parseInt() to convert string to integer

                } else {
                    balance -= Integer.parseInt(rs.getString("amount")); // here "amount" is used to select amount row in mysql
                }
            }
        } catch (Exception e){
                System.out.println(e);
            }

            JLabel text = new JLabel("Your Current Account Balance is Rs "+ balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170,300,400,35);
            text.setFont(new Font("System",Font.BOLD, 16));
            image.add(text);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        setVisible(false);
        new Transactions(pin).setVisible(true);
    }



    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
