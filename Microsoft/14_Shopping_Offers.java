import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution 
{
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) 
    {
        // Use a map to store previously computed results for memoization
        return dfs(price, special, needs, new HashMap<>());
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) 
    {
        // Check memoized results
        if (memo.containsKey(needs)) 
            return memo.get(needs);

        // Calculate the base cost without any offers
        int baseCost = calculateBaseCost(price, needs);

        // Try applying each special offer
        for (List<Integer> offer : special) 
        {
            if (canApplyOffer(offer, needs)) 
            {
                List<Integer> newNeeds = applyOffer(offer, needs);
                baseCost = Math.min(baseCost, offer.get(price.size()) + dfs(price, special, newNeeds, memo));
            }
        }

        // Save the result in the memoization map
        memo.put(needs, baseCost);
        return baseCost;
    }

    // Helper function to calculate the base cost without offers
    private int calculateBaseCost(List<Integer> price, List<Integer> needs) 
    {
        int cost = 0;
        for (int i = 0; i < price.size(); i++) 
            cost += needs.get(i) * price.get(i);
        return cost;
    }

    // Helper function to check if an offer can be applied
    private boolean canApplyOffer(List<Integer> offer, List<Integer> needs) 
    {
        for (int i = 0; i < needs.size(); i++) 
        {
            if (offer.get(i) > needs.get(i))
                return false;
        }
        return true;
    }

    // Helper function to apply an offer and get the updated needs list
    private List<Integer> applyOffer(List<Integer> offer, List<Integer> needs) 
    {
        List<Integer> newNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) 
            newNeeds.add(needs.get(i) - offer.get(i));
        return newNeeds;
    }
}