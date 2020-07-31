package SharpieSet;

import Sharpie.Sharpie;
import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
  List<Sharpie> sharpieSet = new ArrayList<Sharpie>();

  public int countUsable() {
    int usableSharpies = 0;
    for (Sharpie sharpie : sharpieSet) {
      if (sharpie.inkAmount > 0) {
        usableSharpies++;
      }
    }
    return usableSharpies;
  }

  public void removeTrash() {
    for (Sharpie sharpie : sharpieSet) {
      if (sharpie.inkAmount <= 0) {
        sharpieSet.remove(sharpie);
      }
    }
  }
}
