package org.khatep.lovelypets.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank
    @NotNull
    @Column(name = "name")
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @NotNull
    @Column(name = "suname")
    @Size(min = 10, max = 150)
    private String description;

    @NotNull
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(name, category.name) && Objects.equals(description, category.description) && Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, description, products);
    }
}
