package com.gaggle.sdetassesment.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO {
    private int schoolId;
    private String schoolName;
    private Integer studentCount;
    private String emailAddress;
}
