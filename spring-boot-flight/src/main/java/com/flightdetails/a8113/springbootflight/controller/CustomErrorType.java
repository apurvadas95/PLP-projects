package com.flightdetails.a8113.springbootflight.controller;


    public class CustomErrorType {
        private String errorMessage;

    public CustomErrorType(String errorMessage){
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

