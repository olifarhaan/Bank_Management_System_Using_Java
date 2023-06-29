import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpOne extends JFrame implements ActionListener {
    JButton next, back;
    String formNo;
    JLabel formNoTitleLabel, headingLabel, nameLabel, fatherNameLabel, dobLabel, genderLabel, emailLabel, maritalStatusLabel, addressLabel, cityLabel, pincodeLabel, stateLabel;
    JTextField name, fatherName, email, address, city, pincode, state;
    JDateChooser dob;
    JRadioButton male, female, otherGender, married, unmarried, otherMarital;
    ButtonGroup gender, maritalStatus;
    Random random = new Random();

    SignUpOne() {
        setLayout(null);
        Font general = new Font("Verdana", Font.BOLD, 25);

        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(200, 0, 150, 150);
        add(iconLabel);

        formNo = String.valueOf(random.nextInt(999999));
        formNoTitleLabel = new JLabel("Application Form No. " + formNo);
        formNoTitleLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        formNoTitleLabel.setBounds(370, 30, 600, 40);
        add(formNoTitleLabel);

        headingLabel = new JLabel("Step 1: Add Personal Details");
        headingLabel.setFont(general);
        headingLabel.setBounds(370, 80, 600, 40);
        add(headingLabel);

        nameLabel = new JLabel("Full Name");
        nameLabel.setFont(general);
        nameLabel.setBounds(140, 150, 250, 40);
        add(nameLabel);

        name = new JTextField();
        name.setFont(general);
        name.setBounds(400, 150, 550, 40);
        add(name);

        fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setFont(general);
        fatherNameLabel.setBounds(140, 200, 250, 40);
        add(fatherNameLabel);

        fatherName = new JTextField();
        fatherName.setFont(general);
        fatherName.setBounds(400, 200, 550, 40);
        add(fatherName);

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setFont(general);
        dobLabel.setBounds(140, 250, 250, 40);
        add(dobLabel);

        dob = new JDateChooser();
        dob.setFont(general);
        dob.setBounds(400, 250, 550, 40);
        add(dob);

        genderLabel = new JLabel("Gender");
        genderLabel.setFont(general);
        genderLabel.setBounds(140, 300, 250, 40);
        add(genderLabel);

        male = new JRadioButton("Male");
        male.setFont(general);
        male.setBackground(Color.WHITE);
        male.setBounds(400, 300, 150, 40);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(general);
        female.setBackground(Color.WHITE);
        female.setBounds(570, 300, 150, 40);
        add(female);

        otherGender = new JRadioButton("Other");
        otherGender.setFont(general);
        otherGender.setBackground(Color.WHITE);
        otherGender.setBounds(740, 300, 150, 40);
        add(otherGender);
        gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        gender.add(otherGender);

        emailLabel = new JLabel("Email Address");
        emailLabel.setFont(general);
        emailLabel.setBounds(140, 350, 250, 40);
        add(emailLabel);

        email = new JTextField();
        email.setFont(general);
        email.setBounds(400, 350, 550, 40);
        add(email);

        maritalStatusLabel = new JLabel("Marital Status");
        maritalStatusLabel.setFont(general);
        maritalStatusLabel.setBounds(140, 400, 250, 40);
        add(maritalStatusLabel);

        married = new JRadioButton("Married");
        married.setFont(general);
        married.setBackground(Color.WHITE);
        married.setBounds(400, 400, 150, 40);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(general);
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(570, 400, 190, 40);
        add(unmarried);

        otherMarital = new JRadioButton("Other");
        otherMarital.setFont(general);
        otherMarital.setBackground(Color.WHITE);
        otherMarital.setBounds(780, 400, 150, 40);
        add(otherMarital);
        maritalStatus = new ButtonGroup();
        maritalStatus.add(married);
        maritalStatus.add(unmarried);
        maritalStatus.add(otherMarital);


        addressLabel = new JLabel("Address");
        addressLabel.setFont(general);
        addressLabel.setBounds(140, 450, 250, 40);
        add(addressLabel);

        address = new JTextField();
        address.setFont(general);
        address.setBounds(400, 450, 550, 40);
        add(address);

        cityLabel = new JLabel("City");
        cityLabel.setFont(general);
        cityLabel.setBounds(140, 500, 250, 40);
        add(cityLabel);

        city = new JTextField();
        city.setFont(general);
        city.setBounds(400, 500, 550, 40);
        add(city);

        pincodeLabel = new JLabel("Pin Code");
        pincodeLabel.setFont(general);
        pincodeLabel.setBounds(140, 550, 250, 40);
        add(pincodeLabel);

        pincode = new JTextField();
        pincode.setFont(general);
        pincode.setBounds(400, 550, 550, 40);
        add(pincode);

        stateLabel = new JLabel("State");
        stateLabel.setFont(general);
        stateLabel.setBounds(140, 600, 250, 40);
        add(stateLabel);

        state = new JTextField();
        state.setFont(general);
        state.setBounds(400, 600, 550, 40);
        add(state);

        back = new JButton("Back");
        back.setFont(general);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.RED);
        back.setBounds(140, 700, 200, 80);
        back.addActionListener(this);
        add(back);

        next = new JButton("Next");
        next.setFont(general);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(750, 700, 200, 80);
        next.addActionListener(this);
        add(next);


        setTitle("Sign Up Step 1");
        setSize(1200, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            try {
                Conn conn = new Conn();
                String nameString = name.getText();
                String fatherNameString = fatherName.getText();
                String dobString = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
                String genderString = null;
                if (male.isSelected()) genderString = "Male";
                else if (female.isSelected()) genderString = "Female";
                else if (otherGender.isSelected()) genderString = "Other";
                String emailString = email.getText();

                String maritalStatusString = null;
                if (married.isSelected()) maritalStatusString = "Married";
                else if (unmarried.isSelected()) maritalStatusString = "Unmarried";
                else if (otherMarital.isSelected()) maritalStatusString = "Other";

                String addressString = address.getText();
                String cityString = city.getText();
                String pincodeString = pincode.getText();
                String stateString = state.getText();

                conn.s.executeUpdate("insert into signUpOne values('" + formNo + "' , '" + nameString + "' , '" + fatherNameString + "' , '" + dobString + "' , '" + genderString + "' , '" + emailString + "' , '" + maritalStatusString + "' , '" + addressString + "' , '" + cityString + "' , '" + pincodeString + "' , '" + stateString + "')");
                new SignUpTwo(formNo);
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Login();
            setVisible(false);
        }
    }
}
