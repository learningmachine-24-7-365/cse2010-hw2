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
        if (list.isEmpty()) {
            return 0; 
        }

        Node<Term> current = list.getFirstNode(); 
        int maxDegree = Integer.MIN_VALUE; 

        while (current != null) {
            maxDegree = Math.max(maxDegree, current.getInfo().expo); 
            current = list.getNextNode(current); 
        }

        return maxDegree;
    }

    @Override
    public double getCoefficient(final int expo) {
        Node<Term> term = list.find(new Term(0.0, expo), Term::compareExponents);
        double result = term != null ? term.getInfo().coeff : 0.0; // 해당 차수의 계수를 찾음

        return result;
    }

    private Term addTerms(Term x, Term y) {
        return new Term(x.coeff + y.coeff, x.expo);
    }

    @Override
    public Polynomial add(final Polynomial p) {
        DLinkedPolynomial evalResult = new DLinkedPolynomial();
        Node<Term> current = list.getFirstNode();

        // Add terms from the current polynomial
        while (current != null) {
            Term term = current.getInfo();
            evalResult.addTerm(term.coeff, term.expo);
            current = list.getNextNode(current);
        }

        // Add terms from the input polynomial
        for (int i = 0; i <= p.getDegree(); i++) {
            double coeff = p.getCoefficient(i);
            if (coeff != 0) {
                evalResult.addTerm(coeff, i);
            }
        }

        return evalResult;
    }

    private Term multTerms(Term x, Term y) {
        return new Term(x.coeff * y.coeff, x.expo + y.expo);
    }

    @Override
    public Polynomial mult(final Polynomial p) {
        DLinkedPolynomial evalResult = new DLinkedPolynomial();
        Node<Term> current = list.getFirstNode();

        // Multiply each term of the current polynomial with each term of the input polynomial
        while (current != null) {
            Term term1 = current.getInfo();
            for (int i = 0; i <= p.getDegree(); i++) {
                double coeff2 = p.getCoefficient(i);
                if (coeff2 != 0) {
                    Term product = multTerms(term1, new Term(coeff2, i));
                    evalResult.addTerm(product.coeff, product.expo);
                }
            }
            current = list.getNextNode(current);
        }

        return evalResult;
    }

    @Override
    public void addTerm(final double coeff, final int expo) {
        if (coeff == 0) return;

        Term newTerm = new Term(coeff, expo);
        Node<Term> current = list.getFirstNode();

        while (current != null) {
            int compareCoeff = Integer.compare(current.getInfo().expo, expo);

            if (compareCoeff == 0) { 
                double newCoeff = current.getInfo().coeff + coeff;
                if (newCoeff == 0) {
                    list.remove(current);
                } else {
                    current.getInfo().coeff = newCoeff; 
                }
                return;
            } else if (compareCoeff < 0) {
                list.addBefore(current, new Node<>(newTerm, null, null));
                return;
            }

            current = list.getNextNode(current);
        }

        list.addLast(new Node<>(newTerm, null, null));
    }

    @Override
    public void removeTerm(final int expo) {
        Node<Term> node = list.find(new Term(0, expo), Term::compareExponents);
    
        if (node != null) list.remove(node);
        else throw new NoSuchTermExistsException(expo + "차 항이 존재하지 않습니다."); // No such term exists
    }

    @Override
    public int termCount() {
        return list.size();
    }

    @Override
    public double evaluate(final double val) {
        double evalResult = 0.0;
        Node<Term> current = list.getFirstNode();

        while (current != null) {
            Term term = current.getInfo();
            evalResult += term.coeff * Math.pow(val, term.expo);
            current = list.getNextNode(current);
        }

        return evalResult;
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

