package codingdojo.parkingboy.spring.auto_bean;

import codingdojo.parkingboy.spring.interfact.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

    public void play() {
        System.out.println("SgtPeppers");
    }
}
