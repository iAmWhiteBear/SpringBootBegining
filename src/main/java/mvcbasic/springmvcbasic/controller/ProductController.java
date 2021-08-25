package mvcbasic.springmvcbasic.controller;

import mvcbasic.springmvcbasic.domain.Product;
import mvcbasic.springmvcbasic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    private String getProducts(Model model,@RequestParam(required = false) Integer maxPrice){
        //лист полученный спрингом, нельзя изменять, поэтому, создаётся новый лист, который может быть изменён
        List<Product> prods = productService.productGetAll();
        List<Product> maxPriceList = new ArrayList<>();
        if(maxPrice != null){
            for(Product p:prods) {
                if (p.getPrice()<=maxPrice) maxPriceList.add(p);
            }
        } else
            maxPriceList = prods;


        model.addAttribute("products", maxPriceList);

        return "product";
    }

    @GetMapping("/{id}")
    private String getProduct(Model model,@PathVariable(required = false) Long id){
        Product prod = productService.productGetById(id.intValue()).get();
        model.addAttribute("products", prod);

        return "product";
    }

    @GetMapping("new")
    private String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "new-product";
    }

    @PostMapping("/addProduct")
    private String addProduct(@ModelAttribute Product product){
        productService.addProduct(product);

        return "redirect:all";
    }


}
