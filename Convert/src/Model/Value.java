package Model;

public class Value {

	private double val;
	private Unit unit;
	
	public Value(double val, Unit unit) {
		this.setValue(val,unit);
	}
	
	public double getVal() {
		return this.val;
	}	
	public void setVal(double val) {
		this.val = val;
	}
	
	public Unit getUnit() {
		return this.unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public void setValue(double val, Unit unit) {

		this.val = val;
		this.unit = unit;
	}
	
	public SubUnit getPrefixSubUnit() {
		return this.unit.getPrefix();
	}
	public SubUnit getMesureSubUnit() {
		return this.unit.getMesure();
	}
}
