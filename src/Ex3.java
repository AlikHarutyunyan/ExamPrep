public class Ex3 {
    public static void main(String[] args) {

        int[] nums = {3333,1,2,30,40,1,5,4};
        System.out.println(getMedian(nums));
        System.out.println(printHighest(nums));
    }

    public static int printHighest(int[] arr){
        int highest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > highest){
                highest = arr[i];
            }
        }

        return highest;
    }

    public static double getMedian(int[] arr){
        double result;
        sortArr(arr);
        if(arr.length % 2 != 0){
            result = arr[(arr.length-1)/2];
        }else{
            result = (arr[(arr.length/2)] + arr[(arr.length/2-1)])/2.0;
        }

        return result;
    }

    public static void sortArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
