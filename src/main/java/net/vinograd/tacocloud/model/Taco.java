package net.vinograd.tacocloud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @ManyToMany
    @Size(min = 1, message = "You must chose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

}
