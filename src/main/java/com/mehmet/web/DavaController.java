package com.mehmet.web;

import com.mehmet.model.Dava;
import com.mehmet.model.Davali;
import com.mehmet.model.Musteki;
import com.mehmet.service.DavaService;
import com.mehmet.service.DavaliService;
import com.mehmet.service.MustekiService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DavaController {

    @Autowired
    private DavaService davaService;
    @Autowired
    private DavaliService davaliService;

    @Autowired
    private MustekiService mustekiService;


    @GetMapping(value = "/davaListele")
    public String davaliListele (Model model) {
        model.addAttribute("title","Davalı İşlemleri");
        List<Dava> davaList = davaService.davaListele();
        model.addAttribute("davaList",davaList);
        return "davaListele";
    }
    @GetMapping(value = "/davaEkle")
    public String davaEkle (Model model) {
        model.addAttribute("title","Dava Ekle");
        List<Musteki> mustekiList = mustekiService.mustekiListele();
        List<Davali> davaliList = davaliService.davaliListele();

        model.addAttribute("mustekiList",mustekiList);
        model.addAttribute("davaliList",davaliList);
        return "davaEkle";
    }
    @PostMapping(value = "/davaKaydet")
    public @ResponseBody String davaKaydet (@RequestParam(value = "davaId",required = false)  Long davaId,
                                              @RequestParam ("davaAd") String davaAd,
                                              @RequestParam("davaTipi") String davaTipi,
                                              @RequestParam("davaNumarasi") Long davaNumarasi,
                                              @RequestParam("davaliId") Long davaliId,
                                              @RequestParam("mustekiId") Long mustekiId  ) {
        JSONObject jsonObject = new JSONObject();
        if(davaAd.equals("") && davaTipi.equals("")) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }
        Boolean exist = davaService.davaKaydet(davaId,davaAd,davaTipi,davaNumarasi,davaliId,mustekiId);
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
    @GetMapping(value = "/davaGuncelle/{id}")
    public String davaGuncelle (Model model, @PathVariable("id") long id) {
        model.addAttribute("title","Davalı Güncelle");
        Dava dava = davaService.davaLoad(id);
        List<Musteki> mustekiList = mustekiService.mustekiListele();
        List<Davali> davaliList = davaliService.davaliListele();

        model.addAttribute("mustekiList",mustekiList);
        model.addAttribute("davaliList",davaliList);
        model.addAttribute("dava",dava);
        return "davaGuncelle";
    }

    @PostMapping(value = "/davaSil")
    public @ResponseBody String davaSil (@RequestParam("id") long id) {
        Boolean exist = davaService.davaSil(id);
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
