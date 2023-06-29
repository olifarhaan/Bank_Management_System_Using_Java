import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton clear, signIn, signUp;
    JTextField cardNumber;
    JPasswordField pinNumber;
    JLabel title, card, pin;

    Login() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImage));
        iconLabel.setBounds(200, 100, 150, 150);
        add(iconLabel);
        title = new JLabel("Bank Management System");
        title.setFont(new Font("Verdana", Font.BOLD, 35));
        title.setBounds(370, 100, 600, 150);
        add(title);

        card = new JLabel("Account Number");
        card.setFont(new Font("Verdana", Font.BOLD, 25));
        card.setBounds(200, 300, 300, 40);
        add(card);

        cardNumber = new JTextField();
        cardNumber.setFont(new Font("Verdana", Font.BOLD, 22));
        cardNumber.setBounds(520, 300, 400, 40);
        add(cardNumber);

        pin = new JLabel("4 Digit PIN");
        pin.setFont(new Font("Verdana", Font.BOLD, 25));
        pin.setBounds(200, 360, 300, 40);
        add(pin);

        pinNumber = new JPasswordField();
        pinNumber.setFont(new Font("Verdana", Font.BOLD, 22));
        pinNumber.setBounds(520, 360, 400, 40);
        add(pinNumber);

        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Verdana", Font.BOLD, 22));
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.setBounds(520, 440, 190, 40);
        add(signIn);
        signIn.addActionListener(this);

        clear = new JButton("Clear");
        clear.setFont(new Font("Verdana", Font.BOLD, 22));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(730, 440, 190, 40);
        add(clear);
        clear.addActionListener(this);

        signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Verdana", Font.BOLD, 22));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setBounds(520, 500, 400, 40);
        add(signUp);
        signUp.addActionListener(this);

        setTitle("Bank Management System");
        setSize(1200, 850);
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Verdana", Font.BOLD, 20)));
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 300));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signIn) {
            try {
                Conn conn = new Conn();
                String pinNumberString = new String(pinNumber.getPassword());
                ResultSet rs = conn.s.executeQuery("select * from login where cardNo='" + cardNumber.getText() + "' and pin='" + pinNumberString + "'");
                if (rs.next()) {
                    new Transaction(cardNumber.getText());
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == signUp) {
            new SignUpOne().setVisible(true);
            setVisible(false);
        } else if (e.getSource() == clear) {
            pinNumber.setText("");
            cardNumber.setText("");
        }
    }
}
