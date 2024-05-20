package com.morty.usercenter.once;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.io.File;
import java.util.List;

/**
 * @author shkstart
 * @create 2024--14 00:16
 */
public class ImportExcel {

    /**
     * 读取数据
     *
     * @param args
     */
    public static void main(String[] args) {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "/Users/morty/IdeaProjects/workspace/user-center/src/main/resources/testExcel.xlsx";
//        readByListener(fileName);
        synchronousRead(fileName);
    }

    /**
     * 监听器读取
     * @param fileName
     */
    public static void readByListener(String fileName) {
        EasyExcel.read(fileName, UserInfo.class, new TableListener()).sheet().doRead();
    }

    /**
     * 同步读取
     */
    public static void synchronousRead(String fileName) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<UserInfo> totalDataList =
                EasyExcel.read(fileName).head(UserInfo.class).sheet().doReadSync();
        for (UserInfo userInfo : totalDataList) {
            System.out.println(userInfo);
        }
    }
}
