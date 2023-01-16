package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class EmptyChecker {
    private final Grammar grammar;
    private final Set<String> emptyVariables = new HashSet<>();

    public EmptyChecker(Grammar grammar) {
        this.grammar = grammar;
        findEmptyVariables();
    }

    private void findEmptyVariables() {
        boolean changesMade;
        do {
            changesMade = false;
            for (Rule rule : grammar.getRules()) {
                String variable = rule.getLhs();
                List<String> expansions = rule.getRhs();
                for (String expansion : expansions) {
                    if (expansion.isEmpty()) {
                        emptyVariables.add(variable);
                        changesMade = true;
                    } else {
                        boolean isEmpty = true;
                        for (int i = 0; i < expansion.length(); i++) {
                            if (!emptyVariables.contains(expansion.charAt(i) + "") && !grammar.getTerminals().contains(expansion.charAt(i) + "")) {
                                isEmpty = false;
                                break;
                            }
                        }
                        if (isEmpty) {
                            emptyVariables.add(variable);
                            changesMade = true;
                        }
                    }
                }
            }
        } while (changesMade);
    }

    public boolean isEmpty() {
        for (String variable : grammar.getVariables()) {
            if (!emptyVariables.contains(variable)) {
                return false;
            }
        }
        return true;
    }
}


