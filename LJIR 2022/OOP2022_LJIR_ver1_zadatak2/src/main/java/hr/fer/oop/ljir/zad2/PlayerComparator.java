package hr.fer.oop.ljir.zad2;

import java.util.Comparator;

class PlayerComparator implements Comparator<FootballPlayer> {

    @Override
    public int compare(FootballPlayer o1, FootballPlayer o2) {
        if (o1.getOverallSkill() != o2.getOverallSkill()) {
            return Integer.compare(o1.getOverallSkill(), o2.getOverallSkill());
        } else if (!o1.getSurname().equals(o2.getSurname())) {
            return o1.getSurname().compareTo(o2.getSurname());
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
