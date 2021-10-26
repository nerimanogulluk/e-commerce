package com.eticaret.eticaret4.adminEntities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int image_Id;
    private int pid;
    private String image_Name;
    private int sImageId;
    @Temporal(TemporalType.DATE)
    private Date image_Date;

}
