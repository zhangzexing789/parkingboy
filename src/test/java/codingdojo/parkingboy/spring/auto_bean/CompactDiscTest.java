package codingdojo.parkingboy.spring.auto_bean;


import codingdojo.parkingboy.spring.auto_bean.CDPlayerConfig;
import codingdojo.parkingboy.spring.interfact.CompactDisc;
import codingdojo.parkingboy.spring.interfact.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CompactDiscTest {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void beanTest(){
        System.out.println(compactDisc.getClass());
        assertNotNull(mediaPlayer);
        assertNotNull(compactDisc);
    }

    @Test
    public void beanTest2(){
        assertNotNull(mediaPlayer);
        mediaPlayer.play();
    }

}