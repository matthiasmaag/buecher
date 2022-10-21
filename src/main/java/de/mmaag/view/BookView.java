package de.mmaag.view;

import de.mmaag.controller.BookController;
import de.mmaag.controller.interfaces.IController;
import de.mmaag.controller.interfaces.IView;
import de.mmaag.hibernate.entity.Author;
import de.mmaag.hibernate.entity.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class BookView extends JFrame implements IView {

    private JPanel rootPanel;
    private BookController controller;
    private JSplitPane splitPane;
    private JPanel datagridPanel;
    private JPanel editPanel;
    private JTextField txtTitel;
    private JTable table1;
    private JTextField txtPublisher;
    private JTextField txtPages;
    private JCheckBox cbRead;
    private JTextField txtIsbn10;
    private JTextField txtIsbn13;
    private JTextArea taDescription;
    private JButton btnAdd;
    private JButton button1;
    private JButton button2;
    private JComboBox cbAuthor;

    private Action exitAction;
    private Action addAuthorAction;

    public BookView() {
        super("Bücherverwaltung");
        initialization();
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.saveBook(createBook(), (Author) cbAuthor.getSelectedItem());
            }
        });
    }

    private void initialization() {
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createActions();
        addMenuBar();
        add(rootPanel);
    }

    public void setController(IController controller) {
        this.controller = (BookController) controller;
    }

    public void setAuthorComboBoxModel(AuthorComboBoxModel model) {
        this.cbAuthor.setModel(model);
    }

    private void createActions() {
        exitAction = new AbstractAction("Beenden") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        addAuthorAction = new AbstractAction("Author hinzufügen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAuthorDialog dialog = new AddAuthorDialog();
                dialog.pack();
                dialog.setVisible(true);
            }
        };
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Datei");
        fileMenu.add(exitAction);

        JMenu addMenu = new JMenu("Hinzufügen");
        addMenu.add(addAuthorAction);

        menuBar.add(fileMenu);
        menuBar.add(addMenu);
        this.setJMenuBar(menuBar);
    }

    private Book createBook() {
        return new Book(UUID.randomUUID(),
                null,
                txtTitel.getText(),
                txtPublisher.getText(),
                Integer.parseInt(txtPages.getText()),
                taDescription.getText(),
                cbRead.isSelected(),
                txtIsbn10.getText(), txtIsbn13.getText());
    }

}
