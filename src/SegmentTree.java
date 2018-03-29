/**
 * Created by haosun on 11/27/17.
 */
public class SegmentTree {
    private class SegmentTreeNode {
        private int intervalStart;
        private int intervalEnd;
        private int value;
        private SegmentTreeNode left;
        private SegmentTreeNode right;

        public SegmentTreeNode(int intervalStart, int intervalEnd, int value) {
            this.intervalStart = intervalStart;
            this.intervalEnd = intervalEnd;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public SegmentTreeNode(int intervalStart, int intervalEnd, int value, SegmentTreeNode left, SegmentTreeNode right) {
            this.intervalStart = intervalStart;
            this.intervalEnd = intervalEnd;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getIntervalStart() {
            return intervalStart;
        }

        public void setIntervalStart(int intervalStart) {
            this.intervalStart = intervalStart;
        }

        public int getIntervalEnd() {
            return intervalEnd;
        }

        public void setIntervalEnd(int intervalEnd) {
            this.intervalEnd = intervalEnd;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private SegmentTreeNode root;

    public SegmentTree(int[] array) {
        this.root = constructSegmentTree(array, 0, array.length - 1);
    }

    public SegmentTreeNode constructSegmentTree(int[] array, int start, int end) {
        SegmentTreeNode root = null;
        if (start == end) {
            root = new SegmentTreeNode(start, end, array[start]);
        } else {
            int mid = (start + end) / 2;
            SegmentTreeNode left = constructSegmentTree(array, start, mid);
            SegmentTreeNode right = constructSegmentTree(array, mid + 1, end);
            root = new SegmentTreeNode(start, end, left.getValue() + right.getValue(), left, right);
        }
        return root;
    }

    public int query(int start, int end) {
        return queryUtil(start, end, this.root);
    }

    private int queryUtil(int start, int end, SegmentTreeNode root) {
        if (root == null) return 0;

        if (root.getIntervalEnd() < start || root.getIntervalStart() > end) {
            return 0;
        }

        if (start <= root.getIntervalStart() && end >= root.getIntervalEnd()) {
            return root.getValue();
        }

        return queryUtil(start, end, root.left) + queryUtil(start, end, root.right);
    }

    public void update(int index, int diff) {
        updateUtil(index, diff, this.root);
    }

    private void updateUtil(int index, int diff, SegmentTreeNode root) {
        if (root == null) return;

        if (index >= root.getIntervalStart() && index <= root.getIntervalEnd()) {
            root.setValue(root.getValue() + diff);
        }

        updateUtil(index, diff, root.left);
        updateUtil(index, diff, root.right);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};

        SegmentTree segmentTree = new SegmentTree(array);
        System.out.println(segmentTree.query(1,3));
        segmentTree.update(1, -5);
        System.out.println(segmentTree.query(1,3));
    }
}
