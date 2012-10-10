package de.nk.camel.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Getter
@Setter
@ToString
@CsvRecord(separator = ",", skipFirstLine = true)
public class MyCsvBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @DataField(pos = 1)
    private int id;
    @DataField(pos = 2)
    private String msg;
    @DataField(pos = 3)
    private String target;
}
