package com.mehmet.web;

import com.mehmet.model.Avukat;
import com.mehmet.model.Davali;
import com.mehmet.service.DavaliService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DavaliController {

    @Autowired
    private DavaliService davaliService;

    @GetMapping(value = "/davaliListele")
    public String davaliListele (Model model) {
        model.addAttribute("title","Davalı İşlemleri");
        List<Davali> davaliList = davaliService.davaliListele();
        model.addAttribute("davaliList",davaliList);
        return "davaliListele";
    }
    @GetMapping(value = "/davaliEkle")
    public String davaliEkle (Model model) {
        model.addAttribute("title","Davalı Ekle");

        return "davaliEkle";
    }
    @PostMapping(value = "/davaliKaydet")
    public @ResponseBody String davaliKaydet (@RequestParam(value = "davaliId",required = false)  Long davaliId,
                                              @RequestParam ("davaliAd") String davaliAd,
                                              @RequestParam("davaliSoyad") String davaliSoyad,
                                              @RequestParam("davaliTelefon") Long davaliTelefon,
                                              @RequestParam("davaliEposta") String davaliEposta) {
        JSONObject jsonObject = new JSONObject();
        if(davaliAd.equals("") && davaliSoyad.equals("") && davaliEposta.equals("") &&
                davaliTelefon.equals(0L)) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }

        Boolean exist = davaliService.davaliKaydet(davaliId,davaliAd,davaliSoyad,davaliEposta,davaliTelefon);
        if(exist) {
            jsonObject.put("icon","success");
            jsonObject.put("title","Davalı  Başarıyla Kaydedildi");
        }
        else {
            jsonObject.put("icon","error");
            jsonObject.put("title","Hata");
        }
        jsonObject.put("success",true);
        jsonObject.put("exist",exist);

        return jsonObject.toString();
    }
    @GetMapping(value = "/davaliGuncelle/{id}")
    public String davaliGuncelle (Model model, @PathVariable("id") long id) {
        model.addAttribute("title","Davalı Güncelle");
        Davali davali = davaliService.davaliLoad(id);
        model.addAttribute("davali",davali);
        return "davaliGuncelle";
    }

    @PostMapping(value = "/davaliSil")
    public @ResponseBody String davaliSil (@RequestParam("id") long id) {
        Boolean exist = davaliService.davaliSil(id);
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
