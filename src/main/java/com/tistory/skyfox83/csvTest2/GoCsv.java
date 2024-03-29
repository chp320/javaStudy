package com.tistory.skyfox83.csvTest2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GoCsv {

    private String filePath;
    private BufferedReader bufferedReader;
    private List<String[]> readCSV;

    private int index;

    public GoCsv(String filePath) throws IOException {
        this.filePath = filePath;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath),"UTF-8"));
        readCSV = new ArrayList<>();

        makeList(bufferedReader);
        this.index = 0 ;
    }

    public void makeList(BufferedReader bufferedReader) throws IOException {
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineContents = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",-1);

            readCSV.add(lineContents);
        }
    }

    public String[] nextRead() {
        if (readCSV.size() == index) {
            return null;
        }
        return readCSV.get(index++);
    }
}
