
package com.inventory.myservice;

import java.util.HashMap;

public interface DashboardService {

	HashMap<String, Integer> getInTransfers(String store);

	HashMap<String, Integer> getOutTransfers(String store);

	HashMap<String, Integer> getInventoryDiscrepancyRatio(String store);

	HashMap<String, Integer> getMyTasks(String store);

	HashMap<String, Float> getCategoryWiseVariance(String storeName);

}
