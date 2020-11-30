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
        String etapa = "Inicializando...";
        Connection conn = null;
        Statement stmt = null;
        try{
            etapa = "Registrando a classe do driver...";
            Class.forName(CLASS_NAME);
            etapa = "Conectando ao banco de dados...";
            conn = getConnection();
            etapa = "Criando tabela de Disciplinas...";
            stmt = conn.createStatement();
            stmt.execute(Disciplina.getCreateStatement());
            if (Disciplina.getList().isEmpty()){
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Gestão de Projetos',"
                        + "'Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos',"
                        + "'5'"
                        + ")");
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Ética',"
                        + "'Ética; comportamento profissional ético. Moral e Direito',"
                        + "'5'"
                        + ")");
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Laboratório Eng. Software',"
                        + "'Desenvolvimento de um software utilizando os conhecimentos adquiridos ao longo do curso',"
                        + "'5'"
                        + ")");
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Programação Orientada a Objetos',"
                        + "'Conceitos e evolução da tecnologia de orientação a objetos',"
                        + "'4'"
                        + ")");
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Programação para Mobile',"
                        + "'Ambientes de programação para dispositivos móveis',"
                        + "'5'"
                        + ")");
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Sistemas Operacionais II',"
                        + "'Apresentação de um sistema operacional específico utilizado em ambiente corporativo',"
                        + "'4'"
                        + ")");
                stmt.execute("INSERT INTO disciplinas VALUES ("
                        + "'Trabalho de Graduação I',"
                        + "'O estudante elaborará, sob a orientação de docente, um Trabalho de Graduação',"
                        + "'5'"
                        + ")");
            }
            etapa = "Desconectando do banco de dados...";
        }catch (Exception ex){
            exceptionMessage = etapa + ": " + ex.getLocalizedMessage();
        }finally{
            try{
                conn.close();
            }catch (Exception ex2){}
            try{
                stmt.close();
            }catch (Exception ex2){}
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
