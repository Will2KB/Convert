package Model;

public record Unit (SubUnit prefix, SubUnit sufix, double convertValue) {
	public String toString() {
		return this.prefix.symbol() + this.sufix.symbol();
	}
	
	public Unit(SubUnit prefix, SubUnit sufix) {
		this(prefix, sufix, 0);
	}
}

/*public class Unit {
	
//	public enum PrefixUnits {KILO, HECTO, DECA, NONE, DECI, CENTI, MILI};
//	public enum Mesure {GRAMME, LITER, CUBE}
	
	private SubUnit prefix;
	private SubUnit sufix; 
	private double convertValue=0;
	
	public Unit(SubUnit prefix, SubUnit sufix) {
		this.prefix = prefix;
		this.sufix = sufix;
	}
	
	public String getUnit() {
		return this.prefix.symbol() + this.sufix.symbol();
	}	
	public void setUnit(SubUnit prefix, SubUnit sufix) {
		this.prefix = prefix;
		this.sufix = sufix;
	}
	
	public SubUnit getPrefix() {
		return this.prefix;
	}
	
	public SubUnit getMesure() {
		return this.sufix;
	}
	
	public double getConvertValue() {
		return convertValue;
	}
//	public void setConvertValue(double value) {
//		this.convertValue = value;
//	}
	
	public String toString() {
		return getUnit();
	}
}*/
