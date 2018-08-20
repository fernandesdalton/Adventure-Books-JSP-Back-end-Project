package beans;

public class Livro {

	private int codigoLivro;
	private String titulo;
	private double preco;
	private int ano;
	private int paginas;
	private String Assunto;
	private String Autor;
	
	public Livro() {
		
	}

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getAssunto() {
		return Assunto;
	}

	public void setAssunto(String Assunto) {
		this.Assunto = Assunto;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String Autor) {
		this.Autor = Autor;
	}

	@Override
	public String toString() {
		return "Livro [codigoLivro=" + codigoLivro + ", titulo=" + titulo + ", preco=" + preco + ", ano=" + ano
				+ ", paginas=" + paginas + ", Assunto=" + Assunto + ", Autor=" + Autor + "]";
	}
	
}