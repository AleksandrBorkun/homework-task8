package by.epam.lab.task8.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import by.epam.lab.task8.entity.Dish;

public class XMLDOMParser {

	public static void main(String[] args) throws SAXException, IOException {

		DOMParser parser = new DOMParser();
		parser.parse("..\\by.epam.lab.task8\\res\\menu-schema.xml");
		Document document = parser.getDocument();

		Element root = document.getDocumentElement();

		List<Dish> menu = new ArrayList<>();

		NodeList menuSections = root.getElementsByTagName("menuSection");

		// System.out.println(menuSections.getLength());
		Dish dish = null;

		for (int i = 0; i < menuSections.getLength(); i++) {
			NodeList foodNodes = null;
			Element category = (Element) menuSections.item(i);
			System.out.println("\n\t\t" + category.getAttribute("dischTypeName") + "\n");
			foodNodes = category.getElementsByTagName("dish");

			for (int k = 0; k < foodNodes.getLength(); k++) {
				dish = new Dish();
				Element foodElement = (Element) foodNodes.item(k);

				dish.setId(Integer.parseInt(foodElement.getAttribute("id")));
				dish.setTitle(getSingleChild(foodElement, "title").getTextContent().trim());
				dish.setDescription(getSingleChild(foodElement, "description").getTextContent().trim());
				dish.setPortion(getSingleChild(foodElement, "portion").getTextContent().trim());
				dish.setPrice(getSingleChild(foodElement, "price").getTextContent().trim());
				menu.add(dish);
			}

			for (Dish item : menu) {
				System.out.println(item.getId() + ") " + item.getTitle() + "\n" + item.getDescription() + "\nПорция: "
						+ item.getPortion() + "\nЦена: " + item.getPrice() + "\n");
			}
			menu.clear();
		}

		// System.out.println(dish.getMenuSection());

	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element) nList.item(0);
		return child;
	}

}
