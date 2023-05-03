package Hash_Table;

import java.util.*;

/*
        * LEETCODE: 609. Find Duplicate File in System
        * https://leetcode.com/problems/find-duplicate-file-in-system/
 */

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        // logic is to store the content as key and
        // store the paths as value in the hashmap
        for (String path : paths) {
            String[] file = path.split(" ");
            String root = file[0] + "/";
            for (int i = 1; i < file.length; i++) {
                int open = file[i].indexOf('(');
                String content = file[i].substring(open, file[i].length() - 1);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(root + file[i].substring(0, open));
            }
        }

        // then add in list which have more than 1 paths
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }

        // calling garbage collection to free up space,
        // but this might slow the code, can avoid this
        System.gc();
        return res;
    }
}
