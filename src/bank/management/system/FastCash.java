package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet; //ResultSet
import java.util.Date; //Date

public class FastCash extends JFrame implements ActionListener {


    JButton deposit, withdrawal , fastcash, miniStatement, pinchange, balance, exit, account;
    String pin;


    FastCash(String pin) {  //constructor
        this.pin = pin;
        // setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(190,270,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 20));
        image.add(text); //we need to add the text on the picture so use image.add()


        deposit = new JButton("Rs 100");
        deposit.setBounds(150,391,120,25);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(335,391,170,25);
        withdrawal.setBackground(Color.WHITE);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setFont(new Font("Raleway",Font.BOLD, 16));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(150,426,120,25);
        fastcash.setBackground(Color.WHITE);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("Raleway",Font.BOLD, 16));
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(335,426,170,25);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setFont(new Font("Raleway",Font.BOLD, 16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(150,461,120,25);
        pinchange.setBackground(Color.WHITE);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD, 16));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Rs 7000");
        balance.setBounds(335,461,170,25);
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD, 16));
        balance.addActionListener(this);
        image.add(balance);

        account = new JButton("Rs 10000");
        account.setBounds(150,496,120,25);
        account.setBackground(Color.WHITE);
        account.setForeground(Color.BLACK);
        account.setFont(new Font("Raleway",Font.BOLD, 16));
        account.addActionListener(this);
        image.add(account);

        exit = new JButton("BACK");
        exit.setBounds(335,496,170,25);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway",Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);



        //create  a frame
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true); // used so that we dont get the top white colour bar which has cancel sysmbols
        setVisible(true); // set visible should be in the last coz if we type after setvisible anything those will not be visible on the frame



    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == exit){
           setVisible(false);
           new Transactions(pin).setVisible(true);
        }  else {

            String amount = ((JButton)ae.getSource()).getText().substring(3);  // gets the value on the button by taking only the substring by reducing 3 characters that is Rs(space)
            // here except exit if any other button is clicked, then we will extract the value on tht button
            connection c = new connection();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()){   //rs.next() is used to check each and every row  in the pin column in mysql
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));  // here "amount" is used to select amount row in mysql // here amount is a string whereas balance is integer, so we use Integer.parseInt() to convert string to integer

                    } else {
                        balance -= Integer.parseInt(rs.getString("amount")) ; // here "amount" is used to select amount row in mysql
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){   // amount = the value of button we clicked for eg amount =100, only integer value is taken coz we used Integer.parseInt()
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pin+"','"+date+"','withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs: "+amount+ " Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
    public static void main(String args[]){

        new FastCash("");


    }

}