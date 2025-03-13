package com.web.testdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseData {
    public TestCaseData Test;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String confirmPassword;

}
