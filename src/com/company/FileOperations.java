package com.company;

import com.company.FileHandle;

import java.io.*;

public class FileOperations {
    public static FileHandle openFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        return new FileHandle(file, reader);
    }

    public static void closeFile(FileHandle handle) throws IOException {
        handle.getReader().close();
    }

    public static void saveFile(FileHandle handle) throws IOException {
        File file = handle.getFile();
        FileWriter writer = new FileWriter(file);
        writer.write(handle.getContent());
        writer.close();
    }

    public static void saveFileAs(FileHandle handle, String filePath) throws IOException {
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        writer.write(handle.getContent());
        writer.close();
    }

    public static void help() {
        // display help information
    }

    public static void exit() {
        // clean up resources and exit the application
    }
}
