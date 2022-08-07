import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Leetcode 380.o(1)时间插入、删除和获取随机元素
 * Tag:构造，哈希表，变长数组
 * 
 * @author KureNaii
 * @since 2022-08-05 00:09:54
 */
public class Solution380 {
    class RandomizedSet {
        // 删除和新增时需要搜索且时间复杂度为 O(1)，用哈希表
        // 需要等概率随机 O(1) 取出数据，需要变长数组
        private Map<Integer, Integer> map;
        private Random rand;
        private List<Integer> vector;

        public RandomizedSet() {
            map = new HashMap<>();
            rand = new Random();
            vector = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                vector.add(val);
                map.put(val, vector.size() - 1);
                return true;
            } else {
                return false;
            }
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                int tmp = vector.get(vector.size() - 1);
                vector.set(index, tmp);
                vector.set(vector.size() - 1, val);
                vector.remove(vector.size() - 1);
                map.replace(tmp, index);
                map.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            // 注: rand.nextInt(bond) 中的范围是 [0,bond) return
            return vector.get(rand.nextInt(vector.size()));
        }
    }
}
