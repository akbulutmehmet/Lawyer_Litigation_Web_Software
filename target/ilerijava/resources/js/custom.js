$(document).on('click','.btnPersonelSil',function () {
    $(".btnPersonelSil").click(function () {
        let data_id = $(this).data("id");
        let url = "personelSil";
        Swal.fire({
            title: 'Silmek İstediğinize Emin Misiniz?',
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Sil',
            denyButtonText: `İptal`,
        }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {
                        personelId : data_id
                    },
                    success: function (response) {
                        Swal.fire({
                            position: 'center',
                            icon: response.icon,
                            title: response.title,
                            showConfirmButton: false,
                            timer: 10000
                        });

                        if(response.exist) {
                            window.location.href = "personelListele";
                        }
                    },
                    dataType: "json"
                });
            } else if (result.isDenied) {
                Swal.fire('Silme işlemi iptal edildi.', '', 'success')
            }
        })


    });
});
$("#personelTables").DataTable(
    {
        serverSide : true,
        processing: true,
        ajax : {
            url : 'personelData',
            method: 'POST',
            dataType:'JSON'
        },
        columns : [
            {data : 'personelId'},
            {data : 'personelAd'},
            {data : 'personelSoyad'},
            {data : 'personelTc'},
            {data : 'personelCinsiyet'},
            {data : 'isBaslangicTarihi'},
            {data : 'departman'},
            {data : 'gorev'},
            {data : 'islemler',orderable:false},
        ],
        lengthMenu: [
            [5,10,15,20,25,50,100,1000,3000,5000,10000,-1],
            [5,10,15,20,25,50,100,1000,3000,5000,10000,'All']
        ],
        language: {
            url: "//cdn.datatables.net/plug-ins/1.12.0/i18n/tr.json",
        }
    }
);
$("#dataTables").DataTable(
    {
        language: {
            url: "//cdn.datatables.net/plug-ins/1.12.0/i18n/tr.json",
        },
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print',

        ]
    }
);
$("#btnIkKaydet").click(function () {
    let url = "avukatKaydet";
    let isim = $("#isim").val().trim();
    let soyisim = $("#soyisim").val();
    let email = $("#email").val();
    let password = $("#password").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            isim : isim,
            soyisim : soyisim,
            email : email,
            password : password
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 10000
            });
            if(response.exist) {

                window.location.href = "avukatListele";

            }
        },
        dataType: "json"
    });
});
$("#btnIkGuncelle").click(function () {
    let url = $("#dataUrl").val();
    let redirect_url = $("#redirectUrl").val();
    let data_id = $("#ikId").val();
    let isim = $("#isim").val();
    let soyisim = $("#soyisim").val();
    let email = $("#email").val();
    let password = $("#password").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            id : data_id,
            isim : isim,
            soyisim : soyisim,
            email : email,
            password : password
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 3000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {
                window.location.href = redirect_url;
            }
        },
        dataType: "json"
    });

});
$(".btnIkSil").click(function () {
        let data_id = $(this).data("id");
        let url = "avukatSil";
        Swal.fire({
            title: 'Silmek İstediğinize Emin Misiniz?',
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Sil',
            denyButtonText: `İptal`,
        }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {
                        id : data_id
                    },
                    success: function (response) {
                        Swal.fire({
                            position: 'center',
                            icon: response.icon,
                            title: response.title,
                            showConfirmButton: false,
                            timer: 10000
                        });

                        if(response.exist) {
                            window.location.href = "avukatListele";
                        }
                    },
                    dataType: "json"
                });
            } else if (result.isDenied) {
                Swal.fire('Silme işlemi iptal edildi.', '', 'success')
            }
        })

    });
