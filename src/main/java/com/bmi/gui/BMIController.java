package com.bmi.gui;

import com.bmi.model.BMICalculator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller bmi-view.fxml.
 */
public class BMIController {

    @FXML
    private TextField txtBerat;
    @FXML
    private TextField txtTinggi;
    @FXML
    private Label lblHasil;
    @FXML
    private Label lblKategori;

    @FXML
    private void onHitung() {
        try {
            double berat = Double.parseDouble(txtBerat.getText().trim().replace(',', '.'));
            double tinggi = Double.parseDouble(txtTinggi.getText().trim().replace(',', '.'));

            double bmi = BMICalculator.hitung(berat, tinggi);

            lblHasil.setText(String.format("BMI: %.2f", bmi));
            lblKategori.setText(BMICalculator.kategori(bmi));
        } catch (NumberFormatException e) {
            tampilkanError("Input harus berupa angka!");
        } catch (IllegalArgumentException e) {
            tampilkanError(e.getMessage());
        }
    }

    @FXML
    private void onReset() {
        txtBerat.clear();
        txtTinggi.clear();
        lblHasil.setText("BMI: -");
        lblKategori.setText("");
    }

    private void tampilkanError(String pesan) {
        lblHasil.setText("BMI: -");
        lblKategori.setText(pesan);
    }
}
