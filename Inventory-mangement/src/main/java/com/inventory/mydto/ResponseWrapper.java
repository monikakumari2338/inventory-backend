package com.inventory.mydto;

import java.util.List;
import java.util.Map;

public class ResponseWrapper<T> {
	private List<T> excelProductsdto;
	private Map<String, String> errorMap;

	public List<T> getExcelProductsdto() {
		return excelProductsdto;
	}

	public void setExcelProductsdto(List<T> excelProductsdto) {
		this.excelProductsdto = excelProductsdto;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public ResponseWrapper(Map<String, String> errorMap) {
		super();
		this.excelProductsdto = null;
		this.errorMap = errorMap;
	}

	public ResponseWrapper(List<T> excelProductsdto) {
		super();
		this.excelProductsdto = excelProductsdto;
		this.errorMap = null;
	}

	@Override
	public String toString() {
		return "ResponseWrapper [excelProductsdto=" + excelProductsdto + ", errorMap=" + errorMap + "]";
	}

}