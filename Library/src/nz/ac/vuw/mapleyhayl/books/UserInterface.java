package nz.ac.vuw.mapleyhayl.books;

import ecs100.*;
import java.io.*;
import java.util.*;

/* functionality to add
 * - remove books from library
 * - edit entries
 * - search for books by title or author
 * - display all read books
 * - display all unread books
 * - mark any book as read or unread
 * - create custom lists of books e.g. 'to read', 'inspiration'
 * - display books on graphics pane
 */

// For commit

//test test test
public class UserInterface {

	private ArrayList<Book> allBooks = new ArrayList<Book>();

	public UserInterface() {
		UI.initialise();
		UI.setWindowSize(1400, 900);
		UI.setDivider(0.4);
		UI.addButton("Add book", this::addBook);
		UI.addButton("Display latest entry", this::displayLatestEntry);
		UI.addButton("Search by title", this::searchByTitle);
		UI.addButton("Search by author", this::searchByAuthor);
		UI.addButton("Save library", this::saveLibrary);
		UI.addButton("Load library", this::loadLibrary);
	}

	//asks the user for information on a book they wish to register to their library and thats that to the allBooks arrayList
	public void addBook() {
		UI.clearText();
		UI.println("Please enter the title of the book:");
		String title = UI.askString("");
		UI.println("Please enter the author of the book:");
		String author = UI.askString("");
		String[] authorNames = author.split(" ");
		String firstName = authorNames[0];
		String lastName = authorNames[1];
		Author newAuthor = new Author(firstName, lastName);
		UI.println("Please enter the genre of the book:");
		UI.println("[1] Fiction\n[2] Non-Fiction");
		String genre = null;
		int ans = UI.askInt("");
		if (ans == 1) {
			genre = "Fiction";
		} else if (ans == 2) {
			genre = "Non-Fiction";
		}
		UI.println("Have you read this book?");
		Boolean haveRead = false;
		String ans2 = UI.askString("");
		if (ans2.equalsIgnoreCase("yes")) {
			haveRead = true;
		}
		Book newBook = new Book(title, newAuthor, genre, haveRead);
		allBooks.add(newBook);
		UI.clearText();
		UI.println("Entry added.");
	}

	//for debugging - displays the information of the last book entered
	public void displayLatestEntry() {
		UI.clearText();
		Book displayBook = allBooks.get(allBooks.size()-1);
		UI.println(displayBook.toString());
	}
	
	//searches allBooks for a book that contains the title and displays the information of the book
	public void searchByTitle() {
		UI.clearText();
		String ans = UI.askString("Please enter the title: ");
		ans.toLowerCase();
		for (Book b : allBooks) {
			String title = (b.getTitle()).toLowerCase();
			if (title.contains(ans)) {
				UI.println(b.toString());
			}
		}
	}
	
	//searches allBooks for a book that was written by the author and displays the information of the book
	public void searchByAuthor() {
		UI.clearText();
		String ans = UI.askString("Please enter the name of the author: ");
		String[] names = ans.split(" ");
		String firstName = names[0];
		String lastName = names[1];
		for (Book b : allBooks) {
			Author thisAuthor = b.getAuthor();
			if (thisAuthor.getFirstName().contains(firstName) || thisAuthor.getLastName().contains(lastName)) {
				UI.clearText();
				UI.println(b.toString());
			}
		}
	}
	
	//saves the current selection of books as a file
	public void saveLibrary() {
		try {
		PrintStream out = new PrintStream(new File(UIFileChooser.save()));
		for (Book b : allBooks) {
			out.println(b.getTitle());
			out.println(b.getAuthor());
			out.println(b.getGenre());
			out.println(b.getHaveRead());
		}
		out.close();
		} catch (Exception e) {}
	}
	
	//reads in a file and loads a selection of books
	public void loadLibrary() {
		try {
			Scanner in = new Scanner(new File(UIFileChooser.open()));
			while (in.hasNext()) {
				String title = in.nextLine();
				String author = in.nextLine();
				String[] authorNames = author.split(" ");
				String firstName = authorNames[0];
				String lastName = authorNames[1];
				Author newAuthor = new Author(firstName, lastName);
				String genre = in.nextLine();
				boolean haveRead = in.nextBoolean();
				in.nextLine();
				Book newBook = new Book(title, newAuthor, genre, haveRead);
				allBooks.add(newBook);
			}
			in.close();
			UI.println("Library added");
		} catch (Exception e) {}
	}
	
	public static void main(String[] args) {
		new UserInterface();
	}

}
