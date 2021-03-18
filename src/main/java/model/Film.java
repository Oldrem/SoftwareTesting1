package model;

public class Film extends VanishableObject{
    private String mainActorName;

    public Film(boolean doesExist, boolean canBeRealized, String name, String mainActorName) {
        super(doesExist, canBeRealized, name);
        this.mainActorName = mainActorName;
    }

    public boolean realizeIfExists() {
        return !doesExist && canBeRealized && (mainActorName.equals("Хамфри Богарт"));
    }
}
