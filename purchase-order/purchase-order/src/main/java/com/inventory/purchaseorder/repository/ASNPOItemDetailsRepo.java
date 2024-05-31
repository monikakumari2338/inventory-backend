package com.inventory.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.ASNPOItemDetails;
import java.util.List;
import com.inventory.purchaseorder.entity.ASN;

public interface ASNPOItemDetailsRepo extends JpaRepository<ASNPOItemDetails, Integer> {

	List<ASNPOItemDetails> findByAsn(ASN asn);
}
