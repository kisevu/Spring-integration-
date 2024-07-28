package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinter {

    public void print(File file){
        BufferedReader reader=null;
       try{
           reader = new BufferedReader(new FileReader(file));
           String line ="";
           while((line=reader.readLine())!=null){
               System.out.println(line); //display on console
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try{
               reader.close(); //close resources
           }catch (IOException ex){
               ex.printStackTrace();
           }
       }
    }

    public void print(String file){
        System.out.println("invoking print method with string.");
        System.out.println(file);
    }

}
