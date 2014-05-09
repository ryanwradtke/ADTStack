

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
public class DynamicArrayStack<T> implements StackInterface<T> {

    private T[] stack;
    private static final int DEFAULT_SIZE = 1;

    public DynamicArrayStack() {
        this(DEFAULT_SIZE);
    }

    public DynamicArrayStack(int capacity) {
        // the cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[capacity];
        stack = tempStack;
    }

    /**
     * Dynamically increases size of stack as objects are pushed onto stack.
     *
     * @param newEntry
     * @return
     */
    @Override
    public void push(T newEntry) {
        //Declaring a temporary stack that is one index larger than stack.
        T[] tempStack = (T[]) new Object[stack.length + 1];
        
        //Stores the new entry at index 0, the top of the list.
        tempStack[0] = newEntry;

        //Copies the references to all indices in stack.
        if (stack[0] != null) {
            
            System.arraycopy(stack, 0, tempStack, 1, stack.length);
            
            for (int i = 0; i < stack.length; i++) {
                tempStack[i + 1] = (stack[i]);
            }
        }
        
        //references stack to tempStack.
        stack = tempStack;
    }

    /**
     * Dynamically reduces stack size as objects are taken off of the stack.
     *
     * @return
     */
    @Override
    public T pop() {
        
        //Declares temp, the return variable, and references it to the top of the stack.
        T temp = stack[0];

        //Declares a temporary stack that is one index smaller than stack.
        T[] tempStack = (T[]) new Object[stack.length - 1];

        //copies the references to all indices in stack.
        for (int i = 0; i < stack.length - 1; i++) {
            tempStack[i] = stack[i + 1];
        }

        //references stack to tempStack
        stack = tempStack;

        return temp;
    }

    @Override
    public T peek() {
        return stack[0];
    }

    @Override
    public boolean isEmpty() {
        return stack[0] == null;
    }

    @Override
    public void clear() {
        stack = null;
    }
}
