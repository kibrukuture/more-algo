import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    //one
 static int centered(int[] arr){
     int midIndex=(int) Math.floor(arr.length/2);
     int middleVal=arr[midIndex];
     Boolean isValid=true;
     if (arr.length%2==0 ||arr.length==0) return 0;
     for( int i=0; i<arr.length;i++){
         if(i==midIndex) continue;
         if(arr[i]<=middleVal) isValid=false;
     }
     return isValid? 1:0;
 }
 //two
 static int f(int[ ] a){
     int even=0;
     int odd=0;
     for( int i=0;i<a.length;i++){
         if(a[i]%2==0) even+=a[i];
         else odd+=a[i];
     }
     return odd-even;
 }
 //three
 static char[ ] f3(char[ ] a, int start, int len){
     int alen=a.length;
     if(len>alen-start || start<0 ||len<0) return null;
     char[] na=new char[len];
     for(int i=0;i<len;i++){
           na[i]=a[start+i];
     }
     return na;
 }
 //four
 static int f4(int n){ /* reverse the integer.*/
     String str=Integer.toString(n);
     String tot="";
     if(n<0) str=str.substring(1);//
     for(int i=str.length()-1;i>=0;i--){
         tot+= str.charAt(i) ;
     }
     if(n<0) tot="-"+tot;
     n=Integer.parseInt(tot);//
     return n;
 }
 //five
 static int[] f5(int[] first, int[] second){
     if(first ==null || second==null) return null;
     else if(first.length==0 || second.length==0) return new int[] {};
     else {
         int [] shrt;int[] lng;int[] temp;
         if(first.length>second.length){
             shrt=second;
             lng=first;
         }else{
             shrt=first;
             lng=second;
         }//end;
         temp=new int[shrt.length];int mismatch=0;
         for(int i=0;i<shrt.length;i++){
             for(int j=0;j<lng.length;j++){
                 if(shrt[i]==lng[j]) {
                     temp[i]=shrt[i];
                 }else mismatch++;
             }
         }
         int [] retunVal=new int[temp.length-mismatch];
         int jmp=0;
         for( int i=0;i<temp.length;i++){
             if(temp[i]!=0){
                 retunVal[temp.length-i-jmp-mismatch]=temp[i];
             }else{
                 jmp++;
             }
         }
         /*
         * {0,1,0,0,0,12},
         *
         *
         * */
         //System.out.println(Arrays.toString(temp)+temp.length);
         return temp;
         }
     }
 //six:not finished
 static int f7(int[] a){
     //point of equilibrium
     int [] lt;int [] rt;int pos=-1;//left and right sub array from the point of equilibrium.
     if(a==null||a.length==0) return pos;
     for(int i=0;i<a.length;i++){
         if(i==0) continue;
         else{
             lt=Arrays.copyOfRange(a,0,i);
             rt=Arrays.copyOfRange(a, i+1,a.length);
             int sumlt=0;int sumrt=0;
             for(int elem:lt ){
                 sumlt+=elem;
             }
             for(int elem:rt){
                 sumrt+=elem;
             }
             if(sumlt==sumrt) {
                 pos=i;
                 break;
             }
         }
     }
     return pos;
 }
//seven
 static int primeCount(int start, int end){
     if(start>end) return 0;
     int count=0;
     for( int i=start;i<=end;i++){
         if(i%2==0 &&i!=2) continue;
         int isPrimeCount=0;
         for(int j=1;j<=i;j++){
             if(j%2==0 &&j!=2) continue;
             if( (double)  i/j==Math.floor(i/j)) isPrimeCount++;
         }
         if(isPrimeCount==2) count++;
     }
 return count;
 }
