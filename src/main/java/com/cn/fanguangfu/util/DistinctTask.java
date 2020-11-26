package com.cn.fanguangfu.util;

import com.cn.fanguangfu.vo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
public class DistinctTask extends RecursiveTask<List<Student>> {
    private static final int THRESHOLD_NUM = 5000;

    private int start,end;

    private List<Student> dbData;

    private List<Student> genlist;


    public DistinctTask(int start, int end, List<Student> dbData, List<Student> genlist) {
        this.start = start;
        this.end = end;
        this.dbData = dbData;
        this.genlist = genlist;
    }

    @Override
    protected List<Student> compute() {
        genlist = genlist.subList(start,end);
        int size = genlist.size();
        if (size<=THRESHOLD_NUM){
            List<Student> repet = new ArrayList<>();
            for (Student s: genlist) {
                String name = s.getName();
                if (ArrayListUtil.isInclude(dbData,name)){
                    repet.add(s);
                }
            }
            return repet;
        } else {
            int middle = (start+end)/2;
            DistinctTask left = new DistinctTask(start,middle,dbData,genlist);
            DistinctTask right = new DistinctTask(middle+1,end,dbData,genlist);
            left.fork();
            right.fork();
            List<Student> lre = left.join();
            List<Student> rre = right.join();
            lre.addAll(rre);
            return lre;
        }
    }
}
