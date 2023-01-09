package com.company;

import java.util.List;

public class GrammarCYK {
    public static boolean isInLanguage(Grammar g, String word) {
        int n = word.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String symbol = word.substring(i, i + 1);
            dp[i][i] = g.getTerminals().contains(symbol);
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    for (Rule rule : g.getRules()) {
                        List<String> rhs = rule.getRhs();
                        if (rhs.size() == 2 && g.getVariables().contains(rhs.get(0)) && g.getVariables().contains(rhs.get(1))) {
                            if (dp[i][k] && dp[k + 1][j] && g.getVariables().contains(rule.getLhs())) {
                                dp[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}


