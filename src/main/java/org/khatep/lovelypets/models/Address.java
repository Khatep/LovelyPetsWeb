package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @NotBlank(message = "Country should be not empty")
    @NotNull(message = "Country should be not empty")
    @Size(min = 3, max = 50)
    @Column(name = "country")
    private String country;

    @NotBlank(message = "City should be not empty")
    @NotNull(message = "City should be not empty")
    @Size(min = 5, max = 30)
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Street should be not empty")
    @NotNull(message = "Street should be not empty")
    @Size(min = 5, max = 30)
    @Column(name = "street")
    private String street;

    @NotBlank(message = "Postal code should be not empty")
    @NotNull(message = "Postal code should be not empty")
    @Size(min = 10, max = 20)
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank(message = "Number of home should be not empty")
    @NotNull(message = "Number of home should be not empty")
    @Column(name = "number_of_home")
    private String numberOfHome;

    @NotNull(message = "User should be not empty")
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", numberOfHome='" + numberOfHome + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer()
                .getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Address address = (Address) o;
        return getAddressId() != null && Objects.equals(getAddressId(), address.getAddressId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer()
                .getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
