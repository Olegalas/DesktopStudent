package com.dex.desktopstudent.model;

import java.io.Serializable;

/**
 * Created by dexter on 17.12.16.
 */
public enum Degree implements Serializable{

    PROFESSOR(),
    DOCTOR(),
    DEFAULT;

    public static Degree getDegree(String degree){
        if(degree == null || degree.isEmpty()){
            return DEFAULT;
        }
        for(Degree d : Degree.values()){
            if(degree.equals(d.toString())){
                return d;
            }
        }
        return DEFAULT;
    }

}
