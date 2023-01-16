package com.company;

import java.util.*;

class ChomskyConverter {
    private final Grammar grammar;
    private final Map<String, String> newVariables = new HashMap<>();
    private int variableCounter = 0;

    public ChomskyConverter(Grammar grammar) {
        this.grammar = grammar;
    }

    public GrammarChomsky convert() {
        List<Rule> newRules = new ArrayList<>();
        for (Rule rule : grammar.getRules()) {
            List<String> expansions = rule.getRhs();
            if (expansions.size() == 1) {
                if (!grammar.getVariables().contains(expansions.get(0))) {
                    newRules.add(rule);
                }
            } else if (expansions.size() == 2) {
                newRules.add(rule);
            } else {
                String variable = rule.getLhs();
                for (int i = 0; i < expansions.size() - 2; i++) {
                    String newVariable = getNewVariable(variable);
                    newVariables.put(variable, newVariable);
                    variable = newVariable;
                }
                newRules.add(new Rule(variable, Arrays.asList(expansions.get(expansions.size() - 2), expansions.get(expansions.size() - 1))));
            }
        }

        // update variables
        Set<String> newVariablesSet = new HashSet<>();
        for (String v : grammar.getVariables()) {
            newVariablesSet.add(v);
            while (newVariables.containsKey(v)) {
                v = newVariables.get(v);
                newVariablesSet.add(v);
            }
        }

        return new GrammarChomsky(grammar.getIdentifier() + "_Chomsky", new ArrayList<>(newVariablesSet), grammar.getTerminals(), newRules);
    }

    private String getNewVariable(String variable) {
        return variable + "_" + (variableCounter++);
    }
}
