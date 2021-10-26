package com.eticaret.eticaret4.adminEntities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String title;
    private int status; // ana kat = 0, alt kat = anaKatid ?

}
