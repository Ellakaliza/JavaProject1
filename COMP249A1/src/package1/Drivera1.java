// ------------------------------------------------------------
// Assignment {1}
// Written by: Ange Marie Ella Akaliza 40270048
// For COMP 249 Section {PP} - Winter 2024
// ------------------------------------------------------------
/* This program is for FunReadings library. It keeps count of all the library's books, journals, media and clients.
 * it accounts for the the clients, their information and their leased items. The program can add or delete items from the library
 * as well as update information about the items and the clients.*/
 package package1;
import java.util.Scanner;
import package2.Client;
import package3.*;

public class Drivera1 {
	//I am going to keep the information to display in these arrays
	static Books[] books=new Books[20];
	static Journals[] journals= new Journals[20];
	static Media[] media=new Media[20];
	static Client[] clients=new Client[20];
	static int b=0,j=0,m=0,c=0;
	static Items[][] leaseditems;
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome to the FunReadings library Items manager!");
		System.out.println("Do you want to get the menu or a predefined scenario? \nChoose 1 for the menu and 2 for the predefined scenario. ");
		int choice=scan.nextInt();
		choice=Choice(choice,1,2);
		if(choice==1) {
			System.out.println("Please choose between the following operations: ");
			System.out.println("1.Conduct an item operation\r\n"
					+ "2.add a client, edit a client, and delete a client.\r\n"
					+ "3.lease an item to a client and return an item from a client.\r\n"
					+ "4.show all items leased by a client.\r\n"
					+ "5.show all leased items (by all clients).\r\n"
					+ "6.Display the biggest book.\r\n"
					+ "7.Make a copy of the books array");
			choice=scan.nextInt();
			choice=Choice(choice,1,7);
			switch(choice) {
			case 1:
				System.out.println("Which Item operation would you like to conduct?");
				System.out.println("1. add an item\r\n"
				                  +"2.delete an item\r\n"
						          +"3.change information of an item\r\n"
				                  +"4.list all items in a specific category (book, journal, or media)\r\n"
						          +"5.print all items (from all categories)\r\n");
				choice=scan.nextInt();
				choice=Choice(choice,1,5);
				switch(choice) {
				case 1: 
					System.out.println("What is the item's ID?");
					String id=scan.next();
					System.out.println("What is the item's title?");
					String name=scan.next();
					System.out.println("How many authors does the item have?");
					int authornumber=scan.nextInt();
					String[]author=new String[authornumber];
					for(int i=0;i<author.length;i++) {
						System.out.println("What is author #"+(i)+"'s name?");
						author[i]=scan.next();
					}
					System.out.println("In which year was the item published?");
					int yearofpublication=scan.nextInt();
					ItemChoice();
					choice=scan.nextInt();
					choice=Choice(choice,1,3);
					if(choice==1) {
						System.out.println("How many pages does this book have?");
						int bookpages=scan.nextInt();
						books[b]=new Books(name,author,yearofpublication,bookpages);
						books[b].setId(id);
						b++;
					}
					else if(choice==2) {
						System.out.println("How many volumes does this journal have?");
						int journalvolume=scan.nextInt();
						journals[j]=new Journals(name,author,yearofpublication,journalvolume);
						journals[j].setId(id);
						j++;
					}
					else if(choice==3) {
						System.out.println("What type of media is it? Audio, video or interactive?");
						String type=scan.next();
						media[m]=new Media(name,author,yearofpublication,type);
						media[m].setId(id);
						m++;
					}
					System.out.println("Item added successfully!");
					break;
				case 2:
					System.out.println("Please enter the item's id");
					String Id=scan.next();
					ItemChoice();
					choice=scan.nextInt();
					choice=Choice(choice,1,3);
					if(choice==1) {
						for(int i=0;i<books.length;i++) {
							if(books[i].getId().equals(Id)) {
								books[i].setAuthors(null);
								books[i].setId(null);
								books[i].setName(null);
								books[i].setYearOfPublication(0);
								books[i].setNumoPags(0);
							}
						}
					}
					else if(choice==2) {
						for(int i=0;i<journals.length;i++) {
							if(journals[i].getId().equals(Id)) {
								journals[i].setAuthors(null);
								journals[i].setId(null);
								journals[i].setName(null);
								journals[i].setYearOfPublication(0);
								journals[i].setVolumeNumber(0);
							}
						}
					}
					else if(choice==3) {
						for(int i=0;i<media.length;i++) {
							if(media[i].getId().equals(Id)) {
								media[i].setAuthors(null);
								media[i].setId(null);
								media[i].setName(null);
								media[i].setYearOfPublication(0);
								media[i].setType(null);
							}
						}
					}
					System.out.println("Item deleted successfully!");
					break;
				case 3:
					System.out.println("Please enter the item's id");
					Id=scan.next();
					ItemChoice();
					choice=scan.nextInt();
					choice=Choice(choice,1,3);
					if(choice==1) {
						ItemComponentChoice("number of pages");
						choice=scan.nextInt();
						choice=Choice(choice,1,2);
						ItemComponentChange(1,choice,Id);
					}
					else if(choice==2) {
						ItemComponentChoice("volume numbers");
						choice=scan.nextInt();
						choice=Choice(choice,1,2);
						ItemComponentChange(2,choice,Id);
					}
					else if(choice==3) {
						ItemComponentChoice("");
						choice=scan.nextInt();
						choice=Choice(choice,1,2);
						ItemComponentChange(3,choice,Id);
					}
					System.out.println("Information changed successfully!");
					break;
				case 4:
					ItemChoice();
					choice=scan.nextInt();
					choice=Choice(choice,1,3);
					ItemDisplay(choice);
					break;
				case 5:
					ItemDisplay(4);
					break;
				}
				break;
			case 2:
				System.out.println("Please choose between the following operations: ");
				System.out.println("1.Add a client\r\n"
						+ "2.Edit a client.\r\n"
						+ "3.Delete a client.\r\n");
				choice=scan.nextInt();
				choice=Choice(choice,1,3);
				switch(choice) {
				case 1:
					System.out.println("What is the client's name,Id,email adress and telephone number?");
					String nameclient=scan.next();
					String Idclient=scan.next();
					String email=scan.next();
					String phone=scan.next();
					clients[c]=new Client(nameclient,email,phone);
					clients[c].setId(Idclient);
					c++;
					break;
				case 2:
					System.out.println("Enter the Id of the client whose information you would like to change.");
					String id=scan.next();
					System.out.println("What would you like to change?\n1.Client's name\n2.Client's email\n3.Client's phone number");
					choice=scan.nextInt();
					choice=Choice(choice,1,3);
					ClientInfoChange(choice,id);
					break;
				case 3:
					System.out.println("Enter the Id of the client whose information you would like to delete");
					id=scan.next();
					for(int i=0;i<clients.length;i++) {
						if(clients[i].getId().equals(id)) {
							clients[i].setEmailAddress(null);
							clients[i].setId(null);
							clients[i].setName(null);
							clients[i].setPhoneNumber(null);
						}
					}
					break;
				}
				break;
			case 3:
				System.out.println("Would you like to lease an item to a client(1) or return an item from a client(2)?");
				choice=scan.nextInt();
				choice=Choice(choice,1,2);
				
				if(choice==1) {
					System.out.println("Which client would you like to lease an item to(enter their ID)?");
					String Idclient=scan.next();
					System.out.println("Which item would you like to lease to the client? \nEnter the type(1.Book,2.Journal,3.Media) and its Id.");
					choice=scan.nextInt();
					choice=Choice(choice,1,3);
					String Iditem=scan.next();
					int a=ClientArrayCounter(Idclient);
					if(choice==1) {
						for(int i=0;i<books.length;i++) {
							if(books[i].getId().equals(Iditem)) {
								leaseditems[a][leaseditems[a].length]=books[i];
								break;
							}
						}
					}
					else if(choice==2) {
						for(int i=0;i<journals.length;i++) {
							if(journals[i].getId().equals(Iditem)) {
								leaseditems[a][leaseditems[a].length]=journals[i];
								break;
							}
						}
					}
					else if(choice==3) {
						for(int i=0;i<media.length;i++) {
							if(media[i].getId().equals(Iditem)) {
								leaseditems[a][leaseditems[a].length]=media[i];
								break;
							}
						}
					}
					System.out.println("Item leased successfully!");
				}
				else if(choice==2) {
					System.out.println("Which client would like to return their leased item and what item would they like to return?(Enter Ids for client and item, in that order)");
					String Idclient=scan.next();
					String Iditem=scan.next();
					int a=ClientArrayCounter(Idclient);
					for(int i=0;i<leaseditems[a].length;i++) {
						if(leaseditems[a][i].getId().equals(Iditem)) {
							leaseditems[a][i]=null;
						}
					}
					System.out.println("Item returned successfully!");
				}
				break;
			case 4:
				System.out.println("Which client whose lease list would you like to see? \nEnter their Id");
				String Idclient=scan.next();
				int a=ClientArrayCounter(Idclient);
				for(int i=0;i<leaseditems[a].length;i++) {
					if(leaseditems[a][i]==null)
						continue;
					else {
						System.out.print(leaseditems[a][i]+"\n");
					}
				}
				break;
			case 5:
				for(int j=0;j<leaseditems.length;j++) {
					if(leaseditems[j]==null)
						continue;
					else {
						for(int i=0;i<leaseditems[j].length;i++) {
							if(leaseditems[j][i]==null)
								continue;
							else {
								System.out.println(leaseditems[j][i]);
							}
						}
					}
				}
				break;
			case 6:
				System.out.println(getBiggestBook(books));
				break;
			case 7:
				copyBooks(books);
				break;
			}
		}
		else if(choice==2) {
			String[] authors1= {"a1","a2","a3"};
			String[] authors2= {"a4"};
			String[] authors3= {"a5","a6","a7","a8"};
			String[] authors4= {"a9","a10"};
			Books B1=new Books("Book 1",authors1, 2024, 200);
			Books B2=new Books();
			Books B3=new Books(B1);
			System.out.print(B1);
			System.out.print(B2);
			System.out.print(B3);
			Journals J1=new Journals("Journal 1",authors2, 1999, 3);
			Journals J2=new Journals("Journal 2",authors3, 2005, 1);
			Journals J3=new Journals();
			System.out.print(J1);
			System.out.print(J2);
			System.out.print(J3);
			Media M1=new Media("Media 1",authors1, 1975, "audio");
			Media M2=new Media("Media 2",authors4, 2010, "video");
			Media M3=new Media(M1);
			System.out.print(M1);
			System.out.print(M2);
			System.out.print(M3);
			Client C1=new Client("Jane Smith","janes@gmail.com","514-123-4567");
			Client C2=new Client("John Doe","jdoe@gmail.com","514-123-4567");
			Client C3=new Client("Doe Smith","doesmith@gmail.com","514-123-4567");
			System.out.print(C1);
			System.out.print(C2);
			System.out.print(C3);
			System.out.print(B2.equals(M1));
			System.out.print(J1.equals(J2));
			System.out.print(B1.equals(B3));
			Books[] bks= {B1,B2,B3};
			Journals[] jrnls= {J1,J2,J3};
			Media[] mdia= {M1,M2,M3};
			Items[]items= {B1,B2,B3,J1,J2,J3,M1,M2,M3};
			System.out.println(getBiggestBook(bks));
			//copyBooks does not take parameters of type Media
			//copyBooks(mdia);
		}
		System.out.println("Thank you for using the FunReadings library Items manager. Goodbye!");
		scan.close();
	}
	public static Books getBiggestBook(Books[] books) {
		
		for (int i= 0; i< books.length-1; i++) {
			int min = i;
			for (int j= i+1; j < books.length; j++)
				if (books[j].getNumoPags() < books[min].getNumoPags())
					min = j;
			Books temp = books[min];
			books[min] = books[i];
			books[i] = temp;
		}
		return books[books.length-1];
	}
	public static void copyBooks(Books[] books) {
		Books[] copybooks=new Books[books.length];
		for(int i=0;i<books.length;i++) {
			copybooks[i]=books[i];
		}
		for(int i=0;i<copybooks.length;i++) {
			if(copybooks[i]!=null)
				System.out.print(copybooks[i]);
		}
	}
	public static void ItemChoice() {
		System.out.println("Which Item would you like to choose?\n1.Books\n2.Journal\n3.Media");
	}
	//this method ensures that the user chooses between the allowed choices
	public static int Choice(int choice,int lowerbound, int upperbound) {
		Scanner scan=new Scanner(System.in);
		while(!(choice>=lowerbound&&choice<=upperbound)) {
			System.out.println("Please enter a valid choice");
			choice=scan.nextInt();
		}
		//scan.close();
		return choice;
	}
	public static void ItemComponentChoice(String secondchoice) {
		System.out.println("Choose which aspect you want to change.\n"
				  +"1.name of item\n"
				  +"2."+secondchoice);
	}
	public static void ItemComponentChange(int itemchoice, int componentchoice,String id) {
		Scanner scan=new Scanner(System.in);
		if(itemchoice==1) {
			if(componentchoice==1) {
				System.out.println("What is the book's new title? ");
				String newtitle=scan.next();
				for(int i=0;i<books.length;i++) {
					if(books[i].getId().equals(id)) {
						books[i].setName(newtitle);
						break;
					}
				}
			}
			else if (componentchoice==2) {
				System.out.println("What is the book's new number of pages? ");
				int newpages=scan.nextInt();
				for(int i=0;i<books.length;i++) {
					if(books[i].getId().equals(id)) {
						books[i].setNumoPags(newpages);
						break;
					}
				}
			}
		}
		else if(itemchoice==2) {
			if(componentchoice==1) {
				System.out.println("What is the journal's new title? ");
				String newtitle=scan.next();
				for(int i=0;i<journals.length;i++) {
					if(journals[i].getId().equals(id)) {
						journals[i].setName(newtitle);
						break;
					}
				}
			}
			else if (componentchoice==2) {
				System.out.println("What is the journal's new number of volumes? ");
				int newpages=scan.nextInt();
				for(int i=0;i<journals.length;i++) {
					if(journals[i].getId().equals(id)) {
						journals[i].setVolumeNumber(newpages);
						break;
					}
				}
			}
		}
		else if(itemchoice==3) {
			System.out.println("What is the media's new title? ");
			String newtitle=scan.next();
			for(int i=0;i<media.length;i++) {
				if(media[i].getId().equals(id)) {
					media[i].setName(newtitle);
					break;
				}
			}
		}
		//scan.close();
	}
	//this method displays the items in the library: it can either be by category or all the items, depending on choice
	public static void ItemDisplay(int choice) {
		if(choice==1) {
			for(int i=0;i<books.length;i++) {
				if(books[i].getName()==null)
					continue;
				else
					System.out.println(books[i]);
			}
		}
		else if(choice==2) {
			for(int i=0;i<journals.length;i++) {
				if(journals[i].getName()==null)
					continue;
				else
					System.out.println(journals[i]);
			}
		}
		else if(choice==3) {
			for(int i=0;i<media.length;i++) {
				if(media[i].getName()==null)
					continue;
				else
					System.out.println(media[i]);
			}
		}
		else if(choice==4) {
			for(int i=0;i<books.length;i++) {
				if(books[i].getName()==null)
					continue;
				else
					System.out.println(books[i]);
			}
			for(int i=0;i<journals.length;i++) {
				if(journals[i].getName()==null)
					continue;
				else
					System.out.println(journals[i]);
			}
			for(int i=0;i<media.length;i++) {
				if(media[i].getName()==null)
					continue;
				else
					System.out.println(media[i]);
			}
		}
	}
	//this method allows the user to change the client's information depending on the choice:(name,email or phone number)
	public static void ClientInfoChange(int choice,String id) {
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<clients.length;i++) {
			if(clients[i].getId().equals(id)) {
				if(choice==1) {
					System.out.println("What is the client's new name?");
					String newname=scan.next();
					clients[i].setName(newname);
				}
				if(choice==2) {
					System.out.println("What is the client's new email address?");
					String newemail=scan.next();
					clients[i].setEmailAddress(newemail);
				}
				if(choice==3) {
					System.out.println("What is the client's new phone number?");
					String newnumber=scan.next();
					clients[i].setPhoneNumber(newnumber);
				}
				break;
			}
		}
		//scan.close();
	}
	//this method returns the client's index which will become the client's index in leaseditems
	public static int ClientArrayCounter(String id) {
		int a=0;
		for(int i=0;i<clients.length;i++) {
			a=i;
			if(clients[i].getId().equals(id)) {
				break;
			}
		}
		if(a==0)
			return a;
		else
			return a+1;
	}
}