$("#btnMustekiEkle").click(function () {
    let url = "mustekiKaydet";
    let mustekiAd = $("#mustekiAd").val();
    let mustekiSoyad = $("#mustekiSoyad").val();
    let mustekiTelefon = $("#mustekiTelefon").val();
    let mustekiEposta = $("#mustekiEposta").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            mustekiAd : mustekiAd,
            mustekiSoyad:mustekiSoyad,
            mustekiTelefon : mustekiTelefon,
            mustekiEposta : mustekiEposta
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 10000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {

                window.location.href = "mustekiListele";

            }
        },
        dataType: "json"
    });

});
$("#btnDepartmanGuncelle").click(function () {
    let url = $("#dataUrl").val();
    let redirect_url = $("#redirectUrl").val();
    let mustekiId = $("#mustekiId").val();
    let mustekiAd = $("#mustekiAd").val();
    let mustekiSoyad = $("#mustekiSoyad").val();
    let mustekiTelefon = $("#mustekiTelefon").val();
    let mustekiEposta = $("#mustekiEposta").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            mustekiId : mustekiId,
            mustekiAd : mustekiAd,
            mustekiSoyad : mustekiSoyad,
            mustekiEposta : mustekiEposta,
            mustekiTelefon : mustekiTelefon
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 3000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {
                window.location.href = redirect_url;
            }
        },
        dataType: "json"
    });
});
$(".btnDepartmanSil").click(function () {
        let data_id = $(this).data("id");
        let url = "mustekiSil";
        Swal.fire({
            title: 'Silmek İstediğinize Emin Misiniz?',
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Sil',
            denyButtonText: `İptal`,
        }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {
                        id : data_id
                    },
                    success: function (response) {
                        Swal.fire({
                            position: 'center',
                            icon: response.icon,
                            title: response.title,
                            showConfirmButton: false,
                            timer: 10000
                        });

                        if(response.exist) {
                            window.location.href = "mustekiListele";
                        }
                    },
                    dataType: "json"
                });
            } else if (result.isDenied) {
                Swal.fire('Silme işlemi iptal edildi.', '', 'success')
            }
        })

    });
$("#btnDavaEkle").click(function () {
    let url = "davaliKaydet";
    let davaliAd = $("#davaliAd").val();
    let davaliSoyad = $("#davaliSoyad").val();
    let davaliTelefon = $("#davaliTelefon").val();
    let davaliEposta = $("#davaliEposta").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            davaliAd : davaliAd,
            davaliSoyad : davaliSoyad,
            davaliTelefon : davaliTelefon,
            davaliEposta : davaliEposta
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 10000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {

                window.location.href = "davaliListele";

            }
        },
        dataType: "json"
    });

});

$("#btnDavaliGuncelle").click(function () {
    let url = $("#dataUrl").val();
    let redirect_url = $("#redirectUrl").val();
    let davaliId = $("#davaliId").val();
    let davaliAd = $("#davaliAd").val();
    let davaliSoyad = $("#davaliSoyad").val();
    let davaliTelefon = $("#davaliTelefon").val();
    let davaliEposta = $("#davaliEposta").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            davaliId : davaliId,
            davaliAd : davaliAd,
            davaliSoyad : davaliSoyad,
            davaliTelefon : davaliTelefon,
            davaliEposta : davaliEposta
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 3000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {
                window.location.href = redirect_url;
            }
        },
        dataType: "json"
    });
});

$(".btnDavaliSil").click(function () {
    let data_id = $(this).data("id");
    let url = "davaliSil";
    Swal.fire({
        title: 'Silmek İstediğinize Emin Misiniz?',
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonText: 'Sil',
        denyButtonText: `İptal`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            $.ajax({
                type: "POST",
                url: url,
                data: {
                    id : data_id
                },
                success: function (response) {
                    Swal.fire({
                        position: 'center',
                        icon: response.icon,
                        title: response.title,
                        showConfirmButton: false,
                        timer: 10000
                    });

                    if(response.exist) {
                        window.location.href = "davaliListele";
                    }
                },
                dataType: "json"
            });
        } else if (result.isDenied) {
            Swal.fire('Silme işlemi iptal edildi.', '', 'success')
        }
    })

});
$("#btnDavaGuncelle").click(function () {
    let url = $("#dataUrl").val();
    let redirect_url = $("#redirectUrl").val();
    let davaId = $("#davaId").val();
    let davaAd = $("#davaAd").val();
    let davaTipi = $("#davaTipi").val();
    let davaNumarasi = $("#davaNumarasi").val();
    let davaliId = $("#davaliId").val();
    let mustekiId = $("#mustekiId").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            davaId : davaId,
            davaAd : davaAd,
            davaTipi : davaTipi,
            davaNumarasi : davaNumarasi,
            davaliId : davaliId,
            mustekiId:mustekiId
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 3000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {
                window.location.href = redirect_url;
            }
        },
        dataType: "json"
    });
});

