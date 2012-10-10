package de.nk.camel.route;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import de.nk.camel.model.MyCsvBean;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Component("route1")
public class Route1 extends AbstractRoute {

    @Override
    public void configureRoute() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat("de.nk.camel.model");

        from("file://c:/temp?noop=true")
                .log(body().toString())
                .unmarshal(bindy)
                .split(body())
                .process(new Processor() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Message in = exchange.getIn();
                        Map<String, Object> modelMap = (Map<String, Object>) in.getBody();
                        in.setBody(modelMap.get(MyCsvBean.class.getCanonicalName()));
                    }
                })
                .to("direct:camelRouter");
    }

}
