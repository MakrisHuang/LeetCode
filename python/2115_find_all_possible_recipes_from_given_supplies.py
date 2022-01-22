class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        # Construct directed graph and count the in-degrees
        ingredient_to_recipe, in_degree = defaultdict(set), Counter()
        for rcp, ingredient in zip(recipes, ingredients):
            for ing in ingredient:
                ingredient_to_recipe[ing].add(rcp)
            in_degree[rcp] = len(ingredient)    # how many ingredients can form this recipe

        # Topological sort.
        visited = set()
        available, ans = deque(supplies), []
        while available:
            ing = available.popleft()
            if ing not in visited:  # we don't know what recipes this ingred can contribute
                visited.add(ing)
                for rcp in set(ingredient_to_recipe[ing]):  # so traverse all recipe
                    in_degree[rcp] -= 1                     # this ingred contributes to this recipe, so minus 1
                    if in_degree[rcp] == 0:                 # we visited all ingred that can form this recipe
                        available.append(rcp)               # append this ingred as an available resource
                        ans.append(rcp)                     # and append recipe to the answer
        return ans

