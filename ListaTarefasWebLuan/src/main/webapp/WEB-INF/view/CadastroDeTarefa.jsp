<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de tarefas</title>
</head>
<body>

<h1>Registro de Nova tarefa</h1>
  <form action="<%= request.getContextPath() %>/CadastroDeTarefa" method="post">
   <table style="with: 80%">
    <tr>
     <td>Titulo</td>
     <td><input type="text" name="titulo" /></td>
    </tr>
    <tr>
     <td>Descirção</td>
     <td><input type="text" name="descricao" /></td>
    </tr>
   <tr>
	<td>Data criação</td>
	<td><input type="date" name="data_criacao" required/></td>
	 </tr>
	<tr>
	<td>Data conclusão</td>
	<td><input type="date" name="data_conclusao" required/></td>
	</tr>
	 <tr>
	<td>Status</td>
	<td><input type="checkbox" name="status" />Concluido</td>
	 </tr>
	</table><br>
   <input type="submit" value="Submit" />
  </form>

</body>
</html>