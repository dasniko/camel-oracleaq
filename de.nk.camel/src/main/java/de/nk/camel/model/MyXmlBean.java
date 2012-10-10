package de.nk.camel.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Getter
@Setter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MyXmlBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement
    private int id;
    @XmlElement
    private String msg;
    @XmlElement
    private XMLGregorianCalendar timestamp;
}
