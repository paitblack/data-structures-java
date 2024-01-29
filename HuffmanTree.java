import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree{
    private HuffNode root;

    public HuffmanTree(LinkedList<Character> sortedList,LinkedHashMap<Character,Double> sortedDict) {
        buildTree(sortedList,sortedDict);
    }

   /* IT DID NOT WORKED , (NULLPOINT ERROR)
   public void buildTree(LinkedList<Character> sortedList, LinkedHashMap<Character, Double> sortedDict) {
        LinkedList<Double> Frequencies = new LinkedList<>();
        Node<Character> iterator = sortedList.head;
        while (iterator != null) {
            Frequencies.insertToEnd(sortedDict.get(iterator.value));
            iterator = iterator.next;
        }
        sortedList.display();
        Frequencies.display();
        while (Frequencies.count() > 1) {
            if (!Frequencies.isEmpty()) {
                double freq1 = Frequencies.getFirstOne();

                if (!Frequencies.isEmpty()) {  // Check if Frequencies is still not empty
                    double freq2 = Frequencies.getFirstOne();

                    HuffNode node1 = new Leaf(sortedList.getFirstOne(), freq1);
                    HuffNode node2 = new Leaf(sortedList.getFirstOne(), freq2);

                    HuffNode internalNode = new HuffNode(node1, node2);

                    Frequencies.sortedInsert(internalNode.getFrequency());
                }
            }
        }
        root = new Leaf(sortedList.getFirstOne(), Frequencies.getFirstOne());
    }

    */
   private void buildTree(LinkedList<Character> sortedList, LinkedHashMap<Character, Double> sortedDict) {
       PriorityQueue<HuffNode> priorityQueue = new PriorityQueue<>();  // priority queue to store nodes based on their frequencies.

       for (char character : sortedDict.keySet()) {   // characters should be stored in the leaf nodes.
           Leaf leafNode = new Leaf(character, sortedDict.get(character));
           priorityQueue.add(leafNode);
       }

       while (priorityQueue.size() > 1) {   // building the huffman tree by merging nodes until only one node (the root) is left.
           HuffNode node1 = priorityQueue.poll();
           HuffNode node2 = priorityQueue.poll();

           HuffNode internalNode = new HuffNode(node1, node2);

           priorityQueue.add(internalNode);
       }

       root = priorityQueue.poll(); // the last one is the root.
   }

    /* public double getFrequency(char character , LinkedHashMap<Character, Double> sortedDict) {
        if (sortedDict.containsKey(character)) {
            return sortedDict.get(character);
        }
        return 0.0;
    }
     */
    public void displayCodes() {   // a recursive function is used to display codes.
        displayCodes(root, "");
    }

    private void displayCodes(HuffNode node, String code) {  // this is for display each of the huffnodes' code.
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            System.out.println("Character: " + leaf.character + ", Code: " + code);
        } else {
            displayCodes(node.left, code + "0");
            displayCodes(node.right, code + "1");
        }
    }
    public String encoder(String sourceText){   // to preapare it for being encoded. (string converter)
       StringBuilder st = new StringBuilder();
       for (char character : sourceText.toCharArray()){
           st.append(encodeChar(character));
       }
       return st.toString();
    }
    private String encodeChar(char ch){     //to get the huffman code for a single character.
        Map<Character, String> codeMap = displayMapEncoded(root, "");
        return codeMap.get(ch);
    }

    private Map<Character, String> displayMapEncoded(HuffNode hnode, String s) {  //recursive function to build a map of characters to their huff codes
        Map<Character, String> codeMap = new HashMap<>();
        if (hnode instanceof Leaf) {
            Leaf leaf = (Leaf) hnode;
            codeMap.put(leaf.character, s);
        } else {
            codeMap.putAll(displayMapEncoded(hnode.left, s + "0"));
            codeMap.putAll(displayMapEncoded(hnode.right, s + "1"));
        }
        return codeMap;
    }
    public String decoder(String encoded){   // decode the encoded string using the huff tree
        StringBuilder decodedString = new StringBuilder();
        int index = 0;
        while (index < encoded.length()) {
            index = decodeChar(encoded, index, decodedString);
        }
        return decodedString.toString();
    }

    private int decodeChar(String encoded, int index, StringBuilder decodedString) { ///a function to decode a single character in the encoded string
        HuffNode current = root;
        while (!(current instanceof Leaf)) {  // traverse the tree until a leaf node is reached
            char bit = encoded.charAt(index++);
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            }
        }
        Leaf leaf = (Leaf) current;
        decodedString.append(leaf.character);
        return index;
    }
    public boolean checkCode(String code){
        HuffNode iterator=root;
        if (root==null)
            return false;
        for (int i=0;i<code.length();i++){
            if (code.charAt(i)=='0'&&iterator.left!=null){
                iterator=iterator.left;
            }
            else if(code.charAt(i)=='1'&&iterator.right!=null){
                iterator=iterator.right;
            } else return false;
        }
        return true;
    }
}