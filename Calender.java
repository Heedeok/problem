import java.io.*;
import java.util.*;

class Person{
   protected String name ;
   protected int birth;
   protected String workplace;
   public double[][] worktime=new double[12][31];
   public double[][] workmoney=new double[12][31];
   
   Scanner input=new Scanner(System.in);
   
   public void mainMenu() {
	   
	   while(true) {
	   System.out.println("\n<<<<<<�˹� �޿� ����>>>>>>");
	   System.out.println("��ϵ� ȸ���̽ø� 1");
	   System.out.println("��ϵ��� ���������� 2�� �Է��ϼ���");
	   int a=input.nextInt();
	   if(a==1) {
		   signed(); break;}
	   else if(a==2) {
		   unsigned(); break;}	   
	   }
  }
   public void signed() {
	   System.out.println("��������� �Է��ϼ��� : ");
	   System.out.println("***Ŀ���� ������ ������ �Է��ϼ���***");
	   int check=input.nextInt();
	   String fname=String.valueOf(check);
	   try(FileReader fr=new FileReader(fname)){
		   int ch;
		   int i=0;
		   char a=0,b=0,c=0,d=0,e=0,f=0;
		   while((ch=fr.read())!=-1) {
			   if(i==0){
				   System.out.print("������� : ");
				   a=(char)ch;}
			   System.out.print((char)ch);
			   if(i==1)
				   b=(char)ch;
			   else if(i==2)
				   c=(char)ch;
			   else if(i==3)
				   d=(char)ch;
			   else if(i==4)
				   e=(char)ch;
			   else if(i==5) {
				   f=(char)ch;
				   System.out.print("\n�̸� : ");}
			   else if(i==8)
				   System.out.println("\n�ٹ��� : ");
			   i++;
		   }
		   String str=String.valueOf(a);
		   str+=String.valueOf(b);
		   str+=String.valueOf(c);
		   str+=String.valueOf(d);
		   str+=String.valueOf(e);
		   str+=String.valueOf(f);
		   birth=Integer.parseInt(str);
	   }catch (IOException e) {
		   e.printStackTrace();
		   System.out.println("����� ����!");
		   System.out.println("�ʱ�ȭ����� �ٽ� �����մϴ�");
		   mainMenu();
	   }
   }
   public void unsigned() {
	   System.out.println("����� �����մϴ�");
	   System.out.println("***Ŀ���� ������ ������ �Է��ϼ���***");
	   System.out.println("������� : ");
	   birth=input.nextInt();
	   String birthString=String.valueOf(birth);
	   System.out.println("�̸� : ");
	   name=input.next();
	   System.out.println("�ٹ��� : ");
	   workplace=input.next();
	   
	   String info=birthString + name + workplace;
	   char[] chinfo=info.toCharArray();
	   
	   try(FileWriter out=new FileWriter(birthString)){
		   for(int i=0;i<chinfo.length;i++)
			   out.write(chinfo[i]);
	   }catch (IOException e) {
		   e.printStackTrace();
		   System.out.println("����� ����!");
		   System.out.println("�ʱ�ȭ����� �ٽ� �����մϴ�");
		   mainMenu();
	   }
	   finally {
		   System.out.println("����� �Ϸ�Ǿ����ϴ�");
		   mainMenu();
	   }
   }

   public String getBirth() {
	   return  String.valueOf(birth) + "Object";
   }
}
class Employee extends Person implements Serializable {
   private int[][] hour=new int[10][2];
   private int[][] minute=new int[10][2];
   private int[] money=new int[10];
   private static int m=0;
   private static int year=0;
   
