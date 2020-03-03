package crack.code.interview.algorithms.hard;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        int numCompetitors = 5;
        int topNCompetitors = 2;
        List<String> competitors = new ArrayList<>();

        competitors.add("cellular");
        competitors.add("anacell");
        int numReviews = 3;
        List<String> reviews = new ArrayList<>();
        reviews.add("cellular anacell");
        reviews.add("anacell cellular");
        reviews.add("anacell cellular");

        System.out.println("DynamicProgramming: " +
                topNCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews));
    }


    public static ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews)
    {
        // WRITE YOUR CODE HERE
        Map<String, Integer> competitorsFrequencyMap = new HashMap<>();

        for (int i = 0; i < numReviews; i++) {

            String currentReview = reviews.get(i);
            String[] wordsInReview = currentReview.split(" ");
            int n = wordsInReview.length;
            List<String> competitorsCloneList = new ArrayList<String>(competitors);
            for (int j = 0; j < n; j++) {

                if (!competitorsCloneList.isEmpty()) {

                    if (competitorsCloneList.contains(wordsInReview[j])) {

                        if (competitorsFrequencyMap.containsKey(wordsInReview[j])) {
                            int freq = competitorsFrequencyMap.get(wordsInReview[j]) + 1;
                            competitorsFrequencyMap.put(wordsInReview[j], freq);
                        } else {
                            competitorsFrequencyMap.put(wordsInReview[j], 1);
                        }
                        competitorsCloneList.remove(wordsInReview[j]);
                    }

                }

            }
        }
        //Now get the top n competitors
        LinkedHashMap<String, Integer> sortedCompetitors = new LinkedHashMap<>();

        competitorsFrequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .forEachOrdered(x -> sortedCompetitors.put(x.getKey(), x.getValue()));

        int res = 0;
        List<String> result = new ArrayList<>();
        for (String name : sortedCompetitors.keySet()) {

            if (res < numCompetitors) {
                result.add(name);
            } else {
                break;
            }

        }


        return new ArrayList<String>(result);

    }



    void updateRight(int i, int j, List<List<Integer>> grid) {

        if ((i > 0 && i < grid.size()) && (j > 0 &&  j <grid.get(i).size())) {
            grid.get(i).set(j, 1);
        }


    }

    void updateGrid(List<List<Integer>> grid) {

        for (int i = 0; i < grid.size(); i++) {

            for (int j = 0; j < grid.get(0).size(); j++) {

                if (grid.get(i).get(j) == 1 ) {
                    System.out.println("this is 1");
                }
            }
        }
    }



}
