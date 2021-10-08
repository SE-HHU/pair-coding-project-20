package paircoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class FileWriting
{
  private static String filePath1 = "Exercises.txt";//规定保存文件名为Exercises的txt文件
  private static String filePath2 = "Answers.txt";//规定保存文件名为Answers的txt文件
  private static String filePath3 = "shurudaan.txt";//规定保存文件名为shurudaan的txt文件
  private static String filePath4 = "Grade.txt";//规定保存文件名为Grade的txt文件

  
  public static boolean createFile(File fileName)
    throws Exception
  {
    try
    {
      if (!fileName.exists())
        fileName.createNewFile();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }//创建文件的函数

  
  public static String readTxtFile(File file)
  {
    String result = "";
    try {
      InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "gbk");
      BufferedReader br = new BufferedReader(reader);
      String s = null;
      while ((s = br.readLine()) != null) {
        result = result + s;
        System.out.println(s);
      }
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }//读文件的函数

  
  public static boolean writeTxtFile(String content, File fileName)
    throws Exception
  {
    RandomAccessFile mm = null;
    boolean flag = false;//布尔标识
    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(fileName);//创建流
      fileOutputStream.write(content.getBytes("gbk"));
      fileOutputStream.close();//关闭流
      flag = true;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }//写文件

  
  public static void fileChaseFW(String filePath, String content)
  {
    try
    {
      FileWriter fw = new FileWriter(filePath, true);

      fw.write(content + "\r\n");
      fw.close();
    } 
    catch (IOException e) {
      System.out.println("文件写入失败！" + e);
    }
  }//尝试写入文件

  
  public static void writter1(String args) throws Exception {
    File file = new File(filePath1);
    createFile(file);
    fileChaseFW(filePath1, args);
  }//写入文件名为Exercises的txt文件

  
  public static void writter2(String args) throws Exception {
    File file = new File(filePath2);
    createFile(file);
    fileChaseFW(filePath2, args);
  }//写入文件名为Answers的txt文件

  
  public static void writter3(String args) throws Exception {
    File file = new File(filePath3);
    createFile(file);
    fileChaseFW(filePath3, args);
  }//写入文件名为Answers的txt文件
  
  
  public static void writter4(String args) throws Exception {
	  File file = new File(filePath4);
	  createFile(file);
	  fileChaseFW(filePath4, args);
  }//写入文件名为Answers的txt文件
  
  
  public static void fileClear() throws Exception {
    String s = "";
    File file = new File(filePath1);
    writeTxtFile(s, file);
    File file1 = new File(filePath2);
    writeTxtFile(s, file1);
    File file2 = new File(filePath3);
    writeTxtFile(s, file2);
    File file3 = new File(filePath4);
    writeTxtFile(s, file3);
  }//写入文件
}