/**
 * 
 */

function validarCadastro() {
    let nome = frmCadastro.nome.value
    let email = frmCadastro.email.value
    let senha = frmCadastro.senha.value

    if (nome === "") {
        alert("Preencha o campo Nome.");
        frmCadastro.nome.focus();
        return false;
    } else if (email === "") {
        alert("Preencha o campo Email.");
        frmCadastro.email.focus();
        return false;
    } else if (senha === "") {
        alert("Preencha o campo Senha.");
        frmCadastro.senha.focus();
        return false;
    } else {
        document.forms["frmCadastro"].submit();
    }
}