package prueba.zemsania.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import prueba.zemsania.demo.security.JWTAuthorizationFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    	};
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(resources).permitAll()  
				.antMatchers("/").permitAll()
				.antMatchers("/inicio.html").permitAll()
				.antMatchers("/registrarProducto.html").permitAll()
				.antMatchers("/registrar.html").permitAll()
				.antMatchers("/ventas.html").permitAll()
				.antMatchers("/client").permitAll()
				.antMatchers("/client/allClients").permitAll()
				.antMatchers("/client/{id}").permitAll()
				.antMatchers("/client/{id}/{password}").permitAll()
				.antMatchers("/client/saveClient").permitAll()
				.antMatchers("/product").permitAll()
				.antMatchers("/product/{id}").permitAll()
				.antMatchers("/product/allProductos").permitAll()
				.antMatchers("/product/saveProduct").permitAll()
				.antMatchers("/product/updateProduct").permitAll()
				.antMatchers("/product/delete/{id}").permitAll()
				.antMatchers("/venta/{id}").permitAll()
				.antMatchers("/venta/saveVenta").permitAll()
				.antMatchers("/detalle/{idventa}").permitAll()
				.antMatchers("/detalle/saveDetalle").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/inicio.html").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/registrarProducto.html").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/registrar.html").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/ventas.html").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/client").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/client/allClients").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/client/{id}").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/client/{id}/{password}").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/client/saveClient").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/product").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/product/{id}").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/product/allProductos").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/product/saveProduct").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/product/updateProduct").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/product/delete/{id}").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/venta/{id}").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/venta/saveVenta").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/detalle/{idventa}").permitAll()
				.antMatchers("https://prueba-zemsania.herokuapp.com/detalle/saveDetalle").permitAll()
				.anyRequest().authenticated();
		}
	}

}
