package mvcbasic.springmvcbasic.controller;

import mvcbasic.springmvcbasic.domain.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    //spel
    //private Integer portValue;
    private String value;


//    public MainController(@Value("${server.port}") Integer portValue) {
//        this.portValue = portValue;
//        System.out.println(portValue);
//    }

    @GetMapping("/value")
    @ResponseBody
    //@RequestMapping(method = RequestMethod.GET,value =  "/value")
    private String getValue(){
        return "Value GET";
    }

    @PostMapping("/value")
    @ResponseBody
    private  String postValue(@RequestBody  Product product){
        return product.toString();
    }
}
