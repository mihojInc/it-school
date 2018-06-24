package com.lessons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileUtil.getFile("D:\\Programming training\\Java\\it-school2\\src\\com\\lessons\\File");
        FileUtil.getFiles("D:\\Programming training\\Java\\it-school2\\src\\com\\lessons\\Directory");
        FileUtil.readFile(new File("D:\\Programming training\\Java\\it-school2\\src\\com\\lessons\\File"));
        FileUtil.listFileFromDir(" ");


        List<String> list = new ArrayList<>();
        list.add("Hello ");
        list.add("Alex! ");
        list.add("It's ");
        list.add("me!");
        FileUtil.writeFile(new File("D:\\Programming training\\Java\\it-school2\\src\\com\\lessons\\File"), list);

    }
}
