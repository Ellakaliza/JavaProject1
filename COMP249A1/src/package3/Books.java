package package3;

public class Books extends Items {
	private int numberOfPages;
	public int getNumoPags() {
		return numberOfPages;
	}
	public void setNumoPags(int num) {
		numberOfPages=num;
	}
	public Books(String name, String[] authors, int yearOfPublication, int numpags) {
		super(name,authors,yearOfPublication);
		numberOfPages=numpags;
	}
	public Books(Books books) {
		this(books.name,books.authors,books.yearOfPublication,books.numberOfPages);
	}
	public Books() {
		super();
		numberOfPages=0;
	}
	public String toString() {
		return name+" by "+authors+" was published in "+yearOfPublication+" and has "+numberOfPages+" number of pages.";
	}
	public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Books otherbook = (Books) otherObject;
        boolean b=true;
        if(otherbook.authors.length!=this.authors.length)
        	return false;
        for(int i=0;i<authors.length;i++) {
        	if(!(this.authors[i].equals(otherbook.authors[i]))) {
        		b=false;
        		break;
        	}
        }
        if (name.equals(otherbook.name)&& b&&this.yearOfPublication==otherbook.yearOfPublication&&this.numberOfPages==otherbook.numberOfPages) {
            return true;
        } 
        else {
            return false;
        }
    }
}
