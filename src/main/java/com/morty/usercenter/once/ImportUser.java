package com.morty.usercenter.once;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 导入用户到数据库
 *
 * @author shkstart
 * @create 2024--14 23:45
 */
public class ImportUser {
    public static void main(String[] args) {
//        String fileName = "/Users/morty/IdeaProjects/workspace/user-center/src/main/resources/testExcel.xlsx";
        String fileName = "/Users/morty/IdeaProjects/workspace/user-center/src/main/resources/prodExcel.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<UserInfo> userInfoList =
                EasyExcel.read(fileName).head(UserInfo.class).sheet().doReadSync();
        System.out.println("总数 = " + userInfoList.size());
        Map<String, List<UserInfo>> listMap =
                userInfoList.stream()
                        .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
                        .collect(Collectors.groupingBy(UserInfo::getUsername));
        for (Map.Entry<String, List<UserInfo>> stringListEntry : listMap.entrySet()) {
            if (stringListEntry.getValue().size() > 1){
                System.out.println("username = " + stringListEntry.getKey());
                System.out.println("1");
            }
        }
        System.out.println("不重复到名称数 = " + listMap.keySet().size());
    }
}
