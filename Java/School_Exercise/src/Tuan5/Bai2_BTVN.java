package Tuan5;

class Author {
	private String name, email;
	
	// Constructor
	public Author(){
		this.name = this.email = "";
	}
	public Author(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// Getter & setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}

class Book {
	private String name;
	private Double price;
	private Author[] author;
	
	// Constructor
	public Book(String name, Double price, Author[] author) {
		this.name = name;
		this.price = price;
		this.author = author;
	}
	
	// Getter & Setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }
	public Author[] getAuthor() { return author; }
	public void setAuthor(Author[] author) { this.author = author; }
	
	// return name author function
	public String getAuthorName() {
		StringBuilder authorsName = new StringBuilder("");
		for (int i = 0; i < author.length; i++) {
			authorsName.append(author[i].getName());
			if (i < author.length - 1) {
				authorsName.append(',');				
			}
		}
		return authorsName.toString();
	}
	
}

public class Bai2_BTVN {
	// Count prices equal 200000 
	public static void countPrices200000(Book[] book) {
		int count = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getPrice().equals(200000.0)) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Không có cuốn sách nào có giá 200000");
		}
		else {
			System.out.println("Số cuốn sách có giá 20000: " + count);
		}
	}
	
    public static void main(String[] args) {
        // Khởi tạo các tác giả
    	Author author1 = new Author("author1", "author1@gmail.com");
    	Author author2 = new Author("author2", "author2@gmail.com");
    	Author author3 = new Author("author3", "author3@gmail.com");
    	
    	// Tạo danh sách các cuốn sách	
    	Author[] authorBook1 = {author1, author2};
    	Author[] authorBook2 = {author2};
    	
    	Book book1 = new Book("Book1", 200000.0, authorBook1);
    	Book book2 = new Book("Book2", 199999.0, authorBook2);
    	Book book3 = new Book("Book3", 1999.0, authorBook1);
    	
    	// In ra tên các tác giả viết sách của từng cuốn sách
        System.out.println("Tên các tác giả viết sách của từng cuốn sách:");
        System.out.println(book1.getName() + ": " + book1.getAuthorName());
        System.out.println(book2.getName() + ": " + book2.getAuthorName());
        System.out.println(book3.getName() + ": " + book3.getAuthorName());

        // Đếm số cuốn sách có giá 200000
        int count = 0;
        if (book1.getPrice() == 200000) {
            count++;
        }
        if (book2.getPrice() == 200000) {
            count++;
        }
        if (book3.getPrice() == 200000) {
            count++;
        }

        // Hiển thị kết quả
        if (count == 0) {
            System.out.println("Không có cuốn sách nào có giá là 200000.");
        } else {
            System.out.println("Số cuốn sách có giá là 200000: " + count);
        }
    }
}

