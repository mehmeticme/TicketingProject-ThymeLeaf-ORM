package com.practice.entity;

import com.practice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")
public class User  extends BaseEntity{

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;


}
