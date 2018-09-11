package codingdojo.parkingboy.spring.auto_bean;

import codingdojo.parkingboy.spring.interfact.CompactDisc;
import codingdojo.parkingboy.spring.interfact.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play() ;
    }
}
