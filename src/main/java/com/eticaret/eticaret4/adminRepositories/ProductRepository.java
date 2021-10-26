package com.eticaret.eticaret4.adminRepositories;

import com.eticaret.eticaret4.adminEntities.Product;
import com.eticaret.eticaret4.adminEntities.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    //@Query(value = "SELECT p.pid, p.cid, p.detail, p.price, p.ptitle, i.image_name as imageName, c.title FROM product as p INNER JOIN image as i ON p.pid = i.pid INNER JOIN category as c ON c.cid = p.cid", nativeQuery = true)
    //<T> Collection<T> proImages( Class<T> type );

    Product getByPidEquals(int pid);




}
