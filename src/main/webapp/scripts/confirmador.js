/**
 * 
 */

function confirmar(idVendas){
       let resposta = confirm("Confirma a exclusão dessa Venda ?")
       if (resposta === true){
               alert(idVendas)
       }
}