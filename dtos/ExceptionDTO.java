package com.example.librarymanagmentsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    private String message;
    private String resolution;
    
    // Additional fields
    private String errorCode;
    private LocalDateTime timestamp;
    private String path;
    private String method;
    private String userId;
    private String userRole;
    private String details;
    public ExceptionDTO(String message, String resolution) {
        this.message = message;
        this.resolution = resolution;
        this.timestamp = LocalDateTime.now();
    }
    public String getFullDetails() {
        return "ExceptionDTO{" +
                "message='" + message + '\'' +
                ", resolution='" + resolution + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", timestamp=" + timestamp +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", userId='" + userId + '\'' +
                ", userRole='" + userRole + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
    public void setAdditionalDetails(String path, String method, String userId, String userRole, String details) {
        this.path = path;
        this.method = method;
        this.userId = userId;
        this.userRole = userRole;
        this.details = details;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public static ExceptionDTO fromException(Exception e, String resolution, String path, String method) {
        return new ExceptionDTO(e.getMessage(), resolution, "UNKNOWN_ERROR", LocalDateTime.now(), path, method, null, null, null);
    }
    public static ExceptionDTO fromExceptionWithUserDetails(Exception e, String resolution, String path, String method, String userId, String userRole) {
        return new ExceptionDTO(e.getMessage(), resolution, "UNKNOWN_ERROR", LocalDateTime.now(), path, method, userId, userRole, null);
    }
    public ExceptionDTO(String message, String resolution, String errorCode, LocalDateTime timestamp, String path, String method, String userId, String userRole, String details) {
        this.message = message;
        this.resolution = resolution;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
        this.path = path;
        this.method = method;
        this.userId = userId;
        this.userRole = userRole;
        this.details = details;
    }
}
