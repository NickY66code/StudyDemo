package Demo.recursion;

public class SelectKMin {

    public static int findKth(int[] arr1, int[] arr2, int k) {
       if (arr1==null||arr1.length<1)
           return arr2[k-1];
       if (arr2==null||arr2.length<1)
           return arr1[k-1];

       return findKth(arr1,0, arr1.length-1,arr2,0,arr2.length-1,k);

    }

    public static int findKth(int[] arr1, int l1, int r1, int[] arr2, int l2,
                              int r2, int k) {
        if (l1>r1){
            return arr2[k+l2];
        }
        if (l2>r2){
            return arr1[k+l1];
        }
        if (k==0){
            return Math.min(arr1[l1],arr2[l2]);
        }

        int md1=l1+k/2<r1 ? l1+k/2 : r1;
        int md2=l2+k/2<(r2-l1) ? l2+k/2 : r2;

        if (arr1[md1]<arr2[md2]){
            return findKth(arr1,md1+1,r1,arr2,l2,r2,k/2-1);
        }else if (arr1[md1]>arr2[md2]){
            return findKth(arr1,l1,r2,arr2,md2+1,r2,k/2-1);
        }else {
            return arr1[md1];
        }


    }
    // 测试
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3,4, 5, 6};
        System.out.println(findKth(arr1, arr2, 2));

    }
}

