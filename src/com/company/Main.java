package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Grammar grammar = readGrammar("/E:/grammar1.txt");
        Grammar grammar2 = readGrammar("/E:/grammar2.txt");

        String word = "01010101";
        boolean isInLanguage = GrammarCYK.isInLanguage(grammar2, word);





        // Rule newRule = new Rule("S", List.of("A", "D"));
        // grammar.addRule(newRule);

        // grammar.removeRule(5);

        // grammar2.save("/E:/grammar4.txt");

        List<String> symbols = List.of("A", "B");
        List<String> expected = List.of("a", "A", "b", "B");

        System.out.print(grammar);
        System.out.print(grammar2);





        System.out.println(isInLanguage ? "Word is in language" : "Word is not in language");


        EmptyChecker emptyChecker = new EmptyChecker(grammar);
        boolean isEmpty = emptyChecker.isEmpty();
        if (isEmpty) {
            System.out.println("The language generated by the grammar is empty.");
        } else {
            System.out.println("The language generated by the grammar is not empty.");
        }



        ChomskyConverter chomskyConverter = new ChomskyConverter(grammar);
        GrammarChomsky chomskyGrammar = chomskyConverter.convert();
        boolean isChomsky = chomskyGrammar.isChomsky();
        if (isChomsky) {
            System.out.println("The grammar is in Chomsky normal form: " + chomskyGrammar.getIdentifier());
        } else {
            System.out.println("The grammar is not in Chomsky normal form: " + chomskyGrammar.getIdentifier());
        }






    }

    public static Grammar readGrammar(String filePath) throws FileNotFoundException {
        String id = "";
        List<String> variables = new ArrayList<>();
        List<String> terminals = new ArrayList<>();
        List<Rule> rules = new ArrayList<>();

        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("id:")) {
                id = line.substring(4).trim();
            } else if (line.startsWith("variables:")) {
                variables = parseList(line.substring(11));
            } else if (line.startsWith("terminals:")) {
                terminals = parseList(line.substring(11));
            } else if (line.startsWith("rules:")) {
                rules = parseRules(scanner);
            }
        }
        scanner.close();

        return new Grammar(id, variables, terminals, rules);
    }

    private static List<String> parseList(String listStr) {
        List<String> list = new ArrayList<>();
        for (String element : listStr.split(",")) {
            list.add(element.trim());
        }
        return list;
    }

    private static List<Rule> parseRules(Scanner scanner) {
        List<Rule> rules = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split("->");
            String lhs = parts[0].trim();
            List<String> rhs = parseList(parts[0]);
            rules.add(new Rule(lhs, rhs));
        }
        return rules;
    }

}
