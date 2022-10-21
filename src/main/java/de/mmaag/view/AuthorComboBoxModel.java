package de.mmaag.view;

import de.mmaag.hibernate.entity.Author;

import javax.swing.*;

public class AuthorComboBoxModel extends DefaultComboBoxModel<Author> {
    public AuthorComboBoxModel(Author[] items) {
        super(items);
    }

    @Override
    public Author getSelectedItem() {
        Author selectedAuthor = (Author) super.getSelectedItem();

        return selectedAuthor;
    }
}
