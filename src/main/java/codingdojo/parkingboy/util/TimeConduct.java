package codingdojo.parkingboy.util;

import codingdojo.parkingboy.exceotion.BelowZeroException;
import codingdojo.parkingboy.exceotion.NotNatural;

public class TimeConduct {

    public static final String HOUR = " hour, ";
    public static final String HOURS = " hours, ";
    public static final String MINUTE = " minute, ";
    public static final String MINUTES = " minutes, ";
    public static final String SECOND = " second.";
    public static final String SECONDS = " seconds.";

    public String calculate(String num) {
        //TODO time Object three method to handle second min hour
        int timeNum;
        int second = 0;
        int minute = 0;
        int hour = 0;
        int remianNum = 0;
        try {
            timeNum = Integer.parseInt(num);
        }catch (Exception e){
            throw new NotNatural();
        }
        if(timeNum<3600) {
            minute = timeNum / 60;
            second = timeNum % 60;
        }else{
            hour = timeNum / 3600;
            remianNum = timeNum % 3600;
            minute = remianNum / 60;
            second = remianNum % 60;
        }
        
        if(hour > 0){
            if (hour >1) {
                if(minute > 1){
                    if (second > 1){
                        return hour + HOURS + minute + MINUTES +second+ SECONDS;
                    }else if (second == 1){
                        return hour + HOURS + minute + MINUTES +second+ SECOND;
                    }else{
                        return hour + HOURS + minute + MINUTES;
                    }
                }else if (minute == 1){
                    if (second > 1){
                        return hour + HOURS + minute + MINUTE +second+ SECONDS;
                    }else if(second == 1){
                        return hour + HOURS + minute + MINUTE +second+ SECOND;
                    }else {
                        return hour + HOURS + minute + MINUTE ;
                    }
                }else{
                    if (second > 1){
                        return hour + HOURS + minute +second+ SECONDS;
                    }else if(second == 1){
                        return hour + HOURS + minute + second+ SECOND;
                    }else {
                        return hour + HOURS;
                    }
                }
            }else{
                if(minute > 1){
                    if (second > 1){
                        return hour + HOUR + minute + MINUTES +second+ SECONDS;
                    }else if (second == 1){
                        return hour + HOUR + minute + MINUTES +second+ SECOND;
                    }else{
                        return hour + HOUR + minute + MINUTES;
                    }
                }else if (minute == 1){
                    if (second > 1){
                        return hour + HOUR + minute + MINUTE +second+ SECONDS;
                    }else if (second == 1){
                        return hour + HOUR + minute + MINUTE +second+ SECOND;
                    }else{
                        return hour + HOUR + minute + MINUTE ;

                    }
                }
            }
        }else if(minute > 0){
            if(minute > 1){
                if(second > 1){
                    return minute + MINUTES + second + SECONDS;
                }else{
                    return minute + MINUTES + second + SECOND;
                }
            }else{
                if(second > 1){
                    return minute + MINUTE + second + SECONDS;
                }else{
                    return minute + MINUTE + second + SECOND;
                }
            }
        }else if(second > 1){
            return second + SECONDS;
        }else{
            return second + SECOND;
        }
        
//        if(timeNum <= 0) {
//            throw new BelowZeroException();
//        }
//        if(timeNum == 1){
//            return timeNum + " second";
//        }
//        if(timeNum < 60) {
//            return timeNum + " seconds";
//        }
//        if(timeNum == 60){
//            return timeNum/60 + " min";
//        }
//        if(timeNum <3600){
//            return timeNum/60 + " min, " + timeNum%60 +" second";
//        }
        return null;
    }
}
