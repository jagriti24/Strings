class Anangram {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!= t.length()){
            return false;
        }
        Map<Character, Integer> check = new HashMap<Character, Integer>();
        
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(check.containsKey(a)){
                check.put(a,check.get(a)+1);
            }
            else{
                check.put(a,1);
            }
        }
        
        for(int i=0;i<t.length();i++){
            char a = t.charAt(i);
            if(check.containsKey(a)){
                // System.out.println(a+" if");
                if(check.get(a)==1){
                    check.remove(a);
                }
                else{
                    check.put(a,check.get(a)-1);
                }
            }
            else{
                // System.out.println(a+" else");
               return false;
            }
        }
        
        if(check.size()==0){
            return true;
        }
        
        return false;
    }
}
