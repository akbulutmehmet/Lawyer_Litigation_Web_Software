package com.mehmet.web;


import com.mehmet.model.Avukat;
import com.mehmet.service.AvukatService;
import com.mehmet.util.HashUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
     private AvukatService avukatService;

    @GetMapping(value = "/")
    public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        Object avukat = session.getAttribute("avukat");
        if(avukat != null) {
            response.sendRedirect(request.getContextPath() + "/davaListele");
        }
        return "login";

    }
    @GetMapping("/logout")
    public void logout (HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath());
    }


    @PostMapping(value = "/loginKontrol")
    public @ResponseBody  String loginKontrol(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest req, HttpServletResponse res) throws Exception{
        JSONObject jsonObject = new JSONObject();

        if (email.equals("") || password.equals("")) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }
        HashUtil hashUtil = new HashUtil(password);
        String hashPassword = hashUtil.md5();



        Avukat avukat = avukatService.loginKontrol(email,hashPassword);
        Boolean exists = false;
       if(avukat != null) {
            exists = true;
        }


        if(exists){
            HttpSession session = req.getSession();
            session.setAttribute("avukat",avukat);
            session.setAttribute("adsoyad",avukat.getAdSoyad());
            jsonObject.put("icon","success");
            jsonObject.put("title","Başarıyla giriş yaptınız");
        }
        else {
            jsonObject.put("icon","error");
            jsonObject.put("title","Hatalı giriş yaptınız");
        }

        jsonObject.put("success", true);
        jsonObject.put("exists", exists);


        return jsonObject.toString();

    }




}
