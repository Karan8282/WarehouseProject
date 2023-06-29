package com.karan.metacore;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	
	public static void main(String[] args) {
		Serializable s ="hello";
		System.out.println(s);
	}
	
	public static void main11(String[] args) {
		String input="syed";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encPwd = encoder.encode(input);
		System.out.println(encPwd);
	}
	
	
	public static String getOtp() {
		return String.format(
				"%04d", 
				new Random().nextInt(10000)
				);
	}
	
	public static void main3(String[] args) {
		System.out.println(getOtp());
		/*Random r = new Random();
		int val = r.nextInt(99);
		System.out.println(val);
		String otp = String.format("%04d", val);
		System.out.println(otp);*/
		
	}
	
	
	public static void main2(String[] args) {
		//JDK 1.5 - Universally Unique IDentifier(UUID)
		//Generates HexaDecimal String of size 36 chars
		UUID ob = UUID.randomUUID();
		String id = ob.toString();
		id = id.replaceAll("-", "");
		id = id.substring(0, 8);
		System.out.println(id);
				
	}

	public static void main1(String[] args) {
		List<Object[]> list =
				Arrays.asList(
						new Object[] {10,"BOXA"},
						new Object[] {11,"BOXM"},
						new Object[] {12,"BOXD"}
						);
		
		Map<Integer,String> map = 
		list.stream()
		.collect(
				Collectors.toMap(
						ob->(Integer)ob[0], 
						ob->(String)ob[1] 
						)
				);
		
		System.out.println(map);
	}
}
