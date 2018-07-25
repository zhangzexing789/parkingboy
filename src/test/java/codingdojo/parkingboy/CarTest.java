package codingdojo.parkingboy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class CarTest {

	@Test
	public void should_be_return_true_with_same_car() {
		Car c1 = new Car("1");
		Car c2 = new Car("1");
		
		assertEquals(c1,c2);
		assertEquals(c1.hashCode(),c2.hashCode());
	}
	
	@Test
	public void should_be_return_false_with_diff_car() {
		Car c1 = new Car("1");
		Car c2 = new Car("2");

		assertNotSame(c1,c2);
		assertNotSame(c1.hashCode(),c2.hashCode());
	}
}
