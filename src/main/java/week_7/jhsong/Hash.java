package week_7.jhsong;

import java.util.ArrayList;

/*
    해시 함수: 임의의 데이터를 받아, 해당 데이터를 고정된 길이의 특정 값으로 반환
 */
public class Hash {
    ArrayList<ArrayList<Integer>> table = new ArrayList<>();
    final int MAX_HASH_SIZE = 10;

    public void solution() {
        int[] arr = {17, 26, 32, 5, 11, 12, 6, 8, 9};

        // 초기화
        for (int i=0; i<MAX_HASH_SIZE; i++) {
            table.add(new ArrayList<>());
        }

        for (int i: arr) {
            int index = hashFunction(i);
            table.get(index).add(i);
        }

        // 출력
        for(int i=0; i<MAX_HASH_SIZE; i++) {
            System.out.printf("%2d 번째: ", i+1);
            for (Integer v: table.get(i)) {
                System.out.printf("%d ", v);
            }
            System.out.println();
        }
    }

    // 가장 효율적이기 위해서는 데이터가 겹치지 않게 함수를 만들어야 함
    public int hashFunction(int value) {
//        return (6 * value + 2) % MAX_HASH_SIZE;
//        return (5 * value + 5) % MAX_HASH_SIZE;
//        return (4 * value + 8) % MAX_HASH_SIZE;
        return (3 * value + 1) % MAX_HASH_SIZE; // 정답
//        return (2 * value + 11) % MAX_HASH_SIZE;

    }

    public static void main(String[] args) {
        Hash hash = new Hash();
        hash.solution();
    }
}
