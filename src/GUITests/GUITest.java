package GUITests;

import javax.swing.*;
import java.awt.*;

public class GUITest extends JFrame{
    private JPanel MainPanel;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel2;
    private JButton button1;
    private JButton button5;
    private JTextField textField1;
    private JPanel panel1;


    private void createUIComponents() {
        // TODO: place custom component creation code here
        setContentPane(MainPanel);
        setSize(400, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setVisible(true);


    }
    public static void main(String[] args){
        new GUITest().createUIComponents();
    }

}
