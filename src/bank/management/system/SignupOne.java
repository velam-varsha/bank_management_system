package bank.management.system;

import com.toedter.calendar.JDateChooser; // used for calendar, JDateChooser is a class

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {

    // declaring global variables or object names:
    Long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, others;
    JDateChooser dateChooser;

    SignupOne(){  //SignupOne is a constructor here //to build or code the frame


        setLayout(null);  // used to nullify the default settings of starting of the text in the centre of the frame, so that setBound function can run


        Random ran = new Random(); //random is a class and ran is the object name of random class, random class can generate numbers randomly
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);   //used to create random number which are positive of size 4

        JLabel formNo = new JLabel("APPLICATION FORM NO:" + random); // we want random numbers for application so we use random class which can be imported from java.util.*
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140,20,600,40);
        add(formNo);


        JLabel personalDetails = new JLabel("Page 1: Personal Details"); // we want random numbers for application so we use random class which can be imported from java.util.*
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        nameTextField.setBounds(300, 140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        fnameTextField.setBounds(300, 190,400,30);
        add(fnameTextField);


        JLabel dob = new JLabel("Date of Birth:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser(); //JDateChooser is a class and dateChooser is an object of that class
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 18));
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");// JRadioButton is used for creating option buttons, it is a class
        male.setBounds(300,290,120,30);
        male.setFont(new Font("Raleway", Font.BOLD, 18));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(550,290,120,30);
        female.setFont(new Font("Raleway", Font.BOLD, 18));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();  // used so that only one button will be selected, it is a class and genderGroup is the object name
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        emailTextField.setBounds(300, 340,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("married");// JRadioButton is used for creating option buttons, it is a class
        married.setBounds(300,390,100,30);
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
        unmarried.setBackground(Color.white);
        add(unmarried);

        others = new JRadioButton("others");
        others.setBounds(600,390,100,30);
        others.setFont(new Font("Raleway", Font.BOLD, 18));
        others.setBackground(Color.white);
        add(others);


        ButtonGroup maritalGroup = new ButtonGroup();  // used so that only one button will be selected, it is a class and maritalGroup is the object name
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(others);

        JLabel address = new JLabel("Address:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        addressTextField.setBounds(300, 440,400,30);
        add(addressTextField);


        JLabel city = new JLabel("City:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);


        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        cityTextField.setBounds(300, 490,400,30);
        add(cityTextField);


        JLabel state = new JLabel("State:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        stateTextField.setBounds(300, 540,400,30);
        add(stateTextField);

        JLabel pinCode = new JLabel("Pin Code:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        pinTextField.setBounds(300, 590,400,30);
        add(pinTextField);


        // NEXT BUTTON
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(620, 660, 100, 30);
        next.addActionListener(this);   // this statement is added so that an action can be taken which can be specified when clicked on that button
        add(next);



        //creation of the frame
        getContentPane().setBackground(Color.WHITE); //getcontentpane will select teh whole frame and can change the background color
        setSize(850,800);  // we should use extends JFrame or else will get error // to set the size of the frame
        setLocation(350, 10); // we should use extends JFrame or else will get error
        setVisible(true);





    }

    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random; // random is long and mysql can take only strings as data, so convert it by concatenating it with a ""
        String name = nameTextField.getText(); //using getText we can get the value of name entered
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); // used to get the value of the calendar date selected
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";

        }

        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (others.isSelected()){
            marital = "Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinTextField.getText();

        try {
            if(name.equals("") || dob.equals("") || gender.equals("") || email.equals("") || address.equals("") || city.equals("") || state.equals("") || pinCode.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields must be filled");   //JOptionPane is used to show a pop up message when it satisfies the if condition mentioned above
            } else {
                connection c = new connection(); // to insert value into the database
                String query = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
                c.s.executeUpdate(query);  // this is a dml command , s is a object created in connection class

                setVisible(false);
                new SignupTwo(formNo).setVisible(true);

            }
        } catch (Exception e){   // database is an external entity, so we might get errors in runtime, so we should do exception handling
            System.out.println(e);
        }


    }


    public static void main (String args[]){
    new SignupOne();
    }



}


