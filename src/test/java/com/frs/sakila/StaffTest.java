package com.frs.sakila;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.frs.sakila.entity.Address;
import com.frs.sakila.entity.Staff;
import com.frs.sakila.entity.Store;
import com.frs.sakila.exception.StaffNotFoundException;
import com.frs.sakila.repository.StaffRepository;
import com.frs.sakila.service.StaffServiceImpl;

public class StaffTest {

    @Mock
    private StaffRepository staffRepository;

    @InjectMocks
    private StaffServiceImpl staffService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignAddressToStaff() {
        byte id = 1;
        Address address = new Address();
        Staff staff = new Staff();
        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.assignAddressToStaff(id, address);

        assertThat(result.getAddress()).isEqualTo(address);
        verify(staffRepository).findById(id);
        verify(staffRepository).save(any(Staff.class));
    }

    @Test
    public void testSearchStaffByAddress() {
        Address address = new Address();
        Staff staff = new Staff();
        when(staffRepository.findByAddress(address)).thenReturn(staff);

        Staff result = staffService.searchStaffByAddress(address);

        assertThat(result).isEqualTo(staff);
        verify(staffRepository).findByAddress(address);
    }

  
    @Test
    void testSearchStaffByPhone() {
        String phone = "1234567890";
        Staff mockStaff = null;
        // Mocking the behavior of the repository
        when(staffRepository.findByAddress_Phone(phone)).thenReturn(mockStaff);

        // Test the service method
        assertThrows(StaffNotFoundException.class, () -> staffService.searchStaffByPhone(phone));
        verify(staffRepository, times(1)).findByAddress_Phone(phone);
    }

    @Test
    public void testUpdateStaffFirstName() {
        byte id = 1;
        String firstName = "John";
        Staff staff = new Staff();
        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.updateStaffFirstName(id, firstName);

        assertThat(result.getFirstName()).isEqualTo(firstName);
        verify(staffRepository).findById(id);
        verify(staffRepository).save(any(Staff.class));
    }

    @Test
    public void testUpdateStaffLastName() {
        byte id = 1;
        String lastName = "Smith";
        Staff staff = new Staff();
        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.updateStaffLastName(id, lastName);

        assertThat(result.getLastName()).isEqualTo(lastName);
        verify(staffRepository).findById(id);
        verify(staffRepository).save(any(Staff.class));
    }

    @Test
    public void testUpdateStaffEmail() {
        byte id = 1;
        String email = "john@example.com";
        Staff staff = new Staff();
        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.updateStaffEmail(id, email);

        assertThat(result.getEmail()).isEqualTo(email);
        verify(staffRepository).findById(id);
        verify(staffRepository).save(any(Staff.class));
    }

    @Test
    public void testAssignStoreToStaff() {
        byte id = 1;
        Store store = new Store();
        Staff staff = new Staff();
        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.assignStoreToStaff(id, store);

        assertThat(result.getStore()).isEqualTo(store);
        verify(staffRepository).findById(id);
        verify(staffRepository).save(any(Staff.class));
    }

    @Test
    public void testUpdateStaffPhone() {
        byte id = 1;
        String phone = "123456789";
        Address address = new Address();
        Staff staff = new Staff();
        staff.setAddress(address);
        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.updateStaffPhone(id, phone);

        assertThat(result.getAddress().getPhone()).isEqualTo(phone);
        verify(staffRepository).findById(id);
        verify(staffRepository).save(any(Staff.class));
    }

    @Test
    public void testDeleteStaff() {
        byte id = 1;
        staffService.deleteStaff(id);

        verify(staffRepository).deleteById(id);
    }

    // Additional Test Cases

    @Test
    public void testGetStaffById() {
        byte staffId = 1;
        Staff staff = new Staff();
        when(staffRepository.findById(staffId)).thenReturn(Optional.of(staff));

        Staff result = staffService.getStaffById(staffId);

        assertThat(result).isEqualTo(staff);
        verify(staffRepository).findById(staffId);
    }

    @Test
    public void testUpdateStaff() {
        Staff staff = new Staff();
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.updateStaff(staff);

        assertThat(result).isEqualTo(staff);
        verify(staffRepository).save(staff);
    }

    @Test
    public void testAddStaff() {
        Staff staff = new Staff();
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.addStaff(staff);

        assertThat(result).isEqualTo(staff);
        verify(staffRepository).save(staff);
    }

    @Test
    public void testCreateStaff() {
        Staff staff = new Staff();
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff result = staffService.createStaff(staff);

        assertThat(result).isEqualTo(staff);
        verify(staffRepository).save(staff);
    }

    @Test
    public void testFetchAll() {
        List<Staff> staffList = new ArrayList<>();
        staffList.add(new Staff());
        when(staffRepository.findAll()).thenReturn(staffList);

        List<Staff> result = staffService.fetchAll();

        assertThat(result).hasSize(1);
        verify(staffRepository).findAll();
    }
}
