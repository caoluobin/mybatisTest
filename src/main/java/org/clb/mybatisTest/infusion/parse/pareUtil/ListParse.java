package org.clb.mybatisTest.infusion.parse.pareUtil;

import java.util.List;

public class ListParse implements Parse<List>{
    @Override
    public void parse(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
