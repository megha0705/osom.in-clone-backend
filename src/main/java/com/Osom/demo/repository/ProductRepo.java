package com.Osom.demo.repository;

import com.Osom.demo.dto.ProductInfoDto;
import com.Osom.demo.entity.productEntity.ProductBasicDetails;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProductRepo extends JpaRepository<ProductBasicDetails , Integer> {
  /* @Query("SELECT new com.Osom.demo.dto.ProductInfoDto(pi.img_url , pb.price , pb.quantity , pb.name , ps.product_size , ps.material_used , ps.color)"+
                    "FROM ProductImage pi"+
                    "JOIN ProductBasicDetails pb ON pi.product_id = pb.id"+
                    "JOIN ProductSpecification ps ON ps.product_id = pb.id"+
                    "WHERE pb.id = :productId")*/
  @Query("SELECT new com.Osom.demo.dto.ProductInfoDto(pi.img_url, pb.price, pb.stock_quantity, pb.name, ps.product_size, ps.material_used, ps.color) " + "FROM ProductImage pi " + "JOIN pi.product_id pb " + "JOIN pb.product_specification ps " + "WHERE pb.id = :productId")
    ProductInfoDto getFullProductInfo(@Param("productId") int productId);
}
