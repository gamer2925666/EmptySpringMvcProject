/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springsecuritytest.controller;

import com.mycompany.springsecuritytest.pojo.Cat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

/**
 *
 * @author COSH
 */
@Controller
public class TestController {
        @GetMapping("/")
        public ModelAndView index() throws ParserConfigurationException{
                ModelAndView modelAndView = new ModelAndView("index");
                Document document = DocumentBuilderFactory.newInstance().
                        newDocumentBuilder().newDocument();
                document.appendChild(document.createElement("root"));
                modelAndView.addObject(document);

                return modelAndView;
        }

//        @Value("#{testValue}")
//        String value;

        @GetMapping(value="/cat/{id}")
        @ResponseBody
        public List<Cat> test(@PathVariable Long id){
                List<Cat> list = new ArrayList<>();
                Cat cat = new Cat(id, "testCat", "grey", 16);
                list.add(cat);
                return list;
        }

        @GetMapping(value = "/getTestValue")
        @ResponseBody
        public String test1(){
                //取得tomcat中setenv.bat中設定的變數
                return System.getenv("testCat");
        }
}
