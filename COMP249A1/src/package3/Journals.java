package package3;

public class Journals extends Items {
	private int volumeNumber;
	public Journals(String name, String[] authors, int yearOfPublication, int vlmnum) {
		super(name,authors,yearOfPublication);
		setVolumeNumber(vlmnum);
	}
	public Journals(Journals journals) {
		this(journals.name,journals.authors,journals.yearOfPublication,journals.getVolumeNumber());
	}
	public Journals() {
		super();
		setVolumeNumber(0);
	}
	public String toString() {
		return name+" by "+authors+" was published in "+yearOfPublication+" and has "+getVolumeNumber()+" volumes";
	}
	public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Journals otherbook = (Journals) otherObject;
        boolean b=true;
        if(otherbook.authors.length!=this.authors.length)
        	return false;
        for(int i=0;i<authors.length;i++) {
        	if(!(this.authors[i].equals(otherbook.authors[i]))) {
        		b=false;
        		break;
        	}
        }
        if (name.equals(otherbook.name)&& b&&this.yearOfPublication==otherbook.yearOfPublication&&this.getVolumeNumber()==otherbook.getVolumeNumber()) {
            return true;
        } else {
            return false;
        }
    }
	public int getVolumeNumber() {
		return volumeNumber;
	}
	public void setVolumeNumber(int volumeNumber) {
		this.volumeNumber = volumeNumber;
	}
}
