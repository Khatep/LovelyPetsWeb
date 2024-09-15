package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    @NotBlank(message = "Name should be not empty")
    @NotNull
    @Column(name = "name")
    @Size(min = 5, max = 70)
    private String name;

    @NotBlank(message = "Description should be not empty")
    @NotNull
    @Column(name = "description")
    @Size(min = 10, max = 150)
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @NotNull
    @Column(name = "price")
    private Long price;
}
