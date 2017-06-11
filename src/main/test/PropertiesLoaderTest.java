
import emiovska.properties.loader.processing.PropertiesManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
public class PropertiesLoaderTest {

    @Test
    public void testPropertiesLoader() {
        TestProperties properties = PropertiesManager.getProperties(TestProperties.class);

        Assert.assertEquals("test property 1", properties.getTestProperty1());
        Assert.assertEquals("test property 2", properties.getTestProperty2());
    }

    @Test
    public void testMultiplePropertiesFilesLoad() {
        TestProperties properties = PropertiesManager.getProperties(TestProperties.class);
        Test2Properties properties2 = PropertiesManager.getProperties(Test2Properties.class);

        Assert.assertEquals("test property 1", properties.getTestProperty1());
        Assert.assertEquals("test property 2", properties.getTestProperty2());

        Assert.assertEquals("test property 2/1", properties2.getTest2Property1());
        Assert.assertEquals("test property 2/2", properties2.getTest2Property2());
    }
}
