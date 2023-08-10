package net.white.springbootsearchrestapi.repository;

import net.white.springbootsearchrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p from Product p where " +
            "p.name LIKE concat('%',:query,'%')" +
            "OR p.description LIKE concat('%',:query,'%')")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * from Product p where " +
            "p.name LIKE concat('%',:query,'%')" +
            "OR p.description LIKE concat('%',:query,'%')",nativeQuery = true)
    List<Product> searchProductsSQL(String query);
}
