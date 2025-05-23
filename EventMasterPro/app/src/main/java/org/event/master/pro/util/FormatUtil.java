/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.util;

import java.text.DecimalFormat;

/**
 *
 * @author Luisa
 */
public class FormatUtil {
    public static String formatNumber(Double number){
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        return formatter.format(number);
    }
}
