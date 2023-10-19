/**
 * 
 */

 function validarVenda() {
    let comprador = frmVenda.comprador.value;
    let categoria = document.getElementById("nomeCategoria").value;
    let nome = frmVenda.nomeProduto.value;
    let data = frmVenda.dataVenda.value;
    let quantidade = frmVenda.quantidade.value;
    let valor = frmVenda.valorUnitario.value;
    let mensagemErro = "";

    if (comprador === "") {
        mensagemErro = "Preencha o campo Comprador";
        frmVenda.comprador.focus();
    } else if (categoria === "") {
        mensagemErro = "Preencha o campo Categoria";
    } else if (nome === "") {
        mensagemErro = "Preencha o campo Nome Produto";
        frmVenda.nomeProduto.focus();
    } else if (data === "") {
        mensagemErro = "Preencha o campo Data da Venda";
        frmVenda.dataVenda.focus();
    } else if (quantidade === "") {
        mensagemErro = "Preencha o campo Quantidade";
        frmVenda.quantidade.focus();
    } else if (valor === "") {
        mensagemErro = "Preencha o campo Valor do Produto";
        frmVenda.valorUnitario.focus();
    }

    if (mensagemErro !== "") {
        // Exibir mensagem de erro no formulário
        document.getElementById("mensagemErro").textContent = mensagemErro;
        return false;
    } else {
        // Envie o formulário
        document.forms["frmVenda"].submit();
    }
}
