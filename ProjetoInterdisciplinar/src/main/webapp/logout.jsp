<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% 
    // Encerre a sessão atual
    session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
    <!-- Redirecione para a página de login ou qualquer outra página desejada após o logout -->
    <meta http-equiv="refresh" content="0;url=login.html">
</head>
<body>
    <!-- Página de logout -->
</body>
</html>