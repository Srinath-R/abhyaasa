package sri.misc;

// Java program for Boggle game
public class WordBoggle {
    private static int m = 3;
    private static int n = 3;

    public static class TrieNode {
        private static final int DEFAULT_SIZE = 26;
        private TrieNode[] children;
        private boolean leaf;

        public TrieNode() {
            this(DEFAULT_SIZE);
        }

        public TrieNode(int childrenSize) {
            this.leaf = false;
            this.children = new TrieNode[childrenSize];
            for (int i = 0; i < childrenSize; i++) {
                children[i] = null;
            }
        }

        public static int getDefaultSize() {
            return DEFAULT_SIZE;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }
    }

    public static void insert(TrieNode root, String key) {
        int n = key.length();
        TrieNode pChild = root;
        for (int i = 0; i < n; i++) {
            int pos = key.charAt(i) - 'A';
            if (pChild.getChildren()[pos] == null)
                pChild.getChildren()[pos] = new TrieNode();
            pChild = pChild.getChildren()[pos];
        }
        pChild.setLeaf(true);
    }

    private static void findWords(char[][] boggled, TrieNode root) {
        boolean[][] visited = new boolean[m][n];
        String hit = "";
        TrieNode pChild = root;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (pChild.getChildren()[boggled[i][j] - 'A'] != null) {
                    hit = hit + boggled[i][j];
                    matchWord(boggled, i, j, pChild.getChildren()[boggled[i][j] - 'A'], visited, hit);
                    hit = "";
                }
            }
    }

    private static void matchWord(char[][] boggled, int i, int j, TrieNode root, boolean[][] visited, String hit) {
        if (root.isLeaf()) {
            System.out.println(hit);
        }
        if (isSafe(i, j, visited)) {
            visited[i][j] = true;
            for (int k = 0; k < root.getChildren().length; k++) {
                if (root.getChildren()[k] != null) {
                    char c = (char) ('A' + k);
                    if (isSafe(i + 1, j + 1, visited) && boggled[i + 1][j + 1]
                            == c)
                        matchWord(boggled, i + 1, j + 1, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i, j + 1, visited) && boggled[i][j + 1]
                            == c)
                        matchWord(boggled, i, j + 1, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i - 1, j + 1, visited) && boggled[i - 1][j + 1]
                            == c)
                        matchWord(boggled, i - 1, j + 1, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i + 1, j, visited) && boggled[i + 1][j]
                            == c)
                        matchWord(boggled, i + 1, j, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i + 1, j - 1, visited) && boggled[i + 1][j - 1]
                            == c)
                        matchWord(boggled, i + 1, j - 1, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i, j - 1, visited) && boggled[i][j - 1]
                            == c)
                        matchWord(boggled, i, j - 1, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i - 1, j - 1, visited) && boggled[i - 1][j - 1]
                            == c)
                        matchWord(boggled, i - 1, j - 1, root.getChildren()[k],
                                visited, hit + c);
                    if (isSafe(i - 1, j, visited) && boggled[i - 1][j]
                            == c)
                        matchWord(boggled, i - 1, j, root.getChildren()[k],
                                visited, hit + c);
                }
            }
            visited[i][j] = false;
        }
    }

    private static boolean isSafe(int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < m && j < n && !visited[i][j];
    }

    // Driver program to test above function
    public static void main(String args[]) {
        // Let the given dictionary be following
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};

        // root Node of trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie
        int n = dictionary.length;
        for (int i = 0; i < n; i++)
            insert(root, dictionary[i]);

        char boggle[][] = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        findWords(boggle, root);

    }
}
