/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iot.gas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 212616565
 */
@RestController
public class GasController {
    private static List vectors=new ArrayList<DeviceVector>();
    @RequestMapping(value="/gas",method = RequestMethod.GET)
    public List<DeviceVector> getVectors() {
        return vectors;
    }
    @RequestMapping(value="/gas",method = RequestMethod.POST)
    public String addVector(@RequestBody DeviceVector v) {
        vectors.add(v);
        return "success";
    } 
    @RequestMapping(value="/gas/generate",method = RequestMethod.GET)
    public String generateVector() {
        vectors.add(VectorGenerator.getNewVector());
        return "success";
    }
}
