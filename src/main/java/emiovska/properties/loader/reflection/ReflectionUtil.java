package emiovska.properties.loader.reflection;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
public class ReflectionUtil {

    private static Reflections reflections = new Reflections();

    public static boolean setFieldValue(Object targetObject, Field field, Object fieldValue) {
        field.setAccessible(true);
        try {
            field.set(targetObject, fieldValue);
            return true;
        } catch (IllegalAccessException e) {
            return false;
        }
    }

    public static Object createInstancesByClass(Class clazz) {
        Object classInstance = null;
        try {
            classInstance = clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return classInstance;
    }

    public static Set<Class<?>> getClassesAnnotatedWith(Class<? extends Annotation> annotation) {
        return reflections.getTypesAnnotatedWith(annotation);
    }

}
