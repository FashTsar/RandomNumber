import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class General extends JFrame {
    JButton b1, b2;
    JTextField t1, t2;
    JLabel l1, l2, l3;
    int x, y;

    Calculat calk = new Calculat();
    Random rnd = new Random(System.currentTimeMillis());

    public General (String s) {
        super(s);
        setLayout(new FlowLayout());
        l1 = new JLabel("Введите минимальное значение:   ");
        t1 = new JTextField(5);
        l2 = new JLabel("Введите максимальное значение: ");
        t2 = new JTextField(5);
        b1 = new JButton("Очистить");
        b2 = new JButton("Посчитать");
        l3 = new JLabel("");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);
        add(l3);
        b1.addActionListener(calk);
        b2.addActionListener(calk);
    }

    public class Calculat implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == b2) {
                    x = Integer.parseInt(t1.getText());
                    y = Integer.parseInt(t2.getText());
                    int r = x + rnd.nextInt(y - x + 1);
                    String res = "Рандомное число = " + r;
                    l3.setText(res);
                }

                if (e.getSource() == b1) {
                    t1.setText("");
                    t2.setText("");
                    l3.setText("");
                }
            }catch (Exception ex){ JOptionPane.showMessageDialog(null, "Поля заполнены неверно!!!"); }
        }
    }
}
