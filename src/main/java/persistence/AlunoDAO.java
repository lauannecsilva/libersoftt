package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoDAO extends DAO {
	public void create (Aluno aluno) throws Exception{
		open();
		stmt = conexao.prepareStatement("insert into aluno values (null, ?,?,?,?,?,?)");
		
		
	}
}
