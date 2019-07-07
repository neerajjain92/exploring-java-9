package com.neeraj.java9.improvements;

/**
 * Effectively final in try-with-resources.
 * <p>
 * Generally should be used in case of Dependency Injection,
 * when we are getting Object from somewhere else.
 * <p>
 * // Try with Resources, ARM (Automatic Resource Management)
 *
 * @author neeraj on 2019-07-07
 * Copyright (c) 2019, exploring-java-9.
 * All rights reserved.
 */
public class EffectivelyFinalExample {

    public static void main(String[] args) {

        // Try with Resources, ARM (Automatic Resource Management)
        try (Resource resource = new Resource()) {

            resource.operation_1();

            resource.operation_3();

        } // Close will happen automatically

        // Effectively Final Example of the same
        System.out.println("============= Effectively Final in try with Resources==============");
        Resource effectivelyFinalResource = new Resource();
        try (effectivelyFinalResource) {
            effectivelyFinalResource.operation_2();
            effectivelyFinalResource.operation_3();
        }
        System.out.println(">>>>> Done from Main, Let's check if resource is available now ?");

        // yes it is available, so please be careful the object cleanup is done, but the object
        // is still available
        System.out.println(effectivelyFinalResource);
    }
}


class Resource implements AutoCloseable {
    public Resource() {
        System.out.println("Created....");
    }

    public void operation_1() {
        System.out.println("Operation..1");
    }

    public void operation_2() {
        System.out.println("Operation..2");
    }

    public void operation_3() {
        System.out.println("Operation..3");
    }

    @Override
    public void close() {
        System.out.println("Clean up Done...");
    }
}
