package tienda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.*;

public class TiendaGuardarDatos {
	
	public static void guardarDatos(ArrayList<Prenda> arrayPrenda, String ruta) throws FileNotFoundException, IOException {
		
		int terminado = 0;
		
		do {
			
			String tipo = JOptionPane.showInputDialog("Introduce el tipo de prenda a añadir:");
			String talla = JOptionPane.showInputDialog("Introduce la talla de " + tipo);
			double precio = Double.valueOf(JOptionPane.showInputDialog("Introduce el precio de " + tipo));
			String color = JOptionPane.showInputDialog("Introduce el color de " + tipo);
			
			arrayPrenda.add(new Prenda(tipo, talla, precio, color, true));
			
			int opcion = JOptionPane.showOptionDialog(null, "¿Deseas añadir una prenda más?", "Añadir otra prenda", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Quiero añadir otra prenda", "No quiero añadir más prendas"}, 1);
			if (opcion == 1) {
				terminado = 1;
			}
			
		}while(terminado == 0);
		
		FileOutputStream fos = new FileOutputStream(ruta);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// Es necesario saber que cuando añades algo nuevo al .dat se borra todo lo anterior. Por eso usamos el ArrayList para guardar y leer todo.
		// Cuando metamos nueva información al .dat, añadimos todo el contenido del ArrayList al .dat recorriéndolo con un for each.
		for (Prenda p : arrayPrenda) {
			oos.writeObject(p);
		}
		
		fos.close();
		oos.close();
		
	}

}
