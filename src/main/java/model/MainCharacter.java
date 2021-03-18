package model;

public class MainCharacter {

    private String name;

    public MainCharacter(String name) {
        this.name = name;
    }

    public boolean realize(VanishableObject vanishableObject){
        if (vanishableObject.realizeIfExists()){
            System.out.println(name + " осознал, что " + vanishableObject.getName() + " исчез(ла).");
            return true;
        }
        else {
            System.out.println(name + " не смог осознать, что " + vanishableObject.getName() + " мог(ла) исчезнуть.");
            return false;
        }
    }
}
