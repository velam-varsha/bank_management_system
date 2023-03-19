package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {


    JButton deposit, withdrawal , fastcash, miniStatement, pinchange, balance, exit, account;
    String pin;

    Transactions(String pin) {  //constructor
        this.pin = pin;
       // setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,270,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 20));
        image.add(text); //we need to add the text on the picture so use image.add()


        deposit = new JButton("Deposit");
        deposit.setBounds(150,391,120,25);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(335,391,170,25);
        withdrawal.setBackground(Color.WHITE);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setFont(new Font("Raleway",Font.BOLD, 16));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150,426,120,25);
        fastcash.setBackground(Color.WHITE);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("Raleway",Font.BOLD, 16));
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(335,426,170,25);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setFont(new Font("Raleway",Font.BOLD, 16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(150,461,120,25);
        pinchange.setBackground(Color.WHITE);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD, 16));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(335,461,170,25);
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD, 16));
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(150,496,120,25);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway",Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);

        account = new JButton("Account Type");
        account.setBounds(335,496,170,25);
        account.setBackground(Color.WHITE);
        account.setForeground(Color.BLACK);
        account.setFont(new Font("Raleway",Font.BOLD, 16));
        account.addActionListener(this);
        image.add(account);









        //create  a frame
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true); // used so that we dont get the top white colour bar which has cancel sysmbols
        setVisible(true); // set visible should be in the last coz if we type after setvisible anything those will not be visible on the frame



    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if (ae.getSource()== balance){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource()==miniStatement) {
            new MiniStatement(pin).setVisible(true);

        }

    }
    public static void main(String args[]){

        new Transactions("");


    }

}
