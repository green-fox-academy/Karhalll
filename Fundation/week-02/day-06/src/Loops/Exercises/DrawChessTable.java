public class DrawChessTable {
  public static void main(String[] args) {
    // Crate a program that draws a chess table like this
    //
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    //

    int boardSize = 8;

    for (int i = 0; i < boardSize; i++) {
      String line = "";
      for (int j = 0; j < boardSize / 2; j++) {
        if (i % 2 == 0) {
          line += "% ";
        } else {
          line += " %";
        }
      }
      System.out.println(line);
    }
  }
}
