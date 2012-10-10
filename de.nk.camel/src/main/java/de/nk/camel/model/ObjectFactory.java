package de.nk.camel.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public MyXmlBean createMyXmlBean() {
        return new MyXmlBean();
    }
}
