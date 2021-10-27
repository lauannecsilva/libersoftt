package Servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.libersoft.DAO.AlunoDAO;
import br.com.libersoft.Entity.Aluno;

@WebServlet("/")
public class AlunoServlet extends HttpServlet {
	//   private static final long serialVersionUID = 1 L;
	    private AlunoDAO alunoDAO;

	    public void init() {
	        alunoDAO = new AlunoDAO();
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
	    	                	inserirAluno(request, response);
	    	                    break;
	    	                case "/delete":
	    	                   // deleteUser(request, response);
	    	                    break;
	    	                case "/edit":
	    	                	editarForm(request, response);
	    	                    break;
	    	                case "/update":
	    	                   // updateUser(request, response);
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
	    	        List <Aluno> listaAluno = alunoDAO.selectAlunos();
	    	        request.setAttribute("listaAluno", listaAluno);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-list.jsp");
	    	        dispatcher.forward(request, response);
	    	    }
	    private void mostrarForm(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-form.jsp");
	    	        dispatcher.forward(request, response);
	    	    }
	    private void editarForm(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, ServletException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        Aluno alunoExistente = alunoDAO.selecionarAluno(id);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-form.jsp");
	    	        request.setAttribute("aluno", alunoExistente);
	    	        dispatcher.forward(request, response);
	    	    }
	    private void inserirAluno(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	        String nome = request.getParameter("nome");
	    	        String email = request.getParameter("email");
	    	        String senha = request.getParameter("senha");
	    	        String cpf = request.getParameter("cpf");
	    	        String telefone = request.getParameter("telefone");
	    	       Aluno novoAluno= new Aluno(nome, email, senha, cpf, telefone);
	    	        alunoDAO.inserirAluno(novoAluno);
	    	        response.sendRedirect("list");
	    	    }
}
