package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khatep.lovelypets.enums.OrderStatus;
import org.khatep.lovelypets.enums.ShippingMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @NotNull
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_method")
    private ShippingMethod shippingMethod;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
