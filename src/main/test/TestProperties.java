import emiovska.properties.loader.annotations.PropertiesResource;
import emiovska.properties.loader.annotations.PropertyValue;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
@PropertiesResource("test.properties")
public class TestProperties {

    @PropertyValue("test.property.1")
    private String testProperty1;

    @PropertyValue("test.property.2")
    private String testProperty2;

    public String getTestProperty1() {
        return testProperty1;
    }

    public String getTestProperty2() {
        return testProperty2;
    }
}
