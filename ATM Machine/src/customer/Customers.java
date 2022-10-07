package customer;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Customers implements Serializable{
	private int acc_no;
	private String acc_holder;
	private int pin;
	private int acc_balance;

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_holder() {
		return acc_holder;
	}

	public void setAcc_holder(String acc_holder) {
		this.acc_holder = acc_holder;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(int acc_balance) {
		this.acc_balance = acc_balance;
	}
public Customers() {}
	
	public Customers(int acc_no, String acc_holder, int pin, int acc_balance) {
		super();
		this.acc_no = acc_no;
		this.acc_holder = acc_holder;
		this.pin = pin;
		this.acc_balance = acc_balance;
	}

	public void writeCustomers() throws IOException {
		ArrayList<Customers> customers=new ArrayList<>();
		Customers c1=new Customers(101,"Suresh",2343,25234);
		Customers c2=new Customers(102,"Ganesh",5432,34123);
		Customers c3=new Customers(103,"Magesh",7854,26100);
		Customers c4=new Customers(104,"Naresh",2345,80000);
		Customers c5=new Customers(105,"Harish",1907,103400);
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		writeObject.writeCustomerObject(customers);
	}
	public ArrayList<Customers>  customerDetails() throws IOException, ClassNotFoundException {
		
		File f=new File("customers");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList<Customers> al=(ArrayList<Customers>) ois.readObject();
		System.out.println("Customer Details");
		for(Customers c:al) {
			System.out.println(c.getAcc_no() +" "+c.getAcc_holder()+" "+c.getPin()
			+" "+c.getAcc_balance());
		}
		return al;
		
		
		
		
	}
}
