package com.eticaret.eticaret4.adminEntities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int content_id;
    private String content_description;
    private String content_detail;
    private String content_title;


}
