/**
 * 
 */

function validarVenda() {
    let comprador = frmVenda.comprador.value
    let categoria = document.getElementById("nomeCategoria").value;
    let produto = frmVenda.nomeProduto.value
    let data = frmVenda.dataVenda.value
    let quantidade = frmVenda.quantidade.value
    let valor = frmVenda.valor.value
    let vendedor = frmVenda.nomeVendedor.value

    if (comprador === "") {
        alert("Preencha o campo Comprador.");
        frmVenda.comprador.focus();
        return false;
    } else if (categoria === "") {
        alert("Preencha o campo Categoria.");
        frmVenda.categoria.focus();
        return false;
    } else if (produto === "") {
        alert("Preencha o campo Produto.");
        frmVenda.produto.focus();
        return false;
    } else if (data === "") {
        alert("Preencha o campo Data.");
        frmVenda.data.focus();
        return false;
    } else if (quantidade === "") {
        alert("Preencha o campo Quantidade.");
        frmVenda.quantidade.focus();
        return false;
    } else if (valor === "") {
        alert("Preencha o campo Valor.");
        frmVenda.valor.focus();
        return false;
    } else if (vendedor === "") {
        alert("Preencha o campo Vendedor.");
        frmVenda.vendedor.focus();
        return false;
    } else {
        document.forms["frmVenda"].submit();
    }
}