package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by elena.miovska on 11.6.2017 г..
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertiesResource {
    String value();
}
