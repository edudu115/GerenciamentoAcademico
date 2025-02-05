package teste;
import java.util.ArrayList;

public class Turma {
	private String codigo;
	private Disciplina disciplina;
	private Professor professor;
	private ArrayList<Estudante>estudantes= new ArrayList<Estudante>(); 
	private ArrayList<Avaliacao>atividades=new ArrayList<Avaliacao>();
	
	public Turma(String codigo, Disciplina disciplina, Professor professor){
		this.codigo=codigo;
		this.disciplina=disciplina;
		this.professor=professor;
		
	}
	
	public void adicionarEstudante(Estudante estudante) {
		estudantes.add(estudante);
	}
	
	public double calcularRendimento(Estudante estudante) {
		double rendimento;
		
		for()
		
		return rendimento;
		
	}
	
    public double calcularFrequencia(Estudante estudante) {
		double frequencia;
		frequencia=estudante.consultarFaltas() + disciplina.totalAulas();
		return frequencia;
		
	}
	
	
	
	
	public String getcodigo() {
		return this.codigo;
	}
	
	public Disciplina getdisciplina() {
		return this.disciplina;
	}
	 
	public Professor getprofessor() {
		return this.professor;
	}
	
	public void setcodigo(String codigo) {
		this.codigo=codigo;
	}
	
	public void setdisciplina(Disciplina disciplina) {
		 this.disciplina=disciplina;
	}
	
	public void setprofessor(Professor professor) {
		 this.professor= professor;
	}
	
}
