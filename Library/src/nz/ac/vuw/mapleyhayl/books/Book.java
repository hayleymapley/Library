package nz.ac.vuw.mapleyhayl.books;

public class Book {
	
	private String title;
	private Author author;
	private String genre;
	private boolean haveRead;

	public Book(String title, Author author, String genre, boolean read) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.haveRead = read;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author newAuthor) {
		this.author = newAuthor;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String newGenre) {
		this.genre = newGenre;
	}

	public boolean getHaveRead() {
		return haveRead;
	}
	
	public String toString() {
		return "Title: " + this.getTitle() +
				"\nAuthor: " + this.getAuthor() +
				"\nGenre: " + this.getGenre() +
				"\nRead: " + this.getHaveRead();
	}
}
