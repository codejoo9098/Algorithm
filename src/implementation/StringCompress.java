package implementation;

class StringCompress {
	public static void main(String[] args) {
		System.out.println(solution("aabbacd"));
	}
	
    public static int solution(String s) {
        String str, target, current;
        int answer = s.length(), compressedCount = 1;
        int length = s.length();
        
        for (int i = 1; i < length; i++) {
            str = "";
            current = "";
            target = s.substring(0, i);
            compressedCount = 1; //ÀÌ°É ÀØ¾î¼­...
            
            for (int j = i; j < length; j += i) {
                if (j + i > length) current = s.substring(j, length);
                else current = s.substring(j, j + i);
                
                if (current.equals(target)) {
                    compressedCount++;
                }
                else {
                    if (compressedCount > 1) {
                        str += compressedCount;
                    }
                    
                    str += target;
                    target = current;
                    compressedCount = 1;
                }
            }
            
            if (compressedCount > 1) str += compressedCount + target;
            else str += current;
            
            if (str.length() < answer) {
                answer = str.length();
            }
        }
        
        return answer;
    }
}