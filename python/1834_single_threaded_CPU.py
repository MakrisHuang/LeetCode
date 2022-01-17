import heapq
class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        availQ = []
        tasks = [[index, tasks[index][0], tasks[index][1]] for index in range(len(tasks))]    # i, enqueue, processing
        tasks.sort(key=lambda x:x[1])   # sort by enqueue time
        curr_time = tasks[0][1]
        order = []

        def enqueueTasks():
            while tasks and curr_time >= tasks[0][1]:
                task_index, enqueueTime, procTime = tasks.pop(0)
                heapq.heappush(availQ, (procTime, task_index, enqueueTime))

        while tasks:
            enqueueTasks()
            while availQ:
                time_needed, task_index, _ = heapq.heappop(availQ)
                curr_time += time_needed
                order.append(task_index)

                # enqueue all available tasks after each processing
                enqueueTasks()

            # need to update time if there are tasks that come very late
            if tasks and curr_time < tasks[0][1]:
                curr_time = tasks[0][1]

        return order
