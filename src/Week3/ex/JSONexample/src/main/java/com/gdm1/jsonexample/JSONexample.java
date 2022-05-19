package com.gdm1.jsonexample;

import com.google.gson.Gson;
import java.util.Calendar;

public class JSONexample
{

    public static void main(String[] args)
    {
        Person p = new Person("Graham", "Mansfield");
        Calendar dob = Calendar.getInstance();
        dob.set(Calendar.DATE, 23);
        dob.set(Calendar.MONTH, 0);
        dob.set(Calendar.YEAR, 1970);
        p.setDob(dob);
        
        System.out.println("\np.toString():\n\t" + p);
        
        String jsonStr = new Gson().toJson(p);
        
        System.out.println("\nJSON from p:\n\t" + jsonStr);
        
        Person p1 = new Gson().fromJson(jsonStr, Person.class);
        
        System.out.println("\np1.toString():\n\t" + p1);
    }
    
}
