package com.infosys.szz.control;

import java.util.Map;
import java.util.Scanner;

import com.infosys.szz.model.PhoneNumberBook;

public class PhoneNumbersControl {

	public static void main(String[] args) {
		PhoneNumberBook phoneNumberBook = PhoneNumberBook.getPhoneNumberBook();
		Scanner scanner = new Scanner(System.in);
		System.out.println("�绰���Ѵ� ");
		stop_two: while (true) {
			System.out.println("1:�鿴�绰�� 2:��ӵ绰���� 3:ɾ���绰���� 4:�رյ绰��");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Map<String, String> phoneNumbers = phoneNumberBook.getPhoneNumbers();
				for(Map.Entry<String, String> phoneNumber : phoneNumbers.entrySet()){
					System.out.println("����: " + phoneNumber.getKey() + "     �绰:" + phoneNumber.getValue());
				}
				continue;
			case 2:
				stop_one:while(true){
					System.out.println("����������");
					String name = scanner.next();
					if(phoneNumberBook.getPhoneNumbers().containsKey(name)){
						System.out.println("�绰���Ѵ��ڴ�����ϵ��ʽ����������");
						continue;
					}
					while(true){
						System.out.println("������绰����");
						String phone = scanner.next();
						if((phone.matches("^[1-9]{1}[0-9]{7,7}") && phone.length() == 8) ||
								(phone.matches("^[1][3,4,5,8][0-9]{9}$") && phone.length() == 11)){
							phoneNumberBook.addPhoneNumbers(name, phone);
							break stop_one;
						}
						System.out.println("�绰���벻�Ϸ�������������");
					}
				}
				continue;

			case 3:
				while(true){
					System.out.println("������ɾ������");
					String name = scanner.next();
					if(phoneNumberBook.getPhoneNumbers().containsKey(name)){
						phoneNumberBook.getPhoneNumbers().remove(name);
						System.out.println("��ɾ���ü�¼");
						break;
					}
					System.out.println("�绰�������ڴ��ˣ�����������");
				}
				continue;
			case 4:
				System.out.println("�绰���Ѿ��ر�");
				break stop_two;

			default:
				System.out.println("��������Чָ��");
				continue;
			}
		}
	}
}
