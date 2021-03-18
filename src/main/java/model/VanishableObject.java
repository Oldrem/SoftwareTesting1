package model;

public abstract class VanishableObject {
    protected boolean doesExist;
    protected boolean canBeRealized;
    protected String name;

    public VanishableObject(boolean doesExist, boolean canBeRealized, String name) {
        this.doesExist = doesExist;
        this.canBeRealized = canBeRealized;
        this.name = name;
    }

    public abstract boolean realizeIfExists();

    public boolean isDoesExist() {
        return doesExist;
    }

    public void setDoesExist(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public boolean isCanBeRealized() {
        return canBeRealized;
    }

    public void setCanBeRealized(boolean canBeRealized) {
        this.canBeRealized = canBeRealized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
