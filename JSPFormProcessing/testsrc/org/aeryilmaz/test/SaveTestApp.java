package org.aeryilmaz.test;

import org.aeryilmaz.deviceapp.entity.DeviceInfo;
import org.aeryilmaz.deviceapp.repository.DeviceRepository;
import org.aeryilmaz.repository.RepositoryException;

import java.util.Scanner;

public class SaveTestApp {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		
		try {
			for (;;) {
				DeviceRepository repo = DeviceRepository.INSTANCE;
				
				System.out.println("All Devices:");
				for (DeviceInfo di : repo.findAll())
					System.out.println(di);
				
				System.out.print("Device Name:");
				String name = kb.nextLine();
				
				if (name.equals("quit"))
					break;
				
				System.out.print("IP Address:");
				String ipAddress = kb.nextLine();
				
				DeviceInfo di = new DeviceInfo(name, ipAddress);
				
				repo.save(di);
				
				System.out.printf("Device Information:%s%n", di);
				
			}			
			
		}
		catch (RepositoryException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
