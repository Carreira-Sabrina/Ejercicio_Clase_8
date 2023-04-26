package gestion_de_super;

import static org.junit.Assert.*;

import org.junit.Test;

public class DescuentoNegativoExceptionTest {

	@Test//(expected = DescuentoNegativoException.class)
	public void test() {
		
		float precioSinDto = 10;
		
		Descuento dtoTest = new DescuentoFijo();
		
		float valorDto = 15;
		
		dtoTest.setValorDescuento(valorDto);
		
		try {
			dtoTest.precioFinal(precioSinDto);
			
			
		} catch (DescuentoNegativoException | CarritoPrecioCeroException e) {
			System.out.println("Algo salio mal en el test " + e);
			fail("El test ha fallado");
			
		}
	}

}
