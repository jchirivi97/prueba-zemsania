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

function saveClient(){
	if($("#password").val() == $("#password2").val()){
		var client={
			nombre: $("#nombre").val(),
			apellido: $("#apellido").val(),
			dni: $("#dni").val(),
			telefono: $("#telefono").val(),
			email: $("#email").val(),
			password: $("#password2").val(),
			idCliente: $("#codigo").val()	
		}
		$.ajax({
			url: "/client/saveClient",
			type: "POST",
			data: JSON.stringify(client),
			contentType: "application/json",
			success: function(){
				alert("El Usuario registrardo con exito");
				location.href="/"
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { 
	            alert("El Usuario no se pudo registrar"); 
	        }
		})
	}else{
		alert("Contraseñas no coinciden verifique")
	}
	
}

function salir(){
	sessionStorage.clear();
	location.href= "/";
}