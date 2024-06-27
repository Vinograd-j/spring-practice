package net.vinograd.tacocloud.converter;

import lombok.NonNull;
import net.vinograd.tacocloud.data.IngredientRepository;
import net.vinograd.tacocloud.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    @Autowired
    private IngredientRepository ingredientRepository;

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientRepository.findById(id).orElseThrow();
    }

}
