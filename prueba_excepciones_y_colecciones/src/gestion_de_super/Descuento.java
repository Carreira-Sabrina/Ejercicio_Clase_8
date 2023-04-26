package gestion_de_super;

//ESTA CLASE DEBE MANEJAR EXCEPCIONES QUE EVITEN CARRITOS DE PRECIO CERO,
//RESULTADOS DE DESCUENTO DE PRECIO NEGATIVO Y MOSTRAR EL ERROR EN VEZ DEL PRECIO
//DEL CARRITO

public abstract class Descuento {
private float valorDescuento;
	
	public void setValorDescuento(float valor) {
		this.valorDescuento = valor;
	}
	
	public float getValorDescuento() {
		return this.valorDescuento;
	}
	
	//Metodo abstracto para sobre-escribir
	public abstract float precioFinal(float precioSinDescuento) throws CarritoPrecioCeroException,DescuentoNegativoException;
	
	//Metodo abstracto para sobre-escribir: devuelve el tipo de descuento(fijo, porcentaje)
	public abstract String getTipoDto();

}
