<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
	<head>
		<title>LiberSoft</title>
		<style><%@include file="/resources/css/cadastro.css"%></style>
		<script><%@include file="/resources/js/cadastro.js"%></script>
		
	</head>
	<body class="body">
		<div class="conteudo">
			<div class="cadastro">
				<div class="cadastroTopo">
					<label class="titulo">Cadastro</label><br/>
					<label class="subtitulo">Insira as informações do novo usuário.</label><hr/>				
				</div>
				
				<form action="AlunoCadastro" method="post">
					<input type="text" name="nome" class="inputText" placeholder="Nome Completo" value="${aluno.nome}">
					<input type="text" name="email" class="inputText" placeholder="Email" value="${aluno.email}">
					<input type="text" name="telefone" class="inputText" placeholder="Telefone" value="${aluno.telefone}">
					<input type="text" name="matricula" class="inputText" placeholder="Matricula" value="${aluno.matricula}">
					<input type="text" name="senha" class="inputText" placeholder="Senha" value="${aluno.senha}">
					
					<input type="submit" class="button1 mainbtn" value="Cadastre">
					<span id="erro"></span>
				</form>
				
			</div>
		</div>
	</body>
</html>