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

    /**
     * Constructor to create a Term object with given coefficient and exponent.
     *
     * @param coeff coefficient of the term
     * @param expo  exponent of the term
     */
    public Term(double coeff, int expo) {
        this.coeff = coeff;
        this.expo = expo;
    }

    /**
     * Compares the exponents of two Term objects.
     *
     * @param t1 first term
     * @param t2 second term
     * @return -1 if t1.expo < t2.expo,
     * 0 if t1.expo == t2.expo,
     * 1 if t1.expo > t2.expo
     */
    public static int compareExponents(Term t1, Term t2) {
        return Integer.compare(t1.expo, t2.expo);
    }

    /**
     * Compares the coefficients of two Term objects.
     *
     * @param t1 first term
     * @param t2 second term
     * @return -1 if t1.coeff < t2.coeff,
     * 0 if t1.coeff == t2.coeff,
     * 1 if t1.coeff > t2.coeff
     */
    public static int compareCoefficients(Term t1, Term t2) {
        return Double.compare(t1.coeff, t2.coeff);
    }

    /**
     * Compares two Term objects based on their exponents and coefficients.
     * Compares the exponents first, and if they are equal, compares the coefficients.
     *
     * @param t1 first term
     * @param t2 second term
     * @return -1 if t1 < t2,
     * 1 if t1 > t2,
     * 0 if t1 == t2,
     */
    public static int compare(Term t1, Term t2) {
        return switch (Integer.compare(t1.expo, t2.expo)) {
            case 1 -> 1;
            case -1 -> -1;
            default -> Double.compare(t1.coeff, t2.coeff);
        };
    }

    /**
     * Compares this Term object with another object for equality.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Term term))
            return false;
        return Double.compare(term.coeff, coeff) == 0 &&
                expo == term.expo;
    }

    /**
     * Returns a string representation of the Term object.
     *
     * @return a string representation of the Term object
     */
    @Override
    public String toString() {
        return "Term{" +
                "coeff=" + coeff +
                ", expo=" + expo +
                '}';
    }
}
