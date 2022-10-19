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
		
		if (arrayPrenda.size() == 0) {
			JOptionPane.showMessageDialog(null, "El archivo está vacío, no se puede mostrar nada.");
			return;
		}
		
		for (Prenda p : arrayPrenda) {
			
			System.out.println("------ PRENDA " + contador + " ------");
			System.out.println("Tipo: " + p.getTipo());
			System.out.println("Talla: " + p.getTalla());
			System.out.println("---------------------");
			
			contador++;
			
		}
		
	}

}
