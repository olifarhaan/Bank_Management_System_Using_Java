
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JButton submit, back;
    String formNo;
    JLabel formNoTitleLabel, headingLabel, accountTypeLabel, cardLabel, cardDescLabel, cardNumberLabel, cardNumberDescLabel,
            pinNumberLabel, pinNumberDescLabel, pinNumberNoLabel, serviceRequiredLabel;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatements, declaration;
    JRadioButton saving, fixedDeposit, current, recurringDeposit;
    ButtonGroup accountType;

    SignUpThree(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        Font general = new Font("Verdana", Font.BOLD, 23);
        Font description = new Font("Verdana", Font.BOLD, 17);

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

        headingLabel = new JLabel("Step 3: Account Details");
        headingLabel.setFont(general);
        headingLabel.setBounds(370, 80, 600, 40);
        add(headingLabel);

        accountTypeLabel = new JLabel("Select the Account Type");
        accountTypeLabel.setFont(general);
        accountTypeLabel.setBounds(80, 200, 400, 40);
        add(accountTypeLabel);

        saving = new JRadioButton("Saving Account");
        saving.setFont(general);
        saving.setBackground(Color.WHITE);
        saving.setBounds(80, 250, 400, 40);
        add(saving);

        fixedDeposit = new JRadioButton("Fixed Deposit Account");
        fixedDeposit.setFont(general);
        fixedDeposit.setBackground(Color.WHITE);
        fixedDeposit.setBounds(490, 250, 400, 40);
        add(fixedDeposit);

        current = new JRadioButton("Current Account");
        current.setFont(general);
        current.setBackground(Color.WHITE);
        current.setBounds(80, 300, 400, 40);
        add(current);

        recurringDeposit = new JRadioButton("Recurring Deposit Account");
        recurringDeposit.setFont(general);
        recurringDeposit.setBackground(Color.WHITE);
        recurringDeposit.setBounds(490, 300, 400, 40);
        add(recurringDeposit);

        accountType = new ButtonGroup();
        accountType.add(saving);
        accountType.add(fixedDeposit);
        accountType.add(current);
        accountType.add(recurringDeposit);


        cardLabel = new JLabel("Card Number");
        cardLabel.setFont(general);
        cardLabel.setBounds(80, 360, 300, 40);
        add(cardLabel);

        cardDescLabel = new JLabel("(Your 16 Digit Card Number)");
        cardDescLabel.setFont(description);
        cardDescLabel.setBounds(80, 400, 400, 40);
        add(cardDescLabel);

        cardNumberLabel = new JLabel("5040-9368-XXXX-XXXX");
        cardNumberLabel.setFont(general);
        cardNumberLabel.setBounds(500, 360, 400, 40);
        add(cardNumberLabel);

        cardNumberDescLabel = new JLabel("(It would appear on ATM Card/Cheque Book and Statements)");
        cardNumberDescLabel.setFont(description);
        cardNumberDescLabel.setBounds(500, 400, 650, 40);
        add(cardNumberDescLabel);

        pinNumberLabel = new JLabel("PIN");
        pinNumberLabel.setFont(general);
        pinNumberLabel.setBounds(80, 470, 250, 40);
        add(pinNumberLabel);

        pinNumberDescLabel = new JLabel("(4-digit password)");
        pinNumberDescLabel.setFont(description);
        pinNumberDescLabel.setBounds(80, 510, 300, 40);
        add(pinNumberDescLabel);

        pinNumberNoLabel = new JLabel("XXXX");
        pinNumberNoLabel.setFont(general);
        pinNumberNoLabel.setBounds(500, 470, 250, 40);
        add(pinNumberNoLabel);

        serviceRequiredLabel = new JLabel("Services Required");
        serviceRequiredLabel.setFont(general);
        serviceRequiredLabel.setBounds(80, 580, 400, 40);
        add(serviceRequiredLabel);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(general);
        atmCard.setBounds(80, 630, 300, 40);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(general);
        internetBanking.setBounds(390, 630, 300, 40);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(general);
        mobileBanking.setBounds(700, 630, 250, 40);
        add(mobileBanking);

        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setFont(general);
        emailAlerts.setBounds(80, 680, 250, 40);
        add(emailAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(general);
        chequeBook.setBounds(390, 680, 250, 40);
        add(chequeBook);

        eStatements = new JCheckBox("E-Statements");
        eStatements.setBackground(Color.WHITE);
        eStatements.setFont(general);
        eStatements.setBounds(700, 680, 250, 40);
        add(eStatements);

        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(description);
        declaration.setBounds(80, 740, 1100, 40);
        add(declaration);


        back = new JButton("Back");
        back.setFont(general);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.RED);
        back.setBounds(80, 800, 200, 80);
        back.addActionListener(this);
        add(back);

        submit = new JButton("Submit");
        submit.setFont(general);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(790, 800, 200, 80);
        submit.addActionListener(this);
        add(submit);


        setTitle("Sign Up Step 3");
        setSize(1200, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                if (!declaration.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please check the declaration statement");
                } else {

                    String accountTypeString = null;
                    if (saving.isSelected()) accountTypeString = "Saving Account";
                    else if (fixedDeposit.isSelected()) accountTypeString = "Fixed Deposit Account";
                    else if (current.isSelected()) accountTypeString = "Current Account";
                    else if (recurringDeposit.isSelected()) accountTypeString = "Recurring Account";
                    Random random = new Random();
                    String cardNumber = String.valueOf(Math.abs((random.nextLong() % 900000000L) + 5040936800000000L));
                    String pinNumber = String.valueOf(Math.abs((random.nextInt() % 9000L)) + 1000L);

                    StringBuilder services = new StringBuilder();
                    if (atmCard.isSelected()) services.append(" ATM Card");
                    else if (internetBanking.isSelected()) services.append(" Internet Banking");
                    if (mobileBanking.isSelected()) services.append(" Mobile Banking");
                    if (emailAlerts.isSelected()) services.append(" Email Alerts");
                    if (chequeBook.isSelected()) services.append(" Cheque Book");
                    else if (eStatements.isSelected()) services.append(" E-Statements");

                    String serviceString = services.toString();
                    String query1 = "insert into signUpThree values('" + formNo + "','" + accountTypeString + "','" + cardNumber + "','" + pinNumber + "','" + serviceString + "')";
                    String query2 = "insert into login values('" + formNo + "','" + cardNumber + "','" + pinNumber + "')";
                    Conn conn = new Conn();
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin :" + pinNumber + "\nKeep the credentials at safe place");
                    setVisible(false);
                    new Deposit(cardNumber);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Login();
            setVisible(false);
        }
    }
}
