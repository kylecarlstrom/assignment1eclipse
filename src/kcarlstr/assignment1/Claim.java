package kcarlstr.assignment1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kylecarlstrom on 15-01-15.
 */
public class Claim {
    // For progress: 0 = in progress, 1 = submitted, 2 = returned, 3 = approved;
    private String progress;
    private Date startDate;
    private Date endDate;
    private String claimDescription;
    private ArrayList<Expense> expenses;
    private Map<String, Double> currencyAmounts = new HashMap<String, Double>();

    public Claim() {
        this.startDate = new Date();
        this.endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24));
        this.claimDescription = null;
        this.expenses = new ArrayList<Expense>();
        this.progress = "In Progress";
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }


    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    private void updateCurrencyAmounts() {
        currencyAmounts.clear();
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            String currencyCode = expense.getCurrency().getCurrencyCode();
            if (currencyAmounts.containsKey(currencyCode)) {
                double amount = currencyAmounts.get(currencyCode);
                amount += expense.getAmount();
                currencyAmounts.put(currencyCode, amount);
            } else {
                currencyAmounts.put(currencyCode, expense.getAmount());
            }
        }
    }

    public Map<String, Double> getCurrencyAmounts() {
        updateCurrencyAmounts();
        return currencyAmounts;
    }
}

class ClaimComparator implements Comparator<Claim> {
    public int compare(Claim claim1, Claim claim2) {
        return claim1.getStartDate().compareTo(claim2.getStartDate());
    }
}