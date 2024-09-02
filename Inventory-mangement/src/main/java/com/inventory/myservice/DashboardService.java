
package com.inventory.myservice;

import java.util.HashMap;
import java.util.List;

import com.inventory.mydto.MyTasksDto;

public interface DashboardService {

	HashMap<String, Integer> getInTransfers(String store);

	HashMap<String, Integer> getOutTransfers(String store);

	HashMap<String, Integer> getInventoryDiscrepancyRatio(String store);

	List<MyTasksDto> getMyTasks(String store);

	HashMap<String, Float> getCategoryWiseVariance(String storeName);

}
