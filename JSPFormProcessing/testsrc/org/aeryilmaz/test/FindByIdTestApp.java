package org.aeryilmaz.test;

import org.aeryilmaz.deviceapp.entity.DeviceInfo;
import org.aeryilmaz.deviceapp.repository.DeviceRepository;
import org.aeryilmaz.repository.RepositoryException;

import java.util.Optional;
import java.util.Scanner;

public class FindByIdTestApp {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		
		try {
			for (;;) {
				DeviceRepository repo = DeviceRepository.INSTANCE;
				
				System.out.println("All Devices:");
				for (DeviceInfo di : repo.findAll())
					System.out.println(di);
				
				System.out.print("Id:");
				int id = Integer.parseInt(kb.nextLine());
				
				if (id == 0)
					break;
				
				Optional<DeviceInfo> opDev = repo.findById(id);
				
				if (opDev.isPresent())				
					System.out.printf("Device Information:%s%n", opDev.get());
				else
					System.out.println("Not found");
				
			}			
			
		}
		catch (RepositoryException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
