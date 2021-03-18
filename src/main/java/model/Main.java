package model;

public class Main {
    public static void main(String[] args){
        MainCharacter character = new MainCharacter("Петя");
        Currency pound = new Currency("Фут Стерлинг", 103, 0.31);
        Currency dollar = new Currency("Доллар", 74, 30);
        Country england = new Country(false, true, "Англия", pound);
        Country america = new Country(false, false, "Америка", dollar);
        Location newyork = new Location(false, false, "Нью-Йорк");
        Film film = new Film(false, true, "Фильм 'Касабланка'", "Хамфри Богарт");
        HamburgerRestaurant mcdonalds = new HamburgerRestaurant(false, true, "Макдональдс");
        Hamburger bigmac = new Hamburger("Бигмак", 257);
        Hamburger bigtasty = new Hamburger("Биг тейсти", 226);
        mcdonalds.getMenu().add(bigmac);
        mcdonalds.getMenu().add(bigtasty);
        character.realize(england);
        character.realize(america);
        character.realize(newyork);
        character.realize(film);
        character.realize(mcdonalds);
        System.out.println(mcdonalds.getMenu().size());
    }
}
