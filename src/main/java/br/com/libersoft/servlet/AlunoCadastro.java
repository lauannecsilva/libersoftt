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
		String url = "/faces/home.xhtml";
		
		String nome = request.getParameter("nomeCompleto");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		int idBibliotecario = 1;
		int idEndereco = 1;
		
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
		
		alunoDao.save(aluno);
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);	
	}

}
