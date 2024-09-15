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
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @NotBlank(message = "City should be not empty")
    @NotNull
    @Size(min = 5, max = 30)
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Street should be not empty")
    @NotNull
    @Size(min = 5, max = 30)
    @Column(name = "street")
    private String street;

    @NotBlank(message = "Postal code should be not empty")
    @NotNull
    @Size(min = 10, max = 20)
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank(message = "Number of home should be not empty")
    @NotNull
    @Column(name = "number_of_home")
    private String numberOfHome;

    @NotNull
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;
}
