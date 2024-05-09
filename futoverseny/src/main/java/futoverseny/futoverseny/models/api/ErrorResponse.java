package futoverseny.futoverseny.models.api;

public class ErrorResponse {
    public String errorMsg;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        errorMsg = message;
    }

    public ErrorResponse errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}


