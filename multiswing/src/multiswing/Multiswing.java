package multiswing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Multiswing extends JFrame {

    private JLabel imgLabel, textLabel;
    private JTextArea ta;
    private JTextArea tb;
    private JTextField tf;
    private JButton clearButton;
    private ImageIcon img;
    private Container c;
    private Font f;
    private Cursor cursor;
    private JRadioButton done, notdone;
    private ButtonGroup grp;
    private JCheckBox javaCheckBox, cCheckBox;

    Multiswing() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);

        f = new Font("Tamoha", Font.BOLD, 20);

        textLabel = new JLabel("Multiplication Table");
        textLabel.setBounds(66, 2, 200, 20);
        textLabel.setForeground(Color.BLUE);

        textLabel.setFont(f);
        c.add(textLabel);

        img = new ImageIcon(getClass().getResource("iig.jpg"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(20, 24, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);

        textLabel = new JLabel("Enter any number :");
        textLabel.setBounds(10, 174, 200, 200);
        textLabel.setForeground(Color.blue);
        textLabel.setFont(f);
        c.add(textLabel);

        tf = new JTextField();
        tf.setBounds(200, 260, 90, 35);
        tf.setFont(f);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBackground(Color.pink);
        c.add(tf);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        clearButton = new JButton("Clear");
        clearButton.setBounds(200, 300, 90, 35);
        clearButton.setCursor(cursor);
        clearButton.setBackground(Color.yellow);
        c.add(clearButton);

        ta = new JTextArea();
        ta.setBounds(16, 340, 275, 268);
        ta.setBackground(Color.pink);
        ta.setFont(f);
        c.add(ta);

        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value = tf.getText();
                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You didnt put any number");

                } else {
                    ta.setText("");
                    int num = Integer.parseInt(tf.getText());

                    for (int i = 1; i <= 10; i++) {

                        int result = num * i;
                        String r = String.valueOf(result);
                        String n = String.valueOf(num);
                        String incr = String.valueOf(i);

                        ta.append(n + " X " + incr + " = " + r + "\n");
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");

            }

        });
        grp = new ButtonGroup();

        javaCheckBox = new JCheckBox("See a multiplication table");
        javaCheckBox.setBounds(10, 216, 200, 20);
        javaCheckBox.setBackground(Color.cyan);
        c.add(javaCheckBox);

        cCheckBox = new JCheckBox("Dont want to see a multiplication table");
        cCheckBox.setBounds(10, 236, 400, 20);
        cCheckBox.setBackground(Color.cyan);
        c.add(cCheckBox);

        grp.add(javaCheckBox);
        grp.add(cCheckBox);

        done = new JRadioButton("DONE");
        done.setBounds(18, 610, 80, 15);
        done.setBackground(Color.cyan);
        c.add(done);

        notdone = new JRadioButton("NOTDONE");
        notdone.setBounds(120, 610, 120, 15);
        notdone.setBackground(Color.cyan);

        c.add(notdone);

        grp.add(done);
        grp.add(notdone);

        tb = new JTextArea();
        tb.setBounds(16, 626, 275, 22);
        tb.setBackground(Color.pink);
        c.add(tb);

        Handler handler = new Handler();
        done.addActionListener(handler);
        notdone.addActionListener(handler);

    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == done) {
                tb.setText("You have seen a multiplication table");
            } else {
                tb.setText("Enter another number");
            }

        }
    }

    public static void main(String[] args) {
        Multiswing frame = new Multiswing();
        frame.setVisible(true);
        frame.setBounds(300, 20, 320, 700);
        frame.setTitle("MULTIPLICATION TABLE");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
