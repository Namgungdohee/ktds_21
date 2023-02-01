package address_book;

import java.util.ArrayList;
import java.util.List;

public class AddressListHandler {
	
	private List<Address> addressList= new ArrayList<>();
	
	/*
	 * byte = Byte
	 * short = Short
	 * int = Integer
	 * long = Long
	 * float = Float
	 * double = Double
	 * boolean = Boolean
	 * char = Character
	 */
public void create( String name, String phoneNumber, String address) {
		Address addr = new Address();
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
		addressList.add(addr);
	}
	
	public void update(int index, String name, String phoneNumber, String address) {
		Address addr = addressList.get(index);
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
	}
	
	public void delete(int index) {
		addressList.remove(index);
		
	}
	
	public void read(int index) {
		Address addr = addressList.get(index);
		System.out.println("이름: " + addr.getName());
		System.out.println("전화번호: " + addr.getPhoneNumber());
		System.out.println("주소: " + addr.getAddress());
		
	}
	
	/**
	 * 전통적 for를 이용해 반복
	 */
	public void readAllFor() {
		for(int i = 0; i < addressList.size(); i +=1 ){
			read(i);
		}
	}
	
	/**
	 * for-each를 이용해 반복
	 */
	public void readAllForeach() {
		for (Address addr: addressList) {
			System.out.println("이름: " + addr.getName());
			System.out.println("전화번호: " + addr.getPhoneNumber());
			System.out.println("주소: " + addr.getAddress());
			
		}
	}
	
	/**
	 * List의 forEach를 이용해 반복
	 */
	public void readAllListForeach() {
		addressList.forEach( (addr) -> {
			System.out.println("이름: " + addr.getName());
			System.out.println("전화번호: " + addr.getPhoneNumber());
			System.out.println("주소: " + addr.getAddress());
		} );
	}
	
	public static void main(String[] args) {
		AddressListHandler handler = new AddressListHandler();
		
		handler.create("조태용", "010-1234-1234", "서울");
		handler.create("이동학", "010-5678-1234", "서울");
		handler.create("이건회", "010-2345-8888", "서울");
		
		System.out.println(handler.addressList.size());
		
		handler.read(0);
		handler.read(1);
		handler.read(2);
		
		handler.update(2,"이건회", "010-1111-2222", "서울");
		handler.read(2);
		
		handler.delete(2);
		
		System.out.println("FOR");
		handler.readAllFor();
		
		System.out.println("FOR-EACH");
		handler.readAllForeach();
		
		System.out.println("LIST FOR EACH");
		handler.readAllListForeach();
	}
}
