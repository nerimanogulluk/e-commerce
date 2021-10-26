package com.eticaret.eticaret4.siteEntities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    private int pid;
    private String uuid;

}
