package Experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JApplet implements ActionListener {
    public static void main(String[] args) {    // 这 main 方法只在调试时用到
        calculator sc = new calculator();
        sc.init();

        JFrame f = new JFrame();
        f.add(sc);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }

    private JTextField num1 = new JTextField(),
            num2 = new JTextField(),
            result = new JTextField(20);

    public void init() {
        setLayout(new GridLayout(0, 2, 2, 2));
        add(num1);
        add(num2);
        for (String cmd: new String[]{"加", "减", "乘", "除"}) {
            JButton b = new JButton(cmd);
            b.addActionListener(this);
            add(b);
        }
        add(new JLabel("结果：", JLabel.TRAILING));
        add(result);
        result.setEditable(false);
        getRootPane().setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.valueOf(num1.getText()),
                    n2 = Double.valueOf(num2.getText());
            String cmd = e.getActionCommand();
            if (cmd == "加") result.setText(n1 + n2 + "");
            if (cmd == "减") result.setText(n1 - n2 + "");
            if (cmd == "乘") result.setText(n1 * n2 + "");
            if (cmd == "除") result.setText(n1 / n2 + "");

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "数字个数或格式错误！",
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }
}