package Interfaces.Reservations;

import Interfaces.Reservations.booking.Reservationy;
import java.util.Random;

public class Reservation implements Reservationy {
  @Override
  public String getDowBooking() {
    String[] dows = {"MON", "THU", "WED", "THR", "FRI", "SAT", "SUN"};
    Random random = new Random();

    return dows[random.nextInt(dows.length)];
  }

  @Override
  public String getCodeBooking() {
    String validChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String randomCode = "";

    Random random = new Random();

    for (int i = 0; i < 8; i++) {
      randomCode += validChars.charAt(random.nextInt(validChars.length()));
    }
    return randomCode;
  }


}
