<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Login </title>
</head>
<body>

<h1>Realizar Login</h1>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>Login</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>Senha</td>
     <td><input type="text" name="senha" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>

</body>
</html>