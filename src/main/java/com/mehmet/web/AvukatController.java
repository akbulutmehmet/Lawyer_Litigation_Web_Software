package com.mehmet.web;

import com.mehmet.model.Avukat;
import com.mehmet.service.AvukatService;
import com.mehmet.util.HashUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AvukatController {
    @Autowired
    private AvukatService avukatService;

    @GetMapping(value = "/avukatListele")
    public String avukatListele(Model model) {
        model.addAttribute("title","Avukat İşlemleri");
        List<Avukat> avukatList = avukatService.avukatListele();
        model.addAttribute("avukatList",avukatList);
        return "avukatListele";
    }
    @GetMapping(value = "/avukatEkle")
    public String avukatEkle(Model model) {
        model.addAttribute("title","Avukat Ekle");
        return "avukatEkle";
    }
    @PostMapping(value = "/avukatKaydet")
    public @ResponseBody String avukatKaydet (@RequestParam("isim") String isim,@RequestParam("soyisim") String soyIsim,
                                                       @RequestParam("email") String email,@RequestParam("password") String password) {
        JSONObject jsonObject = new JSONObject();
        if(isim.equals("") || soyIsim.equals("") || email.equals("") || password.equals("")) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }
        HashUtil hashUtil = new HashUtil(password);
        String hashPassword = hashUtil.md5();
        Boolean exist = avukatService.avukatKaydet(isim,soyIsim,email,hashPassword);
        if(exist) {
            jsonObject.put("icon","success");
            jsonObject.put("title","Ekleme işlemi başarılı");
        }
        else {
            jsonObject.put("icon","error");
            jsonObject.put("title","Hata");
        }
        jsonObject.put("success",true);
        jsonObject.put("exist",exist);
        return  jsonObject.toString();
    }
    @GetMapping(value = "/avukatGuncelle/{id}")
    public String insanKaynaklariGuncelle(Model model,@PathVariable("id") long id) {
        model.addAttribute("title","Avukat Güncelle");
        Avukat avukat = avukatService.avukatLoad(id);
        model.addAttribute("avukat",avukat);
        return "avukatGuncelle";
    }
    @PostMapping(value = "/avukatUpdate")
    public @ResponseBody String avukatUpdate (@RequestParam("id") Long id,
                                                       @RequestParam("isim") String isim,
                                                       @RequestParam("soyisim") String soyisim,
                                                       @RequestParam("email") String email,
                                                       @RequestParam("password") String password) {
        JSONObject jsonObject = new JSONObject();
        if(id.equals(0L)||isim.equals("") || soyisim.equals("") || email.equals("") || password.equals("")) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }
        Avukat avukat = avukatService.avukatLoad(id);
        HashUtil hashUtil;
        String hashPassword;
        if(!password.equals(avukat.getAvukatSifre())) {
            hashUtil = new HashUtil(password);
             hashPassword = hashUtil.md5();
        }
        else  {
            hashPassword = password;
        }

        Boolean exist = avukatService.avukatUpdate(id,isim,soyisim,email,hashPassword);

        if(exist) {
            jsonObject.put("icon","success");
            jsonObject.put("title","Başarı ile güncellendi");
        }
        else {
            jsonObject.put("icon","error");
            jsonObject.put("title","Hata");
        }
        jsonObject.put("success",true);
        jsonObject.put("exist",exist);
        return jsonObject.toString();
    }
    @PostMapping(value = "/avukatSil")
    public @ResponseBody String avukatSil (@RequestParam("id") long id) {
        Boolean exist = avukatService.avukatSil(id);
        JSONObject jsonObject = new JSONObject();
        if(exist) {
            jsonObject.put("icon","success");
            jsonObject.put("title","Silme işlemi başarılı");
        }
        else {
            jsonObject.put("icon","error");
            jsonObject.put("title","Hata");
        }
        jsonObject.put("success",true);
        jsonObject.put("exist",exist);
        return jsonObject.toString();
    }
}
