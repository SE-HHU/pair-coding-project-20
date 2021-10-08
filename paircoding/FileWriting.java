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
  private static String filePath1 = "Exercises.txt";//�涨�����ļ���ΪExercises��txt�ļ�
  private static String filePath2 = "Answers.txt";//�涨�����ļ���ΪAnswers��txt�ļ�
  private static String filePath3 = "shurudaan.txt";//�涨�����ļ���Ϊshurudaan��txt�ļ�
  private static String filePath4 = "Grade.txt";//�涨�����ļ���ΪGrade��txt�ļ�

  
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
  }//�����ļ��ĺ���

  
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
  }//���ļ��ĺ���

  
  public static boolean writeTxtFile(String content, File fileName)
    throws Exception
  {
    RandomAccessFile mm = null;
    boolean flag = false;//������ʶ
    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(fileName);//������
      fileOutputStream.write(content.getBytes("gbk"));
      fileOutputStream.close();//�ر���
      flag = true;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }//д�ļ�

  
  public static void fileChaseFW(String filePath, String content)
  {
    try
    {
      FileWriter fw = new FileWriter(filePath, true);

      fw.write(content + "\r\n");
      fw.close();
    } 
    catch (IOException e) {
      System.out.println("�ļ�д��ʧ�ܣ�" + e);
    }
  }//����д���ļ�

  
  public static void writter1(String args) throws Exception {
    File file = new File(filePath1);
    createFile(file);
    fileChaseFW(filePath1, args);
  }//д���ļ���ΪExercises��txt�ļ�

  
  public static void writter2(String args) throws Exception {
    File file = new File(filePath2);
    createFile(file);
    fileChaseFW(filePath2, args);
  }//д���ļ���ΪAnswers��txt�ļ�

  
  public static void writter3(String args) throws Exception {
    File file = new File(filePath3);
    createFile(file);
    fileChaseFW(filePath3, args);
  }//д���ļ���ΪAnswers��txt�ļ�
  
  
  public static void writter4(String args) throws Exception {
	  File file = new File(filePath4);
	  createFile(file);
	  fileChaseFW(filePath4, args);
  }//д���ļ���ΪAnswers��txt�ļ�
  
  
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
  }//д���ļ�
}