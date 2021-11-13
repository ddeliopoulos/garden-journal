package ddeliopoulos.github.example.LinkedListBS;

public class InheritanceExample {

    static class X {}
    static class A extends X{}
    static class B extends X{}

    static void use(X x) {

    }

    public static void main(String[] args) {
        use(new A());
    }
}
