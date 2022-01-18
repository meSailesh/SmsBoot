package com.javaWithSpringCourse.smsBoot.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sailesh on 1/6/22.
 */
public class FileUtil {

    public static String saveRecordsToFile(String fileName, String record) {
        try{
            FileWriter fileWriter = new FileWriter(fileName, true);
            String newRecord = (record != null && !record.isEmpty()) ? record.concat("\n") : record;
            fileWriter.write(newRecord);
            fileWriter.close();
            return  record;
        } catch (IOException e) {
            System.out.println("Error while saving records to file");
            e.printStackTrace();
        }
        return null;
    }

    public static String overrideRecordsToFile(String fileName, String record) {
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            String newRecord = (record != null && !record.isEmpty()) ? record.concat("\n") : record;
            fileWriter.write(newRecord);
            fileWriter.close();
            return  record;
        } catch (IOException e) {
            System.out.println("Error while saving records to file");
            e.printStackTrace();
        }
        return null;
    }



    public static Integer  getLastUniqueIdentifier(String fileName) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String lastLine = null;
            while(bufferedReader.ready()) {
                lastLine = bufferedReader.readLine();
            }

            if(lastLine != null && !lastLine.isEmpty()) {
                String[] fields = lastLine.split(",");
                return  Integer.parseInt(fields[0]);

            }
            return  0;
        } catch (IOException e) {
            System.out.println("Error reading the file " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error encoundered while parsing primary key");
        }
        return  null;
    }

    public static String  getRecordByKey(String fileName, Integer key) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] fields = line.split(",");
                if(Integer.parseInt(fields[0]) == key) {
                    return  line;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error encoundered while parsing primary key");
        }
        return  null;
    }

    public static String  getRecordByKeyAndIndex(String fileName, Integer key, Integer index) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if(!line.isEmpty()) {
                    String[] fields = line.split(",");
                    if(Integer.parseInt(fields[index]) == (key)) {
                        stringBuilder.append(line);
                        stringBuilder.append(System.lineSeparator());
                    }
                }
            }
            return  stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("Error reading the file " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error encoundered while parsing primary key");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Please specify valid index");
        }
        return  null;
    }

    public static String  getRecordByName(String fileName, String name) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if(!line.isEmpty()) {
                    String[] fields = line.split(",");
                    if(fields[1].equalsIgnoreCase(name)) {
                        stringBuilder.append(line);
                        stringBuilder.append(System.lineSeparator());
                    }
                }
            }
            return  stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("Error reading the file " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error encoundered while parsing primary key");
        }
        return  null;
    }

    public static String  getRecords(String fileName) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());

            }
            return  stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("Error reading the file " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error encoundered while parsing primary key");
        }
        return  null;
    }
}


//counter 0
// counter 1
// counter 2
