package com.fag.infra.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

    private static PostgresConnection instance;

    private Connection connection = null;

    private PostgresConnection() {
        System.out.println("Realizando conexão banco PG/SUPABASE🔌");

        //Url e informações do seu banco no supabase
        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres";
        String username = "postgres.evyhlhmfmqosbyhthcye";
        String password = "Supabase10.";

        try {
            //realizando a conexão
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Deu boa! Banco conectado!🗂");
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static synchronized PostgresConnection getInstance() {
        if (instance == null) {
            instance = new PostgresConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
