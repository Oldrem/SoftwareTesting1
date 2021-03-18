package model;

import java.util.ArrayList;
import java.util.List;

public class HamburgerRestaurant extends VanishableObject {
    private List<Hamburger> menu = new ArrayList<Hamburger>();

    public HamburgerRestaurant(boolean doesExist, boolean canBeRealized, String name) {
        super(doesExist, canBeRealized, name);
    }

    public boolean realizeIfExists() {
        if (!doesExist && canBeRealized){
            menu.removeAll(menu);
            return true;
        }
        return false;
    }

    public List<Hamburger> getMenu() {
        return menu;
    }

    public void setMenu(List<Hamburger> menu) {
        this.menu = menu;
    }
}
