package ddeliopoulos.github.example.lambdas;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
final class Address {

    private final String country;
    private final String city;

}
