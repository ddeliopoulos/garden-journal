package ddeliopoulos.github.fridge.products;

import ddeliopoulos.github.fridge.products.api.RecipeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
class RefrigeratorController {

    private final RefrigeratorService refrigeratorService;

    @GetMapping("/recipes/{recipeId}")
    public Long itemsInFridge(@Valid @RequestBody RecipeRequest request, @PathVariable Long recipeId, @Param("test") String bla) {
        return refrigeratorService.itemsInFridge(request, recipeId);
    }
}
