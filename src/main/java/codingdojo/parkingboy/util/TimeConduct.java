package codingdojo.parkingboy.util;

import codingdojo.parkingboy.exceotion.BelowZeroException;
import codingdojo.parkingboy.exceotion.NotNatural;

public class TimeConduct {
    public String calculate(String num) {
        //TODO time Object three method to handle second min hour
        int time;
        try {
            time = Integer.parseInt(num);
        }catch (Exception e){
            throw new NotNatural();
        }
        if(time <= 0) {
            throw new BelowZeroException();
        }
        if(time == 1){
            return time + " second";
        }
        if(time < 60) {
            return time + " seconds";
        }
        if(time == 60){
            return time/60 + " min";
        }
        if(time <3600){
            return time/60 + " min, " + time%60 +" second";
        }
        return null;
    }
}
