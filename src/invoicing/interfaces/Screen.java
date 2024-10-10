package invoicing.interfaces;
import javax.swing.*;

public class Screen extends JFrame{

    public Screen(){
        setVisible(true);
        setSize(800, 500);
        setTitle("Screen invoicing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        JButton jButton = new JButton("clique aqui");
        add(jButton);

    }
}
