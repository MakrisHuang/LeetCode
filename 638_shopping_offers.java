class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int calculatedSum = dfs (new HashMap<> (), price, special, needs);
        int regularSum = 0;
        for (int idx = 0; idx < needs.size(); idx ++) regularSum += needs.get (idx) * price.get (idx);
        return Math.min (calculatedSum, regularSum);
    }
    
    private int dfs (Map<String, Integer> map, List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (map.containsKey (needs.toString())) return map.get (needs.toString());
        
        int sum = Integer.MAX_VALUE;
        for (List<Integer> offer : special) {
            List<Integer> reducedNeeds = reduce (offer, needs);
            if (reducedNeeds != null) 
                sum = Math.min (sum, offer.get (offer.size () - 1) + dfs (map, price, special, reducedNeeds));
        }
        
        if (sum == Integer.MAX_VALUE) {
            sum = 0;
            for (int idx = 0; idx < needs.size(); idx ++) sum += needs.get (idx) * price.get (idx);
        }
        
        map.put (needs.toString(), sum);
        return sum;
    }
    
    private List<Integer> reduce (List<Integer> offer, List<Integer> needs) {
        List<Integer> reducedNeeds = new ArrayList<>();
        for (int idx = 0; idx < needs.size (); idx ++) 
            if (offer.get (idx) > needs.get (idx)) return null;
            else reducedNeeds.add (needs.get (idx) - offer.get (idx));
        return reducedNeeds;
    }
}