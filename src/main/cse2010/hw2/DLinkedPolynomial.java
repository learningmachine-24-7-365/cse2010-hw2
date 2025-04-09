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
            return 0; // 링크드 리스트가 비어 있으면 0을 반환함. 
        }

        int maxDegree = Integer.MIN_VALUE; // 초기값을 최소값으로 설정
        Node<Term> current = list.getFirstNode(); // 리스트의 첫 번째 노드부터 시작

        while (current != null) {
            maxDegree = Math.max(maxDegree, current.getInfo().expo); // 현재 노드의 차수와 최대 차수를 비교하여 최대값을 업데이트
            current = list.getNextNode(current); // 다음 노드로 이동
        }

        return maxDegree; // 최대 차수를 반환   
    }

    @Override
    public double getCoefficient(final int expo) {
        Node<Term> term = list.find(new Term(0.0, expo), Term::compareExponents);

        if (term != null) {
            return term.getInfo().coeff; // 해당 차수의 계수를 반환
        }
        else return 0; // you may delete this line
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
        if (coeff == 0) return; // 계수가 0이면 추가할 필요 없음

        Term newTerm = new Term(coeff, expo);
        Node<Term> current = list.getFirstNode();

        while (current != null) {
            int compareCoeff = Integer.compare(current.getInfo().expo, expo);

            if (compareCoeff == 0) { 
                double newCoeff = current.getInfo().coeff + coeff;
                if (newCoeff == 0) {
                    list.remove(current); // 계수가 0이 되면 제거
                } else {
                    current.getInfo().coeff = newCoeff; // 계수 업데이트
                }
                return;
            } else if (compareCoeff < 0) {
                // 현재 항의 차수가 작으면 그 전에 삽입해야 하므로 이전에 추가
                list.addBefore(current, new Node<>(newTerm, null, null));
                return;
            }

            current = list.getNextNode(current);
        }

        // 끝까지 가도 못 찾으면 마지막에 추가
        list.addLast(new Node<>(newTerm, null, null));
    }

    @Override
    public void removeTerm(final int expo) {
        // 특정 차수의 항을 찾음
        Node<Term> node = list.find(new Term(0, expo), Term::compareExponents);
    
        // 해당 항이 존재하면 리스트에서 제거
        if (node != null) {
            list.remove(node);
        }
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
            evalResult += term.coeff * Math.pow(val, term.expo); // 계산: 계수 * (val^차수)
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

