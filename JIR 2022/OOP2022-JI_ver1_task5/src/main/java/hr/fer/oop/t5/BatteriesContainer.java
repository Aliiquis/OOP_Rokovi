package hr.fer.oop.t5;

public class BatteriesContainer extends SpecialContainer implements Hazardous {
    public BatteriesContainer(String id, int volume, String containerMaterial) {
        super(id, volume, containerMaterial);
    }

    @Override
    public String storageInstructions() {
        return "Store in a dry place. " + Hazardous.super.storageInstructions();
    }
}
