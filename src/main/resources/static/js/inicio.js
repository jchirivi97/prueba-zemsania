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
						'<div class="card col m-1 text-center" style="width: 15rem;">'+
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

function verCrear(){
	$("#crear").show();
	$("#actualizar").hide();
	$("#eliminar").hide();
}

function verActualizar(){
	$("#crear").hide();
	$("#actualizar").show();
	$("#eliminar").hide();
}

function verEliminar(){
	$("#crear").hide();
	$("#actualizar").hide();
	$("#eliminar").show();
}

function updateProducto(){
	var producto={
			idProducto : $("#codigoA").val(),
			nombre : $("#nombreA").val(),
			precio : $("#precioA").val()
	}
	$.ajax({
		url: "/product/updateProduct",
		type: "PUT",
		data: JSON.stringify(producto),
		contentType: "application/json",
		success: function(){
			alert("Producto Actualizado")
			$("#codigoA").val("")
			$("#nombreA").val("")
			$("#precioA").val("")
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("Producto no existe"); 
        }
	})
}

function consultProducto(){
	$.ajax({
		url : "/product/" + $("#idActBusc").val(),
		type: "GET",
		success: function(resp){
			$("#codigoA").val(resp.idProducto)
			$("#nombreA").val(resp.nombre)
			$("#precioA").val(resp.precio)
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("Producto no existe"); 
        }
	})
}

function deleteProducto(){
	$.ajax({
		url: "/product/delete/"+$("#idProdDel").val(),
		type: "DELETE",
		success: function(){
			alert("Producto Eliminado")
			$("#idProdDel").val("")
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("Producto no existe"); 
        }
	})
}