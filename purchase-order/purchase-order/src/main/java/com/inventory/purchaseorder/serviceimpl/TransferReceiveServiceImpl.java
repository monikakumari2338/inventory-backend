//package com.inventory.purchaseorder.serviceimpl;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.inventory.purchaseorder.dto.DsdReceiveItemsdto;
//import com.inventory.purchaseorder.dto.ProductCombineddto;
//import com.inventory.purchaseorder.dto.Productdto;
//import com.inventory.purchaseorder.dto.TransferReceiveInfodto;
//import com.inventory.purchaseorder.dto.TransferReceiveProductsdto;
//import com.inventory.purchaseorder.entity.ASN;
//import com.inventory.purchaseorder.entity.Category;
//import com.inventory.purchaseorder.entity.DsdInvoice;
//import com.inventory.purchaseorder.entity.DsdReceiveItems;
//import com.inventory.purchaseorder.entity.DsdSuppliers;
//import com.inventory.purchaseorder.entity.Product;
//import com.inventory.purchaseorder.entity.ProductDetails;
//import com.inventory.purchaseorder.entity.PurchaseOrder;
//import com.inventory.purchaseorder.entity.Stores;
//import com.inventory.purchaseorder.entity.TransferReceiveInfo;
//import com.inventory.purchaseorder.entity.TransferReceiveProducts;
//import com.inventory.purchaseorder.repository.ASNRepo;
//import com.inventory.purchaseorder.repository.CategoryRepo;
//import com.inventory.purchaseorder.repository.ProductDetailsRepo;
//import com.inventory.purchaseorder.repository.ProductRepo;
//import com.inventory.purchaseorder.repository.StoreRepo;
//import com.inventory.purchaseorder.repository.TransferReceiveProductsRepo;
//import com.inventory.purchaseorder.repository.TransferRecieveInfoRepo;
//import com.inventory.purchaseorder.service.TransferReceiveService;
//
//@Service
//public class TransferReceiveServiceImpl implements TransferReceiveService {
//
//	@Autowired
//	private TransferRecieveInfoRepo TransferRecieveRepo;
//
//	@Autowired
//	private ASNRepo asnRepo;
//
//	@Autowired
//	private CategoryRepo categoryRepo;
//
//	@Autowired
//	private StoreRepo storeRepo;
//
//	@Autowired
//	private TransferReceiveProductsRepo transferReceiveProdutcsRepo;
//
//	@Autowired
//	private ProductRepo productRepo;
//
//	@Autowired
//	private ProductDetailsRepo productDetailsRepo;
//
//	// Function to save Transfer-Receive info in the Transfer Receive info table
//	@Override
//	public String save_transferInfo(TransferReceiveInfodto transferReceiveInfodto) {
//		ASN asn = asnRepo.findByasnId(transferReceiveInfodto.getAsn_id());
//
////		System.out.println("asn "+asn);
////		System.out.println("transferReceiveInfodto.getAsn_id:  "+transferReceiveInfodto.getAsn_id());
////		System.out.println("transferReceiveInfodto.getStoreFrom "+transferReceiveInfodto.getStoreFrom());
////		System.out.println("transferReceiveInfodto.getStoreTo "+transferReceiveInfodto.getStoreTo());
//
//		TransferReceiveInfo TransferReceiveInfo = new TransferReceiveInfo(transferReceiveInfodto.getStoreFrom(),
//				transferReceiveInfodto.getStoreTo(), transferReceiveInfodto.getExpected_qty(),
//				transferReceiveInfodto.getReceived_qty(), transferReceiveInfodto.getStatus(), asn);
//		TransferRecieveRepo.save(TransferReceiveInfo);
//
//		return "Transfer Received info saved successfully";
//	}
//
//	// Function to save Transfer-Receive products in the Transfer Receive products
//	// table
//	@Override
//	public TransferReceiveProductsdto saveTransferReceive(TransferReceiveProductsdto transferReceiveProduct) {
//
//		TransferReceiveInfo transferReceiveInfo = TransferRecieveRepo
//				.findBytransferId(transferReceiveProduct.getTransferId());
//		TransferReceiveProducts transferReceiveProducts = transferReceiveProdutcsRepo
//				.findByItemNumberAndColorAndSizeAndStoreAndTransferInfo(transferReceiveProduct.getItemNumber(),
//						transferReceiveProduct.getColor(), transferReceiveProduct.getSize(),
//						transferReceiveProduct.getStore(), transferReceiveInfo);
//
//		System.out.println("transferReceiveProducts : " + transferReceiveProducts);
//		if (transferReceiveProducts == null) {
//
//			TransferReceiveProducts transferReceiveProducts1 = new TransferReceiveProducts(
//					transferReceiveProduct.getItemNumber(), transferReceiveProduct.getItemName(),
//					transferReceiveProduct.getExpectedQty(), transferReceiveProduct.getCategory(),
//					transferReceiveProduct.getColor(), transferReceiveProduct.getPrice(),
//					transferReceiveProduct.getSize(), transferReceiveProduct.getImageData(),
//					transferReceiveProduct.getStore(), transferReceiveProduct.getStock(), transferReceiveInfo);
//
////			System.out.println("invoice : " + dsdInvoice);
//			transferReceiveProdutcsRepo.save(transferReceiveProducts1);
//		}
//
//		else {
//			int stock = transferReceiveProducts.getStock();
//			transferReceiveProducts.setStock(stock + transferReceiveProduct.getStock());
//			transferReceiveProdutcsRepo.save(transferReceiveProducts);
//		}
//
//		return transferReceiveProduct;
//	}
//
//	// Function to get Transfer-Receive id on the basis of ASN
//	@Override
//	public List<TransferReceiveInfodto> getTransferId(String asnNumber) {
//		ASN asn = asnRepo.findByasnNumber(asnNumber);
//		List<TransferReceiveInfo> transferReceiveInfo = TransferRecieveRepo.findByAsn(asn);
//		System.out.println("DsdInvoice : " + transferReceiveInfo);
//		List<TransferReceiveInfodto> transferReceiveInfodto = new ArrayList<>();
//		for (int i = 0; i < transferReceiveInfo.size(); i++) {
//			if (transferReceiveInfo.get(i).getStatus().equals("pending")) {
//				TransferReceiveInfodto transferReceiveInfodto1 = new TransferReceiveInfodto(
//						transferReceiveInfo.get(i).getTransferId(), transferReceiveInfo.get(i).getStoreFrom(),
//						transferReceiveInfo.get(i).getStoreTo(), transferReceiveInfo.get(i).getExpected_qty(),
//						transferReceiveInfo.get(i).getReceived_qty(), transferReceiveInfo.get(i).getStatus(),
//						transferReceiveInfo.get(i).getAsn().getAsnId());
//
//				transferReceiveInfodto.add(transferReceiveInfodto1);
//			}
//
//		}
//		return transferReceiveInfodto;
//	}
//
//	// Function to get Transfer-Receive products on the basis of transferId
//	@Override
//	public List<TransferReceiveProductsdto> getTransferReceiveProducts(int transferId) {
//		TransferReceiveInfo transferReceiveInfo = TransferRecieveRepo.findBytransferId(transferId);
//		List<TransferReceiveProductsdto> transferReceiveProductsdto = new ArrayList<>();
////		System.out.println("transferReceiveInfo : " + transferReceiveInfo);
////		System.out.println("transferReceiveProducts : " + transferReceiveProducts);
//		if (transferReceiveInfo.getStatus().equals("pending")) {
//			List<TransferReceiveProducts> transferReceiveProducts = transferReceiveProdutcsRepo
//					.findBytransferInfo(transferReceiveInfo);
//
//			for (int i = 0; i < transferReceiveProducts.size(); i++) {
//				transferReceiveProductsdto.add(new TransferReceiveProductsdto(
//						transferReceiveProducts.get(i).getItemNumber(), transferReceiveProducts.get(i).getItemName(),
//						transferReceiveProducts.get(i).getExpectedQty(), transferReceiveProducts.get(i).getCategory(),
//						transferReceiveProducts.get(i).getColor(), transferReceiveProducts.get(i).getPrice(),
//						transferReceiveProducts.get(i).getSize(), transferReceiveProducts.get(i).getImageData(),
//						transferReceiveProducts.get(i).getStore(), transferReceiveProducts.get(i).getStock(),
//						transferReceiveProducts.get(i).getTransferInfo().getTransferId()));
//			}
//		}
//		return transferReceiveProductsdto;
//	}
//
//	// Function to save Transfer-Receive in master table
//	@Override
//	public List<ProductCombineddto> saveTransferRecieveProducts(List<ProductCombineddto> productCombineddto,
//			int transferId) {
//
//		TransferReceiveInfo transferReceiveInfo = TransferRecieveRepo.findBytransferId(transferId);
//		Stores storeFrom = storeRepo.findByStoreId(transferReceiveInfo.getStoreFrom());
//		System.out.println("store :  " + storeFrom);
//		// if (!invoiceStatus.equals("complete")) {
//		for (int i = 0; i < productCombineddto.size(); i++) {
//
//			Stores store1 = storeRepo.findByStoreName(productCombineddto.get(i).getProductDetailsdto().getStore());
//			Category category = categoryRepo
//					.findByCategory(productCombineddto.get(i).getProductdto().getCategoryName());
//
//			Product product = productRepo.findByItemNumber(productCombineddto.get(i).getProductdto().getItemNumber());
//
//			System.out.println("product : " + product);
//
//			if (product == null) {
//				Product product1 = new Product(productCombineddto.get(i).getProductdto().getItemNumber(),
//						productCombineddto.get(i).getProductdto().getItemName(), category);
//
//				Productdto Productdto = new Productdto(product1.getItemNumber(), product1.getitemName(),
//						productCombineddto.get(i).getProductdto().getCategoryName());
//				productRepo.save(product1);
//				// productCombineddto1.get(i).setProductdto(Productdto);
//
//				Product product2 = productRepo
//						.findByItemNumber(productCombineddto.get(i).getProductdto().getItemNumber());
//				ProductDetails productDetails2 = new ProductDetails(
//						productCombineddto.get(i).getProductDetailsdto().getColor(),
//						productCombineddto.get(i).getProductDetailsdto().getPrice(),
//						productCombineddto.get(i).getProductDetailsdto().getSize(),
//						productCombineddto.get(i).getProductDetailsdto().getSellableStock(),
//						productCombineddto.get(i).getProductDetailsdto().getNonSellableStock(),
//						productCombineddto.get(i).getProductDetailsdto().getImageData(), store1, product2,
//						productCombineddto.get(i).getProductDetailsdto().getUpc(),
//						productCombineddto.get(i).getProductDetailsdto().getSku());
//
//				productDetailsRepo.save(productDetails2);
//
//				System.out.println("productDetails2: " + productDetails2);
//
//			} else {
//				ProductDetails productDetails1 = productDetailsRepo.findByColorAndSizeAndStoreAndProduct(
//						productCombineddto.get(i).getProductDetailsdto().getColor(),
//						productCombineddto.get(i).getProductDetailsdto().getSize(), store1, product);
//
////				ProductDetails productDetails2 = productDetailsRepo.findByColorAndSizeAndStoreAndProduct(
////						productCombineddto.get(i).getProductDetailsdto().getColor(),
////						productCombineddto.get(i).getProductDetailsdto().getSize(), storeFrom, product);
//
//				System.out.println("productDetails1: " + productDetails1);
////				System.out.println("productDetails2: "+productDetails2);
//				int Prev_stock;
//				int new_stock;
//				int total_stock = 0;
//
//				int Prev_stock1;
//				int new_stock1;
//				int total_stock1 = 0;
//				// System.out.println("productDetails1 : " + productDetails1);
//				if (productDetails1 != null) {
//					Prev_stock = productDetails1.getSellableStock();
//					new_stock = productCombineddto.get(i).getProductDetailsdto().getSellableStock();
//					total_stock = Prev_stock + new_stock;
//					productDetails1.setSellableStock(total_stock);
//					// System.out.println("total_stock : " + total_stock);
//					System.out.println("productDetails1 : " + productDetails1);
//
//					productDetailsRepo.save(productDetails1);
//					// System.out.println("saved : inside else if");
//				}
//
//				else {
//					ProductDetails productDetails3 = new ProductDetails(
//							productCombineddto.get(i).getProductDetailsdto().getColor(),
//							productCombineddto.get(i).getProductDetailsdto().getPrice(),
//							productCombineddto.get(i).getProductDetailsdto().getSize(),
//							productCombineddto.get(i).getProductDetailsdto().getSellableStock(),
//							productCombineddto.get(i).getProductDetailsdto().getNonSellableStock(),
//							productCombineddto.get(i).getProductDetailsdto().getImageData(), store1, product,
//							productCombineddto.get(i).getProductDetailsdto().getUpc(),
//							productCombineddto.get(i).getProductDetailsdto().getSku());
//					productDetailsRepo.save(productDetails3);
//
//					// System.out.println("saved : inside else");
//				}
//
////				Prev_stock1 = productDetails2.getStock();
////				new_stock1 = productCombineddto.get(i).getProductDetailsdto().getStock();
////				total_stock1 = Prev_stock1 - new_stock1;
////				productDetails2.setStock(total_stock1);
////				System.out.println("total_stock1 : " + total_stock1);
////				System.out.println("productDetails2 : " + productDetails2);
////				productDetailsRepo.save(productDetails2);
//
//			}
//
//		}
//		transferReceiveInfo.setStatus("complete");
//		TransferRecieveRepo.save(transferReceiveInfo);
//
////		dsdInvoice.setStatus("complete");
////		invoiceRepo.save(dsdInvoice);
//		return productCombineddto;
//
//	}
//
//	@Override
//	public Set<String> getAllAsnIdFromTransferReceive() {
//
//		Set<String> asnNumber_list = new HashSet<>();
//		List<TransferReceiveInfo> transferReceiveInfo_list = TransferRecieveRepo.findAll();
//
//		for (int i = 0; i < transferReceiveInfo_list.size(); i++) {
//			if (transferReceiveInfo_list.get(i).getStatus().equals("pending")) {
//				asnNumber_list.add(transferReceiveInfo_list.get(i).getAsn().getAsnNumber());
//			}
//
//		}
//
//		return asnNumber_list;
//	}
//
//	@Override
//	public List<TransferReceiveInfo> getAllTransferReceive() {
//
//		List<TransferReceiveInfo> transferReceiveInfo_list = TransferRecieveRepo.findAll();
//		return transferReceiveInfo_list;
//	}
//
//}
