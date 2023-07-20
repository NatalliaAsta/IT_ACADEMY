package lesson8.main;

import lesson8.mylist.MyArrayList;
import lesson8.mylist.MyList;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void run() {

        MyList<Integer> myArr = new MyArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            myArr.add(i);
        }

        System.out.println("size : " + myArr.size());
        print(myArr);

        System.out.println("add 8");
        myArr.add(4, 8);
        System.out.println("after add size : " + myArr.size());
        print(myArr);

        System.out.println("remove " + myArr.remove(9));
        System.out.println("after remove size : " + myArr.size());
        print(myArr);

        System.out.println("set " + myArr.set(5, 9));
        print(myArr);

        System.out.println("addAll");
        List<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            myArr.add(i);
        }
        myArr.addAll(arrList);
        print(myArr);
    }

    private static void print(MyList<Integer> myArr) {
        for (int i = 0; i < myArr.size(); i++) {
            System.out.println(myArr.get(i));
        }
    }
}

