import java.util.Scanner;

public class Lab01 {
  Scanner scanner = new Scanner(System.in);

  int vyberOperace = 0;
  float operand1 = 0f;
  float operand2 = 0f;
  int numberOfDecimals = 1;

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

      vyberOperace = scanner.nextInt();

      switch (vyberOperace) {
        case 1:
          soucet();
          break;
        case 2:
          rodil();
          break;
        case 3:
          soucin();
          break;
        case 4:
          podil();
          break;
        default:
          invalidInputText();
          break;
      }
    }
  }

  private void soucet() {
    String operand1Name = "scitanec";
    String operand2Name = "scitanec";
    char operator = '+';

    askForInput(operand1Name, operand2Name, operator);

    float result = operand1 + operand2;

    printResult(result, operator);
  }

  private void rodil() {
    String operand1Name = "mensenec";
    String operand2Name = "mensitel";
    char operator = '-';

    askForInput(operand1Name, operand2Name, operator);

    float result = operand1 - operand2;

    printResult(result, operator);
  }

  private void soucin() {
    String operand1Name = "cinitel";
    String operand2Name = "cinitel";
    char operator = '*';

    askForInput(operand1Name, operand2Name, operator);

    float result = operand1 * operand2;

    printResult(result, operator);
  }

  private void podil() {
    String operand1Name = "delenec";
    String operand2Name = "delitel";
    char operator = '/';

    askForInput(operand1Name, operand2Name, operator);

    float result = operand1 / operand2;

    printResult(result, operator);
  }

  private void askForInput(String operand1Name, String operand2Name, char operator) {
    askForFloat(operand1Name);
    operand1 = scanner.nextFloat();

    while (true) {
      askForFloat(operand1Name);
      operand2 = scanner.nextFloat();
      if (vyberOperace != 4 || operand2 != 0f) {
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

  private void printResult(float result, char operator) {
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