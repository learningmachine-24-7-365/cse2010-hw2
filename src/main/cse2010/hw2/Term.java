package cse2010.hw2;

/*
 * © 2025 CSE2010 HW #2
 *
 * DO NOT MODIFY THIS CLASS!
 */
public class Term {
    /*
     * Public fields are bad idea. But, for the sake of simplicity, we will use them here.
     */
    public double coeff;    // coefficient
    public int expo;    // exponent

    public Term(double coeff, int expo) {
        this.coeff = coeff;
        this.expo = expo;
    }

    public static int compareExponents(Term t1, Term t2) {
        return Integer.compare(t1.expo, t2.expo);
    }

    public static int compareCoefficients(Term t1, Term t2) {
        return Double.compare(t1.coeff, t2.coeff);
    }

    public static int compare(Term t1, Term t2) {
        return switch (Integer.compare(t1.expo, t2.expo)) {
            case 1 -> 1;
            case -1 -> -1;
            default -> Double.compare(t1.coeff, t2.coeff);
        };
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Term term))
            return false;
        return Double.compare(term.coeff, coeff) == 0 &&
                expo == term.expo;
    }

    @Override
    public String toString() {
        return "Term{" +
                "coeff=" + coeff +
                ", expo=" + expo +
                '}';
    }
}
