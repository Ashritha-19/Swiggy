package com.neoteric.swiggyapp.swiggyservice;

import com.neoteric.swiggyapp.swiggymodel.Credentials;
import com.neoteric.swiggyapp.swiggymodel.GenerateOTP;


public class LoginService {
    public GenerateOTP generateOTP;

    public GenerateOTP login(Credentials credentials) {

        if (credentials.phnNumber == 900030833) {
            GenerateOTP otp1 = new GenerateOTP();
            otp1.generatedOTP = 1234;
            generateOTP = otp1;
            System.out.println(generateOTP);
        }
        return generateOTP;
    }

    public String getLoging(Credentials credentials) {
        if (generateOTP.generatedOTP == credentials.otp.generatedOTP) {
            System.out.println("Login Successful");
            return "Login Successful";
        } else {
            System.out.println("Invalid OTP");
            return "Invalid OTP";
        }
    }
}

