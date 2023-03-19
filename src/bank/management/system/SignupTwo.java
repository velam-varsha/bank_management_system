package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {

    // declaring global variables or object names:
    Long random;
    JTextField panTextField, aadhaarTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, occupation, education;
    String formNo;

    SignupTwo(String formNo) {  //SignupOne is a constructor here //to build or code the frame

        this.formNo = formNo; // this condition is to check that formNO from SignupOne is equal to formNo of SignupTwo

        setLayout(null);  // used to nullify the default settings of starting of the text in the centre of the frame, so that setBound function can run
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");



        JLabel additionalDetails = new JLabel("Page 2: Additional Details"); // we want random numbers for application so we use random class which can be imported from java.util.*
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel Religion = new JLabel("Religion:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Religion.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion.setBounds(100, 140, 200, 30);
        add(Religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};  // we need a slide down column to show the options so JComboBox is used
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel Category = new JLabel("Category:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Category.setFont(new Font("Raleway", Font.BOLD, 20));
        Category.setBounds(100, 190, 200, 30);
        add(Category);

        String valCategory[] = {"General" , "OBC" , "SC" , "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);



        JLabel Income = new JLabel("Income:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(100, 240, 200, 30);
        add(Income);

        String valIncome[] = {"Null" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);



        JLabel Educational = new JLabel("Educational"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Educational.setFont(new Font("Raleway", Font.BOLD, 20));
        Educational.setBounds(100, 290, 200, 30);
        add(Educational);


        JLabel Qualification = new JLabel("Qualification:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(100, 315, 200, 30);
        add(Qualification);

        String valEducation[] = {"Non-Graduation" , "Graduation" , "Post-Graduation" , "Doctrate", "Others"};
        education = new JComboBox(valEducation);
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel Occupation = new JLabel("Occupation:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 200, 30);
        add(Occupation);


        String valOccupation[] = {"Salaried" , "Self-Employed" , "Business" , "Student", "Retired" , "Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);




        JLabel Pan = new JLabel("PAN Number:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Pan.setFont(new Font("Raleway", Font.BOLD, 20));
        Pan.setBounds(100, 440, 200, 30);
        add(Pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);


        JLabel Aadhaar = new JLabel("Aadhaar Number:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhaar.setBounds(100, 490, 200, 30);
        add(Aadhaar);


        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhaarTextField.setBounds(300, 490, 400, 30);
        add(aadhaarTextField);


        JLabel Citizen = new JLabel("Senior Citizen:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        Citizen.setBounds(100, 540, 200, 30);
        add(Citizen);

        syes = new JRadioButton("YES");// JRadioButton is used for creating option buttons, it is a class
        syes.setBounds(300,540,120,30);
        syes.setFont(new Font("Raleway", Font.BOLD, 18));
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(550,540,120,30);
        sno.setFont(new Font("Raleway", Font.BOLD, 18));
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup citizenGroup = new ButtonGroup();  // used so that only one button will be selected, it is a class and genderGroup is the object name
        citizenGroup.add(syes);
        citizenGroup.add(sno);

        JLabel Account = new JLabel("Existing Account:"); // we want random numbers for application so we use random class which can be imported from java.util.*
        Account.setFont(new Font("Raleway", Font.BOLD, 20));
        Account.setBounds(100, 590, 200, 30);
        add(Account);

        eyes = new JRadioButton("YES");// JRadioButton is used for creating option buttons, it is a class
        eyes.setBounds(300,590,120,30);
        eyes.setFont(new Font("Raleway", Font.BOLD, 18));
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(550,590,120,30);
        eno.setFont(new Font("Raleway", Font.BOLD, 18));
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();  // used so that only one button will be selected, it is a class and genderGroup is the object name
        accountGroup.add(eyes);
        accountGroup.add(eno);


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
        setSize(850, 800);  // we should use extends JFrame or else will get error // to set the size of the frame
        setLocation(350, 10); // we should use extends JFrame or else will get error
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        // String formNo = "" + random;
        String Religion = (String) religion.getSelectedItem(); //using getSelectedItem() we will get value selected from the dropdown box, we need the value to be in string, so we write string after =
        String Category = (String) category.getSelectedItem();
        String Income = (String) income.getSelectedItem() ;
        String Education = (String) education.getSelectedItem() ;
        String Occupation = (String) occupation.getSelectedItem() ;
        String Pan = panTextField.getText();
        String Aadhaar = aadhaarTextField.getText();
        String Citizen = null;
        if (syes.isSelected()) {
            Citizen = "YES";
        } else if (sno.isSelected()) {
            Citizen = "NO";

        }

        String Account = null;
        if (eyes.isSelected()) {
            Account = "YES";
        } else if (eno.isSelected()) {
            Account = "NO";
        }

        try {
            if(Religion.equals("") || Category.equals("") || Income.equals("") || Education.equals("") || Occupation.equals("") || Pan.equals("") || Aadhaar.equals("") || Citizen.equals("") || Account.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields must be filled");   //JOptionPane is used to show a pop up message when it satisfies the if condition mentioned above
            } else {
                connection c = new connection(); // to insert value into the database
                String query = "insert into signuptwo values('" + formNo + "','" + Religion + "','" + Category + "','" + Income + "','" + Education + "','" + Occupation + "','" + Pan + "','" + Aadhaar + "','" + Citizen + "','" + Account + "')";
                // these values are collected from the string which are mentioned above // very important to write the commas and format correctly or else there will be an error stating column count doesn't match the value of rows
                c.s.executeUpdate(query);  // this is a dml command , s is a object created in connection class
                setVisible(false);
                new SignupThree(formNo).setVisible(true);

            }
        }
            catch (
                Exception e) {   // database is an external entity, so we might get errors in runtime, so we should do exception handling
            System.out.println(e);
        }


    }


    public static void main(String args[]) {

        new SignupTwo("");
    }
}
