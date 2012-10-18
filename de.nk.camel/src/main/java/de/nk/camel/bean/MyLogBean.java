package de.nk.camel.bean;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;

import de.nk.camel.model.MyCsvBean;

@Log4j
@Service
public class MyLogBean {

    public MyCsvBean log(MyCsvBean bean) {

        log.info("##### " + bean.toString() + " #####");

        return bean;
    }

}
