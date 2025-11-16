package CSVtoJSON;
import java.io.*;
import java.util.*;

public class CSVtoJSON {
    public String filePath;
    public CSVtoJSON(String filePath){
        this.filePath = filePath;
    }
    public String parse(){
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine())!=null){
                lines.add(line);
            }
        }catch(FileNotFoundException e){
            System.err.println("File not found: " + filePath);
            return "[]";  // Return empty array on file not found
        }catch(IOException e){
            System.err.println("Error reading file: " + filePath);
            return "[]";  // Return empty array on read error
        }
        String headers[] = lines.get(0).trim().split(",");
        List<Map<String,String>> data = new ArrayList<>();
        for(int i=1;i<lines.size();i++){
            String values[] = lines.get(i).trim().split(",");
            Map<String,String> record = new HashMap<>();
            for(int j=0;j<headers.length;j++){
                record.put(headers[j], j<values.length ? values[j] : "");
            }
            data.add(record);
        }
        // ]System.out.println(data);
        StringBuilder json = new StringBuilder();
        json.append("[\n");
        for(int i=0;i<data.size();i++){
            Map<String,String> row = data.get(i);
            json.append(" {\n");
            int j=0;
            for(Map.Entry<String,String> entry : row.entrySet()){
                json.append("  \"").append(entry.getKey()).append("\":\"")
                .append(entry.getValue()).append("\"");
                if(j<row.size()-1) json.append(",");
                json.append("\n");
                j++;
            }
            json.append(" }");
            if(i<data.size()-1) json.append(",");
            json.append("\n");
        }
        json.append("]");   
        // System.out.println(json);
        return json.toString();

    }

    public static void main(String[] args) {
        CSVtoJSON parser = new CSVtoJSON("C:\\Users\\OdiN\\OneDrive\\Desktop\\systemdesign\\CSVtoJSON\\path.csv");
        System.out.println(parser.parse());
    }
}