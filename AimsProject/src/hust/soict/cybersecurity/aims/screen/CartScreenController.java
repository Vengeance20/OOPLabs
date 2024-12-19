package hust.soict.cybersecurity.aims.screen;

import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.media.Media;
import hust.soict.cybersecurity.aims.media.Playable;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class CartScreenController {
	
	private Cart cart;
	private ControllerScreen controllerScreen;
	
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Label totalCost;
    
    @FXML
    private Button btnRemove;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnOrder;
    
    @FXML
    private Button btnStop;
    
    @FXML
    private Label playingMedia;
    
    public CartScreenController(Cart cart , ControllerScreen controllerScreen) {
		super();
		this.cart = cart;
		this.controllerScreen = controllerScreen;
	}
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	totalCost.setText(cart.totalCost()+"$");	
    }
    
    @FXML
    void btnOrderPressed(ActionEvent event) {
		System.out.println("Order");
    	btnOrder.setText("Success!!!");
    	btnOrder.setDisable(true);
    	cart.getItemsOrdered().removeAll(cart.getItemsOrdered());
    	totalCost.setText("0.0$");	
    	PauseTransition pt = new PauseTransition(Duration.seconds(1));
        pt.setOnFinished(e ->{
        	btnOrder.setDisable(false);
        	playingMedia.setVisible(false);
        	btnPlay.setVisible(false);
        	btnStop.setVisible(false);
        	btnOrder.setText("Order");
        } );
        pt.playFromStart();
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	playingMedia.setText("Playing "+media.getTitle()+"....");
    	playingMedia.setVisible(true);
    	btnStop.setVisible(true);
    }
    
    @FXML
    void btnStopPressed(ActionEvent event) {
    	playingMedia.setVisible(false);
    	btnStop.setVisible(false);
    }
    
    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	btnStop.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    		new ChangeListener<Media>() {
    			
    			@Override
    			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    				if (newValue != null) {
    					updateButtonBar(newValue);
    				}
    				
    				totalCost.setText(cart.totalCost()+"$");
    			}
    		});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				showFilterMedia(newValue);
			}
		});
    }
    
    @FXML
    void changeToStoreScreen(ActionEvent event) {
    	this.controllerScreen.showStoreScreen();
    }
    @FXML
    void changeToAddBookScreen(ActionEvent event) {
    	this.controllerScreen.showAddBookScreen();
    }

    @FXML
    void changeToAddCDScreen(ActionEvent event) {
    	this.controllerScreen.showAddCDCreen();
    }

    @FXML
    void changeToAddDVDScreen(ActionEvent event) {
    	this.controllerScreen.showAddDVDScreen();
    }

    @FXML
    void changeToCartScreen(ActionEvent event) {
    	this.controllerScreen.showCartScreen();
    }
    
    void showFilterMedia(String searchString) {
    	if(searchString.isEmpty()) {
    		tblMedia.setItems(this.cart.getItemsOrdered());
    	} else {
        	if(radioBtnFilterId.isSelected()) {
        		tblMedia.setItems(new FilteredList<Media>(this.cart.getItemsOrdered(),
        				item-> item.getId()==Integer.parseInt(searchString)));
        	}else
        	tblMedia.setItems(new FilteredList<Media>(this.cart.getItemsOrdered(),
        			item-> item.getTitle().contains(searchString)));
    	}
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
}

