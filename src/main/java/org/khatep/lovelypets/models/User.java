package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.khatep.lovelypets.enums.Gender;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "Name should be not empty")
    @NotNull
    @Size(min = 2, max = 40)
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname should be not empty")
    @NotNull
    @Size(min = 2, max = 40)
    @Column(name="surname")
    private String surname;

    @NotBlank(message = "Email should be not empty")
    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password should be not empty")
    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull(message = "Birth date should be not empty")
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank(message = "Phone number should be not empty")
    @NotNull
    @Size(min = 10, max = 11)
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @NotNull(message = "Gender should be not empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart cart;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", cart=" + cart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(birthDate, user.birthDate) && Objects.equals(phoneNumber, user.phoneNumber) && gender == user.gender && Objects.equals(cart, user.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, email, birthDate, phoneNumber, gender);
    }
}