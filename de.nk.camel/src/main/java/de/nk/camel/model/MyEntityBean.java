package de.nk.camel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Niko Köbler, http://www.n-k.de
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "CAMEL_DEMO")
public class MyEntityBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String message;
    private Date datetime;
}
