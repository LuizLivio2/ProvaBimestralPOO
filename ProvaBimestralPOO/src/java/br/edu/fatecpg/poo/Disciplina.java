
package br.edu.fatecpg.poo;

import java.util.ArrayList;
import java.sql.*;
import web.DbListener;

/**
 *
 * @author Luiz Livio
 */
public class Disciplina {
    private long rowId;
    private String nome;
    private String ementa;
    private int ciclo;
    private float nota;

    public Disciplina(long rowId, String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }
    
    private static ArrayList<Disciplina> discList;

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }
    
    
    
    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplinas ("
                + "nome VARCHAR (50) UNIQUE NOT NULL,"
                + "ementa VARCHAR (200) NOT NULL,"
                + "ciclo INTEGER NOT NULL"
                + ")";
    }
    
    
    public static ArrayList<Disciplina> getList() throws Exception{
            discList = new ArrayList<>();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            Exception methodException = null;
            try{
                conn = DbListener.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT rowId, * FROM disciplinas");
                while (rs.next()){
                    discList.add(new Disciplina(
                                rs.getLong("rowId"),
                                rs.getString("nome"),
                                rs.getString("ementa"),
                                rs.getInt("ciclo")));
                }
            }catch (Exception ex){
                throw ex;
            }finally{
                try{
                    conn.close();
                }catch (Exception ex2){}
                try{
                    stmt.close();
                }catch (Exception ex2){}
                try{
                    rs.close();
                }catch (Exception ex2){}
            }
            if (methodException != null){
                throw methodException;
            }
            
            return discList;
            /*discList.add(new Disciplina("Gestão de Projetos", "Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos", 5));
            discList.add(new Disciplina("Ética", "Ética; comportamento profissional ético. Moral e Direito", 5));
            discList.add(new Disciplina("Laboratório Eng. Software", "Desenvolvimento de um software utilizando os conhecimentos adquiridos ao longo do curso", 5));
            discList.add(new Disciplina("Programação Orientada a Objetos", "Conceitos e evolução da tecnologia de orientação a objetos", 4));
            discList.add(new Disciplina("Programação para Mobile", "Ambientes de programação para dispositivos móveis", 5));
            discList.add(new Disciplina("Sistemas Operacionais II", "Apresentação de um sistema operacional específico utilizado em ambiente corporativo", 4));
            discList.add(new Disciplina("Trabalho de Graduação I", "O estudante elaborará, sob a orientação de docente, um Trabalho de Graduação", 5));
            */
    }
    
    public static void insertDisciplina(String nome, String ementa, int ciclo) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            conn = DbListener.getConnection();
            stmt = conn.prepareStatement("INSERT INTO disciplinas VALUES(?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, ementa);
            stmt.setInt(3, ciclo);
            stmt.execute();
        }catch (Exception ex){
            throw ex;
        }finally{
            try{
                conn.close();
            }catch (Exception ex2){}
            try{
                stmt.close();
            }catch (Exception ex2){}
            try{
                rs.close();
            }catch (Exception ex2){}
        }
        if (methodException != null){
            throw methodException;
        }
    }
    public static void deleteDisciplina(long cod) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            conn = DbListener.getConnection();
            stmt = conn.prepareStatement("DELETE FROM disciplinas WHERE rowId=?");
            stmt.setLong(1, cod);
            stmt.execute();
        }catch (Exception ex){
            throw ex;
        }finally{
            try{
                conn.close();
            }catch (Exception ex2){}
            try{
                stmt.close();
            }catch (Exception ex2){}
            try{
                rs.close();
            }catch (Exception ex2){}
        }
        if (methodException != null){
            throw methodException;
        }
    }
    
}


