package gestion_de_super;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List <ItemCarrito> itemsCarrito = new ArrayList<ItemCarrito>();
	//Si se van a aplicar varios descuentos conviene guardarlos en una ArrayList
	private List <Descuento> descuentos = new ArrayList<Descuento>();
	
	//Constructor: ahora acepta un ArrayList de ItemCarrito
	public Carrito(List<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}
	
	//Devuelve un ArrayList de ItemCarrito
	public List<ItemCarrito> getItemsCarrito() {
		return this.itemsCarrito;
	}
	
	//Devuelve la cantidad de items que hay en el carrito (realmente hace falta?)
	public int getCantItems(){
		return this.itemsCarrito.size();
	}
	
	//Agrega instancias de Descuento a la ArrayList (setter)
	public void agregarDescuento(Descuento descuento) {
		descuentos.add(descuento);
	}
	
	//Devuelve la ArrayList de descuentos
	public List<Descuento> getDescuentos(){
		return this.descuentos;
	}
	
	//Calcula el total sin descuentos
	public float precioSinDto() {
		float total =0;
		for(ItemCarrito articulo:itemsCarrito) {
			total = total + articulo.getSubtotal();
		}
		return total;
	}
	
	public float precio(Descuento descuento) {
		//Deberia agregar aquí las instancias de descuento a la ArrayList?
		float precioFinal = 0;
		agregarDescuento(descuento);
		
		try {
			
			precioFinal = descuento.precioFinal(precioSinDto());
		}
		catch(CarritoPrecioCeroException e) {
			System.out.println("Algo salió mal " + e);
		}
		catch(DescuentoNegativoException e) {
			System.out.println("Algo salió mal " + e);
		}
		return precioFinal;
	}
	 
	public void imprimirTicketCarrito() {
		System.out.println("***********************************************");
		System.out.println("***SUPERMERCADO DE DESCUENTO TODOS CONTENTOS***");
		System.out.println("***********************************************");
		System.out.println("************ DETALLE DE SU COMPRA *************");
		System.out.println("***********************************************");
		System.out.println("\n");
		//Impimir la lista de articulos comprados, su precio,cantidad y subtotal
		for(ItemCarrito articulo : itemsCarrito) {
			System.out.print("articulo: " + articulo.getNombreItem() 
			+"      precio unitario: $" + articulo.getPrecioUnitario() 
			+ "      cantidad: " + articulo.getCantidad() + "      subtotal: $" 
			+ articulo.getSubtotal()+ "\n") ;
		}
		System.out.println();
		System.out.println("		Total sin descuentos: $" + precioSinDto());
		for (Descuento dto : descuentos) {
			System.out.println("		Se aplica un descuento de: $" + dto.getValorDescuento());
			
		}
			
	}

}
