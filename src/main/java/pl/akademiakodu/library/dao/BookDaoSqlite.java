package pl.akademiakodu.library.dao;

import pl.akademiakodu.library.domain.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Lenovo on 2016-11-16.
 */
public class BookDaoSqlite implements pl.akademiakodu.library.dao.BookDao {
    private Connection connection;

    public BookDaoSqlite(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        createTable();
    }

    private void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS Books"
                +"("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"title TEXT, "
                +"author TEXT, "
                +"pages INTEGER "
                +")";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            System.out.println("Nie udało się wykonać SQL"+e.getMessage());
        }
    }

    public static void main(String[] args){
        BookDaoSqlite bookDaoSqlite = new BookDaoSqlite();
        bookDaoSqlite.addBook(new Book("Pozytywne myslenie","Brian Tracy",259));

    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO Books (title, author, pages) "
                +"VALUES ('"+book.getTitle()+"',' "+book.getAuthor()+"', "+book.getPages()+")";

        try{
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
        catch (SQLException e){
            System.out.println("Nie udało się wykonać SQL"+e.getMessage());
        }
    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }
}
