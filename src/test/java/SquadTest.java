import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void newSquad_instantiatesCorrectly() {
        Squad firstSquad = new Squad("Justice League", "Crime Prevention");
        Assert.assertEquals(true, firstSquad instanceof Squad);
    }

}

