package ddeliopoulos.github.example.callbacks;

public class PrintingCallback implements Callback {

    @Override
    public void callMeBack(Object input) {
        System.out.println(input);
    }

}
