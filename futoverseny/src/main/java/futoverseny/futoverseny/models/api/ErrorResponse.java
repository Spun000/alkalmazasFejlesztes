package futoverseny.futoverseny.models.api;

public class ErrorResponse {
    private String errorMsg;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        errorMsg = message;
    }

    public ErrorResponse errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorMsg='" + errorMsg + '\'' +
                '}';
    }
}


