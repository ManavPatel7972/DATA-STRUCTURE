public class ImplementationTrie {

    class Node {
        Node link[];
        boolean flag;

        Node() {
            link = new Node[26];
            flag = false;
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

        }

        // last was EndOfWord So last reference is True
        node.flag = true;
    }

    public boolean search(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            if (!node.containsKey(word.charAt(i))) {
                return false;
            }

            node = node.get(word.charAt(i));
        }

        // after check last reference is true or not ??
        if (node.flag == true) {
            return true;
        }

        return false;
    }

    public boolean startsWith(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            if (!node.containsKey(word.charAt(i))) {
                return false;
            }

            node = node.get(word.charAt(i));

        }

        return true;
    }

    public static void main(String[] args) {

        ImplementationTrie trie = new ImplementationTrie();

        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apxl");
        trie.insert("bac");
        trie.insert("bat");

        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.search("apps")); // true
        System.out.println(trie.search("bat")); // true

        System.out.println(trie.startsWith("ap")); // true
        System.out.println(trie.startsWith("apx")); // true
        System.out.println(trie.startsWith("ba")); // true
        System.out.println(trie.startsWith("ca")); // false
    }

}