static int isMadhavArray(int[ ] a){
     int curr; int prev;
//1,2,3,4,5,6: n(n+1)
    if(a.length==1||a.length==0) return 0;
    int span=1;
    for(int i=0;i<a.length;i++){
        for(int j=i;j<span+j;j++){

        }
        span++;
    }
     return 0;
    //0 1 3 6 10
}
static int isInertial(int [] a){
    int[] odd;int [] even;int oddl=0;int evenl=0;
    int max=a[0];
    if(a[0]%2==0)evenl++;
    else oddl++;
    for(int i=1;i<a.length;i++){
        if(a[i]%2==0) evenl++;
        else oddl++;
        if(max<a[i])max=a[i];//finds max
    }
    if(max%2!=0) return 0;//max is not even.
    else evenl=evenl-1;//max is even and reduce even array,"even", length by one.
    odd=new int[oddl];
    even=new int[evenl];
    int oddi=0;int eveni=0;//index
    boolean isValid = true;
    for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0 && a[i] != max){
                even[eveni] = a[i];
                eveni++;
            } else if(a[i] % 2 != 0) {
                odd[oddi] = a[i];
                oddi++;
            }
        }
    if(odd.length==0) return 0;//no odd value.
    for (int i = 0; i < odd.length; i++) {
            for (int j = 0; j < even.length; j++) {
                if (odd[i] < even[j]) isValid = false;
            }
    }

   if(isValid) return 1;
   return 0;
}
static int countSquarePairs(int[ ] a){
     if(a.length<2) return 0;
     int pair=0;double sqr;
     for(int i=0;i<a.length;i++){
         //forward check up
         for(int f=1+i;f<a.length;f++){
             if(a[f]>a[i]&&a[f]>0&&a[i]>0){
                 sqr= Math.sqrt(a[f]+a[i]);
                 if( sqr==Math.floor(sqr)) {
                     pair++;
                 }
             }
         }
         //backward check up
         for(int b=0;b<i;b++){
             if(a[b]>a[i]&&a[b]>0&&a[i]>0){
                 sqr= Math.sqrt(a[b]+a[i]);
                 if( sqr==Math.floor(sqr)) {
                     pair++;
                 }
             }
         }
     }
     return pair;
}
static int findPorcupineNumber(int n){
      class Prime{
         static boolean isPrime(int n){
             int factors=0;
             for( int i=1;i<=n;i++){
                 if(i!=2&&n%2==0) continue;//evens except two are not prime , so jump.
                 if((double)n/i==Math.floor(n/i)) factors++;
             }
             if(factors==2) return true;//a prime num has 2 factors.
             return false;
         }
     }
     int lstDigit=n%10;
     if(Prime.isPrime(n) && lstDigit==9){
       int porcup;
       while(true){
            porcup=++n;
            lstDigit=porcup%10;
           if(Prime.isPrime(porcup) && lstDigit==9) return porcup;
       }
     }
     return -1;


}
static int isGuthrieSequence(int[ ] a){
     int init=a[0]; // {8, 4, 1, 1}
     int ret=0;
     for(int i=0;i<a.length;i++){
        if(init==a[i]){
             if(init==1){
              ret= 1;
              break;
             }
            if(init%2==0) {
                init = init / 2;
            }
            else init=init*3+1;
         }else break;
     }
     return ret;
}
static int stantonMeasure(int[ ] a) {
        int oneOccur = 0;
        int tot = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                oneOccur++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == oneOccur) {
                tot++;
            }
        }
        return tot;
 }
