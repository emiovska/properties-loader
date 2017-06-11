package demo;

import emiovska.properties.loader.processing.PropertiesManager;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
public class DemoService {

    public TestProperties testProperties = PropertiesManager.getProperties(TestProperties.class);
    public Test2Properties test2Properties = PropertiesManager.getProperties(Test2Properties.class);

    public void getPropertiesValue() {
        //only call the getter methods of the declared classes
        String propertyValue = testProperties.getTestProperty1();
        String property2Value = test2Properties.getTest2Property1();

        System.out.println(propertyValue);
        System.out.println(property2Value);

    }

}
