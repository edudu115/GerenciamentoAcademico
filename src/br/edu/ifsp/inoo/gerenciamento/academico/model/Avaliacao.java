package br.edu.ifsp.inoo.gerenciamento.academico.model;

public final class Avaliacao {
    private final String nome;
    private final double peso;

    public Avaliacao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }
  
    public String nome() {
        return nome;
    }

    public double peso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                '}';
    }


    public static class Builder {
        private String nome;
        private double peso;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder peso(double peso) {
            if (peso < 0 || peso > 100) {
                throw new IllegalArgumentException("O peso deve estar entre 0% e 100%.");
            }
            this.peso = peso;
            return this;
        }

        public Avaliacao build() {
            return new Avaliacao(nome, peso);
        }
    }
}