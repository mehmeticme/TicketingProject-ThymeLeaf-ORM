package com.practice.dto;

import com.practice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private String projectDetail;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate endDate;
    private Status projectStatus;

}
