public class CountStartWith {

    class Node {
        Node link[];
        int cntEndWith = 0;
        int cntPrefix = 0;

        public Node() {
            link = new Node[26];

        }

        // check word is exist in the trie or Not
        boolean containsKey(char ch) {
            return link[ch - 'a'] != null;
        }

        // put word in the trie
        void put(char ch, Node node) {
            link[ch - 'a'] = node;
        }

        // move to new reference
        Node get(char ch) {
            return link[ch - 'a'];
        }

        // Increase count Hole word
        void increaseEnd() {
            cntEndWith++;
        }

        // Increase count starting with how many word
        void increasePrefix() {
            cntPrefix++;
        }

        // reducePrefix starting with word when delete word or erase
        void reducePrefix() {
            cntPrefix--;
        }

        void deleteEnd() {
            cntEndWith--;
        }

        int getEnd() {
            return cntEndWith;
        }

        int getPrefix() {
            return cntPrefix;
        }

    }

    Node root = new Node();

    public void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }

            // move to next reference
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }

        node.increaseEnd();

    }

    public int countWordsEqualTo(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }

        return node.getEnd();
    }

    public int countWordStartingWith(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }

        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }

    public static void main(String[] args) {

        CountStartWith trie = new CountStartWith();

        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apxl");
        trie.insert("bac");
        trie.insert("bat");

        System.out.println("countWordStartingWith ==  " + trie.countWordStartingWith("app")); // 3
        System.out.println("countWordsEqualTo ==  " + trie.countWordsEqualTo("apple")); // 2

    }

}