import org.junit.Before;
import org.junit.Test;
import model.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ModelTest {
    private MainCharacter character = new MainCharacter("Петя");
    @Before
    public void init(){
        MainCharacter character = new MainCharacter("Петя");
    }

    @Test
    public void currencyDropTest(){
        Currency dollar = new Currency("Доллар", 74, 40);
        Country america = new Country(false, false, "Америка", dollar);
        character.realize(america);
        assertEquals(34, dollar.getMarketValue());
    }

    @Test
    public void hamburgerVanishTest(){
        HamburgerRestaurant mcdonalds = new HamburgerRestaurant(false, true, "Макдональдс");
        Hamburger bigmac = new Hamburger("Бигмак", 257);
        Hamburger bigtasty = new Hamburger("Биг тейсти", 226);
        mcdonalds.getMenu().add(bigmac);
        mcdonalds.getMenu().add(bigtasty);
        character.realize(mcdonalds);
        assertEquals(0, mcdonalds.getMenu().size());
    }

    @Test
    public void filmVanishTest(){
        Film film1 = new Film(false, true, "Фильм", "Актёр");
        Film film2 = new Film(false, true, "Фильм", "Хамфри Богарт");
        assertFalse(character.realize(film1));
        assertTrue(character.realize(film2));
    }

    @Test
    public void mainStoryTest(){
        Currency pound = new Currency("Фут Стерлинг", 103, 0.03);
        Currency dollar = new Currency("Доллар", 74, 40);
        Country england = new Country(false, true, "Англия", pound);
        Country america = new Country(false, false, "Америка", dollar);
        Location newyork = new Location(false, false, "Нью-Йорк");
        Film film = new Film(false, true, "Фильм 'Касабланка'", "Хамфри Богарт");
        HamburgerRestaurant mcdonalds = new HamburgerRestaurant(false, true, "Макдональдс");
        Hamburger bigmac = new Hamburger("Бигмак", 257);
        Hamburger bigtasty = new Hamburger("Биг тейсти", 226);
        mcdonalds.getMenu().add(bigmac);
        mcdonalds.getMenu().add(bigtasty);

        assertTrue(character.realize(england));
        assertFalse(character.realize(america));
        assertFalse(character.realize(newyork));
        assertTrue(character.realize(film));
        assertTrue(character.realize(mcdonalds));
    }
}
