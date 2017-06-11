import emiovska.properties.loader.annotations.PropertiesResource;
import emiovska.properties.loader.annotations.PropertyValue;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
@PropertiesResource("test2.properties")
public class Test2Properties {
    @PropertyValue("test2.property.1")
    private String test2Property1;

    @PropertyValue("test2.property.2")
    private String test2Property2;

    public String getTest2Property1() {
        return test2Property1;
    }

    public String getTest2Property2() {
        return test2Property2;
    }
}
