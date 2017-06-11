import annotations.PropertiesResource;
import annotations.PropertyValue;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
@PropertiesResource("test.properties")
public class TestProperties {

    @PropertyValue("service.host")
    private String host;

    @PropertyValue("service.port")
    private String port;

    public String getPort() {
        return port;
    }

    public String getHost() {

        return host;
    }
}
