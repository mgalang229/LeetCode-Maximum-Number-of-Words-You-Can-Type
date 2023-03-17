class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        ArrayList<String> words = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words.add(temp);
                temp = "";
            } else {
                temp += text.charAt(i);
            }
        }
        words.add(temp);
        boolean[] broken = new boolean[26];
        Arrays.fill(broken, false);
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken[(int)((int)brokenLetters.charAt(i)-'a')] = true;
        }
        int count = 0;
        for (String word : words) {
            boolean checker = true;
            for (int i = 0; i < word.length(); i++) {
                if (broken[word.charAt(i)-'a']) {
                    checker = false;
                    break;
                }
            }
            if (checker) {
                count++;
            }
        }
        return count;
    }
}
