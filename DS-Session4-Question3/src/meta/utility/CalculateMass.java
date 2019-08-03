package meta.utility;

import java.util.ArrayList;

public class CalculateMass {
	private String formula;
	private String[] formulaArray;
	private ArrayList<String> formulaList;
	public CalculateMass(String formula) throws Exception {
		this.formula=formula;
		this.formulaArray=this.formula.split("");
		this.formulaList=new ArrayList<String>();
		elementCombiner();
	}
	public int calculateMass() {
		int massOfFormula=0;
		int MASS_OF_CARBON=12;
		int MASS_OF_HYDROGEN=1;
		int MASS_OF_OXYGEN=16;
		for(int indexFirst=0;indexFirst<this.formulaList.size();indexFirst++){
			String element=this.formulaList.get(indexFirst);
			if(element.charAt(0)=='C'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_CARBON;
			}
			if(element.charAt(0)=='H'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_HYDROGEN;
			}
			if(element.charAt(0)=='O'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_OXYGEN;
			}			
		}
		return massOfFormula;
	}
	private void elementCombiner() throws Exception {
		for(int indexFirst=1;indexFirst<this.formulaArray.length;indexFirst++) {
			if(this.formulaArray[indexFirst].equals("C") || this.formulaArray[indexFirst].equals("H") || this.formulaArray[indexFirst].equals("O")) {
				this.formulaList.add(getElementWithItsCoefficient(indexFirst));
			}
			else{
				if(this.formulaArray[indexFirst].equals("(")){
					int indexOfClosingBracket=getIndexOFClosingBracket(indexFirst);
					String coefficient=getNumericCoefficient(indexOfClosingBracket+1);
					indexFirst++;
					while(indexFirst!=indexOfClosingBracket){
						if(this.formulaArray[indexFirst].equals("C") || this.formulaArray[indexFirst].equals("H") || this.formulaArray[indexFirst].equals("O")) {
							String element=getElementWithItsCoefficient(indexFirst);
							this.formulaList.add(element.substring(0,1)+(Integer.toString((Integer.parseInt(element.substring(1)))*(Integer.parseInt(coefficient)))));
						}
						indexFirst++;
					}
				}	
			}
		}
	}
	
	private String getElementWithItsCoefficient(int indexFirst){
		String returnValue="";
		if(indexFirst+1 == this.formulaArray.length || (!(this.formulaArray[indexFirst+1].charAt(0)>='0' && this.formulaArray[indexFirst+1].charAt(0)<='9'))) {
			returnValue= (this.formulaArray[indexFirst]+"1");
		}
		else if((this.formulaArray[indexFirst+1].charAt(0)>='0' && this.formulaArray[indexFirst+1].charAt(0)<='9')){
			String element=this.formulaArray[indexFirst];
			indexFirst++;
			element+=getNumericCoefficient(indexFirst);
			returnValue=(element);
		}
		return returnValue;
	}
	private String getNumericCoefficient(int index){
		String coefficient="";
		while(index!=this.formulaArray.length){
			if(!(this.formulaArray[index].charAt(0)>='0' && this.formulaArray[index].charAt(0)<='9')){
				break;
			}
			else{
				coefficient+=this.formulaArray[index];
				index++;
			}
		}
		return coefficient;
	}
	private int getIndexOFClosingBracket(int indexFirst) throws Exception{
		for(int index=indexFirst;index<this.formulaArray.length;index++){
			if(this.formulaArray[index].equals(")")){
				return index;
			}
		}
		throw new Exception(" ')' bracket Missing");
	}
}
