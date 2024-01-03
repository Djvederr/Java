package CelebrityGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class CelebrityGameGUI extends JFrame {
    JLabel display;

    JTextField answer;

    JButton enter;

    CelebrityGame game;

    public CelebrityGameGUI()  throws FileNotFoundException{
        display = new JLabel("Welcome to guess the celebrities!",JLabel.CENTER);
        answer = new JTextField();
        enter = new JButton("Start");
        enter.setFont(new Font("Verdana", Font.PLAIN, 20));
        display.setFont(new Font("Verdana", Font.PLAIN, 16));
        answer.setFont(new Font("Verdana", Font.PLAIN, 15));
        setLayout(new GridLayout(3,1,10,0));

        add(display);
        add(answer);
        add(enter);

        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton();
            }
        });
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String action=e.getActionCommand();

                if (action.equals("Start") || action.equals("Play again") ) {
                    if(!game.gameOver()){
                        game.pickCelebrity();
                        enter.setText("Submit");
                        display.setText(game.getNextClue());
                    }
                    else{
                        enter.setText("Exit");
                        display.setText("Game finished!");
                    }
                } else if (action.equals("Submit")) {
                    submitButton();
                } else if (action.equals("Next clue")) {
                    display.setText(game.getNextClue());
                    enter.setText("Submit");
                } else {
                    display.setText("An error occurred");
                    enter.setText("Start");
                }
                if(action.equals("Exit")){
                    System.exit(0);
                }
            }
        });



        game=new CelebrityGame("resources\\Celebrities.csv");

        setSize(600, 400);
        setVisible(true);

    }
    public void submitButton(){
        if(enter.getText().equals("Submit")){
            String a = answer.getText();
            answer.setText("");
            if (game.checkAnswer(a)) {
                display.setText("Correct!");
                enter.setText("Play again");

            } else if (game.hasMoreClues()) {
                display.setText("Incorrect!");
                enter.setText("Next clue");
            } else {
                display.setText("<html>Incorrect! <br> Exceeded 3 attempts,<br><strong>" + game.getAnswer() + "</strong>, Round over!</html>");
                enter.setText("Play again");
            }
        }
    }

    public static void main(String[] args)  throws FileNotFoundException{
        new CelebrityGameGUI();
    }



}
