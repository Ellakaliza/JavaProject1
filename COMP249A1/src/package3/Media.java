package package3;

public class Media extends Items {
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public Media(String name, String[] authors, int yearOfPublication, String type) {
		super(name,authors,yearOfPublication);
		this.type=type;
	}
	public Media(Media med) {
		this(med.name,med.authors,med.yearOfPublication,med.type);
	}
	public Media() {
		super();
		type="";
	}
	public String toString() {
		return name+" by "+authors+" was published in "+yearOfPublication+" and is a(n) "+type;
	}
	public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Media otherbook = (Media) otherObject;
        boolean b=true;
        if(otherbook.authors.length!=this.authors.length)
        	return false;
        for(int i=0;i<authors.length;i++) {
        	if(!(this.authors[i].equals(otherbook.authors[i]))) {
        		b=false;
        		break;
        	}
        }
        if (name.equals(otherbook.name)&&b&&this.yearOfPublication==otherbook.yearOfPublication&&this.type.equals(otherbook.type)) {
            return true;
        } else {
            return false;
        }
    }
}
