class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int key : map.keySet()){
            heap.offer(new int[]{key,map.get(key)});

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while(!heap.isEmpty()){
            ans[i++] = heap.poll()[0];
        }

        return ans;
    }
}
