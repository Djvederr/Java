package GUITests;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Extends From JFrame
//implements ActionListener
public class Project extends JFrame implements ActionListener{
    JTextField num1 = new JTextField(20);
    JTextField num2 = new JTextField(20);
    JTextField sum = new JTextField(20);
    JButton btn = new JButton("Add");

    JButton btn2=new JButton("Subtract");

    JPanel numpanel=new JPanel();

    JPanel buttonPanel=new JPanel();



    public Project(){
//Add the ActionListener to the Button
        btn.addActionListener(this);
        btn2.addActionListener(this);
        setLayout(null);
        add(numpanel);
        add(buttonPanel);
        numpanel.add(num1);
        numpanel.add(num2);
        buttonPanel.add(btn);
        buttonPanel.add(btn2);
        add(sum);
        setSize(400, 120);
        numpanel.setLayout(new GridLayout(1,2));
        buttonPanel.setLayout(new GridLayout(1,2));
        setLayout(new GridLayout(3,1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setVisible(true);
        //System.out.println(this);
    }
    public static void main(String[] args){

        Project p=new Project();
        //System.out.println(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int c=0;
        int a = Integer.parseInt(num1.getText());
        int b = Integer.parseInt(num2.getText());
        if(e.getActionCommand().compareTo("Add")==0){

            c = a + b;
        }
        else{
            c = a - b;
        }
        sum.setText(""+c);
    }
}