import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JLabel heading;
    String cardNumber, type = "Withdraw";
    JButton withdrawal, back;
    JTextField amount;

    Withdrawal(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(0, 0, 900, 950);
        add(iconLabel);

        heading = new JLabel("Enter Amount To Withdraw");
        heading.setFont(new Font("Verdana", Font.BOLD, 19));
        heading.setBounds(200, 320, 450, 50);
        heading.setForeground(Color.WHITE);
        iconLabel.add(heading);

        amount = new JTextField();
        amount.setFont(new Font("Verdana", Font.BOLD, 25));
        amount.setBounds(160, 380, 350, 60);
        iconLabel.add(amount);


        Font buttonFont = new Font("Verdana", Font.BOLD, 13);

        back = new JButton("Go Back");
        back.setFont(buttonFont);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.RED);
        back.setBounds(160, 549, 170, 30);
        back.addActionListener(this);
        iconLabel.add(back);

        withdrawal = new JButton("Withdraw");
        withdrawal.setFont(buttonFont);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setBackground(Color.YELLOW);
        withdrawal.setBounds(340, 549, 170, 30);
        withdrawal.addActionListener(this);
        iconLabel.add(withdrawal);

        setTitle("Withdraw");
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setSize(900, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawal) {
            String amountString = amount.getText();
            if (amountString.equals("") || Integer.parseInt(amountString) <= 0) {
                JOptionPane.showMessageDialog(null, "Enter some amount to deposit");
            } else {
                long totalAmount = 0L;
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where cardNo='" + cardNumber + "'");
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit"))
                            totalAmount += Integer.parseInt(rs.getString("amount"));
                        else totalAmount -= Integer.parseInt(rs.getString("amount"));
                    }
                    if (totalAmount < Integer.parseInt(amountString)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {
                        Date date = new Date();
                        conn.s.executeUpdate("insert into bank values('" + cardNumber + "' , '" + type + "' , '" + date + "' , '" + amountString + "')");
                        JOptionPane.showMessageDialog(null, "Amount " + amountString + " debited successfully");
                        new Transaction(cardNumber).setVisible(true);
                        setVisible(false);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }


        } else if (e.getSource() == back) {
            new Transaction(cardNumber).setVisible(true);
            setVisible(false);
        }
    }
}
