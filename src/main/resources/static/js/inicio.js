/**
 * 
 */
var productos=[]
var ultima;
$(document).ready(function(){
	getProductos();
	
	if(JSON.parse(sessionStorage.getItem("compras")).length > 0 ){
		$("#comprar").show();
	}
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
		sessionStorage.setItem("compras",JSON.stringify(productos))
		location.reload()
	}else{
		
		alert("ya agrego este producto")
	}	
}

function newProduct(){
	var producto={
			idProducto : $("#codigoPrin").val(),
			nombre : $("#nombre").val(),
			precio : $("#precio").val()
	}
	console.log(JSON.stringify(producto))
	$.ajax({
		url : "/product/saveProduct",
		type: "POST",
		data: JSON.stringify(producto),
		contentType: "application/json",
		success: function(){
			alert("Producto Creado")
			$("#codigoPrin").val("")
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
			idProducto : parseInt($("#codigoA").val()),
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

function verfinalizarCompra(){
	var productComp = JSON.parse(sessionStorage.getItem("compras"));
	$("#modalComprar").show();
	$("#productosComp").empty();
	for(i in productComp){
		$("#productosComp").append(
				'<div class="card col m-1 text-center" style="width: 15rem;">'+
					'<div class="card-body">'+
					'<h5 class="card-title">' + productComp[i].nombre +'</h5>'+
					'<p class="card-text">Codigo:' + productComp[i].idProducto +'</p>'+
					'<p class="card-text">Precio: $ ' + productComp[i].precio + '</p>'+
					'</div>'+
			  	'</div>'
			)
	}
}

function cerrarfinaliarComp(){
	$("#modalComprar").hide();
}

function comprar(){
	var fecha = new Date()
	var jwt = parseJwt (sessionStorage.getItem("token"));
	
	var venta={
			id_cliente : jwt.sub,
			fecha : fecha
	}
	$.ajax({
		url:"/venta/saveVenta",
		type:"POST",
		data: JSON.stringify(venta),
		contentType: "application/json",
		success: function(resp){
			consultVentas(jwt.sub)						
		},error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("No se pudo realizar la compra"); 
        }
	})	
}


function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};


function consultVentas (idclient){
	$.ajax({
		url:"/venta/"+idclient,
		type:"GET",
		success: function(resp){
			ultima = resp[resp.length-1];
			saveDetalle();
		},error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("No se pudo realizar la venta"); 
        }
	})	
}

function saveDetalle(){
	var productComp = JSON.parse(sessionStorage.getItem("compras"));
	for (i in productComp){
		var detalle={
				id_producto: productComp[i].idProducto,
				id_venta: ultima.id_venta
		}
		$.ajax({
			url:"/detalle/saveDetalle",
			data: JSON.stringify(detalle),
			type:"POST",
			contentType: "application/json",
			success: function(){
				console.log("agregando...")
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { 
	            alert("No se pudo realizar la compra"); 
	        }
		})
	}
	alert("¡Felicitaciones compra finalizada!")
	sessionStorage.setItem("compras","[]")
	location.reload()
}