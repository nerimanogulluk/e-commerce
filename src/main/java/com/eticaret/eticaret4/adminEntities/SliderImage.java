package com.eticaret.eticaret4.adminEntities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class SliderImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sImageId;
    private String sImageName;
    private String sTitle;
    private int sSale;
    private String sDescription;
}
