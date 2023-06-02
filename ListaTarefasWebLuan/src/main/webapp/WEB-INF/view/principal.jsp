<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, model.Tarefa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes Tarefa</title>
</head>
<body>
<div align="center">
		<h1>Tarefas:</h1>
	</div>
	
	<% 
	List<Tarefa> lista = (List<Tarefa>) request.getAttribute("tarefas");
 
	
	if(lista != null) {
	
	for(Tarefa tarefa : lista) {
	
	%>
	
	<div align="center">
		<table border="1" style="with: 80%">
			<tr>
				<td>Titulo</td>
				<td><%= tarefa.getTitulo() %></td>
			</tr>
			<tr>
				<td>Descricao</td>
				<td><%= tarefa.getDescriacao() %></td>
			</tr>
			<tr>
				<td>Data Criação</td>
				<td><%= tarefa.getData_criacao() %></td>
			</tr>
			<tr>
				<td>Data Conclusão</td>
				<td><%= tarefa.getData_conclusao() %></td>
			</tr>
			<tr>
				<td>Status</td>
				<% 
					if(tarefa.isStatus()) {
				%>
				<td>Concluido</td>
				<%
					} else {
				%>
				<td>Em andamento</td>
				<%
					}
				%>
			</tr>

	
		</table>
		<a href="/ListaTarefasWebLuan/editTarefa?id_tarefa=<%= tarefa.getId() %>">Editar</a> |
		<a href="/ListaTarefasWebLuan/DeletarTarefa?id_tarefa=<%=tarefa.getId()%>&id_usuario=${idUser}">Remover</a>

	</div>
	<br>
	<% 
	}
	} else {
	%>
		<div>
			Sem tarefas Cadastradas !!
		</div>
	<%
	}
	%>

	<div align="center">
		<a href="/ListaTarefasWebLuan/CadastroDeTarefa?idUser=${idUser}" style="font-size: 40px; text-decoration: none" > Adicionar Tarefa</a>
	</div>
	
	<div align="center">
		<a href="/ListaTarefasWebLuan/logout" style="font-size: 40px; text-decoration: none" >Deslogar!</a>
	</div>

	
</body>