$("#btnDavaKaydet").click(function () {
    let url = "davaKaydet";
    let davaAd = $("#davaAd").val();
    let davaTipi = $("#davaTipi").val();
    let davaNumarasi = $("#davaNumarasi").val();
    let davaliId = $("#davaliId").val();
    let mustekiId = $("#mustekiId").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            davaAd : davaAd,
            davaTipi : davaTipi,
            davaNumarasi:davaNumarasi,
            davaliId:davaliId,
            mustekiId:mustekiId
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 10000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {

                window.location.href = "davaListele";

            }
        },
        dataType: "json"
    });


});
$(".btnDavaSil").click(function () {
    let data_id = $(this).data("id");
    let url = "davaSil";
    Swal.fire({
        title: 'Silmek İstediğinize Emin Misiniz?',
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonText: 'Sil',
        denyButtonText: `İptal`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            $.ajax({
                type: "POST",
                url: url,
                data: {
                    id : data_id
                },
                success: function (response) {
                    Swal.fire({
                        position: 'center',
                        icon: response.icon,
                        title: response.title,
                        showConfirmButton: false,
                        timer: 10000
                    });

                    if(response.exist) {
                        window.location.href = "davaListele";
                    }
                },
                dataType: "json"
            });
        } else if (result.isDenied) {
            Swal.fire('Silme işlemi iptal edildi.', '', 'success')
        }
    })


});

$("#btnAjandaEkle").click(function () {
    let url = "ajandaKaydet";
    let ajandaIsim = $("#ajandaIsim").val();
    let baslangicTarihi = $("#baslangicTarihi").val();
    let bitisTarihi = $("#bitisTarihi").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            ajandaIsim : ajandaIsim,
            baslangicTarihi:baslangicTarihi,
            bitisTarihi : bitisTarihi
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 10000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {

                window.location.href = "ajandaListele";

            }
        },
        dataType: "json"
    });

});
$("#btnAjandaGuncelle").click(function () {
    let url = $("#dataUrl").val();
    let redirect_url = $("#redirectUrl").val();
    let ajandaId = $("#ajandaId").val();
    let ajandaIsim = $("#ajandaIsim").val();
    let baslangicTarihi = $("#baslangicTarihi").val();
    let bitisTarihi = $("#bitisTarihi").val();
    $.ajax({
        type: "POST",
        url: url,
        data: {
            ajandaId : ajandaId,
            ajandaIsim : ajandaIsim,
            baslangicTarihi : baslangicTarihi,
            bitisTarihi : bitisTarihi
        },
        success: function (response) {
            Swal.fire({
                position: 'center',
                icon: response.icon,
                title: response.title,
                showConfirmButton: false,
                timer: 3000
            });
            setTimeout(function () {

            },3000);
            if(response.exist) {
                window.location.href = redirect_url;
            }
        },
        dataType: "json"
    });
});


$(".btnAjandaSil").click(function () {
    let data_id = $(this).data("id");
    let url = "ajandaSil";
    Swal.fire({
        title: 'Silmek İstediğinize Emin Misiniz?',
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonText: 'Sil',
        denyButtonText: `İptal`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            $.ajax({
                type: "POST",
                url: url,
                data: {
                    id : data_id
                },
                success: function (response) {
                    Swal.fire({
                        position: 'center',
                        icon: response.icon,
                        title: response.title,
                        showConfirmButton: false,
                        timer: 10000
                    });

                    if(response.exist) {
                        window.location.href = "ajandaListele";
                    }
                },
                dataType: "json"
            });
        } else if (result.isDenied) {
            Swal.fire('Silme işlemi iptal edildi.', '', 'success')
        }
    })


});










