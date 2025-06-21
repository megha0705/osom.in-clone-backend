package com.Osom.demo.dto;

public class ProductInfoDto {
    private String img_url;
    private Double price;
    private String name;
    private Integer stock_quantity;
    private Double product_size;
    private String color;
    private String material_used;


    public ProductInfoDto(String img_url, Double price, Integer stock_quantity, String name,
                          Double product_size, String material_used, String color) {
        this.img_url = img_url;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.name = name;
        this.product_size = product_size;
        this.material_used = material_used;
        this.color = color;
    }


    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Double getProduct_size() {
        return product_size;
    }

    public void setProduct_size(Double product_size) {
        this.product_size = product_size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial_used() {
        return material_used;
    }

    public void setMaterial_used(String material_used) {
        this.material_used = material_used;
    }
}
