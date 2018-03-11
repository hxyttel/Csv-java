package com.csv.common;

import com.csv.bean.Contact;
import com.csv.bean.Contact1;
import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//idea的根目录是从项目开始
public class ReadCsvDemo {
    public static void main(String[] args) throws IOException {
        //读取到字符串数组
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/contacts.csv"));
        String [] contact;
        while ((contact = reader.readNext()) != null) {
            //索引[0]代表的是第一个字段
            System.out.println(contact[0] +","+ contact[1]+","+ "etc...");
        }
        reader.close();

        // 读取到字符串数组组成的集和中
        CSVReader reader1 = new CSVReader(new FileReader("src/main/resources/contacts.csv"));
        List<String []> ContactList = reader1.readAll();
        //foreach是迭代器的一种
        for(String[] contact1 :ContactList){
            System.out.println(contact1[0]+","+contact1[1]+",etc....");
        }
        reader1.close();

        //运用集合和迭代器
        CSVIterator iterator = new CSVIterator(new CSVReader(new FileReader("src/main/resources/contacts.csv")));
        for (CSVIterator it = iterator; it.hasNext(); ) {
            String[] nextLine = it.next();
            System.out.println(nextLine [0] + nextLine [1] +"etc ...");
        }

         // 读取到JavaBean， @CsvBindByName
        List <Contact> contactlist1 = new CsvToBeanBuilder(new FileReader("src/main/resources/contacts.csv"))
                .withType(Contact.class).build().parse();
        if (contactlist1 != null && contactlist1.size() > 0) {
            for (Contact contract1 : contactlist1) {
                System.out.println(contract1);
            }
        }
        // 读取到JavaBean， @CsvBindByPositon
        List<Contact1> contact1List2 = new CsvToBeanBuilder(new FileReader("src/main/resources/contacts.csv"))
                .withType(Contact1.class).build().parse();
        if(contact1List2!=null && contact1List2.size()>0){
            for (Contact1 contact2: contact1List2) {
                System.out.println(contact2);

            }
        }

        // 非注解读取到JavaBean中
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Contact.class);
        String[] column = new String[]{"id ","user_name","sex","phone","address"};
        strategy.setColumnMapping(column);
        CsvToBean toBean= new CsvToBean();
        List<Contact> contactList3 =toBean.parse(strategy,new FileReader("src/main/resources/contacts.csv"));
        if(contactList3!=null && contactList3.size()>0){
            for(Contact contact3:contactList3){
                System.out.println("abc..."+contact3);
            }
        }

    }
}
