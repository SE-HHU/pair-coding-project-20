package paircoding;

import java.util.Random;

public class CreateFormula {// ������ʽ
	private static char[] operate = { '+', '-', '*', '��' };

	public String Creating(int range){
		String subject = "";
		Random r = new Random();
		int  operator = r.nextInt(3)+1;//����������
		int kuohao=0;
		boolean flag=true;
		for(int i=1;i<=operator;i++)
		{
			
			Random rand=new Random();
			int temp=rand.nextInt(3)+1;
			if(temp==1)//�����Ƿ����������
			{
				subject+="(";
				kuohao++;
				subject+=this.getNum(range);
				subject += this.getOperate();
			} else if (temp == 2 && flag) {//�����Ƿ����������
				flag=false;
				subject="("+subject;
				kuohao++;
				subject+=this.getNum(range);
				subject += this.getOperate();
			}else if(temp==3&& kuohao!=0){//�����Ƿ����������
				subject+=this.getNum(range);
				subject+=")";
				kuohao--;
				subject += this.getOperate();
			}else{
				subject+=this.getNum(range);
				subject += this.getOperate();
			}
			
		}
		subject+=this.getNum(range);
		for(int i=kuohao;i>0;i--)
		{
			subject=subject+")";
		}
		return subject;	
	}
	private String getNum(int num) {// �����ȡ������,1.��Ȼ����2.�������3.������
		String str = "";
		int fz=0;//����
		int fm=1;//��ĸ
		int zs=0;//��������ߵ�����
		Random rand = new Random();
		int type=rand.nextInt(4);
		if(type==0){	//������
			fm= (rand.nextInt(num)) + 1 ;
			fz=(rand.nextInt(fm));
			if(fz==0)
			{
				fz=fz+1;
			}
			zs=(rand.nextInt(fm))+1;
			str=zs+"'"+fz+"/"+fm+"";
		}else if(type==1){//�����
			fm= (rand.nextInt(num)) + 1 ;
			fz=(rand.nextInt(fm));
			if(fz==0)
			{
				fz=fz+1;
			}
			str=fz+"/"+fm+"";
		}else{
			//��Ȼ��
			  str = ((int) (rand.nextInt(num)) + 1) + "";
		}
		
		return str;
	}

	private  String getOperate() {//������ɲ�����
		Random rand = new Random();
		int temp = rand.nextInt(4);
	 String str=operate[temp]+"";
		return str;
	}
}