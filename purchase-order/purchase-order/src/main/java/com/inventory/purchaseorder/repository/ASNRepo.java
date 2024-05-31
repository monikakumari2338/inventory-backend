package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.ASN;

public interface ASNRepo extends JpaRepository<ASN, Integer> {

//	List<ASN> findAllByStatus(String status);
////	ASN findByasnId(int id);
	ASN findByasnNumber(int num);
//	List<ASN> findByasnNumberContaining(String num);

}
