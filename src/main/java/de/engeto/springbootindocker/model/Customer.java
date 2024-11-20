package de.engeto.springbootindocker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_gen")
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "customer_customer_id_seq", allocationSize = 1)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Size(max = 255)
    @Column(name = "sheet_customer_id")
    private String sheetCustomerId;

}