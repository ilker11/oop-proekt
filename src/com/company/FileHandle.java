package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHandle {
    private File file;
    private FileReader reader;
    private String content;

    public FileHandle(File file, FileReader reader) {
        this.file = file;
        this.reader = reader;
        this.content = readContent();
    }

    public File getFile() {
        return file;
    }

    public FileReader getReader() {
        return reader;
    }

    public String getContent() {
        return content;
    }

    private String readContent() {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            int ch;
            while ((ch = reader.read()) != -1) {
                contentBuilder.append((char) ch);
            }
        } catch (IOException e) {
            // handle exception
        }
        return contentBuilder.toString();
    }
}
