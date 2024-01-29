package org.clb.mybatisTest.infusion.parse;

import org.clb.mybatisTest.infusion.parse.pareUtil.ListParse;
import org.clb.mybatisTest.infusion.parse.pareUtil.Parse;
import org.clb.mybatisTest.infusion.parse.pareUtil.StringParse;

import java.util.Map;

public class CommonParse {

    public Map<String, Parse> map;
    public void init(){
        map.put("String",new StringParse() );
        map.put("list",new ListParse() );
    }
    public void parse(String s){
        Parse parse = map.get(s);
        if (parse==null){
            System.out.println("没有这个类型");
            return;
        }
        parse.parse(s);
    }
}
