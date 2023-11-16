package evaluacion_de_algoritmo_tema2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class evaluacion_de_algoritmo_tema2 {

	
	static String[] nombre = new String[3];
	static String[] apellido = new String[3];
	static int[] numero_camisa = new int[3];
	static String[] suplente = new String[2];
	static int [] n_suplente= new int[2];
	static boolean salirAgregar = true;
	static boolean rtscorrec = true;
	static boolean coreccrts = true;
	static boolean pasar= true;

	public static void ingresedatos() {
		Scanner datos = new Scanner(System.in);

		for (int i = 0; i < nombre.length; i++) {
		
			
			System.out.println("ingrese el nombre del jugador:" + (i + 1));
			nombre[i] = datos.next();
			System.out.println("ingrese el apellido del jugador:" + (i + 1));
			apellido[i] = datos.next();
			
			System.out.println("ingrese el numero de camiseta del jugador:" + (i + 1));
			numero_camisa[i] = datos.nextInt();
			System.out.println("\n");
				
			
		}
	}
	
	
	
	

	public static void agregarjugador() {
		Scanner datos = new Scanner(System.in);
		String respuesta;
		String rest;

		do {
			System.out.println("deseea agregar los datos de un jugador suplente?");
			respuesta = datos.next();

			rest = respuesta.toLowerCase();

			if (rest.equals("si")) {

				System.out.println("ingrese el nombre del suplente");
				suplente[0] = datos.next();
				System.out.println("ingrese el apellido del suplente");
				suplente[1] = datos.next();
				System.out.println("ingrese la posicion del suplente");
				n_suplente[0] = datos.nextInt();
				System.out.println("ingrese el numero de camisa del suplente");
				n_suplente[1] = datos.nextInt();
				analizardatos4jugadores();
				salirAgregar=true;
			}

			else if (rest.equals("no")) {
				System.out.println("eligio no ingresar suplente");
				analizardatosjugadores();
				break;
			}

			else {
				System.out.println("eligio una respuesta incorrecta.vuelva a intentar");
				salirAgregar=false;
			}

		} while (salirAgregar==false);

	}
	
	
	
	

	public static void analizardatosjugadores() {
		Scanner datos = new Scanner(System.in);

		String resf;
		String ref;
		int n_c;
		String n_d;
  
		do {
		System.out.println("datos de los jugadores");

		for (int i = 0; i < nombre.length; i++) {
			System.out.println("nombre del jugador " + (i + 1) + ":" + nombre[i]);
			System.out.println("apellido del jugador " + (i + 1) + ":" + apellido[i]);
			System.out.println("numero de camisa del jugador " + (i + 1) + ":" + numero_camisa[i]);
			System.out.println("\n");
		}
		
		System.out.println("¿los datos ingresados son correctos?");
		resf = datos.next();

		ref = resf.toLowerCase();

		if (ref.equals("si")) {
			System.out.println("deacuerdo");
			rtscorrec= true;
		
			
			   try {

				   String ruta = "C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt";

			         File file = new File(ruta);


			         if (!file.exists()) {
			             file.createNewFile();
			         }

			  
			         FileWriter fw = new FileWriter(file);


			         BufferedWriter bw = new BufferedWriter(fw);

		
			         for (int i = 0; i < 3; i++) {
			    
			             bw.write("Nombre"+(i+1)+ ":" + nombre[i] + ", Apellido "+(i+1)+": " + apellido[i] + ",numero de camisa"+(i+1)+": " + numero_camisa[i]);


			             bw.newLine();
			         }

			         bw.close();

			     
			         System.out.println("Archivo creado con éxito.");
			     } catch (Exception e) {
			
			         e.printStackTrace();
			     }


			     try {
			
			         FileReader archivo = new FileReader("C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt");
			         BufferedReader lector = new BufferedReader(archivo);

			         String linea;

			         while ((linea = lector.readLine()) != null) {

			             System.out.println(linea);
			         }

			         lector.close();
			     } catch (IOException e) {
			 
			         e.printStackTrace();
			     }
			
			
		}

		else if (ref.equals("no")) {
	        rtscorrec= true;
			System.out.println("que numero de camisea desea modificar");
			n_c = datos.nextInt();
			

			for (int l = 0; l < numero_camisa.length; l++) {

				if (n_c == numero_camisa[l]) {
					System.out.println("modifique el numero de camisa del jugador" + (l + 1));
					numero_camisa[l] = datos.nextInt();
					System.out.println("modifique el nombre del jugador" + (l + 1));
					nombre[l] = datos.next();
					System.out.println("modifique el apellido del jugador" + (l + 1));
					apellido[l] = datos.next();
					System.out.println("\n");
				}
				
				
				
				
				if (n_c != numero_camisa[l]) {
					System.out.println("ese valor no exite. vuelva a intenar");
					rtscorrec=false;
				}
			}
			

			for (int i = 0; i < nombre.length; i++) {

				System.out.println("nombre del jugador " + (i + 1) + ":" + nombre[i]);
				System.out.println("apellido del jugador " + (i + 1) + ":" + apellido[i]);
				System.out.println("numero de camisa del jugador " + (i + 1) + ":" + numero_camisa[i]);
				System.out.println("\n");
			}

			
			
			   try {

				   String ruta = "C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt";

			         File file = new File(ruta);


			         if (!file.exists()) {
			             file.createNewFile();
			         }

			  
			         FileWriter fw = new FileWriter(file);


			         BufferedWriter bw = new BufferedWriter(fw);

		
			         for (int i = 0; i < 3; i++) {
			    
			             bw.write("Nombre"+(i+1)+ ":" + nombre[i] + ", Apellido "+(i+1)+": " + apellido[i] + ",numero de camisa"+(i+1)+": " + numero_camisa[i]);


			             bw.newLine();
			         }

			         bw.close();

			     
			         System.out.println("Archivo creado con éxito.");
			     } catch (Exception e) {
			
			         e.printStackTrace();
			     }


			     try {
			
			         FileReader archivo = new FileReader("C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt");
			         BufferedReader lector = new BufferedReader(archivo);

			         String linea;

			         while ((linea = lector.readLine()) != null) {

			             System.out.println(linea);
			         }

			         lector.close();
			     } catch (IOException e) {
			 
			         e.printStackTrace();
			     }
			
			
			System.out.println("si los datos mostrados son incorrectos.volver a iniciar el programa ");
			break;
		}
		
		
		else {
			System.out.println("eligio una opcion incorrecta.vuelva a intentar");
			rtscorrec=false;
		}

		}while(rtscorrec==false);
		
		     
	}
	
	
	
	
	
	
	public static void analizardatos4jugadores() {
		Scanner datos = new Scanner(System.in);


		String resf;
		String ref;
		int n_c;
		String n_d;
  
		do {
		System.out.println("datos de los jugadores");

		for (int i = 0; i < nombre.length; i++) {
			System.out.println("nombre del jugador " + (i + 1) + ":" + nombre[i]);
			System.out.println("apellido del jugador " + (i + 1) + ":" + apellido[i]);
			System.out.println("numero de camisa del jugador " + (i + 1) + ":" + numero_camisa[i]);
			System.out.println("\n");
		}
	
			System.out.println("nombre del suplenete:" + suplente[0]);
			System.out.println("apellido del suplente:" + suplente[1]);	
			System.out.println("posicion del suplente:" + n_suplente[0]);	
			System.out.println("numero de camiseta del suplenete:" + n_suplente[1]);	
		
		
		System.out.println("¿los datos ingresados son correctos?");
		resf = datos.next();

		ref = resf.toLowerCase();

		if (ref.equals("si")) {
			System.out.println("deacuerdo");
			coreccrts= true;
			
			
			   try {

				   String ruta = "C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt";

			         File file = new File(ruta);


			         if (!file.exists()) {
			             file.createNewFile();
			         }

			  
			         FileWriter fw = new FileWriter(file);


			         BufferedWriter bw = new BufferedWriter(fw);

		
			         for (int i = 0; i < 3; i++) {
			    
			             bw.write("Nombre"+(i+1)+ ":" + nombre[i] + ", Apellido "+(i+1)+": " + apellido[i] + ",numero de camisa"+(i+1)+": " + numero_camisa[i]);


			             bw.newLine();
			         }
			         
			         bw.write("nombre del suplente:"+suplente[0] + ", apellido del suplente:"+suplente[1] +", posicion del suplente:"+n_suplente[0] +", numero de camisa del suplente:"+ n_suplente[1]);

			         bw.close();

			     
			         System.out.println("Archivo creado con éxito.");
			     } catch (Exception e) {
			
			         e.printStackTrace();
			     }


			     try {
			
			         FileReader archivo = new FileReader("C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt");
			         BufferedReader lector = new BufferedReader(archivo);

			         String linea;

			         while ((linea = lector.readLine()) != null) {

			             System.out.println(linea);
			         }

			         lector.close();
			     } catch (IOException e) {
			 
			         e.printStackTrace();
			     }
		}

		else if (ref.equals("no")) {
	        coreccrts= true;
			System.out.println("que numero de camisa desea moidificar");
			n_c = datos.nextInt();
			
	
			for (int l = 0; l < numero_camisa.length; l++) {

				if (n_c == numero_camisa[l]) {
					System.out.println("modifique el numero de camisa del jugador" + (l + 1));
					numero_camisa[l] = datos.nextInt();
					System.out.println("modifique el nombre del jugador" + (l + 1));
					nombre[l] = datos.next();
					System.out.println("modifique el apellido del jugador" + (l + 1));
					apellido[l] = datos.next();				
				}
				if (n_c != numero_camisa[l]) {
					System.out.println("ese valor no exite. vuelva a intenar");
					coreccrts=false;
					break;
				}
				
			}
			
			  if(n_c == n_suplente[1]) {
					System.out.println("modifique el numero de camisa del suplente");
					n_suplente[1] = datos.nextInt();
					System.out.println("modifique el nombre del suplente");
					suplente[0] = datos.next();
					System.out.println("modifique el apellido del suplente");
					suplente[1] = datos.next();
					System.out.println("modifique la posicion del suplente");
					n_suplente[0] = datos.nextInt();
                   pasar=true;
				  }
               if(n_c != n_suplente[1]) {
            	   System.out.println("ese valor no existe.vuelve a intenar");
            	   coreccrts=false;
               }
			  
			 if(pasar=true) {
			for (int i = 0; i < nombre.length; i++) {

				System.out.println("nombre del jugador " + (i + 1) + ":" + nombre[i]);
				System.out.println("apellido del jugador " + (i + 1) + ":" + apellido[i]);
				System.out.println("numero de camisa del jugador " + (i + 1) + ":" + numero_camisa[i]);
				System.out.println("\n");
			}
			System.out.println("nombre del suplente:"+suplente[0]);
			System.out.println("apellido del suplente:"+suplente[1]);
			System.out.println("posicion del suplente:"+n_suplente[0]);
			System.out.println("numero de camisa del suplente:"+n_suplente[1]);

			 }
			 

			   try {

				   String ruta = "C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt";

			         File file = new File(ruta);


			         if (!file.exists()) {
			             file.createNewFile();
			         }

			  
			         FileWriter fw = new FileWriter(file);


			         BufferedWriter bw = new BufferedWriter(fw);

		
			         for (int i = 0; i < 3; i++) {
			    
			             bw.write("Nombre"+(i+1)+ ":" + nombre[i] + ", Apellido "+(i+1)+": " + apellido[i] + ",numero de camisa"+(i+1)+": " + numero_camisa[i]);


			             bw.newLine();
			         }
			         
			         bw.write("nombre del suplente:"+suplente[0] + ", apellido del suplente:"+suplente[1] +", posicion del suplente:"+n_suplente[0] +", numero de camisa del suplente:"+ n_suplente[1]);

			         bw.close();

			     
			         System.out.println("Archivo creado con éxito.");
			     } catch (Exception e) {
			
			         e.printStackTrace();
			     }


			     try {
			
			         FileReader archivo = new FileReader("C:\\Users\\Alumno\\Documents\\listajugadores\\archivo_jugadores.txt");
			         BufferedReader lector = new BufferedReader(archivo);

			         String linea;

			         while ((linea = lector.readLine()) != null) {

			             System.out.println(linea);
			         }

			         lector.close();
			     } catch (IOException e) {
			 
			         e.printStackTrace();
			     }
			 
			 
			System.out.println("si los datos mostrados son incorrectos.volver a iniciar el programa ");
            break;
			 
		}
		
		
		
		else {
			System.out.println("eligio una opcion incorrecta.vuelva a intentar");
			coreccrts=false;
		}

		}while(coreccrts==false);
		
	}
	
	
	
	

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
       try {
		ingresedatos();
		agregarjugador();
       }catch(InputMismatchException e) {
    	   System.out.println("error.dato no valido");
       }
		
	
		

	}

	
}
