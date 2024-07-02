class TrieNode {
    boolean word;
    TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
    
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        // 루트 노드부터 시작
        TrieNode cur = root;
        // 단어의 문자를 차례대로 반복하면서 자식 노드 구성
        for(char c : word.toCharArray()) {
            // 해당 문자의 자식 노드가 존재하지 않으면 신규 트라이 노드 생성
            // 'a'가 인덱스 0, 'z'는 인덱스 25가 된다.
            if (cur.children[c - 'a'] == null) {
                // 루트 추가 시 자식 노드가 점점 깊어지면서 문자 단위의 다진 트리 형태
                cur.children[c- 'a'] = new TrieNode();
            }
            // 자식 노드를 현재 노드로 교체
            cur = cur.children[c-'a'];
        }
        // 단어가 원성된 후이므로 현재 노드는 단어 완성 여부에 true설정
        cur.word = true;
    }
    // 단어 존재 여부 판별
    public boolean search(String word) {
        // 루트부터 시작
        TrieNode cur = root;
        // 단어의 문자를 차례대로 반복하며 자식 노드 구성
        for (char c : word.toCharArray()) {
            // 자식 노드가 존재하지 않으면 false 리턴
            if (cur.children[c - 'a'] == null) return false;
            // 자식 노드를 현재노드로 교체
            cur = cur.children[c - 'a'];
        }
        // 탐색이 종료된 후 단어 완성 여부를 리턴
        // 완성된 단어가 아니라면 문자는 모두 매칭이 되어도 단어 완성 여부는 false일 수 있음
        return cur.word == true;
        
    }
    // 문자열로 시작 단어 존재 여부 판별
    public boolean startsWith(String prefix) {
        // 루트부터 시작
        TrieNode cur = root;
        // 단어의 문자를 차례대로 반복하며 자식 노드 구성
        for (char c : prefix.toCharArray()) {
            // 자식 노드가 존재하지 않으면 false 리턴
            if (cur.children[c - 'a'] == null) return false;
            // 자식 노드를 현재 노드로 교체
            cur = cur.children[c - 'a'];
        }
        // 탐색이 종료되면 항상 true 리턴, 시작 여부만 판별하면 되므로 단어 완서 ㅇ여부가 false여도 관계없음
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */