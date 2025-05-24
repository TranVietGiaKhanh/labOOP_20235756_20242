package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import javax.swing.*;


public abstract class AddItemToStoreScreen extends JFrame{
	protected Store store;
    protected JTextField tfID, tfTitle, tfCategory, tfCost;
    protected JButton btnAdd;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());
        add(createForm(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdate = new JMenu("Update Store");

        JMenuItem mAddBook = new JMenuItem("Add Book");
        mAddBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            this.dispose();
        });
        smUpdate.add(mAddBook);

        JMenuItem mAddCD = new JMenuItem("Add CD");
        mAddCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            this.dispose();
        });
        smUpdate.add(mAddCD);

        JMenuItem mAddDVD = new JMenuItem("Add DVD");
        mAddDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            this.dispose();
        });
        smUpdate.add(mAddDVD);

        menu.add(smUpdate);

        JMenuItem mView = new JMenuItem("View Store");
        mView.addActionListener(e -> {
            new StoreManagerScreen(store);
            this.dispose();
        });
        menu.add(mView);

        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        return mb;
    }

    protected abstract JPanel createForm();
}
