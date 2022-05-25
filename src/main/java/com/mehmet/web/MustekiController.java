package com.mehmet.web;

import com.mehmet.model.Musteki;
import com.mehmet.service.MustekiService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MustekiController {

    @Autowired
    private MustekiService mustekiService;

    @GetMapping(value = "/mustekiListele")
    public String mustekiListele (Model model) {
        model.addAttribute("title","Müşteki İşlemleri");
        List<Musteki> mustekiList = mustekiService.mustekiListele();
        model.addAttribute("mustekiList",mustekiList);
        return "mustekiListele";
    }
    @GetMapping(value = "/mustekiEkle")
    public String mustekiEkle (Model model) {
        model.addAttribute("title","Müşteki Ekle");

        return "mustekiEkle";
    }
    @PostMapping(value = "/mustekiKaydet")
    public @ResponseBody String mustekiKaydet (@RequestParam(value = "mustekiId",required = false)  Long mustekiId,
                                                @RequestParam ("mustekiAd") String mustekiAd,
                                                 @RequestParam("mustekiSoyad") String mustekiSoyad,
                                                 @RequestParam("mustekiTelefon") Long mustekiTelefon,
                                                 @RequestParam("mustekiEposta") String mustekiEposta) {
        JSONObject jsonObject = new JSONObject();
        if(mustekiAd.equals("") && mustekiSoyad.equals("") && mustekiEposta.equals("") &&
            mustekiTelefon.equals(0L)) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }
        Boolean exist = mustekiService.mustekiKaydet(mustekiId,mustekiAd,mustekiSoyad,mustekiEposta,mustekiTelefon);
        if(exist) {
            jsonObject.put("icon","success");
            jsonObject.put("title","Müşteki Başarıyla Kaydedildi");
        }
        else {
            jsonObject.put("icon","error");
            jsonObject.put("title","Hata");
        }
        jsonObject.put("success",true);
        jsonObject.put("exist",exist);

        return jsonObject.toString();
    }
    @GetMapping(value = "/mustekiGuncelle/{id}")
    public String mustekiGuncelle (Model model, @PathVariable("id") long id) {
        model.addAttribute("title","Musteki Güncelle");
        Musteki musteki = mustekiService.mustekiLoad(id);
        model.addAttribute("musteki",musteki);
        return "mustekiGuncelle";
    }

    @PostMapping(value = "/mustekiSil")
    public @ResponseBody String mustekiSil (@RequestParam("id") long id) {
        Boolean exist = mustekiService.mustekiSil(id);
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
