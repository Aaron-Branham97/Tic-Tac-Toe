package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe {

    private static final int DEFAULT_WIDTH = 3;

    public static void main(String[] args) {

        int width = DEFAULT_WIDTH;

        if(args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
        

        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
        TicTacToeController controller = new TicTacToeController(model, view);
		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic-Tac-Toe");
		frame.setName("Tic-Tac-Toe");
        frame.pack();
        frame.setVisible(true);
        
        view.showResult(model.getResult().toString());

    }
}