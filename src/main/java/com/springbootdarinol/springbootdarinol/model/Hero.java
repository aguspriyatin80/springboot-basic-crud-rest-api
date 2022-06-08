package com.springbootdarinol.springbootdarinol.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    private int id;

    private String name;
    private int damage;

    private Boolean isMarriage;

}

