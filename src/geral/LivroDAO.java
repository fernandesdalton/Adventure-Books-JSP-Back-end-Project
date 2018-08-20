package geral;

import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Livro;

public class LivroDAO {

	public static void Incluir(Livro livro) throws Exception {
		String sql = "insert into Livro (titulo, preco, ano, paginas, assunto, autor) " + "values('" + livro.getTitulo()
				+ "'," + " '" + livro.getPreco() + "', '" + livro.getAno() + "'," + " '" + livro.getPaginas() + "', '"
				+ livro.getAutor() + "', '" + livro.getAssunto() + "')";
		Conexao.execSql(sql);
		;
	}

	public static void Delete(Livro livro) throws Exception {
		String sql = "delete from Livro where codigo =" + livro.getCodigoLivro() + "";
		Conexao.execSql(sql);
	}

	public static ArrayList<Livro> getData() throws Exception {
		String sql = "select * from Livro order by titulo";
		ResultSet rs = Conexao.getList(sql);

		if (rs == null)
			throw new Exception("Não existe registros");

		ArrayList<Livro> livros = new ArrayList<Livro>();

		while (rs.next()) {
			Livro livro = new Livro();
			livro.setCodigoLivro(rs.getInt("codigo"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setPreco(rs.getDouble("preco"));
			livro.setAno(rs.getInt("ano"));
			livro.setPaginas(rs.getInt("paginas"));
			livro.setAssunto(rs.getString("Assunto"));
			livro.setAutor(rs.getString("autor"));
			livros.add(livro);
		}
		return livros;
	}

	public static void Alterar(Livro livro) throws Exception {
		String sql = "update Livro set titulo ='" + livro.getTitulo() + "',set preco ='" + livro.getPreco() + "'"
				+ "',set ano ='" + livro.getAno() + "'" + "',set paginas ='" + livro.getPaginas() + "'"
				+ "',set assunto ='" + livro.getAssunto() + "'" + "',set autor ='" + livro.getAutor() + "'"
				+ " where codigo = '" + livro.getCodigoLivro() + "'";
		Conexao.execSql(sql);
	}
}