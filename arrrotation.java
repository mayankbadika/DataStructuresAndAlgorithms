public class arrrotation {
    public void rotation(int arr[], int n){
        int temp =0; int a=0;
        for (int i=1;i<=n;i++) { // number of times rotation
            temp = arr[0];
            for (int j = 0; j < arr.length-i; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length-i] = temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args){
        arrrotation obj = new arrrotation();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        obj.rotation(arr,2);

    }
}
