
package br.edu.fatecpg.poo;

import java.util.ArrayList;

/**
 *
 * @author Luiz Livio
 */
public class Disciplina {
    private String nome;
    private String ementa;
    private int ciclo;
    private float nota;

    public Disciplina(String nome, String ementa, int ciclo) {
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
    
    public static ArrayList<Disciplina> getList(){
        if (discList == null){
            discList = new ArrayList<>();
            discList.add(new Disciplina("Gestão de Projetos", "Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos", 5));
            discList.add(new Disciplina("Ética", "Ética; comportamento profissional ético. Moral e Direito", 5));
            discList.add(new Disciplina("Laboratório Eng. Software", "Desenvolvimento de um software utilizando os conhecimentos adquiridos ao longo do curso", 5));
            discList.add(new Disciplina("Programação Orientada a Objetos", "Conceitos e evolução da tecnologia de orientação a objetos", 4));
            discList.add(new Disciplina("Programação para Mobile", "Ambientes de programação para dispositivos móveis", 5));
            discList.add(new Disciplina("Sistemas Operacionais II", "Apresentação de um sistema operacional específico utilizado em ambiente corporativo", 4));
            discList.add(new Disciplina("Trabalho de Graduação I", "O estudante elaborará, sob a orientação de docente, um Trabalho de Graduação", 5));
        }
        return discList;
    }
}


