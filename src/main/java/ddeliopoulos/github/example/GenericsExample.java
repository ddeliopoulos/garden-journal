package ddeliopoulos.github.example;

public class GenericsExample {

    public static void main(String[] args) {
        List<String> myList = new List<>();
        List<Integer> myListOfInts = new List<>();
        myList.add("bla");
        myListOfInts.add(123);
        System.out.println(myList.get(0));

        Base[] emptyArray = GenericsExample.createArrayWithElement(new Base());
        Child[] emptyArray2 = GenericsExample.createArrayWithElement(new Child());
    }

    static class Base {
        void bla() {
            System.out.println("test");
        }
    }
    static final class Child extends Base {
        @Override
        void bla() {
            System.out.println("la");
        }
    }
    static final class Orphan {}

    public static <MethodsGenericType extends Base> MethodsGenericType[] createArrayWithElement(MethodsGenericType element) {
        @SuppressWarnings("unchecked")
        MethodsGenericType[] a = (MethodsGenericType[]) new Base[1];
        a[0] = element;
        element.bla();
        return a;
    }


    public static final class List<MyFancyTypeInsideTheList> {

        @SuppressWarnings("unchecked")
        private MyFancyTypeInsideTheList[] array = (MyFancyTypeInsideTheList[]) new Object[0];

        void add(final MyFancyTypeInsideTheList input) {
            @SuppressWarnings("unchecked")
            MyFancyTypeInsideTheList[] newArray = (MyFancyTypeInsideTheList[]) new Object[array.length + 1];
            for (int i = 0; i < array.length; ++i) {
                newArray[i] = array[i];
            }
            newArray[array.length] = input;
            array = newArray;
        }

        MyFancyTypeInsideTheList get(int index) {
            return array[index];
        }

    }

}
