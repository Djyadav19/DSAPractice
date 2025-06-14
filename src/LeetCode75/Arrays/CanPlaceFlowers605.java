package LeetCode75.Arrays;

public class CanPlaceFlowers605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if(size == 1){
            if(flowerbed[0] == 1){
                return n == 0 ? true : false;
            } else{
                return n==1 ? true:false;
            }
        }
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            n--;
        }
        if(flowerbed[size-1] == 0 && flowerbed[size-2] == 0 && n > 0){
            flowerbed[size-1] = 1;
            n--;
        }
        for(int i = 1;i<size-1;i++){
            if( flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                n--;
                flowerbed[i] = 1;
            }
        }
        return n >0 ? false: true;
    }

    public static void main(String[] args){
        CanPlaceFlowers605 solver = new CanPlaceFlowers605();
        int [] flowerbed = new int[]{0,0,1,0,0};
        int n = 1;
        System.out.println(solver.canPlaceFlowers(flowerbed,n));
    }
}
