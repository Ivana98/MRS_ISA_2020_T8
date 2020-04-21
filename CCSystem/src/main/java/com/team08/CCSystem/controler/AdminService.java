package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.team08.CCSystem.model.Admin;

@Component
public class AdminService {
private static List<Admin> listaAdmina = new ArrayList<>();
	
	static {
		
		listaAdmina.add(new Admin("Fica" , "fkpr76"));
		listaAdmina.add(new Admin("Mare" , "yyy"));
		listaAdmina.add(new Admin("Ogisa" , "880"));
		
	}
	
	public List<Admin> getAll() {
		return listaAdmina;
	}
	
	public void save(Admin a) {
		listaAdmina.add(a);
	}
	
}
