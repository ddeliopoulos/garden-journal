package ddeliopoulos.github.example.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface LambdaAndStreamsExercise {

    static void main(final String... args) {
        final List<Person> people = new RandomShitGenerator().getRandomPeople();
    }

    /**
     * Get a list of names of people whose pets have name "Eddie"
     */
    private static List<String> getListOfNamesOfPeopleWhosePetsHaveNameEddie(final List<Person> people) {
        final List<String> result = new ArrayList<>();
        for (Person person : people) {
            for (Pet pet : person.getPets()) {
                if ("Eddie".equals(pet.getName())) {
                    result.add(person.getName());
                    break;
                }
            }
        }
        return result;
    }

    private static List<String> getListOfNamesOfPeopleWhosePetsHaveNameEddieWithMagic(final List<Person> people) {
        return people.stream()
                .filter(person ->
                        person.getPets()
                                .stream()
                                .map(Pet::getName)
                                .anyMatch("Eddie"::equals)
                ).map(person -> person.getName())
                .collect(Collectors.toList());
    }



    /**
     * 1. Count people who live in USA
     * 2. Count how many people have dogs
     * 3. Count how many people in the USA have dogs
     * 4. Find people who have a dog whose name starts with "C"
     * 5. Find people that have more than 1 bird
     * 6. Print name of people and name of their last pet separated with a comma, e.g. "Pawel,Kiwi"
     */

}
