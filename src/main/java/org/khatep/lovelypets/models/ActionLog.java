package org.khatep.lovelypets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "action_logs")
public class ActionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_log_id")
    private Long actionLogId;

    @NotNull(message = "Action date is not be empty")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "action_date")
    private LocalDateTime actionDate;

    @NotBlank(message = "Description should be not empty")
    @NotNull(message = "Description should be not empty")
    @Column(name = "description")
    @Size(min = 5, max = 150)
    private String description;

    @NotNull(message = "Admin should be not empty")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private Admin admin;

    @Override
    public String toString() {
        return "ActionLog{" +
                "actionLogId=" + actionLogId +
                ", actionDate=" + actionDate +
                ", description='" + description + '\'' +
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
        ActionLog actionLog = (ActionLog) o;
        return getActionLogId() != null && Objects.equals(getActionLogId(), actionLog.getActionLogId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode()
                : getClass().hashCode();
    }
}