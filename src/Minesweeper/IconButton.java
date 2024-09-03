package Minesweeper;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.File;

public class IconButton {

    public static void main(String args[]) {
        JFrame frame = new JFrame("DefaultButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon warnIcon = new ImageIcon("O/Users/vedmahesh/IdeaProjects/Java/src/Minesweeper/Opened-1.png");
        JButton button2 = new JButton(warnIcon);
        frame.add(button2);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
