package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import siscol.persistencia.Aluno;
import siscol.persistencia.Diretor;
import siscol.persistencia.Funcionario;
import siscol.persistencia.Professor;
import siscol.persistencia.helper.DBConn;

public class GraphicalInterface {

	private static int opt;
	private static DBConn conn;

	public static void main(String[] args) {
		conn = new DBConn();
		TelaPrincipal();
	}

	public static void TelaPrincipal() {
		System.out.println("SisCol - Sistema Escolar\n");
		System.out.println("1.Listar alunos");
		System.out.println("2.Cadastrar novo aluno");
		System.out.println("3.listar professores");
		System.out.println("4.Cadastrar novo professor");
		System.out.println("5.Listar diretores");
		System.out.println("6.Cadastrar novo diretor");
		System.out.println("7.Listar funcionários");
		System.out.println("8.Cadastrar novo funcionário");
		opt = readInt();
		selecionaOpcao();

	}
	
	@SuppressWarnings("unchecked")
	private static void selecionaOpcao() {
		switch (opt) {
		case 1:
			List<Aluno> alunos = (List<Aluno>) (List<?>) Aluno.findAll(Aluno.class);
			for (Aluno a : alunos)
				System.out.println(a);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case 2:
			TelaCadastrarAluno();
			break;
		case 3:
			List<Professor> professores = (List<Professor>) (List<?>) Professor.findAll(Professor.class);
			for (Professor p : professores)
				System.out.println(p);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case 4:
			TelaCadastrarProfessor();
			break;
		case 5:
			List<Diretor> diretores = (List<Diretor>) (List<?>) Diretor.findAll(Diretor.class);
			for (Diretor diretor : diretores)
				System.out.println(diretor);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case 6:
			TelaCadastrarProfessor();
			break;
		case 7:
			List<Funcionario> funcionarios = (List<Funcionario>) (List<?>) Funcionario.findAll(Funcionario.class);
			for (Funcionario funcionario: funcionarios)
				System.out.println(funcionario);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case 8:
			TelaCadastrarFuncionario();
			break;
		default:
			System.out.println("Opção inválida.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		}

	}


	public static void TelaCadastrarAluno() {
		Aluno aluno = new Aluno();
		System.out.println("SisCol - Sistema Escolar - Cadastrar Aluno\n");
		System.out.println("Nome:");
		aluno.Nome = readStr();
		System.out.println("RG:");
		aluno.RG = readStr();
		System.out.println("Matrícula:");
		aluno.Matricula = readStr();
		try {
			aluno.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();

	}
	
	public static void TelaCadastrarDiretor() {
		Diretor diretor = new Diretor();
		System.out.println("SisCol - Sistema Escolar - Cadastrar Diretor\n");
		System.out.println("Nome:");
		diretor.Nome = readStr();
		System.out.println("RG:");
		diretor.RG = readStr();
		System.out.println("Endereço:");
		diretor.Endereco = readStr();
		try {
			diretor.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();
	}
	
	public static void TelaCadastrarProfessor() {
		Professor professor = new Professor();
		System.out.println("SisCol - Sistema Escolar - Cadastrar Professor\n");
		System.out.println("Nome:");
		professor.Nome = readStr();
		System.out.println("RG:");
		professor.RG = readStr();
		System.out.println("Endereço:");
		professor.Endereco = readStr();
		System.out.println("Titulação:");
		professor.Titulacao = readStr();
		try {
			professor.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();
	}
	
	
	public static void TelaCadastrarFuncionario() {
		Funcionario funcionario = new Funcionario();
		System.out.println("SisCol - Sistema Escolar - Cadastrar Funcionario\n");
		System.out.println("Nome:");
		funcionario.Nome = readStr();
		System.out.println("RG:");
		funcionario.RG = readStr();
		System.out.println("Endereço:");
		funcionario.Endereco = readStr();
		System.out.println("Cargo:");
		funcionario.Cargo = readStr();
		try {
			funcionario.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();
	}

	public static String readStr() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static int readInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;

	}
}
