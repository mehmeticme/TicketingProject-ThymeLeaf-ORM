package com.practice.entity;

import com.practice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity {

    private String projectName;
    @Column(unique = true)
    private String projectCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private User assignedManager;
    private String projectDetail;
    @Enumerated(EnumType.STRING)
    private Status projectStatus;
    private LocalDate startDate;
    private LocalDate endDate;
}
