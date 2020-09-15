import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
     public void newHero_instantiatesCorrectly() {
        Hero firstHero = new Hero("superman", 123, "flying", "kryptonite");
        Assert.assertEquals(true, firstHero instanceof Hero);
    }
}