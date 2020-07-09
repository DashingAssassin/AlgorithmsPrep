package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Knapsack {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out, false);

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int maxKnapSackWeight = Integer.parseInt(br.readLine());
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int[] knapSackWeight = new int[size];
			int[] knapSackValue = new int[size];
			for (int j = 0; j < size; j++) {
				knapSackWeight[j] = Integer.parseInt(st1.nextToken());
				knapSackValue[j] = Integer.parseInt(st2.nextToken());
			}

			int[][] result = new int[size + 1][maxKnapSackWeight + 1];

			calculateKnapsackValues(result, size, knapSackWeight, knapSackValue, maxKnapSackWeight);
			System.out.println(result[size][maxKnapSackWeight]);
		}
		pw.flush();

	}

	private static void calculateKnapsackValues(int[][] result, int size, int[] knapSackWeight, int[] knapSackValue,
			int maxWeight) {

		for (int i = 0; i <= knapSackWeight.length; i++) {

			for (int w = 0; w <= maxWeight; w++) {
				if (i == 0 || w == 0) {
					result[i][w] = 0;
					continue;
				}

				// if current knapSackWeight is less than total weight
				if (knapSackWeight[i - 1] <= w) {
					result[i][w] = Math.max(result[i - 1][w],
							knapSackValue[i - 1] + result[i - 1][w - knapSackWeight[i - 1]]);
				} else {
					result[i][w] = result[i - 1][w];
				}

			}
		}

	}

}
