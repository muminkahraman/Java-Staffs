package Week10.Task1.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LibraryGateway
{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaprogramming_efrei";
    private static final String DELETE_ALL_BOOKS = "DELETE FROM Book";
    private static final String DELETE_ALL_COPIES = "DELETE FROM Copy";
    private static final String INSERT_BOOK = "INSERT INTO Book(title, author, ISBN) Values (?, ?, ?)";
    private static final String INSERT_COPY = "INSERT INTO Copy(id, copyState, bookISBN) Values (?, ?, ?)";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM Book";
    private static final String SELECT_COPIES_FOR_BOOK = "SELECT * FROM Copy WHERE BookISBN = ?";

    private Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(
                new org.apache.derby.jdbc.ClientDriver());

        return DriverManager.getConnection(DATABASE_URL, "root", "mumin1999.");
    }

    public ArrayList<Book> loadBooks()
    {
        try (Connection conn = getConnection())
        {
            ArrayList<Book> books = selectAllBooks(conn);

            return books;
        }
        catch (SQLException e)
        {
            throw new RuntimeException("There was a problem with the database when loading books", e);
        }
    }

    private ArrayList<Book> selectAllBooks(Connection conn)
    {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_BOOKS))
        {
            ArrayList<Book> books = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Book b
                        = new Book(
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("ISBN"));

                loadCopiesForBook(b, conn);

                books.add(b);
            }
            return books;
        }
        catch (SQLException | EmptyStringException e)
        {
            throw new RuntimeException("Problem loading books", e);
        }
    }

    private void loadCopiesForBook(Book b, Connection conn)
    {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_COPIES_FOR_BOOK))
        {
            stmt.setString(1, b.getISBN());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Copy c
                        = new Copy(
                        rs.getInt("Id"),
                        rs.getString("CopyState"));
                b.addCopy(c);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Problem loading copies", e);
        }
    }

    public void saveBooks(ArrayList<Book> books)
    {
        try (Connection conn = getConnection())
        {
            deleteAllBooks(conn);
            books.forEach(b -> saveBook(b, conn));
        }
        catch (SQLException e)
        {
            throw new RuntimeException("There was a problem with the database when saving books", e);
        }
    }

    private void deleteAllBooks(Connection conn) throws SQLException
    {
        deleteAllCopies(conn);

        PreparedStatement stmt = conn.prepareStatement(DELETE_ALL_BOOKS);
        stmt.executeUpdate();
        stmt.close();
    }

    private void deleteAllCopies(Connection conn) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement(DELETE_ALL_COPIES);
        stmt.executeUpdate();
        stmt.close();
    }

    private void saveBook(Book b, Connection conn)
    {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_BOOK))
        {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getAuthor());
            stmt.setString(3, b.getISBN());
            stmt.executeUpdate();

            Arrays
                    .stream(b.getCopies())
                    .filter(c -> c != null)
                    .forEach(c -> saveCopy(b.getISBN(), c, conn));
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Book not inserted", e);
        }
    }

    private void saveCopy(String bookISBN, Copy c, Connection conn)
    {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_COPY))
        {
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getState());
            stmt.setString(3, bookISBN);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Copy not inserted", e);
        }
    }
}