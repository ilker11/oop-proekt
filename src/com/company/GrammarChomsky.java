package com.company;

import java.util.List;

public class GrammarChomsky {
    private String identifier;
    private List<String> variables;
    private List<String> terminals;
    private List<Rule> rules;

    public GrammarChomsky(String identifier, List<String> variables, List<String> terminals, List<Rule> rules) {
        this.identifier = identifier;
        this.variables = variables;
        this.terminals = terminals;
        this.rules = rules;
    }

    public boolean isChomsky() {
        for (Rule rule : rules) {
            String left = rule.getLhs();
            List<String> right = rule.getRhs();
            if (!variables.contains(left)) {
                // Left side is not a variable
                return false;
            }
            if (right.size() > 2 || (right.size() == 2 && !variables.contains(right))) {
                // Right side has more than 2 symbols or has 2 symbols and at least one is not a variable
                return false;
            }
        }
        return true;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<String> getVariables() {
        return variables;
    }

    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    public List<String> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<String> terminals) {
        this.terminals = terminals;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
