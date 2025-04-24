import java.util.Scanner;

public class Assignment1 {
    // Constants:Board size and player symbols
    static final int row = 6;
    static final int column = 7;
    static final char Empty = ' ';
    static final char Player_Red = 'R';
    static final char Player_Yellow = 'Y';
/**
     * Main method to run the Connect Four game.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args){
        //create game board
        char [][] board = new char[row][column];

        //fill empty cell to initial  to make start

    

        initializeBoard(board);
        // create scannner object
        Scanner scanner = new Scanner(System.in);
// Let the red player start the game
        char currentPlayer = Player_Red;
        // A boolean variable to track whether the game has been won

        boolean gameWon = false;
        boolean gameDraw = false;

        // Game loop: Continues until the game is won or ends in a draw

        while (!gameWon && !gameDraw){
            // Print the current board state to the console
            printBoard(board);

            // Ask the current player to select a column and drop the disc into that column
            

            dropDisc(currentPlayer, board);

            gameWon = isWon(board, currentPlayer);
            gameDraw = isDraw(board);
            if(!gameWon &&  !gameDraw){
                currentPlayer = (currentPlayer == Player_Red) ? Player_Yellow : Player_Red;

            }
        }
        // Print the final board state when the game is over
        printBoard(board);
        if(gameWon){
            System.out.println("Player " + currentPlayer + "wins!!" );


        }
        else {
            System.out.println("The game is a draw");
        }
        /*
        close the scanner object
         
         */
        scanner.close();

}
// Initializes the board by filling it with empty cells

    
    public static void initializeBoard(char [][] board){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                board[i][j] = Empty;
            }
        }
    }
    // Prints the current board state to the console
     /**
     * Prints the current state of the game board to the console.
     *
     * @param board the game board (char[][]) to print
     */
    public static void printBoard(char [][] board){
        for(int i = 0; i < row; i++){
            System.out.print("|");
            for(int j = 0; j < column; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            
        }
        System.out.println("---------------");
        System.out.println("0 1 2 3 4 5 6");

    }
    
    // Checks if a column is full
    /**
     * Checks if a column in the game board is full.
     *
     * @param board  the game board (char[][]) to check
     * @param column the column index (int) to check
     * @return true if the column is full, false otherwise
     */
    
     public static boolean isColumnFull(char[][] board, int column) {
              return board[0][column] != ' '; 

     }
     // Asks the current player to select a column and drops the disc into that column
     public static void dropDisc(char player, char [][] board ){
        Scanner scanner = new Scanner(System.in); 
        int col;
         while (true) {
              System.out.println("Player " + player + ", enter column (0-6):");
              if(!scanner.hasNextInt()){
                System.out.println("Invalid input. Please enter a number between 0 and 6 : ");
               // Consume the invalid input
                scanner.next();
                continue;
              }

              col = scanner.nextInt();
              // Check if the column is a valid column
              if(col < 0 || col >= column){
                System.out.println("Invalid columnn. Enter  a number (0-6) :");

              }
              else if(isColumnFull(board, col)){
                System.out.println("Column " +  col + "is full . Chose another column . ");

              }
              // If the column is valid, exit the loop
              else{
                break;
              }}

              for(int i = row - 1; i >= 0; i--){
                if(board[i][col] == Empty){
                    board[i][col] = player;
                    break;//Disc dropped

                }
              }
              }

// Checks if the game has been won
/**
     * Checks if the specified player has won the game.
     *
     * @param board  the game board (char[][]) to check
     * @param player the player (char) to check for a win
     * @return true if the player has won, false otherwise
     */
     public static boolean isWon(char [][] board, char player){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= column- 4; j++) {
            if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
            && board[i][j + 3] == player) {
            return true; // Horizontal win
            }
            }
            }
           
            // Check for vertical win
            for (int i = 0; i <= row - 4; i++) {
            for (int j = 0; j < column; j++) {
            if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
            && board[i + 3][j] == player) {
            return true; // Vertical win
            }
            }
            }

            //Check for diagonal win (top-left to bottom-right)
            for (int i = 0; i <= row - 4; i++) {
                for (int j = 0; j <= column - 4; j++) {
                       if(board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
                       && board[i + 3][j + 3] == player){
                        return true;

                       }
                    }
                }
            //  (top-right to bottom-left)
            for(int i =0; i <= row -4; i++){
                for(int j = column - 1; j >= 3; j--){
                    if(board[i][j] == player && board[i + 1 ][j - 1] == player && board[i + 2][j - 2]== player && board[i + 3][j - 3] == player){
                        return true;
                    }
                }

            

            }
            return false;
        }

/**
     * Checks if the game has ended in a draw.
     *
     * @param board the game board (char[][]) to check
     * @return true if the game is a draw, false otherwise
     */
        public static boolean isDraw(char[][] board){
            for(int j = 0; j < column; j++){
                if(board[0][j] == Empty){
                    return false; //Not a draw
                }
            }
            return true;//Draw

        }
        



   
   

        

     }



 