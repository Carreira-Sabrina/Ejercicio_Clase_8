package gestion_de_super;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	public static void main(String[] args) {
		//El archivo a leer
		Path rutaArchivoListaCompras =Paths.get("listaDeCompras1.csv");
		//Se crea un ArrayList con las lineas que se lean del archivo
		List <String> listaArchivo;
		//Esta es la lista de ItemCarrito que se pasará al constructor de Carrito
		List <ItemCarrito> ordenDeCompra = new ArrayList<ItemCarrito>();
		
		try {
			listaArchivo = Files.readAllLines(rutaArchivoListaCompras);
			//Se itera por la lista de lineas obtenidas en el archivo
			//La primera lista se descarta porque es la cabecera de la tabla
			for(int i=1;i<listaArchivo.size(); i++) {
				//Cada linea se convierte en una array que se usará para
				//obtener datos para instanciar objetos
				String lineaAArray [] = listaArchivo.get(i).split(",");
				String nombreProducto = lineaAArray[0];
				float precioProducto = Float.parseFloat(lineaAArray[1]);
				int cantItem = Integer.parseInt(lineaAArray[2]);
				//Primero se crea la instancia de producto
				Producto tempProducto = new Producto(nombreProducto,precioProducto);
				//Ahora se crea la instancia de ItemCarrito
				ItemCarrito tempItem = new ItemCarrito(tempProducto,cantItem);
				ordenDeCompra.add(tempItem);	
			}//end of for
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end of catch
		
		
		//Con ordenDeCompra, ya se puede crear la instancia de Carrito
		Carrito carrito = new Carrito(ordenDeCompra);
		
		//Se aplica un descuento fijo de $100
		Descuento dto1 = new DescuentoFijo();
		dto1.setValorDescuento(100);
		
		//Se calcula el precio del carrito pasando el descuento
		float totalCompra = carrito.precio(dto1);
		
		carrito.imprimirTicketCarrito();
		
		System.out.println("		Total con descuentos: $" + totalCompra);

	}

}
