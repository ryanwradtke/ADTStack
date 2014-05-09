/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 * @param <T>
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack;
    private int stackTop;
    private static final int DEFAULT_SIZE = 50;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[capacity];
        stack = tempStack;
        stackTop = stack.length - 1;
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();

        stackTop -= 1;
        stack[stackTop] = newEntry;
    }

    @Override
    public T pop() {
        if (stack[stackTop] != null) {
            T temp = stack[stackTop];
            stack[stackTop] = null;
            stackTop += 1;
            return temp;
        }
        return null;
    }

    @Override
    public T peek() {
        return stack[stackTop];
    }

    @Override
    public boolean isEmpty() {
        return stack[stack.length - 1] == null;
    }

    @Override
    public void clear() {
        stack = null;
        stackTop = stack.length - 1;
    }

    public void ensureCapacity() {
        if (stackTop == 0) {

            //setting stackTop to the appropriate place in the new stack
            stackTop = (stack.length + 1) / 2;
            
            //Declaring a temp stack that is twice the size of the current stack.
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[]) new Object[stack.length * 2];

            //copying the current stack to the end of the temp stack.
            System.arraycopy(stack, 0, tempStack, stackTop, stack.length);

            //referencing the stack variable to tempStack
            stack = tempStack;
        }
    }

}
