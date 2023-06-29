
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener {
    JButton next, back;
    String formNo;
    JLabel formNoTitleLabel, headingLabel, religionLabel, categoryLabel, incomeLabel, qualificationLabel, occupationLabel, panLabel, aadhaarLabel, seniorCitizenLabel, existingAccountLabel;
    JTextField pan, aadhaar;
    JRadioButton yesSenior, noSenior, yesExisting, noExisting;
    ButtonGroup seniorCitizen, existingAccount;

    JComboBox<String> religion, category, income, qualification, occupation;

    SignUpTwo(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        Font general = new Font("Verdana", Font.BOLD, 25);

        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(200, 0, 150, 150);
        add(iconLabel);

        formNoTitleLabel = new JLabel("Application Form No. " + formNo);
        formNoTitleLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        formNoTitleLabel.setBounds(370, 30, 600, 40);
        add(formNoTitleLabel);

        headingLabel = new JLabel("Step 2: Additional Details");
        headingLabel.setFont(general);
        headingLabel.setBounds(370, 80, 600, 40);
        add(headingLabel);

        religionLabel = new JLabel("Religion");
        religionLabel.setFont(general);
        religionLabel.setBounds(140, 150, 250, 40);
        add(religionLabel);

        String[] religionTypes = {"Hindu", "Muslim", "Christian", "Sikh", "Buddhism", "Atheist", "Other"};
        religion = new JComboBox<>(religionTypes);
        religion.setFont(general);
        religion.setBounds(400, 150, 550, 40);
        religion.setSelectedItem(null);
        add(religion);

        categoryLabel = new JLabel("Category");
        categoryLabel.setFont(general);
        categoryLabel.setBounds(140, 200, 250, 40);
        add(categoryLabel);

        String[] categoryTypes = {"General", "OBC", "SC", "ST"};
        category = new JComboBox<>(categoryTypes);
        category.setFont(general);
        category.setBounds(400, 200, 550, 40);
        category.setSelectedItem(null);
        add(category);

        incomeLabel = new JLabel("Income");
        incomeLabel.setFont(general);
        incomeLabel.setBounds(140, 250, 250, 40);
        add(incomeLabel);

        String[] incomeTypes = {"Unemployed", "< 1,00,000", "< 2,50,000", "< 5,00,000", "UpTo 10,00,000"};
        income = new JComboBox<>(incomeTypes);
        income.setFont(general);
        income.setBounds(400, 250, 550, 40);
        income.setSelectedItem(null);
        add(income);

        qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setFont(general);
        qualificationLabel.setBounds(140, 300, 250, 40);
        add(qualificationLabel);

        String[] qualificationTypes = {"Lower Secondary", "Senior Secondary", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        qualification = new JComboBox<>(qualificationTypes);
        qualification.setFont(general);
        qualification.setBackground(Color.WHITE);
        qualification.setBounds(400, 300, 550, 40);
        qualification.setSelectedItem(null);
        add(qualification);

        occupationLabel = new JLabel("Occupation");
        occupationLabel.setFont(general);
        occupationLabel.setBounds(140, 350, 250, 40);
        add(occupationLabel);

        String[] occupationTypes = {"Private", "Government", "Self-Employed", "Business", "Unemployed"};
        occupation = new JComboBox<>(occupationTypes);
        occupation.setFont(general);
        occupation.setBounds(400, 350, 550, 40);
        occupation.setSelectedItem(null);
        add(occupation);

        panLabel = new JLabel("PAN Number");
        panLabel.setFont(general);
        panLabel.setBounds(140, 400, 250, 40);
        add(panLabel);

        pan = new JTextField();
        pan.setFont(general);
        pan.setBounds(400, 400, 550, 40);
        add(pan);

        aadhaarLabel = new JLabel("Aadhaar");
        aadhaarLabel.setFont(general);
        aadhaarLabel.setBackground(Color.WHITE);
        aadhaarLabel.setBounds(140, 450, 150, 40);
        add(aadhaarLabel);

        aadhaar = new JTextField();
        aadhaar.setFont(general);
        aadhaar.setBounds(400, 450, 550, 40);
        add(aadhaar);


        seniorCitizenLabel = new JLabel("Senior Citizen");
        seniorCitizenLabel.setFont(general);
        seniorCitizenLabel.setBounds(140, 500, 250, 40);
        add(seniorCitizenLabel);

        yesSenior = new JRadioButton("Yes");
        yesSenior.setFont(general);
        yesSenior.setBackground(Color.WHITE);
        yesSenior.setBounds(400, 500, 150, 40);
        add(yesSenior);

        noSenior = new JRadioButton("No");
        noSenior.setFont(general);
        noSenior.setBackground(Color.WHITE);
        noSenior.setBounds(600, 500, 150, 40);
        add(noSenior);

        seniorCitizen = new ButtonGroup();
        seniorCitizen.add(yesSenior);
        seniorCitizen.add(noSenior);

        existingAccountLabel = new JLabel("Existing Account");
        existingAccountLabel.setFont(general);
        existingAccountLabel.setBounds(140, 550, 250, 40);
        add(existingAccountLabel);

        yesExisting = new JRadioButton("Yes");
        yesExisting.setFont(general);
        yesExisting.setBackground(Color.WHITE);
        yesExisting.setBounds(400, 550, 150, 40);
        add(yesExisting);

        noExisting = new JRadioButton("No");
        noExisting.setFont(general);
        noExisting.setBackground(Color.WHITE);
        noExisting.setBounds(600, 550, 150, 40);
        add(noExisting);

        existingAccount = new ButtonGroup();
        existingAccount.add(yesExisting);
        existingAccount.add(noExisting);

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


        setTitle("Sign Up Step 2");
        setSize(1200, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            try {
                Conn conn = new Conn();
                String religionString = (String) religion.getSelectedItem();
                String categoryString = (String) category.getSelectedItem();
                String incomeString = (String) income.getSelectedItem();
                String qualificationString = (String) qualification.getSelectedItem();
                String occupationString = (String) occupation.getSelectedItem();
                String panString = pan.getText();
                String aadhaarString = aadhaar.getText();
                String seniorCitizenString = null;
                if (yesSenior.isSelected()) seniorCitizenString = "Yes";
                else if (noSenior.isSelected()) seniorCitizenString = "No";


                String existingAccountString = null;
                if (yesExisting.isSelected()) existingAccountString = "Yes";
                else if (noExisting.isSelected()) existingAccountString = "No";

                conn.s.executeUpdate("insert into signUpTwo values('" + formNo + "' , '" + religionString + "' , '" + categoryString + "' , '" + incomeString + "' , '" + qualificationString + "' , '" + occupationString + "' , '" + panString + "' , '" + aadhaarString + "' , '" + seniorCitizenString + "' , '" + existingAccountString + "')");
                new SignUpThree(formNo);
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
