package de.nk.camel.route;

import org.springframework.stereotype.Component;

import de.nk.camel.model.MyEntityBean;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Component("route4")
public class Route4 extends AbstractRoute {

    @Override
    public void configureRoute() throws Exception {

        from("direct:camelDb")
                .convertBodyTo(MyEntityBean.class)
                .log(body().toString())
                .to("jpa:de.nk.camel.model.MyEntityBean");
    }
}
