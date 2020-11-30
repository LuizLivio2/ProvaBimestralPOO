/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import br.edu.fatecpg.poo.Disciplina;

/**
 * Web application lifecycle listener.
 *
 * @author Luiz Livio
 */
public class DbListener implements ServletContextListener {
    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\Luiz Livio\\Documents\\GitHub\\ProvaBimestralPOO\\p2.db";
    
    public static String exceptionMessage = null;
    
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
