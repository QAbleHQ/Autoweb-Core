package io.unity.autoweb;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocatorReader {


    public JSONObject getLocatorObject(String file_path) {
        LocatorReader reader = new LocatorReader();
        StringBuilder builder = new StringBuilder();
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            InputStream is = reader.getFileAsIOStream(file_path);
            builder = reader.printFileContent(is);
            json = (JSONObject) parser.parse(builder.toString());
        } catch (Exception e) {

        }
        System.out.println(builder);

        return json;
    }

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private StringBuilder printFileContent(InputStream is) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);) {
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            is.close();
        }
        return builder;
    }
}
