package ddeliopoulos.github.example.LinkedListBS;

import com.google.common.base.Objects;
import lombok.Getter;

import static ddeliopoulos.github.example.LinkedListBS.ListNodeNameGenerator.generateName;
import static lombok.AccessLevel.PACKAGE;

@Getter
public final class SingleLinkedListNode<Value> {

    @SafeVarargs
    public static <Value> SingleLinkedListNode<Value> of(final Value... values) {
        final SingleLinkedListNode<Value> head = new SingleLinkedListNode<>(values[0], null, false);
        SingleLinkedListNode<Value> current = head;
        for (int i = 1; i < values.length; ++i) {
            final SingleLinkedListNode<Value> newNode = new SingleLinkedListNode<>(values[i], null, false);
            newNode.previous = current;
            current.next = newNode;
            current = newNode;
        }
        SingleLinkedListNodeObserver.onListCreated(head);
        return head;
    }

    @Getter(PACKAGE)
    private final String name = generateName();

    private Value value;
    private SingleLinkedListNode<Value> next;
    private SingleLinkedListNode<Value> previous;

    public SingleLinkedListNode(final Value value) {
        this(value, null);
    }

    public SingleLinkedListNode(final Value value, final SingleLinkedListNode<Value> next) {
        this(value, next, true);
    }

    private SingleLinkedListNode(final Value value, final SingleLinkedListNode<Value> next, final boolean observe) {
        this.value = value;

        if (observe) SingleLinkedListNodeObserver.onNodeCreated(this);
        if (next != null) {
            if (observe) setNext(next);
            else this.next = next;
        }
    }

    public void setValue(final Value value) {
        final Value oldValue = this.value;
        this.value = value;
        SingleLinkedListNodeObserver.onNodeValueSet(this, oldValue, this.value);
    }

    public void setNext(final SingleLinkedListNode<Value> next) {
        final SingleLinkedListNode<Value> oldNext = this.next;
        if (oldNext != null) oldNext.previous = null;
        if (next != null) next.previous = this;
        this.next = next;
        SingleLinkedListNodeObserver.onNodeNextSet(this, oldNext, this.next);
    }

    boolean isHead() {
        return previous == null;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        final SingleLinkedListNode<?> that = (SingleLinkedListNode<?>) other;

        return Objects.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}