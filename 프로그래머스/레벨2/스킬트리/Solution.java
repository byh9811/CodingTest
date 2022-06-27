package 프로그래머스.레벨2.스킬트리;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        for(String skill_tree: skill_trees) {
            int next = 0;

            for(char c: skill_tree.toCharArray()) {
                if(next!=skill.length() && c==skill.charAt(next))
                    next++;
                else if(!canStudy(next, c, skill)){
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    private boolean canStudy(int next, char c, String skill) {
        for(int i=next+1; i<skill.length(); i++) {
            if(skill.charAt(i)==c)
                return false;
        }

        return true;
    }
}