package com.company;

import java.util.List;

public class Rule {
    private String lhs;
    private List<String> rhs;

    public Rule(String lhs, List<String> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String getLhs() {
        return lhs;
    }

    public List<String> getRhs() {
        return rhs;
    }

    @Override
    public String toString() {
        return "Rule{lhs='" + lhs + "', rhs=" + rhs + "}";
    }
}