<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
	<head>
		<title>LiberSoft</title>
		<style><%@include file="/resources/css/cadastro.css"%></style>
		
	</head>
	<body class="body">
		<div class="conteudo">
			<div class="cadastro">
				<div class="cadastroTopo">
					<label class="titulo">Cadastro</label><br/>
					<label class="subtitulo">Insira as informações do novo usuário.</label><hr/>				
				</div>
				
				<form action="AlunoCadastro" method="post">
					<input type="text" name="nomeCompleto" class="inputText" placeholder="Nome Completo">
					<input type="text" name="email" class="inputText" placeholder="Email">
					<input type="text" name="matricula" class="inputText" placeholder="Matricula">
					<input type="text" name="telefone" class="inputText" placeholder="Telefone">
					<input type="text" name="senha" class="inputText" placeholder="Senha">
					
					<input type="submit" class="button1 mainbtn" value="Cadastre">
				</form>
				
			</div>
		</div>
	</body>
</html>