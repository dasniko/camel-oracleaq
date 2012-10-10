package de.nk.camel.converter;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.camel.Converter;

import de.nk.camel.model.MyCsvBean;
import de.nk.camel.model.MyEntityBean;
import de.nk.camel.model.MyXmlBean;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Converter
public class MyConverter {

    @Converter
    public static MyEntityBean toEntity(MyCsvBean csv) {
        MyEntityBean entity = new MyEntityBean();
        entity.setId(System.currentTimeMillis());
        entity.setMessage(csv.getMsg());
        entity.setDatetime(new Date());
        return entity;
    }

    @Converter
    public static MyXmlBean toXml(MyCsvBean csv) {
        MyXmlBean xml = new MyXmlBean();
        xml.setId(csv.getId());
        xml.setMsg(csv.getMsg());

        XMLGregorianCalendar timestamp = null;
        try {
            timestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    (GregorianCalendar) GregorianCalendar.getInstance());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        xml.setTimestamp(timestamp);

        return xml;
    }
}
