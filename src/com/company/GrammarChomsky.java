package com.company;

import java.util.List;

public class GrammarChomsky {
    public static boolean isChomsky(Grammar g) {
        for (Rule rule : g.getRules()) {
            String left = rule.getLhs();
            List<String> right = rule.getRhs();
            if (!g.getVariables().contains(left)) {
                // Left side is not a variable
                return false;
            }
            if (right.size() > 2 || (right.size() == 2 && !g.getVariables().contains(right))) {
                // Right side has more than 2 symbols or has 2 symbols and at least one is not a variable
                return false;
            }
        }
        return true;
    }
}
