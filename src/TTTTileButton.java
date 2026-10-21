import javax.swing.JButton;
import java.awt.Font;
public class TTTTileButton extends JButton {
    private final int row, col;
    public TTTTileButton(int row,int col) {
        this.row=row; this.col=col;
        setFont(new Font(Font.SANS_SERIF,Font.BOLD,48));
        setFocusPainted(false);
    }
    public int getRowIndex() { return row; }
    public int getColIndex() { return col; }
}
