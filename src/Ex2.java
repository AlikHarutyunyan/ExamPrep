public class Ex2 {
    public static void main(String[] args) {

        System.out.println(isSpecialString("aaAAbbBB"));

        String[] strings = {"aabb", "aABb","cccCCCccCC", "aaaaAAAAbbBB", "aaaaAAAAaaAAaaAAaAb"};
        System.out.println(mostSpecialString(strings,'a'));
    }

    public static boolean isSpecialString(String text){
        boolean result = false;
        if(text.length() % 2 == 0){
            for (int i = 0; i < text.length(); i++) {
                int countCurrent = 0;
                int countOther = 0;
                for (int j = 0; j < text.length(); j++) {
                    if(text.charAt(i) == text.charAt(j)){
                        countCurrent++;
                    } else if (text.charAt(i) == changeCase(text.charAt(j))){
                        {
                            countOther++;
                        }
                    }
                }
                if(countCurrent == countOther ){
                    result = true;
                }else{
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static char changeCase(char x){
        char result;
        if((x+"").toUpperCase().equals(x+"")){
            result = (x+"").toLowerCase().charAt(0);
        }else{
            result = (x + "").toUpperCase().charAt(0);
        }

        return result;
    }


    public static String mostSpecialString(String[] strings, char find){
       String mostSpecialString = null;
       int countCurrent = 0;
       int maxCount = 0;
        for (int i = 0; i < strings.length; i++) {
            if(isSpecialString(strings[i])){
                for (int j = 0; j < strings[i].length(); j++) {
                    if(strings[i].charAt(j) == find){
                        countCurrent++;
                    }
                }

                if(countCurrent > maxCount){
                    maxCount = countCurrent;
                    mostSpecialString = strings[i];
                }
                countCurrent = 0;
            }

        }

        return mostSpecialString;
    }
}