static int sumFactor(int[ ] a){
     if(a.length==0) return 0;
     int sum=0;int appear=0;
     for(int i=0;i<a.length;i++){
         sum+=a[i];
     }
     for(int i=0;i<a.length;i++){
        if(sum==a[i]) appear++;
     }
     return appear;
}
static int guthrieIndex(int n){
     int iter=0;
     while (true){
         if(n==1) break;
         if(n%2==0)n=n/2;
         else{
             n=n*3+1;
         }
         iter++;
     }
     return iter;
}
static int[] solve10(){
    class Factorial {
         static int get(int n){
             if(n<=0) return 1;
             else {
                 return n*get(n-1);
             }
         }
    }
    int fact10=Factorial.get(10);
    System.out.println(fact10);
     //remove
    return new int[]{0,1};
    //THEORY: x, y and z are integers such that x and y are less than z:  x! +y! <z!
    //exceptions: if x and y are 0 or 1, z=2.
    // x!+y!=10! just can not exist.

}
static int repsEqual(int[ ] a, int n){
     String str=Integer.toString(n);
     boolean valid=true;
     for(int i=0;i<a.length;i++){
         String el= str.charAt(i)+"";
         if(a[i]!=Integer.parseInt( el))valid=false;
     }
     return valid?1:0;
}
static int henry (int i, int j){
    class Arr{
        static boolean contains( int []a, int elem){
            boolean valid=false;
            for( int item:a){
                if(item==elem) {
                    valid = true;
                    break;
                }
            }
            return valid;
        }
    }
    class Factors{
        static int[] get(int n ){
            int sqr= (int) Math.sqrt(n);
            int [] factors; int count=0;
            for(int i=1;i<=sqr;i++){
                if(n%i==0){
                    count+=2;
                }
            }
            factors=new int[count];int frst=0;int lst=1;
            for(int i=1;i<=sqr;i++){
                if(n%i==0){
                    if(frst<=count && !Arr.contains(factors,i) ) factors[frst]=i;
                    if (lst<=count && !Arr.contains(factors,n/i) ) factors[lst]=n/i;
                    frst+=2;
                    lst+=2;
                }
            }
            return factors;
        }
    }
     class Perfect{
         static int sum (int []a,int num){
             int tot=0;
             for( int elem: a){
              if(elem!=num)  tot+=elem;
             }
             return tot;
         }
         static int get(int n){
             int [] factors;int which=0;int num=4;int sum;
             while(true){
                 factors=Factors.get(num);
                 sum=sum(factors,num);
                 if(sum==num) ++which;
                 if( n==which) break;
                 num+=2;
             }
             return sum;
         }
     }
     return Perfect.get(i)+Perfect.get(j);//ith and jth perfect numbers.
}
static int isCentered15(int[ ] a){
     int centered=0;//{3, 2, 10, 4, 1, 6, 9}
     for(int i=0;i<a.length;i++){
         int tot=0;
         int lstIndex=i;
         for(int j=i;j<a.length;j++){
             tot+=a[j];
             if(tot==15){
                 lstIndex=j;
                 break;
             }
         }
         if(i==a.length-lstIndex-1) centered=1;
     }
    return centered;
}
static int isDivisible(int [ ] a, int divisor){
     boolean divisible=true;
     for(int i=0;i<a.length;i++){
         if(a[i]%divisor!=0) divisible=false;
     }
     return divisible?1:0;
}
static int isNUnique(int[ ] a, int n){
     class Combination {
         static int factorial (int n){
             if(n<=0) return 1;
             else return n*factorial(n-1);
         }
       static  int get(int n, int r){
             return factorial(n)/(factorial(r)*factorial(n-r));//number of pairs from an array elems.(Combinatory Mathematics)
         }
     }
     int[][] pairs= new int[Combination.get(a.length,2)][2];int trace=0;
     for(int i=0;i<a.length;i++){
         for( int j=i;j<a.length;j++){
             if(j==a.length-1) {
                 trace=j;
                 break;
             }
             pairs[j+trace]=new int[]{ a[i],a[j+1]};
         }
     }
     int pairNum=0;//number of pairs.
    for(int i=0;i<pairs.length;i++){
        if(pairs[i][0]+pairs[i][1]==n) pairNum++;
    }
     return pairNum==1?1:0;
}
static int isSquare(int n){
     int valid=0;
     if(n<0) return valid;//n must be a positive integer.
     for(int i=0;i<n;i++){
         if(i*i==n) {
             valid = 1;
             break;//if found early , just break out of the loop.
         }
     }
     return valid;
}
static int isLegalNumber(int[ ] a, int base){
     int valid=1;
     for( int i=0;i<a.length;i++){
         if(a[i]>base || a[i]<0) valid=0;// digits in array "a" should be between 0(included) and base(excluded).
     }
     return valid;
}
static int convertToBase10(int[ ] a, int base){
     int tot=0;
     if(isLegalNumber(a,base)==1){
         for(int i=0;i<a.length;i++){
             tot+=a[a.length-1-i]*Math.pow(base,i);
     }
     }
     return tot;
}
/*static int matches(int[ ] a, int[ ] p){
    int breakPoint=0; int match=0;int abstot=0;int index=0;
    for( int i=0;i<p.length;i++){
        for(int j=breakPoint;j< a.length;j++){

//        if( p[i] > 0){
//            if(a[j]<0) {
//                match=0;
//                break;
//            }
//            abstot+=a[j];
//        }else{
//            if(a[j]>0) {
//                match=0;
//                break;
//            }
//            abstot+= Math.abs( a[j]);
//        }
//
        System.out.println("Res: "+a[j]);
        int currIndex=Math.abs(p[i])+index;
        if(j==currIndex){
            System.out.println("break point");
            index+=  Math.abs(p[i])-1;
        }
        breakPoint++;
        }
        if(match==0) break;
    }
    if(match==1&&abstot==a.length) return 1;
    return 0;
}*/

// re:do:
static int matches (int[]a, int[]p){

    return 0;
}

