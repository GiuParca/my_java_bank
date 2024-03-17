package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.database.ConnectionManager;

public class Main {
    public static void main(String[] args) throws Exception {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.getConnection();
        connectionManager.getCustomers();
       }
}
