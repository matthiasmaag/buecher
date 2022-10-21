package de.mmaag.main;

import de.mmaag.controller.BookController;
import de.mmaag.view.BookView;

import javax.swing.*;

public class Main {

    static BookController controller;

    public static void main(String[] args) {
        Runnable guiCreator = () -> {
            try {
                System.setProperty("apple.laf.useScreenMenuBar", "true");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            BookView view = new BookView();

            controller = new BookController(view);
            controller.showView();
        };

        SwingUtilities.invokeLater(guiCreator);
    }
}
