/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iot.gas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.storage.StorageAccount;
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
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index() {
        return "Hello World from IoT Controller!";
    }
    
    @RequestMapping(value="/gas",method = RequestMethod.GET)
    public List<DeviceVector> getVectors() {
        return vectors;
    }
    @RequestMapping(value="/gas",method = RequestMethod.POST)
    public String addVector(@RequestBody DeviceVector v) {
        vectors.add(v);
        return writeToStorage(v);
        //return "success";
    } 
    @RequestMapping(value="/gas/generate",method = RequestMethod.GET)
    public String generateVector() {
        DeviceVector v=VectorGenerator.getNewVector();
        vectors.add(v);
        return writeToStorage(v);
    }
    
    private String writeToStorage(DeviceVector v){
        String jsonStr=null;
        try{
            ObjectMapper mapper=new ObjectMapper();
            jsonStr=mapper.writeValueAsString(v);
        }catch(Exception e){
            return "fail";
        }
        return StorageAccount.writeToStorage(jsonStr);
    }
}
