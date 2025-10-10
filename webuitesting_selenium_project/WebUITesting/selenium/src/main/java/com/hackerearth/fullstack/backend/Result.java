package com.hackerearth.fullstack.backend;

public class Result {

    private boolean buttonStatus;
    private String cursorStyle;
    private String buttonColorBeforeDisabled;
    private String buttonColorAfterDisabled;

    public Result() {}

    public Result(boolean buttonStatus, String cursorStyle, String buttonColorBeforeDisabled, String buttonColorAfterDisabled) {
        this.buttonStatus = buttonStatus;
        this.cursorStyle = cursorStyle;
        this.buttonColorBeforeDisabled = buttonColorBeforeDisabled;
        this.buttonColorAfterDisabled = buttonColorAfterDisabled;
    }

    public boolean isButtonStatus() { return buttonStatus; }
    public void setButtonStatus(boolean buttonStatus) { this.buttonStatus = buttonStatus; }

    public String getCursorStyle() { return cursorStyle; }
    public void setCursorStyle(String cursorStyle) { this.cursorStyle = cursorStyle; }

    public String getButtonColorBeforeDisabled() { return buttonColorBeforeDisabled; }
    public void setButtonColorBeforeDisabled(String buttonColorBeforeDisabled) { this.buttonColorBeforeDisabled = buttonColorBeforeDisabled; }

    public String getButtonColorAfterDisabled() { return buttonColorAfterDisabled; }
    public void setButtonColorAfterDisabled(String buttonColorAfterDisabled) { this.buttonColorAfterDisabled = buttonColorAfterDisabled; }
}
