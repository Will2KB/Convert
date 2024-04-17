package Controller;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Model.*;

public class Conversion {

	private SubUnit basePrefixUnit;
	private SubUnit baseMesure;
	private ArrayList<Unit> unitsList;
	
	public Conversion(String fileName) throws Exception{
		super();
		this.loadConfigFile(fileName);
	}
	
	private void loadConfigFile(String fileName) throws Exception {
		File xmlFile = new File(fileName);
		
		this.unitsList = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        doc.getDocumentElement().normalize();
	       
        ArrayList<SubUnit> mesureList = loadSubUnits(doc, "mesure");
        ArrayList<SubUnit> prefixUnitsList = loadSubUnits(doc, "prefixunits");
        		
        for(SubUnit mesure: mesureList) {        	
        	if(mesure.getConvertionValue()==1)
        		this.baseMesure=mesure;
        	
        	for(SubUnit prefixUnit:prefixUnitsList) {        		
        		if(prefixUnit.getConvertionValue()==1)
        			this.basePrefixUnit=prefixUnit;
        		
        		this.unitsList.add(new Unit(prefixUnit, mesure));
        	}
        }
        
        if(this.baseMesure == null || this.basePrefixUnit == null) 
        	throw new ConfigException();

	}
	
	private ArrayList<SubUnit> loadSubUnits(Document doc, String tagName) throws Exception{
		ArrayList<SubUnit> listSubUnits = new ArrayList<>();
		
		NodeList nodeList = doc.getElementsByTagName(tagName);
		
		for (int i = 0; i < nodeList.getLength(); i = i + 1) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
               
                // Récupère l'élément
                Element element = (Element)node;
                String subUnitName = element.getElementsByTagName("name").item(0).getTextContent();
                String subUnitSymbol = element.getElementsByTagName("symbol").item(0).getTextContent();
                String subUnitConvertionValue = element.getElementsByTagName("convert").item(0).getTextContent();
                
                SubUnit subUnit = new SubUnit(subUnitName, subUnitSymbol, Double.parseDouble(subUnitConvertionValue));
                listSubUnits.add(subUnit);
            }
            
        }
		
		return listSubUnits;
	}
	
	public double getConversionForSubUnit(SubUnit subUnit) {
		return subUnit.getConvertionValue();
	}
	
	public boolean isEqualMesure(SubUnit subUnit1, SubUnit subUnit2) {
		return subUnit1.equals(subUnit2);
	}
	
	public Value convertTo (Value inValue, Unit outUnit) {
		try {
			double baseUnitConversion = this.getConversionForSubUnit(inValue.getPrefixSubUnit());
			double baseMesureConversion = this.getConversionForSubUnit(inValue.getMesureSubUnit());
			double unitConversion = this.getConversionForSubUnit(outUnit.getPrefix());
			double mesureConversion = this.getConversionForSubUnit(outUnit.getMesure());
			double outVal= ((inValue.getVal()/(baseUnitConversion*baseMesureConversion))*unitConversion*mesureConversion);
			
			return new Value(outVal, outUnit);
		} catch ( Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public SubUnit getBasePrefixUnit() {
		return this.basePrefixUnit;
	}
	public SubUnit getBaseMesure(){
		return this.baseMesure;
	}
	
	public ArrayList<Unit> getUnitsMap(){
		return this.unitsList;
	}
	
}
