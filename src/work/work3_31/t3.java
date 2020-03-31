package work.work3_31;

public class t3 {
    static String news="";
    public static String split(String s,String regex){
        String newregex=" "+regex+" ";
        news=s.replace(regex,newregex);
        return news;
    }
    public static void main(String[] args){
        String s="a?b?gf#e";
        String regex="?#";
        String[] regex1=new String[10];
        for (int i = 0; i < regex.length(); i++) {
            regex1[i] = regex.substring(i, i + 1);
        }
//        for (int i = 0; i < regex.length(); i++) {
//            System.out.println(regex1[i]);
//        }
        for(int j=0;j<regex.length();j++){
            s=split(s,regex1[j]);
        }
        String[] tokens=s.split(" ");
        for (int i = 0; i < tokens.length; i++){
            System.out.print(tokens[i]+" ");
        }
    }
}

