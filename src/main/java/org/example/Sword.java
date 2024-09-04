package org.example;

public class Sword extends Item {
    private String material;

    public Sword(int x, int y, String material) {
        super(x, y);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}