package com.tistory.skyfox83.csvTest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Food {

    @Id
    @Column(name = "food_id")
    private String id;

    private String name;

    public Food(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
