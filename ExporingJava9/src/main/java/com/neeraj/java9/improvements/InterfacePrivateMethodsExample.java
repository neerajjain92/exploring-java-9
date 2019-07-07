package com.neeraj.java9.improvements;

/**
 * Private Methods in Interface.
 *
 * @author neeraj on 2019-07-07
 * Copyright (c) 2019, exploring-java-9.
 * All rights reserved.
 */
public class InterfacePrivateMethodsExample implements UtilInterfaceWithPrivateAndDefaultMethods {

    public static void main(String[] args) {
        System.out.println("OK");

        InterfacePrivateMethodsExample it = new InterfacePrivateMethodsExample();
        System.out.println("Number of Cores is " + it.getNumberOfCores());
    }
}

interface UtilInterfaceWithPrivateAndDefaultMethods {
    default int getNumberOfCores() {
        return helper();
    }

    private int helper() {
        return Runtime.getRuntime().availableProcessors();
    }
}
