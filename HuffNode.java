public class HuffNode implements Comparable<HuffNode> {

    public double frequency;
    public HuffNode left;
    public HuffNode right;

    public HuffNode(HuffNode left, HuffNode right) {
        this.left = left;
        this.right = right;

        // Check if left and right are not null before accessing their frequencies
        double leftFrequency = (left != null) ? left.getFrequency() : 0.0;
        double rightFrequency = (right != null) ? right.getFrequency() : 0.0;

        this.frequency = leftFrequency + rightFrequency;
    }

    public HuffNode(double frequency) {
        this.frequency = frequency;
    }


    @Override
    public int compareTo(HuffNode node) {
        return Double.compare(frequency, node.getFrequency());
    }

    public double getFrequency() {
        return frequency;
    }
}