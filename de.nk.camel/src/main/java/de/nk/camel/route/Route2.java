package de.nk.camel.route;

import org.springframework.stereotype.Component;

import de.nk.camel.bean.DbPredicate;
import de.nk.camel.bean.JmsPredicate;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Component("route2")
public class Route2 extends AbstractRoute {

    @Override
    public void configureRoute() throws Exception {

        DbPredicate db = new DbPredicate();
        JmsPredicate jms = new JmsPredicate();

        from("direct:camelRouter")
                .log(body().toString())
                .choice().when(db)
                    .to("direct:camelDb")
                .when(jms)
                    .to("direct:camelJms")
                .otherwise()
                    .multicast().parallelProcessing()
                    .to("direct:camelDb", "direct:camelJms")
                .end();
    }
}
