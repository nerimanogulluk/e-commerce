package com.eticaret.eticaret4.adminEntities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private Long id; //user id join
    private String addressTitle;
    private String city;
    private String county;
    private String addressDetails;
}
