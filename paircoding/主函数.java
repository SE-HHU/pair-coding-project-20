package paircoding;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ������
{
  public static void main(String[] args)//������
    throws Exception
  {
    System.out.print("���������ɵ���Ŀ����:");
    String input1 = input();
    while (!isInt(input1)) {
      System.out.println("����������������룡");
      input1 = input();
    }
    System.out.print("��������Ŀ����ֵ��Χ:");
    String input2 = input();
    while (!isInt(input2)) {
      System.out.println("����������������룡");
      input2 = input();
    }
    question exam = new question();
    exam.Exam(Integer.parseInt(input1), Integer.parseInt(input2));
    System.out.println("������ϣ��뵽zuoda.txt����");
    System.out.println("���������밴��1����������˳�");
    String input3 = input();
    if (input3.equals("1")){
      CompareAnswer.compare();
      System.out.println("��������ɣ��뵽Grade�ڲ鿴");
    }
    else
      System.exit(0);
  }

  public static boolean isInt(String string)
  {
    if (string == null) {
      return false;
    }
    String regEx1 = "[\\-|\\+]?\\d+";

    Pattern p = Pattern.compile(regEx1);
    Matcher m = p.matcher(string);

    return m.matches();
  }

  public static String input()
  {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    return input;
  }
}