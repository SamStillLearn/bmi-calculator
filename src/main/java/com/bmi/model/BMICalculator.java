package com.bmi.model;

/**
 * Kategori mengikuti standar WHO.
 */
public class BMICalculator {

    private BMICalculator() {
    }

    /**
     * @param beratKg  berat badan dalam kilogram
     * @param tinggiCm tinggi badan dalam sentimeter
     * @return nilai BMI
     */
    public static double hitung(double beratKg, double tinggiCm) {
        if (beratKg <= 0 || tinggiCm <= 0) {
            throw new IllegalArgumentException("Berat dan tinggi harus lebih dari 0.");
        }
        double tinggiM = tinggiCm / 100.0;
        return beratKg / (tinggiM * tinggiM);
    }

    public static String kategori(double bmi) {
        if (bmi < 18.5) {
            return "Berat badan kurang";
        } else if (bmi < 25) {
            return "Berat badan normal";
        } else if (bmi < 30) {
            return "Berat badan berlebih";
        } else {
            return "Obesitas";
        }
    }
}
