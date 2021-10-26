package com.eticaret.eticaret4.adminEntities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private int cid; // join table
    private String ptitle;
    private double price;
    private String detail;



}