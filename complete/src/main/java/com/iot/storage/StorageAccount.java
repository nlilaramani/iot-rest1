/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iot.storage;

import com.iot.gas.DeviceVector;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class StorageAccount {
    
    private static String connString="DefaultEndpointsProtocol=https;AccountName=cs2ef613247ed84x4ef5x9af;AccountKey=ZzlYvsroucMGvAi89UOALejG+Q6kgjUjVa2ggEr6iuQ2yjabphY1yHTMN6K3hKbWdDogiT+2k5IFiliEL8X9EQ==;EndpointSuffix=core.windows.net";
    
    
    public static String writeToStorage(String s){
        File sourceFile = null, downloadedFile = null;
        CloudStorageAccount storageAccount;
	CloudBlobClient blobClient = null;
	CloudBlobContainer container=null;    
        try{
            storageAccount = CloudStorageAccount.parse(connString);
            blobClient = storageAccount.createCloudBlobClient();
            container = blobClient.getContainerReference("iotstore");
            // Create the container if it does not exist with public access.
            container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());		    
            //Creating a sample file
            java.util.Date dt=new java.util.Date();
            String fileName=dt.getYear()+"-"+dt.getMonth()+"-"+dt.getDay();
            //Check if the file exists in blob
	    sourceFile = File.createTempFile(fileName,".log");
	   //System.out.println("Creating a sample file at: " + sourceFile.toString());
	    Writer output = new BufferedWriter(new FileWriter(sourceFile));
	    output.write(s);
	    output.close();
            CloudBlockBlob blob = container.getBlockBlobReference(sourceFile.getName());
            blob.uploadFromFile(sourceFile.getAbsolutePath());
            return blob.getUri().toString();
                    
        }catch(Exception e){
            
        }
        return "fail";
    
    }
    
}
