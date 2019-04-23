package org.aeryilmaz.deviceapp.repository;

import java.util.HashMap;
import java.util.Optional;

import org.aeryilmaz.deviceapp.entity.DeviceInfo;
import org.aeryilmaz.repository.IRepository;
import org.aeryilmaz.repository.RepositoryException;

public enum DeviceRepository implements IRepository<DeviceInfo, Integer>{ //Aynı anda erişim dikkate alınmamıştır
	INSTANCE;	
	private static final HashMap<Integer, DeviceInfo> ms_devices;
	private static int m_curIndex = 4;
	
	static {
		ms_devices = new HashMap<>();		
		ms_devices.put(1, new DeviceInfo(1, "test", "192.168.2.34"));
		ms_devices.put(2, new DeviceInfo(2, "mest", "192.168.1.34"));
		ms_devices.put(3, new DeviceInfo(3, "jest", "192.168.2.56"));
	}
	
	public DeviceInfo save(DeviceInfo di)
	{
		try {
			di.setId(m_curIndex); 
			ms_devices.put(m_curIndex++, di);		
			
			return di;
		}
		catch (Throwable ex) {
			throw new RepositoryException("save problem", ex);
		}		
	}	
	
	public Iterable<DeviceInfo> findAll()
	{
		try {
			return ms_devices.values();
		}
		catch (Throwable ex) {
			throw new RepositoryException("findAll problem", ex);
		}
	}
	
	public Optional<DeviceInfo> findById(Integer id)
	{
		if (!ms_devices.containsKey(id))
			return Optional.empty();
		
		return Optional.of(ms_devices.get(id));
	}
}









