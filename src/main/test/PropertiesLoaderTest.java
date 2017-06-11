import org.junit.Assert;
import org.junit.Test;
import processing.PropertiesManager;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
public class PropertiesLoaderTest {

    @Test
    public void testPropertiesLoader() {
        TestProperties properties = PropertiesManager.getProperties(TestProperties.class);

        Assert.assertEquals("localhost", properties.getHost());
        Assert.assertEquals("9080", properties.getPort());
    }
}
