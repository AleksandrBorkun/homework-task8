package by.epam.lab.task8.stax.proc;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.lab.task8.entity.Dish;
import by.epam.lab.task8.transfer.MenuTagName;

public class StAXProcess {

	public List<Dish> process(XMLStreamReader reader) throws XMLStreamException {

		String menuSection = null;
		List<Dish> menu = new ArrayList<>();
		Dish dish = null;
		MenuTagName elementName = null;
		while (reader.hasNext()) {

			// определение типа прочтенного эл-та

			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = MenuTagName.getElementTagName(reader.getLocalName());

				switch (elementName) {
				case MENUSECTION:
					menuSection = (reader.getAttributeValue(null, "dischTypeName"));
					break;
				}

				switch (elementName) {

				case DISH:
					dish = new Dish();
					Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					dish.setId(id);
					if (menuSection != null) {
						dish.setMenuSection(menuSection);
						menuSection = null;
					}
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}

				switch (elementName) {

				case TITLE:
					dish.setTitle(text);
					break;
				case PRICE:
					dish.setPrice(text);
					break;
				case DESCRIPTION:
					dish.setDescription(text);
					break;
				case PORTION:
					dish.setPortion(text);
					break;

				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = MenuTagName.getElementTagName(reader.getLocalName());

				switch (elementName) {

				case DISH:
					menu.add(dish);
				}

			}

		}
		return menu;
	}
	
}
