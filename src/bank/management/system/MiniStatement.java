package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    MiniStatement(String pin){
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{

            connection c = new connection();

            ResultSet rs = connection.s.executeQuery("select * from login where pin = '"+pin+"'");
            while (rs.next()){
                card.setText("Card Number: " +rs.getString("card_number").substring(0,4) + "XXXXXXXX" + rs.getString("card_number").substring(12));

            }



        }catch (Exception e){
            System.out.println(e);
        }
        try{

            connection c = new connection();
            int bal = 0;
            ResultSet rs = connection.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()){
                mini.setText(mini.getText() +"<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));  // here "amount" is used to select amount row in mysql // here amount is a string whereas balance is integer, so we use Integer.parseInt() to convert string to integer

                } else {
                    bal -= Integer.parseInt(rs.getString("amount")) ; // here "amount" is used to select amount row in mysql
                }

            }
            balance.setText("Your current account balance is Rs: " +bal);
        }catch (Exception e){
            System.out.println(e);
        }


        mini.setBounds(20,140,400,200);


        setSize(400,600);
        setLocation(600,200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    public static void main(String args[]){
        new MiniStatement("");

    }
}
