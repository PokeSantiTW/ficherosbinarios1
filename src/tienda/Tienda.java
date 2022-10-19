package tienda;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tienda {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// -------------------------------
		// INICIO PROGRAMA
		System.out.println("---------- BIENVENIDO/A A PRIMARK ----------");
		String rutaBinario = pedirRuta() + "\\tienda.dat"; // A la ruta de la carpeta, que se ha pedido en el método pedirRuta(), se le añade 
														   // "tienda.dat". Será el archivo por defecto.
		
		
		ArrayList<Prenda> arrayPrenda = new ArrayList<>();
		
		if (comprobarArchivoTienda(rutaBinario)) {
			arrayPrenda = TiendaLeerDatos.arrayListInicial(rutaBinario); // Traerá todo el contenido de tienda.dat y lo añade al ArrayList.
		}
		
		// A partir de ahora, tenemos todo el contenido del .dat en el ArrayList "arrayPrenda". No hace falta trabajar directamente con el .dat.
		// Si trabajamos con el .dat, será para añadir contenido nuevo del ArrayList. Pero para leer, por ejemplo, leemos desde el ArrayList.
		
		int opciones = 0;
		
		// -------------------------------
		
		// OPCIONES DEL PROGRAMA PRINCIPAL			
		do
		{			
			try {
				
				int opcion = Integer.valueOf(JOptionPane.showInputDialog("Elige la opción\n\n"
						+ "1) Añadir nuevos productos a la tienda.\n"
						+ "2) Mostrar productos de la tienda.\n"
						+ "3) Terminar programa"));
				
				switch (opcion) {
				case 1:
					// Para guardar datos nuevos se pedirá añadir una nueva prenda, luego esa prenda se añade al ArrayList y una
					// vez hayas terminado de añadir prendas al ArrayList, todo el contenido del ArrayList se añade al fichero .dat.
					TiendaGuardarDatos.guardarDatos(arrayPrenda, rutaBinario);
					break;
				case 2:
					 // Ya que todo se está guardando en el ArrayList, leemos los datos desde ahí.
					TiendaLeerDatos.leerDatos(arrayPrenda);
					break;
				case 3:
					// Finaliza el programa
					opciones = 3;
					break;
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Se ha introduce un valor incorrecto, compruébalo e inténtalo de nuevo");
			}
		}while(opciones != 3);
		
		// Cuando sale del do/while, se acaba el programa.
		System.out.println("FIN DEL PROGRAMA");

	}
	
	private static String pedirRuta() {
		
		int opcion = 1;
		String pideRuta = "";
		
		do {
			pideRuta = JOptionPane.showInputDialog("Introduce la ruta del fichero binario de la tienda.");
			opcion = JOptionPane.showOptionDialog(null, "¿Estás seguro de que esta ruta es correcta? Sino, creará un nuevo fichero binario.\n\n" 
					+ pideRuta + "\\tienda.dat", "Comprueba la ruta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
					null, new Object[]{"Sí, es correcto", "No, quiero cambiarlo"}, 1);
			
		}while(opcion == 1);
		
		// Cuando sale del do/while, significa que el usuario ha introducido la ruta deseada, y devuelve esa ruta.
		return pideRuta;
		
	}
	
	private static boolean comprobarArchivoTienda(String ruta) throws IOException {
		
		File f = new File(ruta);
		
		if (f.exists()) {
			System.out.println("Se ha encontrado un archivo tienda.dat, se ha leído correctamente.\n\n");
			return true;
		} else {
			f.createNewFile();
			System.out.println("No se ha encontrado un archivo tienda.dat, se ha creado uno nuevo.\n\n");
			return false;
		}
		
	}

}
