package Inheritance.AircraftCarrier;

public class Aircraft {
  String type;

  int ammo;
  int maxAmmo;

  int baseDmg;

  Aircraft(String type,int maxAmmo, int baseDmg) {
    this.type = type;
    this.maxAmmo = maxAmmo;
    this.baseDmg = baseDmg;

    ammo = 0;
  }

  int fight() {
    int dmgDealt = baseDmg * ammo;
    ammo = 0;
    return dmgDealt;
  }

  int refill(int ammoAmount) {
    ammo += ammoAmount;

    if (ammo > maxAmmo) {
      int ammoLeft = ammo - maxAmmo;
      ammo = maxAmmo;
      return ammoLeft;
    } else {
      return 0;
    }
  }

  String getType() {
    return type;
  }

  String getStatus() {
    return "Type " + type + ", Ammo: " + ammo + ", Base Damage: " + baseDmg
        + ", All Damage: " + baseDmg*ammo;
  }

  boolean isPriority() {
    return false;
  }
}
