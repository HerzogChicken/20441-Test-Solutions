//import javax.lang.model.util.ElementScanner14;

public class TestAnswers {

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 60 sheelon 477 2021b   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //                                                     4/1/22 finished this test , 100/100 
    // Limitations : cannot use backtracking (can't use another array), must solve it with recursive functions, can use overloading 
    //                               cannot change the given array in any way

    //                                                                          QUESTION 1  
    // /*
    public static boolean split3(int[] arr) {
        int index = 0;
        int total = sumArr(arr, index);
        int attempts = 0;
        if(total%3 == 1)
            return false;

        return split3(arr, 0, total, index, attempts);
    }//end of split3

    private static int sumArr(int[] arr, int index) {
        if(index >= arr.length)
            return 0;

        return arr[index] + sumArr(arr, index + 1);
    }// end of sumArr

    private static boolean split3(int[] arr, int sum, int total, int index, int attempts) {

        if(sum == total/3) {
            attempts += 1;
            if(attempts == 2)
                return true;
        }
            
        if(sum > total/3 || index >= arr.length)
            return false;

        return split3(arr, sum, total, index + 1, attempts) || split3(arr, sum + arr[index], total, index + 1, attempts);
    }//end of overloaded split3
    
    // */

    //                                                                          QUESTION 2

    // static method , receives an array filled with non negative integers and a positive integer K as a parameter 
    // the method needs to the find the shortest sub-array such that the sum of the sub-array is greater than K 
    // and then return the length of that sub-array if no sub-array is found , return array.length + 1
    // Limitations : need to write the most efficient method you can, no other limitations

    // P.S need to mention what the time and space complexities are 

    // leetcode 209. very similar but can only have positive integers unlike this question , 0 can be a target and in the array
    // basically a moving window problem 

