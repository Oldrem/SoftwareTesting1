package model;

public class Location extends VanishableObject {

    public Location(boolean doesExist, boolean canBeRealized, String name) {
        super(doesExist, canBeRealized, name);
    }

    public boolean realizeIfExists() {
        return !doesExist && canBeRealized;
    }
}
