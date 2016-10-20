package by.epam.lab.task8.transfer;

public enum MenuTagName {

	TITLE, PRICE, DESCRIPTION, PORTION, PICTURE, COLDSNACK, DISH, MENU, MENUSECTION;
	
	public static MenuTagName getElementTagName(String element) {

		switch (element) {
		case "dish":
			return DISH;
		case "price":
			return PRICE;
		case "description":
			return DESCRIPTION;
		case "portion":
			return PORTION;
		case "title":
			return TITLE;
		case "coldSnack" :
			return COLDSNACK;
		case "menu":
			return MENU;
		case "picture":
			return PICTURE;
		case "menuSection":
			return MENUSECTION;
			default:
				throw new EnumConstantNotPresentException(MenuTagName.class, element);
		}

	}

	
}
