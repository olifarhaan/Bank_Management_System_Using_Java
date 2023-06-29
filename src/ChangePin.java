import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class ChangePin extends JFrame implements ActionListener {
    JLabel heading, newPinLabel, reNewPinLabel;
    String cardNumber;
    JButton changePin, back;
    JPasswordField newPinNumber, reNewPinNumber;

    ChangePin(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        Font buttonFont = new Font("Verdana", Font.BOLD, 13);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(0, 0, 900, 950);
        add(iconLabel);

        heading = new JLabel("Change Your PIN");
        heading.setFont(new Font("Verdana", Font.BOLD, 19));
        heading.setBounds(220, 290, 450, 50);
        heading.setForeground(Color.WHITE);
        iconLabel.add(heading);

        newPinLabel = new JLabel("Enter the new PIN");
        newPinLabel.setFont(buttonFont);
        newPinLabel.setForeground(Color.WHITE);
        newPinLabel.setBounds(160, 340, 150, 40);
        iconLabel.add(newPinLabel);


        newPinNumber = new JPasswordField();
        newPinNumber.setFont(new Font("Verdana", Font.BOLD, 25));
        newPinNumber.setBounds(340, 340, 150, 40);
        iconLabel.add(newPinNumber);


        reNewPinLabel = new JLabel("Re-enter the new PIN");
        reNewPinLabel.setFont(buttonFont);
        reNewPinLabel.setForeground(Color.WHITE);
        reNewPinLabel.setBounds(160, 390, 170, 40);
        iconLabel.add(reNewPinLabel);

        reNewPinNumber = new JPasswordField();
        reNewPinNumber.setFont(new Font("Verdana", Font.BOLD, 25));
        reNewPinNumber.setBounds(340, 390, 150, 40);
        iconLabel.add(reNewPinNumber);

        back = new JButton("Go Back");
        back.setFont(buttonFont);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.RED);
        back.setBounds(160, 549, 170, 30);
        back.addActionListener(this);
        iconLabel.add(back);

        changePin = new JButton("Change Pin");
        changePin.setFont(buttonFont);
        changePin.setForeground(Color.BLACK);
        changePin.setBackground(Color.YELLOW);
        changePin.setBounds(340, 549, 170, 30);
        changePin.addActionListener(this);
        iconLabel.add(changePin);

        setTitle("Change Pin");
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setSize(900, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ChangePin("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePin) {
            String newPinNumberString = new String(newPinNumber.getPassword());
            String reNewPinNumberString = new String(reNewPinNumber.getPassword());
            if (!newPinNumberString.equals(reNewPinNumberString)) {
                JOptionPane.showMessageDialog(null, "Enter the correct new PIN twice");
            } else {
                Conn conn = new Conn();
                try {
                    conn.s.executeUpdate("update login set pin='" + newPinNumberString + "' where cardNo= '" + cardNumber + "'");
                    JOptionPane.showMessageDialog(null, "PIN updated successfully");
                    new Transaction(cardNumber).setVisible(true);
                    setVisible(false);
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

