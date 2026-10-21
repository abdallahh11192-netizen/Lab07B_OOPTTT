public class TTTGame {
    private final TTTBoard board = new TTTBoard();
    private char currentPlayer = 'X';
    private boolean finished = false;
    private String result = "";
    public TTTBoard getBoard() { return board; }
    public char getCurrentPlayer() { return currentPlayer; }
    public boolean isFinished() { return finished; }
    public String getResult() { return result; }
    public boolean play(int row,int col) {
        if(finished || !board.place(row,col,currentPlayer)) return false;
        if(board.hasWinner(currentPlayer)) { finished=true; result=currentPlayer+" wins!"; }
        else if(board.isFull()) { finished=true; result="It's a tie!"; }
        else currentPlayer=currentPlayer=='X'?'O':'X';
        return true;
    }
    public void reset() { board.clear(); currentPlayer='X'; finished=false; result=""; }
}
