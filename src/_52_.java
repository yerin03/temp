import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _52_ {

    public int[] solution(String[] gems){

        // 1.보석 종류 파악하기
        HashSet<String> set = new HashSet<>();
        for (String gem : gems){
            set.add(gem);
        }

        // 2.찾아야 하는 보석 종류 파악하기
        int total = set.size(); // 보석의 총 종류 수
        HashMap<String, Integer> gemCount = new HashMap<>();

        int start = 0, end = 0;
        int length = Integer.MAX_VALUE;
        int r_start =0, r_end = 0;

        while(end < gems.length) {

            //key:value
            gemCount.put(gems[end],gemCount.getOrDefault(gems[end],0) + 1);

            //이제 구간 내에 모든 보석 종류가 하나 있을 경우
            while (gemCount.size() == total && start<=end){
                if(end - start < length){
                    length = end - start;
                    r_start = start;
                }

                if(gemCount.get(gems[start]) == 1){
                    gemCount.remove(gems[start]);
                } else {
                    gemCount.put(gems[start],gemCount.get(gems[start])-1);
                }
                start ++;
            }
            end ++;
        }

        return new int[]{r_start + 1, r_start + length + 1};


    }



}
