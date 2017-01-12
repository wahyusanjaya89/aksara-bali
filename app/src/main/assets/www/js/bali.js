function TransliterasiAksaraBali(e) {
    function n(e) {
        function n(e) {
            for (var n = 0; n < v.length; n++) {
                var i = e.match(v[n].v);
                if (i)return {fr: i[0], to: v[n].f(i[0])}
            }
            return !1
        }

        var r = e.length, f = "", t = e;
        for (i = 0; i < r; i++) {
            var a = n(t.substr(i));
            a ? (f += a.to, i = i + a.fr.length - 1) : f += t.charAt(i)
        }
        return f
    }

    function r(n) {
        var i = "aāiīéuúeoô", r = "hncrkdtswlmgbpjyṇṭśṣṛńňƌŧģƃƥǩ", t = "hń", a = "rṛ", c = ["ng", "dh", "th", "gh", "bh", "ph", "kh"], g = ["ń", "ƌ", "ŧ", "ģ", "ƃ", "ƥ", "ǩ"];
        if (e.preReplace)for (var u in e.preReplace)c.indexOf(u) < 0 && (c.push(u), g.push(e.preReplace[u]));
        n = n.toLowerCase(), o.length && !e.dictDisable && AM.map(o, function (i, r) {
            var t = e.dictPartial ? new RegExp(f(i), "g") : new RegExp("\\b" + f(i) + "\\b", "g");
            n = n.replace(t, d[r])
        }), n = x(n, c, g);
        var p = new RegExp("([" + i + "])([" + i + "])", "g");
        n = n.replace(p, "$1h$2"), p = new RegExp("([^" + t + a + "])[^\\S\\n]*", "g"), n = n.replace(p, "$1"), p = new RegExp("([ṃṁ])[^\\S\\n]*", "g"), n = n.replace(p, "$1 ");
        for (var O = 0; O < r.length; O++)for (var u = 0; u < t.length; u++)p = new RegExp("(" + r[O] + ")([" + i + "])(" + t[u] + ")(" + r[O] + ")([" + i + "])(" + t[u] + ")([^" + i + "]|$)", "g"), n = n.replace(p, "$1$2$3 $4$5$6 $7");
        return n
    }

    function f(e) {
        return e.replace(/([$-\/:-?{-~!"^_`\[\]])/g, "\\$1")
    }

    function t(e) {
        var n = u.slice(1, 7).join("") + "¡¢±²", i = "ÿÜÝ", r = u.slice(82, 86).join(""), t = u.slice(11, 40).join("");
        for (var a in tedung)e = e.replace(new RegExp(f(a + "o"), "g"), tedung[a]);
        for (var a in l)e = e.replace(new RegExp(f(a), "g"), l[a]);
        return e = e.replace(new RegExp("([" + O[0] + "]+)", "g"), ",$1,"), AM.map(O[0], function (n, i) {
            e = e.replace(new RegExp(n, "g"), O[1][i])
        }), e = e.replace(new RegExp("([" + f(n + i) + "])([^" + f(r) + "])", "g"), "$1 $2"), e = e.replace(new RegExp("([" + f(t) + "])([" + f(t) + "])", "g"), "$1 $2")
    }

    function a(e) {
        return e = n(r(e), o, d), t(e)
    }

    function x(e, n, i) {
        var r = 0, f = 0, t = 0, a = 0, x = "", o = !1;
        for (t = e.length, a = n.length, r = 0; t > r; r++) {
            for (o = !1, f = 0; a > f; f++)if (e.substr(r, n[f].length) == n[f]) {
                o = !0, r = r + n[f].length - 1;
                break
            }
            x += o ? i[f] : e.charAt(r)
        }
        return x
    }

    var o = [], d = [];
    if (e = e || {}, e.dictionary && !e.dictDisable) {
        var c = AM.keys(e.dictionary);
        o = c.sort(function (e, n) {
            return n.length > e.length ? 1 : 0
        }), AM.map(o, function (n) {
            d.push(e.dictionary[n])
        })
    }
    var g = ["a", "ā", "i", "ī", "é", "u", "ú", "e", "ê", "o", "ô", "h", "n", "c", "r", "k", "d", "t", "s", "w", "l", "m", "g", "b", "ń", "p", "j", "y", "ň", "ṇ", "ƌ", "ŧ", "ṭ", "ś", "ṣ", "ģ", "ƃ", "ƥ", "ǩ", "ṛ", "lé", ",", ".", ":", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "ṁ", "ṃ"],
        u = ["", "o", "i", "I", ")", "u", "U", "e", "E", "e|o", "E|o", "h", "n", "c", "r", "k", "d", "t", "s", "w", "l", "m", "g", "b", "\\", "p", "j", "y", "z", "x", "a", "q", "`", "]", "[", "f", "v", "|", "¼", "Ï", "ò", "À", "Â", "Ç", "É", "Ð", "Ñ", "Ó", "uæ", "Ù", "Þ", "ß", "á", "ã", "å", "æ", "é", "ê", "ñ", "Å", "Ò", "Ô", "Õ", "Ö", "×", "¥", "ä", "è", "Ð", "Ê", "åÃ", "Á", "õ", "÷", "÷o", "Á)", "ú", "úo", "6", "ü", "O", "Oo", "*", "(", ";", "/", ",", ".", ":", "<", ">", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Ä", "Æ", "Ë", "Ì", "Û", "í", "î", "ï", "¡", "¢", "Ä", "Í", "Û", "¸", "³", "#", "$", "%", "&", "^", "ë", "ì", "ð"],
        p = {
        n: ["Â", "Ä"],
        m: ["ß", "ß"],
        "ṇ": ["Å", "Æ"],
        r: ["É", "Ë"],
        "ṛ": ["Ê", "Ì"],
        w: ["Ù", "Û"],
        y: ["ê", "í"],
        s: ["uæ", "¡æ"],
        "ṣ": ["×", "×"]
    }, O = ["ɐɑɒɓɔɕɖɗɘə", "1234567890"], l = {
        "i*": "&",
        "i(": "^",
        "I*": "#",
        ")(": "$",
        ")*": "%",
        "ß¡": "à¡",
        "ß¢": "à¢",
        "ßí": "àí",
        "ßË": "àË",
        "ßÛ": "àÛ",
        "ßÄ": "àÄ",
        "Éí¡": "ð±",
        "Éí¢": "ð²",
        "Éí": "ð",
        "ê¡": "ë",
        "ê¢": "ì",
        "í¡": "î",
        "í¢": "ï",
        "Ù¡": "Ù±",
        "Ù¢": "Ù²",
        "Û¡": "Û±",
        "Û¢": "Û²",
        "ÙË": "ÚË",
        "Ùí": "Úí",
        "É¡": "É±",
        "É¢": "É²",
        "Ë¡": "Ë±",
        "Ë¢": "Ë²",
        "Ê¡": "Ê±",
        "Ê¢": "Ê²",
        "Â¡": "Â±",
        "Â¢": "Â²",
        "Ä¡": "Ä±",
        "Ä¢": "Ä²",
        "ÂÛ": "ÃÛ",
        "l)": "ò",
        "r)": "Ï",
        "É)": "Ê",
        "æÛ": "æÙ",
        "æÄ": "æÂ",
        "æË": "æÉ",
        "Oo¸": "þ",
        "O¸": "ý",
        "ú¸": "û",
        "Á¸": "ö",
        "I(": "!",
        "ÉÄ": "ÎÄ",
        "ÉÛ": "ÎÛ",
        "o(": "(o",
        "o*": "*o",
        "o¸": "¸o",
        "o³": "³o"
    };
    tedung = {
        h: "Hÿ",
        n: "Nÿ",
        c: "Cÿ",
        r: "Rÿ",
        k: "Kÿ",
        d: "Dÿ",
        t: "Tÿ",
        s: "Sÿ",
        w: "Wÿ",
        l: "Lÿ",
        m: "Mÿ",
        g: "Gÿ",
        p: "Pÿ",
        y: "Yÿ",
        a: "Aÿ",
        q: "Qÿ",
        "`": "~ÿ",
        "]": "}ÿ",
        "[": "{ÿ",
        f: "Fÿ",
        v: "Vÿ",
        "ò": "ò²",
        "æ": "çÿ",
        "×": "Øÿ",
        "ê": "Ü",
        "í": "Ý"
    }, window.latin = g;
    var v = function () {
        var e = f(g.slice(11, 39).join("") + "ṁṃṛ"), n = (f("spṣ"), f(AM.keys(p).join(""))), i = f(g.slice(0, 11).join("")), r = f(O[0]), t = new RegExp("^[" + e + "][" + e + "][" + n + "][" + i + "]"), a = new RegExp("^[" + e + "][" + e + "][" + e + "][" + i + "]"), x = new RegExp("^[" + e + "][" + e + "][" + i + "]"), o = new RegExp("^[" + e + "][" + i + "]"), d = new RegExp("^[" + e + "]"), c = new RegExp("^[" + i + "]"), l = new RegExp("^[" + r + "]");
        return [{
            v: t, f: function (e) {
                var n = u[g.indexOf(e[0])] + u[g.indexOf(e[1]) + 41 - 11] + (AM.isIn(e[1], ["s", "p", "ṣ"]) ? p[e[2]][0] : p[e[2]][1]);
                return g.indexOf(e[3]) <= 4 ? n += u[g.indexOf(e[3])] : g.indexOf(e[3]) <= 6 ? n += u[g.indexOf(e[3]) + 109 - 5] : n = g.indexOf(e[3]) <= 8 ? u[g.indexOf(e[3])] + n : u[g.indexOf(e[3]) - 2] + n + u[1], n
            }
        }, {
            v: a, f: function (e) {
                var n = u[g.indexOf(e[0])] + u[g.indexOf(e[1]) + 41 - 11] + u[g.indexOf(e[2]) + 41 - 11];
                return g.indexOf(e[3]) <= 4 ? n += u[g.indexOf(e[3])] : g.indexOf(e[3]) <= 6 ? n += u[g.indexOf(e[3]) + 109 - 5] : n = g.indexOf(e[3]) <= 8 ? u[g.indexOf(e[3])] + n : u[g.indexOf(e[3]) - 2] + n + u[1], n
            }
        }, {
            v: x, f: function (e) {
                var n = u[g.indexOf(e[0])] + u[g.indexOf(e[1]) + 41 - 11];
                return g.indexOf(e[2]) <= 4 ? n += u[g.indexOf(e[2])] : g.indexOf(e[2]) <= 6 ? n += AM.isIn(g.indexOf(e[1]), [18, 25]) ? u[g.indexOf(e[2])] : u[g.indexOf(e[2]) + 109 - 5] : n = g.indexOf(e[2]) <= 8 ? u[g.indexOf(e[2])] + n : u[g.indexOf(e[2]) - 2] + n + u[1], n
            }
        }, {
            v: o, f: function (e) {
                var n = u[g.indexOf(e[0])];
                return g.indexOf(e[1]) <= 6 ? n += u[g.indexOf(e[1])] : n = g.indexOf(e[1]) <= 8 ? u[g.indexOf(e[1])] + n : u[g.indexOf(e[1]) - 2] + n + u[1], n
            }
        }, {
            v: d, f: function (e) {
                var n = "";
                return n = 24 == g.indexOf(e[0]) ? u[82] : 14 == g.indexOf(e[0]) ? u[83] : 11 == g.indexOf(e[0]) ? u[84] : 54 == g.indexOf(e[0]) ? u[114] : 55 == g.indexOf(e[0]) ? u[115] : u[g.indexOf(e[0])] + u[85]
            }
        }, {
            v: c, f: function (e) {
                return u[g.indexOf(e[0]) + 71]
            }
        }, {
            v: l, f: function (e) {
                return O[1][O[0].indexOf(e[0])]
            }
        }]
    }();
    return a
}
var AM = __am();