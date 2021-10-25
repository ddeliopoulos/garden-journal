package ddeliopoulos.github.example;

import java.util.function.Function;

public interface YetAnotherEither<First, Second> {

    @SuppressWarnings("unused")
    public final static String BLA = "bla";

    First getFirst();

    Second getSecond();

    boolean isFirst();

    boolean isSecond();

    default <NewFirst> YetAnotherEither<NewFirst, Second> mapFirst(Function<First, NewFirst> mapper) {
        return ofFirst(mapper.apply(getFirst()));
    }

    static <First, Second> YetAnotherEither<First, Second> ofFirst(final First value) {
        return new YetAnotherEither<First, Second>() {
            @Override
            public First getFirst() {
                return value;
            }

            @Override
            public Second getSecond() {
                throw new IllegalStateException();
            }

            @Override
            public boolean isFirst() {
                return true;
            }

            @Override
            public boolean isSecond() {
                return false;
            }
        };
    }

    static <First, Second> YetAnotherEither<First, Second> ofSecond(final Second value) {
        return new YetAnotherEither<First, Second>() {
            @Override
            public First getFirst() {
                throw new IllegalStateException();
            }

            @Override
            public Second getSecond() {
                return value;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isSecond() {
                return true;
            }
        };
    }

}
