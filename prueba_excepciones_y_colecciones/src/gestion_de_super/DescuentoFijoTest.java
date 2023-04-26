package gestion_de_super;

import static org.junit.Assert.*;

import org.junit.Test;

public class DescuentoFijoTest {

	@Test
	public void test() {
		Descuento dto1 = new DescuentoFijo();
		dto1.setValorDescuento(50);
		
		float resultado = 0;
		
		try {
			//Para la prueba se asume un precio sin descuento de $300
			//precioFinal(precioSinDescuento)
			resultado = dto1.precioFinal(5); //era 300
			assertTrue(resultado>0);
		} catch (CarritoPrecioCeroException | DescuentoNegativoException e) {
			System.out.println("Algo salio mal en el test " + e);
			fail("El test ha fallado");
		}
	}

}
