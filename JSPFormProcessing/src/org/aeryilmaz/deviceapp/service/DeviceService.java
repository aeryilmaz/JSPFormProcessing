package org.aeryilmaz.deviceapp.service;

import org.aeryilmaz.deviceapp.entity.DeviceInfo;
import org.aeryilmaz.repository.IRepository;
import org.aeryilmaz.repository.RepositoryException;
import org.aeryilmaz.service.ServiceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DeviceService {
	private final IRepository<DeviceInfo, Integer> m_repository;
	
	public DeviceService(IRepository<DeviceInfo, Integer> repository) //dependency injection
	{
		m_repository = repository;
	}
	
	public DeviceInfo save(DeviceInfo di)
	{
		try {			
			return m_repository.save(di);
		}
		catch (RepositoryException ex) {
			throw new ServiceException("save problem in service", ex.getCause());
		}
	}
	
	public List<DeviceInfo> findAll()
	{
		try {			
			return new ArrayList<DeviceInfo>((Collection<DeviceInfo>)m_repository.findAll());
		}
		catch (RepositoryException ex) {
			throw new ServiceException("findAll problem in service", ex.getCause());
		}		
	}
	
	public Optional<DeviceInfo> findById(int id)
	{
		try {
			return m_repository.findById(id);
		}
		catch (RepositoryException ex) {
			throw new ServiceException("findById problem in service", ex.getCause());
		}
	}
}

