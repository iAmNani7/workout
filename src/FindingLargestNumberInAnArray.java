public class FindingLargestNumberInAnArray {
    public static void main(String[] args) {
        int[] array ={13,2,3,4,5,2554,12,2,3,4,225555};
        int max=array[0];
        int index=0;
        for(int i=1;i<array.length;i++)
        {
            if (max<array[i])
            {
                max=array[i];
                index=i;
            }
        }
        System.out.println(max + " " + "index:" + index );
    }
}
