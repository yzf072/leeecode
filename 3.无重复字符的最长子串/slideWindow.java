class Solution {
    public int lengthOfLongestSubstring(String s) {
        //哈希集合记录每个字符是否出现
        Set<Character> occ=new HashSet<Character>();
        int n=s.length();
        int i,j=-1;
        int ans=0;
        for(i=0;i<n;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));      //s.charAt(i-1):delete s i-1 
            }
            while(j+1<n&&!occ.contains(s.charAt(j+1))){
                //如果j+1后还在范围内，并且下一个字符不在occ里，才加进来；如果字符在occ里，不加，随着i增加慢慢删除，直到删掉那个重复的字符再加
                occ.add(s.charAt(j+1));
                ++j;
            }
            //while结束后，从i到j是从i开始最长的无重复的子字符串
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}

/*
滑动窗口
依次递增枚举子串的起始位置，子串的结束位置也是递增的
使用两个指针表示子串的左右边界；每次左指针移动一格，把当前字符作为起始字符，然后右指针不断移动，但要保证两个指针之间没有重复的字符
一次结束，就是从当前字符开始最长的子串
使用《哈希表》判断是否有重复字符，左移动就删除，右移动就添加

时间：O(n)，n为字符串长度，左右指针各遍历一遍字符串
空间：O(x)，x为字符集大小，哈希表要存多少种字符
*/