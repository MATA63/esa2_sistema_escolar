package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import siscol.persistencia.*;
import siscol.persistencia.helper.DBConn;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;


public class GraphicalInterface {

	private static final int OPT_LISTAR_ALUNO = 1;
	private static final int OPT_CADASTRAR_ALUNO = 2;
	private static final int OPT_REMOVER_ANULO = 3;
	private static final int OPT_LISTAR_PROFESSORES = 4;
	private static final int OPT_CADASTRAR_PROFESSOR = 5;
	private static final int OPT_REMOVER_PROFESSOR = 6;
	private static final int OPT_LISTAR_DIRETORES = 7;
	private static final int OPT_CADASTRAR_DIRETOR = 8;
	private static final int OPT_REMOVER_DIRETOR = 9;
	private static final int OPT_LISTAR_FUNCIONARIO = 10;
	private static final int OPT_CADASTRAR_FUNCIONARIO = 11;
	private static final int OPT_REMOVER_FUNCIONARIO = 12;
	private static final int OPT_LISTAR_DISCIPLINA = 13;
	private static final int OPT_CADASTRAR_DISCIPLINA = 14;
	private static final int OPT_LISTAR_NOTAS = 15;
	private static final int OPT_LANCAR_NOTA = 16;
	private static final int OPT_CADASTRAR_SALA = 17;
	private static final int OPT_LISTAR_SALA = 18;
	private static final int OPT_REMOVER_SALA = 19;
	private static final int OPT_CADASTRAR_TURMA = 20;
	private static final int OPT_LISTAR_TURMA = 21;
	
	
	private static int opt;
	private static DBConn conn;

	public static void main(String[] args) {
		conn = new DBConn();
		TelaPrincipal();
	}

	public static void TelaPrincipal() {
		System.out.println("SisCol - Sistema Escolar");
		System.out.println("Alunos:");
		System.out.println("\t" + OPT_LISTAR_ALUNO + ".Listar alunos");
		System.out.println("\t" + OPT_CADASTRAR_ALUNO + ".Cadastrar novo aluno");
		System.out.println("\t" + OPT_REMOVER_ANULO + ".Remover aluno");
		System.out.println("Professores:");
		System.out.println("\t" + OPT_LISTAR_PROFESSORES + ".listar professores");
		System.out.println("\t" + OPT_CADASTRAR_PROFESSOR + ".Cadastrar novo professor");
		System.out.println("\t" + OPT_REMOVER_PROFESSOR + ".Remover professor.");
		System.out.println("Diretores:");
		System.out.println("\t" + OPT_LISTAR_DIRETORES + ".Listar diretores");
		System.out.println("\t" + OPT_CADASTRAR_DIRETOR + ".Cadastrar novo diretor");
		System.out.println("\t" + OPT_REMOVER_DIRETOR + ".Remover diretor");
		System.out.println("Funcionários:");
		System.out.println("\t" + OPT_LISTAR_FUNCIONARIO + ".Listar funcionários");
		System.out.println("\t" + OPT_CADASTRAR_FUNCIONARIO + ".Cadastrar novo funcionário");
		System.out.println("\t" + OPT_REMOVER_FUNCIONARIO + ".Remover funcionário");
		System.out.println("Disciplinas:");
		System.out.println("\t" + OPT_LISTAR_DISCIPLINA + ".Listar disciplinas.");
		System.out.println("\t" + OPT_CADASTRAR_DISCIPLINA + ".Cadastrar nova disciplina.");
		System.out.println("Notas:");
		System.out.println("\t" + OPT_LISTAR_NOTAS + ".Listar notas.");
		System.out.println("\t" + OPT_LANCAR_NOTA + ".Lançar nota.");
		System.out.println("Salas:");
		System.out.println("\t" + OPT_LISTAR_SALA + ".Listar salas");
		System.out.println("\t" + OPT_CADASTRAR_SALA + ".Cadastrar nova sala");
		System.out.println("\t" + OPT_REMOVER_SALA + ".Remover salas");
		System.out.println("Turmas:");
		System.out.println("\t" + OPT_CADASTRAR_TURMA + ".Cadastrar nova turma");
		System.out.println("\t" + OPT_LISTAR_TURMA + ".Listar turmas");

		System.out.print("Selecione opcao: ");
		opt = readInt();
		selecionaOpcao();

	}

