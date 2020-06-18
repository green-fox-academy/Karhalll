import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TicTacToe {

  public static void main(String[] args) {
    // Write a function that takes a filename as a parameter
    // The file contains an ended Tic-Tac-Toe match
    // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
    // Return "X", "O" or "Draw" based on the input file

    System.out.println(ticTacResult("win-o.txt"));
    // Should print "O"

    System.out.println(ticTacResult("win-x.txt"));
    // Should print "X"

    System.out.println(ticTacResult("draw.txt"));
    // Should print "Draw"
  }

  public static String ticTacResult(String gameFileName) {
    List<String> gameLines = null;

    try {
      Path gameFilePath = Paths.get("assets/" + gameFileName);
      gameLines = Files.readAllLines(gameFilePath);
    } catch (IOException e) {
      return "Can not read " + gameFileName + " file";
    }

    if (doesWin(gameLines, 'X')) {
      return "X";
    } else if (doesWin(gameLines, 'O')) {
      return "O";
    } else {
      return "Draw";
    }
  }

  public static boolean doesWin(List<String> game, char x) {
    char[][] gameArray = new char[3][3];

    // Fill array
    for (int i = 0; i < gameArray.length; i++) {
      for (int j = 0; j < gameArray[i].length; j++) {
        gameArray[i][j] = game.get(i).charAt(j);
      }
    }

    for (int i = 0; i < gameArray.length; i++) {
      for (int j = 0; j < gameArray[i].length; j++) {           // line win
        if (gameArray[i][j] != x) {
          break;
        } else if (gameArray[i][gameArray[i].length - 1] == x) {
          return true;
        }
        System.out.println("Checked line char");
      }
      for (int j = 0; j < gameArray[j].length; j++) {           // column win
        if (gameArray[j][i] != x) {
          break;
        } else if (gameArray[j][gameArray[j].length - 1] == x) {
          return true;
        }
        System.out.println("Checked column char");
      }
    }
    return false;
  }
}