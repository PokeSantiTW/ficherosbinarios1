package tienda;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TiendaLeerDatos {
	
	public static ArrayList<Prenda> arrayListInicial(String ruta) throws IOException, ClassNotFoundException {
		
		ArrayList<Prenda> prenda = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream(ruta);
		ObjectInputStream ois = new ObjectInputStream(fis);
		int disponible = 1;
		
		// Mientras queden datos por leer en el .dat, "fis.available" será mayor que 0. Cuando no quede nada más por leer, será 0 y saldrá del while.
		// Se va a leer cada objeto disponible en .dat y se añadirá al ArrayList principal. Este método devuelve ese ArrayList y trabajaremos
		// a partir de ahora con el ArrayList.
		
		// Cuando volvamos a iniciar el programa, este método se ejecuta y lee todo el contenido del .dat para guardarlo en el ArrayList principal,
		// así no se pierde nada de información al trabajar con el .dat.
		while((disponible = fis.available()) > 0) {
			
			Prenda prendaLeida = (Prenda) ois.readObject();
			prenda.add(new Prenda(prendaLeida.getTipo(), prendaLeida.getTalla(), prendaLeida.getPrecio(), prendaLeida.getColor(), prendaLeida.isDisponible()));
			
		}
		
		fis.close();
		ois.close();
		
		return prenda;
		
	}
	
	public static void leerDatos(ArrayList<Prenda> arrayPrenda) {
		
		int contador = 1;
		
		// Ya que trabajamos con el ArrayList que tiene todas las prendas (objetos), no hace falta trabajar con el fichero .dat.
		// Leemos cada uno de los objetos del ArrayList.
		
		if (arrayPrenda.size() == 0) {
			JOptionPane.showMessageDialog(null, "El archivo está vacío, no se puede mostrar nada.");
			return;
		}
		
		for (Prenda p : arrayPrenda) {
			
			System.out.println("------ PRENDA " + contador + " ------");
			System.out.println("Tipo: " + p.getTipo());
			System.out.println("Talla: " + p.getTalla());
			System.out.println("Precio: " + p.getPrecio() + "€");
			System.out.println("Color: " + p.getColor());
			if (p.isDisponible()) {
				System.out.println("Disponible: Sí");
			} else {
				System.out.println("Disponible: No");
			}
			System.out.println("----------------------");
			
			contador++;
			
		}
		System.out.println("\n");
		
	}

}
