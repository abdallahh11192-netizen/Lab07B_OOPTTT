import javax.swing.*;
import java.awt.*;
public class TicTacToeFrame extends JFrame {
    private final TTTGame game = new TTTGame();
    private final TTTTileButton[][] buttons = new TTTTileButton[3][3];
    private final JLabel status = new JLabel("Player X's turn",SwingConstants.CENTER);
    public TicTacToeFrame() {
        super("OOP Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8,8));
        JPanel grid = new JPanel(new GridLayout(3,3,5,5));
        for(int r=0;r<3;r++) for(int c=0;c<3;c++) {
            TTTTileButton b=new TTTTileButton(r,c); buttons[r][c]=b;
            b.addActionListener(e -> onMove(b)); grid.add(b);
        }
        add(status,BorderLayout.NORTH); add(grid,BorderLayout.CENTER);
        JPanel controls=new JPanel();
        JButton reset=new JButton("New Game"); reset.addActionListener(e -> resetGame());
        JButton quit=new JButton("Quit"); quit.addActionListener(e -> dispose());
        controls.add(reset); controls.add(quit); add(controls,BorderLayout.SOUTH);
        setSize(420,480); setLocationRelativeTo(null);
    }
    private void onMove(TTTTileButton b) {
        if(!game.play(b.getRowIndex(),b.getColIndex())) return;
        b.setText(String.valueOf(game.getBoard().getCell(b.getRowIndex(),b.getColIndex())));
        if(game.isFinished()) {
            status.setText(game.getResult());
            JOptionPane.showMessageDialog(this,game.getResult());
        } else status.setText("Player "+game.getCurrentPlayer()+"'s turn");
    }
    private void resetGame() {
        game.reset(); for(TTTTileButton[] row:buttons) for(TTTTileButton b:row) b.setText("");
        status.setText("Player X's turn");
    }
}
