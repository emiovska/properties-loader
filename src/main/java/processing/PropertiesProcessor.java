package processing;

import annotations.PropertiesResource;
import annotations.PropertyValue;
import reflection.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
public class PropertiesProcessor {

    public static Map<String, Object> propertiesByKey = new HashMap<>();
    public static Map<Class, Object> classInstances = new HashMap<>();
    public static Set<Class<?>> classesMarkedAsPropertiesResource;

    public static void loadPropertiesFromClassesMarkedAsResource() {
        classesMarkedAsPropertiesResource = ReflectionUtil.getClassesAnnotatedWith(PropertiesResource.class);

        for (Class propertiesResourceClass : classesMarkedAsPropertiesResource) {
            PropertiesResource propertiesResource = (PropertiesResource) propertiesResourceClass.getAnnotation(PropertiesResource.class);
            //load properties from file
            PropertiesFileLoader.loadPropertiesFromFile(propertiesResource.value(), propertiesByKey);
            //create properties holders instances
            Object classInstance = ReflectionUtil.createInstancesByClass(propertiesResourceClass);
            classInstances.put(propertiesResourceClass,classInstance);
            //populate fields with value
            populatePropertiesValues(propertiesResourceClass, classInstance);
        }
    }

    private static void populatePropertiesValues(Class propertiesResourceClass, Object classInstance) {
        Field[] fields = propertiesResourceClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PropertyValue.class)) {
                PropertyValue propertyValue = field.getAnnotation(PropertyValue.class);
                ReflectionUtil.setFieldValue(classInstance, field, propertiesByKey.get(propertyValue.value()));
            }
        }
    }

}
