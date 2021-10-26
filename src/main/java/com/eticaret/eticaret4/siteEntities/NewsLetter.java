package com.eticaret.eticaret4.siteEntities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class NewsLetter {
    @Id
    private int nid;

    @Column(unique = true)
    private String email;

}
