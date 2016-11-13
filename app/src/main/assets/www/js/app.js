    var translate = translate = TransliterasiAksaraBali({
        dictionary: {},
        dictDisable: !1,
        dictPartial: !1,
        preReplace: {
            ny: "ň",
            v: "w",
            iu: "iyu",
            ia: "iya",
            ua: "uwa",
            oe: "owe",
            ea: "eya",
            x: "ks",
            z: "s",
            f: "p",
            q: "k"
        }
    });

function getAksaraBali(stringFromAndroid){
   var translated = translate(stringFromAndroid) ;
   window.AndroidApp.getAksara(translated);
}