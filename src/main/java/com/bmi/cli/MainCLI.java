package com.bmi.cli;

import com.bmi.model.BMICalculator;

import java.util.Scanner;

/**
 * Tampilan terminal untuk kalkulator BMI.
 */
public class MainCLI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lagi;

        System.out.println("=================================");
        System.out.println("       KALKULATOR BMI (CLI)      ");
        System.out.println("=================================");

        do {
            double berat = bacaAngka(sc, "Berat badan (kg)  : ");
            double tinggi = bacaAngka(sc, "Tinggi badan (cm) : ");

            double bmi = BMICalculator.hitung(berat, tinggi);

            System.out.println("---------------------------------");
            System.out.printf("BMI Anda  : %.2f%n", bmi);
            System.out.println("Kategori  : " + BMICalculator.kategori(bmi));
            System.out.println("---------------------------------");

            System.out.print("Hitung lagi? (y/n): ");
            lagi = sc.nextLine().trim();
        } while (lagi.equalsIgnoreCase("y"));

        System.out.println("Terima kasih!");
        sc.close();
    }

    /** Meminta input angka positif sampai valid. Koma desimal  juga diterima. */
    private static double bacaAngka(Scanner sc, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = sc.nextLine().trim().replace(',', '.');
            try {
                double nilai = Double.parseDouble(input);
                if (nilai > 0) {
                    return nilai;
                }
                System.out.println("Input harus lebih dari 0. Coba lagi.");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
            }
        }
    }
}
