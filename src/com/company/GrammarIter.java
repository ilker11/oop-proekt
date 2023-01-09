package com.company;

import com.company.Grammar;
import com.company.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GrammarIter {
    public static Grammar iterate(Grammar g) {
        String id = g.getIdentifier() + "_iter";
        List<String> vars = g.getVariables();
        List<String> terms = g.getTerminals();
        List<Rule> rules = new ArrayList<>();
        rules.addAll(g.getRules());
        for (Rule rule : g.getRules()) {
            String lhs = rule.getLhs();
            List<String> rhs = rule.getRhs();
            if (rhs.size() == 1 && vars.contains(rhs.get(0))) {
                rules.add(new Rule(lhs, rhs));
            }
        }
        return new Grammar(id, vars, terms, rules);
    }
}
