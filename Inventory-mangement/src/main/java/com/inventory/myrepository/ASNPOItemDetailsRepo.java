package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.ASN;
import com.inventory.myentity.ASNPOItemDetails;

import jakarta.transaction.Transactional;

import java.util.List;

public interface ASNPOItemDetailsRepo extends JpaRepository<ASNPOItemDetails, Integer> {

	List<ASNPOItemDetails> findByAsn(ASN asn);

	@Transactional
	void deleteAllByAsn(ASN asn);

	ASNPOItemDetails findByAsnAndSku(ASN asn, String sku);

}
