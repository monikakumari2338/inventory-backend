package com.inventory.mydto;

import java.util.List;

public class TSFCombinedDto {

	private TsfHeadDto tsfHeadDto;
	private List<TsfDetailsDto> tsfDetailsDto;

	public TsfHeadDto getTsfHeadDto() {
		return tsfHeadDto;
	}

	public void setTsfHeadDto(TsfHeadDto tsfHeadDto) {
		this.tsfHeadDto = tsfHeadDto;
	}

	public List<TsfDetailsDto> getTsfDetailsDto() {
		return tsfDetailsDto;
	}

	public void setTsfDetailsDto(List<TsfDetailsDto> tsfDetailsDto) {
		this.tsfDetailsDto = tsfDetailsDto;
	}

	public TSFCombinedDto(TsfHeadDto tsfHeadDto, List<TsfDetailsDto> tsfDetailsDto) {
		super();
		this.tsfHeadDto = tsfHeadDto;
		this.tsfDetailsDto = tsfDetailsDto;
	}

	@Override
	public String toString() {
		return "TSFCombinedDto [tsfHeadDto=" + tsfHeadDto + ", tsfDetailsDto=" + tsfDetailsDto + "]";
	}

}
