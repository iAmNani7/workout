public class PrintMinLenghtWordFromArray
{
    public static void main(String[] args) {
        String[] words={"q","acid","muffin","text","hi","1","reyy"};
        int index=0;
        int min=words[0].length();
        for (int i=1;i<words.length;i++)
        {
            if(min>words[i].length())
            {
                min=words[i].length();
                index=i;
            }
        }
        System.out.println(min +" "+ words[index]);
    }
}
