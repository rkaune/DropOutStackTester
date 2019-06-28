/*
 * DropOutStack.java
 *
 * Richard Kaune T00641439
 * COMP 2231_SW2 Assignment 2 Question 2
 * The DropOutStack class is the implementation of a drop-out stack that behaves like a stack in every respect, except that 
 * when the stack size is n and the n+1 element is pushed, the bottom element is lost.
 */

package jsjf;

import jsjf.exceptions.*;
//import java.util.Iterator;

/**
 *
 * @author rkaune
 */
public class DropOutStack<T> implements StackADT<T>
{
    private int count;
    private LinearNode<T> top;
    
    // modifications to instance variables of the DropOutStack class
    private final int maxSize = 2; // static size of stack, intending to push 4 or more elements on
    private LinearNode<T> previous;
    private LinearNode<T> current;

    /**
     * Creates an empty stack.
     */
    public DropOutStack()
    {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);
        
        // if the number of elements in the stack is less than the maxSize then add new element to the stack
        if (count < maxSize) 
        {
            temp.setNext(top);
            top = temp;
            count++;
        }
        else if (count >=maxSize && maxSize !=1) // elements in stack are greater than or equal to the maxSize and maxSize is not equal to one
        {
            previous = top;
            current = top.getNext().getNext();
            while (current !=null)
            {
                previous = previous.getNext();
                current = current.getNext();
            }
            previous.setNext(null);
            count --;
            
            push(element);
        }
        else // if maxSize is equal to one
        {
            top.setElement(element);
        }
        
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of this stack.
     * @return string representation of the stack
     */
    public String toString()
    {
        String result = "";
        LinearNode current = top;

        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
