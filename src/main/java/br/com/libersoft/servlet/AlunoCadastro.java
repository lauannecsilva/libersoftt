package br.com.libersoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.libersoft.dao.AlunoDAO;
import br.com.libersoft.model.Aluno;

@WebServlet("/AlunoCadastro")
public class AlunoCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AlunoCadastro() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/login.jsp";
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		int idBibliotecario = 1;
		int idEndereco = 1;
		String erro = request.getParameter("erro");
		
		AlunoDAO alunoDao = new AlunoDAO();
		Aluno aluno = new Aluno();
		
		System.out.println(nome);
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setMatricula(matricula);
		aluno.setTelefone(telefone);
		aluno.setSenha(senha);
		aluno.setIdBibliotecario(idBibliotecario);
		aluno.setIdEndereco(idEndereco);
		
		if (url == "/login.jsp") {
			alunoDao.save(aluno);
		}
		
		request.setAttribute("aluno", aluno);
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);	
	}

}
