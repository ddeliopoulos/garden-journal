package ddeliopoulos.github.example.callbacks;

import lombok.SneakyThrows;

public class CallbackExample {

    public static void main(final String... args) {
        final CallbackExample example = new CallbackExample();
        final PrintingCallback print = new PrintingCallback();

        final Callback anonymousCallback = new Callback() {
            @Override
            public void callMeBack(Object input) {
                System.out.println(input);
            }
        };

        example.doSomething(print);
        example.doSomething(anonymousCallback);
        example.doSomething(input -> System.out.println(input)); // callback lambda
        example.doSomething(System.out::println); // callback method reference
    }

    final void doSomething(final Callback callback) {
        final Object result = doSomeBusyWork();
        callback.callMeBack(result);
    }

    @SneakyThrows
    private Object doSomeBusyWork() {
        Thread.sleep(1_000);
        return "OK";
    }

}
