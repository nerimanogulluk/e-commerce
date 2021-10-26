package com.eticaret.eticaret4.siteRepositories;

import com.eticaret.eticaret4.siteEntities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    @Query("select b from Basket b where b.pid = ?1 and b.uuid = ?2")
    Basket itemBasket(int pid, String uuid);




}
