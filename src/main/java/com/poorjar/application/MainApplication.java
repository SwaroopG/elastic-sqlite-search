package com.poorjar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.collect.Lists;
import com.poorjar.controllers.AssetController;
import com.poorjar.controllers.TrackController;

/**
 * @author Swaroop
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.poorjar.controllers")
public class MainApplication
{
    public static void main(String[] args) throws Exception
    {
        @SuppressWarnings("unchecked")
        Object[] components = Lists.newArrayList(AssetController.class, TrackController.class).toArray();
        SpringApplication.run(components, args);
    }
}