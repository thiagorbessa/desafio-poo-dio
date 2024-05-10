package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	//criar um hash guarda o conteudo, após se inscrever no curso ele será
	//colocado na mesma ordem
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	//é usado pois não pode ser inscrito no mesmo curso mais de uma vez
	//e na ordem de cursos adicionados
	
	public void inscreverBootcamp(Bootcamp bootcamp) {//esse bootcamp deverá ter sido criado o objeto na classe main ou no enum
	this.conteudosInscritos.addAll(bootcamp.getConteudos());//adiciona dentro de conteudos inscritos o bootcamp inscrito ao
	//chamar o metodo inscreverBootcamp
	bootcamp.getDevsInscritos().add(this);//adiciona o dev no bootcamp, metodos getDevsInscritos
	}
	public void progredir() {
		//quando concluir os conteudos eles saem do conteudosInscritos e são adicionados
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		//pega o primeiro conteudo inscrito e coloca
		//na variavel conteudo
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		}
		else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
		
	}
	
	public double calcularTotalXp() {
		return this.conteudosConcluidos.stream()
				.mapToDouble(conteudo -> conteudo.calcularXp())
				.sum();//pega a xp de todos conteudos e soma
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Conteudo> getConteudosInscritos() {
		 System.out.println("|--------------------|");
		return conteudosInscritos;
	}
	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}
	public Set<Conteudo> getConteudosConcluidos() {
		System.out.println("|--------------------|");
		return conteudosConcluidos;
	}
	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}
	
	//crie equals e hashCode toda as vezes que for usar Hash
	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}
	
	
}
