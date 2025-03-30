package cse2010.hw2;

/*
 * © 2025 CSE2010 HW #2
 *
 * Name: (your name goes here)
 * Student ID: (your student ID goes here)
 *
 * You can modify this class!
 */

/**
 * Main driver class for HW #2
 */
public class PolynomialDriver {

    public static void main(String[] args) {

        /*
         * Construct a polynomial f(x)
         */
        Polynomial f = new DLinkedPolynomial(); // Create an empty list

        f.addTerm(10.0, 8);
        f.addTerm(5.0, 4);
        f.addTerm(3.0, 1);
        f.addTerm(2.0, 3);
        f.addTerm(7.0, 0);

        System.out.println("f(x) = " + f);
        System.out.println("Degree: " + f.getDegree());
        System.out.println("f(10) = " + f.evaluate(10.0));
        System.out.println("Coefficient for 4 is " + f.getCoefficient(4) + "\n");

        /*
         * Construct a polynomial g(x)
         */
        Polynomial g = new DLinkedPolynomial(); // Create an empty list

        g.addTerm(1.0, 1);
        g.addTerm(2.0, 2);
        g.addTerm(3.0, 4);
        g.addTerm(4.0, 0);

        System.out.println("g(x) = " + g);
        System.out.println("Degree: " + g.getDegree());
        System.out.println("g(10) = " + g.evaluate(10.0));
        System.out.println("Coefficient for 4 is " + g.getCoefficient(4) + "\n");

        /*
         * Add f(x) + g(x)
         */

        System.out.print("f(x) + g(x) = ");
        System.out.println(f.add(g));

        /*
         * Multiply f(x) * g(x)
         */

        System.out.print("f(x) * g(x) = ");
        System.out.println(f.mult(g));
    }
}