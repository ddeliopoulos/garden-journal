package ddeliopoulos.github.fridge.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import ddeliopoulos.github.fridge.products.api.RecipeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class RefrigeratorService {
    private final RefrigeratorRepository refrigeratorRepository;
    private final ObjectMapper objectMapper;

    @Cacheable(value="recipes")
    public Object getRecipe(final String recipeName) {
        return "my recipe is " + recipeName;
    }

    Long itemsInFridge(final RecipeRequest request, Long refrigeratorId) {
//        objectMapper.readValue("", Object.class);

        final Refrigerator fridgeEntity = new Refrigerator(
                refrigeratorId,
                request.getRedMeat(),
                request.getRedMeatCount(),
                request.getWhiteMeat(),
                request.getWhiteMeatCount(),
                request.getFish(),
                request.getFishCount(),
                request.getVeggieType(),
                request.getVeggieCount(),
                request.getLiquid()
        );

        final Refrigerator savedEntity = refrigeratorRepository.save(fridgeEntity);
        return savedEntity.getRefrigeratorId();
    }

}
