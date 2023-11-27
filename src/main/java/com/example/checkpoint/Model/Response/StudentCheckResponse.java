package com.example.checkpoint.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCheckResponse {

    private Integer studentId ;

    private String name;

    private String classRoom;

    private String gender;

    private Double score;
}
