package com.company;

import java.util.List;
import java.util.ArrayList;

public class GrammarList {
    private List<String> grammarIds;

    public GrammarList() {
        grammarIds = new ArrayList<>();
    }

    public void addGrammar(String id) {
        grammarIds.add(id);
    }

    public List<String> getGrammarIds() {
        return grammarIds;
    }
}

