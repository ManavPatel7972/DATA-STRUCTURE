public class RotatedBinarySearch {
    public static void main(String[] args) {

        int[] arr = { 3, 4, 5, 6, 7, 0, 1, 2 };
        int target = 5;
        System.out.println(search(arr, target));
    }

    static int search(int[] arr,int target){
        int pivot = findPivot(arr);

        if(pivot == -1){
           return binary(arr, target, 0, arr.length-1);
        }

        if(arr[pivot] == target){
            return pivot;
        }

        if(target >= arr[0]){
            return binary(arr, target, 0,pivot-1);
        }

        return binary(arr, target, pivot+1, arr.length-1);
    
    }

    static int binary(int[] arr,int target,int start,int end){

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
        
    }

    static int findPivot(int[] arr) {

        int i = 0;
        int j = i + 1;

        while (j < arr.length) {
           
            if (arr[i] > arr[j]) {
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}
