class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen=new HashSet();
        Set res = new HashSet();
        for(int i=0;i+9<s.length();i++){
            String ten=s.substring(i,i+10);
            if(!seen.add(ten)) res.add(ten);
        }
        return new ArrayList(res);
    }
}