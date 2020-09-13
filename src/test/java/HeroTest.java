import org.junit.*;
import static org.junit.Assert.*;
class HeroTest {
    @Test
     public void newHero_instantiatesCorrectly() {
        Hero firstHero = new Hero("superman", 123, "flying", "kryptonite");
        Assert.assertEquals(true, firstHero instanceof Hero);
    }
}