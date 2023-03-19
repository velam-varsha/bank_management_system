package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
    String pin;

    Deposit(String pin){
        this.pin = pin;



        //setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(155,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 20));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,335,320,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(335,461,170,25);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(335,496,170,25);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);


        //create frame
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();



            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    connection c = new connection();
                    String query = "insert into bank values ('" + pin + "','" + date + "','Deposit','" + number + "')";
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs: " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (Exception e){            // try and catch should be included while updating or storing values in mysql coz he myt throw erros
                    System.out.println(e);
                }
            }

        } else if ((ae.getSource()== back)) {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        }

    }
    public static void main(String args[]){
        new Deposit("");
    }
}
