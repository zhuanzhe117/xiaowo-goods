package com.xiaowo.common.swagger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* =======================================================
 * 小窝
 * 日 期：10/3/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：swagger请求servlet
 * ========================================================
 */
@WebServlet(
        value = {"/swagger"},
        name = "swagger"
)
public class SwaggerServlet extends HttpServlet{

    public SwaggerServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/swagger/index.html");
    }
}
