abstract class Game{
    protected int[][] board;
    public Game(int maxRows, int maxCols){
        board = new int[maxRows][maxCols];

        for(int i = 0; i < maxRows; i++){
            for(int j = 0; j < maxCols; j++)
                board[i][j] = 1;
        }
    }
    public abstract void processThisCell(int rowIndex, int collndex);
}

class FlipCellGame extends Game {
    int maxRows;
    int maxCols;

    public FlipCellGame(int maxRows, int maxCols) {
        super(maxRows, maxCols);
        this.maxRows = maxRows;
        this.maxCols = maxCols;
    }

    @Override
    public void processThisCell(int rowIndex, int collndex) {
        if (board[rowIndex][collndex] == 1) {
            board[rowIndex][collndex] = 0;
        } else {
            board[rowIndex][collndex] = 1;
        }
    }

    public void boardPrint() {
        System.out.println("Game Board\n");
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }

    public int compareTo(FlipCellGame fg) {
        boolean a = true;
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                try{
                    if (board[i][j] != fg.board[i][j]) {
                        return 0;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    return 0;
                }

                }
            }
        return 1;
    }
}


    public class GameDriver {
        public static void main(String[] args) {
            FlipCellGame fg = new FlipCellGame(4, 7);

            fg.boardPrint();
            fg.processThisCell(2, 3);
            fg.boardPrint();
            fg.processThisCell(2, 3);
            fg.boardPrint();

            FlipCellGame fg2 = new FlipCellGame(4, 7);
            fg2.boardPrint();
            System.out.println(fg.compareTo(fg2));

            FlipCellGame fg3 = new FlipCellGame(2, 7);
            fg3.boardPrint();
            System.out.println(fg.compareTo(fg3));
        }
    }
