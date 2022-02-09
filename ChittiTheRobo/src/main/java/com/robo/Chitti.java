package com.robo;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author gautham
 */
public class Chitti {
    
    public static void main(String args[]){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 17);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        Date start = new Date();
        Date end = cal.getTime();
        
        long diff = end.getTime() - start.getTime();
        long min = diff/(1000 * 60);
        System.out.println("Minutes till 17:00 "+min);
        
        try{
            Robot robo = new Robot();
            while(min > 0){
                robo.delay(1000 * 60);
                min--;
                System.out.println(min);
                Point point = MouseInfo.getPointerInfo().getLocation();
                robo.mouseMove(point.x+2, point.y+2);
            }
        } catch (AWTException ex){
            System.err.println(ex);
        }
    }
    
}
