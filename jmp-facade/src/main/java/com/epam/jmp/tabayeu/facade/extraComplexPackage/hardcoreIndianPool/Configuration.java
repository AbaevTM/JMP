package com.epam.jmp.tabayeu.facade.extraComplexPackage.hardcoreIndianPool;

/**
 * Nicely coded indian implementation of a singleton pattern.
 * @author Tsimur_Abayeu
 *
 */
public class Configuration {

    public String DB_USER_NAME ;

    public String DB_PASSWORD ;

    public String DB_URL;

    public String DB_DRIVER;

    public Integer DB_MAX_CONNECTIONS;

    /**
     * Fully protected from creating another instance
     */
    public Configuration(){
     init();
    }

    private static Configuration configuration = new Configuration();

    public static Configuration getInstance(){
     return configuration;
    }

    private void init(){
     DB_USER_NAME = "root";
     DB_PASSWORD = "root";
     DB_URL = "jdbc:mysql://localhost:3306/jmanne";
     DB_DRIVER = "com.mysql.jdbc.Driver";
     DB_MAX_CONNECTIONS = 5;
    }

   }