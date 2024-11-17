package com.studies.utils;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class CsvUtils {

    private static final String OUTPUT_BASE_PATH = "outputFiles/";


    public static String generateCsvFile(List<String[]> data, String fileName){
        return generateCsvFile(data, OUTPUT_BASE_PATH, fileName);
    }

    public static String generateCsvFile(List<String[]> data, String directoryPath, String fileName) {

        try {
            directoryPath = directoryPath.endsWith("/") ? directoryPath : directoryPath + "/";
            fileName = (fileName.endsWith(".csv") ? fileName.replace(".csv", "") : fileName);
            String fileFullName = directoryPath + fileName + ".csv";

            System.out.println("Gerando arquivo CSV: " + fileFullName);

            File directory = new File(fileFullName).getParentFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Criar o arquivo se não existir
            File file = new File(fileFullName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(fileFullName);
            CSVWriter cw = new CSVWriter(fw,
                    ';',//Delimitador
                    '\'',//Caractere de aspas simples
                    CSVWriter.NO_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // Processar os dados para remover aspas duplas
            for (String[] line : data) {
                for (int i = 0; i < line.length; i++) {
                    if (line[i] != null) {
                        line[i] = line[i].replace("\"", "\"");  // Remove aspas duplas
                    }
                }
                cw.writeNext(line);
            }

//            cw.writeAll(data);

            System.err.println("\nArquivo CSV gerado com sucesso em: " + file.getAbsolutePath() + "\n");

            cw.close();
            fw.close();

            return fileFullName;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
