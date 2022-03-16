package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private double totalCost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Book bookId;

}
