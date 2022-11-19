package com.SpringBootRestAPI.demo.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="asset")
@ToString
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="asset_name")
    private String assetName;

    @Column(name="purchase_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date purchaseDate;

    @Column(name="condition_notes")
    private String conditionNotes;

    @Column(name="category")
    private String category;

    @Column(name="assignment_status")
    private String assignmentStatus;

}
