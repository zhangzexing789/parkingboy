package codingdojo.parkingboy.springOther;

import codingdojo.parkingboy.spring.interfact.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class OtherSgtPepper implements CompactDisc {
    public void play() {
        System.out.println("otherSgtPepper");
    }
}
