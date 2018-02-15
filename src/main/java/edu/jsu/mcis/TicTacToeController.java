package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
    
    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        
        
        this.model = model;
        this.view = view;
        
        
        keyboard = new Scanner(System.in);

    }

    public void controlModel() {
       
		int row = keyboard.nextInt();
		int col = keyboard.nextInt();
		if (!model.makeMark(row,col)) {
			view.showInputError();
		}
        
    }

}