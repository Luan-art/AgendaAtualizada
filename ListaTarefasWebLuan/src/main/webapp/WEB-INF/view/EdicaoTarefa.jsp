<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Tarefa</title>
</head>
<body>

<h1>Edicao de tarefa</h1>
  <form action="<%= request.getContextPath() %>/editTask" method="post">
   <table style="with: 80%">
    <tr>
     <td>Titulo</td>
     <td><input type="text" name="nome" /></td>
    </tr>
    <tr>
     <td>Descirção</td>
     <td><input type="text" name="descricao" /></td>
    </tr>
    <tr>
     <td>data_criacao</td>
     <td><input type="text" name="data_criacao" /></td>
    </tr>
    <tr>
     <td>data_conclusao</td>
     <td><input type="password" name="data_conclusao" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>

</body>
</html>