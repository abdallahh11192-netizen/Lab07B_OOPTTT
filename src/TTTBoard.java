public class TTTBoard {
    private final char[][] cells = new char[3][3];
    public TTTBoard() { clear(); }
    public void clear() { for(int r=0;r<3;r++) for(int c=0;c<3;c++) cells[r][c]=' '; }
    public char getCell(int row,int col) { validate(row,col); return cells[row][col]; }
    public boolean place(int row,int col,char symbol) {
        validate(row,col);
        if ((symbol!='X' && symbol!='O') || cells[row][col]!=' ') return false;
        cells[row][col]=symbol; return true;
    }
    private void validate(int row,int col) { if(row<0||row>2||col<0||col>2) throw new IndexOutOfBoundsException(); }
    public boolean hasWinner(char s) {
        for(int i=0;i<3;i++) if((cells[i][0]==s&&cells[i][1]==s&&cells[i][2]==s)||(cells[0][i]==s&&cells[1][i]==s&&cells[2][i]==s)) return true;
        return (cells[0][0]==s&&cells[1][1]==s&&cells[2][2]==s)||(cells[0][2]==s&&cells[1][1]==s&&cells[2][0]==s);
    }
    public boolean isFull() { for(char[] row:cells) for(char cell:row) if(cell==' ') return false; return true; }
}
