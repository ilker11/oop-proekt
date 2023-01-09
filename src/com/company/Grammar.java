package com.company;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grammar {
    private String identifier;
    private List<String> variables;
    private List<String> terminals;
    private List<Rule> rules;

    public Grammar(String identifier, List<String> variables, List<String> terminals, List<Rule> rules) {
        this.identifier = identifier;
        this.variables = variables;
        this.terminals = terminals;
        this.rules = rules;
    }


    public String getIdentifier() {
        return identifier;
    }

    public List<String> getVariables() {
        return variables;
    }

    public List<String> getTerminals() {
        return terminals;
    }

    public List<Rule> getRules() {
        return rules;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grammar ").append(identifier).append(":\n");
        sb.append("Variables: ").append(variables).append("\n");
        sb.append("Terminals: ").append(terminals).append("\n");
        sb.append("Rules:\n");
        for (int i = 0; i < rules.size(); i++) {
            sb.append(i+1).append(". ").append(rules.get(i)).append("\n");
        }
        return sb.toString();
    }

    public void save(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("id: " + identifier);
            writer.write("\nvariables: " + variables);
            writer.write("\nterminals: " + terminals);
            writer.write("\nrules:\n");
            for (Rule rule : rules) {
                writer.write(rule.toString());
                writer.write("\n");
            }
        }
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void removeRule(int index) {
        rules.remove(index);
    }





}
