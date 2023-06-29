import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel heading;
    String cardNumber;
    private final String type = "Withdraw";
    JButton five, ten, twenty, forty, fifty, hundred, back;

    FastCash(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(0, 0, 900, 950);
        add(iconLabel);

        heading = new JLabel("Please Select Your FastCash");
        heading.setFont(new Font("Verdana", Font.BOLD, 19));
        heading.setBounds(170, 320, 450, 50);
        heading.setForeground(Color.WHITE);
        iconLabel.add(heading);

        Font buttonFont = new Font("Verdana", Font.BOLD, 13);
        five = new JButton("Rs 500");
        five.setFont(buttonFont);
        five.setForeground(Color.BLACK);
        five.setBackground(Color.WHITE);
        five.setBounds(160, 442, 170, 30);
        five.addActionListener(this);
        iconLabel.add(five);

        ten = new JButton("Rs 1000");
        ten.setFont(buttonFont);
        ten.setForeground(Color.BLACK);
        ten.setBackground(Color.WHITE);
        ten.setBounds(340, 442, 170, 30);
        ten.addActionListener(this);
        iconLabel.add(ten);

        twenty = new JButton("Rs 2000");
        twenty.setFont(buttonFont);
        twenty.setForeground(Color.BLACK);
        twenty.setBackground(Color.WHITE);
        twenty.setBounds(160, 477, 170, 30);
        twenty.addActionListener(this);
        iconLabel.add(twenty);

        forty = new JButton("Rs 4000");
        forty.setFont(buttonFont);
        forty.setForeground(Color.BLACK);
        forty.setBackground(Color.WHITE);
        forty.setBounds(340, 477, 170, 30);
        forty.addActionListener(this);
        iconLabel.add(forty);

        fifty = new JButton("Rs 5000");
        fifty.setFont(buttonFont);
        fifty.setForeground(Color.BLACK);
        fifty.setBackground(Color.WHITE);
        fifty.setBounds(160, 513, 170, 30);
        fifty.addActionListener(this);
        iconLabel.add(fifty);

        hundred = new JButton("Rs 10000");
        hundred.setFont(buttonFont);
        hundred.setForeground(Color.BLACK);
        hundred.setBackground(Color.WHITE);
        hundred.setBounds(340, 513, 170, 30);
        hundred.addActionListener(this);
        iconLabel.add(hundred);

        back = new JButton("Cancel");
        back.setFont(buttonFont);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.RED);
        back.setBounds(340, 549, 170, 30);
        back.addActionListener(this);
        iconLabel.add(back);

        setTitle("FastCash");
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setSize(900, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Transaction(cardNumber).setVisible(true);
            setVisible(false);
        } else {
            int currentAmount = Integer.parseInt((((JButton) e.getSource()).getText()).substring(3));
            long totalAmount = 0L;
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where cardNo='" + cardNumber + "'");
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) totalAmount += Integer.parseInt(rs.getString("amount"));
                    else totalAmount -= Integer.parseInt(rs.getString("amount"));
                }
                if (totalAmount < currentAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {
                    Date date = new Date();
                    conn.s.executeUpdate("insert into bank values('" + cardNumber + "' , '" + type + "' , '" + date + "' , '" + currentAmount + "')");
                    JOptionPane.showMessageDialog(null, "Amount " + currentAmount + " debited successfully");
                    new Transaction(cardNumber).setVisible(true);
                    setVisible(false);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
