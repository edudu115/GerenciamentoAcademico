package br.edu.ifsp.inoo.gerenciamento.academico.model;

/**
 * Classe que representa uma avaliação acadêmica.
 * <p>
 * Esta classe é imutável em relação ao nome da avaliação, mas permite a alteração da nota e do peso.
 * </p>
 * 
 * <p>
 * Uma avaliação é composta por:
 * </p>
 * <ul>
 *   <li>Um nome (identificador da avaliação)</li>
 *   <li>Um peso (importância da avaliação no cálculo da média final)</li>
 *   <li>Uma nota (resultado obtido pelo aluno na avaliação)</li>
 * </ul>
 * 
 */
public final class Avaliacao {
    /**
     * Nome da avaliação. Este campo é imutável após a criação do objeto.
     */
    private final String nome;

    /**
     * Peso da avaliação, que define sua importância no cálculo da média final.
     */
    private int peso;

    /**
     * Nota obtida pelo aluno na avaliação.
     */
    private double nota;

    /**
     * Constrói uma nova avaliação com nome e peso especificados.
     * A nota é inicializada com o valor 0.
     *
     * @param nome Nome da avaliação
     * @param peso Peso da avaliação no cálculo da média final
     */
    public Avaliacao(String nome, int peso) {
        this.nome = nome;
        this.peso = peso;
        this.nota = 0;
    }

    /**
     * Define a nota obtida pelo aluno na avaliação.
     *
     * @param nota Nota a ser atribuída à avaliação
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * Retorna a nota atual da avaliação.
     *
     * @return Nota da avaliação
     */
    public double getNota() {
        return this.nota;
    }

    /**
     * Retorna o peso da avaliação.
     *
     * @return Peso da avaliação
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Retorna o nome da avaliação.
     *
     * @return Nome da avaliação
     */
    public String getNome() {
        return nome;
    }
}