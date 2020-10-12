/**
 * 
 */
var productos=[]
$(document).ready(function(){
	getProductos();
})

function getProductos(){
	$.ajax({
		url: "/product/allProductos",
		type:"GET",
		success: function(resp){
			if(resp.length == 0){
				$("#productos").append("<p class='text-center'>No hay productos disponibles</p>");
			}else{
				$("#productos").empty();
				for(i in resp){
					$("#productos").append(
						'<div class="card col m-1" style="width: 15rem;">'+
							'<div class="card-body">'+
							'<h5 class="card-title">' + resp[i].nombre +'</h5>'+
							'<p class="card-text">Codigo:' + resp[i].idProducto +'</p>'+
							'<p class="card-text">Precio: $ ' + resp[i].precio + '</p>'+
							'<button type="button" onclick="addProducto(\''+ resp[i].idProducto + '\'' + ',' + '\'' + resp[i].nombre + '\'' + ','+'\'' + resp[i].precio + '\')" class="btn btn-primary">Comprar</button>'+
							'</div>'+
					  	'</div>'
					)
				}
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("No hay productos"); 
        }
	})
}

function addProducto(idproducto,nombre,precio){
	var verificador = true;
	var producto = {
			idProducto : parseInt(idproducto),
			nombre : nombre,
			precio : parseInt(precio)
	}
	for(i in productos){
		if(productos[i].idProducto == producto.idProducto){
			verificador = false;
			break;
		}
	}
	if(verificador){
		productos.push(producto)
		alert("producto agregado")
	}else{
		
		alert("ya agrego este producto")
	}	
}

function newProduct(){
	var producto={
			idProducto : $("#codigo").val(),
			nombre : $("#nombre").val(),
			precio : $("#precio").val()
	}
	$.ajax({
		url : "/product/saveProduct",
		type: "POST",
		data: JSON.stringify(producto),
		contentType: "application/json",
		success: function(){
			alert("Producto Creado")
			$("#codigo").val("")
			$("#nombre").val("")
			$("#precio").val("")
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("Producto ya existe"); 
        }
	})
}