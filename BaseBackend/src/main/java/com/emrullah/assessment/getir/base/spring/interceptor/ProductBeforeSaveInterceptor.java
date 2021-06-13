package com.emrullah.assessment.getir.base.spring.interceptor;

import com.emrullah.assessment.getir.base.entity.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductBeforeSaveInterceptor extends AbstractMongoEventListener<Product> {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onBeforeSave(BeforeSaveEvent<Product> event) {
        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info(event.getSource().getName() + " product entity has been changed by " + uname + " at " + new Date());
    }
}
