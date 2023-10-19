<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="data.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Usuario" %>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Usuario> lista = (ArrayList<Usuario>)request.getAttribute("usuarios");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Análise de Vendas</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
     <h1>Análise de Vendas</h1>
     <a href="cadastro.html">Cadastrar</a><br>
     <a href="login.html">Login</a>
     
     <p>
     <table id="tabela">
           <thead>
                  <tr>
                      <th>Id</th>
                      <th>Nome</th>
                      <th>E-mail</th>
                      <th>Senha</th>
                  </tr>
           </thead>
           <tbody>
                      <% for (int i = 0; i < lista.size(); i++){ %>
                            <tr>
                                <td><%=lista.get(i).getIduser()%></td>
                                <td><%=lista.get(i).getNome()%></td>
                                <td><%=lista.get(i).getEmail()%></td>
                                <td><%=lista.get(i).getSenha()%></td>
                            </tr>
                      <%}%>
           </tbody>
      </table>
</body>
</html>