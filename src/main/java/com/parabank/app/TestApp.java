package com.parabank.app;

import com.parabank.utils.ConfigReader;

import java.util.Properties;

public class TestApp {
    public static void main(String[] args){

        String filename = "app_config";
        ConfigReader.loadProperties(filename);

        Properties prop = ConfigReader.loadProperties(filename);
        String url = prop.getProperty("URL");
        String userName = prop.getProperty("USERNAME");
        String password = prop.getProperty("PASSWORD");

        System.out.println(url);
        System.out.println(userName);
        System.out.println(password);

    }
}
