import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    private String cardNumber;
    private JTable statementTable;
    private JLabel title, description;
    private JScrollPane statementTableScroller;

    private JButton print, back;

    MiniStatement(String cardNumber) {
        this.cardNumber = cardNumber;

        title = new JLabel("Card Number : " + cardNumber);
        title.setFont(new Font("Vardana", Font.BOLD, 25));
        title.setBounds(40, 50, 550, 60);
        add(title);

        description = new JLabel("Your recent 10 transactions is listed");
        description.setFont(new Font("Vardana", Font.BOLD, 18));
        description.setBounds(40, 120, 550, 30);
        add(description);


        statementTable = new JTable();

        JTableHeader header = statementTable.getTableHeader();
        header.setFont(new Font("Verdana", Font.PLAIN, 25));
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        JTableUtilities.setCellsAlignment(statementTable, SwingConstants.CENTER);
        statementTable.setFont(new Font("Verdana", Font.PLAIN, 25));
        statementTable.setRowHeight(40);
        statementTableScroller = new JScrollPane(statementTable);
        statementTableScroller.setBounds(40, 200, 600, 400);
        add(statementTableScroller);
        Conn conn = new Conn();
        String query = "select date, amount, type from bank where cardNo='" + cardNumber + "' order by date desc limit 10";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            statementTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setFont(new Font("Vardana", Font.BOLD, 25));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.RED);
        back.setBounds(80, 650, 200, 80);
        back.addActionListener(this);
        add(back);

        print = new JButton("Print");
        print.setFont(new Font("Vardana", Font.BOLD, 25));
        print.setForeground(Color.WHITE);
        print.setBackground(Color.BLACK);
        print.setBounds(400, 650, 200, 80);
        print.addActionListener(this);
        add(print);


        setLayout(null);
        setTitle("Statement");
        setSize(690, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Transaction(cardNumber).setVisible(true);
            setVisible(false);
        } else if (e.getSource() == print) {
            try {
                statementTable.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
