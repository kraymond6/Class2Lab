/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author Kallie
 */
public class WelcomeService {
    private Calendar date = Calendar.getInstance();
    
    private Calendar morningStart = Calendar.getInstance();
    private Calendar afternoonStart = Calendar.getInstance();
    private Calendar eveningStart = Calendar.getInstance();
    private String timeGreeting;
    
    public String getTime(){
        //Good morningStart = 12am to 12pm
        //Good afternoonStart = 12pm to 5pm
        //Good eveningStart = 5pm to 12am
        morningStart.set(Calendar.HOUR_OF_DAY, 0);
        afternoonStart.set(Calendar.HOUR_OF_DAY, 12);
        eveningStart.set(Calendar.HOUR_OF_DAY, 17);
        
        if (date.equals(morningStart) || (date.after(morningStart) && date.before(afternoonStart))){
            timeGreeting = "Good morning, ";
        }
        else if (date.equals(afternoonStart) || (date.after(afternoonStart) && date.before(eveningStart))){
            timeGreeting = "Good afternoon, ";
        }
        else if (date.equals(eveningStart) || (date.after(eveningStart))){
            timeGreeting = "Good evening, ";
        }
        else{
            timeGreeting = "Error";
        }
        return timeGreeting;
    }
    
    public String getGreeting(String name){
        return timeGreeting + name + "!";
    }
}
