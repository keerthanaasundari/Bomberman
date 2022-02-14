package com.program;

import java.util.Scanner;

public class Program3 {
	
	public static void print(char[][] Map,int N) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
					System.out.print(Map[i][j]+"\t");
			
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		int N;
		System.out.println("Enter Map Size");
		N=new Scanner(System.in).nextInt();
		char[][] Map=new char[N][N];
		System.out.println("Player Position");
		char[] userPosition =new Scanner(System.in).nextLine().toCharArray();
		Map[(userPosition[0]-65)+1][(userPosition[1]-65)+1]='P';
		System.out.println("Key Position");
		char[] keyPosition =new Scanner(System.in).nextLine().toCharArray();
		Map[(keyPosition[0]-65)+1][(keyPosition[1]-65)+1]='K';
		System.out.println("Villain count");
		int vCount =new Scanner(System.in).nextInt();
		String[] vPosition=new String[vCount];
		for(int i=0;i<vCount;i++) {
			System.out.println("V"+(i+1)+":");
			vPosition[i]=new Scanner(System.in).nextLine();
			Map[((vPosition[i].charAt(0))-65)+1][(vPosition[i].charAt(1)-65)+1]='V';
		}
		System.out.println("Brick count");
		int bCount =new Scanner(System.in).nextInt();
		String[] bPosition=new String[bCount];
		for(int i=0;i<bCount;i++) {
			System.out.println("B"+(i+1)+":");
			bPosition[i]=new Scanner(System.in).nextLine();
			Map[((bPosition[i].charAt(0))-65)+1][(bPosition[i].charAt(1)-65)+1]='B';
		}
		char ch1='A';
		char ch2='A';
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==0 && j==0)
					 continue;
				else if(i==0 && j!=0) {
					Map[i][j]=ch1;
					ch1=(char) (ch1+1);
				}else
				if(j==0 && i!=0) {
					Map[i][j]=ch2;
					ch2=(char)(ch2+1);
				}
				
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				if(j==1 || i==1 || i==N-1 || j==N-1) {
					Map[i][j]='*';
			} 
				 if(i%2 !=0 && j%2 !=0) {
					 Map[i][j]='*'; 
				 }
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
					System.out.print(Map[i][j]+"\t");
			
			}
			System.out.println("\n");
		}
		int choice=1;
		do {
		System.out.println("W - Move up"+"\n"+"S - Move down"+"\n"+"A - Move left"+"\n"
		                   +"D - Move right"+"\n"+
		                     "Q - Move diagonally up left"+"\n"+
		                     "Z - Move diagonally down left" +"\n"+
		                     "E - Move diagonally up right" +"\n" +
		                     "C - Move diagonally down right"+"\n"+
		                     "X - Bomb"+"\n"+
		                     "0 to Quit game");
		String direction=new Scanner(System.in).next();
		char option=direction.charAt(0);
		int i=userPosition[0]-65+1;
		int j=userPosition[1]-65+1;
		switch(option){
		case 'C':
			if(Map[i+1][j+1]=='*' || Map[i+1][j+1]=='B') 
			{
				System.out.println("Cant move");
			}
			else if(Map[i+1][j+1]=='V') 
			{
				System.out.println("Player Dies");
				return ;
			}else if(Map[i+1][j+1]!='X'){
				Map[i][j]=' ';
				Map[i+1][j+1]='P';
				print(Map, N);
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				int action=new Scanner(System.in).nextInt();
				if(action==1) {
					Map[i+1][j+1]='X';
					Map[i][j]='P';	
					print(Map, N);
				}
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				action=new Scanner(System.in).nextInt();
				if(action==2) {
					if(Map[(i+1)+1][(j+1)]=='B')
						Map[(i+1)+1][(j+1)]=' ';
					if(Map[(i+1)-1][(j+1)]=='V')
						Map[(i+1)-1][(j+1)]=' ';
					if(Map[(i+1)][(j+1)+1]=='B')
					    Map[(i+1)][(j+1)+1]=' ';
					if(Map[(i+1)][(j+1)-1]=='V')
					Map[(i+1)][(j+1)-1]=' ';
					if(Map[(i+1)][(j+1)-1]=='P'|| Map[(i+1)+1][(j+1)]=='P' || Map[(i+1)-1][(j+1)]=='P'
							|| Map[(i+1)][(j+1)+1]=='P') {
						System.out.println("Player Dies");
						return ;
					}
					Map[i+1][j+1]=' ';
					print(Map, N);
				}
			}
			break;
		case 'S':
			if(Map[i-1][j]=='*' || Map[i-1][j]=='B') 
			{
				System.out.println("Cant move");
			}
			else if(Map[i-1][j]=='V') 
			{
				System.out.println("Player Dies");
				return ;
			}else if(Map[i-1][j]!='X'){
				Map[i][j]=' ';
				Map[i-1][j]='P';
				print(Map, N);
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				int action=new Scanner(System.in).nextInt();
				if(action==1) {
					Map[i-1][j]='X';
					Map[i][j]='P';	
					print(Map, N);
				}
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				action=new Scanner(System.in).nextInt();
				if(action==2) {
					if(Map[(i-1)+1][j]=='B')
						Map[(i+1)+1][j]=' ';
					if(Map[(i-1)-1][j]=='V')
						Map[(i-1)-1][j]=' ';
					if(Map[(i-1)][j+1]=='B')
					    Map[(i-1)][j+1]=' ';
					if(Map[(i-1)][j-1]=='V')
					Map[(i-1)][j-1]=' ';
					if(Map[(i-1)][j-1]=='P'|| Map[(i-1)+1][(j)]=='P' || Map[(i-1)-1][(j)]=='P'
							|| Map[(i-1)][j+1]=='P') {
						System.out.println("Player Dies");
						return ;
					}
					Map[i+1][j+1]=' ';
					print(Map, N);
				}
			}
			break;
		case 'A':
			if(Map[i][j-1]=='*' || Map[i][j-1]=='B') 
			{
				System.out.println("Cant move");
			}
			else if(Map[i][j-1]=='V') 
			{
				System.out.println("Player Dies");
				return ;
			}else if(Map[i][j-1]!='X'){
				Map[i][j]=' ';
				Map[i][j-1]='P';
				print(Map, N);
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				int action=new Scanner(System.in).nextInt();
				if(action==1) {
					Map[i][j-1]='X';
					Map[i][j]='P';	
					print(Map, N);
				}
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				action=new Scanner(System.in).nextInt();
				if(action==2) {
					if(Map[i+1][(j-1)]=='B')
						Map[i+1][(j-1)]=' ';
					if(Map[(i)-1][(j-1)]=='V')
						Map[(i)-1][(j-1)]=' ';
					if(Map[(i)][(j-1)+1]=='B')
					    Map[(i)][(j-1)+1]=' ';
					if(Map[(i)][(j-1)-1]=='V')
					Map[(i)][(j-1)-1]=' ';
					if(Map[i][(j-1)-1]=='P'|| Map[(i)+1][(j-1)]=='P' || Map[(i)-1][(j-1)]=='P'
							|| Map[(i)][(j-1)+1]=='P') {
						System.out.println("Player Dies");
						return ;
					}
					Map[i][j-1]=' ';
					print(Map, N);
				}
			}
			break;
		case 'D':
			if(Map[i][j+1]=='*' || Map[i][j+1]=='B') 
			{
				System.out.println("Cant move");
			}
			else if(Map[i][j+1]=='V') 
			{
				System.out.println("Player Dies");
				return ;
			}else if(Map[i][j+1]!='X'){
				Map[i][j]=' ';
				Map[i][j+1]='P';
				print(Map, N);
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				int action=new Scanner(System.in).nextInt();
				if(action==1) {
					Map[i][j+1]='X';
					Map[i][j]='P';	
					print(Map, N);
				}
				System.out.println("1. Plant"+"\n"+ "2. Detonate");
				action=new Scanner(System.in).nextInt();
				if(action==2) {
					if(Map[i+1][j+1]=='B')
						Map[i+1][j+1]=' ';
					if(Map[i-1][(j+1)]=='V')
						Map[i-1][(j+1)]=' ';
					if(Map[(i)][(j+1)+1]=='B')
					    Map[(i)][(j+1)+1]=' ';
					if(Map[(i)][(j+1)-1]=='V')
					    Map[(i)][(j+1)-1]=' ';
					if(Map[(i)][(j+1)-1]=='P'|| Map[i+1][(j+1)]=='P' || Map[i-1][(j+1)]=='P'
							|| Map[(i)][(j+1)+1]=='P') {
						System.out.println("Player Dies");
						return ;
					}
					Map[i][j+1]=' ';
					print(Map, N);
				}
			}
			break;
		case 'Q':
		case 'Z':
		case 'E':
		case 'W':
			
		}
		}while(choice!=0);
	}

	

}
