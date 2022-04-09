import java.io.*;
import java.util.*;

class SubString {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t > 0){
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A,B));
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int repeatedStringMatch(String A, String B)
    {
        int count = 0;
        // Your code goes here
        if (A.length() >= B.length() && A.contains(B)) {
            return 1;
        }
        StringBuffer buffer = new StringBuffer();
        while(buffer.length() < B.length()) {
            buffer.append(A);
            count++;
            if (buffer.indexOf(B) != -1) {
                return count;
            }
        }
        return -1;
    }
}
