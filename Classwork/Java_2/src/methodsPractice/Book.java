package methodsPractice;
/*Jan 17 2025
Instance variables: 'title', 'author'
Static variable: 'bookCount' to keep track of each book count.
Methods:
1. Accessors (getters)
2. Mutators (setters)
3. A static method to get the value of bookCount
4. A non-static method to display the book info
In the main method, create a couple of book objects,
update bookCount and display book info.
 */
public class Book {
	public String title;
	public String author;

	public static int bookCount = 0;

	// Getters/Accessors
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	// Setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public static int getBookCount() {
		return bookCount;
	}

	public void display() {
		System.out.println(title + " " + author + " " + bookCount);
	}

	public static void main (String [] args) {
		Book b1 = new Book();
		Book b2 = new Book();

		b1.setTitle("'Minecraft'");
		b1.setAuthor("Notch");

		b2.setTitle("'Minecraft Dungeons'");
		b2.setAuthor("Microsoft");

		// Either way works
		Book.bookCount ++;
		bookCount += 1;

		b1.display();
		b2.display();
	}
}

