package package3;

public abstract class Items {
	private String id;
	protected String name;
	protected String[] authors;
	protected int yearOfPublication;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public Items(String name, String[] authors, int yearOfPublication) {
		this.name = name;
		this.authors = authors;
		this.yearOfPublication = yearOfPublication;
	}
	public Items() {
		this("",null,0);
	}
	public Items(Items items) {
		this(items.name,items.authors,items.yearOfPublication);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
