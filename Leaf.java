public class Leaf extends HuffNode{
    public final char character;

    public Leaf(char character , double frequency){
        super(frequency);
        this.character = character;
        this.frequency = frequency;
    }
    // leaf nodes need to have char values and their frequencies , huffnode should just carry frequencies because
    // a parent node of a couple leaf should be the sum of the frequencies of the leaves . so that , huffnode
    //have frequency value , left node and right node. there is no need to define left or right for leaf. it is extended.
}
