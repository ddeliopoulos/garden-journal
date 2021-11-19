package ddeliopoulos.github.example.LinkedListBS;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SingleLinkedListNodeObserver {

    private final static Set<SingleLinkedListNode<?>> ALL_NODES = new HashSet<>();

    static void onListCreated(final SingleLinkedListNode<?> head) {
        SingleLinkedListNode<?> current = head;
        while (current != null) {
            ALL_NODES.add(current);
            current = current.getNext();
        }
        visualize("list with head " + head.getName() + " has been created");
    }

    static void onNodeCreated(final SingleLinkedListNode<?> node) {
        ALL_NODES.add(node);
        visualize("node " + node.getName() + " has been created");
    }

    static void onNodeValueSet(final SingleLinkedListNode<?> node,
                               final Object oldValue,
                               final Object newValue) {
        visualize("node " + node.getName() + " value changed from " + oldValue + " to " + newValue);
    }

    static void onNodeNextSet(final SingleLinkedListNode<?> node,
                              final SingleLinkedListNode<?> oldNext,
                              final SingleLinkedListNode<?> newNext) {
        visualize("node " + node.getName() + " next changed from " + oldNext + " to " + newNext);
    }

    private static void visualize(final String message) {
        System.out.println(message);

        final Set<SingleLinkedListNode<?>> nodesVisualized = new HashSet<>();
        Consumer<SingleLinkedListNode<?>> markVisualized = node -> {
            if (nodesVisualized.contains(node)) {
                throw new IllegalStateException("node " + node.getName() + " is already visualized (circular reference?)");
            } else {
                nodesVisualized.add(node);
            }
        };

        ALL_NODES.stream()
                 .filter(SingleLinkedListNode::isHead)
                 .sorted(comparing(SingleLinkedListNode::getName))
                 .forEach(head -> {
                     SingleLinkedListNode<?> current = head;
                     final StringBuilder builder = new StringBuilder("\t");
                     while (current != null) {
                         markVisualized.accept(current);
                         builder.append(current.getName())
                                .append('(')
                                .append(current.getValue())
                                .append(") -> ");
                         current = current.getNext();
                     }
                     builder.append("null");
                     System.out.println(builder);
                 });

        System.out.println();

        if (!nodesVisualized.equals(ALL_NODES)) {
            throw new IllegalStateException("not all nodes were visualized! circular reference?");
        }
    }
}