	@SuppressWarnings("unchecked")
	private static void selecionaOpcao() {
		switch (opt) {
		case OPT_LISTAR_ALUNO:
			List<Aluno> alunos = (List<Aluno>) (List<?>) Aluno.findAll(Aluno.class);
			for (Aluno a : alunos)
				System.out.println(a);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case OPT_CADASTRAR_ALUNO:
			TelaCadastrarAluno();
			break;
		case OPT_REMOVER_ANULO:
			try {
				TelaRemoverAluno();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case OPT_LISTAR_PROFESSORES:
			List<Professor> professores = (List<Professor>) (List<?>) Professor.findAll(Professor.class);
			for (Professor p : professores)
				System.out.println(p);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case OPT_CADASTRAR_PROFESSOR:
			TelaCadastrarProfessor();
			break;
		case OPT_REMOVER_PROFESSOR:
			TelaRemoverProfessor();
			break;
		case OPT_LISTAR_DIRETORES:
			List<Diretor> diretores = (List<Diretor>) (List<?>) Diretor.findAll(Diretor.class);
			for (Diretor diretor : diretores)
				System.out.println(diretor);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case OPT_CADASTRAR_DIRETOR:
			TelaCadastrarDiretor();
			break;
		case OPT_REMOVER_DIRETOR:
			TelaRemoverDiretor();
			break;
		case OPT_LISTAR_FUNCIONARIO:
			List<Funcionario> funcionarios = (List<Funcionario>) (List<?>) Funcionario.findAll(Funcionario.class);
			for (Funcionario funcionario : funcionarios)
				System.out.println(funcionario);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case OPT_CADASTRAR_FUNCIONARIO:
			TelaCadastrarFuncionario();
			break;
		case OPT_REMOVER_FUNCIONARIO:
			TelaRemoverFuncionario();
			break;
		case OPT_CADASTRAR_DISCIPLINA:
			TelaCadastrarDisciplina();
			break;
		case OPT_LISTAR_DISCIPLINA:
			List<Disciplina> disciplinas = (List<Disciplina>) (List<?>) Disciplina.findAll(Disciplina.class);
			for (Disciplina disciplina : disciplinas)
				System.out.println(disciplina);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case OPT_LISTAR_NOTAS:
			System.out.println("Nome do aluno:");
			List<Aluno> alunoLista = (List<Aluno>) (List<?>) Aluno.find(Aluno.class, "Nome", readStr());
			if (alunoLista != null && alunoLista.size() != 0) {
				List<Notas> notas = (List<Notas>) (List<?>) Notas.find(Notas.class, "aluno_id",
						String.valueOf(alunoLista.get(0).id));
				for (Notas nota : notas)
					System.out.println(nota);
				System.out.println("Pressione qualquer tecla para continuar.");
				readStr();
			} else {
				System.out.println("Aluno nao encontrado.");
				System.out.println("Pressione qualquer tecla para continuar.");
				readStr();
			}
			TelaPrincipal();
			break;
		case OPT_LANCAR_NOTA:
			TelaLancarNota();
			break;
		case OPT_LISTAR_SALA:
			List<Sala> salas = (List<Sala>) (List<?>) Sala.findAll(Sala.class);
			for (Sala s : salas)
				System.out.println(s);
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		case OPT_CADASTRAR_SALA:
			TelaCadastrarSalas();
			break;
		case OPT_REMOVER_SALA:
			TelaRemoverSalas();
			break;
		case OPT_CADASTRAR_TURMA:
			TelaCadastrarTurmas();
			break;
		case OPT_LISTAR_TURMA:
			List<Turma> turmaLista = (List<Turma>) (List<?>) Turma.findAll(Turma.class);
			if (turmaLista != null && turmaLista.size() != 0) {
				List<Sala> salasLista = (List<Sala>) (List<?>) Sala.find(Sala.class, "sala_id",
						String.valueOf(turmaLista.get(0).id));
				for (Sala sala : salasLista)
					System.out.println(sala);
				System.out.println("Pressione qualquer tecla para continuar.");
				readStr();
			} else {
				System.out.println("turma nao encontrado.");
				System.out.println("Pressione qualquer tecla para continuar.");
				readStr();
			}
			TelaPrincipal();
			break;
			
		default:
			System.out.println("Opção inválida.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
			TelaPrincipal();
			break;
		}

	}

	private static void TelaLancarNota() {
		System.out.println("Nome do aluno:");
		List<Aluno> alunoLista = (List<Aluno>) (List<?>) Aluno.find(Aluno.class, "Nome", readStr());
		if (alunoLista != null && alunoLista.size() != 0) {
			System.out.println("Nome da disciplina:");
			List<Disciplina> disciplinaLista = (List<Disciplina>) (List<?>) Disciplina.find(Disciplina.class, "Nome",
					readStr());
			if (disciplinaLista != null && disciplinaLista.size() != 0) {
				Notas nota = new Notas();
				nota.aluno = alunoLista.get(0);
				nota.disciplina = disciplinaLista.get(0);
				System.out.println("Valor:");
				nota.valor = readInt();
				nota.save(Notas.class);
			} else {
				System.out.println("Disciplina nao encontrada.");
				System.out.println("Pressione qualquer tecla para continuar.");
				readStr();
			}
		} else {
			System.out.println("Aluno nao encontrado.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();

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
			aluno.save(Aluno.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();

	}

	public static Aluno TelaRemoverAluno() throws SQLException {
		Aluno aluno = null;
		System.out.println("SisCol - Sistema Escolar - Remover Aluno\n");
		System.out.println("Digite o nome do aluno\n");
		String nome = readStr();
		@SuppressWarnings("unchecked")
		List<Aluno> alunos = (List<Aluno>) (List<?>) Aluno.find(Aluno.class, "Nome", nome);
		if (alunos != null && alunos.size() != 0) {
			alunos.get(0).delete(Aluno.class);
			aluno = alunos.get(0);
		} else {
			System.out.println("Aluno nao encontrado.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();
		return aluno;
	}

	public static Diretor TelaRemoverDiretor() {
		Diretor diretor = null;
		System.out.println("SisCol - Sistema Escolar - Remover Diretor\n");
		System.out.println("Digite o nome do diretor\n");
		String nome = readStr();
		@SuppressWarnings("unchecked")
		List<Diretor> diretores = (List<Diretor>) (List<?>) Diretor.find(Diretor.class, "Nome", nome);
		if (diretores != null && diretores.size() != 0) {
			diretores.get(0).delete(Diretor.class);
			diretor = diretores.get(0);

		} else {
			System.out.println("Diretor nao encontrado.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();
		return diretor;
	}

	public static Professor TelaRemoverProfessor() {
		Professor professor = null;
		System.out.println("SisCol - Sistema Escolar - Remover Professor\n");
		System.out.println("Digite o nome do professor\n");
		String nome = readStr();
		@SuppressWarnings("unchecked")
		List<Professor> professores = (List<Professor>) (List<?>) Professor.find(Professor.class, "Nome", nome);
		if (professores != null && professores.size() != 0) {
			professores.get(0).delete(Professor.class);
			professor = professores.get(0);

		} else {
			System.out.println("Professor nao encontrado.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();
		return professor;
	}

	public static Funcionario TelaRemoverFuncionario() {
		Funcionario funcionario = null;
		System.out.println("SisCol - Sistema Escolar - Remover Funcionario\n");
		System.out.println("Digite o nome do funcionario\n");
		String nome = readStr();
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = (List<Funcionario>) (List<?>) Funcionario.find(Funcionario.class, "Nome",
				nome);
		if (funcionarios != null && funcionarios.size() != 0) {
			funcionarios.get(0).delete(Funcionario.class);
			funcionario = funcionarios.get(0);
		} else {
			System.out.println("Funcionario nao encontrado.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();
		return funcionario;
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
			diretor.save(Diretor.class);
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
			professor.save(Professor.class);
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
			funcionario.save(Funcionario.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();
	}

	public static void TelaCadastrarDisciplina() {
		Disciplina disciplina = new Disciplina();
		System.out.println("SisCol - Sistema Escolar - Cadastrar Disciplina\n");
		System.out.println("Nome:");
		disciplina.Nome = readStr();
		System.out.println("Quantidade de alunos:");
		disciplina.qtdTotalAlunos = readInt();
		try {
			disciplina.save(Disciplina.class);
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
	
	public static void TelaCadastrarSalas() {
		Sala sala = new Sala();
		System.out.println("SisCol - Sistema Escolar - Cadastrar Aluno\n");
		System.out.println("Numero da sala:");
		sala.numero = readInt();
		System.out.println("Quantidade maxima de alunos:");
		sala.qtdMaxima = readInt();
		try {
			sala.save(Sala.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaPrincipal();

	}

	public static Sala TelaRemoverSalas() {
		Sala sala = null;
		System.out.println("SisCol - Sistema Escolar - Remover Sala\n");
		System.out.println("Digite o numero do sala\n");
		String numSala = readStr();
		@SuppressWarnings("unchecked")
		List<Sala> salas = (List<Sala>) (List<?>) Sala.find(Sala.class, "Numero", numSala);
		if (salas != null && salas.size() != 0) {
			salas.get(0).delete(Sala.class);
			sala = salas.get(0);
		} else {
			System.out.println("Sala nao encontrada.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();
		return sala;
	}

	private static void TelaCadastrarTurmas() {
		System.out.print("Numero da turma: ");
		Turma turma = new Turma();
		turma.NumTurma = readStr();
		
		System.out.print("Numero da sala: ");
		List<Sala> salaLista = (List<Sala>) (List<?>) Sala.find(Sala.class, "numero", readStr());
		if (salaLista != null && salaLista.size() != 0) {
			System.out.print("Nome da disciplina: ");
			turma.sala = salaLista.get(0);
			List<Disciplina> disciplinaLista = (List<Disciplina>) (List<?>) Disciplina.find(Disciplina.class, "Nome", readStr());
			if (disciplinaLista != null && disciplinaLista.size() != 0) {
				turma.disciplina = disciplinaLista.get(0);
				turma.save(Turma.class);
			} else {
				System.out.println("Disciplina nao encontrada.");
				System.out.println("Pressione qualquer tecla para continuar.");
				readStr();
			}
		} else {
			System.out.println("Sala nao encontrado.");
			System.out.println("Pressione qualquer tecla para continuar.");
			readStr();
		}
		TelaPrincipal();

	}


}
