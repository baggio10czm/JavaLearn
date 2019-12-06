package com.czm127;

import javafx.css.Size;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 画背景色
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, width, height);

        // 画边框
        graphics.setColor(Color.MAGENTA);
        graphics.drawRect(0, 0, width-1, height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwwyz0123456789";
        Random random = new Random();

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial",Font.ITALIC,20));

        StringBuilder stringBuilder = new StringBuilder();

        // 随机画4个码
        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            stringBuilder.append(c);
            // 第2，3个参数为x，y轴坐标
            graphics.drawString(c+"",width/5*i,height/2);
        }

        final String s = stringBuilder.toString();
        // 将验证码存入 session
        request.getSession().setAttribute("checkCode", s);

        //graphics.drawString("c",20,25);
        //graphics.drawString("Z",40,25);
        //graphics.drawString("M",60,25);
        //graphics.drawString("G",80,25);

        // 画10条干扰线
        graphics.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            // 随机生成坐标点
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1,x2,y2);
        }

        // 输出图片
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
