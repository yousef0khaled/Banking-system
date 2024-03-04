package org.example.banksystem.dao;

public class Loan {
    private int loan_no;
    private String loan_type;
    public Integer loan_amnt;



    public Loan(int loan_no, String loan_type, Integer loan_amnt) {
        this.loan_no =loan_no ;
        this.loan_type = loan_type;
        this.loan_amnt = loan_amnt;


    }

    public int getLoansNumber() {
        return loan_no;
    }

    public void setLoansNumber(int loan_no) {
        this.loan_no = loan_no;
    }

    public String getLoansType() {
        return loan_type;
    }

    public void setLoansType(String loan_type) {
        this.loan_type = loan_type;
    }

    public Integer getLoanAmount() {
        return loan_amnt;
    }

    public void setLoanAmount(Integer loan_amnt) {
        this.loan_amnt = loan_amnt;
    }



    public String toString() {
        //return loan_type;
        return "TYPE: " +  loan_type + "\n " ;
    }



}
