import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class CustomStack implements Iterable<Integer> {
    private Stack<Integer> stack;

    public CustomStack() {
        this.stack = new Stack<>();
    }

    public void push(Integer element) {
        stack.push(element);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("No elements");
        }
        return stack.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomStackIterator(stack);
    }

    private class CustomStackIterator implements Iterator<Integer> {
        private Stack<Integer> tempStack;

        public CustomStackIterator(Stack<Integer> stack) {
            this.tempStack = (Stack<Integer>) stack.clone(); // Clone the stack to iterate without mutation
        }

        @Override
        public boolean hasNext() {
            return !tempStack.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return tempStack.pop();
        }
    }


}
