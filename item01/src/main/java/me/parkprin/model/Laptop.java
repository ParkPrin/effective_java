package me.parkprin.model;

public class Laptop {
	private Long id;
	private String model;
	private String company;

	// 생성자
	private Laptop() {}

	public Laptop(String model, String company) {
		this.model = model;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	// 이름을 가진 static Factory Method

	// 매개변수 하나일 때 from
	// 여러 속성을 지니고 있는 객체 LaptopForm를 convert한다.
	public static Laptop from(LaptopForm laptopForm) {
		Laptop laptop = new Laptop();
		laptop.model = laptopForm.getModel();
		laptop.company = laptopForm.getCompany();
		return laptop;
	}

	// 여러 매개변수를 직접 바인딩 될때 of
	public static Laptop ofModelAndCompany(String model, String company) {
		Laptop laptop = new Laptop();
		laptop.model = model;
		laptop.company = company;
		return laptop;
	}
}
