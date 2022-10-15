package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML
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
}
