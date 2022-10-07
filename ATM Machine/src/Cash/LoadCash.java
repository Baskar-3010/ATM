package Cash;

import java.io.*;
public class LoadCash implements Serializable{
	private int Atmbalance;
	private int $2000;
	private int $500;
	private int $100;

	public void loadCash(int $2000, int $500, int $100) throws IOException {

		this.$2000 += $2000;
		this.$500 += $500;
		this.$100 += $100;
		Atmbalance+=$2000*2000+$500*500+$100*100;
		File f=new File("atmCashDetails");
		FileOutputStream fos=new FileOutputStream(f);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(this);
		fos.close();
		oos.close();
		System.out.println("Amount loaded sucessfully");
	}

	public int getAtmbalance() {
		return Atmbalance;
	}

	public void Atmbalance() throws IOException, ClassNotFoundException {
		File f=new File("atmCashDetails");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		LoadCash balance=(LoadCash)ois.readObject();
		System.out.println("Denominations \t Number \t Value");
		System.out.println(2000 +" "+" \t\t"+ balance.get$2000() +"\t\t" + balance.get$2000()*2000);
		System.out.println(500 +" \t\t "+  balance.get$500() +"\t\t" + balance.get$500()*500);
		System.out.println(100 + " \t\t "+  balance.get$100() +"\t\t" + balance.get$100()*100);
		System.out.println("\n\n Total Amount available in the ATM is ₹"+balance.getAtmbalance());
//		System.out.println(balance.get$2000());
//		System.out.println(balance.get$500());
//		System.out.println(balance.get$100());
//		System.out.println(balance.getAtmbalance());
		fis.close();
		ois.close();
	}

	public void setAtmbalance(int atmbalance) {
		Atmbalance = atmbalance;
	}

	public int get$2000() {
		return $2000;
	}

	public void set$2000(int $2000) {
		this.$2000 = $2000;
	}

	public int get$500() {
		return $500;
	}

	public void set$500(int $500) {
		this.$500 = $500;
	}

	public int get$100() {
		return $100;
	}

	public void set$100(int $100) {
		this.$100 = $100;
	}
	
}
