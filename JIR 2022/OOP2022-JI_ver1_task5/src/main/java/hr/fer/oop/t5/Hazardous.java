package hr.fer.oop.t5;

public interface Hazardous {
    default String storageInstructions() {
        return "Keep away from flamable material!";
    }
}
