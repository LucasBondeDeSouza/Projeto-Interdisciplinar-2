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

 
 function validarLogin() {
	 
	 let email = frmLogin.email.value
	 let senha = frmLogin.senha.value
	 
	 if (email === "") {
		 alert("Preencha o campo Email:")
		 frmLogin.email.focus()
		 return false
	 } else if (senha === "") {
		 alert("Preencha o campo Senha:")
		 frmLogin.senha.focus()
		 return false
	 } else {
		 document.forms["frmLogin"].submit()
	 }
 }