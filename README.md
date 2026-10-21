# Lab07B_OOPTTT
Java Swing OOP Tic Tac Toe. Requires Java 8+.

## Run
```bash
javac -d out src/*.java
java -cp out Main
```

The game model (`TTTGame`, `TTTBoard`) is independent of Swing. `TicTacToeFrame` handles presentation and delegates moves to the model. `TTTTileButton` stores its grid position.

Note: the original Assignment 01 source was unavailable, so this is a fresh GUI and may differ visually from the original.
