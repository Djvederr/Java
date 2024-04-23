package Minesweeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MinesweeperGUI implements ActionListener
{
    JFrame frameObj;
    JButton[][] buttonArr;
    Board board;
    Icon[] icons;
    int[] gameLevel;

    boolean firstClick=false;

    public MinesweeperGUI(int x1,int y1,int bombamt)
    {
        frameObj = new JFrame();

        board=new Board(x1,y1,bombamt);
        int[] temp={x1,y1,bombamt};
        this.gameLevel=temp;

        icons=new Icon[10];
        for(int i=-1;i<=8;i++){
            icons[i+1]=new ImageIcon("resources\\Opened-"+i+".png");
        }

        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonArr=new JButton[x1][y1];
        for(int i=0;i<x1;i++){
            for(int j=0;j<y1;j++){
                buttonArr[i][j]=new JButton(new ImageIcon("resources\\Unopened.png"));
                buttonArr[i][j].addActionListener(this);
                //System.out.print(board[i][0].getTile());
                frameObj.add(buttonArr[i][j]);
            }
            //System.out.println();

        }

        frameObj.setTitle("Minesweeper");

        frameObj.setLayout(new GridLayout(x1,y1));


        frameObj.setSize(80*x1, 80*x1);
        frameObj.setVisible(true);

    }

    public void updateBoard(){
        for(int i=0;i<gameLevel[0];i++) {
            for(int j = 0; j < gameLevel[1]; j++) {
                if(board.board[i][j].state) {
                    buttonArr[i][j].setIcon(icons[board.board[i][j].contents+1]);
                }
                //System.out.print(board[i][0].getTile());
                frameObj.add(buttonArr[i][j]);
            }
            //System.out.println();

        }
    }

    public void printBeforeBoard(){
        for(int i=1;i<=gameLevel[0];i++){
            for(int j=1;j<=gameLevel[1];j++){
                System.out.print(" X");
            }
            System.out.println();
        }
    }

    public void gameEnd(String message) {
        JDialog d = new JDialog(frameObj, "Game over", true);

        JButton b = new JButton("OKAY!");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        JLabel label1 = new JLabel(message);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Monospaced", Font.BOLD, 30);
        ;
        if (message.compareTo("YOU WON!") == 0){
            label1.setForeground(new Color(0, 255, 0));
            b.setForeground(new Color(0, 255, 0));
        }
        else{
            label1.setForeground(new Color(255,0,0));
            b.setForeground(new Color(255, 0, 0));
            b.setText("OK");
        }
        b.setFont(font);
        label1.setFont(font);
        d.add( label1);

        d.add(b);
        d.setLayout( new GridLayout(2,1) );
        d.setSize(300,300);
        d.setVisible(true);
    }

    public void buttonPress(int r,int c){
        if(!firstClick){
            board.generateBoard(r,c);
            firstClick=true;
        }
        board.selectCell(r, c);
        updateBoard();

        if(board.gameOver) {
            if(board.win){
                System.out.println("YOU WON!");
                gameEnd("YOU WON!");
            }
            else {
                System.out.println("YOU LOST!");
                gameEnd("YOU LOST!");
            }
            gameDone();
        }
        //board.testBoard();
    }

    public void gameDone(){
        for(int i=0;i<gameLevel[0];i++) {
            for(int j = 0; j < gameLevel[1]; j++) {

                board.board[i][j].setState(true);


                //System.out.print(board[i][0].getTile());

            }

            //System.out.println();

        }
        updateBoard();

    }


    public static void main(String args[])
    {
        new MinesweeperGUI(8,8,6);

    }

    public int[] getRowCol(JButton button){
        for(int i=0;i<gameLevel[0];i++) {
            for(int j = 0; j < gameLevel[1]; j++) {
                if(buttonArr[i][j]==button){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!board.gameOver) {

            int[] loc = getRowCol((JButton) e.getSource());
            System.out.println(loc[0] +" "+ loc[1]);
            //System.out.println(loc[0]);
            //System.out.println(loc[1]);
            buttonPress(loc[0], loc[1]);
        }


    }
}