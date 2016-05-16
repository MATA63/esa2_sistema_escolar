Trabalho de engenharia de software 2 - 2015.2

Alunos: Tiago Gonçalves, Samuel Almeida
Projeto feito utilizando a IDE Eclipse

*Como criar um POJO
>@DatabaseTable(tableName = "notas")
public class Notas extends Model implements Serializable {
	@DatabaseField
	public int valor;
}

OBS: Basta estender Model e ter acesso a todos os métods CRUD da classe Model.java

*Como salvar um POJO
>nota.save(Notas.class);

*Como deletar um POJO
>nota.delete(Notas.class);

*Como listar todos os POJOs
>List<Disciplina> disciplinaLista = (List<Disciplina>) (List<?>) Disciplina.findAll(Disciplina.class);

*Como listar todos os POJOs por um argumento
>List<Disciplina> disciplinaLista = (List<Disciplina>) (List<?>) Disciplina.find(Disciplina.class, [nome_atributo],[valor_atributo]);

*Como listar todos os POJOs por vários argumentos
>List<Disciplina> disciplinaLista = (List<Disciplina>) (List<?>) Disciplina.find(Disciplina.class, String[] lista_atributos, String[] lista_valores_atributos);

Mais métodos em Model.java

