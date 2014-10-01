package es.indra.movilidad.inject.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by alopezh on 01/10/2014.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForActivity {
}
