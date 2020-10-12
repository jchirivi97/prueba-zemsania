/**
 * 
 */

$(window).on("load",function(){
	
})


function ingreso(){
	$.ajax({
		url : '/client/'+$("#usuario").val()+'/'+$('#password').val(),
		type: 'GET',
		success: function(resp){
			sessionStorage.setItem('token',resp)
			location.href='/inicio.html'
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("El Usuario no existe"); 
        }
	})
	
}