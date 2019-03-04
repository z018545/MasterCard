package com.mastercard.findPath.ui.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {
	
	private Status status = Status.SUCCESS;
	
	private String errorMessge;
	
	private T payload;
	
	public ServiceResponse(T payload){
		this.payload = payload;
	}
	
	public ServiceResponse(String errorMessage) {
		this.status = Status.ERROR;
		this.errorMessge = errorMessage;
	}
}
