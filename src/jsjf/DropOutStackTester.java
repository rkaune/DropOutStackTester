/*
 * DropOutStackTester.java
 *
 * Richard Kaune T00641439
 * COMP 2231_SW2 Assignment 2 Question 2
 * The DropOutStackTester demonstrates a drop-out stack that behaves like a stack in every respect, except that 
 * when the stack size is n and the n+1 element is pushed, the bottom element is lost.
 */

package jsjf;

/**
 *
 * @author rkaune
 */
public class DropOutStackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // instantiate objects from constructors
        DropOutStack<Integer> dropOutStack = new DropOutStack<Integer>();
        
        // run tests on all methods
        dropOutStack.push(42);
        dropOutStack.push(13);
        dropOutStack.push(27);
        dropOutStack.push(7);
        
        // verify that the 4th push drops the bottom element off the stack
        System.out.println(dropOutStack.toString());
    }
    
}
