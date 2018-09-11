package codingdojo.parkingboy.spring.xml_bean;

import codingdojo.parkingboy.spring.interfact.CompactDisc;
import codingdojo.parkingboy.spring.interfact.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;

public class HDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
