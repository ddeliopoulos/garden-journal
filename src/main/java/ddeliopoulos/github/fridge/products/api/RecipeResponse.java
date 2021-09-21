package ddeliopoulos.github.fridge.products.api;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public final class RecipeResponse {

    private String redMeat;
    private Long redMeatCount;

    private String whiteMeat;
    private Long whiteMeatCount;

    private String fish;
    private Long fishCount;

    private String veggieType;
    private Long veggieCount;

    private String liquid;
}
