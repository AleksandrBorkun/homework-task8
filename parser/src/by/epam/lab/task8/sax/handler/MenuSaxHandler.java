package by.epam.lab.task8.sax.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.lab.task8.entity.Dish;
import by.epam.lab.task8.transfer.MenuTagName;

public class MenuSaxHandler extends DefaultHandler {

	private List<Dish> dishList = new ArrayList<>();
	private Dish dish;
	private StringBuilder text;
	private String menuSection;

	public List<Dish> getDishList() {
		return dishList;
	}

	public void startDocumen() throws SAXException {

		System.out.println("Parser started");
	}

	public void endDocumen() throws SAXException {

		System.out.println("Parser ended");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

//		System.out.println("startElement  -> uri: " + uri + ", localName: " + localName + ", qName: " + qName);

		text = new StringBuilder();
		if(qName.equals("menuSection")){
			menuSection = attributes.getValue("dischTypeName");
		}
		if (qName.equals("dish")) {
			dish = new Dish();
			if(menuSection!=null){
				dish.setMenuSection(menuSection);
				menuSection=null;
			}
			dish.setId(Integer.parseInt(attributes.getValue("id")));

		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));

		switch (tagName) {
	//	case MENUSECTION:
		//	if(menuSection.equals(null))
			//	break;
	//		dish.setMenuSection(menuSection.toString());
	//		break;
		case TITLE:
			dish.setTitle(text.toString());
			break;
		case PRICE:
			dish.setPrice(text.toString());
			break;
		case DESCRIPTION:
			dish.setDescription(text.toString());
			break;
		case PORTION:
			dish.setPortion(text.toString());
			break;
		case DISH:
			dishList.add(dish);
			dish = null;
			break;
		}
	}
	
	public void warning(SAXParseException exception){
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}
	public void error(SAXParseException exception){
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXParseException{
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}
	

}
