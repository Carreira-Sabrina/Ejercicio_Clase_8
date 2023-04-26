package gestion_de_super;

public class ItemCarrito {
	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
		
	public int getCantidad() {
		return this.cantidad;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public float getPrecioUnitario() {
		return this.producto.getPrecio();
	}
	
	
	public float getSubtotal() {
		return this.cantidad * this.producto.getPrecio();
	}
	
	public String getNombreItem() {
		return this.producto.getNombre();
	}

}
