/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iot.gas;

/**
 *
 * @author 212616565
 */
public class DeviceVector {
    private String id;
    private long ts;
    private double[] values;
    private String site;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    public String toString(){
        String valToString="[";
        for(double d:getValues()){
            if(d==getValues().length)
                valToString=valToString+d;
            else
                valToString=valToString+d+",";
        }
        valToString=valToString+"]";
        return "{site:"+getSite()+", ts:"+getTs()+", values:"+getValues()+"}";
    }
    
}
