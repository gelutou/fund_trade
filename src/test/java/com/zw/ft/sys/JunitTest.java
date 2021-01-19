package com.zw.ft.sys;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.ReUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zw.ft.common.utils.R;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName JunitTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/11/4 11:09
 * @Version 1.0
 **/
public class JunitTest {

    @Test
    public void getYesterday(){
        String result = "{\"status\":0,\"msg\":\"ok\",\"result\":[{\"id\":1,\"name\":\"北京\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"010\",\"zipcode\":\"100000\",\"depth\":1},{\"id\":2,\"name\":\"安徽\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":\"\",\"depth\":1},{\"id\":3,\"name\":\"福建\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":4,\"name\":\"甘肃\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":5,\"name\":\"广东\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":6,\"name\":\"广西\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":7,\"name\":\"贵州\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":8,\"name\":\"海南\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":9,\"name\":\"河北\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":10,\"name\":\"河南\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"\",\"zipcode\":null,\"depth\":1},{\"id\":11,\"name\":\"黑龙江\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"\",\"zipcode\":null,\"depth\":1},{\"id\":12,\"name\":\"湖北\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":13,\"name\":\"湖南\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":14,\"name\":\"吉林\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"\",\"zipcode\":null,\"depth\":1},{\"id\":15,\"name\":\"江苏\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":16,\"name\":\"江西\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":17,\"name\":\"辽宁\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":18,\"name\":\"内蒙古\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":19,\"name\":\"宁夏\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":20,\"name\":\"青海\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":21,\"name\":\"山东\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":22,\"name\":\"山西\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":23,\"name\":\"陕西\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":24,\"name\":\"上海\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"021\",\"zipcode\":\"200000\",\"depth\":1},{\"id\":25,\"name\":\"四川\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":26,\"name\":\"天津\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"022\",\"zipcode\":\"300000\",\"depth\":1},{\"id\":27,\"name\":\"西藏\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":28,\"name\":\"新疆\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":29,\"name\":\"云南\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":30,\"name\":\"浙江\",\"parentid\":0,\"parentname\":\"\",\"areacode\":null,\"zipcode\":null,\"depth\":1},{\"id\":31,\"name\":\"重庆\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"023\",\"zipcode\":\"404100\",\"depth\":1},{\"id\":32,\"name\":\"香港\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"00852\",\"zipcode\":\"999077\",\"depth\":1},{\"id\":33,\"name\":\"澳门\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"00853\",\"zipcode\":\"999078\",\"depth\":1},{\"id\":34,\"name\":\"台湾\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"00886\",\"zipcode\":null,\"depth\":1},{\"id\":51,\"name\":\"国外\",\"parentid\":0,\"parentname\":\"\",\"areacode\":\"\",\"zipcode\":null,\"depth\":1}]}";
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray resultArray = jsonObject.getJSONArray("result");
        System.out.println("resultArray.size() = " + resultArray.size());
        for(int i=0;i<resultArray.size();i++){
            JSONObject jsonObject1 = resultArray.getJSONObject(i);
            System.out.println("jsonObject1 = " + jsonObject1);
        }
    }
}
