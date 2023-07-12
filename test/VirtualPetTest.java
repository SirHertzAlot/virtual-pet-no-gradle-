import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class VirtualPetTest {

    @Test
    public void timeToEat(int eat){
        VirtualPet falcon = new VirtualPet(false, false, false, false, false);
        falcon.timeToEat(1);

        boolean check = falcon.isHungry;
        assertEquals(true, falcon.isHungry);
    }
}
