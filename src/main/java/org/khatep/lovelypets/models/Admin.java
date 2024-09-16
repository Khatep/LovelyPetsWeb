package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import org.khatep.lovelypets.enums.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @NotBlank(message = "Name should be not empty")
    @NotNull(message = "Name should be not empty")
    @Size(min = 2, max = 40)
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname should be not empty")
    @NotNull(message = "Surname should be not empty")
    @Size(min = 2, max = 40)
    @Column(name = "surname")
    private String surname;

    @NotBlank(message = "Email should be not empty")
    @NotNull(message = "Email should be not empty")
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password should be not empty")
    @NotNull(message = "Password should be not empty")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Role should be not empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role = Role.ADMIN;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ActionLog> actionLogs = new ArrayList<>();

    @NotNull(message = "Active should be not empty")
    @Column(name = "active")
    private boolean active;

    @NotNull(message = "Last Login Time should be not empty")
    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", actionLogs=" + actionLogs +
                ", active=" + active +
                ", lastLoginTime=" + lastLoginTime +
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
        Admin admin = (Admin) o;
        return getAdminId() != null && Objects.equals(getAdminId(), admin.getAdminId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}