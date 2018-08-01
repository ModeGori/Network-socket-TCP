package com.MEGR.tcp;
import java.io.*;
import java.net.*;
public class Servidor {
	public static void main(String argv[]) {
        //Se declara el metodo principal main que espera un parametro

	System.out.println("SERVIDOR");
    ServerSocket socket;   //Se crea un objeto de ServerSocket
    boolean fin = false; //Se declara una variable booleana inicializada a false


  try {
	  //Abrimos una excepcion para el tratamiento de errores
      //Creamos un servidor 
	  socket = new ServerSocket(6837); //Abre un socket en modo escucha en el puerto 6004
      Socket socket_cli = socket.accept(); //Inicio. Se acepta la conexión.

     //Metodo de la clase socket para recibir datos
     DataInputStream in =
        new DataInputStream(socket_cli.getInputStream());

     //Metodo para mandar un valor al cliente
     DataOutputStream out =
         new DataOutputStream(socket_cli.getOutputStream());


     String mensaje =""; //Se inicializa la variable de string mensaje a vacio
     mensaje = in.readUTF(); //La variable Mensaje guarda el valor que ha mandado el cliente

     if (mensaje.startsWith("Holasa")) {
    	 out.writeUTF("Holasa");
     }

     do {

    	 //Estara escuchando el mensaje sin interrupcion debido a la condición (1>0) del while
        mensaje =""; //Se inicializa la variable de string mensaje a vacio
        mensaje = in.readUTF(); //La variable Mensaje guarda el valor que ha mandado el cliente

        if (mensaje.startsWith("ALL")) {

        	mensaje = "ALL BUR:250;CHE:300; BIG:540; PAT:380; SAL:240; BEV:210; DIE:0; COF:0; DES:300";
        	System.out.println(mensaje);

        }
        else if(mensaje.startsWith("BUR"))
        {
        	mensaje = "BUR 250";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("CHE")) {
        	mensaje = "CHE 300";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("BIG")) {
        	mensaje= "BIG 540";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("PAT")) {
        	mensaje= "PAT 380";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("SAL")) {
        	mensaje= "SAL 240";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("BEV")) {
        	mensaje= "SAL 210";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("DIE")) {
        	mensaje= "DIE 0";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("COF")) {
        	mensaje= "COF 0";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("DES")) {
        	mensaje= "DES 300";
        	System.out.println(mensaje);
        }
        else if (mensaje.startsWith("fin")) {
        	mensaje= "fin";
    	    System.out.println(mensaje);
        }
        else{
            mensaje = "ERROR";	
        	System.out.println(mensaje);
        }

        //Mandamos al cliente la respuesta segun lo que ha mandado
            out.writeUTF(mensaje);
        System.out.println(mensaje); 

     } while (1>0);
  }
  catch (Exception e) {
	  //Si se produce algun error saltara la excepcion con el mensaje de error
     System.err.println(e.getMessage());
     System.exit(1); //Salimos con error
  		}
	}
}