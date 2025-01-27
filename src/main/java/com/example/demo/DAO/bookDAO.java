package com.example.demo.DAO;

import com.example.demo.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bookDAO {

    public int createBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, genre, publication_year, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setInt(4, book.getPublicationYear());
            stmt.setDouble(5, book.getPrice());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna o ID gerado
                }
            }
        }
        return -1;
    }

    public List<Book> readBooks() throws SQLException {
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();

        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPublicationYear(rs.getInt("publication_year"));
                book.setPrice(rs.getDouble("price"));
                books.add(book);
            }
        }
        return books;
    }

    public boolean updateBook(int id, Book book) throws SQLException {
        String sql = "UPDATE books SET title = ?, author = ?, genre = ?, publication_year = ?, price = ? WHERE id = ?";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setInt(4, book.getPublicationYear());
            stmt.setDouble(5, book.getPrice());
            stmt.setInt(6, id);

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
