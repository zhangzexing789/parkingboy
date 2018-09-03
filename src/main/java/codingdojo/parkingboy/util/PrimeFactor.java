package codingdojo.parkingboy.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Integer> generate(int n) {
        List<Integer> primes = new ArrayList<Integer>();

        for(int candicate = 2;n>1;candicate ++){
            for (;n % candicate == 0;n/=candicate) {
                primes.add(candicate);
            }
        }
        return primes;
     }
}
