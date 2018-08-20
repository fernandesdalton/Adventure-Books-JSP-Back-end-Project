package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Cliente;
import beans.Funcionario;
import beans.Livro;
import geral.ClienteDAO;
import geral.FuncionarioDAO;
import geral.LivroDAO;

@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessa(request, response);
	}

	protected void doProcessa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String acao = request.getParameter("acao");
		
		RequestDispatcher rd = null;
		
		if (acao.equals("gravarLivro")) {
			String titulo = request.getParameter("titulo");
			double preco = Double.parseDouble("0"+request.getParameter("preco"));
			int ano = Integer.parseInt(request.getParameter("ano"));
			int paginas = Integer.parseInt(request.getParameter("paginas"));
			String assunto = request.getParameter("assunto");
			String autor = request.getParameter("autor");
			
			Livro livro = new Livro();
			livro.setTitulo(titulo);
			livro.setPreco(preco);
			livro.setAno(ano);
			livro.setPaginas(paginas);
			livro.setAssunto(assunto);
			livro.setAutor(autor);
			try {
				LivroDAO.Incluir(livro);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("livro", livro);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (acao.equals("listarLivro")) {
			try {
				ArrayList<Livro> listarlivros = LivroDAO.getData();

				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("listarlivros", listarlivros);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (acao.equals("listarCliente")) {
			try {
				ArrayList<Cliente> listarCliente = ClienteDAO.getData();

				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("listarCliente", listarCliente);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (acao.equals("gravarFuncionario")) {
			String loginFuncionario = request.getParameter("loginFuncionario");
			String senhaFuncionario = request.getParameter("senhaFuncionario");
			String nomeFuncionario = request.getParameter("nomeFuncionario");

			Funcionario funcionario = new Funcionario();
			funcionario.setLoginFuncionario(loginFuncionario);
			funcionario.setSenhaFuncionario(senhaFuncionario);
			funcionario.setNomeFuncionario(nomeFuncionario);

			try {
				FuncionarioDAO.Incluir(funcionario);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("funcionario", funcionario);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (acao.equals("listarFuncionario")) {
			try {
				ArrayList<Funcionario> listarFuncionario = FuncionarioDAO.getData();

				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("listarFuncionario", listarFuncionario);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		rd.forward(request, response);
	}
}
