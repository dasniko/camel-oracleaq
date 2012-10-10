package de.nk.camel.route;


/**
 * @author Niko Köbler, http://www.n-k.de
 */
// @Component("camelInOut")
public class CamelInOut extends AbstractRoute {

    @Override
    public void configureRoute() throws Exception {
        from("aq:queue:CAMEL_IN").to("aq:queue:CAMEL_OUT");
    }

}
