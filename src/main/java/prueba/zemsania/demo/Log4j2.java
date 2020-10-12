package prueba.zemsania.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;

public class Log4j2 {
	
	private static final Logger logger = LogManager.getLogger(Log4j2.class);
	
	public Log4j2(){
		
	}
	public void logger(int estado,int idCliente) throws Exception {
		java.util.Date fecha = new Date();
		 String ruta = "src/main/resources/log.txt";
		 String contenido;
		 File file = new File(ruta);
         // Si el archivo no existe es creado
         if (!file.exists()) {
             file.createNewFile();
         }
    
        //valida el tipo de Log
		if(estado == 1){
			contenido = "\nFecha: " + String.valueOf(fecha) + " Usuario: "+ String.valueOf(idCliente)+ "error";
		}else if( estado == 2){
			contenido = "\nFecha: " + String.valueOf(fecha) + " Usuario: "+ String.valueOf(idCliente)+ " debug : Logueo Exitoso" ;
		}else{
			contenido = "\nFecha: " + String.valueOf(fecha) + " Usuario: "+ String.valueOf(idCliente)+ " info : datos incorrectos en el logueo" ;
		}
		
		FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();
        
        
    }
}
