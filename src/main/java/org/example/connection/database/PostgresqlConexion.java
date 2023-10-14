package org.example.connection.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresqlConexion {

        protected Connection connection;


           private String url = "jdbc:postgresql://localhost:5432/TiendaPeliculas";
           private String username = "postgres";
           private String password = "1040045225";

            public void connect() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }

            public void close() throws SQLException {
                if (connection != null) {
                    if(!connection.isClosed()){
                        connection.close();
                    }
                }
            }
}