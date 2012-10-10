package de.nk.camel.route;

import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.springframework.stereotype.Component;

import de.nk.camel.model.MyXmlBean;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Component("route3")
public class Route3 extends AbstractRoute {

    @Override
    public void configureRoute() throws Exception {

        JaxbDataFormat jaxb = new JaxbDataFormat();
        jaxb.setContextPath("de.nk.camel.model");
        jaxb.setPrettyPrint(true);

        from("direct:camelJms")
                .convertBodyTo(MyXmlBean.class)
                .log(body().toString())
                .marshal(jaxb).convertBodyTo(String.class)
                .to("aq:queue:CAMEL_OUT");
    }
}
