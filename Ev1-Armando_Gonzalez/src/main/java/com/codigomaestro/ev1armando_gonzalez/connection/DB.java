package com.codigomaestro.ev1armando_gonzalez.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DB {

    public static Connection getConnection() throws SQLException, NamingException {

        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/3069543DataSource");
        System.out.println("DataSource: " + ds);
        Connection conn = ds.getConnection();
        return conn;
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
