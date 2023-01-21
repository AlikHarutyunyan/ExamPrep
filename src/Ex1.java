public class Ex1 {
    public static void main(String[] args) {
        String text = "abababababaa";
        System.out.println(isTriangleText(text));
        System.out.println(isAlmostTriangle(text));
    }

    public static boolean isTriangleText(String text){ //O(1)
        boolean result = false;
        if(text.length() % 3 == 0){
            String part = text.substring(0,text.length()/3);
            result = (text.split(part).length==0);
        }
        return result;
    }

    public static boolean isAlmostTriangle(String text){ //O(n)
        int foul = 0;
        if(text.length() % 3 == 0){
            if(!isTriangleText(text)){
                int diff = text.length()/3;
                for (int i = 0; i < text.length()/3; i++) {
                    if(text.charAt(i) != text.charAt(diff+i)){
                        foul++;
                    }
                    if(text.charAt(i) != text.charAt(diff*2+i)){
                        foul++;
                    }
                }

            }
        }
        return (foul == 1);
    }
}