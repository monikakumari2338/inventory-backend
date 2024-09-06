
package com.inventory.myservice;

import java.util.HashMap;
import java.util.List;

import com.inventory.mydto.CategoryWiseDashboardDto;
import com.inventory.mydto.MyTasksDto;
import com.inventory.mydto.TransfersStatusDashboardDto;

public interface DashboardService {

	HashMap<String, Integer> getInventoryDiscrepancyRatio(String store);

	List<MyTasksDto> getMyTasks(String store);

	List<CategoryWiseDashboardDto> getCategoryWiseVariance(String storeName);

	TransfersStatusDashboardDto getTransferStatus(String store);

}
