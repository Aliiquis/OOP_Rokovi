package hr.fer.oop.zad2;

import java.util.Comparator;

public class BasketballPlayerComparator implements Comparator<BasketballPlayer> {
    @Override
    public int compare(BasketballPlayer o1, BasketballPlayer o2) {
        if (o1.getPosition() != o2.getPosition()) return Integer.compare(o1.getPosition(), o2.getPosition());
        else if (o1.getPointsAvg() != o2.getPointsAvg()) return Double.compare(o1.getPointsAvg(), o2.getPointsAvg());
        else if (o1.getAssistsAvg() != o2.getAssistsAvg())
            return Double.compare(o1.getAssistsAvg(), o2.getAssistsAvg());
        else return Double.compare(o1.getReboundsAvg(), o2.getReboundsAvg());
    }
}
