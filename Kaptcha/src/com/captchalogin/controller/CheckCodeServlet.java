package com.captchalogin.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkcode")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String captcha = request.getParameter("captcha");
		String last_captcha = (String)session.getAttribute("captchacode");
		
		if(captcha != null) {
			PrintWriter pw = response.getWriter();
			if(captcha.equalsIgnoreCase(last_captcha)) {
				pw.println("OK");
				return;
			}else {
				pw.println("ERROR");
				return;
			}
		}
		//输出格式
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
		
		int width = 120;
		int height = 37;
		int lines = 7;
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		
		//设置背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		//设置字体
		g.setFont(new Font("黑体",Font.BOLD,22));
		 //随机数字
		Random r = new Random(new Date().getTime());
		String captchacode = "";
		String str[] = {"0","1","2","3","4","5","6","7","8","9","A","B",
				"C","D","E","F","G","H","I","J","K","L","M","N","O","P",
				"Q","R","S","T","U","V","W","X","Y","Z"};
		for(int i=0;i<4;i++) {
			int a = r.nextInt(36);
			int y = 20+r.nextInt(10);
			String s = str[a];
			Color c = new Color(r.nextInt(200),r.nextInt(200),r.nextInt(200));
			g.setColor(c);
			g.drawString(""+s, 5+i*width/4, y);
			captchacode += s;			
		}
		System.out.println(captchacode);
		g.dispose();
		ImageIO.write(img, "JPG", response.getOutputStream());
		session.setAttribute("captchacode",captchacode);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
	}

}
