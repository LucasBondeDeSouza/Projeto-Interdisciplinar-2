<%@page import="model.VendaDAO" %>
<%@page import="data.Venda" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Tabela Vendas</title>
    
    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="resources/css/style.css" rel="stylesheet">
</head>

<style>
    th, td {
        text-align: center;
    }

    th, td {
        font-size: 20px;
    }

    td {
        color: white;
    }

    .btn-primary {
        background-color: #3AABFE;
        border-color: #3AABFE;
    }

    .btn-primary:hover {
        background-color: #3194da;
        border-color: #3194da;
    }

    .btn-primary, .btn-danger {
        font-weight: 700;
    }
    
    .exportar {
        background-color: #61C373;
        border-color: #61C373;
    }
    
    .exportar:hover {
        background-color: #47a859;
        border-color: #47a859;
    }
</style>

<body>
    <div class="container-fluid position-relative d-flex p-0">

        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="menu.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Vendas</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="ms-3">
                        <!-- <h6 class="mb-0">Jhon Doe</h6> -->
                        <span>Admin</span>
                    </div>
                </div>

                <div class="navbar-nav w-100">
                    <a href="menu.html" class="nav-item nav-link"><i class="fa fa-home me-2"></i>Menu</a>
                    <a href="cadastrarVenda.html" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Cadastrar Venda</a>
                    <a href="tabela.jsp" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>Tabela</a>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->

        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <a href="menu.jsp" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>

                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item dropdown">
                        <a href="logout.jsp" class="btn btn-danger m-2">Sair</a>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->
            
            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
            
                <div class="bg-secondary rounded h-100 p-4">
                    <h1 class="mb-4"><strong>Vendas</strong></h1>
                    <div class="table-responsive">
                        <table class="table">
                    <tr>
                         <th>#</th>
                         <th>Comprador</th>
                         <th>Categoria</th>
                         <th>Produto</th>
                         <th>Data Venda</th>
                         <th>Valor</th>
                         <th>Quantidade</th>
                         <th>Vendedor</th>
                         <th>Ações</th>
                   </tr>
                   <%
                       try {
                           VendaDAO objVenda = new VendaDAO();
                           ArrayList<Venda> lista = objVenda.listarVendas();
                           
                           if (lista.isEmpty()) {
                   %>  
                               <tr>
                                   <td colspan="9">Nehuma Venda Cadastrada!</td>
                               </tr>
                   <% 
                           } else {

                           for (int i = 0; i < lista.size(); i++) {
                   %>
                  <tr>
                       <td><%= lista.get(i).getIdVendas() %></td>
                       <td><%= lista.get(i).getComprador() %></td>
                       <td><%= lista.get(i).getCategoria() %></td>
                       <td><%= lista.get(i).getNomeProduto() %></td>
                       <td><%= lista.get(i).getDataVenda() %></td>
                       <td><%= "R$" + lista.get(i).getValor() %></td>
                       <td><%= lista.get(i).getQuantidade() %></td>
                       <td><%= lista.get(i).getNomeVendedor() %></td>
                       <td>
                           <a href="select?idVendas=<%=lista.get(i).getIdVendas()%>" class="btn btn-primary mb-1"><strong>Editar</strong></a>
                           <a href="delete?idVendas=<%= lista.get(i).getIdVendas() %>" class="btn btn-danger mb-1"><strong>Excluir</strong></a>
                       </td>
                 </tr>
                 <%
                           }
                        }
                    } catch (Exception e) {
                    	%>
                        <tr>
                            <td colspan="9">Nenhum dado cadastrado!</td>
                        </tr>
                        <%
                    }
                  %> 
           </table>
                    </div>
                </div>
            </div>
            <!-- Table End -->
            
        </div> 
        <!-- Content End -->
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <!-- Template Javascript -->
    <script src="resources/js/main.js"></script>
    <script src="scripts/confirmador.js"></script>
</body>
</html>
