class WordDictionary {

    static final int NUM_CHARS = 26;

    WordDictionary[] children;
    boolean isEndofWord;

    public WordDictionary() {
        children = new WordDictionary[NUM_CHARS];
        isEndofWord = false;
    }

    // Add word to Trie
    public void addWord(String word) {
        WordDictionary current = this;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new WordDictionary();
            }

            current = current.children[index];
        }

        current.isEndofWord = true;
    }

    // Search with support for '.'
    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String word, int i, WordDictionary current) {

        // Base case
        if (current == null) return false;

        if (i == word.length()) {
            return current.isEndofWord;
        }

        char ch = word.charAt(i);

        // Case 1: normal character
        if (ch != '.') {
            int index = ch - 'a';
            return dfs(word, i + 1, current.children[index]);
        }

        // Case 2: wildcard '.'
        for (int j = 0; j < 26; j++) {
            if (current.children[j] != null) {
                if (dfs(word, i + 1, current.children[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}