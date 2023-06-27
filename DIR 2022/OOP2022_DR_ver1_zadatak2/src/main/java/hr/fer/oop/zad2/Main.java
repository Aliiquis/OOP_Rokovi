package hr.fer.oop.zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasketballPlayer player1 = new BasketballPlayer("Ante", "Antic", 20.0, 10.0, 10.0, 3);
        BasketballPlayer player2 = new BasketballPlayer("Ante", "Antic", 10.0, 20.0, 20.0, 3);
        BasketballPlayer player3 = new BasketballPlayer("Borna", "Bornic", 10.0, 20.0, 20.0, 2);

        System.out.println(player1.equals(player2));
        System.out.println(player1.hashCode() == player2.hashCode());

        List<BasketballPlayer> playerList = new ArrayList<BasketballPlayer>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        System.out.println("Before sorting: " + playerList);

        BasketballPlayerComparator comparator = new BasketballPlayerComparator();
        Collections.sort(playerList, comparator);

        System.out.println("After sorting: " + playerList);
    }
}
