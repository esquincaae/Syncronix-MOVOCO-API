package com.mocovo.mocovo.entities;

import com.mocovo.mocovo.entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter @Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;

    private Integer quantity;

    private Double totalPrice;

    @PrePersist @PreUpdate
    public void prePersist() {
        setTotalPrice(quantity * product.getPrice());
    }

}