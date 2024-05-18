package package2;

public class Client {
	private String id;
	private String name;
	private String emailAddress;
	private String phoneNumber;
	public Client(String name,String emailAddress,String phoneNumber) {
		this.name=name;
		this.emailAddress=emailAddress;
		this.phoneNumber=phoneNumber;
	}
	public Client() {
		this("","","");
	}
	public Client(Client client) {
		this(client.name,client.emailAddress,client.phoneNumber);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String toString() {
		return name+"\n"+id+"\n"+emailAddress+"\n"+phoneNumber;
	}
	public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Client otherclient = (Client) otherObject;

        if (name.equals(otherclient.name) && emailAddress.equals(otherclient.emailAddress)&&this.phoneNumber==otherclient.phoneNumber) {
            return true;
        } else {
            return false;
        }
    }
}
