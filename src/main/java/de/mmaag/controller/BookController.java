package de.mmaag.controller;

import de.mmaag.controller.interfaces.IController;
import de.mmaag.hibernate.entity.Author;
import de.mmaag.hibernate.entity.Book;
import de.mmaag.hibernate.util.HibernateUtil;
import de.mmaag.view.AuthorComboBoxModel;
import de.mmaag.view.BookView;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public class BookController implements IController {

    private BookView view;

    public BookController(BookView view) {
        this.view = view;
        view.setController(this);

        //todo read authors from database
        Author[] authors = new Author[]{
                new Author(UUID.randomUUID(), "Markus Heitz", null),
                new Author(UUID.randomUUID(), "Stephen King", null),
        };

        AuthorComboBoxModel authorComboBoxModel = new AuthorComboBoxModel(authors);

        view.setAuthorComboBoxModel(authorComboBoxModel);
    }

    public void showView() {
        view.setVisible(true);
    }

    public void saveBook(Book book, Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (author.getId() == null) {
                author.setId(UUID.randomUUID());
                transaction = session.beginTransaction();
                session.persist(author);
                transaction.commit();
            }

            book.setAuthorId(author.getId());

            // start a transaction
            transaction = session.beginTransaction();

            // save the book object
            session.persist(book);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}


