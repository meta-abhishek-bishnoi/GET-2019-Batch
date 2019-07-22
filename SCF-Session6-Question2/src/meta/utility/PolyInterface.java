package meta.utility;

public interface PolyInterface {
	public double evalute(Polynomial poly, int value);
	public int degree(Polynomial poly);
	public int[][] addPolynomial(Polynomial polyOne, Polynomial polyTwo);
	public int[][] multiplyPolynomial(Polynomial polyOne, Polynomial polyTwo);
}
