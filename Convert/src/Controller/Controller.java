package Controller;

import java.util.ArrayList;

import Model.*;
import View.*;

public class Controller {

	private Value inValue;
	private Value outValue;
	private ConvertFrame view;
	private Conversion conversion;
	private ErrorFrame errorFrame;
	
	public Controller(String fileName, int initVal, SubUnit inPrefix, SubUnit inMesure, SubUnit outPrefix, SubUnit outMesure) {
		this(fileName);
		this.initializeValue(initVal, inPrefix, inMesure, outPrefix, outMesure);
	}
	
	public Controller(String fileName) {
		this.view=new ConvertFrame();
		this.errorFrame = new ErrorFrame();
		
		try {
			this.conversion = new Conversion(fileName);
			this.initializeValue(0, this.conversion.getBasePrefixUnit(), this.conversion.getBaseMesure(), this.conversion.getBasePrefixUnit(), this.conversion.getBaseMesure());
		} catch (Exception e) {
			this.errorFrame.showError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.view.buildFrame(this);
		this.setValueOnView();
	}
	
	private void initializeValue(int initVal, SubUnit inPrefix, SubUnit inMesure, SubUnit outPrefix, SubUnit outMesure) {
		this.inValue = new Value(initVal, new Unit(inPrefix, inMesure));
		this.outValue = conversion.convertTo(this.inValue, new Unit(outPrefix, outMesure));
	}
	
	public void convertion() {
		this.getValueFromView();
		this.outValue=this.conversion.convertTo(this.inValue, this.outValue.getUnit());
		if(this.outValue==null) {
			this.errorFrame.showError("Il y a un problème lors de la convertion");
			return;
		}
		
		this.setValueOnView();
	}
	
	public void getValueFromView() {
		String textFieldValue=this.view.getInTextField();
		Unit inUnit = this.view.getSelectedInOptionsUnit();
		inValue.setValue(Double.parseDouble(textFieldValue), inUnit);
		
		outValue.setUnit(this.view.getSelectedOutOptionsUnit());
	}
	
	public void setValueOnView() {
		this.view.setInTextField(Double.toString(this.inValue.getVal()));
		this.view.setSelectedInOptionsUnit(this.inValue.getUnit());
		
		this.view.setOutTextField(Double.toString(this.outValue.getVal()));
		this.view.setSelectedOutOptionsUnit(this.outValue.getUnit());
		this.errorFrame.hideError();
	}
	
	public ArrayList<Unit> getUnitsMap(){
		return this.conversion.getUnitsMap();
	}
}
