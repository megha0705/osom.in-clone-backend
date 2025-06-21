package com.Osom.demo.repository;
import com.Osom.demo.entity.productEntity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory , Integer> {
}
