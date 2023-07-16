package com.frs.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.sakila.entity.Address;
import com.frs.sakila.entity.Staff;
import com.frs.sakila.entity.Store;
import com.frs.sakila.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	//done
	@PostMapping("/post")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
        Staff newStaff = staffService.addStaff(staff);
        if (newStaff != null) {
            return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@GetMapping("/all")
	public List<Staff> fetchAll() {
		return staffService.fetchAll();
	}

	//working
	@GetMapping("/lastname/{ln}")
	public List<Staff> searchStaffByLastName(@PathVariable String ln) {
		return staffService.searchStaffByLastName(ln);
	}
	//working
	@GetMapping("/firstname/{fn}")
	public List<Staff> searchStaffByFirstName(@PathVariable String fn) {
		return staffService.searchStaffByFirstName(fn);
	}

	//working
	@GetMapping("/email/{email}")
	public Staff searchStaffByEmail(@PathVariable String email) {
		return staffService.searchStaffByEmail(email);
	}
	
	@PutMapping("/{id}/address")
    public ResponseEntity<Staff> assignAddressToStaff(@PathVariable("id") byte staffId, @RequestBody Address address) {
        // Get the staff by ID
        Staff staff = staffService.getStaffById(staffId);
        
        // Check if the staff exists
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Assign the address to the staff
        staff.setAddress(address);
        
        // Update the staff
        Staff updatedStaff = staffService.updateStaff(staff);

        
            return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
       
    }

	//working
	@GetMapping("/city/{city}")
	public List<Staff> searchStaffByCity(@PathVariable String city) {
		return staffService.searchStaffByCity(city);
	}

	//working
	@GetMapping("/country/{country}")
	public List<Staff> searchStaffByCountry(@PathVariable String country) {
		return staffService.searchStaffByCountry(country);
	}

	//working
	@GetMapping("/phone/{phone}")
	public Staff searchStaffByPhone(@PathVariable String phone) {
		return staffService.searchStaffByPhone(phone);
	}

	//
	@PutMapping("/update/fn/{id}")
	public Staff updateStaffFirstName(@PathVariable byte id, @RequestBody Staff staff) {
	    staff.setFirstName(staff.getFirstName());
	    return staffService.updateStaffFirstName(id, staff.getFirstName());
	}


	//
	@PutMapping("/update/ln/{id}")
	public Staff updateStaffLastName(@PathVariable byte id, @RequestBody Staff staff) {
		staff.setLastName(staff.getLastName());
		return staffService.updateStaffLastName(id, staff.getLastName());
	}

	@PutMapping("/update/email/{id}")
	public Staff updateStaffEmail(@PathVariable byte id, @RequestBody Staff staff) {
	    staff.setEmail(staff.getEmail());
	    return staffService.updateStaffEmail(id, staff.getEmail());
	}

	//working
	@PutMapping("/update/store/{id}")
    public Staff assignStoreToStaff(@PathVariable byte id, @RequestBody Store store) {
        return staffService.assignStoreToStaff(id, store);
    }


	@PutMapping("/update/phone/{id}")
	public Staff updateStaffPhone(@PathVariable byte id, @RequestBody String phone) {
		return staffService.updateStaffPhone(id, phone);
	}
	
}
