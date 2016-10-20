package by.epam.lab.task8.sax;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.lab.task8.entity.Dish;
import by.epam.lab.task8.sax.handler.MenuSaxHandler;

public class SaxDemo {
	
	public static void main(String[] args) throws SAXException, IOException {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MenuSaxHandler handler = new MenuSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("../by.epam.lab.task8/res/menu-schema.xml"));

		
		reader.setFeature("http://xml.org/sax/features/validation", true);
		
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		
		List<Dish> menu = handler.getDishList();
		
		for(Dish dish: menu){
			if(dish.getMenuSection()!=null)
				System.out.println("\t" + dish.getMenuSection());
			System.out.println("\n"+dish.getId() +") " + dish.getTitle() +"\n"+dish.getDescription()+ "\nПорция: " + dish.getPortion() +"\nЦена: " + dish.getPrice() + "\n");
			
		}
	}

}
