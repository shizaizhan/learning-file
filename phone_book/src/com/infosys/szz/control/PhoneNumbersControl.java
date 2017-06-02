package com.infosys.szz.control;

import java.util.Map;
import java.util.Scanner;

import com.infosys.szz.model.PhoneNumberBook;

public class PhoneNumbersControl {

	public static void main(String[] args) {
		PhoneNumberBook phoneNumberBook = PhoneNumberBook.getPhoneNumberBook();
		Scanner scanner = new Scanner(System.in);
		System.out.println("电话簿已打开 ");
		stop_two: while (true) {
			System.out.println("1:查看电话簿 2:添加电话号码 3:删除电话号码 4:关闭电话簿");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Map<String, String> phoneNumbers = phoneNumberBook.getPhoneNumbers();
				for(Map.Entry<String, String> phoneNumber : phoneNumbers.entrySet()){
					System.out.println("姓名: " + phoneNumber.getKey() + "     电话:" + phoneNumber.getValue());
				}
				continue;
			case 2:
				stop_one:while(true){
					System.out.println("请输入姓名");
					String name = scanner.next();
					if(phoneNumberBook.getPhoneNumbers().containsKey(name)){
						System.out.println("电话簿已存在此人联系方式请重新输入");
						continue;
					}
					while(true){
						System.out.println("请输入电话号码");
						String phone = scanner.next();
						if((phone.matches("^[1-9]{1}[0-9]{7,7}") && phone.length() == 8) ||
								(phone.matches("^[1][3,4,5,8][0-9]{9}$") && phone.length() == 11)){
							phoneNumberBook.addPhoneNumbers(name, phone);
							break stop_one;
						}
						System.out.println("电话号码不合法，请重新输入");
					}
				}
				continue;

			case 3:
				while(true){
					System.out.println("请输入删除姓名");
					String name = scanner.next();
					if(phoneNumberBook.getPhoneNumbers().containsKey(name)){
						phoneNumberBook.getPhoneNumbers().remove(name);
						System.out.println("已删除该记录");
						break;
					}
					System.out.println("电话簿不存在此人，请重新输入");
				}
				continue;
			case 4:
				System.out.println("电话簿已经关闭");
				break stop_two;

			default:
				System.out.println("请输入有效指令");
				continue;
			}
		}
	}
}
