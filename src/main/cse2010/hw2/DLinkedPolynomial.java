package cse2010.hw2;

/*
 * © 2025 CSE2010 HW #2
 *
 * You can freely modify this class except the signatures of the public methods!!
 */
public class DLinkedPolynomial implements Polynomial {

    private DLinkedList<Term> list = null;

    public DLinkedPolynomial() {
        list = new DLinkedList<>();
    }

    @Override
    public int getDegree() {
        /*
            Complete the code here
         */
        return 0; // you may delete this line
    }

    @Override
    public double getCoefficient(final int expo) {
        Node<Term> term = list.find(new Term(0.0, expo), Term::compareExponents);

        /*
            Complete the code here
         */
        return 0; // you may delete this line
    }

    private Term addTerms(Term x, Term y) {
        return new Term(x.coeff + y.coeff, x.expo);
    }

    @Override
    public Polynomial add(final Polynomial p) {
        /*
            Complete the code here
         */
        return null; // you may delete this line
    }

    private Term multTerms(Term x, Term y) {
        return new Term(x.coeff * y.coeff, x.expo + y.expo);
    }

    @Override
    public Polynomial mult(final Polynomial p) {
        /*
            Complete the code here
         */
        return null; // you may delete this line
    }

    @Override
    public void addTerm(final double coeff, final int expo) {
        /*
            Complete the code here
         */
    }

    @Override
    public void removeTerm(final int expo) {
        Node<Term> node = list.find(new Term(0, expo), Term::compareExponents);

        /*
            Complete the code here
         */
    }

    @Override
    public int termCount() {
        return list.size();
    }

    @Override
    public double evaluate(final double val) {
        /*
            Complete the code here
         */
        return 0; // you may delete this line
    }

    @Override
    public String toString() {
        if (list.isEmpty())
            return "Empty Polynomial";
        else {
            String[] terms = new String[termCount()];
            int i = 0;
            Node<Term> current = list.getFirstNode();
            do {
                if (current.getInfo().expo == 0) {
                    terms[i++] = String.valueOf(current.getInfo().coeff);
                } else if (current.getInfo().expo == 1) {
                    terms[i++] = current.getInfo().coeff + "x";
                } else {
                    terms[i++] = current.getInfo().coeff + "x^" + current.getInfo().expo;
                }
                current = list.getNextNode(current);
            } while (current != null);
            return String.join("+", terms);
        }
    }

}

