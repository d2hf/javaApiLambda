package lambda;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class Relatorio {

    private String createdAt;
    private double totalBilled = 0;
    private double totalSold = 0;
    private double weightBilled = 0;
    private double inputAnderson = 0;
    private double inputEmpresa = 0;
    private double inputBoaIdeia = 0;
    private double inputFerronato;
    private double inputJuliana;
    private double inputMaxel;
    private double inputSagrima;


    public Relatorio(){
        // empty
    }

    public Relatorio(String createdAt, double totalBilled, double totalSold, double weightBilled, double inputAnderson,
                     double inputEmpresa, double inputBoaIdeia, double inputFerronato, double inputJuliana,
                     double inputMaxel, double inputSagrima) {

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
}
