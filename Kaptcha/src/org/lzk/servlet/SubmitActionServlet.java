package org.lzk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;



public class SubmitActionServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        String key = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        
        response.setContentType("text/html;charset=utf-8");
        
        if(username.isEmpty()||password.isEmpty()||checkcode.isEmpty())
        	JOptionPane.showMessageDialog(null, "输入不得为空！");
        else if(!(username.equals("admin")&&password.equals("admin")))
        	JOptionPane.showMessageDialog(null, "用户名或密码有误！");
        else if(!(checkcode.toLowerCase()).equals((key.toLowerCase())))
        	JOptionPane.showMessageDialog(null, "验证码输入错误！");
        else
        	JOptionPane.showMessageDialog(null, "验证成功！");
        
        response.sendRedirect("/Kaptcha/");  
    }
}