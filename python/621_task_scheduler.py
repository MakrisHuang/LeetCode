class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counter = dict(collections.Counter(tasks))
        max_freq = max(counter.items(), key=lambda x: x[1])[1]
        max_count = 0
        for key, value in counter.items():
            if value == max_freq:
                max_count += 1

        # partCount = count(A) - 1
        part_count = max_freq - 1

        part_length = n - (max_count - 1)

        # emptySlots = partCount * (n - (count of tasks with most frequency - 1))
        empty_slots = part_count * part_length

        # availableTasks = tasks.length - count(A) * count of tasks with most frenquency
        available_tasks = len(tasks) - max_freq * max_count

        # idles = max(0, emptySlots - availableTasks)
        idles = max(0, empty_slots - available_tasks)

        # result = tasks.length + idles
        return len(tasks) + idles
