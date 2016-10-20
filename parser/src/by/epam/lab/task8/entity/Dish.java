package by.epam.lab.task8.entity;

public class Dish {

	private int id;
	private String title;
	private String price;
	private String description;
	private String portion;
	private String picture;
	private String menuSection;
	
	public String getMenuSection() {
		return menuSection;
	}
	public void setMenuSection(String menuSection) {
		this.menuSection = menuSection;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPortion() {
		return portion;
	}
	public void setPortion(String portion) {
		this.portion = portion;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	}
