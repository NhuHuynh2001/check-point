package com.example.checkpoint.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "score")
@NoArgsConstructor
@AllArgsConstructor
public class ScoreEntity {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id ;

    private Integer studentId ;

    private Double score;

}
