package com.frs.sakila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.sakila.entity.Address;
import com.frs.sakila.entity.Staff;
import com.frs.sakila.entity.Store;
import com.frs.sakila.exception.StaffNotFoundException;
import com.frs.sakila.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {	

	@Autowired
	private StaffRepository staffRepository;
	

	@Override
	public List<Staff> searchStaffByLastName(String lastName) {
		List<Staff> staff = staffRepository.findByLastName(lastName);
		if(staff.isEmpty())
			throw new StaffNotFoundException("Staff with Last name "+lastName+" is not available");
		return staffRepository.findByLastName(lastName);
	}
	
	@Override
	public List<Staff> searchStaffByFirstName(String firstName) {
		List<Staff> staff = staffRepository.findByFirstName(firstName);
		if(staff.isEmpty())
			throw new StaffNotFoundException("Staff with First name "+firstName+" is not available");
		return staffRepository.findByFirstName(firstName);
	}
	
	@Override
	public List<Staff> searchStaffByCity(String city) {
		List<Staff> staff =staffRepository.findByAddressCityCity(city);
		if(staff.isEmpty())
			throw new StaffNotFoundException("Staff with city "+city+" is not available");
		return staffRepository.findByAddressCityCity(city);
	}

	@Override
	public List<Staff> searchStaffByCountry(String country) {
		List<Staff> staff =staffRepository.findByAddressCityCountryCountry(country);
		if(staff.isEmpty())
			throw new StaffNotFoundException("Staff with country "+country+" is not available");
		return staffRepository.findByAddressCityCountryCountry(country);
	}

	@Override
	public Staff searchStaffByPhone(String phone) {
		Staff staff =staffRepository.findByAddress_Phone(phone);
		if(staff==null)
			throw new StaffNotFoundException("Staff with city "+phone+" is not available");
		return staffRepository.findByAddress_Phone(phone);
	}

	@Override
	public Staff searchStaffByEmail(String email) {
		Staff staff = staffRepository.findByEmail(email);
		if(staff==null)
			throw new StaffNotFoundException("Staff with email "+email+" is not found");
		return staffRepository.findByEmail(email);
	}
	
	@Override
	public Staff searchStaffByAddress(Address address) {
		return staffRepository.findByAddress(address);
	}

	
	@Override
	public Staff assignAddressToStaff(byte id, Address address) {
		Staff staff = staffRepository.findById(id).orElseThrow(()-> new StaffNotFoundException("Invalid ID"));
	        staff.setAddress(address);
	        return staffRepository.save(staff);
	    } 

	
	@Override
	public Staff updateStaffFirstName(byte id, String firstName) {
		Staff staff = staffRepository.findById(id).orElse(null);
		 if (staff != null) {
		        staff.setFirstName(firstName);
		        return staffRepository.save(staff);
		    } else {
		        throw new StaffNotFoundException("No staff found with the id: " + id);
		    }
	}

	
	@Override
	public Staff updateStaffLastName(byte id, String lastName) {
		Staff staff = staffRepository.findById(id).orElse(null);
		 if (staff != null) {
		        staff.setLastName(lastName);
		        return staffRepository.save(staff);
		    } else {
		        throw new StaffNotFoundException("No staff found with the id: " + id);
		    }
	}
	
	@Override
	public Staff updateStaffEmail(byte id, String email) {
		Staff staff = staffRepository.findById(id).orElse(null);
		if (staff != null) {
	        staff.setEmail(email);
	        return staffRepository.save(staff);
	    }
		else throw new StaffNotFoundException("No staff found with the id: " + id);
	    }

	
	@Override
	public Staff assignStoreToStaff(byte id, Store store) {
		Staff staff = staffRepository.findById(id).orElseThrow(()->new StaffNotFoundException("Invalid ID"));
	        staff.setStore(store);
	        return staffRepository.save(staff);
	}

	@Override
	public Staff updateStaffPhone(byte id, String phone) {
		Staff staff = staffRepository.findById(id).orElse(null);
		if (staff != null) {
			staff.getAddress().setPhone(phone);
			return staffRepository.save(staff);
		} else throw new StaffNotFoundException("No staff found with the id: " + id);
	}

	@Override
	public void deleteStaff(byte id) {
		staffRepository.deleteById(id);
	}
	@Override
    public Staff getStaffById(byte staffId) {
		 Optional<Staff> optionalStaff = staffRepository.findById(staffId);
		    return optionalStaff.orElseThrow(() -> 
		    new StaffNotFoundException("No staff found with the staffId: " + staffId));
    }
    @Override
    public Staff updateStaff(Staff staff) {
        return staffRepository.save(staff);
    }
	@Override
	public Staff assignStoreToStaff(byte id) {
		return null;
	}
	@Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }
	@Override
	public Staff createStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	@Override
	public List<Staff> fetchAll() {
		return staffRepository.findAll();
	}
}
