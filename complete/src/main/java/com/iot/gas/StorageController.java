/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iot.gas;

import com.iot.storage.StorageAccount;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Owner
 */
@RestController
public class StorageController {
    @RequestMapping(value="/storage",method = RequestMethod.POST)
    public String addVector(@RequestBody String s) {
        StorageAccount.writeToStorage(s);
        return s;
    } 
}
