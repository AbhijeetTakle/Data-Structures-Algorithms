package problems.foundation;

import java.util.Scanner;

public class FoundationProblems {

	public void printFibonacci(int n) {
		int a=0,b=1;
		System.out.print(a+" "+b+" ");
		while(a+b<=n) {
			System.out.print(a+b+" ");
			int temp = a;
			a = b;
			b = temp + b;
		}
	}
	
	public int countDigits(long n) {
		int count = 0;
		while(n!=0) {
				count++;
				n/=10;
		}
		return count;
	}
	
	public void digitsOfNumber(long n) {
		 long temp = n;
		 int p = 0;
		 while(temp/10 != 0) {
			 temp /= 10;
			 p++;
		 }
		 while(p>=0) {
			 temp = n;
			 temp/=Math.pow(10, p);
			 p--;
			 System.out.print(temp%10+" ");
		 }
	}
	
	public int reverseNumber(int n) {		
		long temp = n;
		int p = 0;
		while(temp/10 != 0) {
			temp /= 10;
			p++;
		}temp = n;
		int newn = 0;
		int r = 0;
		while(p>=0) {
			temp = n;
			temp/=Math.pow(10, p);
			newn += (temp%10)*Math.pow(10, r++);
			p--;
		}
		return newn;
	}
	
	public int inverseFaceValue(int n) {
		int temp = n,newn = 0,i = 1;
		while(temp!=0) {
			newn += i*Math.pow(10, temp%10-1);
			temp/=10;
			i++;
		}
		return newn;
	}
	
	public int rotateNumber(int n, int k) {
		int temp = n,p = 0,r=0;
		p = countDigits(temp);
		if(Math.abs(k)>=p) {
			r=Math.abs(k)-p;
		}else {
			r=Math.abs(k);
		}
		while(r!=0) {
			if(k>0) {
				temp = (temp/10)+((temp%10)*(int)Math.pow(10, p-1));
			}else {
				int w = (temp/(int)Math.pow(10, p-1));
				temp = (temp-(w*(int)Math.pow(10, p-1)))*10 + w;
			}
			r--;
		}
		return temp;		
	}
	
	public int findGCD(int a, int b) {
		int n1 = a, n2 = b;
		while(n1%n2 != 0) {
			int rem = n1%n2;
			n1 = n2;
			n2 = rem;
		}
		return n2;
	}
	
	public int findLCM(int a, int b) {
		int gcd = findGCD(a,b);
		int lcm  = (a*b)/gcd;
		return lcm;
	}
	
	public boolean isPrime(int n) {
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public void printPrimeFactors(int n) {
		int temp = n,f=0;
		while(temp!=1) {
			for(int i=2; i<=temp; i++) {
				if(isPrime(i)&&temp%i==0) {
					f=i;
					break;
				}
			}
			System.out.print(f+" ");
			temp/=f;
		}
	}
	
	public int decimal2AnyBase(int n, int b) {
		int n1 = 0;
		for(int i=0; n>0; i++) {
			n1 += (n%b)*Math.pow(10, i);
			n/=b;
		}
		return n1;
	}
	
	public int anyBase2Decimal(int n, int b) {
		int n1 = 0;
		for(int i=0; n>0; i++) {
			n1 += (n%10)*Math.pow(b, i);
			n/=10;
		}
		return n1;
	}
	
	public int anyBase2AnyBase(int n, int b1, int b2) {
		int n1 = anyBase2Decimal(n, b1);
		n1 = decimal2AnyBase(n1, b2);
		return n1;
	}
	
	public int anyBaseAddition(int n1, int n2, int b) {
		int c=0, s=0, sum = 0, i=0;
		int max = n1>n2 ? n1 : n2;
		while(max>0) {
			s = (n1%10)+(n2%10)+c;
			sum += (s%b)*Math.pow(10, i++);
			if(s>=b) {
				c=1;
			}else {
				c=0;
			}
			n1/=10;
			n2/=10;
			max/=10;
		}
		sum += (c+n1+n2)*Math.pow(10, i++);
		return sum;		
	}
	
	public int anyBaseSubtraction(int n1, int n2, int b) {
		 int c=0, s=0, i=0, sum=0;
		 int min = n1<n2 ? n1:n2;
		 int max = n1>n2 ? n1:n2;
		 while(min>0) {
			 s = (max%10) - (min%10) + c;
			 if(s<0) {
				 sum += (s+b)*Math.pow(10, i++);
				 c=-1;
			 }else {
				 sum += s*Math.pow(10, i++);
				 c=0;
			 }
			 max/=10;
			 min/=10;
		 }
		 sum += (c + max + min)*Math.pow(10, i++);
		 return sum;
	}
	
	public int anyBaseMultilication(int n1, int n2, int b) {
		int s=0, sum=0, j=0, c=0, i=0, mul=0;
		while(n1>0) {
			s = n2;
			c=0;
			for(i=j++; s>0; i++) {
				System.out.println(s%10+" "+n1%10+" "+c);
				sum += (((n1%10)*(s%10)+c)%b)*Math.pow(10, i);
				System.out.println(sum);
				c=((n1%10)*(s%10)+c)/b;
				s/=10;
			}
			sum += (c%b)*Math.pow(10, i);
			mul = anyBaseAddition(mul, sum, b);
			sum = 0;
			n1 /= 10;			
		}
		return mul;
	}
	
	public int factorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		FoundationProblems fp = new FoundationProblems();
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		fp.printFibonacci(n);
		
//		long n = scn.nextLong();
//		fp.countDigits(n);
		
//		long n = scn.nextLong();
//		fp.digitsOfNumber(n);
		
//		int n = scn.nextInt();
//		fp.reverseNumber(n);
		
//		int n = scn.nextInt();
//		fp.inverseFaceValue(n);
		
//		int n = scn.nextInt();
//		int k = scn.nextInt();
//		System.out.println(fp.rotateNumber(n, k));
		
//		int a = scn.nextInt();
//		int b = scn.nextInt();
//		System.out.println("GCD= "+fp.findGCD(a, b)+"LCM= "+fp.findLCM(a, b));
		
//		int n = scn.nextInt();
//		fp.printPrimeFactors(n);
		
//		int n = scn.nextInt();
//		int b = scn.nextInt();
//		System.out.println(fp.decimal2AnyBase(n, b));
		

//		int n = scn.nextInt();
//		int b = scn.nextInt();
//		System.out.println(fp.anyBase2Decimal(n, b));
		

//		int n = scn.nextInt();
//		int b1 = scn.nextInt();
//		int b2 = scn.nextInt();
//		System.out.println(fp.anyBase2AnyBase(n, b1, b2));
		

//		int n1 = scn.nextInt();
//		int n2 = scn.nextInt();
//		int b = scn.nextInt();
//		System.out.println(fp.anyBaseAddition(n1, n2, b));
		
//		int n1 = scn.nextInt();
//		int n2 = scn.nextInt();
//		int b = scn.nextInt();
//		System.out.println(fp.anyBaseSubtraction(n1, n2, b));
		
//		int n1 = scn.nextInt();
//		int n2 = scn.nextInt();
//		int b = scn.nextInt();
//		System.out.println(fp.anyBaseMultilication(n1, n2, b));
		
		int n = scn.nextInt();
		System.out.println(fp.factorial(n));
		
		scn.close();
	}

}
