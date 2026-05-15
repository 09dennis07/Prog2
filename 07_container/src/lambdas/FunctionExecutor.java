package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionExecutor {
    private int value;

    public FunctionExecutor(int value) {
        this.value = value;
    }
    public Double exec(Function<Integer,Double> lambda) {
        return lambda.apply(value);
    }
    
    public Double exec(BiFunction<Integer,Integer, Double> lambda, Integer value2) {
        return lambda.apply(value,value2);
    }

    public static void main(String[] args) {
        FunctionExecutor executor = new FunctionExecutor(12);
        double res1 = executor.exec(x -> 1+ Math.sqrt(x)); // typeless param
        System.out.println(res1);
        double res2 = executor.exec((Integer x) -> 1.0 + x); // typed param
        System.out.println(res2);
        double res3 = executor.exec((x,y) -> 1.0 + x + y, 3); // two params
        System.out.println(res3);
        Supplier<Integer> lambda = () -> 32; // no param
        int res4 = lambda.get();
        System.out.println(res4);
        double res5 = executor.exec(x -> { double r = 1.0 + x; return r; }); // block as body
        System.out.println(res5);
        
        // Runnable as functional interface
        new Thread(() -> { System.out.println("executing lambda: " + Thread.currentThread()); }).start();
        
        // variable binding
        double factor = 3.14;
        Function<Integer,Double> lambdaWithVarBinding = x -> factor * x;
        double res6 = executor.exec(lambdaWithVarBinding);
        System.out.println(res6);
        // factor = 3; // compiler error
        
        double res7 = executor.exec(Math::sqrt);
        System.out.println(res7);
        
        //function and constructor references
        Function<String,StringBuilder> lambda3 = StringBuilder::new;
        StringBuilder sb = lambda3.apply("Hallo").append(" Welt");
        System.out.println(sb);
        
    }
}
