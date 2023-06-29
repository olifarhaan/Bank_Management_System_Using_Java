import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel heading;
    String pinNumber, cardNumber;
    JButton exit;

    BalanceEnquiry(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(0, 0, 900, 950);
        add(iconLabel);

        long totalAmount = 0L;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where cardNo='" + cardNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) totalAmount += Integer.parseInt(rs.getString("amount"));
                else totalAmount -= Integer.parseInt(rs.getString("amount"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        heading = new JLabel("Your Balance is : Rs " + totalAmount);
        heading.setFont(new Font("Verdana", Font.BOLD, 19));
        heading.setBounds(170, 320, 450, 50);
        heading.setForeground(Color.WHITE);
        iconLabel.add(heading);

        exit = new JButton("Back");
        exit.setFont(new Font("Verdana", Font.BOLD, 14));
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.setBounds(340, 549, 170, 30);
        exit.addActionListener(this);
        iconLabel.add(exit);

        setTitle("BalanceEnquiry");
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setSize(900, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            new Transaction(cardNumber);
        }
    }
}
