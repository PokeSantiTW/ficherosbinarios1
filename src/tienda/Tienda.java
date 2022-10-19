package tienda;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tienda {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// INICIO PROGRAMA
		System.out.println("---------- BIENVENIDO/A A PRIMARK ----------");
		String rutaBinario = pedirRuta() + "\\tienda.dat";
		
		
		ArrayList<Prenda> arrayPrenda = new ArrayList<>();
		
		if (comprobarArchivoTienda(rutaBinario)) {
			arrayPrenda = TiendaLeerDatos.arrayListInicial(rutaBinario);
		}
		
//		FileOutputStream fos = new FileOutputStream(rutaBinario);
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		FileInputStream fentrada = new FileInputStream(rutaBinario);
//		ObjectInputStream leerDatos = new ObjectInputStream(fentrada);
		
//		if (!ficheroBinario.exists()) {
//			System.out.println("El archivo de " + rutaBinario + " ha sido leído correctamente.");
//		} else {
//			ficheroBinario.createNewFile();
//			System.out.println("El archivo no existía, se ha creado uno nuevo en la ruta " + rutaBinario);
//		}
		
		int opciones = 0;
		
		// ----------------------
		// PRUEBA METER DATOS
		
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
					TiendaGuardarDatos.guardarDatos(arrayPrenda, rutaBinario);
					break;
				case 2:
					TiendaLeerDatos.leerDatos(arrayPrenda);
					break;
				case 3:
					opciones = 3;
					break;
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Se ha introduce un valor incorrecto, compruébalo e inténtalo de nuevo");
			}
		}while(opciones != 3);
		
		System.out.println("FIN DEL PROGRAMA");

	}
	
	private static String pedirRuta() {
		
		int opcion = 1;
		String pideRuta = "";
		
		do {
			pideRuta = JOptionPane.showInputDialog("Introduce la ruta del fichero binario de la tienda.");
			opcion = JOptionPane.showOptionDialog(null, "¿Estás seguro de que esta ruta es correcta? Sino, creará un nuevo fichero binario.\n\n" + pideRuta + "\\tienda.dat", "Comprueba la ruta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Sí, es correcto", "No, quiero cambiarlo"}, 1);
		}while(opcion == 1);
		
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
