package com.example.demo.Main;

import com.example.demo.DAO.bookDAO;
import com.example.demo.repository.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		bookDAO bookDAO = new bookDAO();

		try {
			Book newBook = new Book("O homem mais rico da Babilonia", "George S. Clason", "Crônica", 1926, 22.70);
			int bookId = bookDAO.createBook(newBook);
			System.out.println("Livro criado com ID: " + bookId);

			List<Book> books = bookDAO.readBooks();
			System.out.println("Livros no banco de dados:");
			for (Book book : books) {
				System.out.printf("ID: %d, Título: %s, Autor: %s, Gênero: %s, Ano: %d, Preço: %.2f%n",
						book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(),
						book.getPublicationYear(), book.getPrice());
			}

			newBook.setTitle("O homem mais rico de Roma");
			boolean updated = bookDAO.updateBook(bookId, newBook);
			System.out.println("Livro atualizado: " + updated);

			boolean deleted = bookDAO.deleteBook(bookId);
			System.out.println("Livro deletado: " + deleted);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

