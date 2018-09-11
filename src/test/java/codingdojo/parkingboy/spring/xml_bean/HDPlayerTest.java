package codingdojo.parkingboy.spring.xml_bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/xml_bean/applicationContext.xml" )
public class HDPlayerTest {

    @Autowired
    private HDPlayer hdPlayer;

    @Test
    public void play() {
        assertNotNull(hdPlayer);
    }
}