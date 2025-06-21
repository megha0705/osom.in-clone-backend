package com.Osom.demo.controller;

import com.Osom.demo.dto.ProductInfoDto;
import com.Osom.demo.entity.productEntity.ProductImage;
import com.Osom.demo.repository.ProductImgRepo;
import com.Osom.demo.repository.ProductRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RestController
public class UserController {
    //only display the images
    @Autowired
    ProductImgRepo productImgRepo;
    @Autowired
    ProductRepo productRepo;
    @GetMapping("/show-all")
    public List<String> showProducts(){
        List<String> productImageUrl = productImgRepo.findAll().stream().map(product -> product.getImg_url()).collect(Collectors.toList());
        return productImageUrl;
    }
    @GetMapping("/{id}")
    public ProductInfoDto showDetails(@PathVariable int id){
        ProductInfoDto product = productRepo.getFullProductInfo(id);
        return product;
    }
}
