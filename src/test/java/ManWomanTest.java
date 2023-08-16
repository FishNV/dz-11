import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManWomanTest {

    @Test
    public void test () {
        Man karl = new Man("Карл", "Карленко", 64);
        Woman klara = new Woman("Клара", "Кораленко", 59);
        Assert.assertEquals(karl.getFirstName(), "Карл");
        Assert.assertEquals(klara.getFirstName(), "Клара");

        Assert.assertEquals(karl.getLastName(), "Карленко");
        Assert.assertEquals(klara.getLastName(), "Кораленко");

        Assert.assertEquals(karl.getAge(), 64);
        Assert.assertEquals(klara.getAge(), 59);

        Assert.assertFalse(karl.isRetired());
        Assert.assertFalse(klara.isRetired());

        karl.setAge(65);
        klara.setAge(60);

        Assert.assertTrue(karl.isRetired());
        Assert.assertTrue(klara.isRetired());

        Assert.assertNull(karl.partner);
        Assert.assertNull(klara.partner);

        klara.registerPartnership(karl);
        Assert.assertEquals(karl.getLastName(), "Карленко");
        Assert.assertEquals(klara.getLastName(), "Карленко");

        Assert.assertEquals(karl.partner, klara);
        Assert.assertEquals(klara.partner, karl);

        karl.deregisterPartnership(false);

        Assert.assertNull(karl.partner);
        Assert.assertNull(klara.partner);

        Assert.assertEquals(karl.getLastName(), "Карленко");
        Assert.assertEquals(klara.getLastName(), "Карленко");

        karl.registerPartnership(klara);
        klara.deregisterPartnership(true);

        Assert.assertEquals(karl.getLastName(), "Карленко");
        Assert.assertEquals(klara.getLastName(), "Кораленко");
    }
}
