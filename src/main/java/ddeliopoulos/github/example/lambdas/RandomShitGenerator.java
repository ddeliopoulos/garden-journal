package ddeliopoulos.github.example.lambdas;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

final class RandomShitGenerator {

    private final static Random RANDOM = new Random();

    private final static List<String> HUMAN_NAMES = asList(
            "James", "Mary", "Robert", "Patricia",
            "John", "Jennifer", "Michael", "Linda",
            "William", "Elizabeth", "David", "Barbara",
            "Richard", "Susan", "Joseph", "Jessica",
            "Thomas", "Sarah", "Charles", "Karen"
    );

    private final static List<String> PET_SPECIES = asList(
            "dog", "cat", "rabbit", "cockatiel", "shark"
    );

    private final static List<String> PET_NAMES = asList(
            "Eddie",
            "Bella", "Charlie", "Luna", "Lucy",
            "Max", "Bailey", "Cooper", "Daisy",
            "Sadie", "Molly", "Buddy", "Lola",
            "Stella", "Tucker", "Bentley", "Zoey",
            "Harley", "Maggie", "Riley", "Bear",
            "Sophie", "Duke", "Jax", "Oliver",
            "Chloe", "Jack", "Penny", "Rocky",
            "Lily", "Milo", "Piper"
    );

    private final static List<String> COUNTRIES = asList(
            "Spain", "Poland", "USA", "Germany"
    );

    private final static List<String> CITIES = asList(
            "Barcelona", "Philadelphia", "Lublin", "Athens", "Thessaloniki"
    );

    final List<Person> getRandomPeople() {
        return IntStream.range(5, RANDOM.nextInt(15) + 5)
                .mapToObj(it -> generatePerson())
                .collect(toList());
    }

    private Person generatePerson() {
        return new Person(
                getRandomFrom(HUMAN_NAMES),
                RANDOM.nextInt(100),
                IntStream.range(5, RANDOM.nextInt(15) + 5)
                        .mapToObj(it -> generatePet())
                        .collect(toSet()),
                generateAddress()
        );
    }

    private Address generateAddress() {
        return new Address(
                getRandomFrom(COUNTRIES),
                getRandomFrom(CITIES)
        );
    }

    private Pet generatePet() {
        return new Pet(
                getRandomFrom(PET_SPECIES),
                getRandomFrom(PET_NAMES),
                RANDOM.nextInt(25)
        );
    }

    private String getRandomFrom(final List<String> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }

}
