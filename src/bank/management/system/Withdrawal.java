package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String pin;

    Withdrawal(String pin){
        this.pin = pin;



        //setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(155,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 18));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,335,320,25);
        image.add(amount);

        withdraw= new JButton("Withdraw");
        withdraw.setBounds(335,461,170,25);
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("Raleway",Font.BOLD, 16));
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();



            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    connection c = new connection();
                    String query = "insert into bank values ('" + pin + "','" + date + "','Withdrawal','" + number + "')";
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs: " + number + " Withdrew Successfully");
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
