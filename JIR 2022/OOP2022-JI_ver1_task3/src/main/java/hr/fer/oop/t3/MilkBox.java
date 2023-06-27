package hr.fer.oop.t3;

import hr.fer.oop.t3.items.Milk;

import java.util.List;

public class MilkBox extends Box<Milk> {
    public MilkBox(Milk milk) {
        super(List.of(milk));
    }

    public boolean add(Milk milk) {
        if (milk.getType() == super.content.get(0).getType()) {
            super.content.add(milk);
            return true;
        }
        return false;
    }
}
