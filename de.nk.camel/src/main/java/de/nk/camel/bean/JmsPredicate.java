package de.nk.camel.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

import de.nk.camel.model.MyCsvBean;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
public class JmsPredicate implements Predicate {

    @Override
    public boolean matches(Exchange exchange) {
        MyCsvBean body = exchange.getIn().getBody(MyCsvBean.class);
        if ("jms".equalsIgnoreCase(body.getTarget()))
            return true;
        return false;
    }

}
