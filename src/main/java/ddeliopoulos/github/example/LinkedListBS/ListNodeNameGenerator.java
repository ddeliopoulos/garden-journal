package ddeliopoulos.github.example.LinkedListBS;

import java.util.concurrent.atomic.AtomicReference;

final class ListNodeNameGenerator {

    private final static AtomicReference<Character> LAST_NAME = new AtomicReference<>('A');

    static String generateName() {
        return LAST_NAME.getAndUpdate(it -> (char) (it + 1)).toString();
    }

}
