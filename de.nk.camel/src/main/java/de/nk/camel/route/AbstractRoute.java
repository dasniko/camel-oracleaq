package de.nk.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
public abstract class AbstractRoute extends SpringRouteBuilder {

    @Override
    public final void configure() throws Exception {
        // Tracing ein-/ausschalten
        getContext().setTracing(true);

        // Globale Fehlerbehandlung
        onException(Exception.class)
                .handled(true)
                .useOriginalMessage()
                .log(LoggingLevel.ERROR, simple("${exception.message}").getText())
                .logStackTrace(true);

        configureRoute();

    }

    public abstract void configureRoute() throws Exception;

}
