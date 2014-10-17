package jm.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class GetSource {

    public static Object[][] getRunData(File file) {
        List<String> results = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String value = null;
            while ((value = reader.readLine()) != null) {
                results.add(value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Object[][] files = new Object[results.size()][];
        for (int i = 0; i < results.size(); i++) {
            files[i] = new Object[] { results.get(i) };
        }
        return files;
    }

    public static Object[][] getRunData(String filePath, String[] parmList) {
        Properties curParm=getContent(filePath);
        Object[][] files = new Object[1][];
        Object[] values = new Object[parmList.length];
        for (int i = 0; i < parmList.length; i++) {
            values[i] = curParm.getProperty(parmList[i]);
        }
        files[0] = values;

        return files;
    }
    
    public static Properties getContent(String filePath) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
}
