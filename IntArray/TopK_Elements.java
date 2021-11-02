class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((node1, node2) -> (node2.freq - node1.freq));
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                Node node = new Node(nums[i]);
                node.freq = 1;
                map.put(nums[i], node);
                queue.offer(node);
            } else {
                Node node = map.get(nums[i]);
                Node newNode = new Node(nums[i]);
                newNode.freq = node.freq + 1;
                queue.remove(node);
                queue.offer(newNode);
                map.put(nums[i], newNode);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (queue.peek() != null) {
                list.add(queue.poll().val);
            } else {
                break;
            }
        }
      return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private class Node {
        int val;
        int freq;
        public Node(int val) {
            this.val = val;
        }
    }
}
