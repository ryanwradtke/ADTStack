/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Testing top = 0 && bottom = stack.length -1 -- the Dynamic Solution.");
        
        StackInterface<String> test = new DynamicArrayStack<>();

        test.push("Hello");
        test.push("GoodBye");
        test.push("How Much");
        test.push("Where is the bathroom");
        test.push("What price tomatoes");

        System.out.println(test.isEmpty());
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.isEmpty());

        System.out.println("Testing bottom = stack.length - 1");
        
        StackInterface<String> test2 = new ArrayStack<>();
        
        for (int i = 0; i < 75; i++) {
            test2.push("test " + i);
        }
        
        test.push("This is the Top");
        
        System.out.println(test.peek());
        System.out.println(test.pop());
//        System.out.println(test.peek());
        
        for (int i = 0; i < 80; i++){
            System.out.println(test2.pop());
        }
        
        for (int i = 0; i < 80; i++) {
            test.push("test " + i);
        }

        for (int i = 0; i < 80; i++) {
            System.out.println(test.pop());
        }
        
        System.out.println(test2.peek());
        System.out.println(test.isEmpty());
        
    }

}
