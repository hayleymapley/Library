package nz.ac.vuw.mapleyhayl.books;

public class Author {
	
	private String firstName;
	private String lastName;
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	public String toString() {
		return this.getFirstName() + " " + this.getLastName();
	}
}
