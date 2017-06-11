package emiovska.properties.loader.processing;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
public class PropertiesManager {

    static {
        PropertiesProcessor.loadPropertiesFromClassesMarkedAsResource();
    }

    public static <T> T getProperties(Class<T> clazz) {
        return clazz.cast(PropertiesProcessor.classInstances.get(clazz));
    }

}