   public void calmenuback() {
	   System.out.println("=====================");
	      System.out.println("�޷����� ���ư��÷��� 1��");
	      System.out.println("����Ÿ��/�޷¼��� �޴��� ���ư��÷��� 2��");
	      System.out.println("�����Ͻ÷��� �ƹ�Ű�� ��������");
	      int c=input.nextInt();
	      if(c==1)
	    	  calMenu();
	      else if(c==2)
	    	  menu1();        
   }
   public void worktimemenu() {
	   System.out.println("====================");
	   System.out.println("1. �ٹ�Ÿ�� Ȯ��");
	   System.out.println("2. �ٹ�Ÿ�� ����");
	   System.out.println("���� �޴��� ���ư��÷��� �ƹ�Ű�� ��������");
	   int a=input.nextInt();
	   if(a==1)
		   timecheck();
	   else if(a==2)
		   timeSet();
	   else 
		   menu1();	   
   }
   public void menu1() {
	   System.out.println("������ �޴��� ������");
	   System.out.println("1.�ٹ�Ÿ��");
	   System.out.println("2.�޷�");
	   System.out.println("�����Ϸ��� �ƹ�Ű�� ��������");
	   int a=input.nextInt();
	   if(a==1)
		   worktimemenu();
	   else if(a==2) {
		   Calset();
		   calMenu(); }		   
   }
   public void timecheck() {
	   System.out.println("�ٹ�Ÿ���� Ȯ���մϴ�.");
	   for (int i=0;i<hour.length;i++) {
		   System.out.println("�ٹ�Ÿ��"+(i+1));
		      System.out.println("���� �ð� : "+hour[i][0]+"�� "+minute[i][0]+"��");
		      System.out.println("���� �ð� : "+hour[i][1]+"�� "+minute[i][1]+"��");
		      System.out.println("�ñ� : "+money[i]+"��");
	   }
	   worktimemenu();
   }
   public void timeSet() {
      while(true){
            System.out.println("��� ° �ٹ�Ÿ���� �����Ͻðڽ��ϱ�?(�ִ� 10��)");
            System.out.println("�ٹ�Ÿ�Լ����� �׸��ν÷��� 0�� �Է��ϼ���");
            int a=input.nextInt();
            if(a==0){
            	System.out.println("�ٹ�Ÿ�� ������ �Ϸ�Ǿ����ϴ�.");
                break;
            }
            else{
            	 System.out.println("�ٹ�Ÿ���� �����ϼ���. (ex. 15�� 00�� �� 15 00(�ð�, ��)");
                 System.out.println("�ٹ�Ÿ��"+(a));
                 System.out.print("���� �ð� : ");
                 hour[a-1][0]=input.nextInt();
                 minute [a-1][0]=input.nextInt();
                 System.out.print("���� �ð� : ");
                 hour[a-1][1]=input.nextInt();
                 minute [a-1][1]=input.nextInt();
                 System.out.print("�ñ�(��) : ");
                 money[a-1]=input.nextInt();
            }
            a=0;
         }
      	worktimemenu();
   }
   public void Calset() {
       System.out.println("Ȯ���Ϸ��� ������ ���� �Է��ϼ���.  (ex�⵵ : 2018,�� : 3)");
      System.out.print("���� : ");
      year = input.nextInt();
      System.out.print("��: ");
      m = input.nextInt();        
   }
   public void Cal(int a, int b) {
       System.out.println("       [ "+a+"�� "+b+"��"+" ] ");
       System.out.println("=============================");
        System.out.println("    ��     ��     ȭ     ��     ��     ��     ��");

      Calendar cal = Calendar.getInstance();
       cal.set(a, b-1,1);
      int lastOfDate = cal.getActualMaximum(Calendar.DATE);
      int week = cal.get(Calendar.DAY_OF_WEEK);
     for(int i = 1;i < week ; i++)
             System.out.print("    ");
         for(int i =1;i<=lastOfDate;i++){
            
            if (i<10) {
               System.out.printf("  %2d",i) ;
            }
            else if (i>9&& i<21) {
               System.out.printf("  %2d",i) ;
            }
            else if (i>20&& i<28) {
               System.out.printf("  %2d",i) ;
            }
            else if (i>27) {
               System.out.printf("  %2d",i) ;
            }
              //����Ͽ� ��¥�� ǥ���ϰ� �ٹٲ� �ϴ� �ڵ�
              if(week%7==0)System.out.println();
              week++;
          }
   }
   public void daySet() {
	  Scanner sc=new Scanner(System.in);
	  int a;
      while(true) {
      System.out.println("����Ϸ��� �ٹ� Ÿ���� �����ϼ���");
      System.out.println("�ٹ� ��¥ ����� �׸��η��� 0�� �Է��ϼ���");
      a=input.nextInt();
      if(a==0)
         break;
      System.out.println("������ �ٹ�Ÿ��");
      System.out.println("�ٹ�Ÿ��"+a);
      System.out.println("���� �ð� : "+hour[a-1][0]+"�� "+minute[a-1][0]+"��");
      System.out.println("���� �ð� : "+hour[a-1][1]+"�� "+minute[a-1][1]+"��");
      System.out.println("�ñ� : "+money[a-1]+"��");
      System.out.println("�ٹ� Ÿ�Կ� �´� �ٹ� ��¥�� �����ϼ���(ex) 1, 8, 9, 10): "); 
      String n =sc.nextLine(); 
      String[] ma =n.split(",");
      int[] w=new int[ma.length];
      for(int i=0;i<ma.length;i++) {
         w[i]=Integer.parseInt(ma[i]);}
      for(int i=0;i<w.length;i++) {
         worktime[m][w[i]-1]+=(hour[a-1][1]-hour[a-1][0])+(double)(minute[a-1][1]-minute[a-1][0])/60;
         workmoney[m][w[i]-1]+=money[a-1]*(hour[a-1][1]-hour[a-1][0])+(double)(minute[a-1][1]-minute[a-1][0])/60;
      }
      a=0;
      }
      calmenuback();  
}
   public void moneySet() {
      System.out.println("�޿� ����� ��¥�� �����ϼ���");
      System.out.println("���� ��¥ : ");
      int a=input.nextInt();
      System.out.println("���� ��¥ : ");
      int b=input.nextInt();
      System.out.println("====================");
      double pay=0;
      for(int i=0;i<(b-a)+1;i++)
         pay+=workmoney[m][a+i];
      System.out.println("�˹� �޿��� ��"+pay+"�Դϴ�");
      calmenuback();
   }
   public void hoilday() {
      System.out.println("==================");
      System.out.println(m+"���� ���� �� �ٷνð� : ");
      double work=0;
      double money=0;
      System.out.println(work);
      System.out.println(money);
      for(int i=0;i<worktime[m].length;i++) {
         work+=worktime[m][i];
         money+=workmoney[m][i];
      }
      System.out.println(work+" �ð� ���Ͽ����ϴ�.");
      System.out.println("===================");
      if(work<60){
         System.out.println("���޼����� �����ϴ�.");
         System.out.println("������ ��ձٹ� �ð��� 15�ð� �̻��̾�� �մϴ�.");
      }
      else{
         System.out.println("���޼����� ��� �ñ����� ���޵˴ϴ�.");
         System.out.println("�ٷνð� "+work+"�ð� / ��սñ� "+money/work+"��");
         System.out.println("������ �ٹ��� ���� ���� ���޼����� "+((double)work/20)*(money/work)+"�� �Դϴ�");  
      }
      calmenuback();
}
   public void calMenu() {
	  Cal(year,m);
      System.out.println("\n������ �޴��� ������ : ");
      System.out.println("1.�ٷ� ��¥ ����  : ");
      System.out.println("2.�˹� �޿���� : ");
      System.out.println("3.���޼��� ��� : ");
      System.out.println("���� �޴��� ���÷��� �ƹ�Ű�� �������� ");
      int a=input.nextInt();
      if(a==1)
         daySet();
      else if(a==2)
         moneySet();
      else if (a==3)
         hoilday();
      else
         menu1();      
   }  
   public void start(Object q) throws IOException {
		while(true) {
		System.out.println("\n=========================");
		System.out.println("�����ϼ���");
		System.out.println("1. �������� ����ϱ�/ó������ϴº� 2��  ����");
		System.out.println("2. ���� �ʱ�ȭ �ϱ�");
		int a=input.nextInt();
		if(a==1) {
			Last(q);
			break;
		}
		else if(a==2)
			New(q);
			break;
		}
	}
	public void Last(Object q) throws IOException {
		Employee first=(Employee)q;
		ObjectInputStream in=null;
		try{
			in=new ObjectInputStream(new FileInputStream(first.getBirth()));
			Employee second=(Employee)in.readObject();
			second.menu1();
			New(second);
		}catch(ClassNotFoundException e) {
		}finally {
			in.close();
		}
	}
	public void New(Object q) throws IOException {
		Employee first=(Employee)q;
		first.menu1();
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream(first.getBirth()));
			out.writeObject(first);
			out.flush();
		}catch(IOException e) {
		}finally {
			if(out!=null) {
				out.close();
			}
		}
	}
}
public class Calender {
   public static void main(String[] args) throws IOException {
	   Employee one=new Employee();
	   Employee check=one;
	   one.mainMenu();
	   one.start(check);
	   
   }
   }