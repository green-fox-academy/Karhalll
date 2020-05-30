import java.util.Scanner;

public class Lab01 {
  Scanner scanner = new Scanner(System.in);

  int operationChoice = 0;
  float operand1 = 0f;
  float operand2 = 0f;
  int numberOfDecimals = 1;
  char operator = '+';

  public void start(String[] args) {
    homework();
  }

  private void homework() {
    while (true) {
      System.out.print("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");

      if (!scanner.hasNextInt()) {
        scanner.next();
        invalidInputText();
        continue;
      }

      operationChoice = scanner.nextInt();

      switch (operationChoice) {
        case 1:
          operator = '+';
          askForInput("scitanec", "scitanec");
          printResult(operand1 + operand2);
          break;
        case 2:
          operator = '-';
          askForInput("mensenec", "mensitel");
          printResult(operand1 - operand2);
          break;
        case 3:
          operator = '*';
          askForInput("cinitel", "cinitel");
          printResult(operand1 * operand2);
          break;
        case 4:
          operator = '/';
          askForInput("delenec", "delitel");
          printResult(operand1 / operand2);
          break;
        default:
          invalidInputText();
          break;
      }
    }
  }

  private void askForInput(String operand1Name, String operand2Name) {
    askForFloat(operand1Name);
    operand1 = scanner.nextFloat();

    while (true) {
      askForFloat(operand2Name);
      operand2 = scanner.nextFloat();
      if (operationChoice != 4 || operand2 != 0f) {
        break;
      }
      System.out.println("Chyba - pokus o deleni nulou!");
    }

    while (true) {
      askForInt("pocet desetinnych mist");
      numberOfDecimals = scanner.nextInt();
      if (numberOfDecimals >= 0) {
        break;
      }
      System.out.println("Chyba - musi byt zadane kladne cislo!");
    }
  }

  private void askForFloat(String operand1Name) {
    while (true) {
      askForInputText(operand1Name);
      if (scanner.hasNextFloat()) {
        break;
      }
      scanner.next();
      mustBeNumber();
    }
  }

  private void askForInt(String operand1Name) {
    while (true) {
      askForInputText(operand1Name);
      if (scanner.hasNextInt()) {
        break;
      }
      scanner.next();
      System.out.println("Chyba - musi byt cele cislo!");
    }
  }

  private void askForInputText(String operandName) {
    System.out.print("Zadej " + operandName + ": ");
  }

  private void printResult(float result) {
    System.out.print(numberToText(operand1) + " " + operator + " " + numberToText(operand2));
    System.out.print(" = " + numberToText(result) + "\n");
  }

  private String numberToText(float number) {
    String resultText;
    if (numberOfDecimals == 0) {
      resultText = Integer.toString((int) number);
    } else {
      String format = "%." + numberOfDecimals + "f";
      resultText = String.format(format, number);
    }
    return resultText;
  }

  private void invalidInputText() {
    System.out.println("Chybna volba!");
  }

  private void mustBeNumber() {
    System.out.println("Chyba - musi byt cislo!");
  }
}