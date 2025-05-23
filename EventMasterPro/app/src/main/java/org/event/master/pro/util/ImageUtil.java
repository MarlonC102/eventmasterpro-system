/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.util;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Luisa
 */
public class ImageUtil {
    
    public static void setIcon(JFrame frame){
        Image ico = Toolkit.getDefaultToolkit().getImage(ImageUtil.class.getResource("/img/icon.png"));
        frame.setIconImage(ico);
    }
}
