/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jf.chatserver.core;

/**
 *
 * @author Supriya
 */
public class Counter 
{
    private static int count ;
    public static int getCount(){
        return count++;
    }
}
