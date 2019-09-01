import org.apache.commons.lang3.StringUtils;

import java.util.*;


import static java.util.Comparator.comparing;

public class Solver {


    /**
     * This method should combine cities (from list of available cities)
     * so that the next one starts with the last letter of the previous.
     *
     * @param availableCities   list of available cities
     * @return List of cities where the next one starts with the last letter of the previous.
     */
    public static List<String> solve(List<String> availableCities) {

        return availableCities.stream().map(s -> buildChain(s, availableCities))
                .max(Comparator.comparing(list -> list.stream()
                        .mapToInt(String::length)
                        .sum()))
                .orElseGet(ArrayList::new);
    }


    private static List<String> buildChain(String s, List<String> list) {
        List<String> copy = new ArrayList<>(list);
        List<String> chain = new ArrayList<>();
        String last = s;
        chain.add(s);
        copy.remove(s);
        for (String next = getNext(last, copy); !next.isEmpty(); next = getNext(last, copy)) {
            chain.add(next);
            copy.remove(next);
            last = next;
        }
        return chain;
    }


    private static String getNext(String target, List<String> list) {
        return list.stream().filter(s -> secondChainsFirst(target, s)).max(comparing(String::length)).orElse(StringUtils.EMPTY);
    }


    private static boolean secondChainsFirst(String first, String second) {
        return first.charAt(first.length() - 1) == second.charAt(0);
    }



}
