package codingdojo.parkingboy.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static codingdojo.parkingboy.util.PrimeFactor.generate;
import static org.junit.Assert.assertEquals;

public class PrimeFactorsTest {
    private List<Integer> list(int...ints) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : ints)
            list.add(i);
        return list;
    }

    @Test
    public void test1(){
        assertEquals(list(),generate(1));
    }

    @Test
    public void test2(){
        assertEquals(list(2),generate(2));
    }

    @Test
    public void test3(){
        assertEquals(list(3),generate(3));
    }
    @Test
    public void test4(){
        assertEquals(list(2,2),generate(4));
    }

    @Test
    public void test5(){
        assertEquals(list(2,3),generate(6));
    }
    @Test
    public void test6(){
        assertEquals(list(2,2,2),generate(8));
    }

    @Test
    public void  test7(){
        assertEquals(list(3,3),generate(9));
    }
}
