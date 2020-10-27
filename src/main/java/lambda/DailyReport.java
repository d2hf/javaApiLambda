package lambda;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class DailyReport {

    private String createdAt;
    private double totalBilled = 0;
    private double totalSold = 0;
    private double weightBilled = 0;
    private double inputAnderson = 0;
    private double inputEmpresa = 0;
    private double inputBoaIdeia = 0;
    private double inputFerronato = 0;
    private double inputJuliana = 0;
    private double inputMaxel = 0;
    private double inputSagrima = 0;
    private int quartile1 = 0;
    private int quartile2 = 0;
    private int quartile3 = 0;
    private int quartile4 = 0;


    public DailyReport(){
        // empty
    }

    public DailyReport(String createdAt, double totalBilled, double totalSold, double weightBilled, double inputAnderson,
                       double inputEmpresa, double inputBoaIdeia, double inputFerronato, double inputJuliana,
                       double inputMaxel, double inputSagrima, int quartile1, int quartile2, int quartile3, int quartile4) {

        this.createdAt = createdAt;
        this.totalBilled = totalBilled;
        this.totalSold = totalSold;
        this.weightBilled = weightBilled;
        this.inputAnderson = inputAnderson;
        this.inputEmpresa = inputEmpresa;
        this.inputBoaIdeia = inputBoaIdeia;
        this.inputFerronato = inputFerronato;
        this.inputJuliana = inputJuliana;
        this.inputMaxel = inputMaxel;
        this.inputSagrima = inputSagrima;
        this.quartile1 = quartile1;
        this.quartile2 = quartile2;
        this.quartile3 = quartile3;
        this.quartile4 = quartile4;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotalBilled() {
        return totalBilled;
    }

    public void setTotalBilled(double totalBilled) {
        this.totalBilled = totalBilled;
    }

    public double getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(double totalSold) {
        this.totalSold = totalSold;
    }

    public double getWeightBilled() {
        return weightBilled;
    }

    public void setWeightBilled(double weightBilled) {
        this.weightBilled = weightBilled;
    }

    public double getInputAnderson() {
        return inputAnderson;
    }

    public void setInputAnderson(double inputAnderson) {
        this.inputAnderson = inputAnderson;
    }

    public double getInputEmpresa() {
        return inputEmpresa;
    }

    public void setInputEmpresa(double inputEmpresa) {
        this.inputEmpresa = inputEmpresa;
    }

    public double getInputBoaIdeia() {
        return inputBoaIdeia;
    }

    public void setInputBoaIdeia(double inputBoaIdeia) {
        this.inputBoaIdeia = inputBoaIdeia;
    }

    public double getInputFerronato() {
        return inputFerronato;
    }

    public void setInputFerronato(double inputFerronato) {
        this.inputFerronato = inputFerronato;
    }

    public double getInputJuliana() {
        return inputJuliana;
    }

    public void setInputJuliana(double inputJuliana) {
        this.inputJuliana = inputJuliana;
    }

    public double getInputMaxel() {
        return inputMaxel;
    }

    public void setInputMaxel(double inputMaxel) {
        this.inputMaxel = inputMaxel;
    }

    public double getInputSagrima() {
        return inputSagrima;
    }

    public void setInputSagrima(double inputSagrima) {
        this.inputSagrima = inputSagrima;
    }

    public int getQuartile1() {
        return quartile1;
    }

    public void setQuartile1(int quartile1) {
        this.quartile1 = quartile1;
    }

    public int getQuartile2() {
        return quartile2;
    }

    public void setQuartile2(int quartile2) {
        this.quartile2 = quartile2;
    }

    public int getQuartile3() {
        return quartile3;
    }

    public void setQuartile3(int quartile3) {
        this.quartile3 = quartile3;
    }

    public int getQuartile4() {
        return quartile4;
    }

    public void setQuartile4(int quartile4) {
        this.quartile4 = quartile4;
    }
}
