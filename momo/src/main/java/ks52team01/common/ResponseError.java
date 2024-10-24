package ks52team01.common;

import lombok.Data;

@Data
public class ResponseError {
	private boolean isSuccess;
	private String errorCode;
	private String errorMessage;
}
