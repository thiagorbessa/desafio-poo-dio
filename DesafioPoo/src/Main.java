

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso java");
		curso1.setDescricao("Descricao curso Java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso Js");
		curso2.setDescricao("Descricao curso Js");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria1 = new Mentoria();
		mentoria1.setTitulo("Mentoria Java");
		mentoria1.setDescricao("Descricao mentoria Java");
		mentoria1.setData(LocalDate.now());
		
		Mentoria mentoria2 = new Mentoria();
		mentoria2.setTitulo("Mentoria Html");
		mentoria2.setDescricao("Descricao mentoria Html");
		mentoria2.setData(LocalDate.now());
		
		Mentoria mentoria3 = new Mentoria();
		mentoria3.setTitulo("Mentoria Css");
		mentoria3.setDescricao("Descricao mentoria Css");
		mentoria3.setData(LocalDate.now());
		
		//Conteudo conteudo = new Curso();//polimorfismo
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria1);
		
		Bootcamp bootcampFull = new Bootcamp();
		bootcampFull.setNome("Bootcamp Java Developer");
		bootcampFull.setDescricao("Descrição Bootcamp Java Developer");
		bootcampFull.getConteudos().add(curso1);
		bootcampFull.getConteudos().add(curso2);
		bootcampFull.getConteudos().add(mentoria1);
		bootcampFull.getConteudos().add(mentoria2);
		bootcampFull.getConteudos().add(mentoria3);
		
		Dev devThiago = new Dev();
		devThiago.setNome("Thiago");
		System.out.println("Conteudos Inscritos de "+devThiago.getNome()+" "+devThiago.getConteudosInscritos());
		
		Dev devMayra = new Dev();
		devMayra.setNome("Mayra");
		System.out.println("Conteudos Inscritos de "+devMayra.getNome()+" "+devMayra.getConteudosInscritos());
		
		devThiago.inscreverBootcamp(bootcampFull);
		devMayra.inscreverBootcamp(bootcamp);
		
		System.out.println("Conteudos concluidos de "+devThiago.getNome()+" "+devThiago.getConteudosConcluidos());
		System.out.println("Conteudos concluidos de "+devMayra.getNome()+" "+devMayra.getConteudosConcluidos());
		
		System.out.println("/------------------------------------------------------/");
		System.out.println("/------------------------------------------------------/");
		
		System.out.println("Conteudos Inscritos de "+devThiago.getNome()+" "+devThiago.getConteudosInscritos());
		System.out.println("Conteudos Inscritos de "+devMayra.getNome()+" "+devMayra.getConteudosInscritos());
		
		devThiago.progredir();
		devMayra.progredir();
		
		System.out.println("Conteudos Inscritos de "+devThiago.getNome()+" "+devThiago.getConteudosInscritos());
		System.out.println("Conteudos Inscritos de "+devMayra.getNome()+" "+devMayra.getConteudosInscritos());
		
		System.out.println("Conteudos concluidos de "+devThiago.getNome()+" "+devThiago.getConteudosConcluidos());
		System.out.println("Conteudos concluidos de "+devMayra.getNome()+" "+devMayra.getConteudosConcluidos());
		
		System.out.println("XP "+devThiago.calcularTotalXp());
		System.out.println("XP "+devMayra.calcularTotalXp());
		
		
	}

}
