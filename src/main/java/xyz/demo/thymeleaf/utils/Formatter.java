package xyz.demo.thymeleaf.utils;

import xyz.demo.thymeleaf.entity.Product;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class Formatter {

    public static List<List<Product>> groupBy(List<Product> list, int n) {
        int len = list.size();
        List<List<Product>> output = new Vector<>();
        Iterator<Product> iter = list.iterator();

        for(int i = 0; i < len / n + len % n; i++) {
            List<Product> aux = new Vector<>();

            for(int j = 0; j < n; j++)
                if(iter.hasNext()) aux.add(iter.next());

            output.add(aux);
        }

        return output;
    }
}
