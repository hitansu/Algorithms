package World_CodeSprint_8_hack_ans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PrimeDigitSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> primes = create();
		ArrayList<Integer> data = new ArrayList<Integer>();

		int[][] map = new int[1000][2];
		int count = 0;
		long mod = 1000000007;
		long[] result = new long[1000000];

		for (int i = 2; i < 100000; i++) {
			boolean correct = true;
			correct &= primes.contains(sum(i));
			correct &= primes.contains(sum(i % 10000));
			correct &= primes.contains(sum(i % 1000));

			int k = i / 10;

			correct &= primes.contains(sum(k));
			correct &= primes.contains(sum(k % 1000));
			correct &= primes.contains(sum(k / 10));

			if (correct) {
				data.add(i);
			}
		}

		int[] tab = new int[10000];
		long[][] mat = new long[100][400];
		int index = 0;

		for (int i = 0; i < 10000; i++) {
			tab[i] = -1;
		}

		for (Integer a : data) {
			int u = a % 10000;

			if (tab[u] == -1) {
				tab[u] = index++;
			}

			if (a > 10000) {
				mat[5][tab[u]]++;
			}
		}

		boolean[] used = new boolean[100000];

		for (Integer a : data) {
			int u = a % 10000;

			if (used[u]) {
				continue;
			} else {
				used[u] = true;
			}

			for (Integer b : data) {
				if (u == b / 10) {
					map[count][0] = tab[u];
					map[count][1] = tab[b % 10000];
					count++;
				}
			}
		}

		int next = 0;
		int prev = 0;

		for (int i = 5; i < 404040; i++) {
			next = (i + 1) % 10;
			prev = i % 10;

			for (int j = 0; j < count; j++) {
				int a = map[j][0];
				int b = map[j][1];
				mat[next][b] += mat[prev][a];
			}

			long total = 0;

			for (int j = 0; j < 250; j++) {
				mat[next][j] %= mod;
				total += mat[next][j];
				mat[prev][j] = 0;
			}

			result[i + 1] = total % mod;
		}

		int q = sc.nextInt();

		result[1] = 9;
		result[2] = 90;
		result[3] = 303;
		result[4] = 280;
		result[5] = 218;

		for (int i = 0; i < q; i++) {
			int u = sc.nextInt();
			System.out.println(result[u]);
		}
	}

	static int sum(int n) {
		int result = 0;

		while (n > 0) {
			result += n % 10;
			n /= 10;
		}

		return result;
	}

	static HashSet<Integer> create() {
		HashSet<Integer> primes = new HashSet<Integer>();

		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		primes.add(17);
		primes.add(19);
		primes.add(23);
		primes.add(29);
		primes.add(31);
		primes.add(37);
		primes.add(41);
		primes.add(43);

		return primes;
	}
}
