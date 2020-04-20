import java.util.HashMap;
import java.util.Map;

/**
 * Created by gyy on 2020/4/13.
 */
public class Solution {


    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        String[] m = {"whistory", "historyw", "farewell", "wellfare", "orywhist"};
        int n = 8;
        run(m, n);
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            System.out.println("key: " + maps.getKey() + ", value: " + maps.getValue());

        }
    }


    // m是字符个数，n为字符串长度
    public static void run(String[] m, int n) {

        for (int i = 0; i < m.length; i++) {
            if (i == 0) {
                map.put(m[i], 0);
                continue;
            }
            String s = m[i] + m[i];
            for (int j = 0; j < i; j++) {
                if (s.contains(m[j])) {
                    map.put(m[i], j + 1);
                    break;
                } else {
                    map.put(m[i], 0);
                }
            }


        }

    }

}

//
//* char  2个字节  总共要存储10000*1000*2/1000/1000=20MB，内存是256MB足够
//        * 时间限制3s，这个得看cpu频率以及是否允许多线程计算？？这个我目前没考虑
//        * 可以写个数据结构:map<key,List<图>>
//        *     图：
//        *     分别记录某个char的下一位是啥
//        *      <1>例如 a的下一位是b，c那么指向b,c
//        *      c的下一位是d，e，f指向 c和d,e,f
//        *    key：
//        *    key值为char数组的全部后的异或值（是否可以更好的优化，目前没想到）
//        *    新字符串进来后，先转成char数组，然后求出char数组异或值，利用key获取列表图
//        *    开始取列表里第一个图，找到图的某个数据（是否可以用map方式？）和char[]第一个值相同，然后依次走图的路径，是否能走完，能走完返回图出现的情况
//        *    不能走完，遍历列表下一个图。发现都没有，就返回0，并添加到map（key，List<图>）里


