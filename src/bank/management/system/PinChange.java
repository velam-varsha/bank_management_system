package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JLabel text, newpintext, repintext;
    JPasswordField newpin, repin;
    JButton change, back;
    String pin;

    PinChange(String pin) { //constructor

        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,265,500,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 18));
        image.add(text); // the text should be added on the image


        newpintext = new JLabel("New PIN: ");
        newpintext.setBounds(165,300,180,25);
        newpintext.setForeground(Color.WHITE);
        newpintext.setFont(new Font("System",Font.BOLD, 18));
        image.add(newpintext);

        newpin = new JPasswordField();
        newpin.setFont(new Font("Raleway", Font.BOLD,25));
        newpin.setBounds(330,300,180,25);
        image.add(newpin);


        repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setBounds(165,340,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD, 18));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        repin.setBounds(330,340,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(335,461,170,25);
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("Raleway",Font.BOLD, 16));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(335,496,170,25);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);





        setSize(900,900);
        setLocation(300,0);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
            try{

                String npin = newpin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }

                else if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter NEW PIN");
                    return;
                }
                else if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please re-enter NEW PIN");
                    return;
                } else if(npin.equals(rpin)) {

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                }

                connection c = new connection();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query3 = "update signupthree set pin_number = '"+rpin+"' where pin_number = '"+pin+"'";

                connection.s.executeUpdate(query1);
                connection.s.executeUpdate(query2);
                connection.s.executeUpdate(query3);



                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }

    }
    public static void main(String args[]){

        new PinChange("").setVisible(true);
    }

}
