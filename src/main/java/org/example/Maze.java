package org.example;

import java.util.ArrayList;

public class Maze {
    private ArrayList<String> structure;

    public Maze() {
        this.structure = new ArrayList<>();
    }

    public void addElement(String element) {
        structure.add(element);
    }

    public String getElement(int index) {
        return structure.get(index);
    }

    public ArrayList<String> getStructure() {
        return structure;
    }

    public void setStructure(ArrayList<String> structure) {
        this.structure = structure;
    }
}