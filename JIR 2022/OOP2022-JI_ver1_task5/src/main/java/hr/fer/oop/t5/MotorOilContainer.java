package hr.fer.oop.t5;

public class MotorOilContainer extends LiquidContainer implements Hazardous {
    public MotorOilContainer(String id, int volume) {
        super(id, volume, "Stainless steel");
    }

    @Override
    public void setContainerMaterial(String containerMaterial) {
        throw new UnsupportedOperationException("Motor oil container material change not allowed");
    }

    @Override
    public String storageInstructions() {
        return "Use sealed barrels. " + Hazardous.super.storageInstructions();
    }
}
