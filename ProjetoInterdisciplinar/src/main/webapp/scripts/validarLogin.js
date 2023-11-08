/**
 * 
 */

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