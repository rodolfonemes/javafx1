package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entites.Person;

public class ViewController implements Initializable{

	@FXML
	private ComboBox<Person> comboBoxPerson;
	
	private ObservableList<Person> obsList;
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		Alerts.showAlert("Alert title", 
				null, 
				"ID: "  + person.getId() + "\n" +
				"Nome: "  + person.getName() + "\n" + 
				"E-Mail: " + person.getEmail(), 
				AlertType.INFORMATION);
	}
	
	@FXML
	private Button btAll;
	
	@FXML
	public void onBtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	
	/*@FXML
	private TextField txtNumber1;

	@FXML
	private TextField txtNumber2;

	@FXML
	private Label labelResult;

	@FXML
	private Button btSoma;

	@FXML
	public void onBtSomaAction() {

		Locale.setDefault(Locale.US);
		// System.out.println("clique!!!!!!!!");
		try {
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double soma = number1 + number2;
			Alerts.showAlert("Alert title", null, "Resultdo = " + String.format("%.2f", soma), AlertType.WARNING);
			labelResult.setText(String.format("%.2f", soma));
		} catch (NumberFormatException e) {
			Alerts.showAlert("ERROR", null, e.getMessage(), AlertType.ERROR);
		}
	}
*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "rodolfo", "rodolfo@gmail.com"));
		list.add(new Person(2, "rodrigo", "rodrigo@gmail.com"));
		list.add(new Person(3, "rosangela", "rosangela@gmail.com"));
		list.add(new Person(4, "sarah", "sarah@gmail.com"));
		
		obsList = FXCollections.observableArrayList(list);
		comboBoxPerson.setItems(obsList);
		
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
			super.updateItem(item, empty);
			setText(empty ? "" : item.getName());
			}
			};
			comboBoxPerson.setCellFactory(factory);
			comboBoxPerson.setButtonCell(factory.call(null));
		
		
		/*
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 10);
		Constraints.setTextFieldMaxLength(txtNumber2, 10);
		*/	
		
	}
}
