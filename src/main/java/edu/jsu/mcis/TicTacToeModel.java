package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
	
	public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X WIN!"), 
        O("O WIN!"), 
        TIE("TIE"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        
        this(DEFAULT_WIDTH);
        
    }
    
    
    public TicTacToeModel(int width) {
        
        
        this.width = width;
        xTurn = true;
        
		
		grid = new Mark[width][width];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = Mark.EMPTY;
			}
		}
			
    }
	
    public boolean makeMark(int row, int col) {
		
		if (xTurn && isValidSquare(row, col) && !isSquareMarked(row,col) ) {
			grid[row][col] = Mark.X;
			xTurn = false;
			return true;
		}
		
		else if (!xTurn && isValidSquare(row, col) && !isSquareMarked(row,col) ) {
			grid[row][col] = Mark.O;
			xTurn = true;
			return true;
		}

        else return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        if (row >= width || row < 0 || col >= width || col < 0) {
			return false;
		}

        else return true; /* remove this line! */
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        if (getMark(row, col) == Mark.EMPTY) {
			return false;
		}

        else return true; 
    }
	
    public Mark getMark(int row, int col) {
        
        return grid[row][col];
            
    }
	
    public Result getResult() {
      
		if (isMarkWin(Mark.X)) {
			return Result.X;
		}
		else if (isMarkWin(Mark.O)) {
			return Result.O;
		}
		else if (isTie()) {
			return Result.TIE;
		}
		

        else return Result.NONE; 

    }
	
    private boolean isMarkWin(Mark mark) {
      
		int firstDiagCounter = 0;
		int secondDiagCounter = 0;
		int rowCounter = 0;
		int colCounter = 0;
		for (int i = 0; i < width; i++) {
			int forCounter = 0;
			for (int j = 0; j < width; j++) {
				if (getMark(i,j) == mark) {
					forCounter++;
				}
				if (forCounter == width) {
					rowCounter = forCounter;
				}
			}
		}
		for (int i = 0; i < width; i++) {
			int forCounter = 0;
			for (int j = 0; j < width; j++) {
				if (getMark(j,i) == mark) {
					forCounter++;
				}
				if (forCounter == width) {
					colCounter = forCounter;
				}
			}
		}
		for (int i = 0; i < width; i++) {
			if (getMark(i,i) == mark) {
				firstDiagCounter++;
			}
		}
		for (int i = 0; i < width; i++) {
			if (getMark(i,width - 1 - i) == mark) {
				secondDiagCounter++;
			}
		}
		if (firstDiagCounter == width || secondDiagCounter == width || rowCounter == width || colCounter == width ) {
			return true;
		}

        else return false; 

    }
	
    private boolean isTie() {
        
        for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (getMark(i,j) == Mark.EMPTY) {
					return false;
				}
			}
		}

        return true;
        
    }

    public boolean isGameover(){
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        return xTurn;
        
    }

    public int getWidth(){
        
        return width;
        
    }
    
}