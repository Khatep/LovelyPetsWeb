package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long cartId;

    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @NotNull
    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    @NotNull
    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private User user;

    @PrePersist
    public void prePersist() {
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId) && Objects.equals(totalPrice, cart.totalPrice) && Objects.equals(updatedDate, cart.updatedDate) && Objects.equals(products, cart.products) && Objects.equals(user, cart.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, totalPrice, updatedDate, products, user);
    }
}