    //                                                         this solution only works for NON NEGATIVE integers in the array 
    //                                                         the parameter k has to be positive k>=1 else , the method doesn't work
    public static int smallestSub(int[] a, int k) {
        
        if(a == null || a.length == 0)
            return (a.length + 1);

        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(j < a.length) {
            sum += a[j++];

            while(sum >= k) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ?  a.length + 1 : min ;
    }
    

    /*
    " The key to the problem is to understand why we do not have to consider x1 as the left point of some (left, right) 
    interval that sums up to a value greater than K, if x1 < x2 and P[x1] >= P[x2].

    Suppose (x2, right) interval sums up to a value greater than K. 
    We need not consider (x1, right) interval because that is a bigger interval. We already have (x2, right) as a potential candidate which is a smaller interval.

    How about if we suppose (x2, right) sums up to a value less than K? 
    Well, we don't need to consider (x1, right) either because (x1, right) will sum up to a value even less than the value that (x2, right) sums up to. 
    The reason is that P[x1] >= P[x2] => p[y] - p[x1] <= P[y] - P[x2].

    Based on this fact, we can proceed to consider only the indices which conforms to an increasing sequence of prefix sum. "
    */


    // going through the array at most twice , once for i and once for j so time complexity is O(n)
    // we only have declared variables so space complexity is O(1)

    //                                                                          QUESTION 3
    /*
        a.
            return false
        b.
            change the value of the node with value 8 with the father , node with value 7 to 9 and the leftson of node 8 that has value 10 , change the value 
            to [8,9] or remove the node 
        c.
            yes , for example                                      4 <- 5 <- 6 <- 7 -> 8 -> 9
        d.
            the method checks if the differece in absolute value between a node and its son is less than or equal to 1
            if so , the method returns true , otherwise false

            edge cases

            if the the tree is null (no nodes) return true
            if the node has no sons return true
            if the node only has one son , check the difference with that son and move in that direction 



    */

    //                                                                          QUESTION 4
    /*
        1.
            A._x = 9
            B._x = 9
        2.
            A._x = 4
            B._x = 4
        3.
            compilation error , a son cannot call the father , only the opposite can happen
        4.
            A._x = 5
            B._x = 5
            C._x = 25
        5.
            A._x = 9
            B._x = 9
            C._x = 9
            D._x = 10
        6.
            A._x = 2
            B._x = 2
            C._x = 4
            D._x = 4
        7.
            A._x = 9
            B._x = 9
            C._x = 9
            D._x = 19
        8.
            compilation error - there's no inheritance between class E and class D and both inherit from C therefore object D cannot instantiate object E
    */

    //                                                                          QUESTION 5
    // what method , first half, which is the first while loop checks the first value in the linked list and the counts the times it appears in the linked list
    // if a value appears in congruence for at least half of the linked list length then the variable m will be set as that value , 
    // otherwise m is the last value of the linked list if the length of the linked list is ODD and if it's EVEN return the value before the last value
    // and also variable res counts the length of the linked list
    // the second while loop counts the amount of times the value m appears in the linked list , m will either be a value that appears in congruence 
    // for at least half of the linked list or it will be the last value of the linked list
    // if the times the value m appears in the linked list is more than half of the length of the linked list return that value m , otherwise return -9999

    /*
        a.
            will return -9999
        b.
            will return 1
        c.
            will return 2
        d.
            will return -9999
        e.
            the method what returns the value that appears in congruence in the linked list for more than the linked list's length 
            or the value of the last or before last (depends the length of the linked list is ODD or EVEN) if it appears in the linked list 
            for more than half of the linked list's length, otherwise if there's no such value return -9999

            edge cases :
                if the linked list is emprty aka null, return -9999
                if there's only one node , return the value of that node as long as the value is not 0 , if it is then return -9999

    */

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 60 sheelon 477 2021b   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 84 sheelon 478 2019a   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a positive interger as a parameter , find if the number can be written as the sum of exponents of 3 
    // return true if it is , otherwise false
    // Limitations : every exponent of 3 can only be once in the sum and the method has to be recursive

    // *****MATHEMATICAL WAY*****

    // solve this by converting the parameter num that is in decimal AKA base 10 to base 3 AKA ternary which is built from 0,1,2 only 
    // we don't need to save the values only check if the converted number is made of 1/0 only and if there's at least one appearance of 2 in the 
    // converted number , we return false since that means the number is made up of 2 * 3 ^(some exponent)
    public static boolean sumPower3(int num) {

        if(num == 0)
            return true;

        int remainder = num%3;
        if(remainder == 2)
            return false;
        num = (num - remainder)/3;

        return sumPower3(num);
        
    }

    // *****BACKTRACKING WAY*****

    // use overloading
    // either decrease the num by a power of 3 or skip and multiply the power of 3 by 3 
    public static boolean sumPower3OverLoading(int num) {
        return sumPower3OverLoading(num, 1);
    }

    private static boolean sumPower3OverLoading(int num, int power) {

        if(num == 0)
            return true;
        if(power > num)
            return false;

        return sumPower3OverLoading(num, power * 3) || sumPower3OverLoading(num - power, power * 3);
    }


    //                                                                          QUESTION 2

    // find the index that splits the given array into two arrays such that the absolute difference of their averages is the highest (maximum)

    // naive way is to approach it like a window , move along the array and then compare the difference in averages so it will be 
    // time complexity O(n) , moving along the array  once to the sum the rightSum and then move along the array again to check the difference so O(2n) ~ O(n)
    // space complexity is O(1) , only intantiating variables
    

    // this is the correct answer , O(n) for time complexity and O(1) for space complexity 
    public static int averageNaiveApproach(int[] arr) {

        if(arr.length == 1)
            return arr[0];
        if(arr.length == 0)
            return 0;

        int start = 0;
        int end =arr.length - 1;
        int divider = 0; // the "divider" that moves along the array 

        double maxDif = 0; // don't need to set as Integer.MIN_VALUE since we use the absolute difference so 0 will do as a dummy 
        double leftSum = arr[0];
        double rightSum = 0;

        for(int i = 1; i <= end ; ++i) {
            rightSum += arr[i];
        }

        for(int i = 0 ; i < arr.length -1  ; ++i) {
            //get the temporary absolute difference 
            double tempDif = leftSum/(start + 1) - rightSum/end;
            tempDif = (tempDif < 0) ? -tempDif : tempDif ;

            if(tempDif > maxDif) {
                maxDif = tempDif;
                divider = i;
            }
                
            // here we move the divider to the right by 1 spot so we increase and decrease values as we make the left window bigger and the right one smaller
            leftSum += arr[i+1]; 
            start++; // for the average
            rightSum-= arr[i+1]; 
            end--; // for the average
            
        }
        return divider;
    }

    //                                                                          QUESTION 3

    // method f : iterate through the tree until we reach the most left son of the tree , when we do so we return the root of that son
    // method g : iterate through the tree until we reach the most right son of the tree, when we do so we return the root of that son

    /*
        (i)
            the method f will return the NODE with value 5 , the furthest node to the left .
        
            the method g will return the NODE with value 70 , the furtherst node to the right .
        (ii)
            given a root , the method g iterates through the BST and returns the furthest node to the right 
        (iii)
            the method returns true and prints 10,30
        (iv)
            the method will return false and nothing will print 
        (v)
            the method looks for a possible combition of two different nodes with different values such that their sum equals to the given parameter num 
            the method checks each possible combination and moves along the tree using two pointers and two placeholders for the nodes value 
            the method will run until it finds a possible solution and then print it and return or it will keep running until it tries every combination 
            and then will return false if it didn't find any possible solution 

    */

    
    //                                                                          QUESTION 4

    /*
        1.
            first line : create a new object
            second line : prints abc

        2.
            first line : create a new object
            second line : print def
            third line : print ghi
        3. 
            first line : create a new object
            second line : print abc
            third line : compilation error , no get2 method in class A
            fourth line : print jkh
            fith line : print abc
        4.
            run time error - B is not the same or parent of runtime type A 
        5.
            compilation error - poiting a son to a parent object 
        6.

    */
    
    //                                                                          QUESTION 5

    /*
        method what is reversing the linked list
        method secret returns the middle node (list length / 2) zero based
        method something check if the linked list is a palindrome and returns true otherwise false
        
        a.
            reverse the linked list
                {7,2,6,3}
        b.
            the method reverses a linked list , if the linked list is null return null
        c.
            the method will return the node with value 2
        d.
            the method something will return false
        e.
            change the node with value of 2 to 4 or the node with value of 4 to 2 
        f.
            the method something checks if the linked list is a palindrome 
            if it is return true , otherwise false

    */

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 84 sheelon 478 2019a   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon 483 2018a   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    //                                                                          QUESTION 1

    // given a value num , we need to find a path in the two dimensional array such that the difference between each neighboring cell (excluding diagonal cells) 
    // is the number num , return the longest path in the array 
    // what if there's no path ? (return 1), the array is of size nxm !
    // can we have negative numbers in the array ? , they only mention integers 
    // Limitaions : must solve it recursively , can change the array but must return it to its original state at the end , can use overloading 
    // can use overloading , no mention about using arrays

    public static int longestSlope(int[][] mat, int num) {
        // use the help of a boolean array to make sure we don't go into loops and we only check unique paths
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        
        return checkEveryCell(mat, num, 0, 0, visited);
    }
    // this method iterates through the array 
    private static int checkEveryCell(int[][] mat, int num, int i, int j, boolean[][] visited) {
        // measures to make sure the indices are not out of bounds 
        if(i >= mat.length && j >= mat[0].length )
            return 0;
        // in case we reached the end of the row , increment the i'th row start from the beginning of the column and repeat the proccess as long as it's valid
        if(j >= mat[0].length ){
            if(i != mat.length - 1) {
                j = 0; 
                i += 1;
            } else 
                return 0;
            
        }

        return Math.max(checkEveryCell(mat, num, i, j + 1, visited), longestSlope(mat, num, i, j, visited));            
    }

    private static int longestSlope(int[][] mat, int num, int i, int j, boolean[][] visited) {

        int maxPath = 0;
        int tempPath = 0;
        // check right
        if(isValid(mat, i, j + 1) && !visited[i][j + 1]&& (mat[i][j] - mat[i][j + 1] == num ) ) {
            visited[i][j] = true;
            
            tempPath = longestSlope(mat, num, i, j + 1, visited);
            if(maxPath < tempPath)
                maxPath = tempPath;
        }
        // check left
        if(isValid(mat, i, j - 1) && !visited[i][j - 1]&& (mat[i][j] - mat[i][j - 1] == num ) ) {
            visited[i][j] = true;
            
            tempPath = longestSlope(mat, num, i, j - 1, visited);
            if(maxPath < tempPath)
                maxPath = tempPath;
        }
        // check above
        if(isValid(mat, i + 1, j ) && !visited[i + 1][j]&& (mat[i][j] - mat[i + 1][j] == num ) ) {
            visited[i][j] = true;
            
            tempPath = longestSlope(mat, num, i + 1, j, visited);
            if(maxPath < tempPath)
                maxPath = tempPath;
        }
        // check under 
        if(isValid(mat, i - 1, j ) && !visited[i - 1][j]&& (mat[i][j] - mat[i - 1][j] == num ) ) {
            visited[i][j] = true;
            
            tempPath = longestSlope(mat, num, i - 1, j, visited);
            if(maxPath < tempPath)
                maxPath = tempPath;
        }

        visited[i][j] = false;
        return 1 + maxPath;
    }

    private static boolean isValid(int[][] mat, int i, int j) {
        if(i < mat.length && j < mat[0].length && i >= 0  && j >= 0 )
            return true;
        else
            return false;
    }


    //                                                                          QUESTION 2

    // method f is a prefix sum
    // method what iterates through the array , calling f to find a prefix sum , check if the sum is ODD , if it is then check if the difference 
    // j - (i - 1) = j - i + 1 > temp , at the start temp = 0 
    // and repeat the same proccess until we reach the end of the array , that is , i == array.length and then return temp 
    // so we're basically finding the longest ODD prefix sum over the array and returning the length
    // moving like a slug 
    
    /*
        a.
            the method what moves iterates through the given array(if integers) and checks if the prefix sum of every sub-array of the given array is ODD
            if it is , check the length of it , return the longest ODD prefix sum at the end
            if there are only negative integers return 0

        b.
            time complexity is O(n^3) ~ O(n) for the first for loop * O(n) for the inner for loop * O(n) for the inner for loop calling method f which iterates 
            through the array based on given indices
        c.
            // ODD + ODD = EVEN , EVEN + EVEN = EVEN , EVEN + ODD = ODD, don't need to iterate through the array and sum the values
            move once through the array and check each number if it's odd or even 
            but we have a problem if the integers are negative 
            the problem is the negative integers that can be had in the array , otherwise this question is simple and a fast method can be written
        d.
            the time complexity of the new what method is O(n^2) , O(n) for the first outer for loop * O(n) for the inner for loop 
            space complexity is O(1) , only instantiated variables
    */

    public static int what(int[] a) {

        int tempSum = 0;
        int maxLength = 0;
        int arrayLength = a.length;
        // this works and is O(n^2)  \/\/\/\/\/\/\/ can we get closer to O(n) ?

        // check if STACK or DEQUE can help using two stacks for example ? 

        for(int i = 0 ; i < arrayLength ; ++i) {
            tempSum = 0;
            for(int j = i ; j < arrayLength ; ++j) {

                tempSum += a[j];

                if(tempSum%2 == 1 && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                }

            }// end of inner for loop
   
        }// end of outer for loop

        return maxLength;
    } 


    //                                                                          QUESTION 3

    /*
        overloaded method what sums up the length of every unique path to a leaf (counting the edges instead of nodes) 
        i.
            the method what will return 1
        ii.
            the method what returns the sum of all unique paths to a leaf (counting the edges) , if the tree is null return 0
    */

    //                                                                          QUESTION 4



    // need to continue 5/4/22
    // need to continue 16/4/22


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon 483 2018a   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 86 sheelon 455 2017a 5a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //              7/4/22 finished this test    
    //                                                                          QUESTION 1

    // given two strings, and two operations , adding a letter and remove a letter 
    // find the minimum number of operations needed in order to convert str1 into str2 , that is , change a string into a different given string with the 
    // least amount of operations, at the end return the amount of operations done
    // Limitations : the method needs to be recursive 


    public static int edit(String str1, String str2) {

        if(str1.length() == 0 && str2.length() == 0 )
            return 0;
        else if(str1.length() == 0 || str2.length() == 0)
            return (str1.length() == 0) ? str2.length() : str1.length() ; // doesn't matter which one is of length 0 , we return the length as that's
                                                                          // the amount of operations needed to be done until the strings are equal
        if(str1.charAt(0) == str2.charAt(0))
            return edit(str1.substring(1), str2.substring(1)) ; 
        else
            return Math.min( 1 + edit(str1 , str2.substring(1)) , 2 + edit(str1.substring(1), str2.substring(1)));
            // check both ways, either add the different letter and keep the current letter or delete the current letter and add the different letter

    }

    // uppon revisiting this solution , it seems like I didn't count for both case , equal , add and replace but we don't have the deletion 
    // also , from java 7 and on substring has a time complexity of O(n) instead of O(1) for java 6 for example 
    public static int edit2(String str1, String str2) {
        return edit2(str1, str2, str1.length(), str2.length());
    }

    private static int edit2(String str1, String str2, int str1Length, int str2Length) {

        if(str1Length == 0 || str2Length == 0)
            return (str1Length == 0) ? str2Length : str1Length;

        if(str1.charAt(str1Length - 1) == str2.charAt(str2Length - 1)) // both letters are equal so move on
            return edit2(str1, str2, str1Length - 1, str2Length - 1);
        else    // check two cases, either add the letter or remove the letter      
            return 1 + Math.min( edit2(str1, str2, str1Length - 1 , str2Length) , edit2(str1, str2, str1Length, str2Length - 1) );
        

    }

    // another option is to use memoization and reduce the time complexity from exponential to polynomial at the cost of increasing the space compelexity to linear\poly



    //                                                                          QUESTION 2

    // given a SORTED one dimensional array filled with integers and a target value num
    // we need to return the number of subsequences that their sum of three different cells is less than the value num
    // arr[i] + arr[j] + arr[k] < num  , 0 <= i < j < k < arr.length
    // Limitations : time complexity needs to be O(n^2) , space complexity should be O(1) if done right 


    // time complexity is O(n^2) , O(n) since we move along the given array with a for loop * O(n) for the while loop that will go 
    // through at most n-1 indices of the array every time
    // 
    // space complexity is O(1) , only instantiating varibales

    public static int countTriplets(int[] arr, int num) {
        // 5/4/22 
        // the array is sorted in ascending order !
        int arrLength = arr.length;
        int counter = 0;
        for(int i = 0; i < arrLength - 2 ; ++i) {

            int leftIndex = i + 1;
            int rightIndex = arrLength - 1;

            while(leftIndex < rightIndex) {
                // if the interval meets the requirement , add all triplet solutions in that interval and increase the left pointer and repeat the proccess
                if(arr[i] + arr[leftIndex] + arr[rightIndex] < num) {
                    counter += rightIndex - leftIndex;
                    leftIndex++;
                }else   
                    rightIndex--; // in case the sum is not less than num , we decrease the right pointer therefore the value in that index will be lower 
            }
        }
        return counter;
    }
    // we can see this problem as a static point and a dynammic hollow window or two pointers 
    // one point is set every time and then we search for the largest interval that meets the requirement
    // all values\indices in that range will also be a valid solution since the array is sorted, otherwise this way of solving the problem is wrong
         
    //                                                                          QUESTION 3
    
    // what method moves along the binary tree recursively until it reaches the leaves , returns the maximum sum of every branch and then adds the value 
    // of the calling node and repeats the proccess until we reach the root
    

    /*
        (i)
            the method will return 260 , 230 for the maximum sum of the the right\left branch (in this case the left branch) + 30 for the root
        (ii)
            the method what compares the sum of the left and right branches (bottom up) recursively and returns the maximum value and adds the  
            value of the node connecting both branches to the maximum sum and the proccess repeats itself until we reach the root 

            edge cases : 
            when there's only one branch either left or right , we simply return the sum of all nodes in the tree 
            if the binary tree is a leaf , return the value of the root(leaf)
            if the binary tree is null , return 0
     */


    //                                                                          QUESTION 4


    /*
        a.
            create a new object 
            print 
                    In A's f
                    In A's g
        b.
            create a new object of B , x = 3 , y = 5
            print
                    X: 3 Y: 5
                    In B's h
        c.
            create a new object of B x = 3 , y = 2
            let an object of B point to the object a3
            print
                    X: 3 Y: 2
                    In B's f
                    In A's g
                    In B's h
        d.
            create a new object of B x = 4 , y = 6
            (since in compile time the object is of A, we use the method f in the A class)
            print
                    Even
                    In A's f
                    In A's g
                    X: 4
        e.
            runtime error , if we downcast , during runtime it needs to be a parent or the same as the object being downcasted
            
        f.
            compilation error , cannot cast an object of B into an object of A 

    */

    //                                                                          QUESTION 5

    // method method1 iterates through the linked list and sums up sub-linked-lists at the end m1 is the maximum positive sum in the linked list
    // if there's no positive sum , return 0

    /*
        a.
            return the value 12
        b.
            return the value 8 
        c.
            the method iterates through the linked list and searches for the sub linked list that has the maximum sum of all other sub linked lists
            and returns it

            edge cases:
                if every node has a non negative value , return the sum of all the nodes
                if every node has negative values or the linked list is null , return 0;


    */

    //                                                                          QUESTION 6

    // trying to find value x using binary search on a one dimensional array , and the array is sorted such that for every i < j (in range)  arr[i] <= arr[j]

    //                                                  *not sure about this question , the answers are a bit different*
    /*
        a.
            1.
                print
                    x is not in the array
                    x is not in the array
                    x is not in the array
                    x is in the array
            2.
                print
                    x is not in the array
                    x is not in the array
                    x is not in the array
            3.
                go into infinite loop of printing 
                    x is not in the array
            4.
                print
                    x is not in the array
                    x is not in the array
                    x is in the array
            5.
                go into infinite loop of printing 
                    x is not in the array
                
        b.
            option 2
    */

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 86 sheelon 455 2017a 5a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 90 sheelon 455 2017a 1b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // classic 0/1 knapsack 

    // given a weight limit w , and object item that has the properties value and weight , we need to find the best combination possible 
    // such that we get the highest sum of values possible whilst staying withing our weight limit which is w
    // Limitations : need to solve this recursively

    // time complexity is O(2^n)
    public class Item {
        // we're assuming all values given are valid and don't need check that
        private int _weight;
        private int _value;

        public Item(int w, int v) {
            _weight = w;
            _value = v;
        }

        public int getWeight() { return _weight; }
        public int getValue() { return _value; }
    }

    public static int knapSack(Item[] items, int w) {
        int maxIndex = items.length;
        return knapSack(items, w, 0, 0, maxIndex);

    }

    private static int knapSack(Item[] items, int w, int weight, int index, int maxIndex) {
        // in case the we're over the limit , decrease the value sum by the value of the last item added 
        if(weight > w)
            return -items[index - 1].getValue();
        // in case we're out of the array's bounds
        if(index == maxIndex)
            return 0;
        // we basically start at every index on the array and check the different valid possibillities at each index and return the max valid value sum 
        return Math.max(knapSack(items, w, weight, index + 1, maxIndex) ,items[index].getValue() + knapSack(items, w, weight + items[index].getWeight(), index + 1, maxIndex));
        
    }


    // top down approach 9/4/22
    // assuming all values are non negative , we start from the maxiumum weight and work our way down to havin 0 weight or until we run out of items
    // all along we compare the summed value and return the maximum value possible within the constraint to the calling recursive call
    // using a 2D array / matrix we can decrease the complexity of the code (memoization)
    // time complexity is O(n*w) and space complexity is O(n*w)
    private static int max(int a , int b) {
        return (a > b) ? a : b;
    }

    private static int knapSackTopDown(Item[] items, int w, int n, int[][] dp, boolean[][] visited) {

        // went over all the items / reached the weight limit
        if(w == 0 || n == 0)
            return 0;
        // if we already visited that value
        if(visited[n][w])
            return dp[n][w];
        // if the current available item is over the weight limit , move on to the next item, else check if its worth picking the item or not
        if(items[n - 1].getWeight() > w) {
            visited[n][w] = true;
            return dp[n][w] = knapSackTopDown(items, w, n - 1, dp, visited);
        }else {
            visited[n][w] = true;
            return dp[n][w] = max(items[n-1].getValue() + knapSackTopDown(items, w - items[n-1].getWeight(), n - 1, dp, visited),
                                            knapSackTopDown(items, w, n - 1, dp, visited));
        }


    }

    private static int knapSackV2(Item[] items, int w) {
        int arrLength = items.length;
        int[][] dp = new int[arrLength + 1][w + 1];
        boolean[][] visited = new boolean[arrLength + 1][w + 1];

        return knapSackTopDown(items, w, arrLength, dp, visited);
    }

    // revisiting this question 26/5/22 , we can also get away with init our dp array to -1 instead of using another boolean array
    // top down recusive approach with memoization , space comp O(n*W) , time comp O(n*W)
    // start from the top , that is , last item and max weight and then go down 
    private static void initDpArr(int[][] dp, int i , int j, int maxRow, int maxCol) {

        if(i < maxRow && j < maxCol) {
            dp[i][j] = -1;
            initDpArr(dp, i, j + 1, maxRow, maxCol);
        }else {

            if(i < maxRow)
                initDpArr(dp, i + 1, 0, maxRow, maxCol);
            else
                return;
        }

    }

    private static int knapSackTpDwn(Item[] items, int W) {

        int n = items.length;
        int[][] dp = new int[n+1][W+1];
        initDpArr(dp, 0, 0, n+1, W+1);
        return knapSackTpDwn(items, W, n, dp);
    }

    private static int knapSackTpDwn(Item[] items , int W, int n, int[][] dp) {

        if(W == 0 || n == 0)
            return 0;
        
        if(dp[n][W] != -1)
            return dp[n][W];
        
        if(items[n-1].getWeight() <= W)
            return max( items[n-1].getValue() + knapSackTpDwn(items, W - items[n-1].getWeight() , n - 1, dp) , knapSackTpDwn(items, W, n - 1, dp)) ;
        else
            return knapSackTpDwn(items, W, n - 1, dp);
    }

    //                                                   in case we have two arrays , one for items value and one for items weight 
    /*
    
    private static int max(int a , int b) {
        return (a > b) ? a : b;
    }
    
    private static int knapSackTopDown(int val[], int wt[], int w, int n, int[][] dp, boolean[][] visited) {

        // went over all the items / reached the weight limit
        if(w == 0 || n == 0)
            return 0;
        // if we already visited that value
        if(visited[n][w])
            return dp[n][w];
        // if the current available item is over the weight limit , move on to the next item, else check if its worth picking the item or not
        if(wt[n - 1] > w) {
            visited[n][w] = true;
            return dp[n][w] = knapSackTopDown(val, wt, w, n - 1, dp, visited);
        }else {
            visited[n][w] = true;
            return dp[n][w] = max(val[n-1] + knapSackTopDown(val, wt, w - wt[n-1], n - 1, dp, visited),
                                            knapSackTopDown(val, wt, w, n - 1, dp, visited));
        }

    public static int knapSack(int w, int wt[], int val[], int n) {   
        
        int[][] dp = new int[n + 1][w + 1];
        boolean[][] visited = new boolean[n + 1][w + 1];

        return knapSackTopDown(val, wt, w, n, dp, visited);
    }

    */

    // bottom up approach 9/4/22
    // as the name suggests (0/1) we have two operations , either pick an item or not
    // we're using a 2D array to help us get to the best value possible
    // each item has its own row and we can either choose that item and if possible add the item above it or we can choose not to pick the item
    // in that row and stay with the item in the row above , and we repeat the proccess until we reach the last cell available in the 2D matrix
    // which will be the best value possible within the weight limit
    // time complexity is O(n*w) w - maximum weight , n - number of items available 
    // space complexity is also O(n*w) since we create the 2D array / matrix 
    public static int knapSackDpV1(Item[] items, int w) {

        int arrLength = items.length;
        int[][] dp = new int[arrLength + 1][w + 1];

        for(int i = 1 ; i <= arrLength ; ++i) {

            int weight = items[i-1].getWeight();
            int value = items[i-1].getValue();

            for(int currentSize = 0; currentSize <= w ; ++currentSize) {
                // set the current item to the one in the same column but row above
                dp[i][currentSize] = dp[i-1][currentSize];
                // check if the item in the row + item from last row that fits the weight constraint has a higher value than just the item above 
                if(currentSize >= weight && dp[i-1][currentSize - weight] + value > dp[i-1][currentSize]) {
                    dp[i][currentSize] = dp[i-1][currentSize - weight] + value;
                }
            }

        }
        return dp[arrLength][w];
    }



    //                                                                          QUESTION 2

    // given a one dimensional array of positive integers sorted such that ∀(i < j) , array[i] <= array[j] 
    // the method needs to return the smallest positive integer that cannot be a sum of any combination of the arrays cells 
    // Limitations : the method needs to be the most efficient possible 
    // time xomplexity is O(n) , worst case scenario we iterate through the whole array
    // space complexity is O(1) , only instantiating variables

    public static int findSmallest(int[] arr) {

        int prefixSum = 0;
        int arrayLength = arr.length;
        // simple check to see if we have an immediate answer 
        if(1 < arr[0])
            return 1;
        // move through the array and use prefix sum , since we only have positive integers in the given array we only need to check
        // if the prefix sum + 1 is less than the next element in the array if so the smallest number meeting the requirement is prefixSum+1
        // otherwise repeat the proccess until we reach the end of the array
        // since we only have positive integers and the array is sorted, we infer that if there can't be a number prefixSum + 1
        // between two congruent elements in the array that means the values are sequential so the can sum up to their prefix sum (inclusive)
        // so we need to move the index by 1 and check again if two congruent elements values are sequential
        // for array P assume every element i is a prfix sum of the elements in arr , P = {A[0], ..... , A[i] , ... , A[n]}
        // we need to find the prefix sum A[i] such that A[i] + 1 < arr[i+1] for the reason detailed above, if there's no such sum we return A[n] + 1
        for(int i = 0 ; i < arrayLength ; ++i) {
            if(i == arrayLength - 1) 
                return prefixSum + arr[i] + 1;

                prefixSum += arr[i];
            if(prefixSum + 1 < arr[i+1])
                return prefixSum + 1;
        }
        return 0;
    }

    //                                                      cleaner and shorter code 
    /*
    public static int findSmallest(int[] arr) {
        int prefixSum = 1;
        for(int i = 0; i < arr.length ; ++i) {
            if(prefixSum < arr[i])
                return prefixSum;
            else
                prefixSum += arr[0];
        }
        return prefixSum;
    }
    */


    //                                                                          QUESTION 3

    // still need to finish some of the questions in past tests ! 7/4/22
    // still need to finish some of the questions in past tests ! 9/4/22
    // still need to finish some of the questions in past tests ! 16/4/22

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 90 sheelon 455 2017a 1b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 83 sheelon 481 2016a 2a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a 2 dimensional array \ matrix (size nxm) of integers and a number as a parameter , start from index [0][0] and get to the index
    // [n-1][m-1] , find minimal number that is needed in order to complete the path 
    // Limitations : need to solve it recursively, can only move down/right , each element in the matrix has a value 
    // we must add the value in each element visited to the given parameter number and we have to stay positive in every element visited


    // top down recursive approach 
    // time complexity O(2^n) go down or go right every time
    // space complexity O(1) (excluding stack memory , otherwise O(2^n))
    public static int minPoints(int[][] m) {
        return minPoints(m, 0, 0);
    }

    private static int minPoints(int[][] arr, int i , int j) {
        int rowLength = arr.length;
        int colLength = arr[0].length;

        if(i == rowLength || j == colLength)
            return Integer.MAX_VALUE;

        if(i == rowLength - 1 && j == colLength - 1)
            return (arr[i][j] <= 0) ? -arr[i][j] + 1 : arr[i][j];

        int moveRight = minPoints(arr, i, j + 1);
        int moveDown = minPoints(arr, i + 1, j );

        int minPointsToMove = Math.min(moveRight,moveDown) -arr[i][j];

        return (minPointsToMove <= 0) ? 1 : minPointsToMove;
    }

    // 16/6/22 revisiting this question - seems like the answer is wrong , works for the given example but not for every other test case

    public static int minPointsRE(int[][] arr) {

        int addedPoints = 1; // we need to start with 1 point anyhow
        return minPointsRE(arr, 0, 0, 0, addedPoints);

    }

    private static int minPointsRE(int[][] arr, int i, int j, int currentPoints, int addedPoints) {
        // out of bounds check - we don't get overflow 
        if(i >= arr.length || j >= arr[0].length)
            return Integer.MAX_VALUE;
        // in case we go negative after adding the current cell's value 
        if(currentPoints + arr[i][j] <= 0) {
            addedPoints-=(currentPoints + arr[i][j]);
            currentPoints = 0;
        }else // if we don't go negative after adding , simply update the currentPoints
            currentPoints += arr[i][j];

        if(i == arr.length - 1 && j == arr[0].length - 1)
            return addedPoints;
        // check both options, going down or right 
        return Math.min( minPointsRE(arr, i + 1, j, currentPoints, addedPoints) , minPointsRE(arr, i, j + 1, currentPoints, addedPoints) );

    }
    
    //                                                                          QUESTION 2

    // we're given an array that is merged with two sub arrays , one sub array with elements sorted in the even indices and the other sub array
    // is sorted in the odd indices
    // we need to find a value x that can be a sum of two congruent elements in the array
    // Limitations : method needs to be efficient as possible , if the length of the array is 1 return false

    // says the array is instantiated with integers , doesn't mention if only positive integers or not 

    // naive approach would be O(n) for time complexity so we can infer the optimal time complexity would be O(logn)
    // using the binary search as a template for our solution (section 9.3 page 51), we don't search for a value but for a sum 
    // time complexity is O(log_2(n)) - changing the if statements of the binary search and loop case otherwise everything is the same  
    // space complexity is O(1) - instantiating variables
    public static boolean findX(int[] a, int x) {
        int arrLength = a.length;

        if(arrLength == 0 || arrLength == 1)
            return false;

        int low = 0;
        int high = arrLength - 1;
        int mid;
        
        while(low < high) {
            mid = (low + high)/2;
            // if the sum of congruent pair is equal to the value x return true
            if(a[mid] + a[mid + 1] == x || a[mid] + a[mid - 1] == x) 
                return true;
            // in case we reach one of the array's ends and didn't find a valid sum,  prevent an infinite loop
            if(low + 1 == mid && high - 1 == mid ) {
                    return false;
            }

            if(a[mid] + a[mid + 1] < x) {
               low = mid + 1;    
            }else if(a[mid] + a[mid - 1] > x) {
                high = mid - 1;
            }   
        }
        return false;
    }
    
    //                                                                          QUESTION 3







    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 83 sheelon 481 2016a 2a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 89 sheelon 460 2015a a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given an array instantiated with integers , we need to split the array into two sub-array , they don't need to be of the same length
    // and the elements can be chosen arbitrarily 
    // we need to find two sub arrays such that the product of all elements in one sub array equals to the product of all elements in the second subb array 
    // the product of all elements in the second subb array
    // Limitations : need to solve recursively

    // doesn't mention if the integers are only positive
    // in case we do have non positive integers , we can check the number of non positive elements and if it is odd, we can return false immediately 
    // for example , value 0 appears once in the array or -1 appears only once
    
    // ! if we only use positive integers we can remove the two if statements in splitEqualMult and the method checkIfValidArray !

    public static boolean splitEqualMult(int[] a) {
        // using long in case the product is very large
        if(a.length < 2)
            return false;
        char checkIfValid = checkIfValidArray(a, 0 , 0, 0);
        // only need to check if the array is valid and if there's an even amount of elements with the value of 0
        if(checkIfValid == 'n')
            return false;
        if(checkIfValid == '0')
            return true;
        
        long sum1 = multipyArr(a, 0);
        return splitEqualMult(a, 0, sum1, 1); // sum1 will be the product of all elements in the array , 1 is for sum2 so we'll be able to multiply it 

    }

    private static boolean splitEqualMult(int[] arr, int index, long sum1, long sum2) {
        // check if the sum is the same and return true else , check that the index is valid 
        // then we check if the sum1 is greater than sum2 , if so we continue the recursion and check if 
        // we can split the array into two groups with the same product
        // in case the sum2 is greater than sum1 we return false
        if(sum1 == sum2)
            return true;
        if(index == arr.length)
            return false;
        if(sum1 > sum2) {
            return splitEqualMult(arr, index + 1, sum1, sum2) || splitEqualMult(arr, index + 1, sum1/arr[index], sum2 * arr[index]);
        }else 
            return false;
        
    }

    private static long multipyArr(int[] arr, int index) {
        if(index == arr.length)
            return 1;
        return arr[index]* multipyArr(arr, index + 1);
    }
    // check for edge cases and if the array is valid before we start looking for two sub groups
    // using string for readabily and avoiding magic numbers
    private static char checkIfValidArray(int[] arr, int index, int negCount, int zeroCount) {

        if(index == arr.length) {
            if(negCount%2 == 1 || zeroCount%2 == 1)
                return 'n';
            else if(zeroCount%2 == 0)
                return '0';
            else
                return 'y';
        }
        if(arr[index] == 0)
            zeroCount++;
        if(arr[index] < 0)
            negCount++;

        return checkIfValidArray(arr, index + 1 , negCount, zeroCount);
    }

    //                                                                          QUESTION 2

    //                                                               same question 2 in 2016a 2a moed 481 


    //                                                                          QUESTION 3







    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 89 sheelon 460 2015a a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 84 sheelon 475 2020b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1


    // we're playing the game scrabble, we're given a 2 dimensional array of char and a word to look for
    // we can move in four directions (up, down, left, right) 
    // we need to check if we can create the given word using the letters in the 2D array 
    // if we found a path for the word , we need to return a 2D array of integers and mark the path of the word in ascending order of numbers
    // every other element that is not using for making up the word is 0
    // we then calling a method printArr to print our 2D array path for the word (don't need to write the printArr method assume it exists)
    // if we cant use the letters in the 2D array to create the word we're looking for we return "No Such Word"
    // Limitations : must solve this recursively 

    // assuming we can use charAt and substring()
    public static void findWord(char[][] arr, String word) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        if(0 == word.length())
            System.out.println("No Such Word");
        // this would be the matrix printed in case we find the word
        int[][] pathArr = new int[arr.length][arr[0].length];

        // sending the boundry of the matrix to save some repeating calcs, not important
        int rowMax = arr.length;
        int colMax = arr[0].length;

        System.out.println(moveThroughArr(arr, word, 1, 0, 0, visited, pathArr, rowMax, colMax));

        
    }
    // this method simply iterates through the indices for us to check if the word is there
    private static boolean moveThroughArr(char[][] arr, String word, int count, int i, int j, boolean[][] visited, int[][] pathArr, int rowMax, int colMax) {        
        if(j >= colMax && i < rowMax - 1) {
            j = 0;
            i += 1;
        }
        if(i == rowMax - 1 && j == colMax - 1) {
            return lookForWordV2(arr, word, count, i, j, visited, pathArr);
        }
        return moveThroughArr(arr, word, count, i, j + 1, visited, pathArr, rowMax, colMax) || lookForWordV2(arr, word, count, i, j, visited, pathArr);
    }
    // we check every element in the char array and see if we can make a path that creates the word were looking for in the same order
    // check every possible or available direction with every move we make 
    private static boolean lookForWordV2(char[][] arr, String word, int count, int i, int j, boolean[][] visited, int[][] pathArr) {
        boolean found = false;
        int rowMax = arr.length;
        int colMax = arr[0].length;
        // in case we're out of bounds
        if(i >= rowMax || j >= colMax || i < 0 || j < 0)
            return false;
        //System.out.println("i : " + i + " j : " + j);
        //System.out.println("word length : " + word.length());
        // first check if the current cell has the character we're looking for 
        if(arr[i][j] == word.charAt(0) && !visited[i][j]) {
            // this is for the case where we only need to find the last character of the word
            if(word.length() == 1) {
                pathArr[i][j] = count;
                printArr(pathArr);
                return true;

            }
            // move up if we can and check if the word can be found in that path , use boolean array to avoid going into infinite loops and make sure we don't repeat cells
            if(i < rowMax - 1 && !visited[i][j] && arr[i + 1][j] == word.charAt(1)) {
                visited[i][j] = true;
                pathArr[i][j] = count;
                found = lookForWordV2(arr, word.substring(1), count + 1, i + 1, j, visited, pathArr);
                //System.out.println("DOWN found is : " + found);
                if(found)
                    return true;
                else
                    visited[i][j] = false;
                    pathArr[i][j] = 0;
            }
            // move down if we can
            if(i >= 1 && !visited[i][j] && arr[i - 1][j] == word.charAt(1)) {
                visited[i][j] = true;
                pathArr[i][j] = count;
                found = lookForWordV2(arr, word.substring(1), count + 1, i - 1, j, visited, pathArr);
                //System.out.println("UP found is : " + found);
                if(found)
                    return true;
                else
                    visited[i][j] = false;
                    pathArr[i][j] = 0;
            }
            // move to the right if we can
            if(j < colMax - 1 && !visited[i][j] && arr[i][j + 1] == word.charAt(1)) {
                visited[i][j] = true;
                pathArr[i][j] = count;
                found = lookForWordV2(arr, word.substring(1), count + 1, i, j + 1, visited, pathArr);
                //System.out.println("RIGHT found is : " + found);
                if(found)
                    return true;
                else
                    visited[i][j] = false;
                    pathArr[i][j] = 0;
            }
            // move to the left if we can
            if(j >= 1 && !visited[i][j] && arr[i][j - 1] == word.charAt(1)) {
                visited[i][j] = true;
                pathArr[i][j] = count;
                found = lookForWordV2(arr, word.substring(1), count + 1, i, j - 1, visited, pathArr);
                //System.out.println("LEFT found is : " + found);
                if(found)
                    return true;
                else
                    visited[i][j] = false;
                    pathArr[i][j] = 0;
            }
        }
        //System.out.println("found is : " + found);
        return found;

    }
    // don't need this method , just for making sure the array we print is what we need 
    private static void printArr(int[][] arr) {

        for(int i = 0 ; i < arr.length ; ++i) {

            for(int j = 0 ; j < arr[0].length ; ++j) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // revisiting this question 30/5/22 

    public static void findWordRE(char[][] arr, String word) {

        int arrLength = arr.length;
        boolean[][] visited = new boolean[arrLength][arrLength];
        int[][] path = new int[arrLength][arrLength];

        findWordRE(arr, word, 0, 0, arrLength, 0, visited, path);
        //printArr(path);
        return;
    }

    private static void findWordRE(char[][] arr, String word, int i , int j, int arrLength, int wordLength, boolean[][] visited, int[][] path) {
        
        if(j == arrLength) {
            if(i < arrLength)
                findWordRE(arr, word, i + 1, 0, arrLength, wordLength, visited, path);
            else
                return;
        }    
        if(i < arrLength && j < arrLength) {
            if(word.charAt(wordLength) == arr[i][j] && lookForWord(arr, word, i, j, arrLength, 1, visited, path)) {
                return;
            }
        }
        if(i < arrLength && j < arrLength)
        findWordRE(arr, word, i, j + 1, arrLength, wordLength, visited, path);

    }

    private static boolean lookForWord(char[][] arr, String word, int i , int j, int arrLength, int wordLength, boolean[][] visited, int[][] path) {

        if(i >= arrLength || j >= arrLength || i < 0 || j < 0)
            return false;
        
        if(wordLength == word.length()) {
            path[i][j] = wordLength;
            return true;
        }
        // go right
        if(isValid(i, j + 1, arrLength) && word.charAt(wordLength) == arr[i][j + 1] && !visited[i][j+1]) {
            visited[i][j] = true;
            path[i][j] = wordLength;
            
            if(lookForWord(arr, word, i, j + 1, arrLength, wordLength + 1, visited, path))
                return true;
            
            visited[i][j] = false;
            path[i][j] = 0;
        }
        // go left
        if(isValid(i, j - 1, arrLength) && word.charAt(wordLength) == arr[i][j - 1] && !visited[i][j-1]) {
            visited[i][j] = true;
            path[i][j] = wordLength;
            
            if(lookForWord(arr, word, i, j - 1, arrLength, wordLength + 1, visited, path))
                return true;
            
            visited[i][j] = false;
            path[i][j] = 0;
        }
        // go down
        if(isValid(i + 1, j, arrLength) && word.charAt(wordLength) == arr[i + 1][j] && !visited[i+1][j]) {
            visited[i][j] = true;
            path[i][j] = wordLength;
            
            if(lookForWord(arr, word, i + 1, j, arrLength, wordLength + 1, visited, path))
                return true;
            
            visited[i][j] = false;
            path[i][j] = 0;
        }
        // go up 
        if(isValid(i - 1, j, arrLength) && word.charAt(wordLength) == arr[i - 1][j] && !visited[i-1][j]) {
            visited[i][j] = true;
            path[i][j] = wordLength;
            
            if(lookForWord(arr, word, i - 1, j, arrLength, wordLength + 1, visited, path))
                return true;
            
            visited[i][j] = false;
            path[i][j] = 0;
        }

        return false;
    }


    private static boolean isValid(int i , int j, int boundry) {
        if(i < boundry && j < boundry && i >= 0 && j >= 0)
            return true;
        else
            return false;
    }

    //                                                                          QUESTION 2

    // given an int k (k is a natural number) if k=pq , p,q primes s.t p >= q then p >= k^1/2 >= q , would be fun to prove it 
    // given a natural number n that can be expressed by the product of two prime numbers and
    // a method isHighFactorInRange that checks if the bigger prime number in the product is within the range given true if it is, otherwise false
    // we need to find the two prime numbers that their product is the value n
    // we will only get values that are indeed a product of two primes , we don't need to consider the complexity of method isHighFactorInRange
    // Limitations : must solve this in the most efficient way 

    // almost the same as regular binary search from the book , time complexity O(log_2(n))
    // space complexity O(1)

    public static boolean isHighFactorInRange(int n, int low, int high) {
        int bigger = ( high > low) ? high : low;
        int smaller = ( high < low) ? high : low;
        if( bigger >= 127 && smaller <= 127)
            return true;
        else
            return false;
    }

    public static void findFactors(int n) {
        int low = 2;
        int high = n/2; // we can divide by 2 , 2 is the smallest prime 
        int mid;

        while(low<=high) {
            mid = (low+high)/2;
            boolean rightInterval = isHighFactorInRange(n, mid, high);
            boolean leftInterval = isHighFactorInRange(n , low, mid);
            
            if(rightInterval && leftInterval){
                System.out.println(" p is : " + mid + " q is : " + n/mid );
                return;
            }else if(leftInterval) {
                high = mid - 1;
            }else
                low = mid + 1;

        }
        return;
    }

    //                                                                          QUESTION 3





    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 84 sheelon 475 2020b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon 476 2014 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we're given a two dimensional array of UNIQUE integers , we consider an element arr[i][j] to be a "hill" if the four congruent elements 
    // (or less in case we're near the boundries of the array) up,down,left,right are smaller than arr[i][k]
    // we need to find a path from [0][0] to a hill in ascending order value wise ( for example [i][j] < [i + 1][j] ) and print that path
    // Limitations : the method needs to be recursive , and we can only print one path 

    public static void printPath(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = mat[0].length;

        if(maxRow == 1 && maxCol == 1) {
            System.out.println("(0,0)");
            return;
        }
        if(maxRow == 0 && maxCol == 0)
            return;

        // unique elements and traversing in ascending order value wise , no need to worry for infinite loops

        printPath(mat, 0, 0, maxRow, maxCol);

    }

    private static void printPath(int[][] arr, int i, int j, int rowMax, int colMax) {
        boolean up = true;
        boolean down = true;
        boolean left = true;
        boolean right = true;
        boolean moveUp = false;
        boolean moveDown = false;
        boolean moveLeft = false;
        boolean moveRight = false;

        System.out.print("("+i+","+j+") ");

        if(i >= 1 ) {
            if(arr[i][j] < arr[i-1][j]) {
                up = false;
                moveUp = true;
            }
        }
        if(i < rowMax - 1 ) {
            if(arr[i][j] < arr[i+1][j]) {
                down = false;
                moveDown = true;
            }
        }
        if(j >= 1 ) {
            if(arr[i][j] < arr[i][j-1]) {
                left = false;
                moveLeft = true;
            }
        }
        if(j < colMax - 1 ) {
            if(arr[i][j] < arr[i][j+1]) {
                right = false;
                moveRight = true;
            }
        }
            
        if(up&&down&&left&&right) {
            return;
        }
        if(moveDown) { 
            printPath(arr, i + 1, j, rowMax, colMax);
            return;
        }
        if(moveUp) {
            printPath(arr, i - 1, j, rowMax, colMax);
            return;
        }
        if(moveLeft) {
            printPath(arr, i, j - 1, rowMax, colMax);
            return;
        }
        if(moveRight) {
            printPath(arr, i, j + 1, rowMax, colMax);
            return;
        }
           
    }

    // revisiting this question 30/5/22 

    public static void printPathRE(int[][] mat) {
        printPathRE(mat, 0, 0);
    }

    private static void printPathRE(int[][] arr, int i, int j) {

        if(i < arr.length && j < arr[0].length) {
            String check = printPathRE(arr, i, j, arr.length, arr[0].length);

            if(!check.equals("false")) {
                System.out.print(check);
                return;
            }    
            printPathRE(arr, i, j + 1);

        }else if(i < arr.length && j >= arr[0].length)
            printPathRE(arr, i + 1, 0);
        else
            return;
    }

    private static String printPathRE(int[][] arr, int i, int j, int maxRow, int maxCol) {
        // first thing, check if current element is a hill
        if(checkIfHill(arr, i, j, maxRow, maxCol)) {
            return "("+ i + "," + j + ") ";
        }
        // check four directions , we cannot go into infinite loops since we're told the elements values are unique and we must 
        // traverse in ascending order 
        // we return a string with the coordinates if we found a hill , append each string to the next and thus return a string to the 
        // boolean method printPath that will print the returned string which at that point will be the whole path from the start to the hill     
        if (isValidRE(i + 1, j, maxRow, maxCol) && arr[i][j] < arr[i+1][j]) {
            String next = printPathRE(arr, i + 1, j, maxRow, maxCol);
            if(next.equals("false")) {
                return "false";
            }else
                return "("+ i + "," + j + ") " + next;
        }
        if(isValidRE(i - 1, j, maxRow, maxCol) && arr[i][j] < arr[i-1][j]) {
            String next = printPathRE(arr, i - 1, j, maxRow, maxCol);
            if(next.equals("false")) {
                return "false";
            }else
                return "("+ i + "," + j + ") " + next;
        }
        if(isValidRE(i, j + 1, maxRow, maxCol) && arr[i][j] < arr[i][j+1]) {
            String next = printPathRE(arr, i, j + 1, maxRow, maxCol);
            if(next.equals("false")) {
                return "false";
            }else
                return "("+ i + "," + j + ") " + next;
        }
        if(isValidRE(i, j - 1, maxRow, maxCol) && arr[i][j] < arr[i][j-1]) {
            String next = printPathRE(arr, i, j - 1, maxRow, maxCol);
            if(next.equals("false")) {
                return "false";
            }else
                return "("+ i + "," + j + ") " + next;
        }

        return "false";

    }

    // method to check at every index if it is a hill or not 
    private static boolean checkIfHill(int[][] arr, int i , int j, int maxRow, int maxCol) {
        // check four directions , we only need to check 3 but doing so will cost us in more lines of code and 
        // cumbersome work to identify which direction was already checked (only 3 since we can only move in ascending order)
        if (isValidRE(i + 1, j, maxRow, maxCol) && arr[i][j] < arr[i+1][j]) {
            return false;
        }
        if(isValidRE(i - 1, j, maxRow, maxCol) && arr[i][j] < arr[i-1][j]) {
            return false;
        }
        if(isValidRE(i, j + 1, maxRow, maxCol) && arr[i][j] < arr[i][j+1]) {
            return false;
        }
        if(isValidRE(i, j - 1, maxRow, maxCol) && arr[i][j] < arr[i][j-1]) {
            return false;
        }

        return true;
    }

    //                                                                          QUESTION 2

    // given an array filled with unique integers in ascending order
    // and rotation operation , we see the array as a cyclic object , we can rotate the elements we update the indices base on the rotation and we don't lose data
    // find the maximum value in the array 
    // Limitations : solve in the most efficient way 
    // naive way would be time complexity O(n) so we can assume we need to be around O(long(n)) so using some sort of binary search would be a good start
    
    // using the binary search this method has a time complexity of O(long_2(n)) and space complexity of O(1)    


    // we need to find the element such that arr[i] > arr[i+1] and i would be the index of the maximum value 
    public static int findMaxV2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {

            if(low == high)
                return low;

            mid = (low+high)/2;
            // checking that indices are valid and if arr[mid] is bigger than arr[mid+1] then mid is the index we're looking for 
            if(mid < high && arr[mid] > arr[mid + 1])
                return arr[mid];
            // same, checking indices and looking for the maximum value
            if(mid > low && arr[mid] < arr[mid - 1])
                return arr[mid - 1];
            // determine if the maximum is in the right interval or left interval 
            if(arr[mid] < arr[low])
                high = mid - 1;
            else
                low = mid + 1;
            
        }
        // in case low < high the value will be at index 0
        return 0;
    }


    // we dont really need to shift the array , we can just use two variables for the start and end of the array and use modulo of the array's length
    // made things complicated here for no reason 
    public static int findMaxV1(int[] arr) {
        int arrLength = arr.length;
        //int shift = 0;
        int low = 0;
        int high = arr.length - 1;
        int mid = (low+high)/2;
        // arr would be length of 3 or more
        while(low<=high) {
            //mid=(low+high)/2;
            // arr[mid] value is between the two congruent elements 
            if(arr[mid] < arr[(mid+1)%arrLength] && arr[(mid-1)%arrLength] < arr[mid]) {

                if(arr[low] > arr[(mid - 1 )%arrLength]) {
                    low = (low+mid-1) % arrLength;
                    high = (high+mid-1) % arrLength;
                    //continue;
                }else if(arr[high] < arr[(mid+1)%arrLength]) {
                    high = ( high+high - mid + 1  )% arrLength;
                    low = ( low+high - mid + 1  )% arrLength;
                    //continue;
                }else
                    return high;


            }else if(arr[mid] > arr[(mid+1)%arrLength]) { // !!                             !!
                // shift mid to index arr.length-1  49,52,65,70,-5,3,48 -> -5,3,48,49,52,65,70
                high = mid;
                low = mid+1;

            }else if(arr[(mid-1)%arrLength] > arr[mid]) {// !!             !!
                // shift mid to index 0             52,65,70,-5,3,48,49 ->  -5,3,48,49,52,65,70
                high = mid-1;
                low = mid;
            }

        }// while loop
        return high;
    }

    // revisiting this question 30/5/22 - a more compact solution 

    public static int findMaxRE(int[] arr) {

        if(arr.length == 1)
            return arr[0];

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(low < high) {
            
            mid = low + (high - low)/2;
            
            if(arr[low] > arr[high])
                high = mid;
            else
                low = mid + 1;
           
        }
        return low;
    }

    //                                                                          QUESTION 3
    

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon 476 2014 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon 466 2019 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a two dimensional array of positive integers we need to find how many paths there are from [0][0] to [n-1][m-1]
    // each element has a value , we can move in 4 directions (up,down,left,right) but the value of the element dictates how many "jumps" / elements 
    // we have to move through in the direction chosen
    // Limitations : must solve it recursively, we can change the array temporarly , at the end of the method the array must be in it's original state

    public static int howManyPaths(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int maxRow = arr.length;
        int maxCol = arr[0].length;
        return howManyPaths(arr, 0, 0, maxRow, maxCol, visited);
    }

    private static int howManyPaths(int[][] arr, int i, int j, int maxRow, int maxCol, boolean[][] visited) {
        int count = 0;
        
        if(i == maxRow - 1 && j == maxCol - 1)
            return 1;
        
        if(i >= maxRow && j >= maxCol)
            return 0;

        if(i + arr[i][j] < maxRow && !visited[i][j]) {
            visited[i][j] = true;
            int down = howManyPaths(arr, i + arr[i][j], j, maxRow, maxCol, visited);
            count += down;
            visited[i][j] = false;

        }
        if(i - arr[i][j] >= 0 && !visited[i][j]) {
            visited[i][j] = true;
            int up = howManyPaths(arr, i - arr[i][j], j, maxRow, maxCol, visited);
            count += up;
            visited[i][j] = false;
        }
        if(j + arr[i][j] < maxCol && !visited[i][j]) {
            visited[i][j] = true;
            int right = howManyPaths(arr, i, j + arr[i][j], maxRow, maxCol, visited);
            count += right;
            visited[i][j] = false;
        }
        if(j - arr[i][j] >= 0 && !visited[i][j]) {
            visited[i][j] = true;
            int left = howManyPaths(arr, i, j - arr[i][j], maxRow, maxCol, visited);
            count += left;
            visited[i][j] = false;
        }
        
        return count;
    }

    // revisiting this quesiton 30/5/22 - multiplying by -1 to avoid creating a boolean array , doing boundry checks using another method 

    public static int howManyPathsRE(int[][] mat) {
        return howManyPathsRE(mat, 0, 0, mat.length, mat[0].length);
    }

    private static boolean isValidRE(int i, int j, int maxRow, int maxCol) {
        if(i < 0 || j < 0 || i >= maxRow || j >= maxCol)
            return false;
        else
            return true;
    }

    private static int howManyPathsRE(int[][] arr, int i, int j , int maxRow, int maxCol) {
        
        int paths = 0;

        if(i == maxRow - 1 && j == maxCol - 1) 
            return 1;
        
        if(isValidRE(i + arr[i][j], j, maxRow, maxCol) && arr[i + arr[i][j]][j] > 0) {
            arr[i][j]*= (-1);
            paths += howManyPathsRE(arr, i - arr[i][j], j, maxRow, maxCol);
            arr[i][j]*= (-1);
        }
        if(isValidRE(i - arr[i][j], j, maxRow, maxCol) && arr[i - arr[i][j]][j] > 0) {
            arr[i][j]*= (-1);
            paths += howManyPathsRE(arr, i + arr[i][j], j, maxRow, maxCol);
            arr[i][j]*= (-1);
        }
        if(isValidRE(i, j + arr[i][j], maxRow, maxCol) && arr[i][j + arr[i][j]] > 0) {
            arr[i][j]*= (-1);
            paths += howManyPathsRE(arr, i, j - arr[i][j], maxRow, maxCol);
            arr[i][j]*= (-1);
        }
        if(isValidRE(i, j - arr[i][j], maxRow, maxCol) && arr[i][j - arr[i][j]] > 0) {
            arr[i][j]*= (-1);
            paths += howManyPathsRE(arr, i, j + arr[i][j], maxRow, maxCol);
            arr[i][j]*= (-1);
        }

        return paths;
    }

    //                                                                          QUESTION 2

    // given two arrays of integers , a and b such that array a is sorted in a way that ∀ i < j , a[i] <= a[j]
    // and array b is sorted in such a way that ∀ i < j ,  a[i] >= a[j]
    // we need to find the smallest index i such that a[i] == b[i] , if there's no such i , return -1
    // Limitations : method needs to be efficient as possible
    // naive/brute force way would be time complexity of O(n) where n is the length of the smaller array of the two so we're probably looking at 
    // O(log_2(n)) time complexity using a variation of binary search 
    /*
        we can choose to approach this problem from two directions , usig a the non increasing array as our guide or b the non decreasing array
        in this case we'll use a
        in the example a is the shorter array so we bo by length 9 and use the middle of as the standpoint for both arrays
        since a[4] > b[4] and a is non increasing while b is non decreasing we know that the index i we're looking for will be  5 <= i <= 8
        if b[0] >= a[0]  that means we need to look at the left interval of the arrays since a is non increasing and b is non decreasing
        if at any point in one of the arrays we get a[k] = a[k+l] we know the values are the same in that interval and the same goes in case it happens for array b
    */
    // time complexity O(log_2(n)) using binary search , space complexity is O(1)
    public static int meetingPoint(int[] a, int[] b) {
        int arrLength = (a.length < b.length) ? a.length : b.length;
        int low = 0;
        int high = arrLength - 1;
        int mid = (low+high)/2;
        int i = arrLength;
        while(low < high) { 
            mid = (low+high)/2;
            // looking for the lowest index 
            if(a[low] == b[low] && low < i)
                i = low;
            // deciding if we look at the left or right interval 
            if(mid < high && a[mid] > b[mid]) {
                low = mid + 1;
            }else if( mid > low)
                high = mid - 1;

        }
        // returning an index if found else returning -1 
        return (i == arrLength) ? -1 : i;
    }

    // revisiting this question 30/5/22 - seems like this is the corrent answer compared to the old solution 

    public static int meetingPointRE(int[] a, int[] b) {
        // b - sorted in non decreasing order
        // a - sorted in non increasing order 
        int maxLength = (a.length > b.length) ? b.length : a.length;
        int minIndex = maxLength;
        int low = 0;
        int high = maxLength - 1;
        int mid = 0;

        while(low <= high) {

            mid = low + (high - low)/2;
            
            if(a[mid] == b[mid]) {
                high = mid;
                if(minIndex > mid)
                    minIndex = mid;
                if(low == high)
                    break;
            }

            if(a[mid] > b[mid])
                low = mid + 1;
            else
                high = mid;
            
        }

        return (minIndex == maxLength) ? -1 : minIndex;
    }


    //                                                                          QUESTION 3





    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon 466 2019 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon 474 2013 4a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1


    // given a one way linked list we define a sub sequence as a series of numbers from the list as long as they're ordered in the same
    // order of the linked list (cannot have the same node twice and can't mix up the order of the nodes)
    // given the class IntNode with getters and setters (mutators and accessors) and class IntList 
    // we need to add method to class IntList named longestAscending that returns the longest valid sub sequence in that linked list 
    // Limitations : must solve recorsively , obviously we can only use built-in methods and classes that were only mentioned in the book 



    /*
    public class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }
    public IntList(IntNode node) {
        _head = node;
    }

    public int longestAscending() {
        return 1 + sendNodes(_head, _head.getNext()); // +1 counting the current node 
    }
    // this method checks every possible valid combination for 2 starting points to account for cases like 2-4-3-4-5 
    private int sendNodes(IntNode node , IntNode checkNode ) { // ;)
        if(node.getNext() == null)
            return 0;
        if(checkNode == null) {
            node = node.getNext();
            checkNode = node.getNext();
            return sendNodes(node, checkNode);
        }
        return Math.max( longestAscending(node, checkNode) , sendNodes(node, checkNode.getNext()) );
    }
    // counts the length of the sub sequence excluding the first node , we count that when we return the value @ longestAscending()
    private int longestAscending(IntNode node, IntNode compare) {
        //IntNode currentNode = node;
        //IntNode comparingNode = compare;

        if(compare != null) {
            if(node.getValue() < compare.getValue()){
                return 1 + longestAscending(compare, compare.getNext());
            }else
                return longestAscending(node, compare.getNext());
        }
        return 0;
    }

}

    */


    //                                                                          QUESTION 2

    // given a SORTED array of UNIQUE integers we need to find the index i such that arr[i] == i , if there's no such i return -1
    // there may be multiple cases for such index i , in case that happens,  it doesn't matter which valid index we return 
    // Limitations : needs to be efficient as possible
    // since the naive way would be time complexity of O(n) we probably need to get to O(log(n)) so maybe binary search would be ideal here

    // we have a sorted array of unique integers so we can split the array , check the value of arr[mid] if the value is bigger than the index (arr[mid] > mid)
    // we can safely assume the index i we're looking for is not in the right interval of the array and can check if there's such index i in the right 
    // interval repeating this proccess 
    // the same goes in case the value arr[mid] is less than the index mid (arr[mid] < mid)

    // time complexity is O(log_2(n)) ,using binary search 
    // space complexity is O(1) only instantiating variables 

    public static int fixedPoint(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while(low <= high) {

            if(low == high) {   // in case the array is of length 1 , can move it outside the while loop for more efficiency
                if(a[low] == low)
                    return low;
                else
                    return -1;
            }
                
            mid = (low+high)/2;

            if(mid == a[mid])
                return mid;

            if(mid < a[mid])
                high = mid - 1;
            if(mid > a[mid])
                low = mid + 1;
        }
        return -1;
    }

    // revisiting this question 30/5/22 almost the same answer , don't need to paste the solution again 

    //                                                                          QUESTION 3




    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon 474 2013 4a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 83 sheelon 465 2015 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given two strings s and t, we need to find the longest sub-string that that's in both strings
    // we define a sub string as a string of letters that don't have to be congruent but they must follow the order of the letters in the original strings
    // Limitations : must solve this recursively , can only use the methods charAt() and length() in class String , other methods from that class are not allowed

    // we need to use two pointers , one fixed point that will be our starting letter and another one that increase in index by 1 every time 
    // in this way we can check every possible combination that meets the requirements 

    // need to clean up the code and maybe change things , looks bad at the moment
    // need to try this question again at some time 
    public static int lcs(String s, String t) {
        // returning the length of the shorter string as maxLength , the first parameter will be the longest string
        if(s.length() >= t.length())
            return lcs(s, t, 0, 0, t.length());
        else
            return lcs(t, s, 0, 0, s.length());
    }

    private static int lcs(String s, String t, int startIndex, int minIndex, int maxLength) {
        // maxLength would be the shorter length of the two strings
        if(minIndex > maxLength || startIndex >= s.length())
            return 0;
                                                                                    // check if the letter of string s at startIndex can be 
        int checkIfFound = checkForLetter(s, t, startIndex, minIndex);              // found in the other string , t , at some index >= minIndex
        if(checkIfFound != -1 && checkIfFound >= minIndex) {
            if(checkIfFound == startIndex)                                          // in case the indices are equal and so are the letters , we can just move forward
                return 1 + lcs(s, t, startIndex + 1, checkIfFound + 1, maxLength);  
            else                                                                    // in case the indices are not equal but the letter was found 
                return Math.max( 1 + lcs(s, t, startIndex + 1, checkIfFound, maxLength),lcs(s, t, startIndex + 1, minIndex, maxLength) );
                                                                                    // we check both possibilies , picking up the letter or skipping it
        }else
            return lcs(s, t, startIndex + 1, minIndex, maxLength);                  // in case the letter can't be found in string t at some index >= minIndex


    }

    private static int checkForLetter(String s, String t, int startIndex, int minIndex) {
                                                                                    // check if the indices are valid and if the letters match
        if(minIndex < t.length() && s.charAt(startIndex) == t.charAt(minIndex))     // return index minIndex + 1 that will be the new minIndex in method lcs
            return minIndex + 1;                                                    // and we avoid the bug of counting the same letter twice ex. s = "...a" ,t = "...aa"
        else if(minIndex < t.length())
            return checkForLetter(s, t, startIndex, minIndex + 1);

        return - 1;                                                                 // magic number , if the letter is not found we return -1
    }

    // revisiting this question 30/5/22 , way better , added recusion and recursion with memoization 

    private static void initLcsArr(int[][] dp , int i , int j , int maxRow, int maxCol) {

        if(j >= maxCol) {
            if(i == maxRow - 1)
                return;
            else
                initLcsArr(dp, i + 1, 0, maxRow, maxCol);
        }else {
            dp[i][j] = -1;
            initLcsArr(dp, i, j + 1, maxRow, maxCol);
        }
    }

    public static int lcsRE(String s, String t) {
        //int[][] dp = new int[s.length() + 1][t.length() + 1];
        //initLcsArr(dp, 0, 0, s.length() + 1, t.length() + 1);
        //return lcs(s, t, s.length(), t.length(), dp);
        return lcsRE(s, t, s.length(), t.length());

    }
    
    private static int maxRE(int a, int b) {
        return (a > b) ? a : b;
    }

    private static int lcsRE(String origin, String subString, int originIndex, int subSIndex) {

        if(originIndex == 0 || subSIndex == 0)
            return 0;

        if(origin.charAt(originIndex - 1) == subString.charAt(subSIndex - 1))
            return 1 + lcsRE(origin, subString, originIndex - 1, subSIndex - 1);
        else
            return maxRE(lcsRE(origin, subString, originIndex, subSIndex - 1) , lcsRE(origin, subString, originIndex - 1, subSIndex) );

    }

    private static int lcsRE(String origin, String subString, int originIndex, int subSIndex, int[][] dp) {

        if(originIndex == 0 || subSIndex == 0)
            return 0;

        if(dp[originIndex][subSIndex] != -1)
            return dp[originIndex][subSIndex];
        
        if(origin.charAt(originIndex - 1) == subString.charAt(subSIndex - 1)) 
            return dp[originIndex][subSIndex] = 1 + lcsRE(origin, subString, originIndex - 1, subSIndex - 1, dp);
        else 
            return dp[originIndex][subSIndex] = max(lcsRE(origin, subString, originIndex - 1, subSIndex, dp),lcsRE(origin, subString, originIndex, subSIndex - 1, dp));
         
    }

    //                                                                          QUESTION 2

    // given an array of integers , we need to change the array , for every index i we need to replace arr[i] with the maximum value 
    // in the interval ( i , arr.length-1 ] and repeat the proccess until the last index , that index will be repalced with 0 
    // Limitations : solution needs to be efficient as possible

    // naive way would be time complexity of O(n^2) and space complexity of O(1)

    // at the end we know for sure that , [arr.length - 2] =  [arr.length - 1] ,   [arr.length - 1] = 0
    // we can start from the end of the array , in that way we only need to iterate through the array once 
    // so time complexity is O(n) iterating through the array once 
    // space complexity is O(1) only instantiating variables

    public static void replace(int[] a) {
        int arrLength = a.length;
        int temp = 0;
        // question says the array is filled with intergers therefore cannot be empty but can be of length 1
        if(arrLength == 1) {
            a[0] = 0;
            return;
        }
        // we start from the end of the array and continue towards the start of it , changing every element to the maximum value in the interval to the right of it 
        int tempMax = a[arrLength - 1];
        for(int i = arrLength - 1 ; i >= 0 ; --i) {
            if(tempMax >= a[i]) {
                a[i] = tempMax;
            }else {
                temp = tempMax;
                tempMax = a[i];
                a[i] = temp;
            }
        }
        
        a[arrLength - 1] = 0;
        /*
        for(int i = 0 ; i < arrLength ; ++i) {
            System.out.print(" " + a[i] + " ");
        }
        */
        return;
    }

    // revisiting this question 30/5/22 , same thing

    public static void replaceRE(int[] arr) {

        int maxIndex = arr.length;
        int pointer = arr[maxIndex - 1];
        int temp = arr[maxIndex - 1];

        for(int i = maxIndex - 1 ; i >= 0 ; --i) {
            
            if(arr[i] >= pointer) {
                pointer = arr[i];
                arr[i] = temp;
                temp = pointer;
            }else
                arr[i] = pointer;
        }

        arr[maxIndex - 1] = 0;
        return;
    }

    //                                                                          QUESTION 3


    


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 83 sheelon 465 2015 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 93 sheelon 465 2017 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we're given a square matrix , 2 dimensional array of size nxnx of booleans
    // we we define a true region as the maximum true elements in congruence (up,down,left,right) , a true region will be made of at least one true element
    // we need to return the amount of true regions in the matrix , if there are none , return 0
    // Limitations : need to solve it in recursion
    
    // what we can do is , traverse through the array , we count the first encounter of a true element 
    // and then we use another method to trace the path of that region\island and change every element that is true to false
    // then we can iterate through the array without counting regions twice

    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, mat.length); // square matrix so size of nxn
    }

    private static int cntTrueReg(boolean[][] mat, int i, int j, int maxIndex) {
        // checking bounds and iterating through the matrix
        if(j >= maxIndex && i < maxIndex) {
            return cntTrueReg(mat, i + 1, 0, mat.length);
        }else if(j >= maxIndex && i >= maxIndex)
            return 0;    

        // if false, continue , else change the region to false and count 1 and repeat until we reach the end of the matrix
        if(!mat[i][j]) {
            return cntTrueReg(mat, i, j + 1, mat.length);
        }else {
            changeArray(mat, i, j, maxIndex);
            return 1 + cntTrueReg(mat, i, j + 1, mat.length);
        }    

    }

    private static void changeArray(boolean[][] arr, int i, int j, int maxIndex) { // trace the true path and change it 
        if(j >= maxIndex || i >= maxIndex || i < 0 || j < 0)
            return;
        
        if(arr[i][j]) {

            arr[i][j] = false;

            if(j < maxIndex - 1 && arr[i][j + 1])
                changeArray(arr, i, j + 1, maxIndex);
            if(i < maxIndex - 1 && arr[i + 1][j])
                changeArray(arr, i + 1, j, maxIndex);    
            if(j >= 1 && arr[i][j - 1])
                changeArray(arr, i, j - 1, maxIndex);
            if(i >= 1 && arr[i - 1][j])
                changeArray(arr, i - 1, j, maxIndex);

        }
    }

    // 9/6/22 revisiting this question using F&U \ DUS - are we allowed to add classes besides other methods ? 

    public static int cntTrueRegRE1(boolean[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        // we're emulating a 2d array using a 1d array - row-major order
        DisjointUnionSet disjUnionSet = new DisjointUnionSet(row*col);
        unionIslands(mat, disjUnionSet, 0, 0, row, col);
        int[] freq = new int[row*col];
        return countIslands(mat, disjUnionSet, freq, 0, 0, 0, row, col);
        
    }


    private static void unionIslands(boolean[][] mat, DisjointUnionSet disjUnionSet, int i , int j, int maxRow, int maxCol) {

        if( (i == maxRow - 1 && j >= maxCol ) || i >= maxRow)
            return;
        
        if(i < maxRow && j >= maxCol)
            unionIslands(mat, disjUnionSet, i + 1, 0, maxRow, maxCol);
        else {

            if(mat[i][j]) { // if true , check for an element set as 'true' in the four possible directions 
                            // if there is any , union it with the current element
                if(i + 1 < maxRow && mat[i + 1][j])
                    disjUnionSet.union(i*maxCol + j, (i+1)*maxCol + j);
                if(i - 1 >= 0 && mat[i - 1][j])
                    disjUnionSet.union(i*maxCol + j, (i-1)*maxCol + j);
                if(j + 1 < maxRow && mat[i][j + 1])
                    disjUnionSet.union(i*maxCol + j, i*maxCol + j + 1);
                if(j - 1 >= 0 && mat[i][j - 1])
                    disjUnionSet.union(i*maxCol + j, i*maxCol + j - 1);

            }
            unionIslands(mat, disjUnionSet, i, j + 1, maxRow, maxCol);
        }
        
    } // end of unionIslands

    private static int countIslands(boolean[][] mat, DisjointUnionSet disjUnionSet, int[] freq, int islands, int i , int j, int maxRow, int maxCol) {

        if( i == maxRow - 1 && j >= maxCol )
            return islands;

        if(i < maxRow && j >= maxCol)
            return countIslands(mat, disjUnionSet, freq, islands, i + 1, 0, maxRow, maxCol);
        else {

            if(mat[i][j]) { 

                int root = disjUnionSet.find(i*maxCol + j); // get the root of the current node/element that is set as 'true'
                
                if(freq[root] == 0) {   // if the value of freq[root] = 0 that means it is a new island , so we increment both 'islands' and 'freq[root]'
                    islands += 1;       // if freq[root] != 0 then it means the current node/element is already a part of a known set aka
                    freq[root] += 1;    // a known island so we simply increase 'freq[root]' by 1 and move on to the next element and repeat the process
                }else                   // at the end , each element of the array 'freq[]' with a value > 0 will represent a unique island 
                    freq[root] += 1;    // and the value of the element is the number of nodes/elements that form the set (island in that case)

            }

            return countIslands(mat, disjUnionSet, freq, islands, i, j + 1, maxRow, maxCol);
        }

    }

    public static class DisjointUnionSet {

        private int[] rank;
        private int[] parent;
        private int n;

        public DisjointUnionSet(int arrLength) {
            rank = new int[arrLength];
            parent = new int[arrLength];
            this.n = arrLength;
            initSet(0);
        }
        // init the array such that the sets are disjoint at first 
        private void initSet(int index) {

            if(index >= n)
                return;

            parent[index] = index;
            initSet(index + 1);
        }

        public int find(int x) {
            
            if(parent[x] != x)
                parent[x] = find(parent[x]); // doing compression as well 
            
            return parent[x];
        }

        public void union(int x, int y) {

            int xRoot = find(x);
            int yRoot = find(y);

            if(xRoot == yRoot) // if the roots are the same , it means that the nodes are from the same set already
                return;
            // we do the union this way as to avoid increasing the height of the "tree" and therefore we avoid extra potential time complexity 
            if(rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if(rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;
            else {
                // in case they're of the same rank , we can arbitrarily choose which parent will point where 
                // after doing so we increase the rank of the root we point to 
                parent[yRoot] = xRoot;
                rank[xRoot] += 1;
            }

        }

    }

    // 9/6/22 revisiting this question - a hacky solution , solving with 'bfs'
    /*
        we can also get by with a node containing just one int , we'll use row-major order so the int will be i*colMax + j
        and to extract the coords we will simply divide by colMax to get the i'th index and modulo colMax to get the j'th index

        so , _value = i*array[0].length + j , where i is the row index and j is the col index 
        i = _value/array[0].length
        j = _value%array[0].length

        using the boolean visited matrix is an option for this question since we're allowed to change the elements of the given boolean array
        but if we can't then the visited matrix is a must 
    */
    public static int cntTrueRegBFS(boolean[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        boolean[][] visited = new boolean[row][col];
        int islands = 0;
        Queue queue = new Queue();
        return cntTrueRegBFS(mat, visited, queue, 0, 0, row, col, islands);
    }

    private static int cntTrueRegBFS(boolean[][] mat, boolean[][] visited, Queue queue, int i, int j, int maxRow, int maxCol, int islands) {
        // we traverse through the array , if we find an element that is set as 'true' and !visited[i][j] then it means we found a part of the island
        // so we add the coords to queue , call the function breadthFS to set all the other members of the set/island as visited and increase the islands count
        if(i == maxRow - 1 && j >= maxCol)
            return islands;
        if(i < maxRow && j >= maxCol)
            return cntTrueRegBFS(mat, visited, queue, i + 1, 0, maxRow, maxCol, islands);
        else {
            if(!visited[i][j] && mat[i][j]) {
                islands += 1;
                queue.enqueue(i, j);
                visited[i][j] = true;
                breadthFS(mat, visited, queue, i, j, maxRow, maxCol);
            }

            return cntTrueRegBFS(mat, visited, queue, i, j + 1, maxRow, maxCol, islands);
        }

    }

    public static void breadthFS(boolean[][] mat, boolean[][] visited, Queue queue, int i, int j, int maxRow, int maxCol) {

        if(i < 0 || j < 0 || i >= maxRow || j >= maxCol)
            return;
        else {
            // check all four valid directions , if the element is part of the island we call enqueue with the new values and set visited to true @ the new coords 
            if(i + 1 < maxRow && !visited[i + 1][j] &&mat[i + 1][j]) {
                queue.enqueue(i + 1, j);
                visited[i + 1][j] = true;
            }
            if(i - 1 >= 0 && !visited[i - 1][j] && mat[i - 1][j]) {
                queue.enqueue(i - 1, j);
                visited[i - 1][j] = true;
            }
            if(j + 1 < maxCol && !visited[i][j + 1] && mat[i][j + 1]) {
                queue.enqueue(i, j + 1);
                visited[i][j + 1] = true;
            }
            if(j - 1 >= 0 && !visited[i][j - 1] && mat[i][j - 1]) {
                queue.enqueue(i, j - 1);
                visited[i][j - 1] = true;
            }
                    
        }
        // first checking if queue is empty since deque doesn't check for that 
        // then update i and j to the next coords from the queue , dequeue and only then the function calls itself again to look for more parts of the island
        if(!queue.isEmpty()) {
            i = queue.getValueX();
            j = queue.getValueY();
            queue.dequeue();
            breadthFS(mat, visited, queue, i, j, maxRow, maxCol);
        }
    }

    public static class Queue {

        private IntNode _head;
        private IntNode _tail;

        public Queue() {
            _head = null;
            _tail = null;
        }

        public boolean isEmpty() {
            return _head == null;
        }

        public void enqueue(int x, int y) {

            IntNode temp = new IntNode(x,y,null);
            if(_tail != null)
                _tail.setNext(temp);
            _tail = temp;
            if(_head == null)
                _head = temp;

        }
        // FIFO + return the value of the node without aliasing
        public IntNode dequeue() {
            // before calling this method we need to call isEmpty
            // notice that we call the getVal methods of class IntNode 
            IntNode temp = new IntNode(_head.getValueX(),_head.getValueY(),null);
            _head = _head.getNext();
            return temp;
        }
        
        public int getValueX() {
            return _head._xCoord;
        }

        public int getValueY() {
            return _head._yCoord;
        } 
    }

    public static class IntNode {

        private int _xCoord;
        private int _yCoord;
        private IntNode _next;

        public IntNode(int xCoord, int yCoord, IntNode next) {
            // may need to add validation for the integers since we're working with arrays as well 
            _xCoord = xCoord;
            _yCoord = yCoord;
            _next = next;
        }

        public IntNode() {
            _xCoord = 0;
            _yCoord = 0;
            _next = null;
        }

        public int getValueX() {
            return _xCoord;
        }

        public int getValueY() {
            return _yCoord;
        }

        public IntNode getNext() {
            return _next;
        }

        public void setValueX(int x) {
            _xCoord = x;
        }

        public void setValueY(int y) {
            _yCoord = y;
        }

        public void setNext(IntNode next) {
            _next = next;
        }

    }

    // 10/6/22 adding DFS solution even though the first solution is a DFS as well 

    public static int cntTrueRegDFS(boolean[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        int islands = 0;
        return cntTrueRegDFS(mat, 0, 0, row, col, islands);
    }

    private static int cntTrueRegDFS(boolean[][] mat, int i, int j, int maxRow, int maxCol , int islands) {

        if(i == maxRow - 1 && j >= maxCol)
            return islands;
        if(i < maxRow && j >= maxCol)
            return cntTrueRegDFS(mat, i + 1, 0, maxRow, maxCol, islands);
        else {
            if(mat[i][j]) {
                islands += 1;
                depthFS(mat, i, j, maxRow, maxCol);
            }

            return cntTrueRegDFS(mat, i, j + 1, maxRow, maxCol, islands);
        }

    } 

    private static void depthFS(boolean[][] mat, int i, int j, int maxRow, int maxCol) {

        if(i >= 0 && i < maxRow && j >= 0 && j < maxCol && mat[i][j]) {
            mat[i][j] = false;

            depthFS(mat, i + 1, j, maxRow, maxCol);
            depthFS(mat, i - 1, j, maxRow, maxCol);
            depthFS(mat, i, j + 1, maxRow, maxCol);
            depthFS(mat, i, j - 1, maxRow, maxCol);

        }

    }

    //                                                                          QUESTION 2

    // given a sorted array of positive integers (∀i<j , arr[i] <= arr[j])
    // find the smallest positive integer than cannot be represented as a sum of any subsequence in the array 

    // travese through the array while adding each element to a sum , if there's a valid integer then it will be less than next elements value 
    // but bigger by 1 than the current sum 

    // time complexity O(n) , iterating through the array at most once
    // space complexity O(1)
    public static int findSmallestInt(int[] arr) {
        int sum = 0;
        for(int i = 0 ; i < arr.length ; ++i) {

            if(arr[i] - sum >= 2) // if the difference is greater or equal to 2 then it means we found a valid integer 
                return sum + 1;
            else
                sum += arr[i]; // moving on to the next element 
        }
        return sum + 1; // reaching this point means that we coudn't find any valid integer in [arr[0],arr[arr.length-1]]
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 93 sheelon 465 2017 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 87 sheelon 465 2017 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we're given two arrays filled with positive integers, 2 dimensional array mat of size nxm, and 1 dimensional array arr of size m 
    // and integer k , 1<= k <= n
    // we need to check if we can find k or less rows in array mat such that every element in array arr can be found in them 
    // if we found such rows return true , otherwise false
    // Limitations : need to solve recursively

    // we have the option to use 3 given methods if needed , allZero(int[] x) , copy(int[] dest, int[] src) , xZero(int[] x, int[] y)

    // we'll try every possible combination of k or less rows , this is not the most efficient solution but it will work(brute force)
    // we'll use the optional methods


    public static boolean covers(int[][] mat, int[] arr, int k) {
        int[] tempCopy = new int[arr.length];
        copy(tempCopy, arr);

        return covers(mat, tempCopy, k, 0);
    }

    private static boolean covers(int[][] mat, int[] arr, int k, int movingIndex) {
        // if we meet the requirement
        if(allZero(arr))
            return true;
        // checking boundries
        if(k == 0 || movingIndex >= mat.length)
            return false;

        // copying the current arr and using xZero in attempt to change elements to zero 
        int[] check = new int[arr.length];
        copy(check, arr);
        xZero(check, mat[movingIndex]);
        // we check every possible combination of <= k rows
        return covers(mat, check, k-1, movingIndex + 1) || covers(mat, arr, k, movingIndex + 1);
    }


    private static void copy(int[] dest, int[] src) {
        return ;
    }
    private static void xZero(int[] x, int[] y) {
        return;
    }
    private static boolean allZero(int[] x) {
        return true;
    }

    // 11/6/22 revisiting this question - the old solution is wrong as it assumes we can send a specific row from a matrix as a 1d row in java

    public static boolean coversRE(int[][] mat, int[] arr, int k) {
        return coversRE(mat, arr, k, 0);
    }

    private static boolean coversRE(int[][] mat, int[] arr, int k, int i) {
        
        if(allZeroRE(arr))
            return true;

        if(k < 0 || i >= mat.length || i < 0 )
            return false;

        int[] temp = new int[arr.length]; // we'll copy array 'arr' then we will call xZero to compare this array with the i'th row of the matrix 'mat'
        int[] subMat = new int[arr.length]; // we're told arr.length == mat[0].length
        copyRow(mat, subMat, i, 0); // copy the current row as we can't send a specific row from a 2d array

        copyRE(temp, arr);
        xZeroRE(temp, subMat);
        
        return coversRE(mat, arr, k, i + 1) || coversRE(mat, temp, k - 1, i + 1); // two option , moving on without checking mat's row or check and update 'arr' accordingly
    }
    // a simple method to copy a specific row from the matrix 'mat'
    private static void copyRow(int[][] mat, int[] subMat, int i, int j ) {
        
        if(j >= subMat.length)
            return;

        subMat[j] = mat[i][j];
        copyRow(mat, subMat, i, j + 1);

    }

    private static boolean allZeroRE(int[] x) {

        for(int i = 0 ; i < x.length ; ++i)
            if(x[i] != 0)
                return false;

        return true;
    }

    private static void copyRE(int[] dest, int[] src) {
        for(int i = 0 ; i < dest.length ; ++i) {
            dest[i] = src[i];
        }
    }

    private static void xZeroRE(int[] x, int[] y) {
        for(int i = 0 ; i < x.length ; ++i)
            for(int j = 0 ; j < x.length ; ++j)
                if(x[i] == y[i]) {
                    x[i] = 0;
                    break;
                }

    }

    //                                                                          QUESTION 2

    // given a sorted array of integers in ascending order , ∀ i < j , array[i] < array[j]
    // we need to check if there exists three elements that their values are a pythagorean triple , a^2 + b^2 = c^2
    // if found , return true otherwise return false
    // Limitations : solution must be efficient as possible (given hint: time complexity is O(n^2))

    // we'll move with two pointers a,b and compare their sum to the value at c

    // time complexity is O(n^2) iterating through the array ~ n^2 times using the for loop with a nested while loop 
    // space complexity is O(1) instantiating varibales

    public static boolean isPythagorean(int[] arr) {
        int arrLength = arr.length;
        // in case the array is invalid 
        if(arrLength <3)
            return false;
  
        for(int i = 0 ; i < arrLength ; ++i)
            arr[i] = arr[i] * arr[i];
        
        int b = 0;
        int a = 0;

        for(int c = arrLength - 1 ; c > 1 ; --c ) {
            b = c - 1;
            a = 0;
            while(a<b) {
                if(arr[a] + arr[b] == arr[c])
                    return true;
                // since the array is sorted already , if the sum is smaller than arr[c] we will increment index a if the opposite is true , decrement b
                if(arr[a] + arr[b] < arr[c]) {
                    a++;
                }else if(arr[a] + arr[b] > arr[c]) {
                    b--;
                }
            }// end of while loop
            
        }// end of for loop 

        return false;
    }

    // 11/6/22 revisiting this question - solution is almost the same 

    //                                                                          QUESTION 3





    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 87 sheelon 465 2017 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 62 sheelon 477 2021 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    //                                                                          QUESTION 1

    // given an array of integers , write a method that splits the array into two arrays with the same sum and length
    // return true if we can split the array else false
    // Limitations : must solve recursively , cannot changed the array (even if it's temporary) , can't use another array to solve it
    // given : we can assume the array isn't empty or null

    // right away , if the length of the array is odd we can return false
    // lets try to sum the array , and then use brute force to check if there's a possibility to split the array 
    public static boolean equalSplit(int[] arr) {
        int arrLength = arr.length;
        // check if array is valid
        if(arrLength % 2 == 1)
            return false;

        int sum = sumArr2(arr, 0, arrLength);

        return equalSplit(arr, sum, 0, arrLength/2, 0, arrLength);
    }

    private static boolean equalSplit(int[] arr, int sum, int secondSum, int splitLength, int index, int maxIndex) {
        if(index >= maxIndex)
            return false;
        // first check if we're at the needed length, then check if the sum is equal
        if(splitLength == 0) {
            if(sum == secondSum)
                return true;
            else
                return false;
        }

        // check both cases, picking the elements value or skipping to the next , and repeating this process until we reach the end of the array
        return equalSplit(arr, sum - arr[index], secondSum + arr[index], splitLength - 1, index + 1, maxIndex) || 
                        equalSplit(arr, sum, secondSum, splitLength, index + 1, maxIndex);
    }
    // simply sum the array at the start
    private static int sumArr2(int[] arr , int index, int maxIndex) {
        if(index < maxIndex)
            return arr[index] + sumArr2(arr, index + 1, maxIndex);
        else
            return 0;
    }

    // 11/6/22 revisiting this question - almost the same 

    public static boolean equalSplitRE(int[] arr) {
        if(arr.length % 2 == 1) // can't split the array into even halves if the length is odd
            return false;

        int totalSum = totalArrSum(arr, 0, 0);
        return equalSplitRE(arr, 0, 0, totalSum, arr.length/2);
    }
    
    private static boolean equalSplitRE(int[] arr, int i, int currentSum, int totalSum, int numOfElements) {

        if(i >= arr.length || numOfElements < 0)
            return false;

        if(currentSum*2 == totalSum && numOfElements == 0) // multiplying by 2 instead of dividing by 2 as we can lose precision and count incorrect cases as true
            return true;                                   
        // two options , pick current value or skip 
        return equalSplitRE(arr, i + 1, currentSum, totalSum, numOfElements) || equalSplitRE(arr, i + 1, currentSum + arr[i], totalSum, numOfElements - 1);
    }
    // method to get the sum of the array
    private static int totalArrSum(int[] arr, int i, int sum) {
        if(i == arr.length)
            return sum;
        
        return totalArrSum(arr, i + 1, sum + arr[i]);
    }

    //                                                                          QUESTION 2

    // we're given a 2 dimensional array of size nxn (n is a positive exponent of 2) that is circular sorted meaning , every quadrant and sub quadrant 
    // is sorted in a way that arr[i][j] < arr[i][j + 1] < arr[i + 1][j + 1] < arr[i + 1][j - 1] 
    // and if the quadrant is made up of 4 sub quadrants then the 4th quadtant in the 1st sub-quadrant needs to be smaller than the 1st quadrant 
    // in the 2nd sub-quadtant and so on 
    // we need to find a value in the matrix , if found return true and print the elements position else return false
    // given : the array isn't null and is circular rotated , don't need to check that
    // Limitations : solution needs to be efficient as possible 

    // we basically need to use a "square" it will start at   [0][0]  --------- [0][arr.length]
    //                                                         |                            | 
    //                                                         |                            | 
    //                                                         |                            | 
    //                                              [arr.length][0] --------- [arr.length][arr.length]
    // we'll then use indices j,k and divide the length by 2 for every time we go inside another sub quadrant, 
    // we make sure to stay in the bounds of the quadrant we're in and future quadrants by keeping indicis j,k updated on the new position 


    // time complexity I think it is O(log(n)) since the growth of the matrix is exponential yet we have linear amount of operations in the for loop 
    // space complexity is O(1) only instantiating variables

    public static boolean search(int[][] mat, int num) {
        int matLength = mat.length;
        // in case length is just 1
        if(matLength == 1) {
            if(mat[0][0] == num) {
                System.out.println("row = 0 \n col = 0");
                return true;
            }else
                return false;
        }


        int minimumSize = 2; // 

        int j = 0; // row
        int k = 0; // col
        for( ; minimumSize <= matLength ; ) { // search in the matrix until we get to a 2x2 matrix
            // need to resize matLength to count the length from the first element we check until the end every time we close in on the quadrants
            // we divide the length by 2 each time so we stay in the quadrant we're in and keep going deeper 
            if(num < mat[j][k] || num > mat[j + matLength - 1][k])  
                return false;

            matLength = matLength/2; // update the length to the length of the quadrant we're in

            if(num < mat[j][matLength]) {
                // starting point would be the 1st quadrant
                // don't do anything , just divide the length by 2 again 
            }else if(num <  mat[matLength][matLength]) {
                // our starting point would be the 2nd quadrant
                k += matLength;
            }else if(num < mat[matLength][k]) {
                // starting point will be 3rd quadrant
                k += matLength;                           
                j += matLength;
            }else {
                //starting point will be the 4th quadrant
                j += matLength;
            } 
        }

        if(num == mat[j][k]) {
            System.out.println("row = " + j + "\n" + "col = " + k);
            return true;
        }
        if(num == mat[j][k+1]) {
            System.out.println("row = " + j + "\n" + "col = " + (k + 1));
            return true;
        }
        if(num == mat[j+1][k]) {
            System.out.println("row = " + (j + 1) + "\n" + "col = " + k);
            return true;
        }
        if(num == mat[j+1][k+1]) {
            System.out.println("row = " + (j + 1) + "\n" + "col = " + (k + 1));
            return true;
        }

        return false;
    }

    // 11/6/22 revisiting this question 

    // same time and space complexity as the other solution 
    public static boolean searchRE(int[][] mat, int num) {
        // we're told the size of 'mat' is a power of 2 and 'mat' is a square matrix 
        // we'll call the range between the values of the first and fourth elements an interval 
        int row = mat.length;
        if(num < 0 || num > mat[row - 1][0]) // in case the value 'num' is out of range (value-wise)
            return false;

        int jump = row/2; // we move the indices by jump , which we divide by 2 for every jump into another quarter 
        // two 'pointers' min and max , min points to the first sub-quarant on each cycle and max points to the fourth on each cycle
        // each time we close in on the intervals of values 'num' can be between we move min and max accordingly 
        // so we start at the first quadrant again and repeat the process while updating jump as well so we don't go out of bounds (bounds on the quadrant)
        int minI = 0;
        int minJ = 0;
        int maxI = row/2 - 1;
        int maxJ = 0;

        // if we can find 'num' then we will repeat the process row/2 times , each time closing in on a tighter interval 
        // we update the values of the two points to the location of the next interval each time 
        // so we move through quadrants 1 -> 2 -> -3 -> 4 , in case 'num' doesn't fit into the intervals we return false
        while(jump != 0) { 
            System.out.println(" jump : " + jump + "  min: ["+minI+ ","+minJ+"]  max: ["+maxI + "," + maxJ + "]");
            // check first quarter 
            if(mat[minI][minJ] <= num && mat[maxI][maxJ] >= num) {
                jump = jump/2;
                continue;
            }
            // check second quarter
            minJ += jump;
            maxJ += jump;
            if(mat[minI][minJ] <= num && mat[maxI][maxJ] >= num) {
                jump = jump/2;
                continue;
            }
            // check third quarter
            minI += jump;
            maxI += jump;
            if(mat[minI][minJ] <= num && mat[maxI][maxJ] >= num) {
                jump = jump/2;
                continue;
            }
            // check fourth quarter
            minJ -= jump;
            maxJ -= jump;
            if(mat[minI][minJ] <= num && mat[maxI][maxJ] >= num) {
                jump = jump/2;
                continue;
            }
            // in case we close in on the intervals but there were gaps between the intervals which 'num' could fit in to 
            return false;

        } // end of while 
        
        if(num == mat[minI][minJ]) {
            System.out.println("row = " + minI + "\n" + "col = " + minJ);
            return true;
        }
        if(num == mat[maxI][maxJ]) {
            System.out.println("row = " + maxI + "\n" + "col = " + maxJ);
            return true;
        }
        if(num == mat[minI][minJ+1]) {
            System.out.println("row = " + minI + "\n" + "col = " + (minJ+1));
            return true;
        }
        if(num == mat[maxI][maxJ+1]) {
            System.out.println("row = " + maxI + "\n" + "col = " + (maxJ+1));
            return true;
        }

        return false;
    }

    //                                                                          QUESTION 3






    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 62 sheelon 477 2021 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 96 sheelon 475 2020 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    //                                                                          QUESTION 1

    // we're given a two dimensional array of size nxm of positive integers 
    // we define a knight-path as follows
    //      start at the element [0][0]
    //      finish the path at [arr.length - 1][arr[0].length - 1]
    //      the knight has the abillity to move in 8 diretions (if they're valid) just as if it was a chess game
    //      the knight can only move to another element if the difference between the values of the two elements is <=1
    //      the knight cannot visit the same element twice
    // return the highest possible sum of values in a valid knight path , if there's no possible knight path , return -1
    // Limitations : need to solve this recursively, we can change the given matrix but at the end of the method we need to return it to its original state
    // that means we can either choose to use a boolean matrix or we can multiply the elements value by -1 to mark it as visited and just multiply again later


    // for the moves , we can first check 4 lines to see if the moves are possible at all and only then check if the move is valid 
    
    public static int maxSumKnight(int[][] mat) {
        return  maxSumKnight(mat, 0, 0, mat.length, mat[0].length , 0);
    }

    private static int maxSumKnight(int[][] arr, int i, int j, int maxRow, int maxCol , int sum) {
        int maxSum = -1;
        int tempSum = -1;
        // we only return the sum if we reach the end of the matrix , otherwise it will return maxSum 
        if(i == maxRow -1 && j == maxCol - 1) {
            return arr[i][j] + sum;
        }
            
        // start counter clockwise 
        // check all the possible moves, if the knight can move in some direction we check that direction and also if there's another possible direction 
        // multiply by -1 to indicate we already visited that cell , using method isValid2 to avoid repetetive code 
        if(isValid2(arr, i, j,i - 1 , j + 2, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) ,maxSumKnight(arr, i - 1, j + 2, maxRow, maxCol ,sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;

        }
        if(isValid2(arr, i, j,i - 2 , j + 1, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) ,maxSumKnight(arr, i - 2 , j + 1, maxRow, maxCol ,sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }
        if(isValid2(arr, i, j, i - 2 , j - 1, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) ,maxSumKnight(arr,i - 2 , j - 1, maxRow, maxCol ,sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }
        if(isValid2(arr, i, j, i - 1 , j - 2, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) ,maxSumKnight(arr, i - 1 , j - 2, maxRow, maxCol ,sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }   
        if(isValid2(arr, i, j, i + 1 , j - 2, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) ,maxSumKnight(arr, i + 1 , j - 2, maxRow, maxCol ,sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }
        if(isValid2(arr, i, j, i + 2 , j - 1, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) , maxSumKnight(arr, i + 2 , j - 1, maxRow, maxCol ,sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }
        if(isValid2(arr, i, j, i + 2 , j + 1, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) , maxSumKnight(arr, i + 2 , j + 1, maxRow, maxCol ,sum - arr[i][j]));
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }
        if(isValid2(arr, i, j, i + 1 , j + 2, maxRow, maxCol)) {
            arr[i][j] *= -1;
            tempSum = Math.max(maxSumKnight(arr, i, j, maxRow, maxCol ,sum) ,maxSumKnight(arr, i + 1 , j + 2, maxRow, maxCol , sum - arr[i][j]) );
            arr[i][j] *= -1;
            if(tempSum > maxSum)
                maxSum = tempSum;
        }

        return maxSum;

    }
    // check if the move is valid 
    private static boolean isValid2(int[][] arr,int fromI, int fromJ ,int i, int j,int maxRow, int maxCol) {
        if(i < maxRow && j < maxCol && i >= 0 && j >= 0 && arr[i][j] > 0 && Math.abs(arr[i][j] - arr[fromI][fromJ]) <= 1) {
            return true;
        }
        else 
            return false;
    }

    // 11/6/10 revisiting this question - similar, not doing two recursive calls with every move

    public static int maxSumKnightRE(int[][] mat) {
        int max = maxSumKnightRE(mat, 0, 0, 0);
        return (max == 0) ? -1 : max;
    }

    private static int maxSumKnightRE(int[][] mat, int i, int j, int sum) {

        int tempMax = 0;
        int max = 0;

        if(i == mat.length - 1 && j == mat[0].length - 1)
            return sum + mat[i][j];
        // 8 possible moves, validate each move and multiply the current element by -1 to mark it as visited temporarily
        // use tempMax and max to check which path sum is higher between all possible moves
        if(isValidMove(i , j, i + 2, j + 1, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i + 2, j + 1, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i + 2, j - 1, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i + 2, j - 1, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i - 2, j + 1, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i - 2, j + 1, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i - 2, j - 1, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i - 2, j - 1, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i + 1, j + 2, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i + 1, j + 2, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i - 1, j + 2, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i - 1, j + 2, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i + 1, j - 2, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat, i + 1, j - 2, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }
        if(isValidMove(i , j, i - 1, j - 2, mat)) {
            mat[i][j] *= -1;
            tempMax = maxSumKnightRE(mat,i - 1, j - 2, sum - mat[i][j]);
            if(max < tempMax)
                max = tempMax;
            mat[i][j] *= -1;
        }

        return max;

    }
    // validate indices , next move, difference and if not visited
    private static boolean isValidMove(int i, int j, int nextI, int nextJ , int[][] mat) {
        return (nextI >= 0 && nextI < mat.length && nextJ >= 0 && nextJ < mat[0].length && mat[nextI][nextJ] > 0 && Math.abs(mat[nextI][nextJ] - mat[i][j]) == 1);
    }

    //                                                                          QUESTION 2


    // 21/4/22 looks annoying , need to solve at another time 


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 96 sheelon 475 2020 b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 67 sheelon 473 2022 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    //                                                                          QUESTION 1

    // a.

    // we're given a square matrix of integers an integer x and a size parameter named size
    // we need to write a boolean method that checks if there's a sub identity matrix in the given matrix that starts at [x][x] and is of size "size"
    // given : we can assume parameters x and size are valid and the matrix isn't null don't need to check that
    // Limitations : need to solve it recusively , cannot change the values of the elements at all , cannot use other arrays 

    public static boolean isIdentity(int[][] mat, int x, int size) {
        // in case the size is 1 
        if(size == 1)
            if(mat[x][x] == 1)
                return true;
            else
                return false;

        int matrixBoundry = x + size - 1;
        return isIdentity(mat, x, x, matrixBoundry);
    }
    
    private static boolean isIdentity(int[][] arr, int i, int j, int matrixBoundry) {
        if(i == matrixBoundry && j == matrixBoundry && arr[i][j] == 1 ) {
            return true;
        }
        // check that the diagonal is made of 1's and all other elements are 0
        if(arr[i][j] != 1 || !upperTriangle(arr, i, j + 1, matrixBoundry) || !lowerTriangle(arr, i + 1, j, matrixBoundry))
            return false;
        else
            return isIdentity(arr, i + 1, j + 1, matrixBoundry);
        
    }
    // here we make sure every other element besides the diagonal has a value of 0
    private static boolean upperTriangle(int[][] arr, int i, int j, int matrixBoundry) {
        if(j > matrixBoundry)
            return true;
        else {
            if(arr[i][j] == 0)
                return upperTriangle(arr, i, j + 1, matrixBoundry);
            else
                return false;
        }
        
    }
    // here we make sure every other element besides the diagonal has a value of 0
    private static boolean lowerTriangle(int[][] arr, int i, int j, int matrixBoundry) {
        if(i > matrixBoundry)
            return true;
        else {
            if(arr[i][j] == 0)
                return lowerTriangle(arr, i + 1, j, matrixBoundry);
            else
                return false;
    }
    
    }

    // b.

    // we're given a square matrix of integers (the size of the matrix is ODD) 
    // we need to write a method that returns the size of the largest centered sub identity matrix that can be found in the given matrix
    // given : the size of the matrix is ODD and we can use the previous method isIdentity and the matrix isn't null don't need to check that
    // Limitations : need to solve it recusively , cannot change the values of the elements at all , cannot use other arrays 

    public static int maxMatrix(int[][] mat) {
        // we start at the center and work our way upwards on the diagonal while increasing the size of the sub matrix 
        int startIndex = mat.length/2;
        if(mat[startIndex][startIndex] != 1)
            return 0;
        
        return maxMatrix(mat, startIndex, 1, 1, mat.length);
    }
    // bad choice of naming , doesn't matter for now 
    // use tempSize to remember the last valid size and maxSize to check for the next bigger size 
    private static int maxMatrix(int[][] arr, int startIndex, int maxSize, int tempSize, int matrixBoundry) {
        // check if the current size is valid and check if the next size is valid 
        if(isIdentity(arr, startIndex, maxSize)) {
            tempSize = maxSize;
            if(startIndex - 1 >= 0 && startIndex - 1 + maxSize + 2 < matrixBoundry)
                return maxMatrix(arr, startIndex - 1, maxSize + 2, tempSize, matrixBoundry);
            else
                return tempSize;    // next size is invalid , return the current size
        }else
            return tempSize; 
            
    }

    // 13/6/22 revisiting this question 

    // a.

    public static boolean isIdentityRE(int[][] mat, int x, int size) {
        int n  = mat.length;

        if(n == 1) // edge case
            return mat[0][0] == 1;

        return isIdentityRE(mat, x, x, x + size, x + size);
    }
    // we validate the matrix by checking the columns of every row of the target matrix recursively
    private static boolean isIdentityRE(int[][] mat, int i, int j, int maxRow, int maxCol) {

        if(i == maxRow)
            return true;

        if(!moveInCol(mat, i, j, 1, maxCol)) // validate row
            return false;
        else
            return isIdentityRE(mat, i + 1, j, maxRow, maxCol); // move to the next row

    }

    // move on the row recursively until we reach the stop condition or we find an invalid value 
    // (either the diag cell's value != 1 or one of the other cells != 0)
    private static boolean moveInRow(int[][] mat, int i, int j, int move, int maxRow) {

        if(i == maxRow)
            return true;
        // validate value
        if(i == j) {
            if(mat[i][j] != 1)
                return false;
        }else if(mat[i][j] != 0)
            return false;   
        
        return moveInRow(mat, i + move, j, move, maxRow); // move to the next element
    }
    // move on the col recursively until we reach the stop condition or we find an invalid value 
    // (either the diag cell's value != 1 or one of the other cells != 0)
    private static boolean moveInCol(int[][] mat, int i, int j, int move, int maxCol) {

        if(j == maxCol)
            return true;
        // validate value
        if(i == j) {
            if(mat[i][j] != 1)
                return false;
        }else if(mat[i][j] != 0)
            return false;

        return moveInCol(mat, i, j + move, move, maxCol); // move to the next element
    }

    // b.

    public static int maxMatrixRE(int[][] mat) {

        int n  = mat.length;

        if(n == 1)  // in case the matrix is of size 1 
            return (mat[0][0] == 1) ? 1 : 0;
        
        int x = n/2;

        if(mat[x][x] != 1) // in case the center of the matrix is invalid from the start 
            return 0;

        return 1 + maxMatrixRE(mat, x - 1, x + 2); // add 1 to account for the center and start checking for a matrix of size 3x3
    }

    // method to check the size of the biggest valid centered sub matrix
    // we start at the center and expand outwards while checking one bigger "layer" each time
    // layer := the first and last columns and rows of a matrix bigger than the current one (n+1)*(n+1)
    private static int maxMatrixRE(int[][] mat, int x, int boundry) {

        // 5 stop conditions, 4 conditions to check if the "outer layer" is valid and last one is to check if x is negative , which means the whole array itself is valid
        if(x < 0 || !moveInCol(mat, x, x, 1, boundry) || !moveInRow(mat, x, x, 1, boundry) || !moveInRow(mat, x, boundry - 1, 1, boundry)
                            || !moveInCol(mat, boundry - 1, x, 1, boundry))
            return 0;
        // add 2 for the increased size, call the method again and check if the bigger layer is valid as well 
        return 2 + maxMatrixRE(mat, x - 1, boundry + 1);
    }




    //                                                                          QUESTION 2

    // we're given an array of size >= 3 , the array is sorted in ascending order and is made up from values of a certain arithmetic sequence 
    // a_(n+1) - a_n = d 
    // there may or may not be a missing element from the sequence in the array , there can be more than one missing element
    // write a method that returns the index of the first missing element , if there's no missing element return arr.length
    // given : we can assume the array isn't null or empty and is made up from a single arithmetic sequence
    // Limitations : solution needs to be efficient as possible 


    // we can count the length of the array , get the parameter d , if arr[0] + d*(arr.length - 2) = arr[arr.length - 1] the array is valid
    // else , we're missing elements, then we can use some sort of binary search to determine each time if the missing index is on the right or left
    // using the same method we did at the start only that the start would be the middle of the index

    // time complexity is O(log(n)) , using binary search 
    // space complexity is O(1) , only instantiating variables 

    public static int findMissingIndex(int[] a) {
        // assuming the difference will be given in the first 3 elements otherwise the time complexity would be O(n) 
        // look for the difference , the diff is the smallest diff between two congruent elements 
        int diff = (a[1] - a[0] > a[2] - a[1]) ? a[2] - a[1] : a[1] - a[0];
        int aLength = a.length;
        // if the array isn't missing any elements
        if( ( a[0] + (diff * (aLength - 2) ) )== a[aLength-1] )
            return aLength;

        int low = 0;
        int high = aLength - 1;
        int mid = aLength/2;

        while(low <= high) {
            
            mid = low + (high - low)/2;
            
            if( mid >= low && !( (a[low] + diff*(mid - low ) ) == a[mid]) ) 
                high = mid - 1;
            else if( mid <= high && !( (a[mid] + diff*(high - mid) ) == a[high]))
                low = mid + 1;
            else
                return high + 1; // we return high + 1 since if we get to this else statement it means the elements from low to high are in order
                
        }
        
        return 0; // returning a dummy value 
    }

    // 13/6/22 revisiting this question

    public static int findMissingIndexRE(int[] a) {

        int n = a.length;
        // since a sequential sequence can be missing , we only need to check the difference between the first and last two elements 
        int d = a[n-1] - a[n-2];
        if(a[1] - a[0] < d)
            d = a[1] - a[0];
        
        int low = 0;
        int high = n - 1;
        int mid = 0;
        // check if the there's at least one missing element , if not, return the length of the array 
        if(a[low] + high*d == a[high])
            return n;
        // binary search , we calculate what should be the value of a[mid] if we start at a[low] and compare the value with a[mid]
        while(low < mid) {

            mid = low + (high-low)/2;

            if((a[low] + (mid - low)*d) < a[mid])
                high = mid - 1;
            else 
                low = mid + 1;
        }

        return mid + 1;
    }


    //                                                                          QUESTION 3





    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 67 sheelon 473 2022 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 91 sheelon 483 2018 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a one dimensional array with positive integers , we need to use two operations , move i+1 and add that value to the sum
    // or skip the upcoming element and move to i+2 , if we reach the element before the last we cannot skip and have to move to the last element
    // we need to find the minimum sum to reach the end of the array from the start 
    // Limitations : need to solve it recursively
    // we can safely assume the array has valid values


    public static int cheapestRoute(int[] stations) {
        return cheapestRoute(stations, 0, stations.length - 1);
    }

    private static int cheapestRoute(int[] stations, int i, int lastStation) {
        // reaching end of array 
        if(i == lastStation)
            return stations[lastStation];
        if(i + 1 == lastStation) { // reaching element before last
            return stations[i] + stations[lastStation];
        }
        // at every element we check minimum of both choices , either moving to the next element or skipping it 
        return Math.min(stations[i] + cheapestRoute(stations, i + 1, lastStation) , stations[i] + cheapestRoute(stations, i + 2, lastStation));

    }

    // 15/6/22 revisiting this question - dp solution

    public static int cheapestRouteRE(int[] stations) {
        // in case the length <= 2 
        if(stations.length == 1)
            return stations[0];
        if(stations.length == 2)
            return stations[0] + stations[1];
        // create and instantiate the array 
        int[] dp = new int[stations.length];
        dp[0] = stations[0];
        dp[1] = stations[0] + stations[1];
        // we start from index 2
        return cheapestRoute(stations, dp ,2);
    }

    private static int cheapestRoute(int[] stations, int[] dp, int i) {
        // get the minimum cost up until station i 
        dp[i] = stations[i] + Math.min(dp[i - 1] , dp[i - 2]);

        if(i == stations.length - 1) // reaching the end of the array 
            return dp[i];

        return cheapestRoute(stations, dp, i + 1);
    }

    //                                                                          QUESTION 2

    // given an array of size n with natural numbers we need to sort the array by modulo k in ascending order
    // Limitations :  cannout use any other data structure or even k unique variables to solve this question , solution must be efficient as possible

    // since we cannot use any data structure the only way I can see is O(n^2) time complexity approach
    // we can't use arrays variables or linked lists , a stack is not mentiond , maybe we can use it ?
    public static void sortMod(int[] a, int k) {
        // first change the values to k modulo 
        for(int i = 0; i < a.length ; ++i) {
            a[i] = a[i]%k;
        }
        // now we need to sort 


        return;
    }

    // 15/6/22 revisiting this question - seems like we only need to do a simple quickSort with modulo K in mind

    // time complexity O(nlogn) - using quicksort with a slight change in method partition(comparing values with modulo k)
    // space complexity O(1) - only instantiating variables (excluding memory used by recusive calls)
    public static void sortModRE(int[] a, int k) {
        sortMod(a, 0, a.length - 1, k);
    }
    // quicksort
    private static void sortMod(int[] arr, int low, int high, int k) {

        if(low < high) {
            // find the pivot index and start the partitioning and sorting 
            int pivot = partition(arr, low, high, k);

            sortMod(arr, low, pivot - 1, k);
            sortMod(arr, pivot + 1, high, k);

        }

    }
    // almost the same as the method in the regular quicksort 
    // we compare values in modulo k but we don't change the values of the given array 
    private static int partition(int[] arr, int low, int high , int k) {

        int pivot = arr[high]%k;

        int i = low - 1;
        int temp;

        for(int j = low ; j <= high ; ++j) {

            if(arr[j]%k < pivot) { // swap elements

                ++i;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        } // place pivot element at it's corrent position and return the pivot index 
        ++i;    
        temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }



    // 21/4/22
    // !#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!# NEED TO DO 2022 TESTS , THEY SEEM GOOD !#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#
    // !#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!# https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/ THIS WAS ON ONE OF THE TESTS
    // https://www.geeksforgeeks.org/duplicates-in-an-array-in-on-time-and-by-using-o1-extra-space-set-3/?ref=lbp


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 91 sheelon 483 2018 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 87 sheelon 481 2016 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we're given a one dimensional array of non negative integers , we need to split the array into two sequences such that 
    // the difference in their sum is the minimum (in absolute value) and return it 
    // Limitations : need to solve it recursively , cannot change the array at all

    // we'll go with the brute force way again , sum up the array , return two options one that takes the current element and another that skips the current element
    // another option to try, sum the array divide by 2 and try to get as close as we can get to the divided sum using the brute force approach , might get a little messy
    // because of the downcast from double to integer 

    public static int minDiff(int[] arr) {
        int sum = sumArray2(arr, 0, arr.length);
        return minDiff(arr, 0, arr.length, sum, 0, sum);
    }

    private static int minDiff(int[] arr, int index, int maxIndex, int firstSum, int secondSum, int minimumDiff) {
        if(index >= maxIndex) // reaching the end of the array 
            return minimumDiff;
        
        int tempDiff = Math.abs(firstSum - arr[index] - ( secondSum + arr[index]));
        // either pick the element or don't
        return Math.min(minDiff(arr,index+1,maxIndex,firstSum,secondSum,minimumDiff),minDiff(arr,index+1,maxIndex,firstSum-arr[index],secondSum+arr[index],tempDiff));
    }
    // sum the array 
    private static int sumArray2(int[] arr, int index, int maxIndex) {
        if(index >= maxIndex)
            return 0;
        else
            return arr[index] + sumArray2(arr, index + 1, maxIndex);
    }

    // 13/6/22 revisiting this question

    public static int minDiffRE(int[] arr) {
        return minDiff(arr, 0, 0, sumArrDiff(arr, 0, arr.length));
    }

    private static int minDiff(int[] arr, int i, int groupOne, int groupTwo) {

        if(i >= arr.length)
            return Math.abs(groupOne - groupTwo);
        
        return Math.min(minDiff(arr, i + 1, groupOne, groupTwo),minDiff(arr, i + 1, groupOne + arr[i], groupTwo - arr[i]));
    }

    private static int sumArrDiff(int[] arr, int i, int maxIndex) {
        if(i == maxIndex)
            return 0;

        return arr[i] + sumArrDiff(arr, i + 1, maxIndex);
    }

    //                                                                          QUESTION 2

    // we're given a one dimensional array of 0's and 1's
    // 0 will represent an object that moves to the east ->, 1 will represent an object that moves to the west <-
    // a pair intersects if i = 1 j = 0 and j < i
    // count the pairs that interset and return the count
    // Limitations :  need to be efficient as possible 

    // if we start from the end of the array , keep a variable that counts the appearance of 1's and add that updated amount every time we encounter a 0
    // this would be time complexity O(n), can't see a better way to reduce time complexity 

    // time complexity is O(n) , interating through the array once 
    // space complexity O(1) , instantiating variables
    public static int passingCars(int[] a) {
        //int index = a.length - 1;
        int countOnes = 0;
        int totalPairs = 0;

        for(int i = (a.length - 1) ; i >= 0 ; --i ) {
            if(a[i] == 1)
                ++countOnes;
            else
                totalPairs += countOnes;
        }
        return totalPairs;
    }

    //                                                                          QUESTION 3



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 87 sheelon 481 2016 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 92 sheelon 481 2016 2b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a two dimensional array of characters of size NxX such that one element is set as 'K' , another as 'H' and all other elements are set as '0'
    // we're given the position of the knight ('H') and need to find the minimum steps it takes to reach the king ('K')
    // while using knight steps only 
    // given : we can assume the given array is valid and instantiated as we're told 
    //         we can assume knight ('H') and king ('K') are set on different positions
    //         we can change the given array but after calling the method it needs to return to its original state 
    // Limitations : must solve with recursion only

    // we can use simply brute force which will get ~23 points 
    // if we add a tiny bit of optimization we'll get the full 25 points 

    // BFS - not sure if we can use it , this solution only uses the tools we learned in the course so I don't see a reason why they wouldn't allow it 

    // time complexity O(n^2)
    // space complexity - at least O(n^2) , the stack overhead from the recursive calls is pretty big , need to calculate it
    public static class IntNode2 {

        private int _x;
        private int _y;
        private int _moves;
        private IntNode2 _next;

        public IntNode2(int x, int y, int moves, IntNode2 n) {
            _x = x;
            _y = y;
            _moves = moves;
            _next = n;
        }

        public IntNode2 getValue() {
            IntNode2 temp = new IntNode2(this._x,this._y, this._moves, null);
            return temp;
        } 

        public int getX() {
            return _x;
        }

        public int getY() {
            return _y;
        }

        public IntNode2 getNext() {
            return _next;
        }

        public int getMoves() {
            return _moves;
        }

        public void setValue(int x, int y) {
            _x = x;
            _y = y;
        }

        public void setNext(IntNode2 n) {
            _next = n;
        }

    }

    public static class Queue2 {

        private IntNode2 _head;
        private IntNode2 _tail;

        public Queue2() {
            _head = null;
            _tail = null;
        }

        public boolean isEmpty() {
            return _head == null;
        }

        public void enqueue(int x, int y, int moves) {

            IntNode2 temp = new IntNode2(x, y, moves, null);
            if(_tail != null) 
                _tail.setNext(temp);
            _tail = temp;
            if(_head == null)
                _head = temp;
        }

        public IntNode2 deque() {
            IntNode2 temp = new IntNode2(_head.getX(),_head.getY(), _head.getMoves(), null);
            _head = _head.getNext();
            return temp;
        }
    }

    public static int minPath(char[][] minChess, int i, int j) {

        int[] knightPos = {i,j};
        int[] kingPos = {0,0};
        findKing(minChess, kingPos, 0, 0); // find position of the king in char[][] minChess and update the values of kingPos[]
        
        int[] xDir = {-1, -2, -2, -1, 1, 2, 2, 1}; // 8 possible moves 
        int[] yDir = {2, 1, -1, -2, -2, -1, 1, 2};
        boolean[][] visited = new boolean[minChess.length][minChess.length];

        visited[knightPos[0]][knightPos[1]] = true;     // set current position as true
        Queue2 queue = new Queue2();                      
        queue.enqueue(knightPos[0], knightPos[1], 0);   // add knight's position to the queue
        IntNode2 q = new IntNode2(0, 0, 0, null);         // for the BFS we set it as the first node of the queue which also dequeues that node from the queue
                                                        // then we do BFS from that node and add every connected node to the queue and repeat the process
        return minPath(kingPos, q, queue, xDir, yDir, visited);
        
    }
    // method to find the position of the king in the array and update array KingPos with the position 
    private static void findKing(char[][] minChess, int[] kingPos, int i, int j) {

        if(i >= minChess.length )
            return;

        if(i < minChess.length && j >= minChess.length)
            findKing(minChess, kingPos, i + 1, 0);
        else {
            if(minChess[i][j] == 'K') {
                kingPos[0] = i;
                kingPos[1] = j;
                return;
            }

            findKing(minChess, kingPos, i, j + 1);
        }
    }
    // we go over the options to get to kingPos from the current node's values using BFS with each iteration we expand further 
    private static int minPath(int[] kingPos, IntNode2 q, Queue2 queue, int[] xDir, int[] yDir, boolean[][] visited) {

        if(!queue.isEmpty()) {

            q = queue.deque();
            //System.out.println("x : " + q.getX() + " y : " + q.getY());
            if(q.getX() == kingPos[0] && q.getY() == kingPos[1])
                return q.getMoves();

            breadthFirstS(visited, q, xDir, yDir, queue, 0);

            return minPath(kingPos, q, queue, xDir, yDir, visited);
        }

        return -1;
    }
    // method to expand from the current node to all 8 possible solutions 
    private static void breadthFirstS(boolean[][] visited, IntNode2 q, int[] xDir, int[] yDir, Queue2 queue, int i) {

        if(i <= 7) {

            int x = q.getX() + xDir[i];
            int y = q.getY() + yDir[i];

            if(isValidChess(visited, x, y)) {
                visited[x][y] = true;
                queue.enqueue(x, y, q.getMoves() + 1);
            }

            breadthFirstS(visited, q, xDir, yDir, queue, i + 1);
        }

    }
    // simple method to validate the next node
    private static boolean isValidChess(boolean[][] visited, int i, int j) {
        return (i >= 0 && j >= 0 && i < visited.length && j < visited.length && !visited[i][j]);
    }


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 92 sheelon 481 2016 2b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 87 sheelon 490 2016 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we define ascending series as follows :  ∀ n ∈ ℕ ∃ a_n < a_(n+1)
    // write a method that receives a non negative integer as a parameter and returns the number of ascending series that their sum is equal to the parameter
    // the empty series is considered as ascending series with a sum of 0
    // Limitations : need to solve it recursively
    


    public static int count(int num) {
        return 1 + count(num, 1, 0); // we add 1 to count for the number by itself
    }
    // naive way , we either pick the number and add it to the sum or we skip the current number and move to the next , repeating this until we reach sum or > num
    private static int count(int num , int currentNumber, int sum) {
        if(currentNumber > num)
            return 0;
        if(sum == num) {
            return 1;
        }
        int pick = count(num, currentNumber + 1, sum + currentNumber);
        int skip = count(num, currentNumber + 1, sum);

        return (pick + skip);
            
    }

    // 15/6/22 revisiting this question 

    public static int countRE(int sum) {
        return countRE(sum, 0, 0);
    }

    private static int countRE(int sum, int i, int tempSum) {
        
        if(tempSum == sum)
            return 1;

        if(i > sum || tempSum > sum)
            return 0;
        
        return countRE(sum, i + 1, tempSum) + countRE(sum, i + 1, tempSum + i);
    }


    //                                                                          QUESTION 2

    // a.
    // given a string s , return the number of sub-strings that start with the letter c ,end in c and has the letter c only once between the other two c's
    // Limitations : need to be efficient as possible , can't use any other method from class String besides charAt() and length()

    // find the number of 'c' in the string which will be n and return n-2
    // we only need to find the first 2 appearances of c in the string and every other c that is found later counts as a valid string

    // time complexity is O(n) iterating through the array once
    // space complexity O(1)
    public static int subStrC(String s, char c) {
        int strLength = s.length();
        int count = 0;
        for(int i = 0; i < strLength ; ++i) {
            if(s.charAt(i) == c)
                count++;
        }
        count-=2;
        return (count>= 0) ? count : 0;
    }

    // b.
    // given a string s , char 'c' and a positive integer k 
    // return the number of sub-strings that start and end with 'c' and between the two ends has at most k times the letter 'c' 
    // Limitations : need to be efficient as possible , can't use any other method from class String besides charAt() and length()

    // we find the number of c's and we subtract 1 as that will be the start of the sub-string ,subtract again the number i <= k
    // i will increase by 1 every time until we reach k 
    // that will give us each time the amount of sub-strings (though process , we only need to count first c and the need c's between the ends
    // every other c besides that will be the ending c for each sub-string)

    // time complexity is O(n) iterating through the array once
    // space complexity O(1)
    public static int subStrMaxC(String s, char c, int k) {
        int strLength = s.length();
        int count = 0;
        for(int i = 0; i < strLength ; ++i) { // count the c letters in the string
            if(s.charAt(i) == c)
                count++;
        } // sum of natural numbers up to count-1 and subtract from that the sum of natural numbers up to count - k - 2 or count - k - 1
          // depending on the count and k 
        int totalSubStrings = ( ( (count-1)*(count) )/2 - ( (count - k - 2)*(count - k - 1) )/2 ); 
        return (totalSubStrings > 0) ? totalSubStrings : 0;
    }

    // 15/6/22 revisiting this question - older solution is almost the correct answer , it fails if counter - 2 <= k

    public static int subStrMaxCRE(String s, char c, int k) {

        int n = s.length();
        int counter = 0;

        for(int i = 0 ; i < n ; ++i) 
            if(s.charAt(i) == c)
                ++counter;
        // in case there's no valid sub string 
        if(counter <= 1)
            return 0;
        // in case the number of duplicates of c in the string is <= k , we simply return the sum of natural numbers up to (counter - 1)
        if(counter - 2 <= k)
            return ((counter - 1)*counter)/2;
        else // in case the number of duplicates of c in the string is > k (excluding opening and closing c) then we can't simply return the sum of natural numbers
            return ((counter - 1)*counter)/2 - ((counter - 2 - k)*(counter - 1 - k))/2;
             // as that will count non unique sub strings , therefore we need to subtract the sum of natural numbers up to (k-1) from the sum up to (counter - 1)
             // in order to discard sub strings that were counted >= 2

    }

    //                                                                          QUESTION 3






    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 87 sheelon 490 2016 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // 28/4/22 need to solve this and understand more about dp
    // https://leetcode.com/problems/coin-change/
    // https://www.youtube.com/watch?v=1mtvm2ubHCY&list=PLl0KD3g-oDOGJUdmhFk19LaPgrfmAGQfo&index=2 - errichto dp lesson 2 


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon 460 2015 4a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we're given a two dimensional array of size nxm with positive integers and need to return the number of ropes in the current matrix
    // we define a rope a series elements as follows :
    //  first element has to be in the first row , array[0][i]
    //  last element has to be in the last row , array[n-1][j]
    //  every other element has to be in a different row and every element has to be congruent to the one before it , that is 
    //  either right under the element or on one of the diagonals
    //  the values of the elements as we go from top to bottom have to strictly decrease
    // given : the matrix holds positive integers and we don't need to validate that
    // Limitations :  must solve recusrively , can change the given matrix temporarily but it has to return to its original state

    
    // naive way 
    public static int countRopes(int[][] mat) {
        return countRopes(mat, 0, 0, mat.length, mat[0].length, 0);
    }
    // currentRope is used as a temp holder to indicate where we are on the column in first row
    private static int countRopes(int[][] mat , int i, int j, int maxRow, int maxCol, int currentRope) {

        if(i < 0 || j < 0 || i >= maxRow || j >= maxCol)
            return 0;

        if(i == maxRow - 1) // when we reach the last row 
            return 1;

        int tempSum = 0;
        // the rope can move in three different directions 
        if(isValid3(mat, i, j, i + 1, j, maxRow, maxCol)) {
            tempSum += countRopes(mat, i + 1, j, maxRow, maxCol, currentRope);
        }
        if(isValid3(mat, i, j, i + 1, j - 1, maxRow, maxCol)) {
            tempSum += countRopes(mat, i + 1, j - 1, maxRow, maxCol, currentRope);
        }
        if(isValid3(mat, i, j, i + 1, j + 1, maxRow, maxCol)) {
            tempSum += countRopes(mat, i + 1, j + 1, maxRow, maxCol, currentRope);
        }
        // the recursive call with which we iterate over the first column in the first row 
        if(currentRope < maxCol)
            return tempSum + countRopes(mat, 0, currentRope + 1, maxRow, maxCol, currentRope + 1);
        else
            return 0;
    }
    // first make sure the index is valid and then make sure the move is valid 
    private static boolean isValid3(int[][] mat, int currentI, int currentJ, int i, int j, int maxRow, int maxCol) {
        if(i < 0 || j < 0 || i >= maxRow || j >= maxCol || mat[currentI][currentJ] <= mat[i][j])
            return false;
        else
            return true;
    }
    
    // more efficient way , we use the array to store the number of ropes that we found , if there's another rope that can use that path
    // we can simply return the number of paths found without repeating the recusive calls again 
    // we can avoid up to 2 repetetive calls at a time since a rope can only share at most 2 paths with a different rope
    public static int countRopesE(int[][] mat) {
        int[] dp = new int[mat[0].length];
        return countRopesE(mat, 0, 0, mat.length, mat[0].length, 0, dp);
    }
    // currentRope is used as a temp holder to indicate where we are on the column in first row
    private static int countRopesE(int[][] mat , int i, int j, int maxRow, int maxCol, int currentRope, int[] dp) {

        if(i < 0 || j < 0 || i >= maxRow || j >= maxCol)
            return 0;

        if(i == maxRow - 1) // when we reach the last row (end of the rope)
            return 1;

        int tempSum = 0;
        // the rope can move in three different directions 
        if(isValid3E(mat, i, j, i + 1, j, maxRow, maxCol)) { // for testing the example  && mat[i + 1][j] != 0 , without it we count invalid ropes
            if(i == 1 && dp[currentRope] != 0) // if we're at the second row and the current number of paths from that rope was calculated already 
                tempSum += dp[currentRope];    // we simply add the stored value and continue thus avoiding repetetive recursive calls 
            else
                tempSum += countRopesE(mat, i + 1, j, maxRow, maxCol, currentRope, dp);
        }
        if(isValid3E(mat, i, j, i + 1, j - 1, maxRow, maxCol)) {// for testing the example && mat[i + 1][j - 1] != 0 , without it we count invalid ropes
            if(i == 1 && dp[currentRope] != 0) // same explanation as above 
                tempSum += dp[currentRope];
            else
                tempSum += countRopesE(mat, i + 1, j - 1, maxRow, maxCol, currentRope, dp);
        }
        if(isValid3E(mat, i, j, i + 1, j + 1, maxRow, maxCol)) {// for testing the example && mat[i + 1][j + 1] != 0 , without it we count invalid ropes 
            if(i == 1 && dp[currentRope] != 0) // same explanation as above 
                tempSum += dp[currentRope];
            else
                tempSum += countRopesE(mat, i + 1, j + 1, maxRow, maxCol, currentRope, dp);
        }
        // the recursive call with which we iterate over the first column in the first row 
        if(currentRope < maxCol)
            return tempSum + countRopesE(mat, 0, currentRope + 1, maxRow, maxCol, currentRope + 1, dp);
        else
            return 0;
    }
    // first make sure the index is valid and then make sure the move is valid 
    private static boolean isValid3E(int[][] mat, int currentI, int currentJ, int i, int j, int maxRow, int maxCol) {
        if(i < 0 || j < 0 || i >= maxRow || j >= maxCol || mat[currentI][currentJ] <= mat[i][j])
            return false;
        else
            return true;
    }

    // 22/6/22 revisiting this question , using dp to solve it this time 

    public static int countRopesDP(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        if(row == 1) // in case we only have 1 row 
            return col;
        // using two arrays to avoid checking the same paths twice 
        int[] dp1 = new int[col];
        int[] dp2 = new int[col];
        initRope(dp2, 0, col);
        return countRopesDP(mat, dp1, dp2, row - 2, 0, row, col);
    }

    // imagine we're playing leapfrog with dp1 and dp2

    // bottom up approach , we start from a row before the last ,
    // at first dp2 is init with 1's every where, we check which cell above the last row is a valid path to the last cells
    // every time we have a valid connection we add the value of dp2[j] to dp1[j] 
    // so the first recusive call will simply check which node is a possible path for a rope , after checking the first row(row before last)
    // we only use that data to traverse through the array 'mat' so the next recusive call dp1 will be the dp2 before that call 
    // note that we reset dp1[j] at the start since it is dp2 from last call and it has values we don't need 
    // dp2 will contain the values of dp1 from the call before it which holds the values of the valid paths up to the nodes in that row
    // so to simplify , we use dp1 to check for end of ropes using dp2 that is init with 1's 
    // then we switch between the two after we check all the columns of the row , so we check for valid paths again , while dp2(dp1 from a call before)
    // holds the number of possible valid paths up to that point , so we validate the paths again and discard invalid paths on the way to the first row of 'mat'
    // so at the end we only go through the matrix 'mat' once , thus avoiding repetetive recursive calls  
    private static int countRopesDP(int[][] mat, int[] dp1, int[] dp2, int i, int j, int maxRow, int maxCol) {
        
        if(i == 0 && j >= maxCol) // return the sum of the array , since we checked every starting point of a possible rope
            return sumRopes(dp1, 0, maxCol);
        
        if(i > 0 && j >= maxCol) { // go to the row above , since we checked the whole current row
            return countRopesDP(mat, dp2, dp1, i - 1, 0, maxRow, maxCol); // switch between the dp arrays 
        }else {
            dp1[j] = 0; // first set to 0 since this is the dp2 from a recursive call before it so it has a value we don't need 
                        // then update dp1 with values of dp2 which is a dp1 from a recusive call from this one 
            if(j - 1 >= 0 && mat[i][j] > mat[i+1][j-1] && mat[i+1][j-1] > 0) {
                dp1[j] += dp2[j - 1];
            }
            if(j + 1 < maxCol && mat[i][j] > mat[i+1][j+1] && mat[i+1][j+1] > 0) {
                dp1[j] += dp2[j + 1];
            }
            if(mat[i][j] > mat[i+1][j] && mat[i+1][j] > 0) {
                dp1[j] += dp2[j];
            }
            
            return countRopesDP(mat, dp1, dp2, i, j + 1, maxRow, maxCol); // continue checking the row 
        }
            
    }
    // a simple recursive method to sum a given 1d array 
    private static int sumRopes(int[] dp, int i, int maxCol) {
        if(i == maxCol)
            return 0;
            System.out.print(" " + dp[i] + " ");
        return dp[i] + sumRopes(dp, i + 1, maxCol);
    }
    // method to initialize a 1d array with 1's 
    private static void initRope(int[] dp, int i, int maxCol) {
        if(i == maxCol)
            return;

        dp[i] = 1;
        initRope(dp, i + 1, maxCol);
    }



    //                                                                          QUESTION 2

    // array of unique integers ( 0 exlusive , Z/0) that is sorted in ascending order
    // we need to check if there are two indices i,j such that 
    //  i < j
    //  Σ[0,i] < 0 
    //  Σ[i+1,j] = 0
    //  Σ[j+1,arr.length - 1] > 0
    // if one of the requirements will result in outOfBoundsException we can assume it is vacuously true while all other requirements are true
    // if we found such i,j return true, otherwise false
    // Limitations : solution needs to be efficient as possible 

    // the naive way is probably time complexity of O(n) trying to use binary search would be a safe bet but since they use the word sum 
    // that means we need to sum somehow the values in the array so maybe the solution is O(n) and the first example reaffirms that 
    public static boolean splitTo3(int[] arr) {
        return true;
    }


    // 30/4/22 need to solve this question 

    // 22/6/22 revisiting this question 

    // time complexity O(n) - iterating over the array at most twice
    // space complexity O(1) - only instantiating variables
    public static boolean splitTo3RE(int[] arr) {

        int n = arr.length;
        int sum = 0;
        if(n == 1 || arr[n - 1] < 0 || arr[0] > 0) // when the size is 1 we return false , we don't have two different indices and can't have the value 0
            return false;                          // when the last element's value is negative that means we don't have any positive values
                                                   // therefore can't find a sub-array whose sum is 0, same goes if we only have positive values 

        // since the array is sorted in ascending order and doesn't include 0
        // the sub array with sum = 0 will be our center for scale 
        // if we can find such a sub-array the other requirements will be vacuously true

        // this question is basically a sliding window , only need to find a sub-array whose sum is 0
        // and since we can't have the value 0 , that means the sub-array will automatically be valid 

        for(int i = 0 ; i < n ; ++i) { // first sum the array 
            sum += arr[i];
        }

        int low = 0;
        int high = n - 1;

        while(low < high) { // sliding window 

            if(sum == 0)
                return true;

            if(sum < 0) {
                sum -= arr[low++];
            }else
                sum -= arr[high--];

        }

        return false;

    }

    //                                                                          QUESTION 3


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon 460 2015 4a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 91 sheelon 460 2015 2b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // some sort of a coin question, this time we're using sticks and adding their lengths to reach the target length , return the number of ways possible to do so 
    // notice that we need to return the number of combinations and not permutations ! 
    // parameters :
    //  k target length 
    //  array lengths , holds the length of each available stick
    //  num the limit of sticks we can use at the same time (we can use the same stick as many times as the limit num allows)
    // Limitations : need to solve it recursively 

    // naive/brute force 
    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths, k, num, 0, lengths.length);
    }

    private static int makeSum(int[] arr, int k, int stickLim, int i, int numOfSticks) {

        if(k == 0 && stickLim >= 0) // reaching the length within the sticks limit
            return 1;
        if(k < 0 || stickLim < 0) // if not valid anymore
            return 0;
        if(i >= numOfSticks ) // out of bound
            return 0;

        // two options, move to next item or pick up items with the option to pick it again  
        return makeSum(arr, k, stickLim, i + 1,numOfSticks) + makeSum(arr, k - arr[i], stickLim - 1, i,numOfSticks) ;
    }


    //                                                                          QUESTION 2

    // solution to this question is on line 5393                                                                    



    // 30/4/22 solve coin change 2 with dp \ memoization
    // https://www.youtube.com/watch?v=1mtvm2ubHCY&list=PLl0KD3g-oDOGJUdmhFk19LaPgrfmAGQfo&index=3 - errichto
    // https://www.geeksforgeeks.org/coin-change-dp-7/ - gfg for coin change if needed
    // if i have time , need to check if this is helpful
    // https://www.youtube.com/watch?v=dT6dvdbpChA


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 91 sheelon 460 2015 2b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 84 sheelon 467 2017 3a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // a person walks on the sidewalk and can only move to the right\left in one step , the person needs to get to a certain point n that is on his right 
    // given a steps\moves limitation k we need to find out how many ways there are for the person to walk to the destiny on the right with exactly k moves
    // return the number of unique paths
    // given : can assume the parameters are valid and k ≥ 0 , n ≥ 0
    // Limitations : must solve recursively

    // we can simply use an int type that will start at 0 and increment\decrement as needed and create a valid path to n with k steps
    // the "hard" part here is making sure the path is unique 
    // but this is a combinatorical problem 
    // from the examples we can see a pattern , if k-n is ODD the paths will be 0 as there's no way to make it in k steps ,
    /*
        | k - n | = m , m will be the remaining steps needed to make to get a valid path 
        so k-n right steps , that means we are at destination n and we have m steps to make (and we need 2 steps to return back to the same spot)
        if m is odd it mean we will have 1 extra step to make and therefore won't be able to create a valid path 
        if m is even we will be able to create a valid path 

        so we will have m/2 = l identical objects (left moves) and k cells\bins 
        so we'll  be using the partition formula (we only care about the ways we can put the l identical items in k cells since all the other
        cells will be with the other object (right move))
    */
    public static int ways(int k, int n) {
        int steps = Math.abs(k-n); 
        if(steps%2 == 1 || k < n)
            return 0;
        if(k == 0)
            return 1;
        
        int objects = countSteps(1, steps/2);
        int bins = countSteps(1, k - 1);
        int numerator = countSteps(1, k - 1 + steps/2);
        int denominator = objects*bins;
        return numerator/denominator;
    }

    private static int countSteps(int value, int multiply) {
        value *= multiply;
        multiply -=1;
        if(multiply == 0)
            return value;
        else
            return countSteps(value, multiply);
    }

    // 22/6/22 revisiting this question , older solution is wrong but on the right track
    // need to do nCk , (k the number of needed moves) C ((k-n)/2 the number of left moves)

    public static int waysRE(int k ,int n) {

        if(k == n)
            return 1;
        if(k < n || (n == 0 && k > 0) || (k - n)%2 == 1)
            return 0;

        // (k - n)/2 left moves to make , don't need to worry about parity since it must be even , else we return 0 at the start of the method

        int steps = factorial(k);
        int leftStep = factorial((k - n)/2)*factorial(k-(k - n)/2);
        return steps/leftStep;
    }

    private static int factorial(int i) {
        if(i <= 1)
            return 1;

        return i*factorial(i - 1);
    }
    
    //                                                                          QUESTION 2
    // given a one dimensional array of integers that is sorted in ascending order and is possibly rotated 
    // we need to check if there's a pair of elements such that their sum is equal a given value
    // return true if found otherwise false
    // Limitations : solution needs to be efficient as possible 

    // time complexity O(n) - going through the array at most twice
    // space complexity O(1) - only instantiating variables 
    public static boolean findSum(int[] a, int sum) {
        int i;
        int n = a.length;
        for(i = 0 ; i < n - 1 ; ++i) { // find pivot element, can use binary search to do it quicker
            if(a[i] > a[i + 1])
                break;
        }
        // use indices with modulo n 
        int low = (i + 1)%n;
        int high = i;
        // go through array looking for a valid pair 
        while(low != high) {

            if(a[low] + a[high] == sum)
                return true;

            if(a[low] + a[high] < sum)
                low = (low + 1)%n;
            else
                high = (high + n - 1)%n;

        }
        return false;
    }

    // repeating question 

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 84 sheelon 467 2017 3a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon 467 2017 4a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1  

    // we're given 3 coins of different denominations 1,5,7 and a positive integer n , we need to find the minimum coins needed to get to n 
    // given : can assume the parameter is valid and n ≥ 0
    // Limitations : must solve recursively , cannot use method from the class Math  

    // coin change problem only easier since we know the coins already 
    /*
    dp[0] = 0
    dp[1....n] = n+1
    for i 1....n
        for x : coins
            dp[i] = min(dp[i],dp[i-x]+1)
    return dp[n]
    */
    public static int oneFiveSeven(int n) {
        if(n == 0) 
            return 0;

        int[] dp = new int[n+1];
        dp[0] = 0;
        fillArr(dp, n+1, 1, n);
        int[] coins = {1,5,7};
        return oneFivenSeven(n, dp, coins, 1, 0,coins.length);
    }
    // simple method to instantiate the array with chosen values
    private static void fillArr(int[] dp, int defaultNum, int index, int lastIndex) {
        if(index > lastIndex)
            return;
        dp[index] = defaultNum;
        fillArr(dp, defaultNum, index+1, lastIndex);
    }

    private static int oneFivenSeven(int n, int[] dp, int[] coins, int index, int coin,int lastCoin) {
        if(index > n)
            return dp[n]; // at the end this will be return which is the minimum amount of coins needed , it will be return throughout the recursive calls
                            // all the way back to the first recusive call and returned to the calling method 
        // first check if the index is valid for both indices 
        if(coin < lastCoin && index >= coins[coin]) {
            dp[index] = (dp[index] > dp[index - coins[coin]] + 1) ? dp[index - coins[coin]] + 1 : dp[index]; // get minimum for current coin

            if(coin+1 < lastCoin && index >= coins[coin + 1]) // if we can check another coin 
                return oneFivenSeven(n, dp, coins, index, coin + 1,lastCoin);
        }
        
        return oneFivenSeven(n, dp, coins, index + 1, 0,lastCoin); // moving on with the next index
    }

    // 22/6/22 revisiting this question 

    public static int oneFiveSevenDP(int n) {
        if(n == 0)
            return 0;
        // create and init a dp array to help avoid repetetive recusive calls
        int[] dp = new int[n + 1];
        dp[0] = 0;
        initOneFiveSeven(dp, 1, n);
        return oneFivenSevenDP(dp, n, 1);
    }
    // initialize array starting from index 1 with n+1 value
    private static void initOneFiveSeven(int[] dp, int i, int n) {

        if(i == n + 1)
            return;

        dp[i] = n + 1;
        initOneFiveSeven(dp, i + 1, n);
    }
    // at each value we compare the options to reach it with the minimum amount of elements
    private static int oneFivenSevenDP(int[] dp, int n, int i) {
        // compare valid possibilities in order to get the minimum elements needed to reach the current value 
        dp[i] = min(i - 1, i - 5, i - 7, dp[i], dp);

        if(i == n)  // reaching the end of the array
            return dp[i];
        // repeat the process
        return oneFivenSevenDP(dp, n, i + 1);

    }
    // compare all possible valid paths
    private static int min(int a, int b, int c, int d, int[] dp) {
        int aVal = (a >= 0) ? dp[a] + 1 : dp.length;
        int bVal = (b >= 0) ? dp[b] + 1 : dp.length;
        int cVal = (c >= 0) ? dp[c] + 1 : dp.length;
        int temp = 0;
        // find min value 
        temp = (aVal < bVal) ? aVal : bVal;
        temp = (temp < cVal) ? temp : cVal;
        temp = (temp < d) ? temp : d;

        return temp;
    }

    //                                                                          QUESTION 2
    
    // we're given two sorted arrays of integers such that  ∀ i < j , array[i] ≤ array[j] and integer x
    // need to find two numbers a[i] , b[j] such that ∀ l,k  , a[l] + b[k] ≤ a[i] + b[j]  ≤ x  (and vice versa ) and print them 
    // we must have one element from each array 
    // Limitations : solution needs to be efficient as possible

    // time complexity is O(n) ,  iterating through the arrays at most once
    // space complexity is O(1)
    public static void printClosest(int[] a, int[] b, int x) {
        int lastIndexA = a.length;
        int indexA = 0;
        int indexB = b.length - 1;
        int e = Integer.MAX_VALUE; // comparison variable
        int chosenA = 0; // the needed index in a , this is only needed since the last while loop can change the index to something wrong
        int chosenB = 0; // the needed index in b , the same goes for this one 
        // treat both arrays as one using two "pointers" one for each array , and using the fact that theyre sorted
        while(indexA < lastIndexA && indexB >= 0) {
            if(Math.abs(a[indexA] + b[indexB] - x ) < e) { // in case we find a better pair sum , we update the new epsilon and indices
                e = Math.abs(a[indexA] + b[indexB] - x );
                chosenA = indexA; 
                chosenB = indexB;
            }
            if(a[indexA] + b[indexB] < x) 
                indexA++;
            else
                indexB--;
        }
        
        System.out.println(a[chosenA] +" and " + b[chosenB]);
    }

    // 22/6/22 revisiting this question , solution is almost the same , no reason to add it 


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon 467 2017 4a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 87 sheelon 470 2020 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a matrix/grid of size nxm and number of turns k (a turn is moving down->right or right->down)
    // we start at [0][0] , can only move right\down and need to do exactly k turns and end at [arr.length - 1][arr.length -1] 
    // return the unique number of valid paths
    // Limitations : need to solve recursively, can change the given matrix temporarly but at the end it needs to go back to its original state

    // so we start at [0][0] and need to reach [n - 1][m - 1] that means we have n-1 moves to the right and m-1 moves downwards
    // in total n+m-2 moves of r-right and d-down
    // we can see it as a combinatorical question if we have 2 different letters that are adjacent to each other we consider that as a turn
    // if we move to the right first , we need to find out how many unique ways there are to place m-1 identical l-objects in n-1 bins
    // and if we move downwards first we need to find out how many unique ways there are to place n-1 identical r-objects in m-1 bins
    // and we need to do it within the k turns constraint


    /*
        first we'll define a block as a number of consecutive moves like so "rrr" , "rrrrrrrr" , "d" and so on
        we need to do exactly k turns , that means that we need k+1 blocks of r's and d's in total 
        assuming k+1 <= m+n-2 , we have two choices , either start with r block or d block
        if we start with r block and k = 2*L (even) then we will have L+1 blocks or r and L blocks of d
        if k is odd , k = 2*L + 1  then we will have L+1 blocks of r and L+1 blocks of d
        so the solution in case we start with r block would be 

        C(m - 2 , ⌊k/2⌋ ) * C(n - 2 ,  ⌊k-1/2⌋) 

        and in total 

        C(m - 2 , ⌊k/2⌋ ) * C(n - 2 ,  ⌊k-1/2⌋)  +  C(n - 2 , ⌊k/2⌋ ) * C(m - 2 ,  ⌊k-1/2⌋) 
        
    */
    public static int totalWays(int[][] mat, int k) {
        int maxRow = mat.length;
        int maxCol = mat[0].length;
        if(maxRow == 0 || maxCol == 0)
            return 0;

        int rightFirst = nCk(maxCol - 2, k/2)*nCk(maxRow - 2, (k-1)/2);
        int downFirst = nCk(maxRow - 2, k/2)*nCk(maxCol - 2, (k-1)/2);
        return rightFirst + downFirst;
    }

    private static int factorial(int num , int fact) {
        if(num <= 0)
            return fact;
        else
            return factorial(num - 1, fact * num);
    }

    private static int nCk(int n , int k) {
        return factorial(n, 1) / (factorial(k, 1) * factorial(n-k, 1));
    }
    /*  
        great question !
        
        https://math.stackexchange.com/questions/3366084/given-an-n-times-m-grid-with-starting-bottom-left-position-1-1-how-many?rq=1
        https://math.stackexchange.com/questions/1080158/finding-the-count-of-paths-with-k-turns-from-corner-to-corner-in-a-square-box
        https://math.stackexchange.com/questions/667272/number-of-way-to-move-form-1-1-to-n-n-in-a-square-grid-taking-exactly-k?rq=1
        https://math.stackexchange.com/questions/870755/count-no-of-ways-with-exactly-k-turns?rq=1
        https://www.codechef.com/DEC11/problems/MOVES
        https://discuss.codechef.com/t/moves-editorial/947
        https://math.stackexchange.com/questions/87337/combinatorics-problem?rq=1
        https://math.stackexchange.com/questions/1994588/how-many-ways-can-a-moving-object-reach-the-point-m-n-with-exactly-k-chang?rq=1

    */

    // 22/6/22 revisiting this question - almost the same , older solution needs more corner cases checks

    public static int totalWaysRE(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        if(n <= 1 || m <= 1)
            if(k == 0)
                return 1;
            else
                return 0;

        int rightFirst = 0;
        int downFirst = 0;

        if(n - 2 >= k/2)
            rightFirst = nCkRE(n - 2, k/2)*nCkRE(m-2, (k - 1)/2);
        if(m - 2 >= k/2)
            downFirst = nCkRE(m - 2, k/2)*nCkRE(n - 2, (k - 1)/2);
            
        return rightFirst + downFirst;
    }

    private static int nCkRE(int n, int k) {

        return factorialRE(n)/(factorialRE(k)*factorialRE(n - k));

    }

    private static int factorialRE(int i) {
        if(i <= 1)
            return 1;

        return i*factorialRE(i - 1);
    }

    //                                                                          QUESTION 2

    // given a sorted array of positive integers (∀ i < j , array[i] < array[j]) and integer num
    // we need to write a method that prints all triplets in the array such their product is equal to num
    // a[i]*a[j]*a[k] = num
    // Limitations : solution needs to be efficient as possible 

    // naive solution would be O(n^3) so we need something <= O(n^2)
    // from observing this seems like O(nlogn) 

    // we traverse through the array once for every element besides the last two elements O(n)
    // using two pointers we move through the array and check for a valid product O(n)

    // time complexity O(n^2)
    // space complexity O(1)
    public static void printTriplets(int[] a, int num) {
        int aLength = a.length;
        for(int i = 0 ; i < aLength - 2; ++i) {
            int rightIndex = aLength - 1;
            int leftIndex = i + 1;

            while(leftIndex < rightIndex) {
                if(a[i]*a[leftIndex]*a[rightIndex] == num)
                    System.out.println(a[i] + "    " + a[leftIndex] + "   " + a[rightIndex] );
                if(a[i]*a[leftIndex]*a[rightIndex] < num)
                    leftIndex++;
                else
                    rightIndex--;
            }

        }

    }

    // 24/6/22 revisiting this question, solution is pretty much the same , different naming and indices but overall pretty much the same 


    //                                                                          QUESTION 3

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 87 sheelon 470 2020 a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 82 sheelon 465 2012 2a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given an array of unique natural numbers and a natural number n 
    // find if n can be represented as a sum of elements in the given array (can have duplicates)
    // if we can find such sum , return true and print the elements otherwise return false
    // given : the parameters are valid , the array isn't null , all the elements are unique and the value n is natural , remember that the array isn't sorted
    // and 0 can be represented by any array (vacuously true)
    // Limitations : need to solve with recursion only 

    public static boolean isSumOf(int[] s, int n) {
        return isSumOf(s, n, 0, s.length,n);
    }

    private static boolean isSumOf(int[] arr, int sum, int index, int lastIndex, int copySum) {

        if(index>= lastIndex || sum < 0) // in case we get to invalid values of indices or sum
            return false;

        if(sum == 0) { // if sum = 0 return true and then the recusive calls will print the numbers that make up that sum 
            return true; 
        }
        
        if(isSumOf(arr, sum, index + 1, lastIndex,copySum)) { // skip current element
            return true;
        }
        if(isSumOf(arr, sum - arr[index], index, lastIndex,copySum)) { // pick current element with the option to pick it again 
            System.out.print(arr[index] + " ");
            return true;
        }

        return false;
    }

    // 24/6/22 revisiting this question , almost the same 

    public static boolean isSumOfRE(int[] s, int n) {
        return isSumOfRE(s, n, 0, "");
    }

    private static boolean isSumOfRE(int[] s, int n, int i, String numbers) {

        if(n == 0) {
            System.out.println(numbers);
            return true;
        }

        if(n < 0 || i >= s.length)
            return false;

        return isSumOfRE(s, n, i + 1, numbers) || isSumOfRE(s, n - s[i], i, numbers + s[i] + " ");
    }


    //                                                                          QUESTION 2

    // given an array of integers that is sorted in ascending order and integer x
    // we need to return the number of elements in the sorted array with the value x
    // Limitations : need to be afficient as possible 

    // right away the naive way would be O(n) so we can safely assume this one requires a binary search and will be O(nlogn)

    // time complexity O(logn) , using a variation of binary search twice
    // space complexity O(1) 
    public static int count(int[] a, int x) {
        int aLength = a.length;
        int high = aLength - 1;
        int low = 0;
        int mid;
        int rightSide = 0; // variable to hold the index of the right side of the interval
        int leftSide = 0; // variable to hold the index of the left side of the interval
        // use two binary searches , one for finding the right most index for the interval and other for the leftmost interval
        while(low <= high) {

            mid = low + (high-low)/2;

            if(a[mid] == x && ( (mid+1 < aLength && a[mid+1] > a[mid] ) || mid == aLength-1 ) ) {
                rightSide = mid;
                break;
            }

            if( a[mid] > x) 
                high = mid - 1;
            else if( a[mid] <= x)
                low = mid+1;
        }
        // repeating the binary search with different if statements in order to find the leftmost index 
        low = 0;
        high = aLength-1;
        while(low <= high) {
            
            mid = low + (high-low)/2;

            if(a[mid] == x && ((mid-1 >=0 && a[mid-1] < a[mid]) || mid == 0 )  ) {
                leftSide = mid;
                break;
            }

            if( a[mid] < x) 
                low = mid + 1;
            else if( a[mid] >= x)
                high = mid - 1;
                
        }
   
        return (a[leftSide] == x) ? (rightSide - leftSide + 1) : 0;
    }

    // 24/6/22 revisiting this question , pretty much the same  

    public static int countRE(int[] a, int x) {

        int n = a.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        int start = 0;
        int end = 0;

        while(low <= high) {

            mid = low + (high - low)/2;

            if(a[mid] == x) {

                if(mid - 1 >= 0 && a[mid] == a[mid - 1]) {
                    high = mid - 1;  
                }else {
                    start = mid;
                    break;
                }
            }else if(a[mid] < x)
                low = mid + 1; 
            else
                high = mid - 1;

        } // while loop
        // restart values before another binary search 
        low = 0;
        high = n - 1;

        while(low <= high) {

            mid = low + (high - low)/2;

            if(a[mid] == x) {

                if(mid < n - 1 && a[mid] == a[mid + 1]) {
                    low = mid + 1;  
                }else {
                    end = mid;
                    break;
                }
            }else if(a[mid] < x)
                low = mid + 1; 
            else
                high = mid - 1;

        } // while loop

        if(a[start] == x && a[end] == x)
            return end + 1 - start;
        else
            return 0;
    }


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 82 sheelon 465 2012 2a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon ??? 2012 3a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we define sorted in a crossed way as follows :  
    // ∀ (i < j ∧ i,j % 2 = 0 ) , arr[i] < arr[j]  and ∀ (l < k ∧ l,k % 2 = 1 ) , arr[l] > arr[k] 
    // given :  we can assume the arrays are sorted in a crossed way if told so and don't need to check that
    // Limitations : solution needs to be efficient as possible both in terms of time and memory

    // a. (13 points)

    // given an array of intergers that is sorted in a crossed way
    // we need to write a method that sorts the array in ascending order ∀ i < j , arr[i] ≤ arr[j]

    // first thought is to use O(n) space and O(n) time 
    // create a new array and iterate through the given array once , need to check if we can do it in a more efficient way 
    // woudl've been fun if the max size of the array was 32 

    // time complexity O(n) going through the array once
    // space complexity O(n) using a temporary array to sort the elements
    public static void crossSort(int[] arr) {
        int arrLength = arr.length;
        int[] sortedArr = new int[arrLength];
        int evenIndex = 0;
        int oddIndex = (arrLength % 2 == 0) ? arrLength - 1 : arrLength - 2;

        // iterate through the array and compare the even indices from the start with the odd indices starting from the last odd index and decreasing by 2 
        // as we go through the array and sort the elements in the new array
        for(int i = 0; i < arrLength ; ++i) {

            if(oddIndex <= 0 && evenIndex < arrLength) { // in case we added all the elements in the odd indices and are left with just the even indices
                sortedArr[i] = arr[evenIndex];
                evenIndex += 2;
                continue;
            }
            if(evenIndex >= arrLength && oddIndex >= 1) { // same as above just for the opposite case
                sortedArr[i] = arr[oddIndex];
                oddIndex -= 2;
                continue;
            }

            if(arr[evenIndex] >= arr[oddIndex]) { 
                sortedArr[i] = arr[oddIndex];
                oddIndex -= 2;
            }else {
                sortedArr[i] = arr[evenIndex];
                evenIndex += 2;
            }

        }
        // change the given array to a sorted in ascending order state
        for(int i = 0 ; i < arrLength ; ++i) {
            arr[i] = sortedArr[i];
        }

    }


    // b. (12 points)

    // need to write a method that receives a cross sorted array and integer x and returns the index of the element with the value of x otherwise return -1
    // if the value appears more than once it doesn't matter which index we return 


    // since the naive way would be O(n) , we are probably looking at some sort of binary search 
    // we'll run the binary search twice , once for even indices and once for odd indices

    // time complexity O(logn) using binary search twice
    // space complexity O(1) 
    public static int crossSearch(int[] arr, int x) {
        int arrLength = arr.length;
        int high = (arrLength%2 == 0) ? arrLength - 2 : arrLength - 1;
        high = high/2;  // dividing by 2 as the final result would be the last even index in the array 
        int low = 0;
        int mid = 0;

        // we treat the even and odd indices as indices of different arrays to avoid unreadble and messy code 
        // this way we can traverse through the array without worrying we will ever try and compare a value at index of opposite parity 
        // so basically we're avoiding everything by pretending that the indices start at 0 for both odd and even sub-arrays
        // but everytime we need to check the values of the elements we multiply the mid index as need either for even(mid*2) or odd(mid*2 + 1)
        while(low <= high) {

            mid = low + (high-low)/2;
            if(arr[mid*2] == x)
                return mid*2;

            if(arr[mid*2] < x)
                low = mid + 1;
            else
                high = mid - 1;
            
        }
        // here we also account for the sorted in descending order sub-sequence and therefore change the indices as if was ordered in ascending order
        low = (arrLength%2 == 1) ? arrLength - 2 : arrLength - 1;
        low = low/2; // dividng by 2 for the same reason as above but this time it will be the first odd index in the imaginary array 
        high = 0;

        while( low >= high) { // notice low >= high

            mid = low + (high-low)/2; // mid = high + (low - high)/2; ? 
            if(arr[mid*2 + 1] == x)
                return mid*2 + 1;
            
            if(arr[mid*2 + 1] < x)
                low = mid - 1;
            else
                high = mid + 1;

        }
        return -1;

    }   

    // 24/6/22 revisiting this question , almost the same answer 

    //                                                                          QUESTION 2

    // given a 2d array / matrix if non negative integers print the cost of each possible path from [0][0] to the bottom right corner 
    // can move in 4 directions up/down/left/right
    // given :  can assume the matrix isn't null or empty 
    // Limitations : need to solve with recursion 

    /*
        int i = 0
        int j = 0
        int sum = 0;
        usually we can use a boolean array or multiply by -1 but since we have NON-NEGATIVE integers that means we can't multiply by -1 and need to use the boolean arr
        if we reach bottom right corner
            print sum 
            return

        add recursive calls and index check......

        return
    */

    public static void printPathWeights(int[][] m) {
        int maxRow = m.length;
        int maxCol = m[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];
        printPathWeights(m, visited, 0, 0, 0, maxRow, maxCol);
    }

    private static void printPathWeights(int[][] arr, boolean[][] visited, int i, int j, int sum, int maxRow, int maxCol) {

        if(i == maxRow - 1 && j == maxCol - 1) {
            System.out.println(sum);
            return;
        }

        if( isValid4(i, j, maxRow, maxCol)&& !visited[i][j]) {
            visited[i][j] = true;
            printPathWeights(arr, visited, i + 1, j, sum + arr[i][j], maxRow, maxCol);
            printPathWeights(arr, visited, i - 1, j, sum + arr[i][j], maxRow, maxCol);
            printPathWeights(arr, visited, i, j + 1, sum + arr[i][j], maxRow, maxCol);
            printPathWeights(arr, visited, i, j - 1, sum + arr[i][j], maxRow, maxCol);
            visited[i][j] = false;
        }
        return;

    }

    private static boolean isValid4( int i, int j, int maxRow, int maxCol) {
        if(i>=0 && j >= 0 && i < maxRow && j < maxCol)
            return true;
        else
            return false;
    }

    // 24/6/22 revisiting this question , almost the same , not sure if we need to print just the sum or the sum with the path itself though 

    //                                                                          QUESTION 3

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon ??? 2012 3a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 92 sheelon 474 2012 3b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given an array of positive integers we define a valid path as follows
    // we start at arr[0] and can either jump right\left arr[i] times 
    // we cannot exceed the boundries , the path needs to end at the last index 
    // if there's a valid path in the array return true , otherwise false
    // given : we can change the given array 
    // Limitations : need to solve with recursion

    // simply go over the two options , go left or right (if valid)
    // change every visited element to maxIndex in order to avoid it again 
    // that way we won't get into infinite loops 

    public static boolean isWay(int[] a) {
        return isWay(a, 0, 0, a.length);
    }

    private static boolean isWay(int[] arr, int i, int dummyVar, int maxIndex) {
        if(i < 0 || i >= maxIndex || arr[i] == maxIndex) 
            return false;

        if(i == maxIndex - 1)
            return true;
        
        dummyVar = arr[i];
        arr[i] = maxIndex;

        return isWay(arr, i + dummyVar, i, maxIndex) || isWay(arr, i - dummyVar, i, maxIndex);
            
    }
    
    // 24/6/22 revisiting this question , very close 

    public static boolean isWayRE(int[] a) {
        return isWayRE(a, 0);
    }

    private static boolean isWayRE(int[] a, int i) {

        if(i < 0 || i >= a.length || a[i] < 0)
            return false;

        if(i == a.length - 1)
            return true;

        a[i] *= -1;
        
        return isWayRE(a, i - a[i]) || isWayRE(a, i + a[i]);
    }


    //                                                                          QUESTION 2

    // given a string of length 2n of 0's and 1's
    // we need to return the minimum required swaps in order to turn the string into the form of 10101010...10 or 01010101...01
    // given : the string will only contain char 0 and 1 both exactly n times each , don't need to check that
    // Limitations : solution needs to be efficient as possible , we cannot use any other method from class String besides charAt() and length()


    // from first impression , we don't need to even check the swaps , only check a few cases
    // when we have 000 we need to add one swap , when we have string of consecutive 1's that its length is a multiple of 3 we don't need to count it 
    // since we already counted the 000 for them ,
    // few other edge cases that are reasonably trivial to see / figure out
    // so right now this seems like O(n)
    // after some thinking ,this is not the way to go , cases like 1001 wont work with it , so the method will probably require a lot of tinkering 

    // so a better solution is to use the index loop to do a bit-wise and operation 
    // as if we had two strings of length s.length() that look like 010101.....01 and 10101010.....10
    // the minimum of both will be the needed result 
    // this only works since we are guaranteed to have exactly n 0's and n 1's so in total 2n char

    // space complexity O(n) , traversing through the string once
    // space complexity O(1) 
    public static int alternating(String s) {
        int sLength = s.length();
        int countFirstString = 0;   // this will be the counter for the string 101010...10 , 1 at every odd index
        int countSecondString = 0;  // this will be the counter for the string 010101...01 , 1 at every even index
        // we'll use the index of the loop and the logical and operation to make sure addition is performed on the right string at that index 
        for (int i = 0 ; i < sLength ; ++i) {

            if(i%2 == 1 && s.charAt(i) == '1') 
                countFirstString++;
            if(i%2 == 0 && s.charAt(i) == '1')
                countSecondString++;
        }
        // using another method for code readability and funcionality
        return min(countFirstString , countSecondString);
    }
    // min method checks which count is lower and returns it 
    // if both are zero that means we already have a valid string
    // if only one of the is zero we compare the other string with 1
    // else we compare both strings 
    private static int min(int a, int b) {
        if(a == b && a == 0 )
            return 0;

        if(a == 0)
            return (b > 1) ? 1 : b;
        else if(b == 0)
            return (a > 1) ? 1 : a;
        else
            return (b > a) ? a : b;
    }

    // 24/6/22 revisiting this question , almost the same 

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 92 sheelon 474 2012 3b  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 88 sheelon ??? 2012 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@




    //                                                                          QUESTION 2

    // we define a Hadamard matrix of size nxn as follows : 
    // the values of the elements can either be 1 or -1
    // the difference between any two rows will be exactly n/2
    // that is , for any two rows we can pair the elements such that half of the pairs are euqal in value and the other half is the opposite in value 

    // we need to write a method that receives a number n that is a power of 2 and fill a matrix of that size nxn with 1's and -1's such that
    // we get a Hadamard matrix
    // given : we can assume that value n is some power of 2 and the matrix isn't null
    // Limitations : need to solve with recursion only

    public static void fillHadamard(int[][] mat) {

        fillHadamard(mat, 0, 0, mat.length, 1);
    }

    // better solution than mine , really clean 
    // https://stackoverflow.com/questions/35440103/solution-for-hadamard-matrix-using-recursion

    private static void fillHadamard (int [][] mat, int top, int left, int size, int sign)
    {
        if (size == 1)
            mat[top][left] = sign;
        else
        {
           fillHadamard (mat, top, left, size/2, sign);
           fillHadamard (mat, top+size/2, left, size/2, sign);
           fillHadamard (mat, top, left+size/2, size/2, sign);
           fillHadamard (mat, top+size/2, left+size/2, size/2, (-1)*sign);
        }
    }



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 88 sheelon ??? 2012 6a  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 92 sheelon 477 2021 b @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // we're given a one dimensional array of natural numbers (ℕ/0) and a value 'num' , we need to find 
    // how many UNIQUE ways there are to get to the value 'num' by using addition and subtraction of the arrays elements 
    // and then we need to print the valid elements with their corresponding coefficient that make up the value 'num'
    // at the end , return the number of unique ways 
    // Limitations : need to solve with recursion only 

    public static int printExpr(int[] arr, int num) {
        return testExpr(arr, 0, arr.length - 1, num, 0, "");
    }

    private static int testExpr(int[] arr, int index, int maxIndex, int target, int currentSum, String expr) {
        // in case we reach the target , print the expr string and return 1 
        if(target == currentSum) {
            System.out.println(expr);
            return 1;
        }
        // reaching over the end of the array 
        if(index > maxIndex)
            return 0;

        // we have three options ; skip / add / subtract , the skip call will keep the string empty and current sum at 0
        // and thus every recusive call from then on will start with these values 

        // then we have the other two options add and subtract 
        // the element at the current index will be added or subtracted to/from the current sum and the value of the element along with it's coefficient
        // will be added as a string to the expr string 
        return testExpr(arr, index + 1, maxIndex, target, currentSum, expr) + testExpr(arr, index + 1, maxIndex, target, currentSum+arr[index], expr + "+"+arr[index] + " ") + 
                        testExpr(arr, index + 1, maxIndex, target, currentSum-arr[index],expr + "-"+arr[index] + " ");

    }


    //                                                                          QUESTION 2

    // given a one dimensional array of 1's and 0's and a non negative integer 'k'
    // we need to find and return the longest sub-array that contains at most k 0's
    // Limitations : solution needs to be efficient as possible 

    // at first I thought there was a way to use three pointers to somehow progress through the array but it's not going to work
    // seems like the best bet would be O(n) (we will use a window to iterate through the array at most 2 times) right now 

    // time complexity O(n) , iterating through the array at most twice 
    // space complexity O(1)
    public static int longestSequence(int[] a, int k) {

        int arrLength = a.length;
        int zCounter = 0;
        int leftP = 0;
        int rightP = 0;
        int maxLength = 0;
        int windowLength = 0;

        while(leftP < arrLength) {

            if(zCounter <= k && rightP < arrLength){

                if(a[rightP] == 0) {
                    ++zCounter;
                    ++rightP;
                }else {
                    ++windowLength;
                    ++rightP;  
                }

            }else if(leftP < rightP){

                if(a[leftP] == 0) {
                    --zCounter;
                    ++leftP;
                }else {
                    ++leftP;
                    --windowLength; 
                }

            }else
                return maxLength;

            if(zCounter <= k && windowLength + zCounter > maxLength)
                maxLength = windowLength + zCounter;

        }

        return maxLength;

    }


    // another approach is to count the difference between the indices instead of actually counting the length of the valid arrays

    public static int longestSequenceV2(int[] a, int k) {

        int start = 0;
        int end;
        for(end = 0 ; end < a.length ; ++end) {
            if(a[end] == 0)
                --k;
            // in case we have too many 0's , we increment the start index and if the element at that index is 0 we also increase k
            if(k < 0 && a[start++] == 0) 
                ++k;
        }
        // return the difference between the indices instead of counting the length of the sub arrays , when k < 0 we delay the start index
        // and thats why when we get to the end of the array , the difference between the indices is actually the length of the longest valid sequence
        return end - start;
    }


    




    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 92 sheelon 477 2021 b @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 83 sheelon 466 2019 b @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a two dimensional array of 1's and 0's and a target cell [x][y]
    // we need to find the longest valid path from [0][0] to the target cell [x][y]
    // we can move in four directions right/up/left/down
    // we can only move to cells which hold the value 1 and we can't visited a cell twice 
    // given : we can change the given array but only temporarily 
    // Limitations : must solve with recursion only 


    public static int longestPath(int[][] mat, int x, int y) {
        if(mat[0][0] == 0) // in case the first cell has a value of 0
            return 0;
              
        return longestPath(mat, x, y, 0, 0);
    }

    private static int longestPath(int[][] mat, int x, int y, int i, int j) {
        int tempMax = 0; // temp variables in order to compare the lengths of valid paths 
        int max = 0;

        if(i == x && j == y) // reach target cell , add 1 to length 
            return 1;

        // simple four if statements , for the four possible moves , check if the next move is valid in terms of boundries and values (arr[][] != 0 , -1)
        if(isValid5(mat, i, j + 1)) {
            mat[i][j] *= -1;    // mark cell as visited 
            tempMax = 1 + longestPath(mat, x, y, i, j + 1);
            mat[i][j] *= -1;    // unmark the cell 
            if(tempMax > max) // compare the lengths of the valid paths 
                max = tempMax;
        }
        if(isValid5(mat, i - 1, j)) {
            mat[i][j] *= -1;
            tempMax = 1 + longestPath(mat, x, y, i - 1, j);
            mat[i][j] *= -1;
            if(tempMax > max)
                max = tempMax;
        }
        if(isValid5(mat, i, j - 1)) {
            mat[i][j] *= -1;
            tempMax = 1 + longestPath(mat, x, y, i, j - 1);
            mat[i][j] *= -1;
            if(tempMax > max)
                max = tempMax;
        }
        if(isValid5(mat, i + 1, j)) {
            mat[i][j] *= -1;
            tempMax = 1 + longestPath(mat, x, y, i + 1, j);
            mat[i][j] *= -1;
            if(tempMax > max)
                max = tempMax;
        }

        return max;

    }
    // a simple bool method to check if the next move is valid 
    private static boolean isValid5(int[][] mat, int i, int j) {
        return(i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && mat[i][j] == 1);
    }

    // 25/6/22 revisiting this question 

    public static int longestPathRE(int[][] mat, int x, int y) {
        // validating the target coords and making sure the starting cell's value isn't 0
        if(x >= mat.length || y >= mat[0].length || x < 0 || y < 0 || mat[0][0] == 0)
            return 0;

        return longestPathRE(mat, x, y, 0, 0);
    }

    private static int longestPathRE(int[][] mat, int x, int y, int i, int j) {
        // validate coords and cell
        if(i >= mat.length || j >= mat[0].length || i < 0 || j < 0 || mat[i][j] == 0 || mat[i][j] < 0)
            return -1;
        // reaching destination
        if( i == x && j == y)
            return 1;
        // checking all possible four direction and marking the current cell as visited by multiplying by -1 and later on multiplying again to restore to original value 
        mat[i][j] *= -1;
        int max = max(longestPathRE(mat, x, y, i + 1, j), longestPathRE(mat, x, y, i - 1, j), longestPathRE(mat, x, y, i, j + 1), longestPathRE(mat, x, y, i, j - 1));
        mat[i][j] *= -1;

        return 1 + max;
    }
    // check for the longest path out of the four directions 
    private static int max(int up, int down, int left, int right) {

        int temp = 0;

        if(temp < up)
            temp = up;
        if(temp < down)
            temp = down;
        if(temp < left)
            temp = left;
        if(temp < right)
            temp = right;

        return temp;
    }

    //                                                                          QUESTION 2

    // given a matrix of integers sorted row-wise column-wise
    // we need to return the number of cells with negative value
    // given : n rows , m columns , time complexity is O(m+n) , space complexity is O(1)
    // Limitations : solution's time complexity is O(m+n) and space complexity is O(1)


    // time complexity is O(m+n) - worst case scenario , traversting through the array once from top right corner to bottom left corner of the matrix
    // space complexity is O(1) - only instantiating variables 
    public static int howManyNegativeNumbers(int[][] arr) {
        if(arr[0][0] >= 0) // using the fact of how the matrix is sorted , if arr[0][0] >= 0 then we won't find any negative value 
            return 0;

        int row = arr.length;
        int col = arr[0].length;

        int i = 0;
        int j = col - 1;
        int pointer = arr[i][j];

        int negativeNums = 0;
        while(j > 0) {
            
            if(i == row) // in this case all the other elements from the left will be negative so we return the size of that area j*row as well as negativeNums
                return negativeNums + (j*row); // and using the fact that j is 0-based 

            pointer = arr[i][j]; // update to current cell's value

            if(pointer < 0 ) { // increase until we reach a cell with a positive element
                ++i;
            }else { // we reached a cell with a positive value , add i to negativeNums as thats the number of cells with negative values in that col
                    // and move on to the col on the left (--j)
                negativeNums += i;
                --j;
            }
                
        }

        return negativeNums;
    }

    //                                                                          QUESTION 3




    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 83 sheelon 466 2019 b @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 93 sheelon 466 2019 b3 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a one dimensional array of positive integers and a positive value 'num'
    // we need to check if we can find a sub-set of the array such that its sum is equal to 'num' under the given constraint 
    // the elements of the sub set must be unique 
    // can't have three or more consecutive elements , index-wise
    // return true if we can find such sub-set , otherwise return false
    // Limitations : can only use recursion

    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0, 0, 0);
        //return isSum(a, num, 0, 0, 0, "");
    }

    private static boolean isSum(int[] a, int num, int sum, int i, int consec) {

        if(i >= a.length || sum > num || num < 0) // boundry check and stop recursions early if sum > num 
            return false;

        if(sum == num)
            return true;
                        // we have two options , move to the next skip or add , we use the variable 'consec' to avoid using more than two consecutive elements
        if(consec <= 1) // at a time , if we already added two , then we will move to the else statement which simply skips one index/element
            return isSum(a, num, sum, i + 1, 0) || isSum(a, num, sum + a[i], i + 1, consec + 1);
        else
            return isSum(a, num, sum, i + 1, 0);
    }
    // return the expression as well 
    /* 
    private static boolean isSum(int[] a, int num, int sum, int i, int consec, String s) {

        if(i >= a.length)
            return false;

        if(sum == num) {
            System.out.println(s);
            return true;
        }
        if(consec <= 1)
            return isSum(a, num, sum, i + 1, 0, s) || isSum(a, num, sum + a[i], i + 1, consec + 1, s +" "+ a[i]);
        else
            return isSum(a, num, sum, i + 1, 0, s);

    }
    */

    //                                                                          QUESTION 2

    // given two arrays of size N filled with positive integers 
    // the element's value represents the time it takes to pass a part of the road 
    // both roads(arrays) start and end at the same places 
    // we start at one road (array) and can switch roads only ONCE
    // find the minimum points needed to reach the end of the array (fastest route to the end of the road)
    // Limitations : solution needs to be efficient as possible

    // time complexity O(n) - iterating through the array twice
    // space complexity O(1) -  only instantiating variables
    public static int shortestRoad(int[] road1, int[] road2) {
        // using the fact that we can only switch roads once (makes things much easier) we simply arbitrarily sum one array and then 
        // starting from the last element of both we decrease the already counted element and add the element from the other array to the sum
        // we do it until we reach the first element , with each iteration we check for a lower sum
        int tempMin = 0;
        for(int i = 0 ; i < road2.length ; ++i) 
            tempMin += road2[i];

        int minPoints = tempMin;

        for(int i = road2.length - 1 ; i >= 0 ; --i) {
            tempMin += (road1[i] -road2[i]); 
            if(minPoints > tempMin)
                minPoints = tempMin;
        }

        return minPoints;

    }

    // 25/6/22 revisiting this question , need to add another case, old solution works for specific cases only 

    // time complexity O(n) - iterating through the array twice
    // space complexity O(1) -  only instantiating variables
    public static int shortestRoadRE(int[] road1, int[] road2) {

        int road1Sum = 0;
        int road2Sum = 0;
        for(int i = 0 ; i < road2.length ; ++i) {
            road1Sum += road1[i];
            road2Sum += road2[i];
        }
        
        int minLength = (road1Sum < road2Sum) ? road1Sum : road2Sum;
        // check what happens when we swtich from both roads 
        for(int i = road1.length - 1 ; i >= 0 ; --i) {
            road1Sum -= road1[i];
            road1Sum += road2[i];

            road2Sum -= road2[i];
            road2Sum += road1[i];

            if(minLength > Math.min(road1Sum, road2Sum))
                minLength = Math.min(road1Sum, road2Sum);
            
        }
        return minLength;
    }

    //                                                                          QUESTION 3




    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 93 sheelon 466 2019 b3 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon ??? 2019 4a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a one dimensional array of integers 
    // we need to return the length of the longest palindrome sub-array
    // Limitations : must solve with recursion  

    // current naive solution is to check every element in the array and see if we can find a palindrome that starts from that element
    public static int longestPalindrome(int[] arr) {
        return longestPalindrome(arr, 0);
    }
    // iterate through the elements
    private static int longestPalindrome(int[] arr, int i) {

        if(i >= arr.length) // we're not stopping at length/2 since the array isn't necessarily symmetric 
            return 1;

        return Math.max(longestPalindrome(arr, i, arr.length - 1, arr[i]) , longestPalindrome(arr, i + 1));
    }
    // starting from the last element , iterate over the array looking for another element that's equal to arr[i]
    // if found , we check if the length of that sub-array is even or odd 
    // we keep iterating over the array even if we found one element that's equal to arr[i]
    // since there can be more 
    private static int longestPalindrome(int[] arr, int i, int j, int val) {

        if(j < i)
            return 1;

        if(arr[j] == val) {
            if(j + 1 - i % 2 == 0) // even length
                return Math.max(longestPalindrome(arr, i, j, true, 0),longestPalindrome(arr, i, j - 1, val));
            else // odd length
                return Math.max(longestPalindrome(arr, i, j, false, 0),longestPalindrome(arr, i, j - 1, val));
        }

        return longestPalindrome(arr, i, j - 1, val);
    }
    // check if the given sub-array is a valid palindrome 
    // we account for the parity of the length using a boolean 
    private static int longestPalindrome(int[] arr, int i, int j, boolean even, int length) {

        if(i >= arr.length || j < 0 || i >= j)
            return length;

        if(even) {

            if(arr[i] == arr[j]) {  // reaching the middle of the palindrome
                if(j - i == 1)
                    return length + 2; 
                else    // count the length of the possible palindrome
                    return longestPalindrome(arr, i + 1, j - 1, even, length + 2);
            }else   // in case the sub-array is not a valid palindrome
                return 1;
        }else {

            if(arr[i] == arr[j]) {  // reaching the middle of the palindrome
                if(j - i == 2)
                    return length + 3; 
                else    // count the length of the possible palindrome
                    return longestPalindrome(arr, i + 1, j - 1, even, length + 2);
            }else   // in case the sub-array is not a valid palindrome
                return 1;
        }

    }

    //                                                                          QUESTION 2

    // given a one dimensional array of arithmetic sequence we need to find the missing value in the sequence
    // given : we can assume the array always holds the values of an arithmetic sequence 
    // Limitations : solution needs to be efficient as possible 

    // even though we're told the array hold an arithmetic sequence and there's a missing value they either assume we understand the implicit meaning 
    // or they forgot to mention that the size of the array is always >= 3 or what to do in case the length <= 2


    // time complexity O(logn) - using binary search to find the missing element
    // space complexity O(1) - instantiating variables 
    public static int missingValue(int[] arr) {

        int n = arr.length;
        // find the difference 
        int d = (arr[1] - arr[0]  > arr[n - 1] - arr[n - 2]) ? arr[n - 1] - arr[n - 2] : arr[1] - arr[0];

        int low = 0;
        int high = n - 1;
        int mid = 0;

        while(low < high) {

            mid = low + (high - low)/2;

            if(mid == low) {
                if(low - 1 >= 0 && arr[low] - arr[low - 1] != d)
                    return arr[low] - d;
                else if(low + 1 < n && arr[low + 1] - arr[low] != d)
                    return arr[low] + d;
            }

            if(arr[mid] > (arr[low] + d*(mid - low)))
                high = mid;
            else
                low = mid + 1;


        }

        return 0;

    }

    // 27/6/22 revisiting this question , not sure about the solution above
    
    public static int missingValueRE(int[] arr) {
        int n = arr.length;
        int diff = Math.min(arr[1] - arr[0] , arr[n - 1] - arr[n - 2]);

        int low = 0;
        int high = n - 1;
        int mid;

        while(low <= high) {

            mid = low + (high - low)/2;

            if(mid + 1 < n && arr[mid + 1] - arr[mid] != diff)
                return arr[mid] + diff;
            if(mid - 1 >= 0 && arr[mid] - arr[mid - 1] != diff)
                return arr[mid] - diff;

            if(arr[mid] > (mid)*diff + arr[0])
                high = mid - 1;
            else
                low = mid + 1;

        }
        return -1;
    }

    //                                                                          QUESTION 3








    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon ??? 2019 4a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 87 sheelon ??? 2018 6a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a one dimensional array of size n and a positive integer 'max'
    // we're asked to find the number of ways we can fill the array of size n using all positive integers up to and inluding 'max'
    // they mention it needs to be ordered in non descending order but it doesn't matter since they only ask for the number of ways and not to print it 
    // which is a whole different story 
    // Limitations : must solve with recursion only
    // side note : no info was given on the maximum size of the array , we can easily overflow if n > 31 so we may need to use modulo 1e9 + 7


    public static int howManySorted(int n , int max) { // we're told max >= 1
        if(n == 0) // in case the array is empty 
            return 0;
        // return the number of partitions as we don't care about the order since we only need the number of ways to partition the sets of size n
        return ( (factorial2(n + max - 1))/( (factorial2(n))*(factorial2(max - 1)) ) );
    }

    private static int factorial2(int n) {
        if(n <= 1)
            return 1;

        return n*factorial2(n-1);
    }

    //                                                                          QUESTION 2

    // a. 
    // the method is looking for a sub array with a sum equal to 'num' , if found return true otherwise false

    // b. 
    // time complexity O(n^3) - two nested for loops and the nested for calls another method which in turn has another for loop in it
    // with the worst case scenario of O(n) so overall O(n^3)
    // space complexity is O(1) - only instantiating variables  

    // c. + d.
    // time complexity would be O(n) - use a while loop (sort of a sliding window) which will be O(2*n) ~ O(n) since two pointers will go over the array in the worst case
    // space complexity would be O(1) - only instantiating variables

    public static boolean what(int[] a, int num) {
        // assuming a only contains positive integers 
        int left = 0;
        int right = 1;
        int sum = a[0];

        while(left <= right) {

            if(sum == num)
                return true;
            // if the sum is greater , remove the element at index left and move on 
            if(left < a.length && sum > num )
                sum -= a[left++] ;
            else if(right < a.length && sum < num) // if the sum is less than 'num' we add the current element at right and move on 
                sum += a[right++];
            else 
                return false;
                
        }

        return false;

    }


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 87 sheelon ??? 2018 6a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 70 sheelon ??? 2021 a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a stick of size n and a one dimensional array of size n + 1 , with values in the cells such that for every i  
    // the cells's value represents the price of a stick of size i (value at i = 0 is 0 always )
    // we need to return the max profit we can make by cutting the stick into different sizes 
    // given : the array is always filled with positive integers (besides the first cell)
    // we can change the given array but must return it to its original state at the end
    // Limitations : must solve with recusrion only 

    public static int findMaxPrice(int[] prices, int n) {
        // we iterate through the sizes , we will always have a stick 
        if(n == 0)
            return prices[prices.length - 1];
        else {
            return Math.max(findMaxPrice(prices, n - 1, 1, prices[prices.length - n]), findMaxPrice(prices, n - 1));
        }

    }

    private static int findMaxPrice(int[] prices, int n, int i, int sum) {

        if(n == 0) // no more material to cut,  return the sum 
            return sum;
        if(n < 0 || i >= prices.length) // going out of boundries or cut is too big 
            return 0;
        // two options , check the next cut size or cut the stick and add the value to sum with the option to repeat 
        return Math.max(findMaxPrice(prices, n, i + 1, sum) , findMaxPrice(prices, n - i, i, sum + prices[i]));
    }

    //                                                                          QUESTION 2

    // given two arrays of size n filled with integers , and sorted in non-descending order
    // we need to return the median of the arrays 
    // given : we can assume the arrays are of equal length and are sorted in non-descending order 
    // Limitations : solution needs to be efficient as possible 


    /*
    // time complexity O(n) - going through the arrays once 
    // space complexity O(1) - only instantiating variables 
    public static int getMedian(int[] a, int[] b) {
        if(a.length == 1)
            return (a[0] + b[0])/2;
        if(a.length == 0)
            return 0;

        int aPointer = 0;
        int bPointer = 0;


        while(aPointer + bPointer < a.length) {//for(int i = 0 ; i < a.length ; ++i) {

            if(a[aPointer] <= b[bPointer])
                ++aPointer;
            else
                ++bPointer;

        }
        return (aPointer + bPointer)/2;
    }
    */

    // time complexity O(logn) - using binary search on two arrays of equal size 
    // space complexity O(1) - only instantiating variables 
    public static int getMedian(int[] a, int[] b) {

        if(a.length == 1)
            return (a[0] + b[0])/2;
        if(a.length == 0)
            return 0;

        int low = 0;
        int high = a.length;

        int partitionA = 0;
        int partitionB = 0;

        int leftA = 0;
        int rightA = 0;

        int leftB = 0;
        int rightB = 0;
        
        while(low <= high) {
            // first find the middle partition point for array a (for this question it doesn't matter but if the size of the arrays were to be different
            // then we will need to change the code and partition the shorter array )
            partitionA = (low + high)/2;
            partitionB = (a.length + b.length + 1)/2 - partitionA; // partition the second array , b
            // getting the max values up to the partitions and min values after the partitions
            leftA = (partitionA - 1 < 0) ? Integer.MIN_VALUE : partitionA - 1;
            leftB = (partitionB - 1 < 0) ? Integer.MIN_VALUE : partitionB - 1;
            rightA = (partitionA == a.length) ? Integer.MAX_VALUE : partitionA;
            rightB = (partitionB == b.length) ? Integer.MAX_VALUE : partitionB;
            // if the max val of 'a' up to the partition is <= min val of 'b' after the partition
            // and if max val of 'b' up to the partition is <= min val of 'a' after the partition  
            // it means we divided the arrays into two parts each such that the median will be around the partition points 
            if(a[leftA] <= b[rightB] && b[leftB] <= a[rightA]) {
                if((a.length + b.length)%2 == 0)
                    return ( Math.max(a[leftA],b[leftB]) + Math.min(b[rightB],a[rightA]))/2;
                else
                    return Math.max(a[leftA],b[leftB]);
            }else if(a[leftA] > b[rightB]) { // in case the max val of 'a' up to the partition is > min val of 'b' after the partition
                                             // we move to the right on the shortest array which will also move the partition on the longest one
                high = partitionA - 1;

            }else // in case the max val of 'b' up to the partition is > min val of 'a' after the partition , move the partition of the shorterst array to the right
                low = partitionA + 1;

        }

        return -1; // if we reached this point it means at least one of the arrays is not sorted
    }

    


    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 70 sheelon ??? 2021 a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 85 sheelon ??? 2021 a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //                                                                          QUESTION 1

    // given a two dimensional array filled with integers, the diagonal is filled with 0's , any element blow the diagonal is set as -1
    // any element above the diagonal has some value that represents the price of a ticket 
    // we need to find the cheapest path to the bottom right corner of the matrix which represents the last train station
    // given : dont't need to validate the array , the given array is instantiated as we're told , elements that represent the price are not empty(cost != 0)
    // Limitations : recursion only

    public static int minPrice(int[][] mat) {
        return minPrice(mat, 0, 0, 0);
    }

    private static int minPrice(int[][] mat, int i, int j, int cost) {
        // boundry check
        if(i >= mat.length || j >= mat[0].length)
            return Integer.MAX_VALUE;
        // reaching the last station as needed , return the total cost
        if(i == mat.length - 1 && j == mat[0].length - 1)
            return cost;
        // reaching a new station , we need to check the cost of moving to another station
        if(i == j)
            return minPrice(mat, i, j + 1, cost);
        // two options and we take the minimum cost between them , either move to the j'th station or check the other station and repeat
        return Math.min(minPrice(mat, j, j, cost + mat[i][j]), minPrice(mat, i, j + 1, cost));
    }

    //                                                                          QUESTION 2

    // given a one dimensional array of integers sorted in ascending order and a real number 'x'
    // we need to check if there's a sub-array such that it's average is equal to 'x'
    // if there's such sub-array , print the indices of it and return true, otherwise print no valid sub-array found and return false
    // given : we can assume the array is filled with integers and is sorted 
    // Limitations : solution needs to be efficient as possible 

    // time complexity O(n) -  iterating over the array at most twice
    // space complexity O(1) - only instantiating variables 
    public static boolean findAverage(int[] arr, double x) {

        int left = 0;
        int right = arr.length - 1;
        // sum the array 
        double sum = 0;
        for(int i = 0 ; i < arr.length ; ++i)
            sum += arr[i];
        // start with the biggest average and hone down on the target average if exists
        while(left <= right) {
            
            if((sum/(right-left + 1)) == x) {

                for(int i = left ; i <= right ; ++i)
                    System.out.print(i + " ");

                System.out.print("\n");
                return true;
            }
            // average too big , decrease the sum by rightmost element at index right, otherwise decrease the sum by leftmost element at index left
            if((double)(sum/(right-left + 1)) > x) {
                sum -= arr[right--];
            }else
                sum -= arr[left++];

        }
        // reaching this point means there's no such sub array
        System.out.println("there's no such sub-array");
        return false;
    }

    //                                                                          QUESTION 3



    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  END of moed 85 sheelon ??? 2021 a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  START of moed 60 sheelon 477 2021 a @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



    // 6/5/22 visited this after i first looked at it on 4/5/22 , cool stuff , cool way of using bitwise manipulation - bit vectors
    // https://stackoverflow.com/questions/9141830/explain-the-use-of-a-bit-vector-for-determining-if-all-characters-are-unique
    // 6/5/22 need to understand ROBOT MOVES aswesome combinatorics question and can help a lot for understanding 
    // and looking at different ways of solving questions 
    // theres a mention of number of ways to get from 00 to point nm , not exactly the same as the requirement to do K turns and only right/down but still 
    // https://www.geeksforgeeks.org/sum-of-cost-of-all-paths-to-reach-a-given-cell-in-a-matrix/

    /*  
        continue with these links , need to solve this with math instead of brute force 
        
        https://math.stackexchange.com/questions/3366084/given-an-n-times-m-grid-with-starting-bottom-left-position-1-1-how-many?rq=1
        https://math.stackexchange.com/questions/1080158/finding-the-count-of-paths-with-k-turns-from-corner-to-corner-in-a-square-box
        https://math.stackexchange.com/questions/667272/number-of-way-to-move-form-1-1-to-n-n-in-a-square-grid-taking-exactly-k?rq=1
        https://math.stackexchange.com/questions/870755/count-no-of-ways-with-exactly-k-turns?rq=1
        https://www.codechef.com/DEC11/problems/MOVES
        https://discuss.codechef.com/t/moves-editorial/947
        https://math.stackexchange.com/questions/87337/combinatorics-problem?rq=1
        https://math.stackexchange.com/questions/1994588/how-many-ways-can-a-moving-object-reach-the-point-m-n-with-exactly-k-chang?rq=1

    */

    // NOT SURE , k+1 blocks are needed in order to get k turns , basically we have k+1 stars to put and k bars ? 
    // k+1 |*|*| so k+1 bars = 3 and k+1 - 1 = 2 stars aka blocks 
    // continue delving on that  

    // still 6/5/22 , added the solution , we need k+1 blocks , if k is even k = 2L then we have L+1 blocks of the first move we do 
    // and L blocks of the other move 
    // if is odd k = 2L + 1 then we have L+1 of both the first move and the other move
    // then we just need to use nCk (stars and bars) to disribute the first move into k/2 + 1 blocks (we add one since we can start from 0)
    // and then multiply by the distribution of the other move into (k-1)/2 + 1 blocks ((k-1)/2 works for both when k is odd or even , so it is a shorter form )
    // and then we just do the same thing for the other move and just add both solutions 

    // CTF , will be fun to learn 
    // https://www.youtube.com/watch?v=FCIA4YQHx9U - how to use VM on windows 11 pro with hyper V
    // https://www.youtube.com/watch?v=ff2Au8BIy_A
    // https://security.stackexchange.com/questions/193004/what-exactly-is-ctf-and-how-can-i-as-programmer-prepare-for-a-ctf-with-beginner
    // https://security.stackexchange.com/questions/38128/what-are-the-risks-of-sshing-to-an-untrusted-host?noredirect=1&lq=1
    // https://security.stackexchange.com/questions/14815/security-concerns-with-x11-forwarding?noredirect=1&lq=1

}// end of class TestAnswers