static int isStacked(int n){
     int valid =0;int sum=1;
     for( int i=2;i<n;i++){
         sum+=i;
         if(sum==n){
             valid=1;
             break;
         }
     }
    return valid;
}
static int isSumSafe(int[ ]a){
    int tot=0;int safe=1;
    if(a.length==0) return 0;
    for( int i:a){
        tot+=i;
    }//sums elements;
    for( int i:a){
         if(i==tot) safe=0;
    }
    return safe;
}
static int isIsolated(long n){
    long sqr=n*n;long cub=n*n*n;int contains=0;
    if(n> 2097151 || n<0) return -1;
    String sqrstr=Long.toString(sqr);
    String cubstr=Long.toString(cub);
    char [] sqrarr=new char[sqrstr.length()];
    char [] cubarr=new char[cubstr.length()];
    for(int s=0;s<sqrstr.length();s++){
        sqrarr[s]=sqrstr.charAt(s);
    }
    for(int c=0;c<cubstr.length();c++){
        cubarr[c]=cubstr.charAt(c);
    }
    for(int i=0;i<sqrarr.length;i++){
        for(int j=0;j<cubarr.length;j++){
                if(sqrarr[i]==cubarr[j]){
                    contains=1;
                    break;//early break if one match is found.
                }
        }
    }
    return contains;
}
static int isIsolated2(long n){
    if(n<0 || n>2097151) return -1;
    long sqr=n*n;long cub=n*n*n;int contains=0;
    long sqrdigit= sqr%10; long cubdigit=cub%10;
    for(int i=0;i<Long.toString(n*n).length();i++){
        for(int j=0;j<Long.toString(n*n*n).length();j++){
            if(cubdigit==sqrdigit) {
                contains = 1;
                break;//a match is found ,break.
            }
            cub=cub/10;
            cubdigit=cub%10;
        }
        sqr= sqr/10 ;
        sqrdigit= sqr%10;
        cub=n*n*n;
        cubdigit=cub%10;
        if(contains==1) break;
    }
return contains;
}
static int isVanilla(int[ ] a){
    class Digit{
        static boolean isSameDigit(String digit,char flag){
            boolean isValid=true;
            for(int i=0;i<digit.length();i++){
                if(flag!=digit.charAt(i)) {
                    isValid=false;
                    break;
                }
            }
            return isValid;
        }
        static char sampleChar(String str){
            return str.charAt(0);
        }
    }
    if(a.length==0) return 1;//nothing to match;
    char sample= Digit.sampleChar( Integer.toString(a[0]));
    boolean isValid=true;
    for(int i=0;i<a.length;i++){
        if(!Digit.isSameDigit(Integer.toString(a[i]),sample)){
            isValid=false;
            break;
        }
    }
    return isValid?1:0;
}
static int isTrivalent (int[ ] a){
    class Arr{
        static boolean contains( int [] arr, int elem){
            boolean has=false;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==elem){
                    has=true;
                    break;
                }
            }
            return has;
        }
    }
    int [] trielem=new int[3];int index=0;
    for(int i=0;i<a.length;i++){
        if(!Arr.contains(trielem,a[i])){
            if(index==3){
                index=-1;
                break;
            }
            trielem[index]=a[i];
            index++;
        }
    }
    if(index==-1 || a.length==0) return 0;boolean isIn=true;
    for(int i=0;i<a.length;i++){
        if( !Arr.contains(trielem,a[i])){
            isIn=false;
            break;
        }
    }
    return isIn?1:0;
}
static int countRepresentations(int numRupees){
    enum Currency {
        ONE(1), TWO(2), FIVE(5),
        TEN(10), TWENTY(20);
        final int note;
        Currency(int note){
            this.note=note;
        }
    }//constants

    return 0;
}
static int isSequentiallyBounded(int[ ] a){
    class Arr{
        static boolean isInAscendingOrder(int [] a){
            int prev=a[0];boolean isValid=true;
            for( int i=1;i<a.length;i++){
                if(prev>a[i]){
                    isValid=false;
                    break;
                }
                prev=a[i];
            }
            return isValid;
        }
       static boolean isOccurenceRight(int []a, int elem){
            int count=0;
            for( int i=0;i<a.length;i++){
                if(elem==a[i]){
                    count++;
                }
            }
            return count>=elem?false:true;
        }
    }
    int isValid=1;
    for( int i=0;i<a.length;i++){
        if(!Arr.isInAscendingOrder(a)){
            isValid=0;
            break;
        }
        if(!Arr.isOccurenceRight(a, a[i])){
            isValid=0;
            break;
        }
    }
    return isValid;
}
static int isMinMaxDisjoint(int[ ] a){
    class Arr{
        static int max( int []a){
            if(a.length==0) return -1;
            int val=a[0];
            for(int i=1;i<a.length;i++)if(val<a[i]) val=a[i];
            return val;
        }
        static int min( int []a){
            if(a.length==0) return -1;
            int val=a[0];
            for(int i=1;i<a.length;i++)if(val>a[i]) val=a[i];
            return val;
        }
        static int occurence(int []a,int elem){
            int count=0;
            for(int i=0;i<a.length;i++)if(a[i]==elem) count++;
            return count;
        }
        static int[] adjecent(int [] a, int elem){
            int[] adj=new int[2];
            for(int i=0;i<a.length;i++){
                 if(elem==a[0]){
                      adj[0]=a[1];
                      break;
                 }
                 if(elem==a[a.length-1]){
                     if(a.length>2) adj[0]=a[i-1];
                     else adj[0]=a[i];
                     break;
                 }
                 if(elem==a[i]){
                     adj[0]=a[i-1];
                     adj[1]=a[i+1];
                     break;
                 }
            }
            return adj;
        }
    }
    return (Arr.max(a)!=Arr.min(a) &&
            Arr.occurence(a, Arr.max(a))==1 &&
            Arr.occurence(a, Arr.min(a))==1 &&
            Arr.adjecent(a,Arr.max(a))[0]!=Arr.min(a) &&
            Arr.adjecent(a,Arr.max(a))[1]!=Arr.min(a)
           )?1:0;
}
//page 21 first question
static int[ ] clusterCompression(int[ ] a){
    if(a.length==0) return new int[]{};//early return, array is len of zero.
    int curr =a[0];int numofcluster=1;
    for(int i=1;i<a.length;i++){
        if(curr!=a[i]){
            numofcluster++;
            curr=a[i];
        }
    }
    int[] clustercomp=new int[numofcluster];
    int index=1;curr =a[0];clustercomp[0]=a[0];
    for(int i=1;i<a.length;i++){
        if(curr!=a[i]){
            clustercomp[index]=a[i];
            curr=a[i];
            index++;
        }
    }
    return clustercomp;
}
static int isRailroadTie(int[ ] a){
    class Arr{
        static boolean isArrNoneZero(int [] a){
            boolean isValid=false;
            for( int i=0;i<a.length;i++){
                if(a[i]!=0){
                    isValid=true;
                }
            }
            return isValid;
        }
        static boolean isZero(int a){
            return a==0?true:false;
        }
        static int[] adjacent(int [] a, int index){
            int [] res;
            if(a.length<2) return new int[]{};//arr with a len less than 2 can't have a neighbor.
            if(index==0){
                res=new int[1];
                res[0]=a[1];
            }else if( index==a.length-1 && a.length>2){
                res=new int[1];
                res[0]=a[a.length-2];
            }else if( index==a.length-1){
                res=new int[1];
                res[0]=a[0];
            }else{
                res=new int[2];
                res[0]=a[index-1];
                res[1]=a[index+1];
            }
            return res;
        }
    }
    int isValid=1;int [] adj;
    if(!Arr.isArrNoneZero(a) || a.length <2) return 0;
    for( int i=0;i<a.length;i++){
        if(Arr.isZero(a[i])){
          adj=Arr.adjacent(a,i);
          if(adj.length<2){
              isValid=0;
              break;
          }
          if(adj[0]==0 || adj[1]==0){
              isValid=0;
              break;
          }
        }else{
            adj=Arr.adjacent(a,i);
            if(adj.length<2){
                if( adj[0]==0){
                    isValid=0;
                    break;
                }
            }else{
                if(adj[0]==0 && adj[1]==0 || adj[0]!=0 && adj[1]!=0){
                    isValid=0;
                    break;
                }
            }
        }
    }
    return isValid;
}
static int fullnessQuotient(int n){
    class NumberSystem{
        static String changeTo(int decimal, int base){
            String number="";int reminder;
            while(true){
                if(decimal==0) break;
                reminder=decimal%base;
                decimal=decimal/base;
                number+=Integer.toString(reminder);
            }
            return NumberSystem.reverse(number);
        }
        private static String reverse(String str){
            String acc="";int end= str.length()-1;
            while(end>=0){
                acc+=str.charAt(end);
                end--;
            }
            return acc;
        }
        static boolean contains(String str, int num){
            return str.contains(Integer.toString(num));

        }
    }
    String [] numbers=new String[8];int index=0;
   for(int i=2;i<=9;i++){
       numbers[i-2]=NumberSystem.changeTo(n,i);
   }//end;
    int count=0;
    for(int i=0;i<numbers.length;i++){
        if(NumberSystem.contains(numbers[i],0)){
            continue;
        }else count++;
    };
    return count;
}
static int isPacked(int[ ] a){
    class Arr{
        static boolean allPositive(int []a){
            boolean isvalid=true;
            for(int i=0;i<a.length;i++)
                if(a[i]<0){
                    isvalid=false;
                    break;
                }
            return isvalid;
        }
        static boolean isInConsecutiveLoc(int[]a){
            boolean valid=true;int counter=0;;
            for(int i=0;i<a.length;i++){
                if(i==0){
                    counter++;
                    continue;
                }
                if(a[i-1]!=a[i]){
                    counter++;
                }
            }
            int [] cons=new int[counter];counter=0;
            for(int i=0;i<a.length;i++){
                if(i==0){
                    cons[counter]=a[i];
                    counter++;
                    continue;
                }
                if(a[i-1]!=a[i]){
                    cons[counter]=a[i];
                    counter++;
                }
            }
            for(int i=0;i<cons.length;i++){
                for(int j=0;j<cons.length;j++){
                    if(i==j) continue;
                    if(cons[i]==cons[j]){
                        valid=false;
                        break;
                    }

                }
            }
            return valid;
        }
        static boolean packed(int []a){
            int counter=1;boolean valid=true;
            return valid;
        }
    }
System.out.println(Arr.packed(a));

    return 1;
}
    
