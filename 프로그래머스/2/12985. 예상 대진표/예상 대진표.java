class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 1;
        
         while((a + 1) / 2 != (b + 1) / 2){
             if(a % 2 == 0){
                 a /= 2;
             } else {
                 a = (a + 1) / 2;
             }
             
             if(b % 2 == 0){
                 b /= 2;
             } else {
                 b = (b + 1) / 2;
             }
             
             count++;
         }
        
        return count;
    }
}