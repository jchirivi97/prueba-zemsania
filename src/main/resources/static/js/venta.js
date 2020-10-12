/**
 * 
 */
$(document).ready(function(){
	getAllVentas();
})


function getAllVentas(){
	var jwt = parseJwt (sessionStorage.getItem("token"))
	$.ajax({
		url : "/venta/"+jwt.sub,
		type: "GET",
		success: function(resp){
			var column;
			for(i in resp){
				column = "<tr>"+
				"<td>"+resp[i].id_venta+"</td>"
				+"<td>"+resp[i].fecha+"</td>"
				+"<td>"+ '<button type="button" onclick="verDetalleCompra(\''+ resp[i].id_venta + '\')" class="btn btn-primary">Ver Detalle</button>'+"</td>"
				+"</tr>"
				$("#venta").append(column);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("No hay compras realizadas"); 
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


function verDetalleCompra(idventa){
	$("#detalle").show();
	$("#producto").empty();
	$.ajax({
		url : /detalle/+ idventa,
		type: "GET",
		success: function(resp){
			for(i in resp){
				var column;
				$.ajax({
					url: "/product/"+resp[i].id_producto,
					type: "GET",
					success: function(producto){
						column = "<tr>"+
						"<td>"+producto.idProducto+"</td>"
						+"<td>"+producto.nombre+"</td>"
						+"<td>"+producto.precio+"</td>"
						+"</tr>"
						$("#producto").append(column);
					}
				})
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("No hay compras realizadas"); 
        }
	})
}


function cerrar(){
	$("#detalle").hide();
	$("#producto").empty();
}