static int isPacked(int[ ] a){
    class Arr{
        static boolean isAllPositive(int []a){
            boolean isvalid=true;
            for(int i=0;i<a.length;i++)
                if(a[i]<0){
                    isvalid=false;
                    break;
                }
            return isvalid;
        }
        static boolean isInConsecutiveLoc(int[]a){
            boolean valid=true;int counter=0;
            for(int i=0;i<a.length;i++){
                if(i==0){
                    counter++;
                    continue;
                }
                if(a[i-1]!=a[i]){
                    counter++;
                }
            }
            int [] cons=new int[counter];counter=0;
            for(int i=0;i<a.length;i++){
                if(i==0){
                    cons[counter]=a[i];
                    counter++;
                    continue;
                }
                if(a[i-1]!=a[i]){
                    cons[counter]=a[i];
                    counter++;
                }
            }
            for(int i=0;i<cons.length;i++){
                for(int j=0;j<cons.length;j++){
                    if(i==j) continue;
                    if(cons[i]==cons[j]){
                        valid=false;
                        break;
                    }

                }
            }
            return valid;
        }
        static boolean packed(int []a){
            int counter=0; boolean valid=true;
            for(int i=0;i<a.length;i++){
                if(i==0){
                    ++counter;
                    if(a.length==1){
                        if(counter!=a[i]){
                            valid=false;
                        }
                    }
                    continue;
                }
                if(a[i]!=a[i-1]){
                    if(counter!=a[i-1]){
                        valid=false;
                        break;
                    }
                    counter=1;
                    if(counter!=a[i] && i==a.length-1){
                        valid=false;
                    }
                }else{
                    ++counter;
                    if(counter!=a[i] && i==a.length-1){
                        valid=false;
                    }
                }
            }
            return valid;
        }
    }
 return (
         Arr.isInConsecutiveLoc(a) &&
         Arr.packed(a) &&
         Arr.isAllPositive(a)
         ) ? 1:0;
}
    static int isOddHeavy(int[] a) {
        boolean isValid = true; int atleast = 0;int currOdd;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                atleast++;
                for (int j = 0; j < a.length; j++) {
                    if (i != j && a[j] % 2 == 0) {
                        if (a[i] < a[j]) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

        }
        return isValid && atleast > 0 ? 1 : 0;
    }
static int getExponent(int n, int p){
        if(p<=1) return -1;
        if(n<0) n=-n;int index=0;
        for(int i=0;i<n;i++){
            int res=1;
            for(int j=0;j<i;j++){
                res*=p;
            };
            if(res>n) break;
            if(n%res==0) {
                index=i;
            }
        }
        return index;
    }
public static void main(String[] args){
   System.out.print(isPacked(new int []{1,2,2,2,4,4,4,4,3,3,3}));
 }

}
