#!/usr/bin/env python
# coding: utf-8

# In[11]:


import collections
def dfs(graph_dict: dict, curr: str, target: str, temp: list, res: list, visited: set):
    if curr == target:
        res.append(list(temp))

    if curr in visited: return
    visited.add(curr)
    
    for next_relative in graph_dict[curr]:
        temp.append(next_relative)
        dfs(graph_dict, next_relative[1], target, temp, res, visited)
        temp.pop()

def getRelationships(rels: list, name1: str, name2: str) -> list:
    # build relationship in adjacent list
    # apply dfs
    d = collections.defaultdict(list)
    for rel in rels:
        name = rel[0]
        d[name].append(rel[1:])
    res = []
    dfs(d, name1, name2, [], res, set())
    return res


# In[12]:


rels = [
    ["Bart", "brother", "Lisa"], 
    ["Bart", "son", "Homer"], 
    ["Marge", "wife", "Homer"], 
    ["Lisa", "daughter", "Homer"]
]
name1 = "Bart"
name2 = "Homer"


# In[13]:


getRelationships(rels, name1, name2)


# In[7]:


# 1 -> 2
# 2 -> 3
# 4 -> 2
# 1 -> 4


# input: 1, 3
# output: 1->2->3, 1->4->2->3


# In[ ]:




