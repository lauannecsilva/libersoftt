package libersoft.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libersoft.DAO.AlunoDAO;
import libersoft.Model.Aluno;

public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlunoDAO alunoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsuario = getServletContext().getInitParameter("jdbcUsuario");
		String jdbcSenha = getServletContext().getInitParameter("jdbcSenha");

		alunoDAO = new AlunoDAO(jdbcURL, jdbcUsuario, jdbcSenha);
	}

	protected void Post(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        try {
	            switch (action) {
	            case "/new":
	                mostrarForm(request, response);
	                break;
	            case "/insert":
	                inserirALuno(request, response);
	                break;
	            case "/delete":
	                deletarAluno(request, response);
	                break;
	            case "/edit":
	                editarForm(request, response);
	                break;
	            case "/update":
	                atualizarAluno(request, response);
	                break;
	            default:
	                listaAluno(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	  private void listaAluno(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<Aluno> listaAluno = alunoDAO.listarTodosOsAlunos();
	        request.setAttribute("listaAluno ", listaAluno );
	        RequestDispatcher dispatcher = request.getRequestDispatcher("endereço da pagina no front ex: listaAlunos.xhtml");
	        dispatcher.forward(request, response);
	    }
	   private void mostrarForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("endereço da pagina no front q tem o form");
	        dispatcher.forward(request, response);
	    }
	   private void editarForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
	        Aluno aluno = alunoDAO.pegarAluno(id_aluno);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("endereço da pagina no front ");
	        request.setAttribute("aluno", aluno);
	        dispatcher.forward(request, response);
	    }
	   private void inserirALuno(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String nomeCompleto= request.getParameter("nomeCompleto");
	        String email = request.getParameter("email");
	        String senha = request.getParameter("senha");
	        String cpf = request.getParameter("cpf");
	        String telefone = request.getParameter("telefone");
	        String endereco = request.getParameter("endereco");
	       
	        Aluno novoAluno = new Aluno(nomeCompleto, email, senha, cpf, telefone, endereco);
	        alunoDAO.inserirALuno(novoAluno);
	        response.sendRedirect("listaAluno");
	    }
	   private void atualizarAluno(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
	        String nomeCompleto= request.getParameter("nomeCompleto");
	        String email = request.getParameter("email");
	        String senha = request.getParameter("senha");
	        String cpf = request.getParameter("cpf");
	        String telefone = request.getParameter("telefone");
	        String endereco = request.getParameter("endereco");
	     
	        Aluno aluno = new Aluno(id_aluno, nomeCompleto, email, senha, cpf, telefone, endereco);
	        alunoDAO.atualizarAluno(aluno);
	        response.sendRedirect("listaAluno");
	    }
	    private void deletarAluno(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
	 
	        Aluno aluno = new Aluno(id_aluno);
	        alunoDAO.excluirAluno(aluno);
	        response.sendRedirect("listaALuno");
	 
	    }
}