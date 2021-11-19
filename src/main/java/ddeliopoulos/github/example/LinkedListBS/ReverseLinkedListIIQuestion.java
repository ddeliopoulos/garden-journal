package ddeliopoulos.github.example.LinkedListBS;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ReverseLinkedListIIQuestion {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int oneIndexedLeft, int oneIndexedRight) {
        if (head == null) return null;

        final int left = oneIndexedLeft - 1;
        final int right = oneIndexedRight - 1;

        ListNode current = head;
        final List<ListNode> listOfNodes = new ArrayList<>();
        while (current != null) {
            listOfNodes.add(current);
            current = current.next;
        }

        for (int l = left, r = right; l < r; ++l, --r) {
            swap(l, r, listOfNodes::get, listOfNodes::set);
        }
        final ListNode newHead = new ListNode(listOfNodes.get(0).val);
        current = newHead;

        for (int i = 1; i < listOfNodes.size(); ++i) {
            final ListNode newCurrent = new ListNode(listOfNodes.get(i).val);
            current.next = newCurrent;
            current = newCurrent;
        }

        return newHead;
    }

    public static <T> void swap(final int firstIndex,
                                final int secondIndex,
                                final Function<Integer, T> getter,
                                final BiConsumer<Integer, T> setter) {
        final T tmp = getter.apply(firstIndex);
        setter.accept(firstIndex, getter.apply(secondIndex));
        setter.accept(secondIndex, tmp);
    }

    //                             T
    //                             R
    //answer = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 +
    //                        ^----------------+

    //                #
    // 4 -> 5 -> 6 -> 7 -> 1 -> 2 -> 3

    // [1, 2, 3, 4, 0, 0, 0, 0]
    // [1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    // [0, 0, 0, 0, 0]
    // [1, 2, 0, 3, 4]
    // [1, 2, bla, 3, 4]


    public static void main(String[] args) {
        final SingleLinkedListNode<Integer> head = SingleLinkedListNode.of(1, 2, 3, 4, 5, 6, 7);

        SingleLinkedListNode<Integer> current = head;
        SingleLinkedListNode<Integer> beforeCurrent = null;
        while (current.getValue() != 4) {
            beforeCurrent = current;
            current = current.getNext();
        }

        SingleLinkedListNode<Integer> newHead = current;
        beforeCurrent.setNext(null);

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(head);
    }
}

