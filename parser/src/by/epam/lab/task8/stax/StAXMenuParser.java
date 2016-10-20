package by.epam.lab.task8.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

import by.epam.lab.task8.entity.Dish;
import by.epam.lab.task8.stax.proc.StAXProcess;

public class StAXMenuParser {

	public static void main(String[] args) throws FileNotFoundException {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		StAXProcess stax = new StAXProcess();

		try {

			InputStream input = new FileInputStream("../by.epam.lab.task8/res/menu-schema.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Dish> menu = stax.process(reader);
			;

			for (Dish dish : menu) {
				if (dish.getMenuSection() != null)
					System.out.println(dish.getMenuSection() + "\n");
				System.out.println(dish.getId() + ") " + dish.getTitle() + "\n" + dish.getDescription());
				System.out.println("Порция:" + dish.getPortion() + "\nЦена:" + dish.getPrice() +"\n");
				;
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}



}
