package codingdojo.parkingboy.spring.auto_bean;

import codingdojo.parkingboy.spring.auto_bean.CDPlayer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {CDPlayer.class})
public class CDPlayerConfig {

}
