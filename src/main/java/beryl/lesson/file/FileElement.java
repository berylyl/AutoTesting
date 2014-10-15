package beryl.lesson.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileElement {
    
    public void fileSeparator(){
        System.out.println(File.separator);
    }
    
    public void newDir(String path){
        File filePath = new File(path);
        if (!filePath.exists()){
            System.out.println("创建["+filePath.getAbsolutePath()+"]目录："+filePath.mkdirs());
        }else{
            System.out.println("存在目录："+filePath.getAbsolutePath());
        }
        
    }
    
    
    public void newFile(String fileName) {
        File file = new File(fileName);
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            fw.write("file content");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(File.separator);
    }
}
