package com.exercise.domain;

public class Professional extends Client {

    private String companyName;
    private String siren;
    private String vatNumber;
    private double annualRevenue;

    public Professional(String id, String companyName, String siren, String vatNumber, double annualRevenue) {
        super(id);
        this.companyName = companyName;
        this.siren = siren;
        this.vatNumber = vatNumber;
        this.annualRevenue = annualRevenue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}