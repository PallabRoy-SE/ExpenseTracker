package com.pspallabroy.expensetracker.views.models;

import androidx.annotation.Nullable;

import java.util.Date;

public class DetailsItem {
    private int id;
    private double amount;
    private Date date;
    private String description;

    public DetailsItem(int id, double amount, @Nullable String description) {
        this.id = id;
        this.amount = amount;
        this.date = new Date();
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
