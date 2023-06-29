import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JLabel heading;
    String pinNumber, cardNumber;
    JButton deposit, cashWithdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;

    Transaction(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(0, 0, 900, 950);
        add(iconLabel);

        heading = new JLabel("Please Select Your Transaction");
        heading.setFont(new Font("Verdana", Font.BOLD, 19));
        heading.setBounds(170, 320, 450, 50);
        heading.setForeground(Color.WHITE);
        iconLabel.add(heading);

        Font buttonFont = new Font("Verdana", Font.BOLD, 13);
        deposit = new JButton("Deposit");
        deposit.setFont(buttonFont);
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.setBounds(160, 442, 170, 30);
        deposit.addActionListener(this);
        iconLabel.add(deposit);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setFont(buttonFont);
        cashWithdrawal.setForeground(Color.BLACK);
        cashWithdrawal.setBackground(Color.WHITE);
        cashWithdrawal.setBounds(340, 442, 170, 30);
        cashWithdrawal.addActionListener(this);
        iconLabel.add(cashWithdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setFont(buttonFont);
        fastCash.setForeground(Color.BLACK);
        fastCash.setBackground(Color.WHITE);
        fastCash.setBounds(160, 477, 170, 30);
        fastCash.addActionListener(this);
        iconLabel.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setFont(buttonFont);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.setBounds(340, 477, 170, 30);
        miniStatement.addActionListener(this);
        iconLabel.add(miniStatement);

        pinChange = new JButton("PIN Change");
        pinChange.setFont(buttonFont);
        pinChange.setForeground(Color.BLACK);
        pinChange.setBackground(Color.WHITE);
        pinChange.setBounds(160, 513, 170, 30);
        pinChange.addActionListener(this);
        iconLabel.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setFont(buttonFont);
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.setBounds(340, 513, 170, 30);
        balanceEnquiry.addActionListener(this);
        iconLabel.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setFont(buttonFont);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.setBounds(340, 549, 170, 30);
        exit.addActionListener(this);
        iconLabel.add(exit);

        setTitle("Transaction");
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setSize(900, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            new Deposit(cardNumber);
            setVisible(false);
        } else if (e.getSource() == cashWithdrawal) {
            new Withdrawal(cardNumber);
            setVisible(false);
        } else if (e.getSource() == fastCash) {
            new FastCash(cardNumber);
            setVisible(false);
        } else if (e.getSource() == miniStatement) {
            new MiniStatement(cardNumber);
            setVisible(false);
        } else if (e.getSource() == pinChange) {
            new ChangePin(cardNumber);
            setVisible(false);
        } else if (e.getSource() == balanceEnquiry) {
            new BalanceEnquiry(cardNumber);
            setVisible(false);
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
