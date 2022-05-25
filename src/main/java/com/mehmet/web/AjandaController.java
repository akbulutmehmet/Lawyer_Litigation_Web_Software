package com.mehmet.web;

import com.mehmet.model.*;
import com.mehmet.service.AjandaService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AjandaController {

    @Autowired
    private AjandaService ajandaService;


    @GetMapping(value = "/ajandaListele")
    public String ajandaListele (Model model, HttpServletRequest request) {
        model.addAttribute("title","Ajanda İşlemleri");
        Avukat avukat = (Avukat) request.getSession().getAttribute("avukat");
        List<Ajanda> ajandaList = ajandaService.ajandaListele(avukat.getAvukatId());

        model.addAttribute("ajandaList",ajandaList);
        return "ajandaListele";
    }

    @GetMapping(value = "/ajandaEkle")
    public String ajandaEkle (Model model) {
        model.addAttribute("title","Ajanda Ekle");

        return "ajandaEkle";
    }

    @PostMapping(value = "/ajandaKaydet")
    public @ResponseBody String ajandaKaydet (
            @RequestParam(value = "ajandaId",required = false) Long ajandaId,
            @RequestParam("ajandaIsim") String ajandaIsim,
            @RequestParam("baslangicTarihi") String baslangicTarihi,
            @RequestParam("bitisTarihi") String bitisTarihi,
            HttpServletRequest request
    ) {
        JSONObject jsonObject = new JSONObject();
        if(ajandaIsim.equals("") && baslangicTarihi.equals("") && bitisTarihi.equals("")
        ) {
            jsonObject.put("success",true);
            jsonObject.put("exist",false);
            jsonObject.put("icon","error");
            jsonObject.put("title","Zorunlu alanları doldurunuz");
            return jsonObject.toString();
        }
        Avukat avukat = (Avukat) request.getSession().getAttribute("avukat");
        Boolean exist = ajandaService.ajandaKaydet(ajandaId,ajandaIsim,baslangicTarihi,bitisTarihi,avukat);
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
    @PostMapping(value = "/ajandaSil")
    public @ResponseBody String davaSil (@RequestParam("id") long id) {
        Boolean exist = ajandaService.ajandaSil(id);
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

    @GetMapping(value = "/ajandaGuncelle/{id}")
    public String ajandaGuncelle (Model model, @PathVariable("id") long id) {
        model.addAttribute("title","Ajanda Güncelle");
        Ajanda ajanda = ajandaService.ajandaLoad(id);

        model.addAttribute("ajanda",ajanda);
        return "ajandaGuncelle";
    }
}
