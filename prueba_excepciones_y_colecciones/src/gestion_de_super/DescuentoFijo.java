package gestion_de_super;

public class DescuentoFijo extends Descuento {


	@Override
	public float precioFinal(float precioSinDescuento) throws CarritoPrecioCeroException,DescuentoNegativoException {
		float precioConDescuento = 0;
		if(precioSinDescuento!=0) {
			precioConDescuento = precioSinDescuento - this.getValorDescuento();
		}
		else {
			throw new CarritoPrecioCeroException("El valor del carrito es de $0 o menor");
		}
		if(precioConDescuento < 0) {
			throw new DescuentoNegativoException("Quedaria en valor negativo");
		}
		return precioConDescuento;
			
	}

	@Override
	public String getTipoDto() {
		return "FIJO";
	}

}
