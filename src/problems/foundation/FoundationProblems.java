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
	
	public 
	
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
		
		
		
		scn.close();
	}

}
