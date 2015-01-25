package kcarlstr.assignment1;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kylecarlstrom on 15-01-15.
 */

public class Expense {
    private Date date;
    private String category;
    private String description;
    private double amount;
    private Currency currency;

    public Expense() {
        // Testing values
        date = new Date();
        category = "Other";
        description = "";
        amount = 0;
        currency = Currency.getInstance("CAD");

    }

    public Expense(Expense copy) {
        this.date = copy.getDate();
        this.category = new String(copy.getCategory());
        this.description = new String(copy.getDescription());
        this.amount = copy.getAmount();
        this.currency = copy.getCurrency();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
