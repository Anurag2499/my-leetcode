class MedianFinder {
    List<Integer> l = new ArrayList<>();
    PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(Collections.reverseOrder());

    PriorityQueue<Integer> minH = new PriorityQueue<Integer>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxH.size() == 0) {
            maxH.add(num);
            return;
        }
        if (maxH.peek() >= num) {
            if (maxH.size() == minH.size()) {
                maxH.add(num);
            } else if (maxH.size() > minH.size()) {
                int rem = maxH.remove();
                minH.add(rem);
                maxH.add(num);
            }
        } else {
            if (minH.size() == 0)
                minH.add(num);

            else if (num > minH.peek()) {
                if (maxH.size() == minH.size()) {
                    int rem = minH.remove();
                    minH.add(num);
                    maxH.add(rem);
                } else if (maxH.size() > minH.size()) {
                    minH.add(num);
                }
            } else if (num <= minH.peek()) {
                if (maxH.size() == minH.size()) {
                    maxH.add(num);
                } else if (maxH.size() > minH.size()) {
                    minH.add(num);
                }
            }
        }

    }

    public double findMedian() {
        if (maxH.size() == minH.size()) {
            return (double) (maxH.peek() + minH.peek()) / 2;

        }
        return maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */