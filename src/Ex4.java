public class Ex4 {
    public static void main(String[] args) {
        int[] nums = {3,4,1,2};
        int[] target = {4,1,2,3};
        moveRight(nums);
        moveLeft(nums);
        System.out.println(fastestCircularTransformation(nums,target));
    }

    public static int[] moveRight(int[] nums){
        int[] result = new int[nums.length];
        result[0] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i-1];
        }
        return result;
    }

    public static int[] moveLeft(int[] nums){
        int[] result = new int[nums.length];
        result[nums.length -1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i-1] = nums[i];
        }

        return result;
    }


    public static int fastestCircularTransformation(int[] original, int[] target){
        boolean isPossible = true;
        int result;
        int countLeft = 0;
        int countRight = 0;
        if(original.length != target.length){
            isPossible = false;
        }else {
            countLeft = countShift(original, target, false);
            if (countLeft == -1) {
                countLeft = 0;
                isPossible = false;
            } else {
                countRight = countShift(original, target, true);
            }
        }

            if(!isPossible){
                result = 0;
            }else{
                if(countLeft < countRight){
                    result = 1;
                }else if(countLeft > countRight){
                    result = 2;
                }else{
                    result = 3;
                }
            }
        return result;
    }



    public static int countShift(int[] original, int[] target, boolean isRight){
        int count = 0;
        int result = 0;
        for (int i = 0; i < original.length; i++) {
            count++;
            if(isRight) {
                original = moveRight(original);
            }else{
                original = moveLeft(original);
            }
            if(isEqual(original,target)){
                break;
            }
            if(i + 1 == original.length){
                result = -1;
            }
        }
        if(result != -1){
            result = count;
        }

        return result;
    }

    public static boolean isEqual(int[] x, int[] y){
        boolean result = true;
        if(x.length == y.length) {
            for (int i = 0; i < x.length; i++) {
                if (x[i] != y[i]) {
                    result = false;
                    break;
                }
            }
        }
        else{
            result = false;
        }

        return result;
    }
}
