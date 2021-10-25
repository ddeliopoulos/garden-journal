//package ddeliopoulos.github.example;
//
//import lombok.EqualsAndHashCode;
//import lombok.RequiredArgsConstructor;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Optional;
//import java.util.function.Function;
//
//
//@EqualsAndHashCode
//@RequiredArgsConstructor
//public final class Either<TypeOfFirstParameter, TypeOfSecondParameter> {
//
//    private final TypeOfFirstParameter objS;
//    private final TypeOfSecondParameter objI;
//    private final boolean first;
//
//    public TypeOfFirstParameter getFirst() {
//        if (!isFirst()) throw new IllegalStateException();
//        return objS;
//    }
//
//    public TypeOfSecondParameter getSecond() {
//        if (isFirst()) throw new IllegalStateException();
//        return objI;
//    }
//
//    public Boolean isFirst() {
//        return first;
//    }
//
//    public void bla(TypeOfFirstParameter a) {
//
//    }
//
//    @NotNull
//    public static <TypeI> Either<Integer, TypeI> ofFirst(Integer input) {
//        System.out.println("I am first of integer!");
//        return ofFirst(input);
//    }
//
//    public static <TypeOfFirstInThisMethod, TypeI> Either<TypeOfFirstInThisMethod, TypeI> ofFirst(TypeOfFirstInThisMethod input) {
////        System.out.println("I accept String and Integer cause I'm inclusive!, I am type: " +
////                                   input.getClass()
////                                        .getName());
//        return new Either<>(input, null, true);
//    }
//
//    public static <TypeOfFirstInAnotherMethod, TypeI> Either<TypeOfFirstInAnotherMethod, TypeI> ofSecond(TypeI input) {
////        System.out.println("I accept String and Integer cause I'm inclusive!, I am type: " +
////                                   input.getClass()
////                                        .getName());
//        return new Either<TypeOfFirstInAnotherMethod, TypeI>(null, input, false);
//    }
//
//    <NewTypeI> Either<TypeOfFirstParameter, NewTypeI> mapSecond(Function<TypeOfSecondParameter, NewTypeI> mapper) {
//        if (isFirst()) {
//            return Either.ofFirst(getFirst());
//        } else {
//            return Either.ofSecond(mapper.apply(getSecond()));
//        }
//    }
//
//    static Integer mapCharSeq(CharSequence someSeq) {
//        return someSeq.length();
//    }
//
//    public static void main(String[] args) {
//        Function<CharSequence, Integer> bla = Either::mapCharSeq;
//
//        Either<Integer, Object> aabla = Either.ofFirst(123);
//        Either<String, Integer> first = Either.ofFirst("null");
//        Either<String, String> second = Either.ofSecond("5");
//        Optional<String> s = Optional.of("");
//        s.map(bla);
//
//
//        Either<Either<String, Integer[]>, Either<Double, Either<Long, Object>>> superEither = Either.ofFirst(Either.ofSecond(new Integer[2]));
//
//        if (first.isFirst()) {
//            System.out.println(first.getFirst()); // works OK
//            System.out.println(first.getSecond()); // should throw, this is an Either of first
//        }
//    }
//
//
//}
