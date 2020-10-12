package prueba.zemsania.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import prueba.zemsania.demo.Log4j2;
import prueba.zemsania.demo.model.cliente;
import prueba.zemsania.demo.service.clienteService;

@RestController
@RequestMapping(value="/client")
public class clienteController {
	
	@Autowired
	clienteService clientService;
	
	//consulta un cliente
	@RequestMapping(method=RequestMethod.GET,path="/{id}")
	public ResponseEntity<cliente> getClient(@PathVariable("id") int idCliente){
		try{
			return ResponseEntity.ok(clientService.getClient(idCliente));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	//Ingreso del usuario retornado un token de seguridad
	@RequestMapping(method=RequestMethod.GET,path="/{id}/{password}")
	public ResponseEntity<String> getLoginClient(@PathVariable("id") int idClient, @PathVariable("password") String password){
		Log4j2 log = new Log4j2();
		try{
			cliente clientResp = clientService.loginClient(idClient, password);
			if(clientResp.getPassword().equals(password)){
				log.logger(2, idClient);
			}
			return ResponseEntity.ok(this.getJWTToken(clientResp.getIdCliente()));
		}catch(Exception e){
			try {
				log.logger(3, idClient);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Retona todos los usuarios registrados
	@RequestMapping(method=RequestMethod.GET,path="/allClients")
	public ResponseEntity<List<cliente>> getAllClient(){
		try{
			return ResponseEntity.ok(clientService.allClients());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//alamcena un cliente nuevo
	@RequestMapping(method=RequestMethod.POST,path="/saveClient")
	public void saveClient(@RequestBody cliente client){
		try{
			clientService.saveClient(client);
		}catch(Exception e){
			System.out.println("entro por error");
			ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	/*
	 * metodo que genera el token de seguridad con el usuario
	 */
	private String getJWTToken(int username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(String.valueOf(username))
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		return token;
	}
}
