package recursion;

import java.util.*;
import java.util.stream.Stream;

public class Sort {

    public void sort(List<Integer> arr){
        if (arr.size() == 1){
            return;
        }
        int temp = arr.remove(arr.size()-1);
        sort(arr);
        merge(arr, temp);
    }

    public void merge(List<Integer> lst, int element){
        if (lst.size() == 0 || lst.get(lst.size()-1) < element){
            lst.add(element);
            return;
        }
        int temp = lst.remove(lst.size()-1);
        merge(lst, element);
        lst.add(temp);
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        List<Integer> lst = new ArrayList<>();
        Stream.of(1, 5, 4, 2, 3).forEach(val -> lst.add(val));
        sort.sort(lst);
        System.out.println(lst);
    }

}
