<%@ page contentType="text/html; charset=ISO-8859-9" %>
<!DOCTYPE html>
<html>
	<head>
		<title>LiberSoft</title>
		<style><%@include file="/resources/css/home.css"%></style>
		
	</head>
	<body class="body">
		<div class="wrapper">
			<div class="left-navbar">
				<img src="resources/imgs/libersoft_logo_blue.svg" class="logo">
				
				<hr style="margin: 10% 0"/>
				
				<a href="home.jsp" class="menuItem">
				<img src="resources/imgs/pagina_inicial.svg" class="iconeItem"> 
				Página Inicial
				</a>
				<a href="home.jsp" class="menuItem">
				<img src="resources/imgs/livros.svg" class="iconeItem"> 
				Livros
				</a>
				
				<span class="menuItem menuSubtitulo">Seu Acervo</span>
				
				<a href="home.jsp" class="menuItem">
				<img src="resources/imgs/meus_livros.svg" class="iconeItem"> 
				Meus Livros
				</a>
				<a href="home.jsp" class="menuItem">
				<img src="resources/imgs/renovacao.svg" class="iconeItem"> 
				Renovação
				</a>
				
				<span class="menuItem menuSubtitulo">Você</span>
				
				<a href="home.jsp" class="menuItem">
				<img src="resources/imgs/avatar_padrao.svg" class="iconeItem"> 
				Meu Perfil
				</a>
				<a href="home.jsp" class="menuItem">
				<img src="resources/imgs/sair.svg" class="iconeItem"> 
				Sair
				</a>
				
			</div>
			<div class="content">
				<div class="barraDePesquisa">
					<form action="PesquisaServlet" method="post" class="formularioPesquisa">
						<input type="text" id="pesquisa" class="inputSearch" placeholder="Procurar por livros...">
						<input type="submit" class="mainbtn button2" value="Pesquisar">
					</form>
				</div>
				
				<div class="recomendacoes">
					<p>Recomendações</p>
					<div class="livros">
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/sistemas_operacionais_andrew_tenembaum.jpg" class="livro">
								<span id="tituloLivro1" class="tituloLivro">Sistemas Operacionais Modernos - 2ª Edição</span>
								<br/>
								<span id="autorLivro1" class="autorLivro">Andrew S. Tenembaum</span>
							</a>
						</div>
						
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/codigo_limpo.jpg" class="livro">
								<span id="tituloLivro2" class="tituloLivro">Código Limpo</span>
								<br/>
								<span id="autorLivro2" class="autorLivro">Robert C. Martin</span>
							</a>
						</div>
						
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/sistemas_operacionais_andrew_tenembaum.jpg" class="livro">
								<span id="tituloLivro3" class="tituloLivro">Sistemas Operacionais Modernos - 2ª Edição</span>
								<br/>
								<span id="autorLivro3" class="autorLivro">Andrew S. Tenembaum</span>
							</a>
						</div>
						
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/codigo_limpo.jpg" class="livro">
								<span id="tituloLivro4" class="tituloLivro">Código Limpo</span>
								<br/>
								<span id="autorLivro4" class="autorLivro">Robert C. Martin</span>
							</a>
						</div>
						
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/sistemas_operacionais_andrew_tenembaum.jpg" class="livro">
								<span id="tituloLivro5" class="tituloLivro">Sistemas Operacionais Modernos - 2ª Edição</span>
								<br/>
								<span id="autorLivro5" class="autorLivro">Andrew S. Tenembaum</span>
							</a>
						</div>
					</div>
				</div>	
				
				<div class="meusLivros">
					<p>Meus Livros</p>
					<div class="livros">
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/codigo_limpo.jpg" class="livro">
								<span id="tituloLivro6" class="tituloLivro">Código Limpo</span>
								<br/>
								<span id="autorLivro6" class="autorLivro">Robert C. Martin</span>
							</a>
						</div>
						
						<div class="estruturaLivro">
							<a href="https://google.com/" target="_blank">
								<img src="resources/imgs/books/sistemas_operacionais_andrew_tenembaum.jpg" class="livro">
								<span id="tituloLivro7" class="tituloLivro">Sistemas Operacionais Modernos - 2ª Edição</span>
								<br/>
								<span id="autorLivro7" class="autorLivro">Andrew S. Tenembaum</span>
							</a>
						</div>
					</div>
				</div>			
			</div>
		</div>
	</body>
</html>