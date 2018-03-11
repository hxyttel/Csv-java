package com.csv.common;

import com.csv.bean.Contact;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class WriterCsvDemo {
    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        //从String字符串写进csv
        CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/stu.csv"));
        String[][] stu = new String[][]{
                {"1","a","M"},
                {"2","b","F"},
                {"3","c","M"}
        };
        for(String[] stus :stu){
            writer.writeNext(stus);
        }
        writer.close();

        // 从bean的集合中写出到csv文件
        Writer writer1 = new FileWriter("src/main/resources/ctact.csv");
        StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer1).build();
        List<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact("1","SSD","SDFB","SDFVB","SDFGH"));
        contactList.add(new Contact("2","SDF","WE","WERTHJ","WERTY"));
        statefulBeanToCsv.write(contactList);
        writer1.close();

    }
}
