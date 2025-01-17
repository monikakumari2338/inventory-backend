
package com.inventory.dashboard.service;

import java.util.HashMap;
import java.util.List;

import com.inventory.dashboard.jpa.dto.CategoryWiseDashboardDto;
import com.inventory.dashboard.jpa.dto.MyTasksDto;
import com.inventory.tsf.jpa.dto.TransfersStatusDashboardDto;

public interface DashboardService {

	HashMap<String, Integer> getInventoryDiscrepancyRatio(String store);

	List<MyTasksDto> getMyTasks(String store);

	List<CategoryWiseDashboardDto> getCategoryWiseVariance(String storeName);

	TransfersStatusDashboardDto getTransferStatus(String store);

}
