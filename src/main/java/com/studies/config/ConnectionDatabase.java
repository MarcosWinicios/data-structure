package com.studies.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

@Getter
public class ConnectionDatabase {
    private static ConnectionDatabase instance;
    private final EntityManagerFactory connection;

    static {
        instance = new ConnectionDatabase();
        System.out.println("\n\nInicializando Connection Database\n\n");
    }

    private ConnectionDatabase(){
        this.connection = Persistence.createEntityManagerFactory("database-config");
    }

    public static ConnectionDatabase getInstance(){
        if(instance == null){
            instance = new ConnectionDatabase();
        }
        return instance;
    }

}
