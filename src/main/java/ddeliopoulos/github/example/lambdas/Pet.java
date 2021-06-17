package ddeliopoulos.github.example.lambdas;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
final class Pet {

    private final String species;
    private final String name;
    private final int age;

}
