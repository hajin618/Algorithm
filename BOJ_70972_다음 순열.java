import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		nextPermutation();
		
	}
	
	public static void nextPermutation() {
		int idx = N-1;
		
		while(idx>0 && arr[idx-1] > arr[idx])
			idx--;
		
		// idx == 0이면 마지막 순열
		if(idx == 0) {
			System.out.println("-1");
			return;
		}
		
		// 해당 인덱스 기준 좌/우 나누기
		// 좌 가장 오른쪽 숫자에 대하여 우 오른쪽 지점부터 큰 수 찾기
		int big_idx = N-1;
		while(big_idx > idx && arr[idx-1] > arr[big_idx])
			big_idx--;
		
		// 찾은 후 swap
		int tmp = arr[idx-1];
		arr[idx-1] = arr[big_idx];
		arr[big_idx] = tmp;
		
		// 우 부분 정렬
		Arrays.sort(arr, idx, N);
		
		for(int i=0; i<N; i++)
			System.out.print(arr[i] + " ");
	}
}
