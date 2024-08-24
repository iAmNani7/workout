public class MergeTwoStringArrays {

        public static void main(String[] args) {
            String a[]={"a","b","c"};
            String b[]={"d","f"};
            int s=a.length+b.length;
            String c[]=new String[s];
            int p=0;
            for(int i=0;i<a.length+b.length;i++){
                if(i<a.length)
                {
                    c[i]=a[i];
                }
                else{
                    c[i]=b[p];
                    p++;
                }
            }
            for(String s1:c)
            {
                System.out.print(s1+" ");
            }
        }
}
