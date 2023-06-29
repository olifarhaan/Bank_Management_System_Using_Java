import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JLabel heading;
    String cardNumber, type="Deposit";
    JButton deposit, back;
    JTextField amount;

    Deposit(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(0, 0, 900, 950);
        add(iconLabel);

        heading = new JLabel("Enter Amount To Deposit");
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

        deposit = new JButton("Deposit");
        deposit.setFont(buttonFont);
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.YELLOW);
        deposit.setBounds(340, 549, 170, 30);
        deposit.addActionListener(this);
        iconLabel.add(deposit);

        setTitle("Deposit");
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setSize(900, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String amountString= amount.getText();
            if(amountString.equals("") || Integer.parseInt(amountString)<=0){
                JOptionPane.showMessageDialog(null, "Enter some amount to deposit");
            }
            else{
                Conn conn=new Conn();
                Date date= new Date();
                try {
                    conn.s.executeUpdate("insert into bank values('" + cardNumber + "' , '" + type + "' , '" + date + "' , '" + amountString + "')");
                    JOptionPane.showMessageDialog(null, "Amount "+amountString+" deposited successfully");
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
