package hr.fer.oop.t3;

import hr.fer.oop.t3.items.Beverage;
import hr.fer.oop.t3.items.Perishable;

import java.time.LocalDate;

public class ItemsUtil {
    public static double totalVolume(Box<? extends Beverage> box) {
        double volume = 0;
        for (Beverage b : box.boxContent()) {
            volume += b.getVolume();
        }
        return volume;
    }

    public static LocalDate useBefore(Box<? extends Perishable> box) {
        if (box.boxContent().isEmpty()) return null;
        LocalDate min = LocalDate.MAX;
        for (Perishable p : box.boxContent()) {
            if (p.getBestBefore().isBefore(min)) {
                min = p.getBestBefore();
            }
        }
        return min;
    }
}
