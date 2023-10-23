<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastrar Venda</title>

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
    /* Estilo para remover os botões de aumento e diminuição */
    input[type="number"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    
    input[type="button"], .btn {
		font-size: 18px;
		font-weight: 800;
	}
	
	input {
	   color: white;
	}

    .form-control {
        width: 100%; 
        font-size: 18px;
        padding: 10px; 
    }

    label {
        font-size: 18px;
        color: #fff;
    }
    
    select[name="categoria"] {
        width: 100%;
        font-size: 18px;
        font-weight: 600;
        padding: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #000;
        color: #fff;
        border: none;
    }
    
    #caixa3 {
        background: black;
        border: 1px solid #ff0000;
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
                    <a href="cadastrarVenda.html" class="nav-item nav-link active"><i class="fa fa-keyboard me-2"></i>Cadastrar Venda</a>
                    <a href="tabela.jsp" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Tabela</a>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->

        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
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

            <!-- Form Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded h-100 p-4">
                    <h1 class="mb-4"><strong>Editar Venda</strong></h1>
                    <form class="form-floating mb-3" name="frmVenda" action="update">
                        <div class="form-floating mb-3">
                            <input type="number" name="idVendas" id="caixa3" readonly
                            value = "<%out.print(request.getAttribute("idVendas")); %>">
                        </div>
						<div class="form-floating mb-3">
                            <input type="text" name="comprador" class="form-control" id="floatingText" placeholder="Nome..." required
                            value = "<%out.print(request.getAttribute("comprador")); %>">
                            <label for="floatingText"><Strong>Comprador</Strong></label>
                        </div>
                        <div class="form-floating mb-3">
                             <select name="categoria" id="nomeCategoria" required
                             value = "<%out.print(request.getAttribute("categoria")); %>">
                                <option value="" selected disabled><strong>Categoria</strong></option>
                                <option value="E-commerce"><strong>E-commerce</strong></option>
                                <option value="Loja Física"><strong>Loja Física</strong></option>
                             </select>
                        </div> 
                        <div class="form-floating mb-3">
                            <input type="text" name="nomeProduto" class="form-control" id="floatingText" placeholder="Nome..." required
                            value = "<%out.print(request.getAttribute("nomeProduto")); %>">
                            <label for="floatingText"><Strong>Nome Produto</Strong></label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="date" name="dataVenda" class="form-control" id="floatingInput" placeholder="nome@exemplo.com" required
                            value = "<%out.print(request.getAttribute("dataVenda")); %>">
                            <label for="floatingInput"><Strong>Data da Venda</Strong></label>
                        </div>
                        <div class="form-floating mb-3">
                             <input type="number" name="valor" class="form-control" id="floatingPassword" placeholder="Senha..." required
                             value = "<%out.print(request.getAttribute("valor")); %>">
                             <label for="floatingPassword"><Strong>Valor Unitário</Strong></label>
                        </div>
                        <div class="form-floating mb-3">
                             <input type="number" name="quantidade" class="form-control" id="floatingPassword" placeholder="Senha..." required
                             value = "<%out.print(request.getAttribute("quantidade")); %>">
                             <label for="floatingPassword"><Strong>Quantidade</Strong></label>
                        </div>
                        <div class="form-floating mb-3">
                             <input type="text" name="nomeVendedor" class="form-control" id="floatingPassword" placeholder="Senha..." required
                             value = "<%out.print(request.getAttribute("nomeVendedor")); %>">
                             <label for="floatingPassword"><Strong>Nome Vendedor</Strong></label>
                        </div>
                        
                        <input type="button" class="btn btn-primary py-3 w-100 mb-4" value="Cadastrar" onclick="validarVenda()">
                    </form>
                </div>
            </div>
            <!-- Form End -->
        </div> 
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="scripts/validarVenda.js"></script>
    <script src="resources/js/main.js"></script>
</body>
</html>