package hust.soict.hedspi.aims.screen.customer.controller;
import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
	private final Store store;
    private final Cart cart;
    public CartController(Cart cart, Store store){
        this.cart = cart;
        this.store = store;
    }
    @FXML
	private Label lblTotalCost;
	
	@FXML
    private TextField tfFilter;
	
	@FXML
    private RadioButton radioBtnFilterId;
	
	@FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if ( media instanceof Playable){
            if(media instanceof DigitalVideoDisc dvd){
                dvd.play();


                // Display the dialog pane
                javafx.scene.control.Dialog<Button> dialog = new javafx.scene.control.Dialog<>();
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("Playing: " + dvd.getTitle());
                dialogPane.setContentText("Media is now playing...");

                Label details = new Label(
                        "Length: " + dvd.getLength() + " minutes\n" +
                                "Director: " + dvd.getDirector() + "\n" +
                                "Category: " + dvd.getCategory()
                );
                dialogPane.setExpandableContent(details);
                ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(closeButton);
                dialog.setDialogPane(dialogPane);
                dialog.showAndWait();
            }else if(media instanceof CompactDisc cd){
                cd.play();
                javafx.scene.control.Dialog<Button> dialog = new javafx.scene.control.Dialog<>();
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("Playing: " + cd.getTitle());
                dialogPane.setContentText("Media is now playing...");

                Label details = new Label(
                        "Length: " + cd.getLength() + " minutes\n" +
                                "Director: " + cd.getDirector() + "\n" +
                                "Category: " + cd.getCategory()
                );
                dialogPane.setExpandableContent(details);
                ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(closeButton);
                dialog.setDialogPane(dialogPane);
                dialog.showAndWait();
            }

        }


    }
    void updateCostLabel(){
        float totalCost = 0;
        for (Media media: cart.getItemsOrdered()){
            totalCost += media.getCost();
        }
        costLabel.setText( totalCost + "$");
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateCostLabel();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id")
        );
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );

        if(cart.getItemsOrdered() != null){
            tblMedia.setItems(cart.getItemsOrdered());

        }
        btnPlay.setVisible(false);	
        btnRemove.setVisible(false);	
    }
    void updateButtonBar(Media media) {
    	if (media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	} else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		} else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    public void updateTotalCost() {
        float totalCost = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", totalCost));
    }
}

  
