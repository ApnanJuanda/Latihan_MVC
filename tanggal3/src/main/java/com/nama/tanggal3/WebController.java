/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nama.tanggal3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class WebController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("saying hello...");
        return "hello";
    }
    
}
