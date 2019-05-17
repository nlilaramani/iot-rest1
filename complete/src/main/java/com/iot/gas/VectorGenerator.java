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
public class VectorGenerator {
    public static DeviceVector getNewVector(){
        DeviceVector v=new DeviceVector();
        v.setId("1");
        v.setSite("ITEXPS");
        v.setTs(System.currentTimeMillis());
        v.setValues(new double[]{12.3,34.5,23.5,11.6,11.2});
        return v;
    }
}
