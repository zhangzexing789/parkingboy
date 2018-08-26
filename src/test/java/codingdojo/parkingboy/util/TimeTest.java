package codingdojo.parkingboy.util;

import codingdojo.parkingboy.exceotion.BelowZeroException;
import codingdojo.parkingboy.exceotion.NotNatural;
import codingdojo.parkingboy.util.TimeConduct;
import org.junit.Assert;
import org.junit.Test;

public class TimeTest {
//    小于0 throw excption
    @Test(expected = BelowZeroException.class)
    public void should_throw_not_be_zero_exception_when_given_time_is_below_zero(){
        //given
        TimeConduct timeConduct = new TimeConduct();
        String num = "-1";
        //when
        timeConduct.calculate(num);
    }
//    不是自然数 exception
    @Test(expected = NotNatural.class)
    public void should_throw_not_a_natural_exception_when_given_time_is_not_a_natural(){
        //given
        TimeConduct timeConduct = new TimeConduct();
        String num = "r";

        //when
        timeConduct.calculate(num);
    }

//1 out 1 second
    @Test
    public void should_return_one_second_when_given_time_1(){
        //given
        TimeConduct timeConduct = new TimeConduct();
        String num = "1";

        //when
        String result = timeConduct.calculate(num);

        //then
        Assert.assertEquals("1 second",result);
    }
//2 out 2 seconds
    @Test
    public void should_return_two_second_when_given_time_2(){
        //given
        TimeConduct timeConduct = new TimeConduct();
        String num = "2";

        //when
        String result = timeConduct.calculate(num);

        //then
        Assert.assertEquals("2 seconds",result);
    }
//60 out 1 min
    @Test
    public void should_return_one_min_when_given_time_60(){
        //given
        TimeConduct timeConduct = new TimeConduct();
        String num = "60";

        //when
        String result = timeConduct.calculate(num);

        //then
        Assert.assertEquals("1 min",result);
    }
//61 out 1 min, 1 second
    @Test
    public void should_return_1_min_1_second_when_given_time_61(){
        //given
        TimeConduct timeConduct = new TimeConduct();
        String num = "61";

        //when
        String result = timeConduct.calculate(num);

        //then
        Assert.assertEquals("1 min, 1 second",result);
    }
//62 out 1 min, 2 seconds
//120 out 2 mins
//121 out 2 mins, 1 second
//122 out 2 mins, 2 seconds
//3600 out 1 hour
//3660 out 1 hour, 1 min
//3661 out 1 hour, 1 min, 1 second
//3662 out 1 hour, 1 min, 2 seconds
//3720 out 1 hour, 2 mins
//3721 out 1 hour, 2 mins, 1 second
//3722 out 1 hour, 2 mins, 2 seconds
//7200 0ut 2 hours
}
