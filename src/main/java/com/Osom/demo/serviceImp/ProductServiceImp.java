package com.Osom.demo.serviceImp;

import com.Osom.demo.entity.productEntity.CategoryName;
import com.Osom.demo.entity.productEntity.ProductBasicDetails;
import com.Osom.demo.entity.productEntity.ProductCategory;
import com.Osom.demo.entity.productEntity.ProductSpecification;
import com.Osom.demo.repository.ProductCategoryRepo;
import com.Osom.demo.repository.ProductRepo;
import com.Osom.demo.repository.ProductSpecificationRepo;
import com.Osom.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp  implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductSpecificationRepo productSpecsRepo;
    @Autowired
    ProductCategoryRepo productCategoryRepo;
    @Override
    public void addProductBasicDetails(String name, String description, Double price, int stock_quantity, String warehouse_location) {
        ProductBasicDetails productBasicDetails = new ProductBasicDetails();
        productBasicDetails.setDescription(description);
        productBasicDetails.setName(name);
        productBasicDetails.setPrice(price);
        productBasicDetails.setStock_quantity(stock_quantity);
        productBasicDetails.setWarehouse_location(warehouse_location);
        productRepo.save(productBasicDetails);
    }

    @Override
    public void addProductSpecification(List<Double> product_size, String color, String material_used , int product_id) {

        ProductBasicDetails products = productRepo.findById(product_id).orElseThrow(()->  new RuntimeException("product with this id is not found"));
        for(Double size : product_size){
            ProductSpecification productSpecification = new ProductSpecification();
            productSpecification.setProduct_size(size);
            productSpecification.setColor(color);
            productSpecification.setMaterial_used(material_used);
            productSpecification.setProduct_id(products);
            productSpecsRepo.save(productSpecification);
        }


    }

    @Override
    public void addCategory(int categoryName, int productId) {
        ProductCategory productCategory = new ProductCategory();
        ProductBasicDetails product_id = productRepo.findById(productId).orElseThrow(()-> new RuntimeException("product with that id is not found"));

        productCategory.setCategory_name(CategoryName.values()[categoryName]);
        productCategory.setProduct_id(product_id);
        productCategoryRepo.save(productCategory);
    }
}
