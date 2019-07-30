package test;

import utility.Poly;
import utility.PolyVar;
import utility.Variable;

public class Main {
	public static void main(String[] args) {
		Poly poly = new Poly();
		PolyVar polyVar = new PolyVar(3,'+');
		polyVar.addVariable(new Variable('x',2));
		polyVar.addVariable(new Variable('y',2));
		polyVar.addVariable(new Variable('z',-3));
		System.out.println(poly.addPoly(polyVar));
		polyVar = new PolyVar(2,'-');
		polyVar.addVariable(new Variable('x',1));
		polyVar.addVariable(new Variable('y',2));
		polyVar.addVariable(new Variable('w',-1));
		System.out.println(poly.addPoly(polyVar));
		System.out.println(poly.toPolyString());
		System.out.println(poly.degree());
	}
}
