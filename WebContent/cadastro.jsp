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
				
				<form action="AlunoServlet" method="post">
					<input type="text" id="nomeCompleto" class="inputText" placeholder="Nome Completo">
					<input type="text" id="senha" class="inputText" placeholder="Senha">
					<input type="text" id="email" class="inputText" placeholder="Email">
					<input type="text" id="telefone" class="inputText" placeholder="Telefone">
					<input type="text" id="cpf" class="inputText" placeholder="CPF">
					<input type="text" id="endereco" class="inputText" placeholder="Endereço">
					
					<input type="submit" class="button1 mainbtn" value="Cadastre">
				</form>
				
			</div>
		</div>
	</body>
</html>