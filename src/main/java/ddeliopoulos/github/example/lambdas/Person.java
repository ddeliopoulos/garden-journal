package ddeliopoulos.github.example.lambdas;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
final class Person {

    private final String name;
    private final int age;
    private final Set<Pet> pets;
    private final Address address;


}
